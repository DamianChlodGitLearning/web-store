package com.mycompanyname.webstore.domain.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.mycompanyname.webstore.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findAll();

	User findByUserId(int userId);

}
