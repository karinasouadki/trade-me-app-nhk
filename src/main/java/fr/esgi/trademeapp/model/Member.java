package fr.esgi.trademeapp.model;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Table(name="MEMBER")
public class Member implements Serializable {

    @Column(name = "ID")
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "SKILL")
    @OneToMany
    private List<String> skills;

    @Column(name = "CITY")
    @ManyToMany
    private List<String> cities;

    @Column(name = "PROJECT")
    private List<Project> projects;


}
