package com.agiledeveloper.todo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/task")
class TaskController {
    @GetMapping
    fun tasks() = "to be implemented"
}