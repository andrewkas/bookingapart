package org.homeapart.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.homeapart.domain.enums.SystemRole;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="m_role")
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="role_name")
    @Enumerated(EnumType.STRING)
    private SystemRole role;


    @OneToOne(mappedBy = "userRole")
    private User user;


    @OneToOne(mappedBy = "landlordRole")
    private Landlord landlord;


    public Role(Long id, SystemRole role) {
        this.id = id;
        this.role = role;
    }

    public Role(SystemRole role, User user) {
        this.role = role;
        this.user = user;
    }

    public Role(SystemRole role, Landlord landlord) {
        this.role = role;
        this.landlord = landlord;
    }

    @Override
    public String toString() {
        return   ""+role+"";
    }
}
