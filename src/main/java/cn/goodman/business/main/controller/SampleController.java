package cn.goodman.business.main.controller;

import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Shaun on 2017/1/18.
 */
@RestController
public class SampleController {
    @RequestMapping("/sample")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

}
