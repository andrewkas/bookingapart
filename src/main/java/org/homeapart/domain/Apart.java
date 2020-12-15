package org.homeapart.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.homeapart.domain.enums.ApartamentStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Set;


@Data
@Entity
@EqualsAndHashCode(exclude = {"address","additionally"})
@Table(name = "m_apart")
@AllArgsConstructor
@NoArgsConstructor
public class Apart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @Column(name="apart_name")
    private String apartName;


    @OneToOne
    @JoinColumn(name = "address_id")
    @JsonBackReference
    private Address address;


    @Column(name="guest_number")
    private Integer guestNumber;

    @Column
    private Double area;

    @Column(name="cost_per_day")
    private Double costPerDay;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    @JsonBackReference
    private Landlord landlord;


    @Column
    @Enumerated(EnumType.STRING)
    private ApartamentStatus status =ApartamentStatus.BOOKED;

    @Column
    private Timestamp created;


    @Column
    private Timestamp changed;


    @OneToMany(mappedBy = "apart", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private Set<Additionally> additionally = Collections.emptySet();

}
