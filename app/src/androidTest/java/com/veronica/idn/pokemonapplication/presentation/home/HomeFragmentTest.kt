package com.veronica.idn.pokemonapplication.presentation.home

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.veronica.idn.pokemonapplication.R
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeFragmentTest : TestCase(){
    @Test
    fun testVisibilityHomeRecyclerview() {
        Espresso.onView(withId(R.id.rvHome))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}