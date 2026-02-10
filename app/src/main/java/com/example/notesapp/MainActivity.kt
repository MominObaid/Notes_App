package com.example.notesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}