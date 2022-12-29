package pagefactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class Reservation {
	
		@FindBy(xpath="/html/body/app-root/app-reservation/div/div[1]/span[1]")
		public static WebElement Reservationpage;
		
		@FindBy(id="/html/body/app-root/app-reservation/div/div[1]/span[1]")
		public static WebElement table;
		
		@FindBy(xpath="/html/body/app-root/app-reservation/div/div[1]/span[1]")
		public static WebElement rpage;

}


