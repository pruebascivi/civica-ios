package civica.nacional.iOS.steps;

import static org.junit.Assert.fail;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.TransporteCivicaPageObjects;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class TransporteCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	Utilidades utilidades;
	TransporteCivicaPageObjects transporteCivPage;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();

	@Step
	public void enterBeneficiosViajevModule() {
		try {
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.MENU_HAMBURGUESA);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.MENU_HAMBURGUESA);
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.USER_BTN_HM);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.USER_BTN_HM);
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.BENEFICIOS_BTN);
			Utilidades.tomaEvidencia("Valido opción 'Beneficios de viaje' en menú hamburguesa");
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BENEFICIOS_BTN);
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.BENEFICIOS_MODULE_TXT);
			
		} catch (Exception e) {
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.MENU_HAMBURGUESA) : "El elemento !Aún no tienes beneficios activos¡ no es visible después de esperar";
			Utilidades.tomaEvidencia("El elemento !Aún no tienes beneficios activos¡ no es visible después de esperar");
			fail("No se pudo interactuar con el elemento o tiempo de espera superado" + e);
		}  
	}
	
	@Step
	public void validateMsn() {
		try {
			boolean isElementVisible = utilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.TXT_WITHOUT_BENEFITS);
			if (isElementVisible) {
				String beneficiosViaje = utilidadesTCS.obtenerTexto("xpath",TransporteCivicaPageObjects.TXT_WITHOUT_BENEFITS);
				UtilidadesTCS.validateTextContainsStringBoolean(beneficiosViaje, "Aún no tienes beneficios activos");
				Utilidades.tomaEvidencia("Valido mensaje: " + beneficiosViaje);
				
			} else {
				Utilidades.tomaEvidencia("El elemento !Aún no tienes beneficios activos¡ no es visible después de esperar");
			}
	
		} catch (Exception e) {
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.MENU_HAMBURGUESA) : "El elemento !Aún no tienes beneficios activos¡ no es visible después de esperar";
			Utilidades.tomaEvidencia("El elemento !Aún no tienes beneficios activos¡ no es visible después de esperar");
		    fail("El elemento !Aún no tienes beneficios activos¡ no es visible después de esperar" + e);
		}  
	}
	
	@Step
	public void validateFavoriteRoutes() {
		try {
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_BENEFICIOS_VIAJE);
			WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TransporteCivicaPageObjects.SALDOS_HOME)));
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.SALDOS_HOME);
			MobileElement elemento = driver.findElement(By.xpath(TransporteCivicaPageObjects.HOME_W_ARE_U_GOING));
			utilidadesTCS.moverElementoTouch(elemento, -350);
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING);
			
			boolean isElementVisible = utilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.EMPIEZA_A_VIAJAR);
			if (isElementVisible) {
				try {
					Utilidades.esperaMiliseg(500);
					Utilidades.tomaEvidencia("Valido que el usuario no tiene trayectos guardados como favoritos y se muestra el mensaje 'Empieza a viajar con Cívica'");

				} catch (Exception e) {
					fail("No se pudo interactuar con el elemento" + e);
				}
			} else {
				MobileElement elementoTrayecto = driver.findElement(By.xpath(TransporteCivicaPageObjects.HOME_W_ARE_U_GOING));
				Utilidades.tomaEvidencia("Valido que el módulo trayectos guardados está presente");
				utilidadesTCS.moverElementoTouchHorizontal(elementoTrayecto, -250);
			    Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("Valido que el usuario tiene trayectos guardados y estos trayectos se muestran por tarjetas");
			}
			
		} catch (Exception e) {
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING) : "El elemento no es visible después de esperar";
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("El elemento no es visible después de esperar" + e);
		}  
	}
	
	@Step
	public void validateTripProgressSection() {
		try {
			
			boolean isAllJourneysVisible = utilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.TXT_TRIP_PROGRESS);

			if (isAllJourneysVisible) {
			    System.out.println("Valido que el usuario está registrado en Cívica Pay y la app muestra el módulo de 'Viaje en curso'");
				Utilidades.tomaEvidencia("Valido que el usuario está registrado en Cívica Pay y la app muestra el módulo de 'Viaje en curso'");

			} else {
			    System.out.println("Valido que el usuario no está registrado en Cívica Pay y la app no muestra el módulo de 'Viaje en curso'");
				Utilidades.tomaEvidencia("Valido que el usuario no está registrado en Cívica Pay y la app no muestra el módulo de 'Viaje en curso'");
			}
			
		} catch (Exception e) {
		    fail("Hubo un error esperando el elemento. " + e);
		}  
	}
	
	@Step
	public void validateBtnAllJourneys () {
		try {
			
			boolean isAllJourneysVisible = utilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.EMPIEZA_A_VIAJAR);

			if (!isAllJourneysVisible) {
				try {
					
					utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.ALL_JOURNEYS);
					UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.TXT_ALL_JOURNEYS_MODULE);
					Utilidades.tomaEvidencia("Valido la opción 'Ver todos' que permite al usuario dirigirse a la pantalla donde se encuentran guardados todos los trayectos");
					utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_TRAYECTOS_GUARDADOS);
					
				} catch (Exception e) {
				    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.MODULE_TRAYECTOS_SAVES) : "El elemento !Ver todos¡ no es visible después de esperar";
					fail("No se pudo interactuar con el elemento" + e);
				}
			} else {
				Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("Valido que la opción 'Ver todos' no se encuentra presente.");
			}
			
		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.ALL_JOURNEYS) : "El elemento no es visible después de esperar";
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("El elemento no es visible después de esperar" + e);
		}  
	}
	
	@Step
	public void validateListJourneys () {
		try {
			boolean isAllJourneysVisible = utilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.TRAYECTO_PRESENT);

			if (isAllJourneysVisible) {
				WebDriverWait wait = new WebDriverWait(driver, 1);
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TransporteCivicaPageObjects.SALDOS_HOME)));
				UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.SALDOS_HOME);
				Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("Valido que si hay trayectos guardado.");
				
			} else {
			    System.out.println("No se pudo ingresar al módulo Trayectos guardados, ya que no hay ningún trayecto para listar.");
			}

		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.SALDOS_HOME) : "El elemento no es visible después de esperar";
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("El elemento no es visible después de esperar" + e);
		} 
	}

	@Step
	public void validateNearPlaces() {
		try {
			Utilidades.esperaMiliseg(2000);
			MobileElement elemento = driver.findElement(By.xpath(TransporteCivicaPageObjects.HOME_W_ARE_U_GOING));
			utilidadesTCS.moverElementoTouch(elemento, -350);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.MODULE_NEAR_PLACES);
			MobileElement lugaresCercanos1 = driver.findElement(By.xpath(TransporteCivicaPageObjects.LC_COMERCIO));
			Utilidades.esperaMiliseg(200);
			Utilidades.tomaEvidencia("Valido que las opciones de 'Lugares cercanos' estén presentes 1.");
			utilidadesTCS.moverElementoTouchHorizontal(lugaresCercanos1, -250);
			MobileElement lugaresCercanos2 = driver.findElement(By.xpath(TransporteCivicaPageObjects.LC_FINANCIERO));
			Utilidades.esperaMiliseg(200);
			Utilidades.tomaEvidencia("Valido que las opciones de 'Lugares cercanos' estén presentes 2.");
			utilidadesTCS.moverElementoTouchHorizontal(lugaresCercanos2, -350);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Valido que las opciones de 'Lugares cercanos' estén presentes 3.");

		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.MODULE_TRAYECTOS_SAVES) : "El elemento no es visible después de esperar";
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("El elemento no es visible después de esperar" + e);
		}  
	}
	
	@Step
	public void validateWhereAreUGoing() {
		try {
			
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING);
			Utilidades.esperaMiliseg(5000);
			boolean aDondeVas = utilidadesTCS.validateElementEnabled("xpath", TransporteCivicaPageObjects.FIELD_W_ARE_U_GOING);
			utilidadesTCS.validateStatusElement(aDondeVas);
			Utilidades.esperaMiliseg(2000);
			utilidadesTCS.esperarElementVisibilityBoolean("xpath", TransporteCivicaPageObjects.JOURNAYS_SAVES_INTO_W_ARE_U_GOING);
			boolean trayectosGuardados = utilidadesTCS.validateElementEnabled("xpath", TransporteCivicaPageObjects.JOURNAYS_SAVES_INTO_W_ARE_U_GOING);
			utilidadesTCS.validateStatusElement(trayectosGuardados);
			Utilidades.tomaEvidencia("Valido campos de la sección 'A dónde vas?'");

		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.FIELD_W_ARE_U_GOING) : "El elemento no es visible después de esperar";
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.JOURNAYS_SAVES_INTO_W_ARE_U_GOING) : "El elemento no es visible después de esperar";
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("El elemento no es visible después de esperar" + e);
		}
	}
	
	@Step
	public void validateListJourneysSavesWAreUGo() {
		try {
			
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.SEE_ALL_SINCE_W_ARE_U_GOING);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Valido trayectos guardados en ver todos dentro de la sección 'A dónde vas'");
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_SEE_ALL_SINCE_W_ARE_U_GOING);

		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.SEE_ALL_SINCE_W_ARE_U_GOING) : "El elemento 'Ver todos' desde  A donde vas? no es visible después de esperar";
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.MODULE_TRAYECTOS_SAVES) : "El elemento 'Trayectos guardados' desde A donde vas? no es visible después de esperar";
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("El elemento no es visible después de esperar" + e);
		}
	}
	
	@Step
	public void validatePresenceSelectLocation() {
		try {
			Utilidades.esperaMiliseg(5000);	
	        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.SALDOS_HOME);
			Utilidades.esperaMiliseg(1000);	
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING);
			Utilidades.esperaMiliseg(2000);	
			Point startPoint = new Point(200, 365);
			utilidadesTCS.moverElementoMapaCoordenadas(startPoint, -150);
			utilidadesTCS.moverElementoMapaCoordenadas(startPoint, -150); 
			Utilidades.esperaMiliseg(1000);
		    Utilidades.tomaEvidencia("Valido que al mover el mapa se muestra la opción de seleccionar ubicación y se minimizan los trayectos guardados");		
	    	//boolean selectLoctation = utilidadesTCS.validateElementEnabled("xpath", TransporteCivicaPageObjects.BTN_SELECT_LOCATION);
		    //utilidadesTCS.validateStatusElement(selectLoctation);
			utilidadesTCS.clickByCoordinates(197, 754);
			Utilidades.esperaMiliseg(2000);
		    Utilidades.tomaEvidencia("Valido que al accionar la pestaña oculta, muestra de nuevo los trayectos guardados");
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_BENEFICIOS_VIAJE);

		} catch (Exception e) {
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.MAP_FROMLOCATION) : "El elemento de ubicación en el mapa no es visible después de esperar";
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		}    
	}
	
	@Step
	public void enterIntoJourneysSaves() {
		try {
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.SALDOS_HOME);
			Utilidades.esperaMiliseg(1500);
			MobileElement elemento = driver.findElement(By.xpath(TransporteCivicaPageObjects.HOME_W_ARE_U_GOING));
			utilidadesTCS.moverElementoTouch(elemento, -200);

			boolean isAllJourneysVisible = utilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.TRAYECTO_PRESENT);
			if (isAllJourneysVisible) {
				
				utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.TRAYECTO_PRESENT);
				UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.START_JOURNERY);
			    Utilidades.tomaEvidencia("Valido que al ingresar a algún trayecto guardado, redirecciona a la sección 'Empezar trayecto'");
				utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects. BTN_RETURN_SINCE_BENEFICIOS_VIAJE );
				
			} else {
			    System.out.println("No se encontraron trayectos guardados");
			    Utilidades.tomaEvidencia("No se encontraron trayectos guardados");
			}

		} catch (Exception e) {
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.SALDOS_HOME) : "El elemento no es visible después de esperar";
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.START_JOURNERY) : "El elemento no es visible después de esperar";
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		}    
	}
	
	@Step
	public void validateOptionsIntoWhereAreUGoing() {
		try {
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.SALDOS_HOME);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING);
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.FIELD_INTO_W_ARE_U_GOING);
			utilidadesTCS.clickByCoordinates(110, 130);
			Utilidades.esperaMiliseg(800);
			boolean currentLocation = utilidadesTCS.validateElementEnabled("xpath", TransporteCivicaPageObjects.CURRENT_LOCATION);
			utilidadesTCS.validateStatusElement(currentLocation);
			boolean whereAreUGoing = utilidadesTCS.validateElementEnabled("xpath", TransporteCivicaPageObjects.FIELD_W_ARE_U_GOING);
			utilidadesTCS.validateStatusElement(whereAreUGoing);
			boolean selectOnTheMap = utilidadesTCS.validateElementEnabled("xpath", TransporteCivicaPageObjects.BTN_SELECT_ON_THE_MAP);
			utilidadesTCS.validateStatusElement(selectOnTheMap);
		    String txtCurrentLocation = utilidadesTCS.obtenerTexto("xpath", TransporteCivicaPageObjects.CURRENT_LOCATION);
		    Utilidades.tomaEvidencia("Valido opciones de la sección 'A dónde vas?' y también que al ingresar por primera vez, en el campo origen la app lo completa con: " + txtCurrentLocation);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.CURRENT_LOCATION);
		    Utilidades.tomaEvidencia("Valido que la app permite diligenciar una ubicación diferente y se puede seleccionar en el mapa");
		    
		} catch (Exception e) {
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.FIELD_W_ARE_U_GOING) : "El elemento no es visible después de esperar";
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		}    
	}
	
	@Step
	public void inputAdress(String direccionActual, String destino) {
		try {
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.CAMPO_INGRESA_DIRECCION);
			//utilidadesTCS.ingresarUsuario("xpath", TransporteCivicaPageObjects.CURRENT_LOCATION, direccionActual);
			//utilidadesTCS.clickByCoordinates(130, 186);
			utilidadesTCS.clickByCoordinates(130, 317);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.FIELD_A_DONDE_VAS);
			//utilidadesTCS.ingresarUsuario("xpath", TransporteCivicaPageObjects.FIELD_W_ARE_U_GOING, destino);
			//utilidadesTCS.clickByCoordinates(130, 240);
			utilidadesTCS.clickByCoordinates(130, 378);
		    Utilidades.tomaEvidencia("Ingreso dirección actual y destino");
		    
		} catch (Exception e) {
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.CURRENT_LOCATION) : "El elemento no es visible después de esperar";
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.FIELD_W_ARE_U_GOING) : "El elemento no es visible después de esperar";
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		}
	}
	
	@Step
	public void inputDate(String date) {
		try {
			utilidadesTCS.clickByCoordinates(110, 275);
			Utilidades.esperaMiliseg(500);
	        utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.DATE_BIRTH_INPUT_FIELD);
	        IOSElement pickerWheelElementDay = (IOSElement) driver.findElementByXPath(TransporteCivicaPageObjects.DAY_FIELD_TO_SCROLL);
	        IOSElement pickerWheelElementMonth = (IOSElement) driver.findElementByXPath(TransporteCivicaPageObjects.DAY_FIELD_TO_SCROLL);
	        utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.DAY_FIELD_TO_SCROLL);
	        UtilidadesTCS.setInputValue(pickerWheelElementDay);
	        utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.DATE_BIRTH_INPUT_FIELD);
	        utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.MONTH_FIELD_TO_SCROLL);
	        UtilidadesTCS.setInputValue(pickerWheelElementMonth);
	        utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.DATE_BIRTH_INPUT_FIELD);
	        utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.YEAR_FIELD_TO_SCROLL);
	        UtilidadesTCS.setInputValue(pickerWheelElementMonth);
	        utilidadesTCS.ingresarUsuario("xpath", TransporteCivicaPageObjects.DATE_BIRTH_INPUT_FIELD, date);

		} catch (Exception e) {
		    fail("El elemento no es visible después de esperar" + e);
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		}	
	}
	
	@Step
	public void inputDepertureTime(String hora, String minuto, String jornada) {
		try {
	        utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.FIELD_DEPERTURE);
	        IOSElement pickerWheelElementHour = (IOSElement) driver.findElementByXPath(TransporteCivicaPageObjects.FIELD_HOUR);
	        UtilidadesTCS.setInputValue(pickerWheelElementHour);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.FIELD_HOUR);
			Utilidades.esperaMiliseg(800);
	        utilidadesTCS.scrollToElementHour(driver, hora);
			Utilidades.esperaMiliseg(100);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.FIELD_MINUTE);
			Utilidades.esperaMiliseg(800);
	        utilidadesTCS.scrollToElementMinute(driver, minuto);
		    utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_ACEPTAR_HORA);
		    Utilidades.tomaEvidencia("Selecciono la fecha y horario de salida");
		    
		} catch (Exception e) {
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("No se pudo interactuar con el elemento" + e);
		}	
	}
	
	@Step
	public void validateSuggestedRoutes() {
		try {
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_BACK_FROM_MORE_SERVICES);
			Utilidades.esperaMiliseg(1000);
		    Utilidades.tomaEvidencia("Valido que al regresar de más servicios, la aplicación muestra trayectos sugeridos");
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_BACK_FROM_SUGGESTED_ROUTES);
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_BENEFICIOS_VIAJE);
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_BENEFICIOS_VIAJE);
			Utilidades.esperaMiliseg(800);
		    
		} catch (Exception e) {
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.SUGGESTED_ROUTES) : "El elemento no es visible después de esperar";
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		}	
	}
	
	@Step
	public void validateBtnQRPublicHome() {
		try {
			boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

			if (isElementLogoutVisible) {
				try {
					utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
				} catch (Exception e) {
					fail("No se pudo interactuar con el elemento" + e);
				}
			} else {
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CERRAR_MH);
			}
			Utilidades.esperaMiliseg(1000);
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.TRAVEL_WITH_QR);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING);
			Utilidades.esperaMiliseg(5000);
		    Utilidades.tomaEvidencia("Valido que la aplicación permite navegar en la aplicación sin estar logueado e ingresar a la sección 'Planear un viaje'");
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_BENEFICIOS_VIAJE);
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.TRAVEL_WITH_QR);
			Utilidades.esperaMiliseg(800);
			MobileElement elemento = driver.findElement(By.xpath(TransporteCivicaPageObjects.HOME_W_ARE_U_GOING));
			utilidadesTCS.moverElementoTouch(elemento, -250);
			Utilidades.tomaEvidencia("Valido presencia del mensaje ¡Empieza a viajar! en trayectos guardados");
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.TRAVEL_WITH_QR);
			Utilidades.esperaMiliseg(900);
			Utilidades.tomaEvidencia("Valido Popup 'Ingresa a la App. Debes iniciar sesión para disfrutar de nuestras funcionalidades'");
		    UtilidadesTCS.esperarElementVisibility( "xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC);
			Utilidades.esperaMiliseg(1000);
			Utilidades.esperaMiliseg(500);
		    Utilidades.tomaEvidencia("Valido que la aplicación invita al usuario a loguearse");
		    
		} catch (Exception e) {
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("No se pudo interactuar con el elemento" + e);
		}	
	}
}
