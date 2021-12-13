Feature: Create Legal Entity Feature

Scenario Outline: Login with Salesforce

Given Launch the Browser
Given Launch the Salesforce application with URL "https://login.salesforce.com"
When Enter the <username> and <password>
Then Salesforce Home page should be opened successfully
And Close the Browser

Examples:
|username|password|
|"fullstack@testleaf.com"|"SelBootcamp$123"|