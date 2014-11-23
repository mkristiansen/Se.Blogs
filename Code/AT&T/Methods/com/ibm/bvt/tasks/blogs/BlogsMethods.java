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

package com.ibm.bvt.tasks.blogs;

//import com.ibm.automation.bvt.setup.common.Initialize;
import com.ibm.bvt.appobjects.blogs.BlogsData;
import com.ibm.bvt.appobjects.blogs.BlogsObjects;
import com.ibm.bvt.appobjects.common.CommonData;
import com.ibm.bvt.appobjects.common.CommonObjects;
import com.ibm.bvt.tasks.common.CommonMethods;
import com.ibm.bvt.tasks.common.FormInputHandler;
import com.thoughtworks.selenium.*;
import java.lang.Object.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.*;
import org.junit.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class BlogsMethods extends CommonMethods {

	private FormInputHandler typist = getFormInputHandler();

	public void CreateABlogAsAdmin(String BlogsName, String BlogsAddress) throws Exception {
		// Enter the details for the blogs
		typist.type(BlogsObjects.BlogsNameField, BlogsName);
		typist.type(BlogsObjects.BlogsAddress, BlogsAddress);
		typist.type(BlogsObjects.BlogsTags, BlogsData.BlogsTag);
		typist.type(BlogsObjects.BlogsDescription, BlogsData.BlogsDescription);
		selenium.select(BlogsObjects.BlogsTimeZone, BlogsData.BlogsTimeZoneOption);
		sleep(500);
		selenium.select(BlogsObjects.BlogsTheme, BlogsData.BlogsThemeOption);
		sleep(500);
		// Save the form
		FormSaveButton(CommonObjects.SaveButton);

		
	}
	
	public void SetBlogAsPrimary(String BlogsName) throws Exception{
		// Set as default
		clickLink(BlogsObjects.BlogsSetAsPrimaryBlog);

		// Verify the change
		assertTrue(selenium.isTextPresent("You have set ["+BlogsName+"] to be your primary blog"));

	}

	public void ChangeAdminSettings() throws Exception {
		// Click on Admistration
		clickLink(BlogsObjects.Administration);

		// Edit the Handle of Blog to server as Blogs Homepage
		selenium.type(BlogsObjects.BlogsSiteSettingsHandleOfBlog, BlogsData.BlogsHandleOfBlog);

		// Save the change
		clickLink(BlogsObjects.BlogsSiteSettingsSave);

		// Verify the change
		assertTrue(selenium.isTextPresent("Change saved."));
	}

	public void CreateABlogAsStandardUser(String BlogsName, String BlogsAddress) throws Exception {
		// Enter the details for the blogs
		typist.type(BlogsObjects.BlogsNameField, BlogsName);
		Thread.sleep(500);
		typist.type(BlogsObjects.BlogsAddress, BlogsAddress);
		Thread.sleep(500);
		typist.type(BlogsObjects.BlogsTags, BlogsData.BlogsTag);
		Thread.sleep(500);
		typist.type(BlogsObjects.BlogsDescription, BlogsData.BlogsDescription);
		Thread.sleep(500);
		selenium.select(BlogsObjects.BlogsTimeZone, BlogsData.BlogsTimeZoneOption);
		Thread.sleep(500);
		selenium.select(BlogsObjects.BlogsTheme, BlogsData.BlogsThemeOption);
		Thread.sleep(500);
		// Save the form
		FormSaveButton(CommonObjects.SaveButton);
	}

	public void CreateANewBlogEntry(String BlogsName, String BlogEntryName, String TextToEnter) throws Exception {
		// Select the blog that you just created
		clickLink("link=" +BlogsName);
		Thread.sleep(1000);
		
		//Ensure that the focus is on the browser window
		selenium.selectWindow("null");

		// Click on the New Entry button
		clickLink(BlogsObjects.BlogsNewEntry);

		// Fill in the form for new entry
		typist.type(BlogsObjects.BlogsNewEntryTitle, BlogEntryName);
		Thread.sleep(500);
		clickLink(BlogsObjects.BlogsNewEntryAddTags);
		typist.type(BlogsObjects.BlogsNewEntryAddTagsTextfield, BlogsData.BlogsNewEntryTag);
		clickLink(BlogsObjects.BlogsNewEntryAddTagsOK);
		Thread.sleep(500);
		TypingInEditor(TextToEnter);
		clickLink(BlogsObjects.BlogsNewEntryPost);
		
	}
	
	public void TypingInEditor(String TextToEnter)throws Exception {
		/*
		 * Method that will enter text into the CKEditor
		 */
		
		//Ensure that the focus is on the browser window
		selenium.selectWindow("null");
		
		//Ensure that the Rich Text tab has focus and then tab into the editor area
		selenium.focus(BlogsObjects.BlogsNewEntryRich);
		Thread.sleep(1000);
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_TAB));
		Thread.sleep(1000);
		typeNative(TextToEnter);
		Thread.sleep(500);
		
		/*//Native Selenium key press events
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_T));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_H));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_I));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_S));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_SPACE));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_I));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_S));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_SPACE));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_A));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_SPACE));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_T));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_E));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_S));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_T));*/
	
	}

	public void CreateANewBlogEntryWithImage(String BlogEntryName, String TextToEnter) throws Exception {
		// Select the blog that you just created
		// clickLink("link="+BlogsData.BlogsName);
		// Thread.sleep(1000);

		// Click on the New Entry button
		clickLink(BlogsObjects.BlogsNewEntry);

		// Fill in the form for new entry
		selenium.type(BlogsObjects.BlogsNewEntryTitle, BlogEntryName);
		Thread.sleep(1000);
		if (CommonObjects.TestBrowser.contains("iexplore")) {
			selenium.mouseDown(BlogsObjects.BlogsCKEInsertImageButton);
			selenium.mouseUp(BlogsObjects.BlogsCKEInsertImageButton);
			Thread.sleep(2500);
			selenium.click(BlogsObjects.BlogsCKEInsertFromRecent);
			Thread.sleep(1000);
			selenium.click(BlogsObjects.BlogsCKEChoosePhoto);
			Thread.sleep(1000);
			selenium.click(BlogsObjects.BlogsCKEInsertButton);
			
		} else if (CommonObjects.TestBrowser.contains("googlechrome")) {
			/*
			 * Will need to come back to this on chrome at a later stage
			 * as I could not get the code to work to open the Choose File 
			 * dialog and then select a image - working on IE & FF
			 */
			
		}
		else{
			selenium.click(BlogsObjects.BlogsCKEInsertImageButton);
			Thread.sleep(2500);
			selenium.click(BlogsObjects.BlogsCKEInsertFromRecent);
			Thread.sleep(1000);
			selenium.click(BlogsObjects.BlogsCKEChoosePhoto);
			Thread.sleep(1000);
			selenium.click(BlogsObjects.BlogsCKEInsertButton);
			
		}
		//Enter some text in the editor 
		TypingInEditor(TextToEnter);
		
		Thread.sleep(2500);
		selenium.focus(BlogsObjects.BlogsNewEntryPost);
		clickLink(BlogsObjects.BlogsNewEntryPost);
	}

	public void AddACommentToEntry() throws Exception {
		// Click on the Add a comment link for entry
		clickLink(BlogsObjects.BlogsAddACommentLink);

		// Fill in the comment form
		selenium.type(BlogsObjects.BlogsCommentTextArea, BlogsData.BlogsCommentText);

		// Submit comment
		clickLink(BlogsObjects.BlogsCommentSubmit);

	}

	public void BlogsFileUpload(String FileUploadName) throws Exception {
		// Click on the Settings button
		clickLink(BlogsObjects.BlogsManageBlog);
		
		clickLink("link=File Uploads");
			
		if (CommonObjects.TestBrowser.contains("googlechrome")) {
			/*
			 * Will need to work on this further as can not upload with
			 * Chrome currently!!
			 */
		} else{
			//Tab into the field
			TabToBrowse();

			InsertImageToEntry(FileUploadName);

			clickLink(BlogsObjects.BlogsFileUploadButton);
			
			CheckForNoFilesUploaded(FileUploadName);
		}
	}

	public void BlogsVerifyUIMessage(String UIMessage) throws Exception {

		// verify that the blog was created
		assertTrue(selenium.isTextPresent(UIMessage));

	}
	
	public void CheckForNoFilesUploaded(String FileUploadName) throws Exception{
		if (selenium.isTextPresent("You have chosen no files to upload")){
			//Close the message dialog
			clickLink(CommonObjects.OKButton);
			
			//Ensure that the focus is on the Upload button
			selenium.focus(BlogsObjects.BlogsFileUploadButton);
									
			//Then tab back to browse button
			selenium.keyDownNative(String.valueOf(KeyEvent.VK_SHIFT));
			selenium.keyDownNative(String.valueOf(KeyEvent.VK_TAB));
			selenium.keyUpNative(String.valueOf(KeyEvent.VK_TAB));
			selenium.keyUpNative(String.valueOf(KeyEvent.VK_SHIFT));
			Thread.sleep(500);
			selenium.keyDownNative(String.valueOf(KeyEvent.VK_SPACE));
			selenium.keyUpNative(String.valueOf(KeyEvent.VK_SPACE));
			//selenium.keyDownNative(String.valueOf(KeyEvent.VK_SPACE));
			//selenium.keyUpNative(String.valueOf(KeyEvent.VK_SPACE));
			Thread.sleep(2000);	
			
			//Enter the image name & location
			InsertImageToEntry(FileUploadName);

			//Upload file
			clickLink(BlogsObjects.BlogsFileUploadButton);
			Thread.sleep(1500);	
		}else{
			
		}
		
	}
	
	public void TabToBrowse() throws Exception{
		selenium.selectWindow("null");
		Thread.sleep(1000);
		selenium.focus("link=File Uploads");
		selenium.focus("link=File Uploads");
		Thread.sleep(1000);
		try{
			int count = 1;
			while (count < 5){
				Thread.sleep(500);
				selenium.keyDownNative(String.valueOf(KeyEvent.VK_TAB));
				selenium.keyUpNative(String.valueOf(KeyEvent.VK_TAB));
				Thread.sleep(500);
				count++;
			}
			selenium.keyDownNative(String.valueOf(KeyEvent.VK_SPACE));
			selenium.keyUpNative(String.valueOf(KeyEvent.VK_SPACE));
			Thread.sleep(1500);	
		}catch (Exception e){
			
		}
	}

	public void InsertImageToEntry(String FileUploadName) throws Exception {
		// For adding Images
		if (CommonObjects.TestOS.contains("Windows")) {
			typeNative(CommonData.WindowsFileLocation+FileUploadName);
			Thread.sleep(500);
		}else{
			typeNative(CommonData.LinuxMacFileLocation+FileUploadName);
			Thread.sleep(500);
		}
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_TAB));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_TAB));
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		Thread.sleep(2000);
		
	}
}
