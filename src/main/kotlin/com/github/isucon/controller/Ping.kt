package com.github.isucon.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
class PingController {

    @GetMapping("/ping")
    fun ping(res: HttpServletResponse): ResponseEntity<String> {
       return ResponseEntity("ok", HttpStatus.OK)
    }
}