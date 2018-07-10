package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "FIRST_NAME")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "LAST_NAME")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "BIRTHDAY")
    @Getter
    @Setter
    private Date birthday;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Getter
    @Setter
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "EMPL_PROJ",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROJECT_ID")
    )
    @Getter
    @Setter
    private Set<Project> projects;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee "
                + "id=" + id
                + ", firstName='" + firstName
                + ", lastName='" + lastName
                + ", birthday=" + birthday
                + ", address=" + address + " ";
    }
}
