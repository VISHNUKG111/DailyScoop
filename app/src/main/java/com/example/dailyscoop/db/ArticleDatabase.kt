package com.example.dailyscoop.db

import androidx.room.Database
import androidx.room.TypeConverter
import com.example.dailyscoop.model.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverter(Conveters::class)

class ArticleDatabase {
}