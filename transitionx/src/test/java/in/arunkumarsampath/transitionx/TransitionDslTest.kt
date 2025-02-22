package `in`.arunkumarsampath.transitionx

import androidx.core.view.animation.LinearOutSlowInInterpolator
import androidx.transition.*
import `in`.arunkumarsampath.transitionx.transition.set.DefaultTransitionSetBuilder
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [19, 21, 24])
class TransitionDslTest {

    // To test DSL, it is sufficient to construct a transition set with given DSL syntax and test
    // if generated transition test contains correct transitions as per DSL.
    @Test
    fun `test dsl reflects generated transition`() {
        val transition = DefaultTransitionSetBuilder().apply {
            slide {
                duration = 200
            }
            fade {
                interpolator = LinearOutSlowInInterpolator()
            }
            scaleRotate {
                startDelay = 200
            }
            changeClipBounds()
            moveResize()
            changeImage()
            changeScroll()
            explode()
        }.transition

        transition.run {
            val slide = getTransitionAt(0)
            assertTrue(slide is Slide)
            assertTrue(slide.duration == 200L)
            val fade = getTransitionAt(1)
            assertTrue(fade is Fade)
            assertTrue(fade.interpolator is LinearOutSlowInInterpolator)
            val changeTransform = getTransitionAt(2)
            assertTrue(changeTransform is ChangeTransform)
            assertTrue(changeTransform.startDelay == 200L)
            assertTrue(getTransitionAt(3) is ChangeClipBounds)
            assertTrue(getTransitionAt(4) is ChangeBounds)
            assertTrue(getTransitionAt(5) is ChangeImageTransform)
            assertTrue(getTransitionAt(6) is ChangeScroll)
            assertTrue(getTransitionAt(7) is Explode)
        }
    }

    @Test
    fun `test custom transition builder`() {
        class SimpleFade : Fade()

        val transition = DefaultTransitionSetBuilder().apply {
            customTransition<SimpleFade>()
        }.transition

        assertTrue(transition.getTransitionAt(0) is SimpleFade)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `test dsl for custom transition with non instantiable constructor fails`() {
        class SimpleFade(private val something: Int) : Fade()

        val transition = DefaultTransitionSetBuilder().apply {
            customTransition<SimpleFade>()
        }.transition

        assertTrue(transition.getTransitionAt(0) is SimpleFade)
    }

    /*@Test
    fun `test listeners get triggered`() {
        val testActivity = Robolectric.buildActivity(TestActivity::class.java).apply {
            start()
            resume()
        }.get()

        val contentView = testActivity.findViewById<FrameLayout>(android.R.id.content)
        contentView.prepareAutoTransition {
            testActivity.textView.text = "Something"
            onEnd {}
        }
    }*/
}
