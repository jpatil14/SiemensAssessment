Assessment Test Engineer Mendix
===============================

Introduction
------------

This assessment consists of two assignments. Each assignment is intended to give
insights on your skills.

Please read the exercises carefully. If you have any questions at all, do not
hesitate to contact us.

After completing the exercises, please upload the assignment to private github repo and invite us.

In your one of the coming interviews we will discuss your results. The focus will be on your
reasoning and chosen methodologies when tackling the assignment. We will conclude
the interview with an exercise in exploratory testing.

Please treat this exercise as confidential so that we can reuse it for any
future candidates.

Good luck and please enjoy!



The Pet Clinic
--------------

### Background information

Mendix has a customer, *PetVets Inc. – a Pet Clinic*, that uses Mendix to create
and maintain an online booking system for their customers. You are working as a
member of the Mendix Expert Services team. *PetVets Inc.* contacted Mendix to
help them with this specific customer, because they are struggling with
development. Your assignment is to consult with the PetVets Inc. development
team to make the PetVets app fly.

Last year they released the following:

-   Website with calendar to make appointments

-   Availability overview of employees, rooms and equipment.

-   Customers can consult this overview as well

-   Email, SMS and Slack reminders for customers and Employees when an
    appointment is made.

-   Online payments with PayPal

-   Overview of the customers (CRM)



**The PetVets Inc. Scrum Team**

The development team consists of a single scrum team with 5 developers, 1 Test
engineer and a Product Owner. The team has faced some tough luck last year and
the motivation level is below zero.

During the Retrospective the team states they have lost confidence in the
product. There are bugs in the product that show a lack of testing by both
developers and testers. Besides that, there are very unclear requirements, and the
Product Owner has a hard time satisfying the stakeholders, who keep pressing
him.

The last two releases had to be rolled back, because of unpredicted behavior of
the product.

The team thinks that the stakeholders demand too much and are unreasonable with
deadlines. The result is a poor quality product and a decrease in motivation in
the team.

### Exercise description

The team is willing to give it a one last try. Their goal is to restore faith in
the product and the quality they deliver. You are asked to join the team as
second Test Engineer. You will join the team for at least a month and will be part
of the team for the next two sprints. The duration of a sprint is two weeks.

For the next sprint planning, the following 6 stories are on top of the Product
Backlog and are within the average velocity of the team. Before you start, the
development team provides with these stories, so you can prepare and give some
feedback in advance. Before the sprint starts you will have a meeting with the
team.



**User Story 1**

As a Pet Owner  
I want to view available time slots So I can make a new appointment as quick as
possible

*Acceptance criteria:*

-   Should work in IE and Firefox

-   Appropriate candidate should be presented in details

-   Build a user friendly interface for searching

Table Mockup

| Search query:                   | Search results:                   |
|---------------------------------|-----------------------------------|
| Start date/time: [ inputfield ] | Timeslot 1 (Details Veterinarian) |
| End date/time:   [ inputfield ] | Timeslot 2 (Details Veterinarian) |
|                                 | Timeslot 3 (Details Veterinarian) |
|                                 | Timeslot 4 (Details Veterinarian) |



**User Story 2**

As a Pet Owner I want to create a new appointment myself

*Acceptance criteria: *

-   Start and End time must be filled in

-   User can select Veterinarian

-   User can select Space and Equipment



**User Story 3**

As a Pet Owner  
I want to edit a new appointment

*Acceptance criteria:*

-   Start and End time can be changed

-   User can select different Veterinarian

-   User can select Space



**User Story 4**

As a Veterinarian
I want to cancel my appointment

*Acceptance criteria:*

-   Veterinarian must be notified by SMS or email  



**User Story 5**

As a Developer  
I want to remove the Hibernate layer out of the searching calls  
So adding new queries will be easier

*Acceptance criteria:*

-   Online Payment components should be able to register

-   No iFrames allowed!



**User Story 6**

As a Developer  
I want to refactor the current implementation of the consult overview So that it
will be a better maintainable

*Acceptance criteria:*

-   The user should not notice anything




### Exercise 1: Prepare the Sprint

PetVets Inc has scheduled a pre-sprint team meeting. During this meeting you are
expected to share your thoughts and suggestions on the current situation of the
team and on how to approach the upcoming sprint(s).

Try to be concise but complete. Pay attention to:

-   What were your findings from reviewing/inspecting the stories?
	1. Usually pre-sprint meeting is also called as Sprint Grooming meeting where team(Dev/Test) clarify all the technical doubts related stories with product owner,BA etc and then if time permits team estimates the stories too so that during Sprint Planning meeting new sprint can be created quickly.
	2. As a new test engineer to team, I would like to ask questions like what was the previous sprint capacity/velocity of the team?, Does team hold Sprint Demo call at the end of the sprint?, As a test automation engineer, Am i supposed to write manual TC first and then automate it or will there be anyone who will provide me the TC to automate?
	3. I would like to get more information about stories like UI screenshots of new pages/fields, Are there any other user roles need to be tested with same stories?, Are these stories needs to be tested on Dev env too?

-   What would you ask from the Product Owner/Dev Team?
	1. To Dev Team - As a new Test Engineer in team, i would like to gain knowledge about application from Devlopers perspective so that i can understand the core/business logic behind the application. Also i will try to build up a good rapo with dev team so that in future i can reach out to them anytime to resolve test teams queries.
	2. To Product Owner - First of all i will try to understand the application from PO's perspective and then i would like to ask PO about various challenges team faced in past and what were the exact reasons that team couldnt deliver the expectations.
	

-   Where do you see yourself and the other Test Engineer in the process?
	1. As a new test engineer in the team, I would like to get KT of application from other test engineer? Also would like to understand the current scrum process and team introduction from other Test Enginner.
	2. As a new Test enginner in team, I understand management is having expectations from me and i need to give my 100% to make it happen.
	3. As a new Test enginner in team, I would expect initial support from other Test Engineer incase of any difficulties to understand the application/process.

-   How will you interact with the team during the sprint?
	1. I would like to sit with Dev and Test team together so that queries would be resolved quickly but incase thats not possible I would prefer daily syncup call with other Test Enginner and may be biweekly/weekly call with Dev Team/Product Owner if I come across any issues (Provided they have time).
	2. Ofcourse would like to communicate through slack/skype/teams channel with my teammates.


### Exercise 2: Review code and implement a feature

#### Exercise 2a: Review the code from the Shopping Cart Application

You are asked to review the code from the shopping cart application and provide
feedback to the developers. They know you are not a code ninja, but want to get
some sensible feedback. Additionally they made the effort to write some unit
tests and they are interested in your input.

When doing so, pay attention to:

-   Clarity of the code
	1. I could see the description is missing for functions/classes/tests. Description/comments in code helps to understand the code quickly.
	2. add2() function is not giving clarity behind its objective.The function name should be descriptive.
	3. Funtion name should start with small case character.Fount one function as "TotalPrice" which should be written as totalPrice.I have renamed it to totalPriceBeforeDiscount().

-   What has been tested?
	1. OrderTest class is testing functionalities like,
		- Shopping cart should have mutltiple items - Failing
		- System should be able to create an prder for customer - Passing
		- System should update amount of a product in cart - Nullpointer exception as orderline object is not getting initialized in constructor calling of Order() class
		- System should create an order from a product - Nullpointer exception as orderline object is not getting initialized in constructor calling of Order() class
		- Order should be attached to customer - Passing
		- It_should_fail_after() - 	Failing - Expected is IndexOutOfBoundsException excpetion
-   What is missing?
		- System should_apply_discount_when_order_total_greater_than_20_euros - not implemented
		- customer Can Place One Item In Shooping Cart - No Test tag found

#### Exercise 2b: Coding exercise

The team decided to iterate on the Discount feature.  
You are asked to change the current code base and make sure this feature is
implemented & tested properly according to the following requirement:


**Requirement: Offering Discount**

We offer discount of 5% to the customer when the total price of the Order is
equal or greater than 20,00 EUR.

When doing so, pay attention to:

-   Clarity of the code

-   Unit tests

-   What else would you test?
	1. I would set the customer with Order first
	2. Then if my total price of added product is >=20.0, then i will calculate 5% discount and compare the discounted price.


#### Tooling
We recommend using an IDE for this exercise. If you're not sure which one to use:
- C#: Visual Studio 2017 (Community Edition), https://www.visualstudio.com/vs/community/
- Java: IntelliJ Community Edition, https://www.jetbrains.com/idea/download
