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

The application is pre-populated with vehicles with the following registrations:
<ul>
<li>AB10 XYZ
<li>AB11 XYZ
<li>AB12 XYZ
<li>AB13 XYZ
<li>AB14 XYZ
<li>AB18 XYZ
<li>HI10 ZYX
<li>HI13 ZYX
<li>HI18 ZYX
<li>HI19 ZYX
</ul>
