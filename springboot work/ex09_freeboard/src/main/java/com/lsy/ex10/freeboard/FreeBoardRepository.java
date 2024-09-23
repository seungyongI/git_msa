package com.lsy.ex10.freeboard;

import org.springframework.data.jpa.repository.JpaRepository;

// select, insert, update, delete
public interface FreeBoardRepository extends JpaRepository <FreeBoard, Long> {


}
