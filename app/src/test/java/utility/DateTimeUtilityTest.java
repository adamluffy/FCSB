/*
 * Copyright (c) 2018. This project begin with the difficulty of using hard copy form. As years has passed, many of
 * wasted form were dump into the store. In order to solve the problem. I decide to build an Android app for operating
 * hour and vehicle millage. This app is only used within the company community.
 */

package utility;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class DateTimeUtilityTest {

    @Test
    public void timeDiff() {

        Calendar starTime = Calendar.getInstance();
        starTime.set(Calendar.YEAR,Calendar.OCTOBER,Calendar.DAY_OF_MONTH,12,30,0);

        Calendar endTime = Calendar.getInstance();
        endTime.set(Calendar.YEAR,Calendar.OCTOBER,Calendar.DAY_OF_MONTH,14,0,0);

        assertEquals(1.5,DateTimeUtility.timeDiff(starTime.getTime(),endTime.getTime()));
    }
}