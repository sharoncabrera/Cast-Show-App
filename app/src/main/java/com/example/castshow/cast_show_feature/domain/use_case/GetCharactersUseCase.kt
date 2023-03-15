package com.example.castshow.cast_show_feature.domain.use_case

import com.example.castshow.cast_show_feature.domain.repository.CastRepository
import javax.inject.Inject


class GetCharactersUseCase @Inject constructor(
    private val castRepository: CastRepository
) {
    suspend operator fun invoke() = castRepository.getCharactersFromApi()
}