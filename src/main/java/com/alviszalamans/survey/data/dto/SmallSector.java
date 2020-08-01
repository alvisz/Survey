package com.alviszalamans.survey.data.dto;


import java.util.ArrayList;
import java.util.List;

public class SmallSector {

    private final int id;
    private final String name;
    private final List<SmallSector> children = new ArrayList<>();
    private final List<Integer> childrenQueue = new ArrayList<>();

    public SmallSector(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addChild(SmallSector sector){
        this.children.add(sector);
    }

    public Integer getSectorId() {
        return id;
    }

    public String getName() { return name; }

    public List<SmallSector> getChildren() { return children; }

    public List<Integer> getChildrenQueue() {
        return childrenQueue;
    }

    public void addToChildrenQueue(int[] children) {
        for (int child: children) this.childrenQueue.add(child);
    }

    public void removeFromChildrenQueue(ArrayList<Integer> childrenQueue) {
        this.childrenQueue.removeAll(childrenQueue);
    }

}
