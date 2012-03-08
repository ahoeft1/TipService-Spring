package tipservice;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * See if you can modify this class to use Spring as in Lab1.
 */
public class Startup_1 {

    public static void main(String[] args) {
        // First create some low-level instances using
        // Liskov Substitution Principle

//        TipCalculator calc1 =
//           new FoodServiceTipCalculator(TipService.ServiceQuality.FAIR,125.00);
//
//        TipCalculator calc2 =
//           new BaggageServiceTipCalculator(TipService.ServiceQuality.GOOD,5);

//        // Next, create the high-level class
//        TipService tipMgr = new TipService(calc1);

          final AbstractApplicationContext ctx = 
                new ClassPathXmlApplicationContext("applicationContext.xml");


        // Now ask the tip manager to do some work...
        double tip = ctx.getBean("tipManager").getTip();
        String quality = ctx.getBean("tipManager").getServiceQuality();

        // Now prove it works...
        System.out.println("\nThe tip for the "
                + ctx.getBean("tipCalc1").getClass().getSimpleName() + " is: "
                + tip + ", with a service qualilty of: " + quality);

    }

}
