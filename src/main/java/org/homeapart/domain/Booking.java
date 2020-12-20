package org.homeapart.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "m_booking")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "apart_id")
    @JsonBackReference
    private Apart apart;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    @Column
    private Double price;

    @Column
    private Timestamp created;


    @Column
    private Timestamp changed;



}
