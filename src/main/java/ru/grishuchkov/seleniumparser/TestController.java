package ru.grishuchkov.seleniumparser;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.grishuchkov.seleniumparser.service.ParseServiceImpl;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final ParseServiceImpl parseService;

    @GetMapping("/")
    public ResponseEntity<String> test() {
        parseService.parse();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
