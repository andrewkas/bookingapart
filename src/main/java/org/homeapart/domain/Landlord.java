package org.homeapart.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode (exclude = {"apart"})
@Table(name = "m_landlord")
public class Landlord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String surname;


    private String phone;


    private String eMail;


    private Timestamp created;


    private Timestamp changed;


    private String login;


    private String password;

    @OneToMany(mappedBy = "landlord", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private Set<Apart> apart = Collections.emptySet();



}
