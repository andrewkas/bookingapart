package org.homeapart.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = {"apart"})
@Table(name = "m_city")
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column
    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference
    private Country country;


    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private Set<Apart> apart= Collections.emptySet();


}
