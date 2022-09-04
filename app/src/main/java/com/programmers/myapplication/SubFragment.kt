package com.programmers.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.programmers.myapplication.databinding.SubFragmentBinding

class SubFragment() : Fragment(R.layout.sub_fragment) {

    private lateinit var myNumberViewModel: MyNumberViewModel

    companion object {
        const val TAG: String = "LOG"
    }

    init {
        Log.d(MyNumberViewModel.TAG, "MyNumberViewModel")
    }

    private var _binding: SubFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SubFragmentBinding.inflate(inflater, container, false)
        myNumberViewModel = ViewModelProvider(activity as ViewModelStoreOwner)[MyNumberViewModel::class.java]
        binding.viewModel = myNumberViewModel
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
