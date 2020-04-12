package j2c.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClickStreamController {

    @GetMapping("/gce/hello")
    public String getHellow() {
        return "hellow from google cloud";
    }

}
