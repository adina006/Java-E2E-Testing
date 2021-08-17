Introduction: 
It's a simple test automation project created using Java, selenium web driver. Used Maven built tool, TESTNG framework. Created testng framework using page object pattern;



Test Architecture: In my project you will see folowing items: 





Under scr/main/java I have used 




test base - include the most basic method that I will use everytime before my test starts, or after my test is excuting;




Constant - I have achieved globlazation in there; Like URL, timeouts, getProperties;





Factories - I have used page factory in my project in order for me to call my method in a easy and fast way



Pages - different pages for automating my test cases, to make it more clear; 




Utils - Under utils I will attached some common used method, in this case I don't have to repeat them in all of my tests; I have JDBC, EXCEL; SELENIUM AND LOG4J helper;



![main](https://user-images.githubusercontent.com/89051877/129811488-a23266e0-ec4d-4516-969a-bedee2efec47.PNG)




Under scr/main/test I have used



Flights test- this is for book tickets



Login test - using negative testing and excel datas to login; 



LinkTest - open links under footer session and get the title of each of them




Excel Test; Log4j Test; JDBC test --- Just simply show that I am able to implement them in my project



![test](https://user-images.githubusercontent.com/89051877/129811501-2ac51719-dd9c-4520-8116-3cd3e9b0767e.PNG)




TestNG.xml to achieve parallel testing







![testngxml](https://user-images.githubusercontent.com/89051877/129812428-2953d9f9-8800-4eca-bbee-6f8bd04bff0d.PNG)










