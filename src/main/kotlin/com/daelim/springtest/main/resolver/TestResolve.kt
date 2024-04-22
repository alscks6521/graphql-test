package com.daelim.springtest.main.resolver

import com.daelim.springtest.main.api.model.dto.TestDto
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.kickstart.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component
import java.util.*

@Component
class PostResolver : GraphQLQueryResolver, GraphQLMutationResolver {
    private val tests = mutableListOf<TestDto>()

    // 쿼리 리졸버 비워둠
    fun findAllTests(): List<TestDto>? = null
    fun findTestById(id: ID): TestDto? = null

    fun createTest(testDtoInput: TestDtoInput): TestDto {
        // id중복 확인

        val existingTest = tests.find { it.id == testDtoInput.id }
        // tests 컬렉션에서 id가 testDtoInput.id와 일치하는 테스트 데이터를 찾음

        if (existingTest != null) {
            // 이미 해당 ID를 가진 테스트가 존재하는지 확인
            throw Exception("ID already exists")
            // 중복된 ID가 없는 경우에는 새로운 테스트를 생성하고 반환
        }

        // 랜덤 닉네임 생성
        val adjectives = arrayOf("용감한", "귀여운", "멋진", "친절한", "똑똑한") // 형용사 배열 생성
        val nouns = arrayOf("사자", "토끼", "여우", "너구리", "펭귄") //명사 배열 생성
        val randomNickname = "${adjectives[Random.nextInt(adjectives.size)]} ${nouns[Random.nextInt(nouns.size)]}"
        // 형용사와 명사를 조합

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
