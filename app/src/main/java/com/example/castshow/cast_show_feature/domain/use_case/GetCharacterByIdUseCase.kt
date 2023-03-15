package com.example.castshow.cast_show_feature.domain.use_case

import com.example.castshow.cast_show_feature.domain.repository.CastRepository
import javax.inject.Inject
import com.example.castshow.core.data.model.Character

class GetCharacterByIdUseCase @Inject constructor(
    private val castRepository: CastRepository
) {
    suspend operator fun invoke(id: Int): Character = castRepository.getCharacterById(id)
}