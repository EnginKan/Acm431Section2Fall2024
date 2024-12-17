package com.yeditepe.acm431section2

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.yeditepe.acm431section2.persistence.Student
import com.yeditepe.acm431section2.persistence.StudentDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Test


class StudentDatabaseTest {
    lateinit var databaseInstance: StudentDatabase
    @Before
    fun initialzeDatabase(){
        val context: Context = ApplicationProvider.getApplicationContext()
        databaseInstance = Room.inMemoryDatabaseBuilder(context, StudentDatabase::class.java)
            .allowMainThreadQueries()
            .build()

    }

    @Test
     fun testInsertStudent():Unit{
            val dao = databaseInstance.studentDao()
            val student= Student(1,"Engin","Kandiran","COMP")

                    dao.insertStud(student)
        assert(dao.getAllStud().size==1)

    }
}