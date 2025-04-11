package com.intprog.vscan.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.intprog.vscan.R
import com.intprog.vscan.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {
    private var _binding: FragmentForgotPasswordBinding? = null
    private val viewBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnRequest.setOnClickListener {
            // TODO: Implement password reset logic
            Toast.makeText(
                requireContext(),
                "Password reset link sent to your email",
                Toast.LENGTH_SHORT
            ).show()
        }

        viewBinding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_ForgotPasswordFragment_to_LoginFragment)
        }
    }
}