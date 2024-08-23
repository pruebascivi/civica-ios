package civica.nacional.iOS.steps;

import static org.junit.Assert.fail;
import java.util.Date;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.RegistroCivicaPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Credenciales;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class RegistroCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	RegistroCivicaPage registroPage;
	Utilidades utilidades;	
	
	@Step
	public void enterCredentials1(String tipoID, String usuario, String contrasenia, String dia, String mes, String anio) {
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
			utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		}
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.HM_REGISTRATION_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DOCUMENT_TYPE_BTN);
		utilidadesTCS.scrollToElement(RegistroCivicaPage.DROPDOWN_DOCUMENT_TYPE_CC, tipoID);
		Utilidades.tomaEvidencia("Selecciono tipo de documento");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DOCUMENTO_NUM_INPUT_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.DOCUMENTO_NUM_INPUT_FIELD, usuario);
		Utilidades.tomaEvidencia("Ingreso número de documento");
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.CONTINUE_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DAY_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementDay(RegistroCivicaPage.DAY_FIELD_TO_SCROLL, dia);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.MONTH_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementMonth(RegistroCivicaPage.MONTH_FIELD_TO_SCROLL, mes);
		utilidadesTCS.clickByCoordinates(360,360);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.YEAR_FIELD_TO_SCROLL);
		utilidadesTCS.scrollToElementYear(RegistroCivicaPage.YEAR_FIELD_TO_SCROLL, anio);
		utilidadesTCS.clickByCoordinates(360,360);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE2_BTN);
		utilidadesTCS.validateElementVisibility("xpath", RegistroCivicaPage.VALIDATE_REGISTER_TXT);
		Utilidades.tomaEvidencia("Ingreso al registro manual.");
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.MANUAL_REGISTRATION_BTN);
	}
	
	@Step
	public void enterCredentialsAgeIncorrect(String tipoID, String usuario, String contrasenia, String dia, String mes, String anio) {
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
			utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		}
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.HM_REGISTRATION_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DOCUMENT_TYPE_BTN);
		utilidadesTCS.scrollToElement(RegistroCivicaPage.DROPDOWN_DOCUMENT_TYPE_CC, tipoID);
		Utilidades.tomaEvidencia("Selecciono tipo de documento");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DOCUMENTO_NUM_INPUT_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.DOCUMENTO_NUM_INPUT_FIELD, usuario);
		Utilidades.tomaEvidencia("Ingreso número de documento");
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.CONTINUE_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DAY_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementDay(RegistroCivicaPage.DAY_FIELD_TO_SCROLL, dia);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.MONTH_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementMonth(RegistroCivicaPage.MONTH_FIELD_TO_SCROLL, mes);
		utilidadesTCS.clickByCoordinates(360,360);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.YEAR_FIELD_TO_SCROLL);
		utilidadesTCS.scrollToElementYear(RegistroCivicaPage.YEAR_FIELD_TO_SCROLL, anio);
		utilidadesTCS.clickByCoordinates(360,360);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE2_BTN);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Se valida el siguiente mensaje 'No cuentas con la edad mínima requerida para el registro.'");
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		Utilidades.tomaEvidencia("Se validara el registro nuevamente con la edad permitida.");
	}
	
	@Step
	public void enterCredentials2(String tipoID, String usuario, String contrasenia, String dia, String mes, String anio) {
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
			utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		}
        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.HM_REGISTRATION_BTN);
		Utilidades.esperaMiliseg(3000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DOCUMENT_TYPE_BTN);
		utilidadesTCS.scrollToElement(RegistroCivicaPage.DROPDOWN_DOCUMENT_TYPE_CC, tipoID);
		Utilidades.tomaEvidencia("Selecciono tipo de documento");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DOCUMENTO_NUM_INPUT_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.DOCUMENTO_NUM_INPUT_FIELD, usuario);
		Utilidades.tomaEvidencia("Ingreso número de documento");
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.CONTINUE_BTN);
		Utilidades.esperaMiliseg(3000);
        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DAY_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementDay(RegistroCivicaPage.DAY_FIELD_TO_SCROLL, dia);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.MONTH_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementMonth(RegistroCivicaPage.MONTH_FIELD_TO_SCROLL, mes);
		utilidadesTCS.clickByCoordinates(360,360);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.YEAR_FIELD_TO_SCROLL);
		utilidadesTCS.scrollToElementYear(RegistroCivicaPage.YEAR_FIELD_TO_SCROLL, anio);
		utilidadesTCS.clickByCoordinates(360,360);
		Utilidades.esperaMiliseg(3000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE2_BTN);
		Utilidades.esperaMiliseg(3000);
		utilidadesTCS.validateElementVisibility("xpath", RegistroCivicaPage.VALIDATE_REGISTER_TXT);
		Utilidades.tomaEvidencia("Valido mensaje 'Esta es tu nueva cuenta'");
	}
	
	@Step
	public void confirmDataAndContinue(String nombre, String apellido) {
		try {
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.NAME_INPUT_FIELD);
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.NAME_INPUT_FIELD, nombre);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.LASTNAME_INPUT_FIELD);
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.LASTNAME_INPUT_FIELD, apellido);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.BACKGROUND_VIEW);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Confirmo datos ingresados y continúo");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE3_BTN);
		} catch(Exception e) {
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}	
	
	@Step
	public void enterDocumentData(String diaExp, String mesExp, String anioExp, String departamentoExp, String municipioExp) {
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_ISSUED_EXP_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.YEAR_FIELD_TO_SCROLL);
		utilidadesTCS.scrollToElementYear(RegistroCivicaPage.YEAR_FIELD_TO_SCROLL, anioExp);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_ISSUED_EXP_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DAY_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementDay(RegistroCivicaPage.DAY_FIELD_TO_SCROLL, diaExp);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.MONTH_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementMonth(RegistroCivicaPage.MONTH_FIELD_TO_SCROLL, mesExp);
		utilidadesTCS.clickByCoordinates(360,360);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DEPARTMENT_CITY_FIELD);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DEPARTMENT_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.DEPARTMENT_FIELD, departamentoExp);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(52,329);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CITY_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CITY_FIELD, municipioExp);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(52,329);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(300,390);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé el departamento y ciudad de expedición del documento de identidad.");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE4_BTN);
		Utilidades.esperaMiliseg(1000);		
	}	
	
	
	@Step
	public void enterContactInfo(String numCelular, String correo) {
		try {
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CELLPHONE_NUM_FIELD);
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CELLPHONE_NUM_FIELD, numCelular);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.MAIL_FIELD);
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.MAIL_FIELD, correo);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.FIELD_VIEW);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Ingresé número de celular y correo electrónico.");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE5_BTN);
			Utilidades.esperaMiliseg(10000);
		} catch (Exception e) {
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}	
	
	@Step
    public void verificateCode() throws Exception {
		try {
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
			for(int i=0; i<=1; i++) {
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);		
			}
		} catch (Exception e) {
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}
 
	@Step
	public void confirmEmail(String contrasena) throws Exception {
		try {
			Utilidades.esperaMiliseg(2000);
			Utilidades.tomaEvidencia("Acepto Pop Up 'Vamos a crear tu clave'.");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CREATE_PASS_POPUP_BTN);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CREATE_PASS_FIELD);
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CREATE_PASS_FIELD, contrasena);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONFIRM_PASS_FIELD);
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CONFIRM_PASS_FIELD, contrasena);
			utilidadesTCS.clickByCoordinates(180,180);
			Utilidades.tomaEvidencia("Creé y confirmé mi clave.");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CREATE_PASS_BTN);
			Utilidades.esperaMiliseg(1000);
		} catch (Exception e) {
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}
		
	@Step
	public void authorizeTermsCond(String numCelular) throws Exception {
		try {
			
			UtilidadesTCS.esperarElementVisibility("xpath", RegistroCivicaPage.VALIDATE_TERMS_TXT);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N1_FIELD);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N2_FIELD);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N3_FIELD);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N4_FIELD);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Acepté términos y condiciones.");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE_BNT_SINCE_TERMS);
			Utilidades.esperaMiliseg(3000);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONFIRM_CEL_NUM_FIELD);
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CONFIRM_CEL_NUM_FIELD, numCelular);
			utilidadesTCS.clickByCoordinates(222,222);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Confirmé número de celular.");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE_SINCE_CONFIRM_CEL_BTN);
			Utilidades.esperaMiliseg(5000);
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
			utilidadesTCS.clickByCoordinates(199,199);
			utilidadesTCS.clicElement("xpath", RegistroCivicaPage.ACCEPT_CODE_CEL_BTN);
			Utilidades.esperaMiliseg(1050);
			Utilidades.tomaEvidencia("Verifico último paso para el registro.");
			Utilidades.esperaMiliseg(5000);
	        utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
			boolean isElementLoginVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_HOME);

			if (isElementLoginVisible) {
		        System.out.println("Se presentó un error al registrase: ¡Ups! Lo sentimos. Tu registro no pudo continuar. Para más información ingresa al botón ¿Necesitas ayuda?");
				Utilidades.tomaEvidencia("Se presentó un error al registrarse: ¡Ups! Lo sentimos. Tu registro no pudo continuar. Para más información ingresa al botón ¿Necesitas ayuda?");
		        assert false : "¡Ups! Lo sentimos. Tu registro no pudo continuar. Para más información ingresa al botón ¿Necesitas ayuda?";
				
			} else {
				Utilidades.tomaEvidencia("Registro exitoso.");
				System.out.println("Registro exitoso.");
			}
		} catch (Exception e) {
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}
	
	@Step
	public void authorizeTermsCondRegister(String numCelular) throws Exception {
		UtilidadesTCS.esperarElementVisibility("xpath", RegistroCivicaPage.VALIDATE_TERMS_TXT);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N1_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N2_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N3_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N4_FIELD);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Acepté términos y condiciones.");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE_BNT_SINCE_TERMS);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONFIRM_CEL_NUM_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CONFIRM_CEL_NUM_FIELD, numCelular);
		utilidadesTCS.clickByCoordinates(222,222);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Confirmé número de celular.");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE_SINCE_CONFIRM_CEL_BTN);
		Utilidades.esperaMiliseg(5000);
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
		utilidadesTCS.clickByCoordinates(199,199);
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.ACCEPT_CODE_CEL_BTN);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Validar el mensaje '¡Ups! Lo sentimos. Cuentas con registro en el App Daviplata activo con otro número.'");
	}
	
	@Step
	public void verifiedCellNumberRegistered() {
		try {
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N1_FIELD);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N2_FIELD);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N3_FIELD);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N4_FIELD);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Acepté términos y condiciones.");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE_BNT_SINCE_TERMS);
			Utilidades.esperaMiliseg(1010);
			Utilidades.esperaMiliseg(1);
			Utilidades.tomaEvidencia("Número de celular no corresponde a la cédula registrada.");
		} catch(Exception e) {
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}

	@Step
	public void validarTopesRedeban(String valorParametrico) {
		try {
			
			String saldoRedeban = Double.toString(BaseUtil.saldos.get(0));
			BaseUtil.saldoConvertidoWebRedebanInicial = UtilidadesTCS.removeDecimalBalancesWeb(saldoRedeban);
			int saldoRedebanConvertido = Integer.parseInt(BaseUtil.saldoConvertidoWebRedebanInicial );
			int valorParametricoConvertido = Integer.parseInt(valorParametrico);
			
			if(saldoRedebanConvertido < valorParametricoConvertido) {
				
				Utilidades.tomaEvidencia("El cliente no supera el tope permitido en Redeban entonces puede continuar con el registro.");
		        System.out.println("El cliente no supera el tope permitido en Redeban entonces puede continuar con el registro: " + saldoRedebanConvertido);

			} else {
				
				Utilidades.tomaEvidencia("El cliente supera el tope permitido en Redeban entonces se rechaza el registro.");
		        assert false : "El cliente supera el tope permitido en Redeban entonces se rechaza el registro: " + saldoRedebanConvertido;
			}
			
		} catch(Exception e) {
			
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}
}
