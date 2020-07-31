package com.alviszalamans.survey.data.entity;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="RESULTS")
@TypeDefs({
        @TypeDef(name = "list-array", typeClass = IntArrayType.class)
})
public class Application {
    @Id
    @Column(name = "RESULT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long resultId;

    @NotBlank(message = "Name is required")
    @Size(min = 5, message = "Your name must be at least 5 characters long")
    @Column(name="NAME")
    private String fullName;



    @Type(type = "list-array")
    @Column(
            name = "SECTORS",
            columnDefinition = "integer[]"
    )
    @Size(min = 1, max = 5, message = "Please pick 1 to 5 sectors")
    private int[] sectors;

    @AssertTrue(message = "Please agree to terms")
    @Column(name="AGREE_TERMS")
    private boolean terms;

    public boolean isTerms() {
        return terms;
    }

    public void setTerms(boolean terms) {
        this.terms = terms;
    }

    public long getResultId() {
        return resultId;
    }

    public void setResultId(long resultId) {
        this.resultId = resultId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int[] getSectors() {
        return sectors;
    }

    public void setSectors(int[] sectors) {
        this.sectors = sectors;
    }
}
