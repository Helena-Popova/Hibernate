package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "TITLE")
    @Getter
    @Setter
    private String title;

    @ManyToMany(mappedBy = "projects")
    @Getter
    @Setter
    private Set<Employee> employees;

    public Project() {

    }

    @Override
    public String toString() {
        return "Project "
                + "id=" + id
                + ", title='" + title + " ";
    }
}
