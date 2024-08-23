package civica.nacional.iOS.steps;

import static org.junit.Assert.fail;
import java.math.BigDecimal;
import civica.nacional.iOS.pageObjects.SacarPlataPageObjects;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;

public class SacarPlataSteps {

	UtilidadesTCS utilidadesTCS;
	SacarPlataPageObjects sacarPlataPage;
	Utilidades utilidades;
	
	public void enterToSacarPlata() {
		utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.SACAR_PLATA_MODULE);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Ingresé al modulo Sacar Plata");
	}

	public void enterAmountMoney(String monto, String contrasena) {
		
		int valueInAccount = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
		int valueToSend = Integer.parseInt(monto.trim());
		
		boolean condicionUno = valueToSend > valueInAccount;
		boolean condicionDos = valueToSend > 720000;
		boolean condicionTres = valueToSend < 10000;
		boolean condicionCuatro = valueToSend % 10000 != 0;
		
		if(condicionUno) {
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.AMOUNT_MONEY_FIELD, monto);
			utilidadesTCS.clickByCoordinates(190, 460);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Ingresé el monto de dinero que deseo sacar");
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.CONTINUE_BTN);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("No tienes saldo suficiente.");
			assert false: "No tienes saldo suficiente.";
			
		} else if (condicionDos || condicionTres || condicionCuatro) {
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.AMOUNT_MONEY_FIELD, monto);
			utilidadesTCS.clickByCoordinates(190, 460);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Ingresaste un monto diferente al permitido.");
			assert false: "Ingresaste un monto diferente al permitido.";
	 
		} else {
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.AMOUNT_MONEY_FIELD, monto);
			BigDecimal valorBigDecimal = new BigDecimal(monto); 
			BaseUtil.montoTransado = valorBigDecimal;
			utilidadesTCS.clickByCoordinates(190, 460);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Ingresé el monto de dinero que deseo sacar");
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.CONTINUE_BTN);
			Utilidades.esperaMiliseg(500);
			try {
				utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.INPUT_PASS_FIELD, contrasena);	
				utilidadesTCS.clickByCoordinates(190, 290);
				Utilidades.esperaMiliseg(500);
				utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.SACAR_PLATA_BTN);
			} catch (Exception e) {
				fail("Error en el proceso de ingresar la contraseña e intentar continuar. " + e);
			}
			UtilidadesTCS.esperarElementVisibility("xpath", SacarPlataPageObjects.TXT_VALIDATE);
			BaseUtil.newAut = utilidadesTCS.getTextMobileElement("xpath", SacarPlataPageObjects.NEW_AUTORIZADOR);
			Utilidades.tomaEvidencia("Validé código para retiro de dinero en cajero: " + BaseUtil.newAut);
			System.out.println("Validé código para retiro de dinero en cajero: " + BaseUtil.newAut);
			BaseUtil.tipoTransaccion = "SACAR PLATA - SOLICITUD OTP AP";
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.END_BTN);
		}
	}
	
	public void enterAmountMoneyWithError(String montoConUno, String montoConDosOConCuatro, String montoConTres, String montoExitoso, String contrasena, String contrasenaErronea) {
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.AMOUNT_MONEY_FIELD, montoConUno);
			utilidadesTCS.clickByCoordinates(190, 460);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Ingresé el monto de dinero que deseo sacar");
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.CONTINUE_BTN);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("No tienes saldo suficiente.");
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.BTN_CANCEL);
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.cleanInputElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE);
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE, montoConDosOConCuatro);
			utilidadesTCS.clickByCoordinates(190, 460);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Ingresaste un monto superior a 720.000 y no es multiplo de 10.000.");
			utilidadesTCS.cleanInputElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE);
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE);
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE, montoConTres);
			utilidadesTCS.clickByCoordinates(190, 460);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Ingresaste un monto inferior a 10.000");
			utilidadesTCS.cleanInputElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE);
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE);
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE, montoExitoso);
			utilidadesTCS.clickByCoordinates(190, 460);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Ingresaste un monto de acuerdo al rango permitido.");
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.CONTINUE_BTN);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.INPUT_PASS_FIELD, contrasena);
			utilidadesTCS.clickByCoordinates(190, 290);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.SACAR_PLATA_BTN);
			UtilidadesTCS.esperarElementVisibility("xpath", SacarPlataPageObjects.TXT_VALIDATE);
			BaseUtil.newAut = utilidadesTCS.getTextMobileElement("xpath", SacarPlataPageObjects.NEW_AUTORIZADOR);
			Utilidades.tomaEvidencia("Validé código para retiro de dinero en cajero: " + BaseUtil.newAut);
			System.out.println("Validé código para retiro de dinero en cajero: " + BaseUtil.newAut);
			BaseUtil.tipoTransaccion = "SACAR PLATA - SOLICITUD OTP AP";
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.END_BTN);
			Utilidades.esperaMiliseg(2000);
			
			enterToSacarPlata();
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.AMOUNT_MONEY_FIELD, montoExitoso);
			utilidadesTCS.clickByCoordinates(190, 460);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.CONTINUE_BTN);
			Utilidades.esperaMiliseg(500);
			
		    for (int intento = 1; intento <= 4; intento++) {
				utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.INPUT_PASS_FIELD);
				utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.INPUT_PASS_FIELD, contrasenaErronea);
				utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.SACAR_PLATA_BTN);

		        if (intento < 4) {
					Utilidades.esperaMiliseg(900);
		        	Utilidades.tomaEvidencia("Ingreso clave errónea: Intento " + intento);
		            System.out.println("Ingreso clave errónea: Intento " + intento);
		        } else {
					Utilidades.esperaMiliseg(1500);
		            Utilidades.tomaEvidencia("Validé mensaje 'Algo salió mal luego de cuarta clave errónea. Superaste el número de intentos' Intenta en 5:00 minutos'");
		        }
		    }
			Utilidades.esperaMiliseg(500);
			// BOTÓN REGRESO DESDE INGRESO CONTRASEÑA HACIA SACAR PLATA.
		    utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.RETURN_BTN);
			Utilidades.esperaMiliseg(500);
			// BOTÓN REGRESO DESDE MÓDULO SACAR PLATA HACIA EL HOME.
		    utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.BACK_BTN_DESDE_SACARPLATA);
		}	
}
