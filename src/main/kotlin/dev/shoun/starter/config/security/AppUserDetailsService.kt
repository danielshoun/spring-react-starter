package dev.shoun.starter.config.security

import dev.shoun.starter.models.User
import dev.shoun.starter.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AppUserDetailsService : UserDetailsService {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun loadUserByUsername(email: String): UserDetails {
        val user: User = userRepository.findByEmail(email) ?: throw UsernameNotFoundException("User not found")
        return UserPrincipal(user)
    }
}