package com.daelim.springtest.main.resolver

import com.daelim.springtest.main.api.model.dto.TestDto
import com.daelim.springtest.main.api.model.dto.TestDtoInput
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import kotlin.random.Random

    @Component
    class PostResolver : GraphQLQueryResolver, GraphQLMutationResolver {
    // 김민성, 김시온 --------------------------------------------------------------------------------
    private val tests = mutableListOf<TestDto>()

    // 전체 조회 기능
    fun findAllTests(): List<TestDto> {
        // TestDto 객체를 리스트 형태로 반환
        return  tests
    }

    // Id로 조회 기능
    fun findTestById(id: String): TestDto? {
        // id와 일치하는 TestDto 객체를 찾아서 반환
        // 없다면 null 반환
        return tests.find { it.id == id }
    }

    // 공통된 닉네임 조회 검색어 기능
    fun findSerach(nickname: String): List<TestDto> {
        // ignoreCase = true : 대소문자를 구분하지 않고 두 문자열이 같은지 비교
        return tests.filter { it.nickname.contains(nickname, ignoreCase = true) }
    }

    // 김민기, 백예준 --------------------------------------------------------------------------------
    fun createTest(
        testDtoInput: TestDtoInput
    ): TestDto {
        // id중복 확인
        val existingTest = tests.find { it.id == testDtoInput.id }
        if (existingTest != null) {
            throw Exception("ID already exists")
        }

        // 랜덤 닉네임 생성
        val adjectives = arrayOf("용감한", "귀여운", "멋진", "친절한", "똑똑한")
        val nouns = arrayOf("사자", "토끼", "여우"    , "너구리", "펭귄")
        val randomNickname = "${adjectives[Random.nextInt(adjectives.size)]} ${nouns[Random.nextInt(nouns.size)]}"

        //   새로운 TestDto 객체 생성
        val newTest = TestDto(
            id = testDtoInput.id,
            nickname = randomNickname
        )

        // 새로운 객체를 tests 리스트에 추가
        tests.add(newTest)

        // 반환
        return newTest
    }
}
