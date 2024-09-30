package com.lsy.ex10.user;

import com.lsy.ex10.error.ErrorCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("select")
    public ResponseEntity<List<User>> select() {

        List<User> list = userRepository.findAll();

        return ResponseEntity.status(200).body(list);
    }

    @PostMapping("insert")
    public ResponseEntity<String> insert(@Valid @RequestBody UserReqDto userReqDto) {

        userService.insert(userReqDto);

        return ResponseEntity.status(200).body("success insert");
    }

    @PutMapping("update")
    public ResponseEntity<String> update(@Valid @RequestBody UserReqDto userReqDto) {

        userService.update(userReqDto);

        return ResponseEntity.status(200).body("success update");
    }

    @DeleteMapping("delete/{idx}")
    public ResponseEntity<String> delete(@PathVariable long idx) {
        userRepository.deleteById(idx);
        return ResponseEntity.status(200).body("success delete");
    }
}