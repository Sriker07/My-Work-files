Feature: Login GNTC alpha1

Scenario: Login and Log out 
Given Launch chrome browser
And Navigate to URL "https://alpha1.giantfoodstores.com/"
And Navigate to profile link
And Click on Sign in
And There user log in through Login Window by using Username as "tdm_gntc+34263021_tdm@test.com" and Password as "Test1234"
And Click on login button
Then login must be successful
And Navigate to profile link
When Click on log out
Then Log out must be successful
And Close the browser