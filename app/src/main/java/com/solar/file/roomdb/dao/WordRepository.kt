package com.solar.file.roomdb.dao

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import com.solar.file.roomdb.dao.WordDao
import com.solar.file.roomdb.model.Word

class WordRepository(private val wordDao: WordDao) {
    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    // You must call this on a non-UI thread or your app will crash. So we're making this a
    // suspend function so the caller methods know this.
    // Like this, Room ensures that you're not doing any long running operations on the main
    // thread, blocking the UI.
    @WorkerThread // to mark that this method needs to be called from a non-UI thread
    suspend fun insert(word: Word) {  //suspend :  be called from a coroutine or another suspending function.
        wordDao.insert(word)
    }
}