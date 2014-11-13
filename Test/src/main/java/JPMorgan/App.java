package JPMorgan;

import JPMorgan.ProductProcessor.ProductItemProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductItemProcessor obj = (ProductItemProcessor) context.getBean("productProcessor");
        obj.process();        
    }
}
