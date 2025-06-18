# Monster-shop API

This is the backend application for **Monster Shop**, an e-commerce platform where users can browse products, leave reviews, and rate items. The backend is built with **Java 21** and **Spring Boot**, using **MySQL** as the relational database.

## Technologies Used

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![draw.io](https://img.shields.io/badge/draw.io-F08705?style=for-the-badge&logo=diagramsdotnet&logoColor=white)

## API Endpoints

### Product

- `GET /api/products` — Get all products
- `GET /api/products/{id}` — Get product by ID
- `POST /api/products` — Add new product
- `PUT /api/products/{id}` — Update product
- `DELETE /api/products/{id}` — Delete product

### Review

- `GET /api/reviews/{productId}` — Get all reviews by productID
- `POST /api/reviews` — Add new review
- `PUT /api/reviews/{id}` — Update review
- `DELETE /api/reviews/{id}` — Delete review

## ER Diagram(Crow's feet)


## ClassDiagram


## Clone the Repository

```bash
git clone https://github.com/NepyAnna/monster-shop.git
cd monster-shop
```
### Run

```bash
./mvnw spring-boot:run
```
or
```bash
mvn spring-boot:run
```
Alternative Way to Run the Application
If you are using an IDE such as IntelliJ IDEA or VS Code, you can simply click the “Run” button or run the main application class directly (the one annotated with @SpringBootApplication).
For example, in IntelliJ IDEA, right-click the main class and choose "Run 'MonsterShopApp...main()'".

## Contributors

NepyAnna
<a href="https://github.com/NepyAnna">
    <picture>
        <source srcset="https://img.icons8.com/ios-glyphs/30/ffffff/github.png" media="(prefers-color-scheme: dark)">
        <source srcset="https://img.icons8.com/ios-glyphs/30/000000/github.png" media="(prefers-color-scheme: light)">
        <img src="https://img.icons8.com/ios-glyphs/30/000000/github.png" alt="GitHub icon"/>
    </picture>
</a>

## Disclaimer
This project is developed as part of a bootcamp learning experience and is intended for educational purposes only. The creators and contributors are not responsible for any issues, damages, or losses that may occur from using this code.
This project is not meant for commercial use, and any trademarks or references to third-party services belong to their respective owners. By using this code, you acknowledge that it is a work in progress, created by learners.

Use at your own discretion and risk.

Thank You! 