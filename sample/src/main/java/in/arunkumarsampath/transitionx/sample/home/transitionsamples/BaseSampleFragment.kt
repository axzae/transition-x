package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.core.app.Fragment
import `in`.arunkumarsampath.transitionx.sample.R
import kotlinx.android.synthetic.main.fragment_base_sample_transition.*

abstract class BaseSampleFragment : Fragment() {

    @get:LayoutRes
    abstract val contentLayoutResource: Int

    @get:StringRes
    abstract val titleRes: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflater.inflate(R.layout.fragment_base_sample_transition, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setTitle(titleRes)
        with(layoutStub) {
            layoutResource = contentLayoutResource
            inflate()
        }
    }
}
