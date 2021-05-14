package architecture.core.base

import kotlinx.coroutines.flow.Flow

interface BaseUseCase<in I, out O> : Flow<O> {
    operator fun invoke(input: I): Flow<O>
}