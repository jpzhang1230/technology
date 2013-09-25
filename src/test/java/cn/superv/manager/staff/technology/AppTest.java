package cn.superv.manager.staff.technology;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Unit test for simple App.
 */
@RunWith(Parameterized.class)
public class AppTest {
	private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

	private int input1;
	private int input2;
	private int expected;
	
	/**
	 * 准备数据
	 * 1)该方法必须由 @Parameters修饰
	 * 2)必须是public static
	 * 3)必须返回Collection类型
	 * 4)方法没有参数
	 * @param  none
	 * @return Collection
	 */
	@Parameters
	public static Collection<Object[]> prepareData(){
		Object[][] objects={{-1,-2,-3},{0,2,2},{-1,1,0},{1,2,3}};
		return Arrays.asList(objects);
	}
	
	public AppTest(int input1,int input2,int expected){
		this.input1=input1;
		this.input2=input2;
		this.expected=expected;
	}
	
	@Test
	public void testAdd(){
		App app=new App();
		int result=app.add(input1, input2);
		logger.info("{},{}",input1,input2);
		assertEquals(expected,result);
	}
	
	
	public enum Week {
		Monday, Tuesday, wednesday, Thursday, Friday, Saturday, Sunnday;

		public boolean isIdle() {
			if (this == Saturday || this == Sunnday) {
				return true;
			}
			return false;
		}
	}

	public void testApp() {
		Week week = Week.Monday;
		switch (week) {
		case Sunnday:
			System.out.println("今天是星期天");
			break;

		default:
			break;
		}
		assertFalse("week.idle=false",week.isIdle());
	}
	
	
}
