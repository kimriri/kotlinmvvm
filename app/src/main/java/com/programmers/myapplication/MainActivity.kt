package com.programmers.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.programmers.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "LOG"
        private lateinit var myNumberViewModel: MyNumberViewModel
    }

    @SuppressLint("LogConditional")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val binding = ActivityMainBinding.inflate(layoutInflater)
         val view = binding.root
        setContentView(view)
        myNumberViewModel = ViewModelProvider(this)[MyNumberViewModel::class.java]
        binding.viewModel = myNumberViewModel

        myNumberViewModel.currenValue.observe(this) {
            binding.numberTextView.text = it.toString()
        }

        binding.goFragmentBtn.setOnClickListener {
            supportFragmentManager.commit {
              //  setReorderingAllowed(true)
                replace<SubFragment>(R.id.fragment_container_view)
            }
        }
    }
}
