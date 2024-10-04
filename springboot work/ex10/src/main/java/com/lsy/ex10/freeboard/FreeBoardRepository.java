package com.lsy.ex10.freeboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

// select, insert, update, delete
public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {

//    @Modifying
//    @Transactional
//    @Query(value = "delete from FreeBoard fb where fb.idx = :idx")
//    void cusDeleteByIdx(@Param("idx") Long Idx);
}