package ch02.jpa.start1;

import javax.persistence.*;  //**

/**
 * 애플리케이션에서 사용할 회원 클래스 생성
 */
@Entity
@Table(name="MEMBER")
public class Member {

    // 기본 키(PK)에 매핑한다.
    // id 필드를 테이블의 ID 기본키 컬럼에 매핑한다.
    // 식별자 필드
    @Id
    @Column(name = "ID")
    private String id;

    // 필드를 컴럼에 매핑한다.
    @Column(name = "NAME")
    private String username;

    // 매핑 정보가 없는 필드
    // 필드 명이 age이르로 age컬럼으로 매핑
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
