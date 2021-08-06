package com.saggezza.CannonGame;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends MongoRepository<UserModel, String> {


    UserModel findByUserName (String username);


}
