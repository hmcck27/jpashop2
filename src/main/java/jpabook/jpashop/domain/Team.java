package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = {"members"})
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany // mapped by : 나의 반대편 사이드의 변수이름
    @JoinColumn(name = "team_id")
    private List<Member> members = new ArrayList<>();



//    public void addMember(Member member) {
//        member.setTeam(this);
//        members.add(member);
//    }
}
