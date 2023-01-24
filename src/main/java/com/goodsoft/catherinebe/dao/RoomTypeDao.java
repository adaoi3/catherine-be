package com.goodsoft.catherinebe.dao;

import com.goodsoft.catherinebe.entity.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoomTypeDao {

    RoomType readByName(String roomTypeName);

}
