package com.lions.shen60.body.dao;

import com.lions.shen60.body.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 原来JPARepository的方法依然可以使用
     **/
    @Query("select t from User  t where t.name = :name")
    User findUserByName(@Param("name")String name);
}
