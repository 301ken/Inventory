# Inventory Management System
This project provides an Inventory Management System with product and inventory functionalities, including features for managing stock levels, creating products, updating products, and checking stock levels.

---

## Clone the repository:
bash
### Copy code
`git clone https://github.com/your-username/inventory-management.git
cd inventory-management`

### Build and run the application: Using Maven:
bash
./mvnw spring-boot:run
Or if you are using an IDE, you can simply run the main class InventoryManagementApplication.java.

Access the application: Once the server starts, the application will be available at:

## Endpoints and Usage
1. Get All Products
- URL: `/api/products`

- Method: `GET`

- Description: Retrieves a list of all products in the system.

- Response Example:
`
json
[
  {
    "id": 1,
    "name": "smartphone",
    "price": 43.2,
    "category": {
      "id": 1,
      "name": "electronics"
    },
    "inventory": {
      "stockLevel": 100
    }
  },
  ...
]`

2. Get Product by ID
- URL: /api/products/{id}

- Method: GET

- Description: Retrieves details of a specific product based on its ID.

- Response Example:
`
json
{
  "id": 1,
  "name": "smartphone",
  "price": 43.2,
  "category": {
    "id": 1,
    "name": "electronics"
  },
  "inventory": {
    "stockLevel": 100
  }
}`

3. Create Product
- URL: /api/products

- Method: POST

- Description: Creates a new product in the system.

- Request Example:

`
{
  "name": "tablet",
  "price": 129.99,
  "categoryId": 2
}
Response Example:

json
{
  "id": 2,
  "name": "tablet",
  "price": 129.99,
  "category": {
    "id": 2,
    "name": "electronics"
  },
  "inventory": {
    "stockLevel": 50
  }
}`

4. Update Product
URL: /api/products/{id}

Method: PUT

Description: Updates an existing product in the system based on its ID.

Request Example:

json
{
  "name": "smartphone pro",
  "price": 899.99,
  "categoryId": 1
}
Response Example:

json
{
  "id": 1,
  "name": "smartphone pro",
  "price": 899.99,
  "category": {
    "id": 1,
    "name": "electronics"
  },
  "inventory": {
    "stockLevel": 100
  }
}
5. Delete Product
URL: /api/products/{id}
Method: DELETE
Description: Deletes a product from the system based on its ID.
Response Example: 204 No Content (successful deletion).
6. Get Stock Level for a Product
URL: /api/products/{id}/stock-level

Method: GET

Description: Retrieves the stock level of a product based on its ID.

Response Example:

json
{
  "stockLevel": 100
}
7. Update Stock Level
URL: /api/inventory/{productId}

Method: PUT

Description: Updates the stock level for a product.

Request Example:

json
{
  "quantity": 150
}
Response Example:

json
{
  "id": 1,
  "stockLevel": 150
}

## Access Swagger UI
After starting the application, Swagger UI will be available at:

`http://localhost:8080/swagger-ui.html`
### Using Swagger

- Open the Swagger UI link in your browser.
- You will see a list of all available endpoints with descriptions.
- You can test the endpoints directly by providing the required input and clicking the "Execute" button.
