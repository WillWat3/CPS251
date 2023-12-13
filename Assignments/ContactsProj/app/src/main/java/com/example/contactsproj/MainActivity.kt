package com.example.contactsproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsproj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: ContactListAdapter? = null
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenerSetup()
        observerSetup()
        recyclerSetup()



    }

    private fun listenerSetup() {

        binding.addButt.setOnClickListener {
            val name = binding.nameInput.text.toString()
            val number = binding.phoneInput.text.toString()

            if (name != "" && number != "") {
                val contact = Contact(name, number)
                viewModel.inserContact(contact)
                clearFields()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Please enter proper name and phone number",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.findButt.setOnClickListener {
            viewModel.findContact(
                binding.nameInput.text.toString()
            )
        }


        binding.delButton.setOnClickListener {
            (viewModel.deleteContact(binding.nameInput.text.toString()))
        }

    }


        private fun observerSetup() {
            viewModel.getAllContacts()?.observe(this) { contacts ->
                contacts?.let {
                    adapter?.setContactList(it)
                }
            }

            viewModel.getAsc()?.observe(this){contacts ->
                contacts?.let{
                    adapter?.setContactList(it)
                }
            }



            viewModel.getSearchResults().observe(this) { contacts ->
                contacts?.let {
                    if (it.isNotEmpty()) {
                        binding.nameInput.setText(it[0].contactName)
                        binding.phoneInput.setText(it[0].contactNumber)
                    } else {
                        Toast.makeText(applicationContext, "No match found.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

            }
        }

        private fun recyclerSetup() {
            adapter = ContactListAdapter(R.layout.card_layout)
            binding.recView.layoutManager = LinearLayoutManager(this)
            binding.recView.adapter = adapter
        }

        private fun clearFields() {
            binding.nameInput.setText("")
            binding.phoneInput.setText("")
        }}

