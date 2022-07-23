package com.example.fetchrewardscodingexercise.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchrewardscodingexercise.R
import com.example.fetchrewardscodingexercise.adapter.ItemsAdapter
import com.example.fetchrewardscodingexercise.databinding.ActivityMainBinding
import com.example.fetchrewardscodingexercise.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainActivityViewModel>()
    lateinit var adapter: ItemsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerViewItems.layoutManager = LinearLayoutManager(this)
        adapter = ItemsAdapter()
        binding.recyclerViewItems.adapter = adapter
        setUpObserver()
        setUpButton()
    }

    private fun setUpButton() {
        binding.buttonReload.setOnClickListener {
            mainViewModel.fetchItems()
        }
    }

    private fun setUpObserver() {
        mainViewModel.itemListLiveData.observe(this) {
            if (it != null) {
                adapter.setData(it)
                binding.recyclerViewItems.visibility = View.VISIBLE
                binding.buttonReload.visibility = View.GONE
            } else {
                binding.recyclerViewItems.visibility = View.GONE
                binding.buttonReload.visibility = View.VISIBLE
                Toast.makeText(this, this.getString(R.string.main_activity_fetch_error), Toast.LENGTH_SHORT).show()
            }
        }
    }
}