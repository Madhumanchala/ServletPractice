package com.demo;

import java.sql.Connection;


public class Test {

	public static void main(String[] args) {
		Connection con = StudentDao.getconection();

		if (con != null) {
			System.out.println("connection Succesfull");
			System.out.println(con);
		} else {
			System.out.println("fail");
		}

	}

}
