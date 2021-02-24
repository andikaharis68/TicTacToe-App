package com.example.latihanframgent.presentations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.latihanframgent.databinding.FragmentRegistrationBinding
import com.example.latihanframgent.interfaces.OnNavigationListener


class RegistrationFragment(val onNavigationListener: OnNavigationListener) : Fragment() {

    lateinit var viewModel: MainActivityViewModel
    lateinit var binding: FragmentRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        binding.apply {
            etPlayerName1.setText(viewModel.player1)
            etPlayerName2.setText(viewModel.player2)
            btnPlay.setOnClickListener {
                val player1 = etPlayerName1.text.toString()
                val player2 = etPlayerName2.text.toString()
                viewModel.setPlayer(player1, player2)
                onNavigationListener.onRegistration()
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(onNavigationListener: OnNavigationListener) = RegistrationFragment(onNavigationListener)
    }
}