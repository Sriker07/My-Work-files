Feature: Verify Logo OrangeHRM

Scenario: Logo name of OrangeHRM after Login

Given Launch chrome browser
And Navigate to URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
And There user log in through Login Window by using Username as "Admin" and Password as "admin123"
And Click on login button
Then login must be successful
And Orange Logo must be visible
When Click on log out
Then Log out must be successful
And Close the browser