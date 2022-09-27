package test;

import java.sql.Connection;

import connectivity.CheckConnection;

public class Test {
	
	
	public static void main(String[] args)
	{
		Connection con=CheckConnection.getConnect();
		
		if(con!=null)
		{
			System.out.println("connection Succesfull");
			System.out.println(con);
		}
		else
		{
			System.out.println("fail");
		}
}
}
