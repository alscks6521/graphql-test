package com.daelim.springtest.main.resolver

import com.daelim.springtest.main.api.model.dto.TestDto
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.kickstart.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component
import java.util.*

@Component
class PostResolver : GraphQLQueryResolver, GraphQLMutationResolver {
    // 김민성, 김시온 --------------------------------------------------------------------------------
    private val tests = mutableListOf<TestDto>()

    // 쿼리 리졸버 비워둠. Find 작업
    fun findAllTests(): List<TestDto>? = null


    // Find 작업
    fun findTestById(id: ID): TestDto? = null

    // 김민기, 백예준 --------------------------------------------------------------------------------
    fun createTest(testDtoInput: TestDtoInput): TestDto {
        // id중복 확인
        val existingTest = tests.find { it.id == testDtoInput.id }
        if (existingTest != null) {
            throw Exception("ID already exists")
        }

        // 랜덤 닉네임 생성
        val adjectives = arrayOf("용감한", "귀여운", "멋진", "친절한", "똑똑한")
        val nouns = arrayOf("사자", "토끼", "여우", "너구리", "펭귄")
        val randomNickname = "${adjectives[Random.nextInt(adjectives.size)]} ${nouns[Random.nextInt(nouns.size)]}"

        // 새로운 TestDto 객체 생성
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
