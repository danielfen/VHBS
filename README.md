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
