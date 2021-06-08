package com.neo.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Chen Gong
 * @date：2021/6/8 2:42 下午
 */
@RequestMapping("/{version}/version")
@RestController
@ApiVersion(2)
public class V2Controller {
    @GetMapping
    public String test() {
        return "version2";
    }
}
