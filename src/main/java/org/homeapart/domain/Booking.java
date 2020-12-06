package org.homeapart.domain;


import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "m_booking")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private apartId;


    private userId;


    private int numberOfPersons;


    private Date checkIn;


    private Date checkOut;


    private Double price;


    private Timestamp created;



    private Timestamp changed;

}
