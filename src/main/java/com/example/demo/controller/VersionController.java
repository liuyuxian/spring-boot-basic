package com.example.demo.controller;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/version")
public class VersionController {

    private int major = 2;
    private int minor = 0;
    private int patch = 0;

    @RequestMapping(method = RequestMethod.GET)
    public String getVersion() {
        return major + "." + minor + "." + patch;
    }

    @RequestMapping(path = "/major", method = RequestMethod.POST)
    public String updateMajor() {
        major++;
        return getVersion();
    }
}
