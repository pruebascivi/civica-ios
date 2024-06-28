package civica.nacional.iOS.steps;

import java.math.BigDecimal;

import civica.nacional.iOS.pageObjects.PagoServiciosPage;
import civica.nacional.iOS.pageObjects.RecargarCelularCivicaPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class RecargarCelularCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	RecargarCelularCivicaPage recargarCelPage;
	Utilidades utilidades;
	BaseUtil baseUtil;

	@Step
	public void enterToModuleRecargarCelular() {
		Utilidades.esperaMiliseg(1500);
	    try {
	    	utilidadesTCS.validateElementVisibility("xpath", RecargarCelularCivicaPage.RECARGAR_CEL_BTN);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.RECARGAR_CEL_BTN);
			Utilidades.esperaMiliseg(3000);
			Utilidades.tomaEvidencia("Ingresé a la sección de selección de operador en el modulo Recargar Celular");
			BaseUtil.tipoTransaccion = "RECARGAR CELULAR";
	    } catch (Exception e) {
	        // Manejo de la excepción
	        e.printStackTrace(); // Imprime la traza de la excepción.
	    }
	}	
	
	
	@Step
	public void selectOperatorAndEnterData(String numCelular, String valor) {
		
		try {
			int valueInAccounta = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
			int valueToSend = Integer.parseInt(valor.trim());
			
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.validateElementVisibility("xpath", RecargarCelularCivicaPage.VALIDATE_VISIBLE_TXT);
			Utilidades.tomaEvidencia("Verifiqué y seleccioné el operador del celular");
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.OPERATOR_SELECTION_CLARO_BTN); 
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_CELLPHONE_NUM_FIELD);
			utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_CELLPHONE_NUM_FIELD, numCelular);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
			Utilidades.esperaMiliseg(500);
			
			if(valueInAccounta < valueToSend || valueToSend > 100000 || valueToSend < 1000) {
				
				utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD);
				utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD, valor);
				utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
				Utilidades.tomaEvidencia("Ingresé el número de celular y el monto a recargar");
				Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("Se intenta hacer una transacción sin contar con el saldo completo o supera el tope permitido.");
		        assert false : "Se intenta hacer una transacción sin contar con el saldo completo o supera el tope permitido.";
							
			} else {
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD);
			utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD, valor);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
			Utilidades.tomaEvidencia("Ingresé el número de celular y el monto a recargar");
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
			utilidadesTCS.scrollBackground(RecargarCelularCivicaPage.FIELD_VIEW);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Validé campos ingresados");
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.CONTINUE_BTN);
			
			BigDecimal valorBigDecimal = new BigDecimal(valor); 
			BaseUtil.montoTransado = valorBigDecimal;
		  }
		} catch (Exception e) {
	        // Manejo de la excepción
	        e.printStackTrace(); // Imprime la traza de la excepción.
	    }		
	}
	
	@Step
	public void selectOperatorAndEnterDataWithBadValue(String numCelular, String valor, String badValue) {
		
		try {
			int valueInAccounta = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
			int valueToSend = Integer.parseInt(badValue.trim());
			
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.validateElementVisibility("xpath", RecargarCelularCivicaPage.VALIDATE_VISIBLE_TXT);
			Utilidades.tomaEvidencia("Verifiqué y seleccioné el operador del celular");
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.OPERATOR_SELECTION_CLARO_BTN); 
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_CELLPHONE_NUM_FIELD);
			utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_CELLPHONE_NUM_FIELD, numCelular);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
			Utilidades.esperaMiliseg(500);

			if(valueInAccounta < valueToSend || valueToSend > 100000 || valueToSend < 1000) {
				
				utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD);
				utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD, badValue);
				utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
				Utilidades.tomaEvidencia("Ingresé un monto no permitido.");
				Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("Se intenta hacer una transacción sin contar con el saldo completo o supera el tope permitido.");
				utilidadesTCS.cleanInputElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
				utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD, valor);
				Utilidades.tomaEvidencia("Ingresé un monto permitido.");

				
			}
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD);
			utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD, valor);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
			Utilidades.tomaEvidencia("Ingresé el número de celular y el monto a recargar");
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
			utilidadesTCS.scrollBackground(RecargarCelularCivicaPage.FIELD_VIEW);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Validé campos ingresados");
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.CONTINUE_BTN);
			
			BigDecimal valorBigDecimal = new BigDecimal(valor); 
			BaseUtil.montoTransado = valorBigDecimal;
			
		} catch (Exception e) {
	        // Manejo de la excepción
	        e.printStackTrace(); // Imprime la traza de la excepción.
	    }		
	}
	
	
	@Step
	public void validateDataAndEnd(String contrasena) {
		
		try {
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_PASS_FIELD);
			utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_PASS_FIELD, contrasena);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.RECHARGE_BTN);
			Utilidades.esperaMiliseg(1000);

			boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", PagoServiciosPage.BAD_PASS_IMPUT, "La clave no es correcta");
			
			if(isElementVisible) {
				
				for(int i=0; i<=4; i++) {
					utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
					utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_PASS_FIELD, contrasena );
					utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
					Utilidades.esperaMiliseg(500);
					utilidadesTCS.clicElement("xpath",PagoServiciosPage.PASS_CONTINUE_BTN);
				}
				Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("No fue posible el ingreso por exceder número intentos ingresando clave errónea.");
		        assert false : "No fue posible el ingreso por exceder número intentos ingresando clave errónea.";
		        
			} else {
				Utilidades.esperaMiliseg(1000);
				Utilidades.tomaEvidencia("Transferencia dinero (error en ambiente)");
				//utilidadesTCS.validateElementVisibility("xpath", RecargarCelularCivicaPage.VALIDATE_TXT_RECARGA_REALIZADA);
				Utilidades.tomaEvidencia("Recarga realizada");
				utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.END_BTN);
			}
			
		} catch (Exception e) {
	        // Manejo de la excepción
	        e.printStackTrace(); // Imprime la traza de la excepción.
	    }
	}	
}
