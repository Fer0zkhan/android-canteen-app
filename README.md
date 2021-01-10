# android-canteen-app

### Here is main modules of our application

## 1 -> Admin
-Login: Admin need to login using valid login credentials to access the system.
-Add Canteen: Admin will add a canteen with details like Management Name, Handler, Mobile, No. of Workers and Address.
-View/Edit/Delete Canteen: Added canteens can be manageable by the admin.
-Add Students:  System allows admin to register new students with their details and create a valid login id and password and share with the student.
-View/Edit/Delete Students: Admin can manage all the added students by viewing, editing and deleting a student
-Add Balance: A registered student can Load their wallet by paying cash to admin, which will be added to their wallet account
-Withdraw: Check student's account and withdraw amount) & Same for canteen 

## 2 -> Canteen
-Login: Canteen person need to login using valid login credentials to access the system.
-Add Items: A canteen person can add new food items by specifying details like Food name, Items description, cost, time to get ready, etc
-View/Edit/Delete/Enable Items: All the added food items will be manageable by the canteen person and if the item is not available in the canteen then it gives an option to disable the food Item.
-View New Orders: Can view all the orders received from the registered students.
-Update Status: Can update the order details
-View Transactions: Can view all the transactions by selecting the date range and search all the transactions.
-Add Balance: A canteen person can add balance into student’s wallet, which will be paid via cash by the student
-Withdraw: Only student can withdraw whenever required.

## 3 - Student
-Login: Students need to login using valid login credentials provided by admin to access the system
-View Menu: Students can order any food item from the menu.
-Review & Place Order: Before placing an order, a review of order will be displayed and then student can proceed to pay. If wallet has low balance, then a student cannot make rest of payment via card.
-Add Balance: Students can add balance to their wallet via card.
-View Transactions: AStudent can view all their transactions done to place orders. 
