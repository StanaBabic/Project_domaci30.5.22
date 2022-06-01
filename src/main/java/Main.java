import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/*Domaći:
        Otići na http://www.strela.co.rs/, kliknuti na dugme Prodavnica u headeru,
// izabrati opciju Lukovi - Bows iz leve navigacije, potom kliknuti na luk koji se zove Samick Sage,
 i onda proveriti da ime tog luka na njegovoj stranici zaista sadrži reč Samick.
 */
public class Main{

    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\GIT project\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            Thread.sleep(5000);
            driver.get("http://www.strela.co.rs/");

            WebElement shopBtn= driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a/span/strong"));
            shopBtn.click();
            WebElement bows= driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
            bows.click();

            Thread.sleep(5000);

            WebElement bowElImage= driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img"));
            bowElImage.click();
            WebElement bowElTitle= driver.findElement(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel"));
            Assert.assertTrue(bowElTitle.getText().contains("Samick"));
            System.out.println(bowElTitle.getText().contains("Samick"));
            driver.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
