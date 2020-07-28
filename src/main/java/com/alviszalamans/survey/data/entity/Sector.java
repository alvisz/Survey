package com.alviszalamans.survey.data.entity;

import javax.persistence.*;

@Entity
@Table(name="SECTORS")
public class Sector {
    @Id
    @Column(name = "SECTOR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectorId;
    @Column(name="PARENT")
    private Long parent;
    @Column(name="NAME")
    private String name;

    public long getSectorId() {
        return sectorId;
    }

    public void setSectorId(long sectorId) {
        this.sectorId = sectorId;
    }

    public long getParent() {
        if (parent == null){
            return 1;
        } else return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
