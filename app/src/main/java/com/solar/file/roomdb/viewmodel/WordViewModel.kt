package com.solar.file.roomdb.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.solar.file.roomdb.dao.WordRepository
import com.solar.file.roomdb.dao.WordRoomDatabase
import com.solar.file.roomdb.model.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository
    val allWords: LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application,GlobalScope).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(word: Word) = GlobalScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }

        //
}