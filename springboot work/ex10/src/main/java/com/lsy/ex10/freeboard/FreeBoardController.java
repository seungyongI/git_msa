package com.lsy.ex10.freeboard;

import com.lsy.ex10.error.BizException;
import com.lsy.ex10.error.ErrorCode;
import com.lsy.ex10.file.FileEntity;
import com.lsy.ex10.file.FileRepository;
import com.lsy.ex10.user.User;
import com.lsy.ex10.user.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("freeboard")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class FreeBoardController {

    private final FreeBoardRepository freeBoardRepository;
    private final FileRepository fileRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Value("${my.value}")
    private String welcome;

    @GetMapping("test")
    public String test() {
        return welcome;

    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
//    @Transactional
    private ResponseEntity<FreeBoard> save(@Valid @RequestPart(name = "data") FreeBoardReqDto freeBoardReqDto,
                                           @RequestPart(name = "file", required = false) MultipartFile file) {

        FreeBoard freeBoard = new ModelMapper().map(freeBoardReqDto, FreeBoard.class);
//        freeBoardRepository.save(freeBoard);

        if (freeBoardReqDto.getIdx() == null) {
            freeBoardRepository.save(freeBoard);
        } else {
            FreeBoard dbFreeBoard = freeBoardRepository.findById(freeBoard.getIdx()).orElseThrow();
            dbFreeBoard = new ModelMapper().map(freeBoardReqDto, FreeBoard.class);
            freeBoardRepository.save(dbFreeBoard);
        }

//        System.out.println("userRepository = " + userRepository);

        User user = userRepository.findById(1l).orElse(new User());
//        User user = userRepository.findById(1l).orElse(null);
        freeBoard.setUser(user);


        if (file != null) {
            String myFilePath = Paths.get("images/file/").toAbsolutePath() + File.separator + file.getOriginalFilename();
            try {
                File destFile = new File(myFilePath);
                file.transferTo(destFile);
            } catch (Exception e) {
                e.printStackTrace();
            }

            FileEntity fileEntity = new FileEntity();
            fileEntity.setName(file.getOriginalFilename());
            fileEntity.setPath(Paths.get("images/file/").toAbsolutePath().toString());
            fileEntity.setFreeBoard(freeBoard);
            freeBoard.setList(Arrays.asList(fileEntity));
            fileRepository.save(fileEntity);

            freeBoard.setList(Arrays.asList());
            freeBoardRepository.save(freeBoard);
        } else {
//            System.out.println("일로오나");
            freeBoard.setList(null);
//            freeBoardRepository.save(freeBoard);

            List<FileEntity> list = fileRepository.findByFreeBoardIdx(freeBoard.getIdx());
            list.forEach(fileEntity -> {
                // delete * from free_board_file where idx = ?
                fileRepository.deleteById(fileEntity.getIdx());
                fileRepository.flush();
            });
            freeBoard.setList(Arrays.asList());
            freeBoardRepository.save(freeBoard);
        }
        return ResponseEntity.status(200).body(freeBoard);
    }

    @GetMapping("select")
    public ResponseEntity<FreeBoardResponsePageDto> findALl(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum
            , @RequestParam(name = "size", defaultValue = "5") int size) {

        Sort sort = Sort.by(Sort.Direction.DESC, "idx");
        Pageable pageable = PageRequest.of(pageNum, size, sort);

        Page<FreeBoard> page = freeBoardRepository.findAll(pageable);
        FreeBoardResponsePageDto freeBoardResponsePageDto = modelMapper.map(page, FreeBoardResponsePageDto.class);

        List<FreeBoardResponseDto> list = freeBoardResponsePageDto
                .getContent()
                .stream()
                .map(freeBoard -> {
                    FreeBoardResponseDto freeBoardResponseDto = modelMapper.map(freeBoard, FreeBoardResponseDto.class);

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm");
                    freeBoardResponseDto.setRegDate(dateTimeFormatter.format(freeBoard.getRegDate()));
                    freeBoardResponseDto.setModDate(dateTimeFormatter.format(freeBoard.getModDate()));

                    if (freeBoard.getUser() != null) {
                        freeBoardResponseDto.setCreAuthor(freeBoard.getUser().getName());
                        freeBoardResponseDto.setModAuthor(freeBoard.getUser().getName());
                        freeBoardResponseDto.setUserIdx(freeBoard.getUser().getIdx());
                    } else {
                        freeBoardResponseDto.setCreAuthor("탈퇴한 회원");
                        freeBoardResponseDto.setModAuthor("탈퇴한 회원");
                    }

                    return freeBoardResponseDto;
                }).toList();

        freeBoardResponsePageDto.setList(list);
        return ResponseEntity.ok(freeBoardResponsePageDto);
    }

    @GetMapping("view/{idx}")
    public ResponseEntity<FreeBoardResponseDto> findOne(@PathVariable(name = "idx") long idx) {
        // 해당되는 행 찾고...
        FreeBoard freeBoard = freeBoardRepository.findById(idx).orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));
        // 수정 하고...
        freeBoard.setViewCount(freeBoard.getViewCount() + 1);
        freeBoardRepository.save(freeBoard);

        FreeBoardResponseDto freeBoardResponseDto = modelMapper.map(freeBoard, FreeBoardResponseDto.class);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm");
        freeBoardResponseDto.setRegDate(dateTimeFormatter.format(freeBoard.getRegDate()));
        freeBoardResponseDto.setModDate(dateTimeFormatter.format(freeBoard.getModDate()));

        if (freeBoard.getUser() != null) {
            freeBoardResponseDto.setCreAuthor(freeBoard.getUser().getName());
            freeBoardResponseDto.setModAuthor(freeBoard.getUser().getName());
            freeBoardResponseDto.setUserIdx(freeBoard.getUser().getIdx());
        } else {
            freeBoardResponseDto.setCreAuthor("탈퇴한 회원");
            freeBoardResponseDto.setModAuthor("탈퇴한 회원");
        }

        return ResponseEntity.ok(freeBoardResponseDto);
    }

    @DeleteMapping("delete/{idx}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "idx") long idx) {

        FreeBoard freeBoard = freeBoardRepository.findById(idx)
                .orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));

//        freeBoard.setList(new ArrayList<>());
        freeBoard.setUser(null);
        freeBoardRepository.save(freeBoard);
        freeBoardRepository.delete(freeBoard);

//        fileRepository.findByFreeBoardIdx(
//                freeBoard.getIdx()).forEach(fileEntity -> {
//            fileRepository.deleteById(fileEntity.getIdx());
//        });
//        freeBoardRepository.cusDeleteByIdx(idx);

        return ResponseEntity.ok("삭제되었습니다.");
    }

}