package com.gmail.spencerdamon1974.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.gmail.spencerdamon1974.countries.data.remote.respository.CountryRepository
import com.gmail.spencerdamon1974.countries.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val countryRepository = CountryRepository()
    private lateinit var countryAdapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupLoadingState()
        CoroutineScope(Dispatchers.IO).launch {
            val countries = countryRepository.getCountries().toList()
            countryAdapter = CountryAdapter(countries)
            Log.d("Countries", countries.toString())
            withContext(Dispatchers.Main) {
                setupRecyclerView()
                setupSuccessState()
            }

        }
    }

    private fun setupRecyclerView() {
        binding.recyclerview.adapter = countryAdapter
    }

    private fun setupSuccessState() = with(binding) {
        recyclerview.isVisible = true
        progressLoading.isVisible = false
    }

    private fun setupLoadingState() = with(binding){
        recyclerview.isVisible = false
        progressLoading.isVisible = true
    }

}