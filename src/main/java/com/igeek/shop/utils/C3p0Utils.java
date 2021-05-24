package com.igeek.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

public class C3p0Utils {

	public static void main(String[] args){
		try{
			ComboPooledDataSource dataSource=new ComboPooledDataSource();
			System.out.println("数据连接池创建成功");
			Connection connection=dataSource.getConnection();
			System.out.println("连接成功");
			System.out.println(connection);
		}catch (Exception e){
			System.out.println(e);
		}

	}
}
