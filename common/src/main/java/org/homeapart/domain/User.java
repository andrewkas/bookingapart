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

import javax.validation.constraints.*;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


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

    @NotBlank(message = "name must not be blank")
    @Size(min = 2,max = 100,message = "the number of symbols of name must be more than 2 and less than 100")
   @Column
    private String name;

   @NotBlank(message = "surname must not be blank")
   @Size(min=4, max=100, message = "the number of symbols of surname must be more than 2 and less than 100")
    @Column
    private String surname;

    @Email(message = "email should be a valid")
    @Column(name="e_mail")
    private String email;


    @Column(name="birth_date")
    private Date birthDate;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @NotBlank(message = "login must not be blank")
    @Size(min = 6,max = 200,message = "login not valid, must be more than 6 and less than 200")
    @Column(unique = true)
    private String login;

    @NotBlank(message = "password must not be empty")
    @Size(min = 6,max = 200,message = "password not valid, must be more than 6 and less than 200")
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
