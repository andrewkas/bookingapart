package org.homeapart.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String phone;

    @Column(name="e_mail")
    private String email;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @Column
    private String login;

    @Column
    private String password;

    @OneToMany(mappedBy = "landlord", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)

    @JsonManagedReference

    private Set<Apart> apart = Collections.emptySet();



}
