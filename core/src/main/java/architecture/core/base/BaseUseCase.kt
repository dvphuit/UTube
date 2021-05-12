package architecture.core.base

import kotlinx.coroutines.flow.Flow

interface BaseUseCase<in I, out O : Entity> : Flow<O> {
    operator fun invoke(input: I): Flow<O>
}