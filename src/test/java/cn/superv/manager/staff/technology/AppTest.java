package cn.superv.manager.staff.technology;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    public enum Week{
    	Monday,Tuesday,wednesday,Thursday,Friday,Saturday,Sunnday;
    	
    	public boolean isIdle() {
    		if (this==Saturday || this==Sunnday) {
				return true;
			}
    		return false;
    	}
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	Week week=Week.Sunnday;
    	switch (week) {
		case Sunnday:
			System.out.println("今天是星期天");
			break;

		default:
			break;
		}
    	System.out.println(week.isIdle());
        assertTrue( true );
    }
}
