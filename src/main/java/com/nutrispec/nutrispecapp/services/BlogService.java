package com.nutrispec.nutrispecapp.services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.nutrispec.nutrispecapp.models.Blog;

public class BlogService {
	private Connection conn;
	
	public BlogService(Connection conn) {
		this.conn = conn;
	}
	
	public Blog addBlog(Blog blog) {
		
		return blog;
			
	}
	
	public List<Blog> getAllBlogs() {
		List<Blog> blogs_list = new ArrayList<Blog>();
		return blogs_list;
	}

}
