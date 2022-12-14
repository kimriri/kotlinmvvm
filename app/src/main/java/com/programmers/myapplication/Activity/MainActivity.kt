package com.programmers.myapplication.Activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import com.programmers.myapplication.MyNumberViewModel
import com.programmers.myapplication.R
import com.programmers.myapplication.SubFragment
import com.programmers.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var myNumberViewModel: MyNumberViewModel

    companion object {

        const val TAG: String = "LOG"
    }

    @SuppressLint("LogConditional")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val binding = ActivityMainBinding.inflate(layoutInflater)
         val mainActivityView = binding.root
        setContentView(mainActivityView)
        Log.d(SubFragment.TAG, "MainActivityView $mainActivityView")

        myNumberViewModel = ViewModelProvider(this)[MyNumberViewModel::class.java]
        binding.mainActivityViewModel = myNumberViewModel

        myNumberViewModel.currenValue.observe(this) {
            binding.numberTextView.text = it.toString()
        }
        binding.goFragmentBtn.setOnClickListener {
            supportFragmentManager.commit {
                // setReorderingAllowed(true) -> 트랙젠션 상태변환 최적화 없어도 실행에 문제는 없다.
                setReorderingAllowed(true)
                replace<SubFragment>(R.id.fragment_container_view)
            }
        }
    }
}
