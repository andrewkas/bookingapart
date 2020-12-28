package org.homeapart.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.homeapart.domain.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.homeapart.domain.enums.SystemRole;
//import javax.validation.constraints.Size;
//import javax.validation.constraints.NotNull;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "m_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column
    private String name;

    @Column
    private String surname;

    @Column(name="e_mail")
    private String email;

    @Column(name="birth_date")
    private Date birthDate;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender= Gender.NOT_SELECTED;

 @JsonIgnore
    @OneToOne
    @JoinColumn(name="role_id")
    private Role userRole;




}
