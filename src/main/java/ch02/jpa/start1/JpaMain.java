package ch02.jpa.start1;

import javax.persistence.*;
import java.util.List;

/**
 * @author holyeye
 */
public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        // p83. JPA를 시작하려면 우선 persistence.xml의 설정 정보를 사용해서 엔티티 매니저 팩토리 생성
        // 생성 비용이 크기 때문에 => 프로젝트 전반에 한번만 생성하고 공유해서 사용한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        // p83. 엔티티 매니저는 등록/수정/삭제/조회를 할수 있다.
        // 엔티티 매니저는 내부에 데이터소스(데이터베이스 커넥션)를 유지 하면서 데이터베이스와 통신
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void logic(EntityManager em) {

        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("지한");
        member.setAge(2);

        //등록
        // p85. 저장을 하는 메서드, 매개 변수에 저장할 엔티티를 넘겨준다.
        em.persist(member);

        //수정
        // p85. 수정자 메소드(set)메소드 호출
        member.setAge(20);

        //한 건 조회
        // p86. @Id로 데이터베이스 테이블의 기본키와 매핑한 식별자 값으로 엔티티 하나를 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());

        //목록 조회
        // p87. JPQL
        // 하나 이상의 회원 목록을 조회하는 다음 코드를 자세히 살펴보자.
        // JPQL을 사용하기 위해서는 em.createQuery(JPQL, 반환_타입.class) 메소드를 실행하서
        // query.getResultList()을 실행한다.
        TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
        List<Member> members = query.getResultList();
        System.out.println("members.size=" + members.size());

        //삭제
        em.remove(member);

    }
}
