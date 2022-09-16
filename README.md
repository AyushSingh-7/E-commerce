# E-commerce
A full stack project built using <br>:
<b>backend: Spring boot, Java , Mysql MongoDB, Elastic Search<br></b>
<b>frontend: Vue.js, html, css, javascript</b>

This Full stack project has various functionalities like:<br>
1.User registration and login Authentictaion.<br>
2.A recommended list(recommendation decided in backend) of products on home screen.<br>
3.category wise viewing of product.<br>
4.Search option to search across products.<br>
5.A products discription page with access to cart.<br>
6.add to cart and buy options.<br>
7.user information and order history of that user.<br>
8.In cart No duplictaion of product happens insted the quantity is added and substracted as per user's choice.<br>
9.total cart price is displayed.<br>
10.A mail is sent on successful purchase.<br>


<h1>Home Page<h1>
<img width="1440" alt="Screenshot 2022-08-24 at 11 22 43 PM" src="https://user-images.githubusercontent.com/64305346/186679633-6b600ce0-c2c4-49a9-bc0c-f91a691534d0.png">
<img width="1440" alt="Screenshot 2022-08-24 at 11 23 09 PM" src="https://user-images.githubusercontent.com/64305346/186679683-f4dfc772-5af0-4c1f-a43d-7e9f96c2658a.png">
<img width="1440" alt="Screenshot 2022-08-24 at 11 23 18 PM" src="https://user-images.githubusercontent.com/64305346/186679690-60567d26-f56f-403b-be4c-3061fa98a288.png">
<h1>products page (main page)</h1>
<img width="1440" alt="Screenshot 2022-08-24 at 11 23 26 PM" src="https://user-images.githubusercontent.com/64305346/186679693-da6f76e5-9105-4814-b23c-04daeffe6b69.png">
<h1>Search Function(Elastic Search)</h1>
<img width="1440" alt="Screenshot 2022-08-24 at 11 23 51 PM" src="https://user-images.githubusercontent.com/64305346/186679699-0c93268b-3cb0-46b4-824b-1b84f65810ea.png">

<img width="1440" alt="Screenshot 2022-08-24 at 11 24 08 PM" src="https://user-images.githubusercontent.com/64305346/186679703-36e2f3c4-f8c7-4ad3-ad8b-4c17c7a17ae1.png">

<h1>Account details and order History </h1>
<img width="1440" alt="Screenshot 2022-08-24 at 11 25 47 PM" src="https://user-images.githubusercontent.com/64305346/186679704-4a7d1396-3de9-4cce-bc7b-d935c4763cce.png">
<h1>Cart</h1>
<img width="1440" alt="Screenshot 2022-08-24 at 11 26 16 PM" src="https://user-images.githubusercontent.com/64305346/186679705-520ad35b-17f6-4425-8e01-50066fd82ac9.png">
<h1>Product discription page</h1>
<img width="1440" alt="Screenshot 2022-08-24 at 11 27 13 PM" src="https://user-images.githubusercontent.com/64305346/186679712-4a00f5c2-8412-4cfc-a964-0dcad1b6230d.png">
<h1>successful purchase</h1>
<img width="1440" alt="Screenshot 2022-08-24 at 11 32 36 PM" src="https://user-images.githubusercontent.com/64305346/186679714-c6df1208-973b-4822-a8dc-41ca4547f6d1.png">
  
  
  
  
  
  
  	
	
E-commerce Documentation 

Microservices: 
service 1 - login service 
service 2 - catalogue service ( products) 
service 3 - orders & cart service 
service 4 - search 
service 5 - Merchant 
   
Schema: 
Products: (MySQL) 
Id - pk 
Name 
Merchant id 
Catalog Name 
Category Name 
Price 
Strike price 
Usp 
Description  
Quantity 
Rating 
Rating count 
attributes  - one to many 
Image - link   
   
Merchant: (MySQL) 
Id - pk 
Name 
Rating 
Total products 
Sold products(orders) 
   
Orders: (MySQL) 
Id - pk 
cart id - fk 
Bill-amount 
Rating 
   
Customer: (MongoDB) 
Customer Id - string 
Name 
Email Id 
Address 
Contact number   
   
Cart: (MongoDB) 
Cart Id 
Product Id  
Customer Id 
Quantity 
Incart 
Billing Amount 
 
Search: Elastic Search 
   
Authentication: (MySQL) 
Email Id 
Password 
isMerchant – boolean 
isCustomer- boolean   
List of pages 
   
iOS, UI and android (Customer side) 
1. Home page  
2. Login page  
3. SignUp page  
4. Product List page  
5. Product details page  
6. Cart  
7. Conformance of order  
   
UI (Merchant side) 
1. Home Page  
2. Form page  
3. Submission successful page  
   
API Calls 
1. Product list fetching (GET) - products and merchant   
2. Search (Elastic search) - search  
3. Registering a new customer (POST) - login  
4. Registering a new product by merchant (POST) - login  
5. Updating the cart (GET) - orders and carts   
6. Adding to the cart (POST) - orders and carts   
7. Sending confirmation Email - orders and carts  
 
 
 
Catalog: 
 
1. Electronics:  TV    Mobile Phones   AC   Washing Machine   Kitchen Appliances      
2. Sports:  Cricket   Badminton   Swimming   Football   Skating      
3. Furniture:  Bed   Sofa   Dining Table   Bean bags   Wardrobes    
