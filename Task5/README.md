**Program Description: Product Filter with CSV and Exception Handling**
This program demonstrates file handling, exception management, and custom exception creation in Java by working with product data stored in a CSV file. The main objective is to read product details from a CSV file, filter products based on their price, and save valid products to a new CSV file.

**Key Features**
_**CSV File Creation**_ : 
The program generates a sample file products.csv containing product names and prices.
Each product entry is stored on a separate line in the format: ProductName,Price

**Reading and Filtering Data** : 
The program reads the CSV file line by line using BufferedReader.
Each line is split into two parts: product name and price.
If the price is greater than 1000, the product is considered valid and written into a new file filtered_products.csv.

**Custom Exception Handling** : 
A custom exception class InvalidProductDataException is used to handle invalid or corrupted rows (e.g., missing price, non-numeric price, or incorrect format).
Invalid rows are skipped with an error message instead of crashing the program.

**Robust Error Handling** :
FileNotFoundException: Handled if the input CSV file does not exist.
NumberFormatException: Caught if the price cannot be converted to a number.
Finally Block: Ensures file resources (BufferedReader, FileWriter) are closed safely.

**Verification Step** : 
After filtering, the program reads and prints the contents of the new file filtered_products.csv to verify the results.

**OUTPUT IMG** : 

<img width="872" height="377" alt="Screenshot 2025-09-17 184057" src="https://github.com/user-attachments/assets/18e66d5f-d1e6-4c42-96ff-6b6ec0b057ab" />

