![Logo](https://www.browserstack.com/images/static/header-logo.jpg)

# Manual To Automation @ Banco De Bogota - Lesson 2 - Simple Maven Example <a href="https://nodejs.org/en/"><img src="https://brandslogos.com/wp-content/uploads/thumbs/java-logo-vector-1.svg" alt="nodejs" height="22" /></a> <a href="https://nodejs.org/en/"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Apache_Maven_logo.svg/1200px-Apache_Maven_logo.svg.png" alt="nodejs" height="22" /></a>

## Introduction

This code provides the solution to the exercise given at the end of the second lesson in the Manual To Automation @ BDB training series. It is a simple Java and Maven application that uses Selenium Webdriver to open the BrowserStack website, find and interact with the login elements, and perform a succesful login.

---

## Installation

There are a few things that you will need before you can get started.

* Maven - use [this](https://maven.apache.org/install.html) guide for both Windows and Mac.
* Java JDK - You can download the JDK directly from the Oracle website [here](https://www.oracle.com/java/technologies/downloads/). This will allow you to run Java applications on your machine.
* Git for pulling down the code - follow [this]() guide for installing Git on all platforms. There are other useful guides on the website mentioned previously. Start [here](https://github.com/git-guides) anad follow through to the various links to learn more about Git. It will be very useful on your automation journey. If you have any issues with tokens or user credentials, let me know as this can trip a lot of people up.
* IntelliJ or Eclipse - Either is fine, it's really down to personal preference. You can download IntelliJ for free from [here](https://www.jetbrains.com/idea/download/). You can download Eclipse from [here](https://www.eclipse.org/downloads/) .These are very useful tools for writing and running your code as they have auto complete, and powerful debugging capabilities.
* ChromeDriver - this is the web driver that will be used to open Chrome and do the test locally. You can download it from [here](https://chromedriver.chromium.org/downloads). Remember to grab the version that matches your installed browser.

Once you have these installed, you are good to go to the next step.

Follow the below steps to get the code onto your local machine.

* Open a terminal. (Terminal on Mac, Command Prompt on Windows)
* Go to the directory where you want to place the code using [cd](https://docs.microsoft.com/en-us/windows-server/administration/windows-commands/cd) for Windows, and it functions mostly the same for Mac. You just use "cd" but the folder structure on Mac is different (/Users/username/Documents instead of C:/Users/username/Documents)
* Copy the following command into the terminal, (remember, you must have [Git](https://git-scm.com/downloads) installed)
```sh
git clone https://github.com/Manual-To-Automation-Browserstack/Sky-Lesson-2-Selenium.git.
```
* Move into the directory that you just cloned by typing
```sh
cd Sky-Lesson-2-Selenium
```
* To run your test, you can use the Run button in your IDE of choice.

## Available Tests

This repository contains the following Java tests:

| Module                                  | Test name    | Description                                                                                                                             |
|-----------------------------------------|--------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| BrowserStack Login on Local WebDriver   | Simple Login | This test runs using the maven dependency of selenium-webdriver to set up a local Chrome driver and sign into the BrowserStack website. |
| BrowserStack Login on BrowserStack grid | Simple Login | This test is the same as the first but it uses BrowserStack to open the webpage remotely.                                               |
  
---

# BrowserStack

[BrowserStack](https://browserstack.com) provides instant access to 2,000+ real mobile devices and browsers on a highly reliable cloud infrastructure that effortlessly scales as testing needs grow.

## Prerequisites

- Create a new [BrowserStack account](https://www.browserstack.com/users/sign_up) or use an existing one.
- Identify your BrowserStack username and access key from the [BrowserStack Automate Dashboard](https://automate.browserstack.com/) and export them as environment variables using the below commands.

    - For \*nix based and Mac machines:

  ```sh
  export BROWSERSTACK_USERNAME=<browserstack-username> &&
  export BROWSERSTACK_ACCESS_KEY=<browserstack-access-key>
  ```

    - For Windows:

  ```shell
  set BROWSERSTACK_USERNAME=<browserstack-username>
  set BROWSERSTACK_ACCESS_KEY=<browserstack-access-key>
  ```

  Alternatively, you can also hardcode username and access_key objects in the code but this is NOT recommended.
