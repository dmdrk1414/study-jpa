package nct.test.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "temp_member")
public class TempMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "temp_member_id")
    private String tempMemberId;

    @Column(name = "first_name", length = 10, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "major", length = 20, nullable = false)
    private String major;

    @Column(name = "gpa", length = 10, nullable = false)
    private String gpa;

    @Column(name = "specialty_skill", length = 255, nullable = false)
    private String specialtySkill;

    @Column(name = "hobby", length = 255, nullable = false)
    private String hobby;

    @Column(name = "mbti", length = 10, nullable = false)
    private String mbti;

    @Column(name = "student_id", length = 15, nullable = false)
    private String studentId;

    @Column(name = "birth_date", length = 20, nullable = false)
    private String birthDate;

    @Column(name = "advantages", length = 1000, nullable = false)
    private String advantages;

    @Column(name = "disadvantage", length = 1000, nullable = false)
    private String disadvantage;

    @Column(name = "introduction", length = 1000, nullable = false)
    private String introduction;

    @Column(name = "photo", length = 255, nullable = false)
    private String photo;

    @Column(name = "email", length = 40, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;
}
