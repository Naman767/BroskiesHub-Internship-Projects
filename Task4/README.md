_**Project: Product Filter using Java I/O:**_
**Objective:**
The main goal of this project is to practice Java File Handling (I/O streams) by working with CSV files. The program reads product data (name and price) from a CSV file, applies a filtering condition (price greater than 1000), and writes the filtered data into a new CSV file.

**Project Workflow:**
Input File Creation:
A sample products.csv file is created, containing product names and their prices.
Example:
Laptop,55000
Mouse,750
Mobile,15000
Keyboard,1200
Headphones,950

**Reading the File**
Use BufferedReader to read each line from the CSV file.
Each line is split by a comma , to separate the product name and price.

**Processing the Data**
Convert the price string into a double.
Apply a condition to check if the price is greater than 1000.

**Writing to New File**
Use FileWriter to create a new file, e.g., filtered_products.csv.
Write only the products that meet the condition (price > 1000).

**Output & Verification**
Display a success message once the file is created.
Verify by opening the new file to check the filtered product list

**Example output:**
<img width="955" height="444" alt="Screenshot 2025-09-16 184333" src="https://github.com/user-attachments/assets/90653528-7845-48d2-8789-e032ea558aff" />

