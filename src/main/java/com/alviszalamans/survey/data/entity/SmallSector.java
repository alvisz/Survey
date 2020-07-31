package com.alviszalamans.survey.data.entity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallSector {

    private final int id;
    private final String name;
    private List<SmallSector> children = new ArrayList<>();
    private List<Integer> childrenQueue = new ArrayList<>();

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

    public String getName() {
        return name;
    }

    public List<SmallSector> getChildren() {
        if (children != null){
            return children;
        } else return Collections.emptyList();
    }


    public List<Integer> getChildrenQueue() {
        return childrenQueue;
    }

    public void addToChildrenQueue(int[] children) {
        for (int child: children){
            this.childrenQueue.add(child);
        }
    }

    public void removeFromChildrenQueue(ArrayList<Integer> childrenQueue) {
        this.childrenQueue.removeAll(childrenQueue);
    }

    @Override
    public String toString() {
        return "SmallSector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", children=" + children.size() +
                ", childrenQueue=" + childrenQueue +
                '}';
    }


}
