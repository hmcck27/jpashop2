package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Address address;

    public AddressEntity(String city, String street, String zipcode) {
        Address address = new Address(city, street, zipcode);
        this.address = address;
    }

    public AddressEntity() {

    }
}
