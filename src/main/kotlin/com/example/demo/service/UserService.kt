package com.example.demo.service

import com.example.demo.model.User
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun createUser(user: User): User = userRepository.save(user)

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun getUserById(id: Long): User? = userRepository.findById(id).orElse(null)

    fun updateUser(id: Long, updatedUser: User): User? {
        val user = userRepository.findById(id).orElse(null) ?: return null
        user.name = updatedUser.name
        user.email = updatedUser.email
        return userRepository.save(user)
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}