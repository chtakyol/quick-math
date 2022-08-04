package com.example.quick_math.data

import androidx.datastore.core.DataStore
import com.example.quick_math.Statistics
import com.example.quick_math.domain.IStatisticsRepository
import com.example.quick_math.domain.UserStatistics
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext

class LocalUserStatisticsRepositoryImpl(
    private val dataStore: DataStore<Statistics>
): IStatisticsRepository {
    override suspend fun getStatistics(
        onSuccess: (UserStatistics) -> Unit,
        onError: (Exception) -> Unit
    ) = withContext(Dispatchers.IO) {
        try {
            val userStatistics = dataStore.data.first()

            onSuccess(
                userStatistics.toUserStatistics
            )
        } catch (e: Exception) {
            onError(e)
        }
    }

    override suspend fun updateStatistics(
        highScore: Int,
        onSuccess: (isRecord: Boolean) -> Unit,
        onError: (Exception) -> Unit
    ) = withContext(Dispatchers.IO) {
        try {
            val userStatistics = dataStore.data.first()
            val oldScore = userStatistics.highScore
            if(highScore > oldScore){
                dataStore.updateData { stats ->
                    stats.toBuilder()
                        .setHighScore(highScore)
                        .build()
                }
            }
            onSuccess(true)
        } catch (e: Exception) {
            onError(e)
        }
    }

    private val Statistics.toUserStatistics: UserStatistics get() {
        return UserStatistics(
            this.highScore
        )
    }
}