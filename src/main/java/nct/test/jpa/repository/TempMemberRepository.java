package nct.test.jpa.repository;

import nct.test.jpa.entity.TempMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempMemberRepository extends JpaRepository<TempMember, Long> {

}
