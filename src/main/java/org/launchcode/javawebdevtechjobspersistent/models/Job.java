package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private int id;

    private String name;

//@ManyToOne
    private String Employer;
//    private String skills;

    @ManyToMany
    private final List<Skill> skills= new ArrayList<>();

    public Job() {
    }

    public Job(String employer) {
        Employer = employer;
    }
//    public Job(String Employer, List<Skill> skills) {
//        super();
//        this.Employer = Employer;
////        this.Skills = someSkills;
//    }

    // Getters and setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployer() {
        return Employer;
    }

    public void setEmployer(String employer) {
        this.Employer = employer;
    }

//    public String getSkills() {
//        return skills;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }

//    @Override
//    public int getId() {
//        return id;
//    }

    public List<Skill> getSkills() {
        return skills;
    }
}
