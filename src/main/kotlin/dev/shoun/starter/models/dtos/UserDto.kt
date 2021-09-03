package dev.shoun.starter.models.dtos

import dev.shoun.starter.models.User

class UserDto(user: User) {
    val id: Long? = user.id
    val firstName: String = user.firstName
    val lastName: String = user.lastName
}

class SelfUserDto(user: User) {
    val id: Long? = user.id
    val firstName: String = user.firstName
    val lastName: String = user.lastName
    val email: String = user.email
}