package JPMorgan.ProductProcessor;
import JPMorgan.Product.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;

public class ProductItemProcessor 
{
    public void process() throws Exception
    {
        String csvFile = "D:\\Test\\src\\test\\resources\\sample.csv";
        String outputFile = "D:\\Test\\src\\test\\resources\\output.csv";
	BufferedReader br = null;
        BufferedWriter bw = null;
	String line = "";
	String cvsSplitBy = ",";
        Product product;
        
        try {
           br = new BufferedReader(new FileReader(csvFile));
	   bw = new BufferedWriter(new FileWriter(outputFile,true));
           br.readLine();  // skipping the header
           bw.newLine();
           while ((line = br.readLine()) != null) 
           {
                product = new Product();
   		String[] row = line.split(cvsSplitBy);
		//System.out.println("Record [instrument type= " + row[0]+ " , name=" + row[1] +
                //                   ", quantity=" + row[2] +", buy price=" + row[3] +
                //                   ", sell price=" + row[4] + ", coupon=" + row[5] +"]");
                 
                product.setType(row[0]);
                product.setName(row[1]);
                product.setCoupon(row[5]);
                product.setsellPrice(row[4]);
                product.setbuyPrice(row[3]);
                product.setQuantity(row[2]);
                
                product.setEquityProfit();
                product.setBondProfit();
                
                bw.append(product.getRecordRow());
                bw.newLine();
          }
	} catch (FileNotFoundException e) {
		System.out.println("FIle not found");
	} catch (IOException e) {
		System.out.println("Unexpected input");
	} 
        catch (NumberFormatException e) {
		System.out.println("Not a float");
	} 
        finally {
            if (br != null) {
                try {
                    br.close();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            if (bw != null) {
                try {
                    bw.close();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }            
        } 
	System.out.println("Done");
    }
}