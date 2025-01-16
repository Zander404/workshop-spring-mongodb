package com.xandy.workshopspringmongo.repository;

import com.xandy.workshopspringmongo.domains.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
