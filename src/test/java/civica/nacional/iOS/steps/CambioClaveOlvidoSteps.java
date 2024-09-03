package civica.nacional.iOS.steps;

import static org.junit.Assert.fail;
import java.util.Date;
import civica.nacional.iOS.pageObjects.CambioClaveOlvidoPage;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.RegistroCivicaPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Credenciales;
import civica.nacional.iOS.utilidades.TesseractOCR;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class CambioClaveOlvidoSteps {
	
	UtilidadesTCS utilidadesTCS;
	CambioClaveOlvidoPage cambioClaveOlvidoPage;
	Utilidades utilidades;
	LoginCivicaPage loginRobustoPage;
	BaseUtil base;
	TesseractOCR tess;
	
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
	}
	
	@Step
	public void confirmBadEmail(String correoErroneo, String newPass, String tipoID, String usuario, String correo) throws Exception{
        Utilidades.esperaMiliseg(2500);
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");

         if (isElementVisible) {
        	 
         // Realizar acciones si el elemento es visible
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
            performCambioClaveOlvidoStepsImputEmail(correoErroneo);
            Utilidades.esperaMiliseg(800);
            performCambioClaveOlvidoSteps(correo, newPass);

         }  else {
        	 
         // Realizar acciones si el elemento no es visible
        	 performCambioClaveOlvidoStepsImputEmail(correoErroneo);
             Utilidades.esperaMiliseg(800);
             performCambioClaveOlvidoSteps(correo, newPass);
		}
	}
	
	@Step
	public void confirmEmail(String correo, String newPass) throws Exception {
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");

         if (isElementVisible) {
         // Realizar acciones si el elemento es visible
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
          // Realizar acciones si el elemento no es visible
        	performCambioClaveOlvidoSteps(correo, newPass);
         }
	}
	
	// Pasos perform reutilizables:
	
	private void performCambioClaveOlvidoSteps(String correo, String newPass) throws Exception {
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD);
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD, correo);
		BaseUtil.baseMail = correo;
		String correctMail = Credenciales.propertiesWebs().getProperty("userMail");
		
		if (!correctMail.equals(BaseUtil.baseMail)) {
	     // Realizar acciones si el elemento es visible (correo erróneo)
			Utilidades.esperaMiliseg(800);
			Utilidades.tomaEvidencia("El correo electónico no coincide con el correo registrado.");
			System.out.println("El correo electónico no coincide con el correo registrado.");
	        assert false : "El correo electónico no coincide con el correo registrado.";

		} else {
		 // Realizar acciones si el elemento es visible (correo erróneo)
			performCambioClaveOlvidoStepsAllFlow(newPass);
			String validatePass = newPass;		
			
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clickByCoordinates(190, 260);
	    	UtilidadesTCS.esperarElementVisibility("xpath", CambioClaveOlvidoPage.CREATE_PASS_BTN);
			utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CREATE_PASS_BTN);	
			Utilidades.esperaMiliseg(1200);
			
	    	//String isElementVisible = Evidencias.capturaDispositivoTesseract("Intenta otra clave");
			//Utilidades.tomaEvidencia("Intenta otra clave");
			//System.out.println("Mensaje extraido en la captura: " + isElementVisible);
	    	//String base = "Intenta otra clave";
	    	
		    // Verificar si la contraseña cumple con alguna de las condiciones especificadas
		    if (validatePass.startsWith("19") || validatePass.startsWith("20")) {
				//utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_BTN);
		    	Utilidades.esperaMiliseg(800);
				Utilidades.tomaEvidencia("La contraseña no debe comenzar por '19' o '20' ni debe ser igual a la existente.");
		        assert false : "La contraseña no debe comenzar por '19' o '20' ni debe ser igual a la existente.";
	
		    } else {
				//utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_BTN);
		    	Utilidades.esperaMiliseg(500);
		        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
				Utilidades.tomaEvidencia("Validé el cambio exitoso de la clave");
		    	UtilidadesTCS.esperarElementVisibility("xpath", CambioClaveOlvidoPage.END_BTN);
				utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.END_BTN);
		        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
				
				//Se comenta porque solo hay un END_BTN 
				//for(int i=0; i<=2; i++) {
				//	utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.END_BTN);
				//}
			    }
		  }
	}
	
	private void performCambioClaveOlvidoStepsImputEmail(String correo) throws Exception {
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD, correo);
		utilidadesTCS.clickByCoordinates(190, 490);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_EMAIL_BTN);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Ingresé correo erróneo y valido mensaje de error");
		System.out.println("Ingresé correo erróneo y valido mensaje de error");
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
		Utilidades.esperaMiliseg(500);
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
