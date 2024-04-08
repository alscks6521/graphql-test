package com.daelim.springtest.main.resolver
//
//import com.daelim.springtest.main.api.model.dto.TestDto
//import graphql.kickstart.tools.GraphQLMutationResolver
//import graphql.kickstart.tools.GraphQLQueryResolver
//import net.datafaker.Faker
//import org.springframework.stereotype.Component
//import java.util.*
//
//@Component
//class PostResolver : GraphQLQueryResolver, GraphQLMutationResolver {
//    private val tests = mutableListOf<TestDto>()
//
//    val faker = Faker(Locale.KOREA)
//
//    fun findAllTests(): List<TestDto> {
//        return tests
//    }
//
//    fun findTestById(id: String): TestDto? {
//        return tests.find { it.id == id }
//    }
//
////    fun createTest(userId: String): TestDto {
////        val test = TestDto(
////            id = userId,
////            address = faker.address().fullAddress(),
////            email = faker.internet().emailAddress(),
////            tel = faker.phoneNumber().phoneNumber(),
////            age = Random().nextInt(100)
////        )
////        tests.add(test)
////        return test
////    }
//}