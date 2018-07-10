package entity;

import lombok.Builder;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "COUNTRY")
    @Getter
    @Setter
    private String country;

    @Column(name = "CITY")
    @Getter
    @Setter
    private String city;

    @Column(name = "STREET")
    @Getter
    @Setter
    private String street;

    @Column(name = "POST_CODE", length = 10)
    @Getter
    @Setter
    private String postCode;


    public Address() {

    }

    @Override
    public String toString() {
        return "Address{"
                + "id=" + id
                + ", country='" + country
                + ", city='" + city
                + ", street='" + street
                + ", postCode='" + postCode + " ";
    }
}
