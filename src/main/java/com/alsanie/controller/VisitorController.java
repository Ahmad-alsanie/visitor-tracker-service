package com.alsanie.controller;

import com.alsanie.service.VisitorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitor")
public class VisitorController {
    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping("/increment")
    public String incrementVisitor() {
        visitorService.incrementVisitorCount();
        return "Visitor count incremented.";
    }

    @GetMapping("/count")
    public int getVisitorCount() {
        return visitorService.getVisitorCount();
    }
}