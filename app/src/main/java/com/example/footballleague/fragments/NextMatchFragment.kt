package com.example.footballleague.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.example.footballleague.R

/**
 * A simple [Fragment] subclass.
 */
class NextMatchFragment : Fragment(),View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNextMatchFragment:Button = view.findViewById(R.id.btn_next_match)
        btnNextMatchFragment.setOnClickListener(this)
    }
    override fun onClick(v: View?) {

    }


}
