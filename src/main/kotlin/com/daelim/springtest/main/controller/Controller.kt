package com.daelim.springtest.main.controller

import com.daelim.springtest.main.api.model.dto.TestDto
import com.daelim.springtest.main.api.model.dto.TestDtoRequest
import io.swagger.v3.oas.annotations.Parameter
import jakarta.validation.Valid
import net.datafaker.Faker
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class NicknameController {

}


@RestController
class Controller {
    private val tests = mutableListOf<TestDto>()


    @PostMapping("/nickname")
    fun postNickname(): ResponseEntity<String> {
        val adjectives = arrayOf("용감한", "귀여운", "멋진", "친절한", "똑똑한")
        val nouns = arrayOf("사자", "토끼", "여우", "너구리", "펭귄")
        val randomNickname = "${adjectives[Random().nextInt(adjectives.size)]} ${nouns[Random().nextInt(nouns.size)]}"
        return ResponseEntity.ok(randomNickname)
    }

    @PostMapping("/test")

    fun postTestDto(
        @RequestBody testDtoRequest: TestDtoRequest
    ): ResponseEntity<TestDto> {
        val faker = Faker(Locale.KOREA)
        val test = TestDto(
            id = testDtoRequest.id,
            address = faker.address().fullAddress(),
            email = faker.internet().emailAddress(),
            tel = faker.phoneNumber().phoneNumber(),
            age = Random().nextInt(10)
        )
        tests.add(test)
        return ResponseEntity.ok().body(test)
    }

    @GetMapping("/test")
    fun getAllTestDto(
    ): ResponseEntity<List<TestDto>> {
        val response = tests
        return ResponseEntity.ok().body(response)
    }

    @GetMapping("/test/{id}")
    fun getTestDto(
        @PathVariable("id") userId: String
    ): ResponseEntity<TestDto> {
        val response = tests.firstOrNull { it.id == userId }
        return ResponseEntity.ok().body(response)
    }
}