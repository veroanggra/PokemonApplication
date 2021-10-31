package com.veronica.idn.pokemonapplication.presentation.detail

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.veronica.idn.pokemonapplication.R
import junit.framework.TestCase
import org.junit.Test

class DetailFragmentTest : TestCase(){
    @Test
    fun testVisibilityRecyclerviewWeakness() {
        Espresso.onView(ViewMatchers.withId(R.id.rvWeaknesses))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun testVisibilityRecyclerviewStats() {
        Espresso.onView(ViewMatchers.withId(R.id.rvStats))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun testVisibilityRecyclerviewEvolution() {
        Espresso.onView(ViewMatchers.withId(R.id.rvEvolutions))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}