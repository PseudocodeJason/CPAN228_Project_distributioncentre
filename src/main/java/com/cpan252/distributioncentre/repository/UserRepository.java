package com.cpan252.distributioncentre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cpan252.distributioncentre.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
