package com.lsy.ex08.freeboard;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("freeboard")
@RequiredArgsConstructor
@CrossOrigin
public class FreeBoardController {

    private final FreeBoardRepository freeBoardRepository;

    @PostMapping("insert")
    private ResponseEntity<FreeBoard> save(@Valid @RequestBody FreeBoardReqDto freeBoardReqDto) {
        FreeBoard freeBoard = new ModelMapper().map(freeBoardReqDto, FreeBoard.class);
        freeBoardRepository.save(freeBoard);
        return ResponseEntity.status(200).body(freeBoard);
    }

    @GetMapping("select")
    public ResponseEntity<FreeBoardResponsePageDto> findAll(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
                                                            @RequestParam(name = "size", defaultValue = "10") int size) {

        Sort sort = Sort.by(Sort.Direction.DESC, "regDate");

        Pageable pageable = PageRequest.of(pageNum, size, sort);

        Page<FreeBoard> page = freeBoardRepository.findAll(pageable);

        System.out.println("Elements = " + page.getTotalElements());
        System.out.println("Pages = " + page.getTotalPages());

        FreeBoardResponsePageDto freeBoardResponsePageDto
                = new ModelMapper().map(page, FreeBoardResponsePageDto.class);

        List<FreeBoardResponseDto> list = new ArrayList<>();

        for (FreeBoard freeBoard : freeBoardResponsePageDto.getContent()) {

            FreeBoardResponseDto freeBoardResponseDto
                    = new ModelMapper().map(freeBoard, FreeBoardResponseDto.class);

            DateTimeFormatter dateTimeFormatter
                    = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh:mm");

            freeBoardResponseDto.setRegDate(dateTimeFormatter.format(freeBoard.getRegDate()));
            freeBoardResponseDto.setModDate(dateTimeFormatter.format(freeBoard.getModDate()));

            list.add(freeBoardResponseDto);
        }

        freeBoardResponsePageDto.setList(list);

        return ResponseEntity.ok(freeBoardResponsePageDto);
    }


}