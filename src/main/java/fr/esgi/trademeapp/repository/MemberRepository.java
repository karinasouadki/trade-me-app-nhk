package fr.esgi.trademeapp.repository;


import fr.esgi.trademeapp.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository {

    Member findById(Long id);

    List<Member> findAll();

    List<Member> findBySkill(String skill);

    List<Member> findByCity(String city);

    void save(Member member);

}
