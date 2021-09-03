package dev.shoun.starter.forms

import dev.shoun.starter.forms.constraints.EmailNotInUse
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class RegisterNewUserForm(
    @field:NotNull @field:Size(min = 1, max = 32) val firstName: String,
    @field:NotNull @field:Size(min = 1, max = 32) val lastName: String,
    @field:Email @field:Size(min = 1, max = 256) @field:EmailNotInUse val email: String,
    @field:NotNull @field:Size(min = 8) val password: String
)