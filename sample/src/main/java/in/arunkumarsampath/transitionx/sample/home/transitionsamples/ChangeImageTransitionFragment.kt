/*
 *
 * Copyright 2019 Arunkumar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.view.updateLayoutParams
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import `in`.arunkumarsampath.transitionx.prepareTransition
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.databinding.LayoutChangeImageContentBinding
import `in`.arunkumarsampath.transitionx.sample.utils.dpToPx

class ChangeImageTransitionFragment : BaseSampleFragment() {

    private lateinit var binding: LayoutChangeImageContentBinding
    override val contentLayoutResource = R.layout.layout_change_image_content
    override val titleRes = R.string.change_image_transition

    private val dp112 by lazy { requireContext().dpToPx(112.0) }

    private var toggle = true

    @SuppressLint("RtlHardcoded")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LayoutChangeImageContentBinding.bind(viewStubRoot)
        setupMeow()
        initClickListeners()
    }

    private fun setupMeow() {
        binding.frameLayout.post {
            Glide.with(binding.userIconView)
                .load(R.drawable.cute_cat)
                .apply(RequestOptions().override(binding.frameLayout.width))
                .into(binding.userIconView)
        }
    }

    private fun initClickListeners() {
        binding.fab.setOnClickListener {
            binding.frameLayout.prepareTransition {
                moveResize()
                changeImage()
                +binding.userIconView
            }

            with(binding.userIconView) {
                if (toggle) {
                    updateLayoutParams<FrameLayout.LayoutParams> {
                        height = binding.frameLayout.height / 2
                        width = FrameLayout.LayoutParams.MATCH_PARENT
                    }
                    scaleType = ImageView.ScaleType.CENTER_CROP
                } else {
                    updateLayoutParams<FrameLayout.LayoutParams> {
                        height = dp112
                        width = dp112
                    }
                    scaleType = ImageView.ScaleType.CENTER
                }
                toggle = !toggle
            }
        }
    }
}
