package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    /**
     * 설계상 실수를 방지하기 위해서 그냥 추상 클래스로 만드는게 좋다.
     */

    private String createdBy;
    private LocalDateTime createdDateTime;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

}
