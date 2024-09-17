package civica.nacional.iOS.utilidades;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static io.appium.java_client.touch.offset.PointOption.point;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.pageObjects.CambioClaveCivicaPage;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.RecargaTarjetaCivicaPage;
import civica.nacional.iOS.pageObjects.WebRedebanPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import javax.mail.*;
import java.util.Properties;
import io.appium.java_client.ios.IOSElement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

public class UtilidadesTCS extends PageObject {

	static Utilidades utilidades;
	static BaseUtil base;
	static Utilidades utilidad;
	static int contador = 0;
	private static WebDriverWait wait = Hooks.getDriverWait();
	private static AppiumDriver<MobileElement> driver = Hooks.getDriver();
	WebRedebanPageObjects webRedebanPageObjects;
	
	public void scrollToElement(String locator, String tipoId) {
		MobileElement element = (MobileElement) findElement("xpath", locator);
		int yOffset = 0; /*AJUSTA EL VALOR SEGÚN SEA NECESARIO*/

		switch (tipoId) {
		case "CC":
			yOffset = 0;
			break;
		case "TI":
			yOffset = -50;
			break;
		case "CE":
			yOffset = -100;
			break;
		default:
			throw new IllegalArgumentException("Tipo de documento no válido: " + tipoId);
		}
		Point location = element.getCenter();
		int startX = location.getX();
		int startY = location.getY();

		new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startX, startY + yOffset)).release().perform();

		System.out.println("Moví elemento");
	}
	

	public void scrollBackground(String locator) {
		MobileElement element = (MobileElement) findElement("xpath", locator);

		int yOffset = 70; /*AJUSTA EL VALOR SEGÚN SEA NECESARIO*/

		Point location = element.getCenter();
		int startX = location.getX();
		int startY = location.getY();

		new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startX, startY + yOffset)).release().perform();

		System.out.println("Moví elemento");
	}

	public void scrollBirth(String locatorType, String locator) {
		MobileElement element = (MobileElement) findElement("xpath", locator);

		int yOffset = 1100; /*AJUSTA EL VALOR SEGÚN SEA NECESARIO*/

		Point location = element.getCenter();
		int startX = location.getX();
		int startY = location.getY();

		new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startX, startY + yOffset)).release().perform();

		System.out.println("Moví elemento");
	}

	public void clickByCoordinates(int x, int y) {
		new TouchAction(BaseUtil.driver).press(PointOption.point(x, y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).release().perform();

		System.out.println("Realizado clic en las coordenadas (" + x + ", " + y + ")");
	}
	
	
	public void moverElementoTouch(MobileElement element, int yOffset) {
		Point location = element.getCenter();
		int startX = location.getX();
		int startY = location.getY();

		new TouchAction(BaseUtil.driver).press(point(startX, startY)).waitAction(waitOptions(ofMillis(500)))
				.moveTo(point(startX, startY + yOffset)).waitAction(waitOptions(ofMillis(100))).release().perform();

		System.out.println("Moví elemento");
	}
	
	public void moverElementoTouchHorizontal(MobileElement element, int xOffset) {
	    Point location = element.getCenter();
	    int startX = location.getX();
	    int startY = location.getY();

	    int endX = startX + xOffset; // NUEVA COORDENADA X DE DESTINO

	    new TouchAction(BaseUtil.driver)
	            .press(point(startX, startY))
	            .waitAction(waitOptions(ofMillis(500)))
	            .moveTo(point(endX, startY)) // MOVER A LA NUEVA COORDENADA X DE DESTINO
	            .waitAction(waitOptions(ofMillis(100)))
	            .release()
	            .perform();

	    System.out.println("Moví elemento horizontalmente");
	}
	
    public void moverElementoMapaCoordenadas(Point startPoint, int xOffset) {
        int startX = startPoint.getX();
        int startY = startPoint.getY();

        int endX = startX + xOffset; // NUEVA COORDENADA X DE DESTINO

        new TouchAction(BaseUtil.driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
                .moveTo(PointOption.point(endX, startY)) // MOVER A LA NUEVA COORDENADA X DE DESTINO
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .release()
                .perform();

        System.out.println("Moví elemento horizontalmente");
    }
	
    public static String obtenerHoraActual() {
        // OBTÉN LA HORA ACTUAL
        LocalDateTime ahora = LocalDateTime.now();

        // DEFINE EL FORMATO DE SALIDA (HH:MM)
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        // FORMATEA LA HORA ACTUAL SEGÚN EL FORMATO
        String horaFormateada = ahora.format(formatoHora);

        return horaFormateada;
    }

	public MobileElement findElement(String locatorType, String locator) {
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}
	
	public void acceptPopup() {
		for(int i=0; i<=1; i++) {
			clicElement("xpath",LoginCivicaPage.ACP_POPUP);
		}
	}
	
	public void acceptPopupAndClickAccept() {
		
	    // ASEGÚRATE DE CONFIGURAR UN TIEMPO DE ESPERA CORTO PARA ENCONTRAR EL POPUP
	    BaseUtil.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    // INTENTA ACEPTAR EL POPUP INMEDIATAMENTE
	    try {
	    	
	        clicElement("xpath", LoginCivicaPage.ACP_POPUP);
	        
	    } catch (NoSuchElementException e) {
	        // SI NO SE ENCUENTRA EL POPUP, SE MANEJA AQUÍ
	    }

	    // RESTAURA EL TIEMPO DE ESPERA ORIGINAL
	    BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	    // CONTINÚA CON OTRAS ACCIONES SI ES NECESARIO
	}

	public void clicElement(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			BaseUtil.driver.findElement(by).click();
			System.out.println("Se realizó clic en: " + locator);
		} catch (Exception e) {
			fail("No pudo interactuar con el elemento: " + locator);
		}
	}
	
	
	public boolean clicElementNoFail(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			check = BaseUtil.driver.findElement(by).isDisplayed();
			System.out.println("Se verifica presencia del elemento: " + locator);
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);;
		}
		return check;
	}

	public void clicElementAction(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			MobileElement element = driver.findElement(by);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();

			System.out.println("Se realizó clic en: " + locator);
		} catch (Exception e) {
			fail("No pudo interactuar con el elemento: " + locator);
		}
	}
	
	public String getTextMobileElement(String locatorType, String locator) {
		String text = null;
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			text = element.getText();
			System.out.println("Se extrajo texto del elemento: " + locator);
		} catch (Exception e) {
			fail("No pudo extraer texto del elemento: " + locator);
		}
		return text;
	}


	public String obtenerTexto(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String txt = "Vacio";
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			txt = BaseUtil.driver.findElement(by).getText();
			System.out.println("Se obtuvo el texto del elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}
		return txt;
	}

	public boolean validateElementVisibility(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			check = BaseUtil.driver.findElement(by).isDisplayed();
			System.out.println("Se verifica presencia del elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}

		return check;
	}
	
	public boolean validateElementVisibilityException(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			check = BaseUtil.driver.findElement(by).isDisplayed();
			System.out.println("Se verifica presencia del elemento: " + locator);
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);;
		}
		return check;
	}

	public void writeElement(String locatorType, String locator, String texto) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			BaseUtil.driver.findElement(by).sendKeys(texto);
			System.out.println("Se escribe el texto: " + texto + " en el elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}
	}

	public static void esperarElementVisibility(String locatorType, String locator) {
		switch (locatorType) {
		case "name":
			break;
		case "id":
			break;
		case "xpath":
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			contador++;
		} catch (Exception e) {
			if (!(contador == 10)) {
				Utilidades.esperaMiliseg(500);
				esperarElementVisibility(locatorType, locator);
			} else {
				fail("No se encontró el elemento: " + locator + ", debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
	
	public void esperarElementPresence(String locatorType, String locator) {
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			contador++;
		} catch (Exception e) {
			if (!(contador == 15)) {
				Utilidades.esperaMiliseg(500);
				esperarElementPresence(locatorType, locator);
			} else {
				fail("No se encontró el elemento: " + locator + ", debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validateTextContainsString(String textoExtraido, String textoIgualado) {
		assertThat(textoExtraido, containsString(textoIgualado));
	}
	
	public static boolean validateTextContainsStringBoolean(String textoExtraido, String textoIgualado) {
	    try {
	        assertThat(textoExtraido, containsString(textoIgualado));
	        return true;  // LA VALIDACIÓN ES EXITOSA
	    } catch (AssertionError e) {
	        return false; // LA VALIDACIÓN HA FALLADO
	    }
	}
    
    public static String removeDecimalBalancesWeb(String value) {
    	String monto = value.replace(".","");
    	String valorConvertido = monto.substring(0, monto.length() - 1);
        return valorConvertido;
    }

	public void validateStatusElement(boolean estado) {
		assertThat(estado, is(true));
	}

	public void validateTextEqualTo(String textoExtraido, String textoIgualado) {
		assertThat(textoExtraido, equalTo(textoIgualado));
	}

	public void validateTextNotEqualTo(String textoExtraido, String textoIgualado) {
		assertThat(textoExtraido, not(equalTo(textoIgualado)));
	}

	public static String removeDecimalBalances(String value) {
		String monto = value.replace("$", "").replace(",", "").replace(".", "");
		String valorConvertido = monto.substring(0, monto.length() - 2);
		return valorConvertido;
	}
	
	public static String removeDecimal(String value) {
		String monto = value.replace("$", "").replace(",", "").replace(".", "");
		//String valorConvertido = monto.substring(0, monto.length() - 2);
		return monto;
	}
	
	public String removeCharacterBalances(String value) {
		String monto = value.replace("-", "").replace(",", "").replace(".", "");
		return monto;
	}
	
	public String removeCharacterDate(String value) {
		String date = value.replace("/", "-").replace(",", "").replace(".", "");
		return date;
	}

	public boolean validateElementEnabled(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			check = BaseUtil.driver.findElement(by).isEnabled();
			System.out.println("Se verifica el estado de habilitación del elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}

		return check;
	}

	public String validarLongitudNumerica(String valorExtraido, int rango) {
		int longitud = valorExtraido.length();
		assertThat(longitud, equalTo(rango));
		String longString = Integer.toString(longitud);
		return longString;
	}

	public String validarCaracteresNumericos(String texto) {
		String mensaje = "";
		if (texto.matches("\\d+")) {
			mensaje = "Sí, contiene solo caracteres numéricos";
		} else {
			mensaje = "No, se encontraron letras o caracteres especiales";
		}
		return mensaje;
	}

	public void cleanInputElement(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			BaseUtil.driver.findElement(by).clear();
			System.out.println("Se limpió el campo del elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}
	}

	public void cerrarMensajePopUp(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			boolean mensajeTopes = driver.findElement(By.xpath(locator)).isDisplayed();
			if (mensajeTopes) {
				TouchAction touchAction = new TouchAction(driver);
				touchAction.tap(new PointOption().withCoordinates(192, 163)).perform();
			}
			System.out.println("Se encontró y se cerró mensaje");
		} catch (Exception e) {
			System.out.println("No se encontró mensaje");

		}
	}

	public void ingresarUsuario(String locatorType, String locator, String numCelularEspecial) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		BaseUtil.driver.findElement(By.xpath(locator)).sendKeys(numCelularEspecial);
		BaseUtil.usuario = numCelularEspecial;
	}
	
	public static String obtenerContenidoUltimoCorreo(String usuario, String contrasena) throws Exception {
		Properties propiedades = new Properties();
		propiedades.setProperty("mail.store.protocol", "imaps");
		propiedades.setProperty("mail.imaps.ssl.protocols", "TLSv1.2");
		propiedades.setProperty("mail.imaps.ssl.trust", "*");

		Session sesion = Session.getInstance(propiedades);

		Store tienda = sesion.getStore("imaps");
		tienda.connect("imap.gmail.com", usuario, contrasena);

		Folder bandeja = tienda.getFolder("inbox");
		bandeja.open(Folder.READ_ONLY);

		Message[] mensajes = bandeja.getMessages();
		Message ultimoMensaje = mensajes[mensajes.length - 1];

		String contenido = obtenerContenidoMensaje(ultimoMensaje);
		String codigoActivacion = extraerCodigoActivacion(contenido);

		bandeja.close(false);
		tienda.close();

		return contenido;
	}

	public static String extraerCodigoActivacion(String contenido) {
		// String patron = "Tu código de activación es: (\\d+)";
		Pattern pattern = Pattern.compile("\\d+");
		java.util.regex.Matcher matcher = pattern.matcher(contenido);

		if (matcher.find()) {
			String nuevaClaveVirtual = matcher.group();
			System.out.println("La OTP ES: " + nuevaClaveVirtual);
			return nuevaClaveVirtual;
		}
		System.out.println("No encontré la OTP");
		return "No encontré la OTP"; // SI NO SE ENCUENTRA EL PATRÓN, DEVOLVER NULL O MANEJAR DE OTRA MANERA SEGÚN SEA NECESARIO
	}
	
	public static void eliminarUltimoCorreoConOTP(String usuario, String contrasena) throws Exception {
	    Properties propiedades = new Properties();
	    propiedades.setProperty("mail.store.protocol", "imaps");
	    propiedades.setProperty("mail.imaps.ssl.protocols", "TLSv1.2");
	    propiedades.setProperty("mail.imaps.ssl.trust", "*");

	    Session sesion = Session.getInstance(propiedades);

	    Store tienda = sesion.getStore("imaps");
	    tienda.connect("imap.gmail.com", usuario, contrasena);

	    Folder bandeja = tienda.getFolder("inbox");
	    bandeja.open(Folder.READ_WRITE);  // Asegúrate de tener acceso de lectura y escritura

	    Message[] mensajes = bandeja.getMessages();
	    if (mensajes.length > 0) {
	        Message ultimoMensaje = mensajes[mensajes.length - 1];  // El último mensaje

	        String contenido = obtenerContenidoMensaje(ultimoMensaje);
	        // Verificar si es un correo con OTP
	        if (extraerCodigoActivacion(contenido) != null) {
	            // Marcar para eliminación
	            ultimoMensaje.setFlag(Flags.Flag.DELETED, true);
	            System.out.println("El mensaje con OTP ha sido marcado para eliminación.");
	        } else {
	            System.out.println("El último mensaje no contiene un OTP.");
	        }

	        // Cerrar la bandeja con expunge para que se eliminen los mensajes marcados
	        bandeja.close(true);  // true para expurgar (eliminar los correos marcados)
	    } else {
	        System.out.println("No se encontraron mensajes en la bandeja de entrada.");
	        bandeja.close(false);  // Cierra la bandeja sin expurgar si no hay mensajes
	    }

	    tienda.close();
	}

	private static String obtenerContenidoMensaje(Message mensaje) throws Exception {
		Object contenido = mensaje.getContent();
		if (contenido instanceof Multipart) {
			Multipart multipart = (Multipart) contenido;
			BodyPart parte = multipart.getBodyPart(0); // OBTÉN LA PRIMERA PARTE DEL MENSAJE
			return parte.getContent().toString();
		} else {
			return contenido.toString();
		}
	}

	public void seleccionarValorEnPickerWheelAnio(String locator, String anio) {
		MobileElement element = (MobileElement) findElement("xpath", locator);

		int startYear = 2022; // AÑO INICIAL, AJUSTAR SEGÚN SEA NECESARIO
		int yOffsetIncrement = 40; // INCREMENTO EN YOFFSET POR CADA AÑO

		int year = Integer.parseInt(anio);
		int yOffset = (startYear - year) * yOffsetIncrement;

		if (year > startYear) {
			throw new IllegalArgumentException("Año no válido: " + anio);
		}

		Point location = element.getCenter();
		int startX = location.getX();
		int startY = location.getY();

		new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startX, startY + yOffset)).release().perform();

		System.out.println("Moví elemento");
	}

	public void scrollToElementMonth(String locator, String mes) {
		MobileElement element = (MobileElement) findElement("xpath", locator);
		int yOffset = 0; // Ajusta el valor según sea necesario

		switch (mes) {
		case "Enero":
			yOffset = 0;
			break;
		case "Febrero":
			yOffset = -35;
			break;
		case "Marzo":
			yOffset = -70;
			break;
		case "Abril":
			yOffset = -105;
			break;
		case "Mayo":
			yOffset = -140;
			break;
		case "Junio":
			yOffset = -175;
			break;
		case "Julio":
			yOffset = -210;
			break;
		case "Agosto":
			yOffset = -245;
			break;
		case "Septiembre":
			yOffset = -280;
			break;
		case "Octubre":
			yOffset = -315;
			break;
		case "Noviembre":
			yOffset = -350;
			break;
		case "Diciembre":
			yOffset = -385;
			break;
		default:
			throw new IllegalArgumentException("Mes no válido: " + mes);
		}
		Point location = element.getCenter();
		int startX = location.getX();
		int startY = location.getY();

		new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startX, startY + yOffset)).release().perform();

		System.out.println("Moví elemento");
	}


	public void scrollToElementDay(String locator, String dia) {
		MobileElement element = (MobileElement) findElement("xpath", locator);

		int minDay = 1; // DÍA MÍNIMO
		int maxDay = 31; // DÍA MÁXIMO

		int day = Integer.parseInt(dia);

		if (day < minDay || day > maxDay) {
			throw new IllegalArgumentException("Día no válido: " + dia);
		}

		// CONVERTIR EL ELEMENTO A IOSELEMENT
		IOSElement iosElement = (IOSElement) element;

		// LIMPIAR EL CONTENIDO EXISTENTE
		iosElement.clear();

		// INGRESAR EL DÍA DIRECTAMENTE
		iosElement.sendKeys(String.valueOf(day));

		System.out.println("Moví elemento");
	}

	public void scrollToElementYear(String locator, String anio) {
		MobileElement element = (MobileElement) findElement("xpath", locator);

		int baseYear = 2024; // AÑO MÁXIMO, AJUSTA SEGÚN SEA NECESARIO
		int minYear = 1904; // AÑO MÍNIMO, AJUSTA SEGÚN SEA NECESARIO

		int year = Integer.parseInt(anio);

		if (year < minYear || year > baseYear) {
			throw new IllegalArgumentException("Año no válido: " + anio);
		}

		// CONVERTIR EL ELEMENTO A IOSELEMENT
		IOSElement iosElement = (IOSElement) element;

		// LIMPIAR EL CONTENIDO EXISTENTE
		iosElement.clear();

		// INGRESAR EL AÑO DIRECTAMENTE
		iosElement.sendKeys(String.valueOf(year));

		System.out.println("Moví elemento");
	}
	
	    
    public void scrollToElementBanco(String locator, String banco) {
        MobileElement element = (MobileElement) findElement("xpath", locator);
        int yOffset = getOffsetForBanco(banco);

        Point location = element.getCenter();
        int startX = location.getX();
        int startY = location.getY();

        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, startY + yOffset))
                .release()
                .perform();

        System.out.println("Moví elemento");
    }
    
    public static void scrollPickerWheelToValue(AndroidDriver<MobileElement> driver, MobileElement pickerWheelElement, String targetValue) {
        String currentValue;
        do {
            currentValue = pickerWheelElement.getText();
            if (!currentValue.equals(targetValue)) {
                // SCROLL HACIA ARRIBA
                driver.executeScript("mobile: scroll", "{direction: 'down', element: '" + pickerWheelElement.getId() + "'}");
            }
        } while (!currentValue.equals(targetValue));
    }

    public static void scrollPickerWheelToValue(IOSElement pickerWheelElement, String targetValue) {
        // OBTENER EL VALOR ACTUAL DEL DÍA
        String currentValue = pickerWheelElement.getText();

        // SI EL VALOR ACTUAL NO COINCIDE CON EL VALOR OBJETIVO, CONTINUAR DESPLAZANDO
        while (!currentValue.equals(targetValue)) {
            // SCROLL HACIA ARRIBA
            Dimension size = pickerWheelElement.getSize();
            int startX = size.width / 2;
            int startY = (int) (size.height * 0.8);
            int endY = (int) (size.height * 0.2);
            new TouchAction<>(driver)
                    .press(PointOption.point(startX, startY))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();

            // ACTUALIZAR EL VALOR ACTUAL DESPUÉS DEL DESPLAZAMIENTO
            currentValue = pickerWheelElement.getText();
        }
    }
    
    public static void setInputValue(IOSElement pickerWheelElement) {
        // LIMPIA EL CAMPO PARA ASEGURARSE DE QUE ESTÉ VACÍO ANTES DE INGRESAR EL NUEVO VALOR
        pickerWheelElement.clear();
//
//        // Ingresa el valor deseado en el campo
//        pickerWheelElement.setValue(targetValue);
    }
    
    public static void setInputValue(IOSElement pickerWheelElement, String targetValue) {
        // INGRESA EL VALOR DESEADO EN EL CAMPO SIN BORRAR EL VALOR EXISTENTE
        pickerWheelElement.setValue(targetValue);
    }
    

    public static void clearInputValue(IOSElement pickerWheelElement) {
        // ENVÍA UNA SECUENCIA DE RETROCESO PARA ELIMINAR EL CONTENIDO DEL CAMPO
        pickerWheelElement.sendKeys(Keys.BACK_SPACE);
    }

    private int getOffsetForBanco(String banco) {
        switch (banco.toUpperCase()) {
            case "ALIANZA FIDUCIARIA":
                return -50;
            case "BAN100":
                return -100;
            case "BANCAMIA":
                return -150;
            case "BANCO UNION COLOMBIANO":
                return -500;
            default:
                throw new IllegalArgumentException("Nombre de banco no válido: " + banco);
        }
    }
    
    public void scrollHorizontalHalfScreen() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

        int startX = (int) (screenWidth * 0.2); 
        int endX = (int) (screenWidth * 0.8);   
        int y = screenHeight / 2;

        new TouchAction<>(driver)
            .press(PointOption.point(startX, y))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
            .moveTo(PointOption.point(endX, y))
            .release()
            .perform();

        System.out.println("Realizado scroll horizontal de izquierda a derecha");
    }
    
    public void scrollVerticalNegative() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.9); 
        int endY = (int) (screenHeight * 0.5);    

        new TouchAction<>(driver)
            .press(PointOption.point(startX, startY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
            .moveTo(PointOption.point(startX, endY))
            .release()
            .perform();

        System.out.println("Realizado scroll vertical negativo");
    }
    
    public void scrollVerticalPositive() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.4);  
        int endY = (int) (screenHeight * 0.5);    

        new TouchAction<>(driver)
            .press(PointOption.point(startX, startY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
            .moveTo(PointOption.point(startX, endY))
            .release()
            .perform();

        System.out.println("Realizado scroll vertical positivo");
    }
     
    public void selectTipoId(String tipoId) {
    	MobileElement element = null;

        switch (tipoId) {
            case "Cédula de ciudadania":
            	element = findElement("xpath",  RecargaTarjetaCivicaPage.CC_BTN);
                break;
            case "Al portador (número de tarjeta cívica)":
            	element = findElement("xpath", RecargaTarjetaCivicaPage.AL_PORTADOR_BTN);
                break;
            case "Cédula de extranjera":
            	element = findElement("xpath", RecargaTarjetaCivicaPage.CE_BTN);
                break;
            case "Número único de identidad personal":
            	element = findElement("xpath", RecargaTarjetaCivicaPage.NUM_UNICO_BTN);
                break;
            case "Pasaporte":
            	element = findElement("xpath", RecargaTarjetaCivicaPage.PASAPORTE_BTN);
                break;
            case "Permiso especial de permanencia":
            	element = findElement("xpath",RecargaTarjetaCivicaPage.PERMISO_ESPECIAL_BTN);
                break;
            case "Permiso por protección temporal":
            	element = findElement("xpath", RecargaTarjetaCivicaPage.PERMISO_PROTECCION_BTN);
                break;
            case "Tarjeta de identidad":
            	element = findElement("xpath", RecargaTarjetaCivicaPage.TI_BTN);
                break;
            // AGREGA OTROS CASOS SEGÚN SEA NECESARIO
            default:
                throw new IllegalArgumentException("Tipo de documento no válido: " + tipoId);
        }

        if (element != null) {
            element.click();
            System.out.println("Clic en el elemento para tipoId: " + tipoId);
        } else {
            throw new IllegalArgumentException("Tipo de documento no válido: " + tipoId);
        }
    }
    
    public boolean isTextPresent(String locatorType, String locator, String expectedText) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By by = null;

        switch (locatorType) {
            case "name":
                by = By.name(locator);
                break;
            case "id":
                by = By.id(locator);
                break;
            case "xpath":
                by = By.xpath(locator);
                break;
            default:
                throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 1); // ESPERA DE 5 SEGUNDOS
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

            // VERIFICA QUE EL TEXTO DEL ELEMENTO SEA IGUAL AL TEXTO ESPERADO
            return element.getText().contains(expectedText);
        } catch (Exception e) {
            return false; // RETORNA FALSE SI EL TEXTO NO ESTÁ PRESENTE DESPUÉS DE LA ESPERA
        }
    }
    
    
    public boolean esElementoVisible(String textoElemento) {
        return textoElemento != null && !textoElemento.isEmpty();
    }
    
    
    public boolean esperarElementVisibilityBoolean(String locatorType, String locator) {
        By by = null;
        switch (locatorType) {
            case "name":
                by = By.name(locator);
                break;
            case "id":
                by = By.id(locator);
                break;
            case "xpath":
                by = By.xpath(locator);
                break;
            default:
                throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }

        try {
            contador++;
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;  /*EL ELEMENTO ESTÁ VISIBLE*/
        } catch (Exception e) {
            if (!(contador == 15)) {
                Utilidades.esperaMiliseg(500);
                return esperarElementVisibilityBoolean(locatorType, locator);  /*INTENTA NUEVAMENTE*/
            } else {
                fail("No se encontró el elemento: " + locator + ", debido a: " + e.getMessage());
                return false;  /*NO SE ENCONTRÓ EL ELEMENTO DESPUÉS DE INTENTAR VARIAS VECES*/
            }
        } finally {
            contador = 0;
        }
    }
    
    /*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  
    * PERFORMANCE ÚNICO PARA VALIDAR LAS POSIBLES ALTERNATIVAS DE CONTRASEÑAS FALLIDAS EL INGRESO    *
    *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  */
	public static void switchSelectAction(String contrasenia) {
		String validatePass = contrasenia;
		String action;
	    
	    if (validatePass.startsWith("19") || validatePass.startsWith("20")) {
	        action = "Contraseña que comienza por 19 ó 20";
	        assert action.equals("Contraseña que comienza por 19 ó 20") : "La acción debería ser Contraseña que comienza por 19 ó 20";
	    } else if (!validatePass.equals(BaseUtil.baseContrasena)) {
	        action = "Contraseña diferente a la existente";
	        BaseUtil.actionSwitch = action;
	        assert action.equals("Contraseña diferente a la existente") : "La acción debería ser Contraseña diferente a la existente";
	    } else {
	        action = "Otra acción"; /*SI NO COINCIDE CON NINGUNO DE LOS CASOS ANTERIORES*/
	        assert action.equals("Otra acción") : "La acción debería ser Otra acción";
	    }

	    switch (action) {
	        case "Contraseña que comienza por 19 ó 20":
	            try {
	        		esperarElementVisibility("xpath", CambioClaveCivicaPage.PASS_NO_VALID);
	                Utilidades.tomaEvidencia("La contraseña no debe comenzar por '19' o '20'. Intente de nuevo");
	    			Utilidades.esperaMiliseg(800);
	                System.out.println("La contraseña no debe comenzar por '19' o '20'.");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            break;

	        case "Contraseña diferente a la existente":
	            try {
	        		esperarElementVisibility("xpath", CambioClaveCivicaPage.PASS_NO_VALID);
	                Utilidades.tomaEvidencia("La contraseña no coincide con la contraseña base. Intente de nuevo.");
	    			Utilidades.esperaMiliseg(800);
	                System.out.println("La contraseña no coincide con la contraseña base.");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            break;

	        default:
	            /*ACCIÓN POR DEFECTO SI 'ACCION' NO COINCIDE CON NINGÚN CASE*/
	            System.out.println("Continúa flujo correcto gracias a que la contraseña cumple");
	    }
	    System.out.println("Continúa flujo correcto gracias a que la contraseña cumple");
	}
    
    /*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  
    * MÉTODO ÚNICO PARA SELECCIONAR LA HORA PARA PROGRAMAR UN VIAJE EN EL MÓDULO TRANSPORTE CÍVICA   *
    *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  */
    public void scrollToElementHour(AppiumDriver<MobileElement> driver, String hour) {
    	
    	int hora = Integer.parseInt(hour);
        if (hora < 1 || hora > 12) {
            throw new IllegalArgumentException("Hora no válida: " + hour);
        }

        /*LÓGICA PARA OBTENER EL SELECTOR DE HORA EN TU APLICACIÓN*/
        MobileElement selectorDeHora = driver.findElement(By.xpath("(//XCUIElementTypePickerWheel)[1]"));

        int yOffset = -40 * (hora - 1); /*CALCULA EL DESPLAZAMIENTO VERTICAL BASADO EN LA HORA*/

        int startX = selectorDeHora.getLocation().getX() + (selectorDeHora.getSize().getWidth() / 2);
        int startY = selectorDeHora.getLocation().getY() + (selectorDeHora.getSize().getHeight() / 2);

        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, startY + yOffset))
                .release()
                .perform();

        System.out.println("Moví elemento");
    }
    
    /*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
    * MÉTODO ÚNICO PARA SELECCIONAR LOS MINUTOS PARA PROGRAMAR UN VIAJE EN EL MÓDULO TRANSPORTE CÍVICA  *
    *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  */
    public void scrollToElementMinute(AppiumDriver<MobileElement> driver, String minute) {
    	
    	int minuto = Integer.parseInt(minute);
        if (minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException("Minuto no válido: " + minute);
        }

        int yOffset = -5 * minuto; /*AJUSTA EL VALOR SEGÚN SEA NECESARIO*/

        /*LÓGICA PARA OBTENER EL SELECTOR DE MINUTOS EN TU APLICACIÓN*/
        MobileElement selectorDeMinutos = driver.findElement(By.xpath("(//XCUIElementTypePickerWheel)[2]"));

        int startX = selectorDeMinutos.getLocation().getX() + (selectorDeMinutos.getSize().getWidth() / 2);
        int startY = selectorDeMinutos.getLocation().getY() + (selectorDeMinutos.getSize().getHeight() / 2);

        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, startY + yOffset))
                .release()
                .perform();

        System.out.println("Moví elemento de minutos");
    }
    
    /**
     * Método para validar un elemento visible que retorna un boolean
     * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
     * @return check = true or false de a cuerdo si el elemento es visible o no
     */
	public boolean validateElementVisibilityCatch(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			check = BaseUtil.driver.findElement(by).isDisplayed();
			System.out.println("Se verifica presencia del elemento: " + locator);
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);
		}
		return check;
	}
	
	public void waitElementVisibilityWeb(String locatorType, String locator) {
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			contador++;
		} catch (Exception e) {
			if (!(contador == 15)) {
				Utilidades.esperaMiliseg(500);
				waitElementVisibilityWeb(locatorType, locator);
			} else {
				fail("No se encontró el elemento: " + locator + ", debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
    
	/**
     * Método que espera hasta que un elemento se desaparezca de la pantalla
     * Tiempo que pregunta repetitivo: Cada 2 Seg
     * Tiempo máximo de espera: 1 minuto
     * 
     * @author Jonathan Vargas Ríos
     * 
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
     * @param maxWait en segundos
     */
    public void esperaCargaElemento(String locator, int maxWait) {
        boolean isElementProgressBarVisible = true;
        boolean elementVisible = true;
        int timeCont = 1;
        
        while(elementVisible) {
            System.out.println("Cargando... " + locator);
            isElementProgressBarVisible = validateElementVisibilityCatch("xpath", locator);
            Utilidades.esperaMiliseg(1000);
            timeCont++;
            
            if(!isElementProgressBarVisible) {
                elementVisible = false;
                Utilidades.esperaMiliseg(5000);
                System.out.println("Terminó la espera del elemento.");
                
            } else if(timeCont == maxWait) {
        		Utilidades.tomaEvidencia("Tiempo de espera superado");
        		BaseUtil.causaFalla = "Tiempo de espera superado";
    			fail("Tiempo de espera superado");
            }
        }
    }
    
    public boolean esperaElementVisibilityWeb(String locatorType, String locator) {
		BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			check = BaseUtil.chromeDriver.findElement(by).isDisplayed();
			System.out.println("Se verifica presencia del elemento: " + locator);
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);
		}
		return check;
    }
    
    
    public void esperaCargaElementoWeb(String locator, int maxWait) {
        boolean isElementProgressBarVisible = true;
        boolean elementVisible = true;
        int timeCont = 1;
        
        while(elementVisible) {
            System.out.println("Cargando... " + locator);
            isElementProgressBarVisible = esperaElementVisibilityWeb("xpath", locator);
            Utilidades.esperaMiliseg(1000);
            timeCont++;
            
            if(!isElementProgressBarVisible) {
                elementVisible = false;
                Utilidades.esperaMiliseg(5000);
                System.out.println("Terminó la espera del elemento.");
                
            } else if(timeCont == maxWait) {
    			WebRedebanPageObjects.cerrarWebRedeban();
    			Utilidades.tomaEvidencia("Web - Tiempo de espera superado");
        		BaseUtil.causaFalla = "Tiempo de espera superado";
    			fail("Tiempo de espera superado");
            }
        }
    }
    
    public static void causaFalla(String detalle) {
		Utilidades.tomaEvidencia(detalle);
		BaseUtil.causaFalla = detalle.trim();
    }
}
