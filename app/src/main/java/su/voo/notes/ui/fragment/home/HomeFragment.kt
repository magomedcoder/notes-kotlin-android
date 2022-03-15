package su.voo.notes.ui.fragment.home

import su.voo.notes.ui.base.BaseFragment
import su.voo.notes.databinding.FragmentHomeBinding
import android.view.View
import android.os.Bundle
import androidx.fragment.app.viewModels

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}