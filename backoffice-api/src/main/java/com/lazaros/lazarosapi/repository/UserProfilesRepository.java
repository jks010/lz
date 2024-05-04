package com.lazaros.lazarosapi.repository;

import com.lazaros.lazarosapi.entity.User;
import com.lazaros.lazarosapi.entity.UserProfiles;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserProfilesRepository extends CrudRepository<UserProfiles, Long> {

    @Query("select l from lz_profiles l where l.user.id = :userId")
    List<UserProfiles> findByUserId(@Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query("delete from lz_profiles l where l.user.id = :userId")
    void deleteByUserId(@Param("userId") Long userId);
}
