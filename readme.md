# Gabi assignment
This repository contains java based application that executes e2e tests on Gabi's FE.
## Software pre-requisites
- maven
- Java8 RE
- chrome
## Running the app
Before starting anything - make sure that you have cloned or downloaded the repository to your local machine and you are checked out in your favourite CLI on the project's root.
### In headless mode
Make note, that you won't be able to see what is performed, as everything is going to be executed "under-cover"  
`mvn clean verify`
### Visible mode
@Windows  
`mvn clean verify -D"chrome.switches"=`
### Using Docker + Jenkins
##### Pre-requisites
- download and install docker for your system  
##### Running from docker container
`docker pull kbartnik1/assignment` <-- this might take a while.  
Afterwards `docker run -p 8080:8080 kbartnik1/assignment`
After just few seconds you can visit your localhost:8080 and you'll be able to run it from within the docker container. Select project gabi, and on the left hand side you can click on "Run" button. After execution, you can browse the report online by clicking on "Thucydides Test Report" link.
Note: this is just a PoC, thus I did not integrate it with vcs.

## Reporting
Every test execution leaves a nice looking report that can be viewed after opening /target/site/serenity/index.html file.
