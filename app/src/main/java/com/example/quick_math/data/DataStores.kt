package com.example.quick_math.data

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.example.quick_math.Statistics
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

internal val Context.statisticsDataStore: DataStore<Statistics> by dataStore(
    fileName = "user_stats.pb",
    serializer = StatisticsSerializer
)

private object StatisticsSerializer: Serializer<Statistics> {
    override val defaultValue: Statistics = Statistics.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): Statistics {
        try {
            return Statistics.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: Statistics, output: OutputStream) = t.writeTo(output)
}