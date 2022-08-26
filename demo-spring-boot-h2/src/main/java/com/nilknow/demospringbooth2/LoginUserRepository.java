package com.nilknow.demospringbooth2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginUserRepository extends CrudRepository<LoginUserEntity,Long> {
    Optional<LoginUserEntity> findByNickname(String nickname);
}
