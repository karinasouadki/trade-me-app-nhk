package fr.esgi.trademeapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Table(name="PROJECT")
public class Project {

    private List<Skill> skills;

    private City location;

    private Integer dailyRate;

    private Range engagementRange;

}




