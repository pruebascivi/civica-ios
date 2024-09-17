package civica.nacional.iOS.steps;

import static org.junit.Assert.fail;
import java.util.Date;
import civica.nacional.iOS.pageObjects.CambioClaveOlvidoPage;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.RegistroCivicaPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Credenciales;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class CambioClaveOlvidoSteps {
	
	UtilidadesTCS utilidadesTCS;
	CambioClaveOlvidoPage cambioClaveOlvidoPage;
	Utilidades utilidades;
	LoginCivicaPage loginRobustoPage;
	BaseUtil base;
	
	@Step
	public void forgotPassOption(String tipoID, String usuario) {
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
			try {
		        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
				Utilidades.esperaMiliseg(5000);
			    utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
			    
			} catch (Exception e) {
				fail("No se pudo interactuar con el elemento" + e);
			}
		} 
		
		try {
			utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.FORGOT_PASS_BTN);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.TYPE_ID_BTN);
			utilidadesTCS.scrollToElement(CambioClaveOlvidoPage.SELECT_TIPO_ID, tipoID);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.DOCUMENT_NUM_FIELD, usuario);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Selecciono tipo de documento e ingresé número");
			utilidadesTCS.clickByCoordinates(190, 490);
			utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_BTN);
			
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento" + e);
		}
		
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.DEFECTO_CAMBIO_CLAVE, "No te encuentras registrado");
		if(isElementVisible) {
			UtilidadesTCS.causaFalla("Mensaje 'No te encuentras registrado' cuando el usuario si se encuentra registrado");
			fail("Mensaje 'No te encuentras registrado' cuando el usuario si se encuentra registrado");
		}
	}
	
	@Step
	public void confirmBadEmail(String correoInvalido, String correoErroneo) throws Exception{
        Utilidades.esperaMiliseg(2500);
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");

         if (isElementVisible) {
        	 /*Realizar acciones si el elemento es visible*/
            utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
            Utilidades.esperaMiliseg(6000);
            Date fechaActual = new Date();
            System.out.println("Fecha actual: " + fechaActual);
            String user = Credenciales.propertiesWebs().getProperty("userMail");
            String pass = Credenciales.propertiesWebs().getProperty("passMail");
            String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
            System.out.println("Código de activación: " + codigoActivacion);
            String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
            utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
            utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
            Utilidades.esperaMiliseg(1000);
            performCambioClaveOlvidoStepsImputEmail(correoInvalido, correoErroneo);

         }  else {
        	 /*Realizar acciones si el elemento no es visible*/
        	 performCambioClaveOlvidoStepsImputEmail(correoInvalido, correoErroneo);
		}
	}
	
	@Step
    public void ingresarDatos(String tipoID, String usuario) throws Exception {
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
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);
	        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
	        Utilidades.esperaMiliseg(6000);

		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento" + e);
		}
        UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.ELEMENT_VISIBLE);
        Utilidades.esperaMiliseg(1000);
        utilidadesTCS.clicElement("xpath", LoginCivicaPage.REGRESAR);
        Utilidades.esperaMiliseg(3000);
		utilidadesTCS.scrollVerticalPositive();
        utilidadesTCS.clicElement("xpath", LoginCivicaPage.REGRESAR);
		Utilidades.esperaMiliseg(3000);
        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
		UtilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		Utilidades.esperaMiliseg(5000);
	}
	
	@Step
	public void confirmEmail(String correo, String newPass) throws Exception {
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");

         if (isElementVisible) {
        	/*Realizar acciones si el elemento es visible*/
            Utilidades.esperaMiliseg(6000);
            Date fechaActual = new Date();
            System.out.println("Fecha actual: " + fechaActual);
            String user = Credenciales.propertiesWebs().getProperty("userMail");
            String pass = Credenciales.propertiesWebs().getProperty("passMail");
            String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
            System.out.println("Código de activación: " + codigoActivacion);
            String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
            utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
            utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
            utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
            Utilidades.esperaMiliseg(1000);
            performCambioClaveOlvidoSteps(correo, newPass);
            
         } else {
        	 /*Realizar acciones si el elemento no es visible*/
        	performCambioClaveOlvidoSteps(correo, newPass);
         }
	}
	
	@Step
	public void setMailAndBadPass(String correo, String newPass) throws Exception {
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");

         if (isElementVisible) {
        	/*Realizar acciones si el elemento es visible*/
            Utilidades.esperaMiliseg(6000);
            Date fechaActual = new Date();
            System.out.println("Fecha actual: " + fechaActual);
            String user = Credenciales.propertiesWebs().getProperty("userMail");
            String pass = Credenciales.propertiesWebs().getProperty("passMail");
            String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
            System.out.println("Código de activación: " + codigoActivacion);
            String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
            utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
            utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
            utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
            Utilidades.esperaMiliseg(1000);
            performCambioClaveBadPass(correo, newPass);
            
         } else {
        	 /*Realizar acciones si el elemento no es visible*/
        	 performCambioClaveBadPass(correo, newPass);
         }
	}
	
	@Step
	public void inputBadEmail(String correo) throws Exception {
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");

         if (isElementVisible) {
        	/*Realizar acciones si el elemento es visible*/
            Utilidades.esperaMiliseg(6000);
            Date fechaActual = new Date();
            System.out.println("Fecha actual: " + fechaActual);
            String user = Credenciales.propertiesWebs().getProperty("userMail");
            String pass = Credenciales.propertiesWebs().getProperty("passMail");
            String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
            System.out.println("Código de activación: " + codigoActivacion);
            String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
            utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
            utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
            utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
            Utilidades.esperaMiliseg(1000);
         } 
      	/*Realizar acciones si el elemento no es visible*/
 		UtilidadesTCS.esperarElementVisibility("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD);
 		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD);
 		Utilidades.esperaMiliseg(1500);
 		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD, correo);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(190, 490);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé correo registrado");
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_EMAIL_BTN);
        Utilidades.esperaMiliseg(1000);
        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
        utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
	}
	
	/*Pasos perform reutilizables*/
	
	private void performCambioClaveOlvidoSteps(String correo, String newPass) throws Exception {
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD);
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD, correo);
		BaseUtil.baseMail = correo;
		String correctMail = Credenciales.propertiesWebs().getProperty("userMail");
		
		if (!correctMail.equals(BaseUtil.baseMail)) {
			/*Realizar acciones si el elemento es visible (correo erróneo)*/
			Utilidades.esperaMiliseg(800);
			Utilidades.tomaEvidencia("El correo electónico no coincide con el correo registrado.");
			System.out.println("El correo electónico no coincide con el correo registrado.");
	        assert false : "El correo electónico no coincide con el correo registrado.";

		} else {
			/*Realizar acciones si el elemento es visible (correo erróneo)*/
			performCambioClaveOlvidoStepsAllFlow(newPass);
			String validatePass = newPass;		
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clickByCoordinates(190, 260);
	    	UtilidadesTCS.esperarElementVisibility("xpath", CambioClaveOlvidoPage.CREATE_PASS_BTN);
			utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CREATE_PASS_BTN);	
			Utilidades.esperaMiliseg(1200);
	    	
		    /*Verificar si la contraseña cumple con alguna de las condiciones especificadas*/
		    if (validatePass.startsWith("19") || validatePass.startsWith("20")) {
		    	Utilidades.esperaMiliseg(800);
				Utilidades.tomaEvidencia("La contraseña no debe comenzar por '19' o '20' ni debe ser igual a la existente.");
		        assert false : "La contraseña no debe comenzar por '19' o '20' ni debe ser igual a la existente.";
	
		    } else {
		    	Utilidades.esperaMiliseg(500);
		        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
				Utilidades.tomaEvidencia("Validé el cambio exitoso de la clave");
		    	UtilidadesTCS.esperarElementVisibility("xpath", CambioClaveOlvidoPage.END_BTN);
				utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.END_BTN);
		        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
		    }
		}
	}
	
	private void performCambioClaveBadPass(String correo, String newPass) throws Exception {
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD);
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD, correo);
		
		performCambioClaveOlvidoStepsAllFlow(newPass);
		String validatePass = newPass;		
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(190, 260);
    	UtilidadesTCS.esperarElementVisibility("xpath", CambioClaveOlvidoPage.CREATE_PASS_BTN);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CREATE_PASS_BTN);	
		Utilidades.esperaMiliseg(1200);
	    	
	    /*Verificar si la contraseña cumple con alguna de las condiciones especificadas*/
	    if (validatePass.startsWith("19") || validatePass.startsWith("20")) {
	    	Utilidades.esperaMiliseg(800);
			Utilidades.tomaEvidencia("La contraseña no debe comenzar por '19' o '20' ni debe ser igual a la existente.");
	    }
	}
	
	private void performCambioClaveOlvidoStepsImputEmail(String correoInvalido, String correoErroneo) throws Exception {
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD, correoInvalido);
		utilidadesTCS.clickByCoordinates(190, 490);
		Utilidades.tomaEvidencia("Ingreso correo diferente al registrado");
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_EMAIL_BTN);
		Utilidades.esperaMiliseg(100);
		Utilidades.tomaEvidencia("Valido Pop up error al ingresar correo");
	}
	
	private void performCambioClaveOlvidoStepsAllFlow(String newPass) throws Exception {
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(190, 490);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé correo registrado");
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_EMAIL_BTN);
        Utilidades.esperaMiliseg(1000);
        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
        Utilidades.esperaMiliseg(1000);
        Date fechaActual = new Date();
        System.out.println("Fecha actual: " + fechaActual);
        String user = Credenciales.propertiesWebs().getProperty("userMail");
        String pass = Credenciales.propertiesWebs().getProperty("passMail");
        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
        System.out.println("Código de activación: " + codigoActivacion);
        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
        utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
        utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(190, 330);
		Utilidades.tomaEvidencia("Ingresé código de verificación del correo");
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_CODE_VERIFY_BTN);
		Utilidades.esperaMiliseg(750);
		Utilidades.tomaEvidencia("Valido mensaje de creación de contraseña");
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.AD_CREATE_PASS);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CREATE_NEW_PASS);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.CREATE_NEW_PASS, newPass);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(190, 260);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONFIRM_PASS_FIELD);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.CONFIRM_PASS_FIELD, newPass);
		BaseUtil.baseContrasena = newPass;
	}
}
