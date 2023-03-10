package swyg.hollang.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import swyg.hollang.config.FeignClientConfig
import swyg.hollang.dto.CreateRecommendationResultResponse
import swyg.hollang.dto.CreateTestResponseDetailRequest

@FeignClient(
    name = "recommendationApiClient",
    url = "\${inferring.server.host}:5000",
    configuration = [FeignClientConfig::class])
interface RecommendationApiClient {

    @PostMapping("/test-responses", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun inferHobbiesAndType(@RequestBody createTestResponseDetailRequests: MutableList<CreateTestResponseDetailRequest>)
        : CreateRecommendationResultResponse
}