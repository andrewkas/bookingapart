package org.homeapart.domain;

public class Additionally {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Additionally additionally;


    @ManyToOne
    @JoinColumn(name = "apart")
    @JsonBackReference
    private Apart apart;


}
