# Rent-A-Builder
<h3>Project Description</h3>
<p>A web application for renting construction equipment to allow clients/customers to rent construction equipment (e.g., construction vehicles, generators, light towers, etc.) and manage the inventory of products. The client/customer is able to register for an account, view the catalog of products, add products to cart, submit orders, and etc. The administrator is able to add, delete, and edit products and process new orders.</p>

<h3>Tech Stack</h3>
<ul>
  <li>Frontend: HTML/CSS, Bootstrap, Javascript, JSP</li>
  <li>Backend: Spring Boot (Spring Data JPA, Spring Security/BCrypt, Spring Validation) & Core Java (Eclipse IDE)</li>
  <li>Database: MySQL (MariaDB)</li>
  <li>Server: Apache Tomcat</li>
  <li>Testing: JUnit Jupiter</li>
  <li>Project Management Tool: Apache Maven</li>
</ul>
  
<h3>Challenges</h3>
<ul>
  <li>Difficulty in designing relational database schema</li>
    <ul><li>Dropped and created database multiple times</li></ul>
  <li>Difficulty with referencing CSS, Javascript, and images when URL was “nested” (e.g., ../product/add)</li>
    <ul><li>Asked fellow peers for help</ul></li>
  <li>Lack of inspiration for designing my website</li>
     <ul><li>Looked at professional e-Commerce websites for inspiration</ul></li>
  <li>Did not know how to access the details of the current user when using Spring Security</li>
    <ul><li>Researched how to use Spring Security taglibs and Principal object injection for easy access to the current user</ul></li>
  <li>Difficulty using customized methods provided by Spring Data JPA’s CrudRepository interface (e.g., findByFieldContainingIgnoreCase(Object field))</li>
    <ul><li>Used the @Query annotation to define the methods</ul></li>
</ul>

<h3>Functional Requirements (DONE)</h3>
<ul>
  <li>Users (Clients/Customers and Admins) Access Management</li>
    <ul><li>As an admin, I need to be able to sign in</ul></li>
    <ul><li>As an admin, I need to have all the privileges of a user</ul></li>
    <ul><li>As a user, I need to be able sign up and login</ul></li>
    <ul><li>As a guest, I should be able to only browse the landing, product catalog, register, and login page</ul></li>
  <li>Admin Data Management</li>
    <ul><li>As an admin, I should be able to add, delete, and modify existing products</ul></li>
  <li>User Order Management</li>
    <ul><li>As a user, I should be able to see all the products</ul></li>
    <ul><li>As a user, I should be able to add products to the cart</ul></li>
    <ul><li>As a user, I should be able to update quantity of the product in the cart</ul></li>
    <ul><li>As a user, I should be able to assign the rental duration of orders</ul></li>
    <ul><li>As a user, I should be able to submit and cancel orders</ul></li>
  <li>Account Info Management</li>
    <ul><li>As an admin and user, I should be able to store and update my account information (e.g., name, contact info, address, etc.)</ul></li>
  <li>Frontend UI/UX Design and Management</li>
    <ul><li>As admins, we should be the only ones to be able to access the admin page</ul></li>
    <ul><li>As an admin and user, I should be able to easily access every authorized page of the website</ul></li>
    <ul><li>As a user, I should be able to view my orders in an organized manner</ul></li>
</ul>

<h3>Functional Requirements (TODO)</h3>
<ul>
  <li>Users (Clients/Customers and Admins) Access Management</li>
    <ul><li>As an admin, I can upgrade other users to be admins</ul></li>
  <li>Admin Data Management</li>
    <ul><li>As an admin, I should be able to view, approve and cancel all purchase orders</ul></li>
    <ul><li>As an admin, I should be able to keep track of all product inventories</ul></li>
  <li>Frontend UI/UX Design and Management</li>
    <ul><li>As an admin, I should be able to view all orders in an organized manner</ul></li>
</ul>
