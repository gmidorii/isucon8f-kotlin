package com.github.isucon.infra.entity

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
class User(
        @Column(name = "bank_id") var bankId: String,
        var name: String,
        var password: String,
        @Column(name = "created_at") @CreatedDate var createdDate: LocalDateTime? = LocalDateTime.now(),
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)
