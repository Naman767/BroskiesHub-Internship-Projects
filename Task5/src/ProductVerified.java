import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProductVerified {
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
            ProductFilter.createSampleCSV(inputFile);
            ProductFilter.filterProducts(inputFile, outputFile);
            verifyFile(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
