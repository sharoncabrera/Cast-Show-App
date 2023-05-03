package com.example.castshow.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.castshow.core.data.local.entities.CharacterEntity


@Database(
    entities = [
        CharacterEntity::class
    ],
    version = 1
)
abstract class CastShowDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao

}