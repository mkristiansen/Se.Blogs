/* ***************************************************************** */
/*                                                                   */
/* IBM Confidential                                                  */
/*                                                                   */
/* OCO Source Materials                                              */
/*                                                                   */
/* Copyright IBM Corp. 2010                                          */
/*                                                                   */
/* The source code for this program is not published or otherwise    */
/* divested of its trade secrets, irrespective of what has been      */
/* deposited with the U.S. Copyright Office.                         */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.bvt.appobjects.common;

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


@SuppressWarnings("unused")
public class CommonData {
	
	/*
	 * File location for the files for uploading
	 */
	public static final String WindowsFileLocation = "c:\\SeleniumServer\\TestFiles\\";
	public static final String LinuxMacFileLocation = "/SeleniumServer/TestFiles/";
	
	/*
	 * Users
	 */
	
	protected Selenium selenium;

	private static final String BUNDLE = "users.properties";
	private static final Properties properties;
	static {
		properties = new Properties();
		try {
			properties.load(CommonObjects.class.getResourceAsStream(BUNDLE));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Users 
	public static final String Username = properties.getProperty("test_user");
	
	//Passwords
	public static final String Password = properties.getProperty("test_user_password");
	
	//For typeahead
	public static final String Typeahead = properties.getProperty("test_user_typeahead");

	//User with email
	public static final String EmailID = properties.getProperty("test_user_email");

	//List of Roles
	public static final String OwnerRole = properties.getProperty("test_owner");
	public static final String EditorRole = properties.getProperty("test_editor");
	public static final String ReaderRole = properties.getProperty("test_reader");

	//bluepages user
	public static final String BluepagesUsername = properties.getProperty("test_bluepage_username");
	public static final String BluepagesPassword = properties.getProperty("test_bluepage_password");
	
	
	
	
	
	
	/*public static final String LDAP_User_Name = "ajones";
	public static final String LDAP_User_Password = "jones";
	public static final String LDAP_User_Typeahead = "Jones";
	public static final String LDAP_UserName_withMailID1 = "<ajones";
	public static final String LDAP_UserName_withMailID2 = "@janet.iris.com>";
	
	//User Roles
	public static final String Owner_Role = "Owner";
	public static final String Editor_Role = "Editor";
	public static final String Reader_Role = "Reader";
	public static final String Anonymous_User = "Anonymous";
	public static final String Creator_Role = "Creator";
	public static final String Page_Creator_Role = "Page Creator";
	
	public static final String LDAP_Admin_Username = "ajones";
	public static final String LDAP_Admin_Password = "jones";
	public static final String LDAP_FullUsername = "Amy Jones";
	
	public static final String IC_LDAP_Admin_Username = LDAP_Admin_Username+"1";
	public static final String IC_LDAP_Admin_Password = LDAP_Admin_Password+"1";
	public static final String IC_LDAP_Admin_UserName_withMailID = LDAP_User_Name+"1" +LDAP_UserName_withMailID1+"66"+LDAP_UserName_withMailID2;
	public static final String IC_LDAP_Admin_Username_DisplayonMyWikitab = "Amy Jones1's Wikis";
	
	public static final String IC_LDAP_Username = LDAP_User_Name+"66";
	public static final String IC_LDAP_Password = LDAP_User_Password+"66";
	public static final String IC_LDAP_UserName_withMailID = LDAP_User_Name+"66" +LDAP_UserName_withMailID1+"66"+LDAP_UserName_withMailID2;
	public static final String IC_LDAP_Username_DisplayonMyWikitab = "Amy Jones66's Wikis";
	public static final String IC_LDAP_Username_Fullname = LDAP_FullUsername+"66"; 
	
	public static final String IC_LDAP_Username77 = LDAP_User_Name+"77";
	public static final String IC_LDAP_Password77 = LDAP_User_Password+"77";
	public static final String IC_LDAP_Username_Fullname77 = LDAP_FullUsername+"77";
	
	public static final String IC_LDAP_Username88 = LDAP_User_Name+"88";
	public static final String IC_LDAP_Password88 = LDAP_User_Password+"88";
	public static final String IC_LDAP_Username_Fullname88 = LDAP_FullUsername+"88";
	
	public static final String IC_LDAP_Username111 = LDAP_User_Name+"111";
	public static final String IC_LDAP_Password111 = LDAP_User_Password+"111";
	public static final String IC_LDAP_UserName111_withMailID = LDAP_User_Name+"111" +LDAP_UserName_withMailID1+"111"+LDAP_UserName_withMailID2;
	public static final String IC_LDAP_UserName111_Typeahead = LDAP_User_Typeahead+"111";
	
	public static final String IC_LDAP_Username222 = LDAP_User_Name+"222";
	public static final String IC_LDAP_Password222 = LDAP_User_Password+"222";
	public static final String IC_LDAP_UserName222_withMailID = LDAP_User_Name+"222" +LDAP_UserName_withMailID1+"222"+LDAP_UserName_withMailID2;
	public static final String IC_LDAP_UserName222_Typeahead = LDAP_User_Typeahead+"222";
	
	public static final String IC_LDAP_Username333 = LDAP_User_Name+"333";
	public static final String IC_LDAP_Password333 = LDAP_User_Password+"333";
	public static final String IC_LDAP_UserName333_withMailID = LDAP_User_Name+"333" +LDAP_UserName_withMailID1+"333"+LDAP_UserName_withMailID2;
	public static final String IC_LDAP_UserName333_Typeahead = LDAP_User_Typeahead+"333";
	
	public static final String IC_LDAP_Username444 = LDAP_User_Name+"444";
	public static final String IC_LDAP_Password444 = LDAP_User_Password+"444";
	public static final String IC_LDAP_UserName444_withMailID = "Amy Jones444 <ajones14@janet.iris.com>";
	public static final String IC_LDAP_UserName444_Typeahead = LDAP_User_Typeahead+"444";
	
	public static final String IC_LDAP_Owner_Username = LDAP_User_Name+"77";
	public static final String IC_LDAP_Owner_Password = LDAP_User_Password+"77";
	public static final String IC_LDAP_Owner_withMailID = LDAP_User_Name+"77" +LDAP_UserName_withMailID1+"77"+LDAP_UserName_withMailID2;
	public static final String IC_LDAP_Owner_DisplayonMyWikitab = LDAP_User_Name+"77's Wikis";
	public static final String Owner_Username_Typeahead = LDAP_User_Typeahead+"77";
	
	public static final String IC_LDAP_Editor_Username = LDAP_User_Name+"88";
	public static final String IC_LDAP_Editor_Password = LDAP_User_Password+"88";
	public static final String IC_LDAP_Editor_withMailID = LDAP_User_Name+"88" +LDAP_UserName_withMailID1+"88"+LDAP_UserName_withMailID2;
	public static final String IC_LDAP_Editor_DisplayonMyWikitab = LDAP_User_Name+"88's Wikis";
	public static final String Editor_Username_Typeahead = LDAP_User_Typeahead+"88";
	
	public static final String IC_LDAP_Reader_Username = LDAP_User_Name+"99";
	public static final String IC_LDAP_Reader_Password = LDAP_User_Password+"99";
	public static final String IC_LDAP_Reader_withMailID = LDAP_User_Name+"99" +LDAP_UserName_withMailID1+"99"+LDAP_UserName_withMailID2;
	public static final String IC_LDAP_Reader_DisplayonMyWikitab = LDAP_User_Name+"99's Wikis";
	public static final String Reader_Username_Typeahead = LDAP_User_Typeahead+"99";*/

	
}    
