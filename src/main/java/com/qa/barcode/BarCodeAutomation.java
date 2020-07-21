package com.qa.barcode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BarCodeAutomation {
	@Test
	public void barcodeAutomation() throws IOException, NotFoundException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
	    WebDriver d=new ChromeDriver();
	    d.get("https://barcode.tec-it.com/en/?data=HI HOW R U");
	   /* d.findElement(By.xpath("//textarea[@id='Data']")).sendKeys("Parvej123@");data we are passing through url data then read the source
	    d.findElement(By.xpath("//a[contains(text(),'Refresh')]")).click();*/
	   String BarcodeURL= d.findElement(By.tagName("img")).getAttribute("src");
	   System.out.println(BarcodeURL);
	   URL url=new URL(BarcodeURL);
	   BufferedImage bufferedImage= ImageIO.read(url);
	   LuminanceSource luminancesource= new BufferedImageLuminanceSource(bufferedImage);
	   BinaryBitmap binarybitmap=new BinaryBitmap(new HybridBinarizer(luminancesource));
	   Result result=new MultiFormatReader().decode(binarybitmap);
	   System.out.println(result.getText());
	}

}
