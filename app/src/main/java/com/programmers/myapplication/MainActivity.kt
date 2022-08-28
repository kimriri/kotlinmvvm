package com.programmers.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.programmers.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "LOG"
    }
    private lateinit var myNumberViewModel: MyNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        myNumberViewModel = ViewModelProvider(this)[MyNumberViewModel::class.java]
        myNumberViewModel.currenValue.observe(this) {
            Log.d(TAG, "MainActivityValue : $it")
            binding.numberTextView.text = it.toString()
        }

        binding.plusBtn.setOnClickListener{
            myNumberViewModel.updateValue(ActionType.PULS,binding.userInputEdittext.text.toString().toInt())}
        binding.minusBtn.setOnClickListener{
            myNumberViewModel.updateValue(ActionType.MINUS,binding.userInputEdittext.text.toString().toInt())}
    }


}

