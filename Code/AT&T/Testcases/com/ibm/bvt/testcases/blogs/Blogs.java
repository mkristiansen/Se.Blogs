package com.ibm.bvt.testcases.blogs;

import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;

import com.ibm.bvt.appobjects.blogs.BlogsData;
import com.ibm.bvt.appobjects.blogs.BlogsObjects;
import com.ibm.bvt.appobjects.common.CommonData;
import com.ibm.bvt.appobjects.common.CommonObjects;
import com.ibm.bvt.tasks.blogs.BlogsMethods;
import com.ibm.bvt.tasks.common.CommonMethods;

public class Blogs extends BlogsMethods {
	/*
	 * Created by: Conor Pelly
	 * Date: 10/18/2011
	 * Comment: This is a test class for AT&T demo 
	 */
	
	public void testDemoForBlogs () throws Exception {
		System.out.println("INFO: Start of Blogs Code Example");	
		String DateTime = CommonMethods.genDateBasedRandVal();
		
		//Load the component
		LoadComponent(CommonObjects.ComponentBlogs);
					
		//Login as a user (add the user for this test in the test.properties)
		Login(CommonData.Username, CommonData.Password);
				
		//Click on the My Blogs tab
		clickLink(BlogsObjects.MyBlogs);
		
		//Click on the Start a Blog button
		clickLink(BlogsObjects.StartABlog);
		
		//Add code for creating a blog
		CreateABlogAsAdmin(BlogsData.BlogsName1+DateTime, BlogsData.BlogsAddress1+DateTime);
				
		//Add an Entry
		CreateANewBlogEntry(BlogsData.BlogsName1+DateTime, BlogsData.BlogsNewEntryTitle+DateTime, BlogsData.BlogsNewEntryEntry);
		
		//Verify that the entry has being added and the text has being added too
		String EntryTitle=selenium.getText(BlogsObjects.VerifyBlogsEntry);
		String EntryTitleText=selenium.getText(BlogsObjects.VerifyBlogsEntryText);
		assertEquals(EntryTitle, BlogsData.BlogsNewEntryTitle+DateTime);
		assertEquals(EntryTitleText, BlogsData.BlogsNewEntryEntry);
		
		//Logout of Wiki
		Logout();	
	  	
		System.out.println("INFO: End of Blogs Code Example");
	}
	
}
