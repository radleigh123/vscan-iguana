package com.intprog.vscan.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.intprog.vscan.R
import com.intprog.vscan.databinding.FragmentLoginBinding

/**
 * A login [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment(R.layout.fragment_login) {
    // This fragment is used for the login screen
    // You can add your login logic here
    // For example, you can use ViewModel to handle login data and authentication
    private var _binding: FragmentLoginBinding? = null
    private val viewBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up your login logic here
        // For example, you can set up click listeners for buttons
        viewBinding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_RegisterFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}