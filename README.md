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

Future Enhancements:

1. Add error handling for if the cost of a car is queried whose registration does not exist
2. Provide POST methods to allow for updating of when cars are hired and returned
3. Remove hard-coding of pre-populated data. Data instead could come from an external source e.g. an SQL database
