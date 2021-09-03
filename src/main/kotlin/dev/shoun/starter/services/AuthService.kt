package dev.shoun.starter.services

import dev.shoun.starter.forms.RegisterNewUserForm
import dev.shoun.starter.models.User
import dev.shoun.starter.models.dtos.SelfUserDto
import dev.shoun.starter.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.validation.BindingResult

@Service
class AuthService {
    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    fun registerNewUser(registerNewUserForm: RegisterNewUserForm, bindingResult: BindingResult): SelfUserDto {
        val user = User(
            email = registerNewUserForm.email,
            firstName = registerNewUserForm.firstName,
            lastName = registerNewUserForm.lastName
        )
        user.password = passwordEncoder.encode(registerNewUserForm.password)
        user.enabled = true
        userRepository.save(user)
        return SelfUserDto(user)
    }
}