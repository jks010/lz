package com.lazaros.lazarosapi.repository;

import com.lazaros.lazarosapi.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> findAllByOrderByIdAsc();

}
