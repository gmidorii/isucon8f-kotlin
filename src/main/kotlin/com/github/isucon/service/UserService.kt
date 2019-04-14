package com.github.isucon.service

import com.github.isucon.model.entity.User
import com.github.isucon.model.repository.UserRepository
import com.github.isucon.web.SignUpForm
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {

    @Transactional
    fun signUp(form: SignUpForm) {
        val user = User(
                bankId = form.bank_id,
                name = form.name,
                password = form.password
        )

        userRepository.save(user)
    }
}