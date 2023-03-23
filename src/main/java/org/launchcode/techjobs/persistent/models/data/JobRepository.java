package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/*TODO: Add data access interfaces for the relational objects
        Create a new interface called EmployerRepository that extends CrudRepository
        EmployerRepository should be annotated @Repository
        Create a new interface called SkillRepository that extends CrudRepository
        SkillRepository should be annotated @Repository*/
/*TODO: Add private field to the EmployerRepository
        type called "employerRepository
        give it an @Autowired annotation
        Add index method that responds to /employers with a lsit of all employers in the database
        this method should use the template employers/index*/

/*TODO: add appropriate code to save a valid objet to the "processAddEmployerForm" in the employerRepository*/

/*TODO: change the optEmployer in displayViewForm from null to make it use the .findById() method with the right argument to look for a given employer object*/
@Repository
@Transactional
public interface JobRepository extends CrudRepository<Job, Integer> {


}
