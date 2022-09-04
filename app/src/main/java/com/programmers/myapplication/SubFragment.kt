package com.programmers.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.programmers.myapplication.databinding.SubFragmentBinding

class SubFragment() : Fragment(R.layout.sub_fragment) {

    private lateinit var myNumberViewModel: MyNumberViewModel

    companion object {
        const val TAG: String = "LOG"
    }

    init {
        Log.d(TAG, "SubFragment")
    }

    private var _binding: SubFragmentBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("LogConditional")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SubFragmentBinding.inflate(inflater, container, false)
        myNumberViewModel =
            ViewModelProvider(activity as ViewModelStoreOwner)[MyNumberViewModel::class.java]
        binding.subFragmentViewModel = myNumberViewModel
        val subFragmentView = binding.root
        Log.d(TAG, "SubFragmentView $subFragmentView")
        return subFragmentView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
