package com.paula.arquitectura.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.paula.arquitectura.databinding.ActivityFrasesBinding
import com.paula.arquitectura.viewmodel.QuoteViewModel

class FrasesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFrasesBinding

    private val QuoteViewModel : QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //infla la vista
        binding = ActivityFrasesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        QuoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })

        binding.viewCpntainer.setOnClickListener {
            QuoteViewModel.randomQuote()
        }

    }
}