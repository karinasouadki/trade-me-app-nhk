package com.esgi.trademe.use_cases.profile.domain;

import com.esgi.trademe.use_cases.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {
}
