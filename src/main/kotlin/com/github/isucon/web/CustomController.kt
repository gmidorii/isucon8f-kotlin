package com.github.isucon.web

import com.github.isucon.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomController @Autowired constructor(private val userService: UserService) {

    @GetMapping("/ping")
    fun ping(): ResponseEntity<String> {
       return ResponseEntity("ok", HttpStatus.OK)
    }

    @PostMapping("/signup")
    fun signUp(form: SignUpForm): ResponseEntity<String> {
        userService.signUp(form)
        return ResponseEntity("ok", HttpStatus.OK)
    }
}

class SignUpForm(
        var name: String,
        // TODO: Post Formのパラメータ名とフィールド名のマッピング方法がわからなかったため
        var bank_id: String,
        var password: String
)

