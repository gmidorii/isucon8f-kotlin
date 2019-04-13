package com.github.isucon.model.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue

@Entity
data class User(
        @Column(name = "bank_id") var bankId: String,
        var name: String,
        var password: String,
        @Column(name = "created_at") var createdDate: CreatedDate? = null,
        @Id @GeneratedValue var id: Long? = null
)
