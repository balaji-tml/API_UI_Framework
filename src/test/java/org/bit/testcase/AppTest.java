package org.bit.testcase;

import org.bit.base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("Page title: "+driver.getTitle());
        assertTrue( true );
    }
}
