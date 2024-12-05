package com.lsy.org.freeboard;

import org.springframework.data.jpa.repository.JpaRepository;

// select, insert, update, delete
public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {

//    @Modifying
//    @Transactional
//    @Query(value = "delete from FreeBoard fb where fb.idx = :idx")
//    void cusDeleteByIdx(@Param("idx") Long Idx);
}