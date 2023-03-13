package com.example.castshow.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.castshow.core.data.entities.CharacterEntity


@Database(
    entities = [
        CharacterEntity::class
    ],
    version = 1
)
abstract class CastShowDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao

}