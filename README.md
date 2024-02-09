##### Playwright-Java Framework

	/**
	 * Playwright hierarchy: create Playwright object --> Browser object --> Page
	 * object -->
	 */


##### How to download the binaries using CMD:
	There are three drivers:
		- chrome
		- firefox
		- webkit
		
##### Install browsers: [Playwright can install supported browsers. Running the command without arguments will install default browsers](https://playwright.dev/java/docs/browsers#install-browsers)
	- mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install-deps"
	

##### Why Playwright website used **try-with-resources** to instantiate the object creation	
The try block you’re referring to is known as a try-with-resources statement in Java. It’s a special kind of try statement that ensures that each resource declared in the try is closed at the end of the statement.

Playwright playwright = Playwright.create() is the resource. The advantage of using this sort of try block is that it automatically closes the Playwright object once it’s no longer needed. This helps to prevent resource leaks and makes your code cleaner and more robust.

It’s particularly useful when dealing with resources that must be closed after use, such as files, network connections, or, in this case, a browser instance controlled by Playwright. If you didn't use a try-with-resources statement, you would have to manually close the Playwright object in a finally block, which can be error-prone.

	- The advantages of using *try-with_resources* are:

	- Automatic resource management: The runtime system automatically closes the resources at the end of the statement, which helps prevent resource leaks.
	- Improved code readability: The syntax of the try-with-resources statement is more concise and clear, making the code easier to read.
	- Better exception handling: The try-with-resources statement ensures that each resource is closed in reverse order from which they were created, even if exceptions are thrown, providing better exception handling.
	

###### How to install driver binaries with CLI:
	mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install msedge-dev"
	
	
	
###### How to run codegen to run the text
	- mvn exec:java -e -D exec:mainClass=com.microsoft.playwright.CLI -D exec.args="codegen <test-site-url>"
	above code will open the browser, and generate code for us
	