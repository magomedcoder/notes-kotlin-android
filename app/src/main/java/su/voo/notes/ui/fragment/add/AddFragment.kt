package su.voo.notes.ui.fragment.add

import su.voo.notes.ui.base.BaseFragment
import su.voo.notes.databinding.FragmentAddBinding
import android.view.View
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup

class AddFragment : BaseFragment<FragmentAddBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAddBinding.inflate(inflater, container, false)

}