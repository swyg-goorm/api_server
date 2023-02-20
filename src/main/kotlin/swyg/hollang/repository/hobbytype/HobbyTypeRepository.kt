package swyg.hollang.repository.hobbytype

import swyg.hollang.entity.HobbyType

interface HobbyTypeRepository {

    fun findByMbtiType(mbtiType: String): HobbyType

    fun findByMbtiTypeIsIn(mbtiTypes: List<String>): List<HobbyType>
}