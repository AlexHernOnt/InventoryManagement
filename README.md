## 🏬 Inventory Management System

---

## 📚 Overview
The Inventory Management System is designed to help store managers track products, manage stock quantities, and handle sales. The system provides functionalities for adding, updating, listing, and deleting products. It also integrates with an Order Management System to manage orders and update inventory when sales are made.

## Features
### 1. Product Management
- Add products to the inventory with basic information: name, price, and stock quantity
- List all products in the inventory for easy viewing
- Update product information, including price and stock quantity
- Reduce stock when a sale is made, ensuring the inventory reflects real-time changes
- Delete obsolete products that are no longer available or relevant

### 2. Order Management (Integration with Inventory)
- Create orders that include products from the inventory
- List all orders and their details
- View order details, including products and quantities
- Mark an order as completed or canceled, updating the inventory accordingly

---

## 🚀 API Endpoints  

### 🛒 Product Management  
- **Get All Products**  
  `GET /products`  

- **Get Product By ID**  
  `GET /products/{id}`  

- **Add a New Product**  
  `POST /products`  

- **Update a Product**  
  `PUT /products/{id}`  

- **Reduce Stock of a Product**  
  `PUT /products/reduceStock/{id}/{quantity}`  

- **Remove a Product**  
  `DELETE /products/removeProduct`  
