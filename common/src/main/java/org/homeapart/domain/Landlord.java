package org.homeapart.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.homeapart.domain.enums.SystemRole;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@EqualsAndHashCode (exclude = {"apart"})
@Table(name = "m_landlord")
public class Landlord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name must not be empty")
    @Size(min = 2,max = 200,message = "the number of symbols of name must be more than 2 and less than 200")
    @Column
    private String name;

    @NotEmpty(message = "name must not be empty")
    @Size(min=2, max=200, message = "the number of symbols of surname must be more than 2 and less than 200")
    @Column
    private String surname;

    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{2}\\))|\\d{2})?\\d{7}$")
    @Column
    private String phone;

    @Email(message = "email should be a valid")
    @Column(name="e_mail")
    private String email;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @NotEmpty(message = "name must not be empty")
    @Size(min = 6,max = 200,message = "login not valid, must be more than 6 and less than 200")
    @Column (unique = true)
    private String login;

    @NotEmpty(message = "name must not be empty")
    @Size(min = 6,max = 200,message = "password not valid, must be more than 6 and less than 200")
    @Column
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "landlord",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Apart> apart = Collections.emptySet();

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id")
    private Role landlordRole;

}
