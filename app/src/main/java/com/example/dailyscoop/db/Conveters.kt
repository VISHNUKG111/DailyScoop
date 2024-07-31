package com.example.dailyscoop.db

import androidx.room.TypeConverter
import com.example.dailyscoop.model.Source

class Conveters{
    @TypeConverter
    fun fromSource(source: Source) :String{
        return source.name
    }
    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name, name)
    }
}