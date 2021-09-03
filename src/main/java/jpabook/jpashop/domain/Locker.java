package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locker_id")
    private Long id;

    @Column(name = "name")
    private String name;


}
