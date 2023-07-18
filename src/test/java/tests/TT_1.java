package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class TT_1 {

        //  1-Amazon anasayfaya gidebilecek sekilde bir page sayfasi olusturun : AmazonPage
            @Test
            public void Test01() throws InterruptedException {
                Driver.getDriver().get("https://www.amazon.com");

                //  2-Amazon ana sayfasinda en altta bulunan Webtable’i inceleyebilmek icin AmazonPage
                //  clasinda en altta gitme isini yapacak bir method olusturun
                Actions actions = new Actions(Driver.getDriver());
                actions.sendKeys(Keys.END).perform();
                Thread.sleep(3000);

                //  3-Tests paketi altinda yeni bir class olusturun: D26_AmazonSatirSutunSayisi
                //  4-Bu class’in altinda bir test method olusturun : satirSayisi() ve webtable’da 10 satir
                //  oldugunu test edin
                List<WebElement> satirListesi = Driver.getDriver().findElements(By.xpath("//tbody/tr"));
                System.out.println("---------------------------");
                System.out.println(satirListesi.size());
                int expectedSatirSayisi = 10;
                int actualSatirSayisi = satirListesi.size();
                Assert.assertEquals(actualSatirSayisi,expectedSatirSayisi);

                //  5-Yeni bir method olusturun : sutunSayisi() ve yazi olan sutun sayisinin 7 oldugunu test
                //  edin
            }
                @Test
                public void Test02sutunSayisi () {
                List<WebElement> sutunSayisi = Driver.getDriver().findElements(By.xpath("//tbody/tr/td"));
                int expectedsutun = 7;
                int actualSutun = sutunSayisi.size();
                Assert.assertEquals(actualSutun,expectedsutun);


        //      1-AmazonPage sayfasinda istedigim satir ve sutun sayisi ile cagirdigimda bana
        // hucredeki yaziyi getirecek bir method olusturun
        //      2-Tests paketi altinda yeni bir class olusturun: D26_AmazonHucreTesti
        //      3-Bu class’in altinda bir test method olusturun : hucretesti() ve webtable’da 3. satir
        // 2.sutundaki yazinin “Home Services” yazisi icerdigini test edin
        //      4 Yeni bir method olusturun : AmazonYazisi() ve tabloda 9 Hucrede “Amazon” yazisi
        // bulundugunu test edin



        //  1- Amazon uzerine yapilan 4 testi otomatik olarak calistiracak xml kodunu yazin ve
        //  calistirin
        //  2- D26_AmazonSatirSutunSayisi class’indan satirSayisi() testini ve
        //  D26_AmazonHucreTesti class’indan hucretesti() testini calistiracak xml kodunu yazin
        //  ve calistirin



        //      1-D26_AmazonSatirSutunSayisi class’indan satirSayisi() testini ve
        // D26_AmazonHucreTesti class’indan hucretesti() testini rapor alacak sekilde hazirlayin
        // ve 3.sorudaki xml dosyasi ile calistirip raporu olusturun
}
}