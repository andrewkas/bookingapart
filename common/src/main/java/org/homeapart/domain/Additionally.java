package org.homeapart.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import org.homeapart.domain.enums.AdditionallyList;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Getter
@Setter
@Entity
@EqualsAndHashCode(exclude = {"apart"})
@Table(name = "m_additionally")
public class Additionally {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private AdditionallyList additionally;


    @ManyToMany
    @JoinTable(name = "l_apart_additionally",
            joinColumns = @JoinColumn(name = "additionally_id"),
            inverseJoinColumns = @JoinColumn(name = "apart_id")
    )
    @JsonIgnore
    private Set<Apart> apart= Collections.emptySet();


}
