package com.clouway;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit multimap for simple App.
 */
public class MainTest
    extends TestCase
{
    /**
     * Create the multimap case
     *
     * @param testName name of the multimap case
     */
    public MainTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MainTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
