/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.teatime;

import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * This test demos a user clicking the decrement button and verifying that it properly decrease
 * the quantity the total cost.
 */

// COMPLETED (1) Add annotation to specify AndroidJUnitRunner class as the default test runner
    @RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest {

    // COMPLETED (2) Add the rule that provides functional testing of a single activity
@Rule public ActivityTestRule<OrderActivity> mActivityRule= new ActivityTestRule<>(OrderActivity.class);

    // COMPLETED (3) Finish writing this test which will:
    @Test
    public void clickDecrementButton_ChangesQuantityAndCost() {
        // 1. Find the view and
        // 2. Perform the action in the view

        //   - Check that the initial quantity is zero
        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));
        //   - Click on the decrement button
        onView(withId(R.id.decrement_button)).perform(click());
        //   - Verify that the decrement button won't decrease the quantity 0 and cost below $0.00
        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));

        // with InstrumentationRegistry.getTargetContext we can access the resources of the app
        Resources resources= InstrumentationRegistry.getTargetContext().getResources();
        String name= resources.getString(R.string.initial_cost);
        onView(withId(R.id.cost_text_view)).check(matches(withText(name)));


    }
}