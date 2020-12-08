package org.homeapart.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.homeapart.domain.enums.AdditionallyList;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
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


    @ManyToOne
    @JoinColumn(name = "apart_id")
    @JsonBackReference
    private Apart apart;


}
