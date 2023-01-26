package com.goodsoft.catherinebe.dao;

import com.goodsoft.catherinebe.entity.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoomTypeDao {

    String readNameById(Long id);
    RoomType readByName(String roomTypeName);

}
