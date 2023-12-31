package com.botree.constants;

public class QueryConstants {

	public static final String LOGIN_SQL="""
			select password from user where username=?;
			""";
	public static final String SEARCH_SQL = """
			select * from cars where brand_name=?;
			""";
	public static final String INSERT_SQL = """
			insert into cars values(?,?,?,?,?,?,?,?,?,?,?)
			""";
	
	
}
