package com.ibm.bvt.appobjects.blogs;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Properties;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;
import com.ibm.bvt.tasks.common.CommonMethods;

@SuppressWarnings("unused")
public class BlogsData {
	
	public static final String BlogsName1 = "First Blogs Level 2 test ";
	public static final String BlogsAddress1= "Test1Address";
	public static final String BlogsName2 = "Second Blogs Level 2 test ";
	public static final String BlogsAddress2= "Test2Address";
	public static final String BlogsName3 = "Third Blogs Level 2 test ";
	public static final String BlogsAddress3= "Test3Address";
	public static final String BlogsName4 = "Fourth Blogs Level 2 test ";
	public static final String BlogsAddress4= "Test4Address";
	public static final String BlogsTag = "BVTLevel2";
	public static final String BlogsDescription = "This is a test description";
	public static final String BlogsTimeZoneOption = "(GMT) Greenwich Mean Time : Dublin, Edinburgh, Lisbon, London";
	public static final String BlogsThemeOption = "Blog_with_Bookmarks";
	
	//Data for Search
	public static final String BlogsNameForSearch = "Blog for Search BVT 12345";
	public static final String BlogsAddressForSearch = "SearchBlogAddress12345";
	public static final String BlogsDescriptionForSearch = "This is a blog created for the search bvt - for laying down the data";
	public static final String BlogsTagForSearch = "searchblogtag12345";
	
	public static final String BlogsNewEntryTitle = "Entry for Level 2 Test ";
	public static final String BlogsSecondEntryTitle = "Second Entry for Level 2 Test ";
	public static final String BlogsNewEntryTag = "TestTag";
	public static final String BlogsNewEntryEntry = "This is a test entry for entering text into the CKEditor, This is a test entry for entering text into the CKEditor, This is a test entry for entering text into the CKEditor, This is a test entry for entering text into the CKEditor, This is a test entry for entering text into the CKEditor, This is a test entry for entering text into the CKEditor, This is a test entry for entering text into the CKEditor, and then the last part of the text.";
	
	public static final String BlogsHandleOfBlog = "Handle" + CommonMethods.genDateBasedRandVal();
	
	public static final String BlogsCommentText = "This is the test for the comment to be added to the entry in blogs - part of the BVT level 2 test";
	
	public static final String BlogFileAttachment1 = "Connections_BVT/CommonTestObjects/Desert.jpg";
	
	
}
