package org.launchcode.techjobs.persistent.models;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {


    /*TODO: Add string field for location,
        Add validation to location that ensures it is not empty and is reasonable length DONE
        add public accessor methods to Employer
        Must have the @Entity annotation as well as a no arg constructor required for hibernate to create an object (DONE)*/

    @NotBlank
    @Size(min=3, max=50, message="The location must be between 3 and 50 characters")
    public String location;

    public Employer(){}

    public Employer(String location) { // this is the constructor/
        this.location = location;
    }

    public String getLocation() { //public accessor methods
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    /*TODO: add a private jobs field of type List<Job>
            initialize it to an empty ArrayList
            use the @OneToMany and @JoinColumn annotations on the jobs list in Employer to declare the relationship between data tables
            these annotations need a name parameter*/

    @OneToMany
    @JoinColumn(name="employer_id")
    private List<Job> jobs = new ArrayList<Job>();


}
