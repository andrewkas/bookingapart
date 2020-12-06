package org.homeapart.domain;

import java.util.Collections;
import java.util.Set;

public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String country;


    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private Set<City> citySet= Collections.emptySet();






}
