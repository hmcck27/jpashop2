package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class JpaMain {

    public static void main(String[] args) {

        // 이걸 만드는 순간 데이터베이스랑 연결이 됬다고 보면 된다.
        // application loading 시점에 딱 하나만 만들어야 한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 트랜잭션 단위에서 항상 늘 만들어야 함.
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 시작
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 여기에 데이터 베이스 접근 코드를 작성하면 된다.
        // 데이터 베이스 접근 코드는 항상 트랜잭션 내에서 작성해야 한다.

        try  {

            Member3 member3 = new Member3();
            member3.setUsername("member1");
            member3.setAddress(new Address("city1", "street", "10000"));

            member3.getFavoriteFoods().add("치킨");
            member3.getFavoriteFoods().add("족발");
            member3.getFavoriteFoods().add("피자");

            member3.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
            member3.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));

            // persist를 해도 전이가 되서 딸린 객체들도 같이 들어간다.
            em.persist(member3);


            em.flush();
            em.clear();

            System.out.println("======== start ============");
            Member3 findMember = em.find(Member3.class, member3.getId());


//            Address a = findMember.getAddress();
//            findMember.setAddress(new Address("new1", a.getStreet(), a.getZipcode()));
//
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

//            findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
//            findMember.getAddressHistory().add(new AddressEntity("newCity", "street", "10000"));

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            // entity manager를 닫아주는게 중요하다.
            // 이게 디비 트랜잭션을 물고 작동한다.
            em.close();
        }

        // 실제 application이 끝나면 이 팩토리를 닫아줘야 한다.
        emf.close();

    }


}
