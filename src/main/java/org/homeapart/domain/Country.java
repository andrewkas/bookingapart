package org.homeapart.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;


@Data
@Entity
@EqualsAndHashCode
@Table(name = "m_country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String country;


    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private Set<City> citySet= Collections.emptySet();






}
