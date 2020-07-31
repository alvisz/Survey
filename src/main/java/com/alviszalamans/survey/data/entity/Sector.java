package com.alviszalamans.survey.data.entity;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="SECTORS")
public class Sector {
    @Id
    @Column(name = "SECTOR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sectorId;

    @Type(type = "list-array")
    @Column(
            name = "CHILDREN",
            columnDefinition = "integer[]"
    )
    private int[] children;

    @Column(name="NAME")
    private String name;



    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public int[] getChildren() {
        return children;
    }

    public void setChildren(int[] children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
