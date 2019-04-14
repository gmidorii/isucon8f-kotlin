package com.github.isucon.infra.repository

import com.github.isucon.infra.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
}