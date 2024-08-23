package civica.nacional.iOS.utilidades;

import org.openqa.selenium.chrome.ChromeDriver;

public class CustomChromeDriver {
	
	public static void iniciarChromeDriver() {
		System.setProperty("webdriver.chrome.driver", Credenciales.parametrosGenerales().getProperty("ubicacion.driverchrome"));
		BaseUtil.chromeDriver = new ChromeDriver();
		//base.chromeDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		BaseUtil.chromeDriver.manage().window().maximize();
		//chromeDriver.get(url);
	}
	
	public void iniciarChromeDriverLatinia() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/Mac/chromedriver.exe");
		BaseUtil.chromeDriverLatinia = new ChromeDriver();
		//base.chromeDriver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		BaseUtil.chromeDriverLatinia.manage().window().maximize();
	}
	public void iniciarChromeDriverNLatinia() {
		System.setProperty("webdriver.chrome.driver", Credenciales.parametrosGenerales().getProperty("ubicacion.driverchrome"));
		BaseUtil.chromeDriverNLatinia = new ChromeDriver();
		//base.chromeDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		BaseUtil.chromeDriverNLatinia.manage().window().maximize();
	}
	
	public static void cerrarChromeDriver() {
		//base.chromeDriver.close();
		BaseUtil.chromeDriver.quit();
	}
	
	public void cerrarChromeDriverLatinia() {
		BaseUtil.chromeDriverLatinia.close();
		BaseUtil.chromeDriverLatinia.quit();
	}
	
	public void cerrarChromeDriverNLatinia() {
		BaseUtil.chromeDriverNLatinia.close();
		BaseUtil.chromeDriverNLatinia.quit();
	}
}
