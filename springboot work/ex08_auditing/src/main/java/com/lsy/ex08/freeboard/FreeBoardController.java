package com.lsy.ex08.freeboard;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("freeboard")
@RequiredArgsConstructor
@CrossOrigin
public class FreeBoardController {

    private final FreeBoardRepository freeBoardRepository;

    @GetMapping("select")
    public ResponseEntity<List<FreeBoard>> findAll() {
        List<FreeBoard> list = freeBoardRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("insert")
    private ResponseEntity<FreeBoard> save(@RequestBody FreeBoardReqDto freeBoardReqDto) {
        FreeBoard freeBoard = new ModelMapper().map(freeBoardReqDto, FreeBoard.class);

        freeBoardRepository.save(freeBoard);

        return ResponseEntity.status(200).body(freeBoard);
    }

}