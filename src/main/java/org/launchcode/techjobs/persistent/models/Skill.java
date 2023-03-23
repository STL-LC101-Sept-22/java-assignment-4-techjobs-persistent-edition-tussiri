package org.launchcode.techjobs.persistent.models;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    /*TODO: Add a field for a larger description of the skill named description
            must have a public accessor method
            must have the @Entity annotation and a no arg constructor
        */

    @ManyToMany(mappedBy = "skills")
    private List<Job> jobs = new ArrayList<>();
    private String description;


    public Skill(){};

    public Skill(List<Job> jobs, String description) {
        super();
        this.jobs = jobs;
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
/*TODO: add a jobs field
                what type should this field be? Initialize it in this field declaration accordingly
                add a getter and setter for the field
                this field has a many-to-many relationship with skills
                add @ManyToMany annotation with an argument mappedBy="skills"*/

    /*TODO: update Job.skills
                what needs to change and/or be added to map this relationship? It needed to change to Jobs.description
                */

}