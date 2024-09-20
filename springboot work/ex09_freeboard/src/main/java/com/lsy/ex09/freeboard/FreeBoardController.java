package com.lsy.ex09.freeboard;

import com.lsy.ex09.Ex09Application;
import com.lsy.ex09.error.BizException;
import com.lsy.ex09.error.ErrorCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class FreeBoardController {

    private final FreeBoardRepository freeBoardRepository;
    private final ModelMapper modelMapper;

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

    @GetMapping("view/{idx}")
    public ResponseEntity<FreeBoardResponseDto> findOne(@PathVariable(name = "idx") long idx) {

        FreeBoard freeBoard = freeBoardRepository.findById(idx).orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));

        FreeBoardResponseDto freeBoardResponseDto = modelMapper.map(freeBoard, FreeBoardResponseDto.class);

        DateTimeFormatter dateTimeFormatter
                = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");

        freeBoardResponseDto.setRegDate(dateTimeFormatter.format(freeBoard.getRegDate()));
        freeBoardResponseDto.setModDate(dateTimeFormatter.format(freeBoard.getModDate()));

        return ResponseEntity.ok(freeBoardResponseDto);
    }

    @DeleteMapping("delete/{idx}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "idx") long idx) {
        freeBoardRepository.findById(idx).orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));
        freeBoardRepository.deleteById(idx);

        return ResponseEntity.ok("삭제되었습니다.");
    }

}
