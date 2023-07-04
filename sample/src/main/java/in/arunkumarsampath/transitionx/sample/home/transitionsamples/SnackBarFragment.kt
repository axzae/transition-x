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

import android.os.Bundle
import android.view.View
import `in`.arunkumarsampath.transitionx.prepareTransition
import `in`.arunkumarsampath.transitionx.sample.R
import `in`.arunkumarsampath.transitionx.sample.databinding.LayoutSnackbarContentBinding
import `in`.arunkumarsampath.transitionx.sample.utils.toggleGone

class SnackBarFragment : BaseSampleFragment() {

    private lateinit var binding: LayoutSnackbarContentBinding
    override val contentLayoutResource = R.layout.layout_snackbar_content
    override val titleRes = R.string.snackbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LayoutSnackbarContentBinding.bind(viewStubRoot)
        bindListeners()
    }

    private fun bindListeners() {
        binding.fab.setOnClickListener {
            binding.snackbarConstraintLayout.prepareTransition {
                moveResize {
                    +binding.fab
                }
                slide {
                    +binding.snackbarMessage
                }
                ease { decelerateEasing }
            }
            binding.snackbarMessage.toggleGone()
        }
    }
}
