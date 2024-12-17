package com.yeditepe.acm431section2.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val _id: Int,
    @ColumnInfo(name="Name")
    val name: String,
    val surname: String,
    val department:String
)