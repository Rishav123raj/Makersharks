# Makersharks Supplier Search API
This project is a proof of concept (POC) for a RESTful API that allows users to search for manufacturers (suppliers) based on specific criteria such as location, 
nature of business, and manufacturing processes. The API is built using Spring Boot and includes features like pagination, input validation, and structured response handling.

# Project Overview
# API Endpoint:
/api/supplier/query [POST]: This endpoint retrieves a list of manufacturers (suppliers) based on the specified location, nature of business, and manufacturing processes.

# Supplier Details:
1. supplier_id: Unique identifier for each supplier.
2. company_name: Name of the supplier company.
3. website: Supplier's website.
4. location: City where the supplier is located.
5. nature_of_business: Type of business, with possible values being small_scale, medium_scale, or large_scale.
6. manufacturing_processes: Types of manufacturing processes the supplier can perform, with possible values being moulding, 3d_printing, casting, and coating.

# Key Features:
1. Pagination: Handles large datasets by paginating the results.
2. Validation: Ensures that the input parameters are correctly formatted.
3. Exception Handling: Implements proper error handling for invalid requests.

# Prerequisites
Before running the application, ensure you have the following installed:
1. Java 17 or higher
2. Maven 3.6.3 or higher
3. Git (to clone the repository)
4. MySQL (or any other database of your choice)

# Running the Application
1. Clone the Repository
   1. git clone https://github.com/Rishav123raj/Makersharks.git
   2. cd Makesharks
   
2. Configure the Database
  Open the src/main/resources/application.properties file.
  Update the following properties to match your database configuration:
  properties
  Copy code
  spring.datasource.url=jdbc:mysql://localhost:3306/makersharks_db
  spring.datasource.username=your_db_username
  spring.datasource.password=your_db_password
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
If you're using a different database, update the spring.datasource.url and spring.jpa.properties.hibernate.dialect accordingly.

3. Build the Application
Navigate to the root directory of the project and run the following Maven command to build the project:
bash
Copy code
mvn clean install

4. Run the Application
After building the application, you can run it using the following command:

bash
Copy code
mvn spring-boot:run
