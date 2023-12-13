package com.example.contactsproj

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>
    private val sortedAsc: LiveData<List<Contact>>?

    init{
        allContacts = repository.allContacts
        searchResults = repository.searchResults
        sortedAsc = repository.sortedAsc

    }

    fun inserContact(contact: Contact){
        repository.insertContact(contact)
    }

    fun findContact(name:String){
        repository.findContact(name)
    }

    fun deleteContact(name: String){
        repository.deleteContact(name)
    }

    fun getSearchResults(): MutableLiveData<List<Contact>>{
        return searchResults
    }

    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }

   fun getAsc():LiveData<List<Contact>>?{
       return sortedAsc
   }

}