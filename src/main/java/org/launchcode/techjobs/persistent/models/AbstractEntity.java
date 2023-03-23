package org.launchcode.techjobs.persistent.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

/*TODO: PART 2:
* A:  We will be creating tables for the subclasses that inherit from AbstractEntity
* but not a table for this parent class.
* Therefore, give AbstractEntity the @MappedSuperclass annotation. Done
* B: add the @Id and @GeneratedValue annotations to the field id.
* C: subclass will also inherit the name field from AbstractEntity.
*         Add appropriate validation annotations so that:
*       1: a user cannot leave this field blank when creating an object
*       2: reasonable limitations on the size of the name string.
*           The name field will be shared across Job, Employer, and Skill
 * */

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(min=1, max=100, message = "The name must be between 1 and 100 characters")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}