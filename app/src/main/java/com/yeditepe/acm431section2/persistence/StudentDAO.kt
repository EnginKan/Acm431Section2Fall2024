package com.yeditepe.acm431section2.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface StudentDAO {

    @Query("Select * from students")
  fun getAllStud(): MutableList<Student>

 @Query("Select * from Students where Name like :startChar+'%'")
 suspend fun getAllStudWithNameStartWith(startChar: Char)

    @Insert
    fun insertStud(student: Student) : Student

    @Delete
    suspend fun deleteStud(student: Student): Student

    @Query(" Delete from students where _id = :id")
    suspend fun deleteStud(id : Int): Student

    @Update
    suspend fun updateStud(student : Student)
}