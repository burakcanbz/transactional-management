package com.example.auth.repository;

import com.example.auth.entity.Auth;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository  extends CrudRepository<Auth, Long> {
}
