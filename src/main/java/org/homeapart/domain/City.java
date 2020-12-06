package org.homeapart.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference
    private Country country;


    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private Set<Apart> apart= Collections.emptySet();


}
