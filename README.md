# Online Merch Store with Elasticsearch FTS

This project is a Spring Boot application implemented in Kotlin. It utilizes PostgreSQL as its primary datastore and Elasticsearch for full-text search capabilities. The application and its services are containerized using Docker and orchestrated with Docker Compose.

## Prerequisites

- Docker
- Docker Compose
- JDK 17

## Quick Start

1. **Clone the Repository**:

```bash
git clone https://github.com/thejramon/online-merch-store.git
cd online-merch-store
```

2. **Start the Services with Docker Compose**:

This will start the PostgreSQL, Elasticsearch

```bash
docker-compose up -d
```

3. **Verify the Services**:

Navigate to the following URLs in your browser to verify that the services are up and running:

- Spring Boot Application: http://localhost:8080/
- Elasticsearch: http://localhost:9200/

4. **API Usage**:

To search for products:

```bash
curl http://localhost:8080/api/products/search?name=YOUR_SEARCH_TERM
```

Replace `YOUR_SEARCH_TERM` with the product name or partial name you're searching for.

5. **Shutting Down**:

To stop and remove all containers:

```bash
docker-compose down
```

## Local Development

1. **Start Only the Databases with Docker Compose**:

If you want to run the Spring Boot application from your IDE but use the containerized databases:

```bash
docker-compose up -d postgres elasticsearch
```

2. **Run the Spring Boot Application**:

Execute the main application class from your IDE or use:

```bash
./mvnw spring-boot:run
```


## Tables

1. **Tables**:
   1. **Users**:
      - `id` (Primary Key, Integer, Auto-increment)
      - `username` (VARCHAR)
      - `password` (VARCHAR, encrypted)
      - `email` (VARCHAR)
      - `full_name` (VARCHAR)
      - `address` (VARCHAR)
      - `phone` (VARCHAR)
      - `created_at` (Date-Time)

   2. **Products**:
      - `id` (Primary Key, Integer, Auto-increment)
      - `product_name` (VARCHAR)
      - `description` (TEXT)
      - `price` (DECIMAL)
      - `stock_quantity` (INTEGER)
      - `category_id` (Foreign Key, Integer)
      - `image_url` (VARCHAR)
      
   3. **Categories**:
      - `id` (Primary Key, Integer, Auto-increment)
      - `category_name` (VARCHAR)

   4. **Orders**:
      - `id` (Primary Key, Integer, Auto-increment)
      - `user_id` (Foreign Key, Integer)
      - `order_date` (Date-Time)
      - `total_amount` (DECIMAL)
      - `shipping_address` (VARCHAR)
      - `order_status` (VARCHAR, e.g., "Processing", "Shipped", "Delivered")

   5. **OrderDetails**:
      - `id` (Primary Key, Integer, Auto-increment)
      - `order_id` (Foreign Key, Integer)
      - `product_id` (Foreign Key, Integer)
      - `quantity` (INTEGER)
      - `sub_total` (DECIMAL)

   6. **Reviews**:
      - `id` (Primary Key, Integer, Auto-increment)
      - `product_id` (Foreign Key, Integer)
      - `user_id` (Foreign Key, Integer)
      - `rating` (INTEGER, e.g., 1 to 5)
      - `comment` (TEXT)
      - `review_date` (Date-Time)

2. **Relationships**:
   - **Users** to **Orders**: One-to-Many (One user can have many orders)
   - **Users** to **Reviews**: One-to-Many (One user can leave many reviews)
   - **Products** to **OrderDetails**: One-to-Many (One product can be in many order details)
   - **Products** to **Reviews**: One-to-Many (One product can have many reviews)
   - **Products** to **Categories**: Many-to-One (Many products can belong to one category)
   - **Orders** to **OrderDetails**: One-to-Many (One order can have many order details)

## Notes


## Contributions

Feel free to fork the project, create a feature branch, and send us a pull request!
