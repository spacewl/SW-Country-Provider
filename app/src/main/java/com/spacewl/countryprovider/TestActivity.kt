package com.spacewl.countryprovider

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.spacewl.countryprovider.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding
    private lateinit var viewModel: TestViewModel
    private lateinit var adapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)
        adapter = CountryAdapter()
        with(binding) {
            rvCountries.layoutManager = LinearLayoutManager(this@TestActivity)
            rvCountries.adapter = this@TestActivity.adapter
        }
        viewModel.countriesLD.observe(this) { counties ->
            this.adapter.replace(items = counties)
        }
    }
}