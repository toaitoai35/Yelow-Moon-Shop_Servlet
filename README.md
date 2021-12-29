# Yelow-Moon-Shop_Servlet
J3.L.P0019. Yelow Moon Shop_Servlet 500
Title: Yellow Moon Shop
Background
Yellow Moon shop is an online shop selling moon cakes.
Program Specifications
Build a website that sells moon cakes. The website supports online payment or cash payment upon delivery. You
must use Servlet as Main Controller and follow MVC2 model.
Features:
This system contains the following functions:
- Function 1: Login – 50 LOC
o In order to tracking your order, an authentication is required.
o If the user has not authenticated, the system redirects to the login page.
o The actor enters userID and password, the function checks if the userID with the password is in the
available user list, then grant the access permission. If not, a message would appear to notify that user is
not found.
o Login function includes logout and welcome functions.
- Function 2: Search Cakes – 50 LOC
o List first 20 available items in the system order by date (status is active and quantity greater than 0). Paging
is required to use.
o Each Cake has a name, image, description, price, createDate, expirationDate, category, …
o User can find the Cake based on name or range of money or category.
o All users can use this function (login is not required)
- Function 3: Update Cake – 50 LOC
o The list of first 20 Cakes will be displayed (order by date). The Cake category and the Cake status will show
in combo box (drop down list) form. Paging is required to use.
o Update information of the selected Cake: name, image, price, category, quantity, createDate,
expirationDate, status...
o Update list Cake after update.
o The system must record the last update date, last update user.
o Only Admin role has permission to do this function.
- Function 4: Create Cake – 50 LOC
o This function allows user to create new Cake.
o Create date and expiration date fields must use date component.
o The default status of new Cake is active.
o Only Admin role has permission to do this function.
- Function 5: Shopping – 150 LOC
o Add the selected Cake to shopping cart. The default quantity is 1.o Each user can buy any available Cake in the list.
o User can view the selected Cake in the cart. For each Cake: Cake name, amount, price, total. The screen
must show the total amount of money of this cart.
o User can remove the Cake from the cart. The confirm message will show before delete action.
o User can update amount of each Cake in cart.
o Click the Confirm button to store the Cake to database (must store the buy date time). The warning
message will show if the selected Cake is out of stock. System will return and show orderID for tracking.
o Login is not required. If viewer not login then viewer must input the information for shipping (phone
number, name, address, …)
o The default payment is cash payment upon delivery.
o All user can use this function except Admin role
- Function 6: Order Tracking – 50 LOC
o User can track their orders by orderID.
o User inputs the orderId and click Search to tracking their order.
o The screen must show the information of the order: User Name, orderID, orderDate, list of cakes, payment
method, payment status, shipping address,
o Login is required.
- Function 7: Integrate online payment – 50 LOC (extra)
o User can pay online via Paypal.
- Function 8: Login extra – 50LOC (extra)
o Integrated login using Google email.
* The above specifications are only basic information; you must build the application according to real requirements.
* You have to build your own database.
* The lecturer will explain the requirement only once on the first slot of the assignment.
