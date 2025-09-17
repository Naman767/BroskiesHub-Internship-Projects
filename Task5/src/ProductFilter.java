import java.io.*;

// Custom exception for invalid product data
class InvalidProductDataException extends Exception {
    public InvalidProductDataException(String message) {
        super(message);
    }
}

public class ProductFilter {

    // Create sample products.csv (with both valid and invalid data for testing)
    public static void createSampleCSV(String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        fw.write("Laptop,55000\n");
        fw.write("Mouse,200\n");        //<1000
        fw.write("Keyboard,1500\n");
        fw.write("Monitor,3000\n");
        fw.write("USB Cable,300\n");    //<1000
        fw.write("CPU Body,5000\n");
        fw.write("Smart-Phone,15000\n");
        fw.write("Headphone,1000\n");   //<=1000
        fw.write("Sound System,3000\n");
        fw.close();
        System.out.println("Sample products.csv created...");
    }

    // Read input, filter, and write to new CSV with exception handling
    public static void filterProducts(String inputFile, String outputFile) {
        BufferedReader br = null;
        FileWriter fw = null;

        try {
            br = new BufferedReader(new FileReader(inputFile));
            fw = new FileWriter(outputFile);

            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split(",");
                    if (parts.length != 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                        throw new InvalidProductDataException("Invalid row format: " + line);
                    }

                    String name = parts[0];
                    double price;

                    try {
                        price = Double.parseDouble(parts[1]);
                    } catch (NumberFormatException e) {
                        throw new InvalidProductDataException("Invalid price for product: " + line);
                    }

                    if (price > 1000) {
                        fw.write(name + "," + price + "\n");
                    }
                } catch (InvalidProductDataException e) {
                    System.err.println("Skipping row due to error: " + e.getMessage());
                }
            }
            System.out.println("Filtered Products saved to " + outputFile);

        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Safely close resources
            try {
                if (br != null) br.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Verify the new file by printing its contents
    public static void verifyFile(String filename) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            System.out.println("\nVerifying contents of " + filename + ":");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String inputFile = "products.csv";
        String outputFile = "filtered_products.csv";

        try {
            createSampleCSV(inputFile);
            filterProducts(inputFile, outputFile);
            verifyFile(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
