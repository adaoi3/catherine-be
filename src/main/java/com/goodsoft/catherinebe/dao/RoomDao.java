package com.goodsoft.catherinebe.dao;

import com.goodsoft.catherinebe.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoomDao {

    Room readById(Integer roomId);

}
