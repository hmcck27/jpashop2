package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Member3 {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "favorite_food", joinColumns =
        @JoinColumn(name = "member_id")
    )
    @Column(name = "food_name")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "address", joinColumns =
//        @JoinColumn(name = "member_id"))
//    private List< Address> addressHistory = new ArrayList<>();

    // 값 타입 컬렉션을 사용할거면 이렇게 그냥 일대다 관계로 풀어라.
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressEntity> addressHistory = new ArrayList<>();


}
