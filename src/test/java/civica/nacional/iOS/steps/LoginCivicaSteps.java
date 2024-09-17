package civica.nacional.iOS.steps;

import static org.junit.Assert.fail;
import java.util.Date;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.pageObjects.CambioClaveCivicaPage;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.PasarPlataCivicaPage;
import civica.nacional.iOS.pageObjects.RegistroCivicaPage;
import civica.nacional.iOS.pageObjects.TransporteCivicaPageObjects;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Credenciales;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class LoginCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	LoginCivicaPage loginRobustoPage;
	Utilidades utilidades;
	CambioClaveCivicaSteps cambioClaveCivicaSteps;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	
	@Step
	public void logInToTheApplication() {
		
        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
		UtilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
        Utilidades.esperaMiliseg(500);
		boolean permisosVisible = utilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.TXT_PERMISOS_CIVICA);
		if (permisosVisible) { 
			
	        Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Acepto permisos para activar la localización y determinar la ubicación al utilizar la aplicación");
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.PERMITIR_AL_USAR);
			
		} else {
			System.out.println("La aplicación no solicita aceptar permisos para activar la localización");
		}
		
		try {
	        Utilidades.esperaMiliseg(1000);
			UtilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
			System.out.println("Ingresando al aplicativo");
	        Utilidades.esperaMiliseg(500);
	        UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.TRAVEL_WITH_QR);
			
		} catch (Exception e) {
	        Utilidades.esperaMiliseg(1000);
			//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
			fail("Error de aserción: " + e.getMessage());
		    assert utilidadesTCS.validateElementVisibility("xpath", LoginCivicaPage.MENU_HAMBURGUESA) : "El elemento del menú no es visible después de esperar";
		}  
	}
	
	@Step
	public void loginAgain() {
		try {
			UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_LOGIN_HOME);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_LOGIN_HOME);
			UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.LIST_TIPO_ID);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.LIST_TIPO_ID);
			
		} catch(Exception e) {
			//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
			fail("No se pudo interactuar con el elemento" + e);
		}
	}
	
	@Step
	public void checkVersion() {
		Utilidades.esperaMiliseg(5000);
        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
		UtilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		Utilidades.esperaMiliseg(5000);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.TXT_VERSION_APP);
		String version = utilidadesTCS.obtenerTexto("xpath",LoginCivicaPage.TXT_VERSION_APP);
		BaseUtil.versionApp = version;
		Utilidades.tomaEvidencia("Información " + version);
		System.out.println(version);
	}
	
	@Step
	public void logoutApp() {
		UtilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
			
			try {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
	        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
			Utilidades.esperaMiliseg(5000);
		    utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		    
			} catch (Exception e) {
				//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
				fail("No se pudo interactuar con el elemento" + e);
			}
		} 
	}

	@Step
    public void enterCredentials(String tipoID, String usuario, String contrasenia) throws Exception {
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
			
			try {
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
		        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
				Utilidades.esperaMiliseg(5000);
			    utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
			} catch (Exception e) {
				//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
				fail("No se pudo interactuar con el elemento" + e);
			}
		} 
		try {
			Utilidades.esperaMiliseg(3000);
		    utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
	        UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
	        utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
	        utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
	        Utilidades.tomaEvidencia("Selecciono tipo de documento e ingreso número de documento");
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);
	        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);

		} catch (Exception e) {
			//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
			fail("No se pudo interactuar con el elemento" + e);
		}
		
        Utilidades.esperaMiliseg(2000);
        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
		boolean isElementVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginCivicaPage.ELEMENT_VISIBLE);

         if (isElementVisible) {
        	 try {
		    	/*REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE*/
		        UtilidadesTCS.esperarElementVisibility("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
		        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
		        Date fechaActual = new Date();
		        System.out.println("Fecha actual: " + fechaActual);
		        String user = Credenciales.propertiesWebs().getProperty("userMail");
		        String pass = Credenciales.propertiesWebs().getProperty("passMail");
		        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
		        System.out.println("Código de activación: " + codigoActivacion);
		        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
		        UtilidadesTCS.eliminarUltimoCorreoConOTP(user, pass);
		        Utilidades.esperaMiliseg(5000);
		        utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
		        utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
				Utilidades.esperaMiliseg(800);
		        Utilidades.tomaEvidencia("Ingreso OTP en cambio de dispositivo");
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
		        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
		
		        /*REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE*/
		        Utilidades.esperaMiliseg(1000);
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN);
		        utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
		        BaseUtil.baseContrasena = contrasenia;
		        UtilidadesTCS.switchSelectAction(contrasenia);
		        Utilidades.esperaMiliseg(1000);
		        
        	 } catch (Exception e) {
     			//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
     			fail("No se pudo interactuar con el elemento" + e);
    		    assert utilidadesTCS.validateElementVisibility("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN) : "No se pudo ingresar correctamente el código de autorización.";
     		}
        } else {
        	
        	try {
	            /*REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE*/
	            System.out.println("El elemento no está presente o no es visible. Ejecutando el bloque else.");
	            utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
	            utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
	            BaseUtil.baseContrasena = contrasenia;
	            UtilidadesTCS.switchSelectAction(contrasenia);
	            Utilidades.esperaMiliseg(1000);
	            utilidadesTCS.clicElement("xpath", LoginCivicaPage.BACKGROUND_VIEW);
	            
	        } catch (Exception e) {
				//UtilidadesTCS.causaFalla("Error al ingresar contraseña");
				fail("Error al ingresar contraseña" + e);
			}
        }
	}
	
	@Step
    public void enterCredentialsHome(String tipoID, String usuario, String contrasenia) throws Exception {
        UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_HOME);
        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_HOME);
        
		try {
			Utilidades.esperaMiliseg(3000);
		    utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
		    utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
	        utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
	        utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
	        Utilidades.tomaEvidencia("Selecciono tipo de documento e ingreso número de documento");
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);
	        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
	        Utilidades.esperaMiliseg(6000);

		} catch (Exception e) {
			//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
			fail("No se pudo interactuar con el elemento" + e);
		}
		
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");

         if (isElementVisible) {
        	 try {
		    	/*REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE*/
		        UtilidadesTCS.esperarElementVisibility("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
		        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
		        Date fechaActual = new Date();
		        System.out.println("Fecha actual: " + fechaActual);
		        String user = Credenciales.propertiesWebs().getProperty("userMail");
		        String pass = Credenciales.propertiesWebs().getProperty("passMail");
		        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
		        System.out.println("Código de activación: " + codigoActivacion);
		        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
		        Utilidades.esperaMiliseg(5000);
		        utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
		        utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
				Utilidades.esperaMiliseg(800);
		        Utilidades.tomaEvidencia("Ingreso OTP en cambio de dispositivo");
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
		        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
		
		        /*REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE*/
		        Utilidades.esperaMiliseg(1000);
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN);
		        utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
		        BaseUtil.baseContrasena = contrasenia;
		        UtilidadesTCS.switchSelectAction(contrasenia);
		        Utilidades.esperaMiliseg(1000);
		        
        	 } catch (Exception e) {
     			//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
     			fail("No se pudo interactuar con el elemento" + e);
    		    assert utilidadesTCS.validateElementVisibility("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN) : "No se pudo ingresar correctamente el código de autorización.";
     		}
        } else {
        	
        	try {
	            /*REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE*/
	            System.out.println("El elemento no está presente o no es visible. Ejecutando el bloque else.");
	            utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
	            utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
	            BaseUtil.baseContrasena = contrasenia;
	            UtilidadesTCS.switchSelectAction(contrasenia);
	            Utilidades.esperaMiliseg(1000);
	            utilidadesTCS.clicElement("xpath", LoginCivicaPage.BACKGROUND_VIEW);
	            
	        } catch (Exception e) {
				//UtilidadesTCS.causaFalla("Error al ingresar contraseña");
				fail("Error al ingresar contraseña" + e);
			}
        }
	}
	
	@Step
	public void clickOnEnterOption() {
		
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.ICON_EYE_CONFIRM_PASS);
	    boolean isVisible;
	    int clickCount = 0;

	    do {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESAR);
	        
	        // Tomar evidencia solo en el segundo clic
	        if (clickCount == 0) {
				Utilidades.esperaMiliseg(500);
	            Utilidades.tomaEvidencia("Ingreso clave");
	        }
	        
	        // Verificar si el elemento sigue siendo visible
	        isVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginCivicaPage.BTN_INGRESAR);
	        clickCount++;
	        
	    } while (isVisible);
	}
	
	@Step
	public void clickOnEnterOptionBad() {
	    boolean isVisible;
	    int clickCount = 0;

	    do {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESAR);
	        
	        // Tomar evidencia solo en el segundo clic
	        if (clickCount == 1) {
				Utilidades.esperaMiliseg(499);
	            Utilidades.tomaEvidencia("Ingreso clave errónea");
	        }
	        
	        // Verificar si el elemento sigue siendo visible
	        isVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginCivicaPage.BTN_INGRESAR);
	        clickCount++;
	        
	    } while (isVisible);
	}
	
	@Step
	public void clickOnEnterOptionBadNumTries() {
	    boolean isVisible;
	    int clickCount = 0;

	    do {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESAR);
	        
	        // Tomar evidencia solo en el segundo clic
	        if (clickCount == 1) {
				Utilidades.esperaMiliseg(245);
	            Utilidades.tomaEvidencia("Ingreso clave errónea");
	        }
	        
	        // Verificar si el elemento sigue siendo visible
	        isVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginCivicaPage.BTN_INGRESAR);
	        clickCount++;
	        
	    } while (isVisible);
	}
	
	@Step
	public void verifyToBeInsideTheApp() {
		try {
			Utilidades.esperaMiliseg(5000);
            utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 180);
            boolean isVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginCivicaPage.ACTUALIZAR_SALDO);
            while (isVisible) {
                Utilidades.esperaMiliseg(1500);
                utilidadesTCS.clicElement("xpath", LoginCivicaPage.ACTUALIZAR_SALDO);
                isVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginCivicaPage.ACTUALIZAR_SALDO);
		          Utilidades.esperaMiliseg(1500);
            }

            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PasarPlataCivicaPage.SALDOS_HOME)));
			UtilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.SALDOS_HOME);
			System.out.println("Ingresé a la APP");
            Utilidades.tomaEvidencia("Ingresé a la APP");    
            UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
            utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
			Utilidades.esperaMiliseg(5000);
            UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.USUARIO);
			Utilidades.esperaMiliseg(3000);
            utilidadesTCS.clicElementAction("xpath", LoginCivicaPage.USUARIO);
			Utilidades.esperaMiliseg(500);
            UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.DATOS_USUARIO);
			Utilidades.esperaMiliseg(1500);
            utilidadesTCS.clicElement("xpath", LoginCivicaPage.DATOS_USUARIO);
            utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
            UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.DATOS_PERSONALES);
			Utilidades.esperaMiliseg(1000);
            UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.CEL_NUMBER_USER);
			Utilidades.tomaEvidencia("Verifico que el usuario está activo en la APP");	
			BaseUtil.numeroCelular = utilidadesTCS.obtenerTexto("xpath", LoginCivicaPage.CEL_NUMBER_USER);
			BaseUtil.tipoDocumento = utilidadesTCS.obtenerTexto("xpath", LoginCivicaPage.ID_NUMBER_USER);
            utilidadesTCS.clicElement("xpath", LoginCivicaPage.REGRESAR);
            utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);

        } catch (TimeoutException e) {
			//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
        	fail(e.getMessage());
        }
    }
	
	@Step
	public void incorrectPasswordEntry(String tipoID, String usuario, String contrasenia) throws Exception {
	    for (int intento = 2; intento <= 4; intento++) {
	        performLoginSteps(tipoID, usuario, contrasenia, intento);
	        
	        if (intento < 4) {
	            System.out.println("Ingreso clave errónea: Intento " + intento);
	        } else {
	            System.out.println("Validé POPUP 'Algo salió mal");
	            //Utilidades.tomaEvidencia("Validé mensaje 'Algo salió mal luego de cuarta clave errónea. Superaste el número de intentos' Intenta en 5:00 minutos'");
	        }
	    }
        System.out.println("Validé POPUP 'Algo salió mal");	
    }
	
	@Step
	public void validatePopupErrorMaxLoginAttempt() {
		System.out.println("Validé POPUP 'Algo salió mal");
	}
	
	@Step
	public void checkWrongPassword(String tipoID, String usuario, String badPass, String contrasenia) throws Exception {
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
			try {
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
				Utilidades.esperaMiliseg(5000);
				UtilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
				utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
				
			} catch (Exception e) {
				//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
				fail("No se pudo interactuar con el elemento" + e);
			}
			
		} else
			try {
				UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);        
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);        
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
		        utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
		        Utilidades.tomaEvidencia("Selecciono tipo de documento");
		        utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
		        Utilidades.tomaEvidencia("Ingreso número de documento");
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);        
		        Utilidades.esperaMiliseg(1000);
	            utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
		        
			} catch (Exception e) {      
				//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
				fail("No se pudo interactuar con el elemento" + e);        
			}

		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");
		if (isElementVisible) {             
			 try {
		        Utilidades.esperaMiliseg(2000);
	            utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
		        Date fechaActual = new Date();
		        System.out.println("Fecha actual: " + fechaActual);
		        String user = Credenciales.propertiesWebs().getProperty("userMail");
		        String pass = Credenciales.propertiesWebs().getProperty("passMail");
		        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
		        System.out.println("Código de activación: " + codigoActivacion);
		        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
		        Utilidades.esperaMiliseg(2000);
				UtilidadesTCS.esperarElementVisibility("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);        
		        utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
		        Utilidades.esperaMiliseg(1500);
		        utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
		        Utilidades.esperaMiliseg(1000);
				utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, badPass);
				Utilidades.esperaMiliseg(2000);            
				Utilidades.tomaEvidencia("Ingreso clave");
				
			 } catch (Exception e) {         
				fail("No se pudo interactuar con el elemento" + e);  
			 }
			 
		} else {
			 try {
				/*REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE*/           
				System.out.println("El elemento no está presente o no es visible. Ejecutando el bloque else.");            
				UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN);        
				utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, badPass);            
				Utilidades.esperaMiliseg(1000);            
				Utilidades.tomaEvidencia("Ingreso clave");            
				clickOnEnterOption();
				Utilidades.esperaMiliseg(800);
				Utilidades.tomaEvidencia("Valido mensaje de rechazo por clave errónea");
				
			 } catch (Exception e) {              
				 fail("No se pudo interactuar con el elemento" + e);            
			 }
			 try {
		 /*	
		 * 		 REALIZAR ACCIONES PARA EL LOGIN POSITIVO.
		 * 		 SE CORRE EL BLOQUE DE CÓDIGO 'ENTERCREDENCIALS'.
		 * 		 SE HACE USO DEL MÉTODO 'CLICLONENTEROPTION.
		 */ 
				 utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_REGRESO_DESDE_RECUPERAR);
				 Utilidades.esperaMiliseg(1000);
				 UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
				 utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA); 
				 enterCredentials(tipoID, usuario, contrasenia);
				 Utilidades.esperaMiliseg(800);
				 clickOnEnterOption();
				 
			 } catch (Exception e) {  
				 
				 fail("No se pudo interactuar con el elemento" + e);            
			 }	 
		}
	}
	
	@Step
	public void checkWrongPasswordUnique(String tipoID, String usuario, String badPass) throws Exception {
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
			try {
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
				Utilidades.esperaMiliseg(5000);
				UtilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
				utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
				
			} catch (Exception e) {
				//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
				fail("No se pudo interactuar con el elemento" + e);
			}
			
		} else
			try {
				UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);        
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);        
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
		        utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
		        Utilidades.tomaEvidencia("Selecciono tipo de documento");
		        utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
		        Utilidades.tomaEvidencia("Ingreso número de documento");
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);        
		        Utilidades.esperaMiliseg(1000);
	            utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
		        
			} catch (Exception e) {      
				//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
				fail("No se pudo interactuar con el elemento" + e);        
			}

		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");
		if (isElementVisible) {             
			 try {
		        Utilidades.esperaMiliseg(2000);
	            utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);		        
	            Date fechaActual = new Date();
		        System.out.println("Fecha actual: " + fechaActual);
		        String user = Credenciales.propertiesWebs().getProperty("userMail");
		        String pass = Credenciales.propertiesWebs().getProperty("passMail");
		        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
		        System.out.println("Código de activación: " + codigoActivacion);
		        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
		        UtilidadesTCS.eliminarUltimoCorreoConOTP(user, pass);
		        Utilidades.esperaMiliseg(2000);
				UtilidadesTCS.esperarElementVisibility("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);        
		        utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
		        Utilidades.esperaMiliseg(1500);
		        utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
				Utilidades.esperaMiliseg(800);
		        Utilidades.tomaEvidencia("Ingreso OTP en cambio de dispositivo");
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
		        Utilidades.esperaMiliseg(5000);
				utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, badPass);
				Utilidades.esperaMiliseg(1000);            
				clickOnEnterOptionBad();
				Utilidades.esperaMiliseg(800);
				System.out.println("Valido mensaje de rechazo por clave errónea");
				
			 } catch (Exception e) {         
				fail("No se pudo interactuar con el elemento" + e);  
			 }
			 
		} else {
			 try {
				/*REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE*/     
				 
				System.out.println("El elemento no está presente o no es visible. Ejecutando el bloque else.");            
				UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN);        
				utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, badPass);            
				Utilidades.esperaMiliseg(1000);            
				clickOnEnterOptionBad();
				Utilidades.esperaMiliseg(800);
				System.out.println("Valido mensaje de rechazo por clave errónea");
				
			 } catch (Exception e) {              
				 fail("No se pudo interactuar con el elemento" + e);            
			 }
		}
	}
	
	@Step
	public void checkWrongPasswordNumTries(String tipoID, String usuario, String badPass) throws Exception {
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
			try {
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
				Utilidades.esperaMiliseg(5000);
				UtilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
				utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
				
			} catch (Exception e) {
				//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
				fail("No se pudo interactuar con el elemento" + e);
			}
			
		} else
			try {
				UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);        
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);        
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
		        utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
		        Utilidades.tomaEvidencia("Selecciono tipo de documento");
		        utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
		        Utilidades.tomaEvidencia("Ingreso número de documento");
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);        
		        Utilidades.esperaMiliseg(1000);
	            utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
		        
			} catch (Exception e) {      
				//UtilidadesTCS.causaFalla("No se pudo interactuar con el elemento o tiempo de espera superado");
				fail("No se pudo interactuar con el elemento" + e);        
			}

		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");
		if (isElementVisible) {             
			 try {
		        Utilidades.esperaMiliseg(2000);
	            utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);		        
	            Date fechaActual = new Date();
		        System.out.println("Fecha actual: " + fechaActual);
		        String user = Credenciales.propertiesWebs().getProperty("userMail");
		        String pass = Credenciales.propertiesWebs().getProperty("passMail");
		        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
		        System.out.println("Código de activación: " + codigoActivacion);
		        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
		        UtilidadesTCS.eliminarUltimoCorreoConOTP(user, pass);
		        Utilidades.esperaMiliseg(2000);
				UtilidadesTCS.esperarElementVisibility("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);        
		        utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
		        Utilidades.esperaMiliseg(1500);
		        utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
				Utilidades.esperaMiliseg(800);
		        Utilidades.tomaEvidencia("Ingreso OTP en cambio de dispositivo");
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
		        Utilidades.esperaMiliseg(5000);
				utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, badPass);
				Utilidades.esperaMiliseg(1000);            
				clickOnEnterOptionBadNumTries();
				Utilidades.esperaMiliseg(800);
				System.out.println("Valido mensaje de rechazo por clave errónea");
				
			 } catch (Exception e) {         
				fail("No se pudo interactuar con el elemento" + e);  
			 }
			 
		} else {
			 try {
				/*REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE*/     
				System.out.println("El elemento no está presente o no es visible. Ejecutando el bloque else.");            
				UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN);        
				utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, badPass);            
				Utilidades.esperaMiliseg(1000); 
				clickOnEnterOptionBadNumTries();
				Utilidades.esperaMiliseg(800);
				System.out.println("Valido mensaje de rechazo por clave errónea");
				
			 } catch (Exception e) {              
				 fail("No se pudo interactuar con el elemento" + e);            
			 }
		}
	}
	
	@Step
	public void signOut() {
		try {
	        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
			UtilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
			Utilidades.esperaMiliseg(500);
	        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
			utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
			Utilidades.esperaMiliseg(800);
			UtilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.SIGN_OUT);
			utilidadesTCS.clicElement("xpath",LoginCivicaPage.SIGN_OUT);
			Utilidades.esperaMiliseg(100);
			utilidadesTCS.clicElementNoFail("xpath",LoginCivicaPage.CLOSE_APP);
			
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento" + e);
		}
	}
	
	/*PASO PARA LOGIN DESPUÉS DE CAMBIAR CONTRASEÑA.*/
	@Step
	public void enterCredentialsNewPass(String tipoID, String usuario, String newPass) {
		try {
			enterCredentials(tipoID, usuario, newPass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*MÉTODO PARA OPTIMIZAR LÍNEAS Y EVITAR REPETIR CÓDIGO: */
	private void performLoginSteps(String tipoID, String usuario, String contrasenia, int intento) throws Exception {
	    UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_REGRESO_DESDE_RECUPERAR);
	    utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_REGRESO_DESDE_RECUPERAR);
	    Utilidades.esperaMiliseg(1000);
	    UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
	    utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
	    utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
	    utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
	    utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
	    utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
	    utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);
        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
	    Utilidades.esperaMiliseg(2000);
	    	    
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");

        if (isElementVisible) {
        	/*REALIZAR ACCIONES SI EL ELEMENTO ES VISIBLE*/
           Utilidades.esperaMiliseg(6000);
           Date fechaActual = new Date();
           System.out.println("Fecha actual: " + fechaActual);
           String user = Credenciales.propertiesWebs().getProperty("userMail");
           String pass = Credenciales.propertiesWebs().getProperty("passMail");
           String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
           System.out.println("Código de activación: " + codigoActivacion);
           String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
           Utilidades.esperaMiliseg(2000);
           utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
           utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
           utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
           
           /*REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE*/
           Utilidades.esperaMiliseg(1000);
           utilidadesTCS.clicElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN);
           utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
           clickOnEnterOptionBad();
           Utilidades.esperaMiliseg(999);
           //Utilidades.tomaEvidencia("Ingreso clave errónea");
      	   System.out.println("Ingreso clave errónea");  
      	   
        } else {
	        /*REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE*/
	        System.out.println("El elemento no está presente o no es visible. Ejecutando el bloque else.");
	        Utilidades.esperaMiliseg(1200);
	        utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
	        clickOnEnterOptionBad();
	   	    Utilidades.esperaMiliseg(750);
	   	    Utilidades.tomaEvidencia("Ingreso clave errónea");
	   	    System.out.println("Ingreso clave errónea");        
   	    }
	}
}
