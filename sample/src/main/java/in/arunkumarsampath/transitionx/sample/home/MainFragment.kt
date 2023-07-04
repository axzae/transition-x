package `in`.arunkumarsampath.transitionx.sample.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import `in`.arunkumarsampath.transitionx.sample.databinding.FragmentHomeBinding
import `in`.arunkumarsampath.transitionx.sample.home.adapter.SampleItemsAdapter

class MainFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val adapter = SampleItemsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val flexBoxLayoutManager = FlexboxLayoutManager(requireContext()).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.STRETCH
        }
        binding.sampleRecyclerView.layoutManager = flexBoxLayoutManager
        with(binding.sampleRecyclerView) {
            layoutManager = flexBoxLayoutManager
            adapter = this@MainFragment.adapter
        }
    }
}
