# Car_Multithread_MVC

CRUD - Create Read Update Delete MVC - Model View Controller

This application is of simple CRUD operations such as :

1. Add Car
2. Search Car
   
_**Steps to run this Standalone Application :**_

Step 1: Download this file, Unzip it.

Step 2: Import it in your IDE. Make sure your IDE supports java. (JDK)

Step 3: Have a related database.

   ~ My database Name: car_db      
   
   ~ Consists of 2 tables, user table is for login credentials. 
        user:
      ---------------------
      | name  | password  |
      ---------------------     
      |       |           |

   ~ cars table is to perform CRUD operations.
        cars:
      ----------------------------------------------------------------------------------------------------------------------------------------
      | Customer_Name | Mobile_Number | Gender | City | Budget | Brand_Name | Model_Name | Price_in_lakh | Fuel | Mileage | Seating_Capacity |
      ----------------------------------------------------------------------------------------------------------------------------------------
      |               |               |        |      |        |            |            |               |      |         |                  |

Step 4: Make sure about mysql-connector-java-8.0.26.jar in your Referenced Libraries (use supporting version).

Step 5: Finally, set DbUtil inside the package com.botree.util

Step 6: Thats it! Run as Java application.

