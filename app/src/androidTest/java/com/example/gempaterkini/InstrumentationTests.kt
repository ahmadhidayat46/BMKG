package com.example.gempaterkini

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.gempaterkini.network.Gempaterkini
import com.example.gempaterkini.ui.GempaterkiniListFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstrumentationTests : BaseTest() {

    @Test
    fun `recycler_view_content`() {
        launchFragmentInContainer<GempaterkiniListFragment>(themeResId = R.style.Theme_Gempaterkini)
        waitForView(ViewMatchers.withText("Great Basin Spadefoot")).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        waitForView(ViewMatchers.withText("Tiger Salamander")).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun `detail_content`() {
        launchActivity<MainActivity>()
        waitForView(ViewMatchers.withText("Blue Jeans Frog")).perform(ViewActions.click())
        waitForView(ViewMatchers.withText("Blue Jeans Frog")).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        waitForView(
            ViewMatchers.withText(
                "Sometimes called the Strawberry Poison-Dart Frog, this little " +
                        "amphibian is identifiable by its bright red body and blueish-purple arms and " +
                        "legs. The Blue Jeans Frog is not toxic to humans like some of its close " +
                        "relatives, but it can be harmful to some predators."
            )
        )
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun <T> launchActivity() {
        TODO("Not yet implemented")
    }
}
