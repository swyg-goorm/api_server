package swyg.hollang.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import swyg.hollang.dto.CreateRecommendationResultResponse
import swyg.hollang.entity.Recommendation
import swyg.hollang.entity.TestResponse
import swyg.hollang.repository.hobby.HobbyRepository
import swyg.hollang.repository.recommendation.RecommendationRepository

@Service
@Transactional(readOnly = true)
class RecommendationService(private val recommendationRepository: RecommendationRepository) {

    fun save(testResponse: TestResponse, createRecommendationResultResponse: CreateRecommendationResultResponse)
        : Recommendation {
        val result = mutableMapOf(
            "hobbyType" to createRecommendationResultResponse.hobbyType,
            "hobbies" to createRecommendationResultResponse.hobbies
        )
        return recommendationRepository.save(testResponse = testResponse, result = result)
    }

    fun getRecommendationWithUserById(recommendationId: Long): Recommendation {
        return recommendationRepository.findWithUserById(recommendationId)
    }
}