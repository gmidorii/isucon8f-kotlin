package com.github.isucon.web

import javafx.beans.NamedArg
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
class CustomController {

    @GetMapping("/ping")
    fun ping(): ResponseEntity<String> {
       return ResponseEntity("ok", HttpStatus.OK)
    }

    @PostMapping("/signUp")
    fun signUp(form: SignUpForm): ResponseEntity<String> {
        println(form)
        return ResponseEntity("ok", HttpStatus.OK)
    }
}

data class SignUpForm (
        var name: String = "",
        @NamedArg("bank_id")
        var bankId: String = "",
        var password: String = ""
)

