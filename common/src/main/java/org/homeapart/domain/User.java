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

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;


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

    @NotBlank
    @Size(min = 2,max = 40,message = "surname not valid")
   @Column
    private String name;

   @NotNull
   @Size(min=4, max=20, message = "the number of symbols must be more than 4 and less than 20")
    @Column
    private String surname;

    @Column(name="e_mail")
    @Email
    private String email;

    @Column(name="birth_date")
    private Date birthDate;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @NotBlank
    @Size(min = 2,max = 40,message = "login not valid")
    @Column
    private String login;

    @NotBlank
    @Size(min = 2,max = 200,message = "password not valid")
    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender= Gender.NOT_SELECTED;

 @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)

    @JoinColumn(name="role_id")
    private Role userRole;




}
