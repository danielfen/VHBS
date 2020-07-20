# VHBS
Vehicle Hire Booking System

To start the application, run the following from the command line in the vhbs directory:
./mvnw spring-boot:run

Enter the following in to an internet browser:
<ul>
<li>http://localhost:8080/listForHire
<li>http://localhost:8080/listHired
<li>http://localhost:8080/calculateCost?reg=AB10%20XYZ&start=2020-07-20&end=2020-07-30
</ul>
calculateCost takes the following parameters:
<ul>
<li>reg - the vehicle registration
<li>start - the start date to calculate hire costs from (in format yyyy-MM-dd)
<li>end - the end date to calculate hire costs until (in format yyyy-MM-dd)
</ul>

The application is pre-populated with the following vehicles:
<ul>
<li>AB10 XYZ (Small Car, Available)
<li>AB11 XYZ (Small Car, Available)
<li>AB12 XYZ (Small Car, Available)
<li>AB13 XYZ (Estate Car, Available)
<li>AB14 XYZ (Estate Car, Available)
<li>AB18 XYZ (Van Car, Available)
<li>HI10 ZYX (Small Car, Hired)
<li>HI13 ZYX (Estate Car, Hired)
<li>HI18 ZYX (Van Car, Hired)
<li>HI19 ZYX (Van Car, Hired)
</ul>

Design:

Vehicles are represented by the 'Vehicle' class, with the attributes:

Registration, Category, Make, Model, Fuel, Price per day, Customer.

The only changeable attribute is Customer, which is only present if the vehicle is hired.

Category is represented via an enum - new categories of vehicle can be added to the system by simply adding them to this enum.

Fuel type is represented via an enum - new categories of fuel (e.g. electric) can be added to the system by simply adding them to this enum.

Prices of vehicles are fixed and stored within a static mapping of Vehicle. Prices changes can be made here, or preferably with future enhancements allowed to be dynamically updated.
<br>

The Stock class stores the company's stock of available and hired vehicles. This is currently pre-populated with demonstration data.
The StockController provides a Spring REST api for the available functions to query the stock.
<br>
<br>

Future Enhancements:

1. Add error handling for if the cost of a car is queried whose registration does not exist
2. Provide POST methods to allow for updating of when cars are hired and returned
3. Remove hard-coding of pre-populated data. Data instead could come from an external source e.g. an SQL database
4. Allow price to be dynamic
