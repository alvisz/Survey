package com.alviszalamans.survey.data.service;

import com.alviszalamans.survey.data.entity.Sector;
import com.alviszalamans.survey.data.dto.SectorDto;
import com.alviszalamans.survey.data.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class SectorService {

    @Autowired
    SectorRepository sectorRepository;

    private final List<SectorDto> nestedSectors = new ArrayList<SectorDto>();

    public List<SectorDto> getNestedSectors(){
        if (this.nestedSectors.size() == 0){
            this.retrieveSectors();
        }
        return this.nestedSectors;
    }

    private void retrieveSectors(){
        List<Sector> sectors;
        try {
            sectors = sectorRepository.findAll();
        } catch (NullPointerException e){
            sectors = Collections.emptyList(); // If no sectors added to DB gives empty collection
        }
        for (Sector s: sectors){
            SectorDto smallSector = new SectorDto(s.getSectorId(),s.getName());
            if (s.getChildren() != null) smallSector.addToChildrenQueue(s.getChildren()); // if ahs nested sectors, adds them to sectorDto children list
            nestedSectors.add(smallSector);
        }
        convertSectors(); // Converts the list in multilevel list
    }


    private void convertSectors(){
        ArrayList<SectorDto> toRemove = new ArrayList<>();
        for (SectorDto s: nestedSectors){
            ArrayList<Integer> idToRemove = new ArrayList<>(); // Finds id's to remove after they have been added to children(object) list
            if (s.getChildrenQueue().size() != 0){
                for (int childId: s.getChildrenQueue()){
                    SectorDto findSector = findSector(childId);
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

    private SectorDto findSector(int id){
        for (SectorDto s: nestedSectors){
            if (s.getSectorId() == id){
                return s;
            }
        }
        return null;
    }

}
