package com.rudroid.newsapp.db

import androidx.room.TypeConverter
import com.rudroid.newsapp.models.Source

class Converter {
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}