package org.homeapart.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;


@Data
@Entity
@EqualsAndHashCode

@NoArgsConstructor
@Table(name = "m_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String country;


    @Column
    private String city;


    @Column
    private String location;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Apart apart;

    public Address(String country, String city, String location) {
        this.country = country;
        this.city = city;
        this.location = location;
    }
}
