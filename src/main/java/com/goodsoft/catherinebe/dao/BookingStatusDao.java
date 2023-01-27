package com.goodsoft.catherinebe.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BookingStatusDao {

    String readNameById(Integer id);

}
