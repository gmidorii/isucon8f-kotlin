package com.github.isucon.model.repository

import com.github.isucon.model.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
}