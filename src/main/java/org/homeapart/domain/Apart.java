package org.homeapart.domain;

import org.homeapart.domain.enums.Additionally;
import org.homeapart.domain.enums.ApartamentStatus;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Set;

public class Apart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String type;


    private String apartName;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference
    private City city;


    private String address;


    private BigInteger guestNumber;


    private Double area;


    private Double costPerDay;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    @JsonBackReference
    private Landlord landlord;


    private ApartamentStatus status =ApartamentStatus.BOOKED;


    private Timestamp created;



    private Timestamp changed;


    @OneToMany(mappedBy = "apart", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private Set<Additionally> additionally = Collections.emptySet();

}
