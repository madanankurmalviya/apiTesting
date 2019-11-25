package com.employee.utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class randDataGenRestUtils
{
	

	public static String empName()
	{
		String genEmpName = RandomStringUtils.randomAlphabetic(5);
		System.out.println("The random Emp Name gen is :"+genEmpName);
		return(genEmpName);		
	}
	public static String empAge()
	{
		String genEmpAge = RandomStringUtils.randomNumeric(2);
		return(genEmpAge);
	}
	public static String empSalary()
	{
		String genEmpSalary =RandomStringUtils.randomNumeric(5);
		return (genEmpSalary);
	}

}
