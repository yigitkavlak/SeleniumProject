import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class seleniumBasicCommands {

    public static void main(String Args[]) throws InterruptedException, ParseException {
        System.setProperty("webdriver.gecko.driver","/Users/mrk/Desktop/geckodriver.exe");

        //Create firefox driver's instance
        WebDriver driver = new FirefoxDriver();

        //Set implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch hepsiburada
        driver.get("https://www.hepsiburada.com/iphone-12-128-gb-p-HBV00000YDZXL");
        String iphoneFromHb = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/section[1]/div[6]/div/div[4]/div[1]/div[2]/div/div[1]/div[1]")).getText();
        System.out.println(iphoneFromHb);

        Thread.sleep(5000);

        String parsedValueHB = iphoneFromHb.split("TL")[0].trim().replace(".", "").replace(",","");
        double priceFromHbFormatted = Double.parseDouble(parsedValueHB);
        System.out.println("priceFromHbFormatted: " + priceFromHbFormatted);
        Iphone hepsiburada = new Iphone(priceFromHbFormatted, "HepsiBurada");

        Thread.sleep(5000);

        //Launch gittigidiyor
        driver.get("https://www.gittigidiyor.com/apple-iphone-12_spp_849455");
        String iphoneFromGg = driver.findElement(By.id("price")).getText();
        System.out.println(iphoneFromGg);

        Thread.sleep(5000);

        String parsedValueGG = iphoneFromGg.split("TL")[0].trim().replace(".", "").replace(",","");
        double priceFromGGFormatted = Double.parseDouble(parsedValueGG);
        System.out.println("priceFromGGFormatted: " + priceFromGGFormatted);
        Iphone gittiGidiyor = new Iphone(priceFromGGFormatted, "GittiGidiyor");


        Thread.sleep(5000);

        //Launch trendyol
        driver.get("https://www.trendyol.com/apple/iphone-12-128gb-beyaz-cep-telefonu-apple-turkiye-garantili-p-65277274?boutiqueId=583350&merchantId=123425");
        String iphoneFromTrendyol = driver.findElement(By.cssSelector(".with-dsc-info > div:nth-child(2)")).getText();
        System.out.println(iphoneFromTrendyol);;

        Thread.sleep(5000);

        String parsedValueTrendyol = iphoneFromTrendyol.split("TL")[0].trim().replace(".", "").replace(",","");
        double priceFromTrendyolFormatted = Double.parseDouble(parsedValueTrendyol);
        System.out.println("priceFromTrFormatted: " + priceFromTrendyolFormatted);
        Iphone trendyol = new Iphone(priceFromTrendyolFormatted, "Trendyol");

        ArrayList<Iphone> iphoneList = new ArrayList<Iphone>();
        iphoneList.add(hepsiburada);
        iphoneList.add(gittiGidiyor);
        iphoneList.add(trendyol);

        Iphone highestPriceIphone;
        highestPriceIphone = trendyol;

        double totalPrice = 0.0;
        double averagePrice = 0.0;

        for(int i=0; i<=iphoneList.size()-1; i++){
            totalPrice += iphoneList.get(i).price;
            if(i == iphoneList.size()-1){
                averagePrice = totalPrice / iphoneList.size();
                System.out.println("ortalama fiyat: " + averagePrice);
            }
            if(iphoneList.get(i).price > highestPriceIphone.price){
                highestPriceIphone = iphoneList.get(i);
            }
        }

        System.out.println("EN PAHALISI: "+ highestPriceIphone.marketName );

        Thread.sleep(50000);

        //Close the browser
        driver.close();
    }
}

class Iphone{
    String marketName;
    double price;

    public Iphone(double price, String marketName){
        this.marketName = marketName;
        this.price = price;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}