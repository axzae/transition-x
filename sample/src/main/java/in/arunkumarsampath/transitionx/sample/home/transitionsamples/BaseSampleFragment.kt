package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import `in`.arunkumarsampath.transitionx.sample.databinding.FragmentBaseSampleTransitionBinding

abstract class BaseSampleFragment : Fragment() {

    private lateinit var binding: FragmentBaseSampleTransitionBinding
    lateinit var viewStubRoot: View // get() = binding.layoutStub.rootView

    @get:LayoutRes
    abstract val contentLayoutResource: Int

    @get:StringRes
    abstract val titleRes: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBaseSampleTransitionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setTitle(titleRes)
        with(binding.layoutStub) {
            layoutResource = contentLayoutResource
            viewStubRoot = inflate()
        }
    }
}
