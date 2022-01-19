package fr.esgi.trademeapp.service;

import fr.esgi.trademeapp.model.Member;
import fr.esgi.trademeapp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member getUser(Long id) {
        return memberRepository.findById(id);
    }

}
