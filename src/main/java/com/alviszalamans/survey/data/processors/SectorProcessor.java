package com.alviszalamans.survey.data.processors;

import com.alviszalamans.survey.data.entity.Sector;
import com.alviszalamans.survey.data.entity.SmallSector;
import com.alviszalamans.survey.data.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class SectorProcessor {

    @Autowired
    SectorRepository sectorRepository;

    private List<Sector> sectors;
    private List<SmallSector> nestedSectors = new ArrayList<SmallSector>();

    public List<SmallSector> getNestedSectors(){
        try {
            sectors = sectorRepository.findAll();
        } catch (NullPointerException e){
            return Collections.emptyList();
        }
        for (Sector s: sectors){
            SmallSector smallSector = new SmallSector(s.getSectorId(),s.getName());
            if (s.getChildren() != null) smallSector.addToChildrenQueue(s.getChildren());
            nestedSectors.add(smallSector);
        }
        process();
        return nestedSectors;
    }


    private void process(){
        ArrayList<SmallSector> toRemove = new ArrayList<>();
        for (SmallSector s: nestedSectors){
            ArrayList<Integer> idToRemove = new ArrayList<>();
            if (s.getChildrenQueue().size() != 0){
                for (int childId: s.getChildrenQueue()){
                    SmallSector findSector = findSector(childId);
                    if (findSector != null){
                        s.addChild(findSector);
                        toRemove.add(findSector);
                        idToRemove.add(childId);
                    }
                }
            }
            s.removeFromChildrenQueue(idToRemove);
        }
        nestedSectors.removeAll(toRemove);
    }

    private SmallSector findSector(int id){
        for (SmallSector s: nestedSectors){
            if (s.getSectorId() == id){
                return s;
            }
        }
        return null;
    }

}
