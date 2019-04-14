package com.lions.shen60.header.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by konghao on 2016/12/7.
 */
@NoRepositoryBean
@Transactional(readOnly=true)
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {

    List<Object[]> listBySQL(String sql);

    @Transactional
    void updateBySql(String sql,Object...args);
    @Transactional
    void updateByHql(String hql,Object...args);
}
