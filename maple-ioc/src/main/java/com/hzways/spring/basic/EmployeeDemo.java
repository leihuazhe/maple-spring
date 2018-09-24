package com.hzways.spring.basic;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/*
 * 给 一 个 字 符 串 name= 小 红 &age=17&salary=8000.00&hireDate=1991-07-03;name= 小 明&age=23&salary=10000.00&hireDate=1992-12-11;name= 小 白&age=18&salary=12000.00&hireDate=1996-01-09，
	请把字符串中的数据封装到 Employee 的对象中，
	类 Employee 有 name（String 类型）、age（int 类型）、salary（薪水是 BigDecimal 类型）、
	hireDate（入职日期是 Date 类型） 四个字段且符合 JavaBean 规范
	把三个创建的对象存放数组中，求出在 1996 年前入职的员工的的平均薪资。
	
	思路:
	1.先用split方法分割字符串为字符数组
	2.如何传递该字符串数组,使其他类可以操作字符串数组,计算name,age,salary,hireDate分别出现几次
	3.构建数组将name,age,salary,hireDate的索引值分别装入各自的数组中
	4.创建Employee数组实例化
	5.解析各数组为Employee数组赋值
		
 */
public class EmployeeDemo {

	@Test
	public void testName() throws Exception {
		String str = "name= 小 红 &age=17&salary=8000.00&hireDate=1991-07-03;name= 小 明&age=23&salary=10000.00&hireDate=1992-12-11;name= 小 白&age=18&salary=12000.00&hireDate=1996-01-09";
		List<String> emps = SpiltUtil.spiltEmployees(str);

		List<Employee> employees = emps.stream().map(emp -> SpiltUtil.kvMapToObject(SpiltUtil.buildEmployee(emp))).collect(Collectors.toList());

		employees.forEach(employee -> System.out.println(employee.toString()));





		//System.out.println(Arrays.toString(SpiltUtil.getInstance().spiltUtil()));
		//System.out.println(Arrays.toString(Field.getInstance().ageArrays()));
		//Employee[] employees=Field.getInstance().getEmployees();
	}

}
