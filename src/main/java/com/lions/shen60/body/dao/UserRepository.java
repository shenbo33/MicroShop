package com.lions.shen60.body.dao;

import com.lions.shen60.body.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SysUser,Integer> {
    /**
     * 原来JPARepository的方法依然可以使用
     **/
    @Query("select t from SysUser t where t.username = ?1")
    SysUser findUserByName(@Param("username")String username);
}
