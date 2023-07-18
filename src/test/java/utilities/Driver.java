package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    private Driver() {

    }
    public static WebDriver getDriver() {

        /*
            Bundan sonra daha önce driver olarak TestBase den alıp kulllandığımız
            WebDriver ın yerine

            Driver class ından getDriver methodunu kullanacğız
            ancak mahşerin dört atlısında kullandığımız

            driver = new ChromeDriver();

            problem oluşturuyor,çünkü her çalıştığında yeniden CromeDriver oluşturuyor.

            Bizim istediğimiz şu:

            ben testimi çalıştırmaya başladığımda
            ilk kez bu method u kullanınca CromeDriver oluştursun
            Sonraki kulllanımlarda oluşturmasın

            bunun için driver == null kontrol edip
            ona göre yeni ChromeDriver ataması yapıyoruz

         */

        /*
        İş yerimizde çalışırken
        testlerimizi farklı Browser lar ile çalıştırmamız istenebilir
        Dinamik olarak browser kullanabilmek için
        configuration.properties dosyamıza browser = istenen browser
        browser tanımladık

        Driver class ında da configuration.properties dosyasındaki
        bilgiyi okuyup o bilgiye göre istenen browser ı oluşturacak
        bir yapı hazırlayalım.
         */
        WebDriverManager.chromedriver().setup();

        if(driver==null){

            String browser = ConfigReader.getProperty("browser");

            switch (browser) {

                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
            }
            driver=new ChromeDriver();
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;

    }

    public static void closeDriver() {
        if(driver != null){
            driver.close();
            driver = null;
        }
    }
    public static void quitDriver() {
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
