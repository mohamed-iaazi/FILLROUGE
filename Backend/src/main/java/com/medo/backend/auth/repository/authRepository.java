package com.medo.backend.auth.repository;

import com.medo.backend.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface authRepository  extends CrudRepository<User ,Long> {

}
