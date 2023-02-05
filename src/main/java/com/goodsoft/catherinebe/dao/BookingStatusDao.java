package com.goodsoft.catherinebe.dao;

import com.goodsoft.catherinebe.entity.BookingStatus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BookingStatusDao {

    String readNameById(Integer id);
    BookingStatus readByName(String statusName);

}
