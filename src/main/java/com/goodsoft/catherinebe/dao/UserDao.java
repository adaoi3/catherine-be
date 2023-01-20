package com.goodsoft.catherinebe.dao;

import com.goodsoft.catherinebe.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    User readByLogin(@Param("login") String login);

}
