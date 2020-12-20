package org.homeapart.domain;

import org.homeapart.domain.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
//import javax.validation.constraints.Size;
//import javax.validation.constraints.NotNull;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode
        //(exclude = {
        //"roles", "goods"
//})
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
}
