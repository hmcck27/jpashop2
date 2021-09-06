package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Member2 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Embedded
    private Period workPeriod;

    @Embedded
    private Address homeAddress;

}
