package com.alviszalamans.survey.data.entity;
import org.hibernate.annotations.Type;
import javax.persistence.*;


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

    public int[] getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

}
