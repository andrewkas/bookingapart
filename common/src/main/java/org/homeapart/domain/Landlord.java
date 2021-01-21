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

    @NotBlank
    @Size(min = 2,max = 40,message = "surname not valid")
    @Column
    private String name;

    @NotNull
    @Size(min=4, max=20, message = "the number of symbols must be more than 4 and less than 20")
    @Column
    private String surname;

    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{2}\\))|\\d{2})[- .]?\\d{3}[- .]?\\d{2}[-.]?\\d{4}$")
    @Column
    private String phone;

    @Email
    @Column(name="e_mail")
    private String email;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @NotBlank
    @Size(min = 6,max = 40,message = "login not valid")
    @Column
    private String login;

    @NotBlank
    @Size(min = 6,max = 100,message = "password not valid")
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
