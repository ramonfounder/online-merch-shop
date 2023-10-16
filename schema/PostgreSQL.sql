CREATE TABLE "User" (
  "userId" Long PRIMARY KEY,
  "username" String,
  "password" String,
  "email" String,
  "fullName" String,
  "address" String,
  "createdAt" DateTime
);

CREATE TABLE "Product" (
  "productId" Long PRIMARY KEY,
  "productName" String,
  "description" String,
  "price" Decimal,
  "stockQuantity" Integer,
  "imageUrl" String,
  "category_id" Long
);

CREATE TABLE "Category" (
  "categoryId" Long PRIMARY KEY,
  "categoryName" String
);

CREATE TABLE "Order" (
  "orderId" Long PRIMARY KEY,
  "orderDate" DateTime,
  "totalAmount" Decimal,
  "user_id" Long
);

CREATE TABLE "OrderDetail" (
  "orderDetailId" Long PRIMARY KEY,
  "quantity" Integer,
  "price" Decimal,
  "product_id" Long,
  "order_id" Long
);

CREATE TABLE "Review" (
  "reviewId" Long PRIMARY KEY,
  "rating" Integer,
  "comment" String,
  "product_id" Long,
  "user_id" Long
);

ALTER TABLE "Product" ADD FOREIGN KEY ("category_id") REFERENCES "Category" ("categoryId");

ALTER TABLE "Order" ADD FOREIGN KEY ("user_id") REFERENCES "User" ("userId");

ALTER TABLE "OrderDetail" ADD FOREIGN KEY ("product_id") REFERENCES "Product" ("productId");

ALTER TABLE "OrderDetail" ADD FOREIGN KEY ("order_id") REFERENCES "Order" ("orderId");

ALTER TABLE "Review" ADD FOREIGN KEY ("product_id") REFERENCES "Product" ("productId");

ALTER TABLE "Review" ADD FOREIGN KEY ("user_id") REFERENCES "User" ("userId");
