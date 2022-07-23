package com.example.fetchrewardscodingexercise.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchrewardscodingexercise.adapter.ItemsAdapter
import com.example.fetchrewardscodingexercise.databinding.ActivityMainBinding
import com.example.fetchrewardscodingexercise.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainActivityViewModel>()
    lateinit var adapter: ItemsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, com.example.fetchrewardscodingexercise.R.layout.activity_main)
        binding.recyclerViewItems.layoutManager = LinearLayoutManager(this)
        adapter = ItemsAdapter()
        binding.recyclerViewItems.adapter = adapter
        setUpObserver()
    }

    private fun setUpObserver() {
        mainViewModel.itemListLiveData.observe(this) {
            if(it!=null){
               adapter.setData(it)
            }else{
                Toast.makeText(this,"Error Fetching Data",Toast.LENGTH_SHORT).show()
            }
        }
    }
}