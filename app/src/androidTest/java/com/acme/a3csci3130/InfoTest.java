package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.TestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by SuperTalentVax on 2018-03-15.
 */
public class InfoTest {

    @Rule
    public ActivityTestRule <DetailViewActivity> testRule= new ActivityTestRule<DetailViewActivity>(DetailViewActivity.class);

    @Test
    public void onCreate() throws Exception{
        String name = "John Smith";
        String address = "250 Main Avenue";
        String businessNum = "512665041";
        String primaryBusiness = "Fisher";
        String province = "NS";

        onView(withId(R.id.name)).perform(typeText(name),closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText(name),closeSoftKeyboard());
        onView(withId(R.id.businessNum)).perform(typeText(name),closeSoftKeyboard());
        onView(withId(R.id.primaryBusiness)).perform(typeText(name),closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText(name),closeSoftKeyboard());



    }

}