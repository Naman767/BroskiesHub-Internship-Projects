import java.io.*;

public class ProductFilter {

    //Create sample products.csv
    public static void createSampleCSV(String filename) throws Exception{
        FileWriter fw = new FileWriter(filename);
        fw.write("Laptop,55000\n");
        fw.write("Mouse,200\n");
        fw.write("Keyboard,1500\n");
        fw.write("Monitor,3000\n");
        fw.write("USB Cable,300\n");
        fw.write("CPU Body,5000\n");
        fw.write("Smart-Phone,15000\n");
        fw.write("Headphone,1000\n");
        fw.write("Sound System,3000\n");
        fw.close();
        System.out.println("Sample products.csv created...");
    }

    //Read input, filter, and write to new CSV
    public static void filterProducts(String inputFile, String outputFile)throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        FileWriter fw = new FileWriter(outputFile);

        String line;
        while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length == 2){
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    if(price > 1000){
                        fw.write(name + "," + price + "\n");
                    }
                }
        }
        br.close();
        fw.close();
        System.out.println("Filtered Products saved to " + outputFile);
    }

    //Verify the new file by printing its contents
    public static void verifyFile(String filename)throws Exception{
        System.out.println("\n verifying contents of " + filename + ":");
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line= br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }

    public static void main(String[] args) {
        String inputFile = "products.csv";
        String outputFile = "filtered_products.csv";

        try {
            createSampleCSV(inputFile);
            filterProducts(inputFile,outputFile);
            verifyFile(outputFile);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
