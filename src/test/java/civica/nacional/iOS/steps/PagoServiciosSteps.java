package civica.nacional.iOS.steps;

import java.math.BigDecimal;

import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.PagoServiciosPage;
import civica.nacional.iOS.pageObjects.PasarPlataCivicaPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class PagoServiciosSteps {
	
	UtilidadesTCS utilidadesTCS;
	PagoServiciosPage pagoServiciosPage;
	Utilidades utilidades;
	BaseUtil baseUtil;
	
	@Step
	public void enterIntoHacerPagos(String servicio, String referencia) {
	//	POP UP QUE SE CIERRA SOLO DURANTE LA AUTOMATIZACIÓN EN iOS, POR ESO SE COMENTA EL PASO DEL CLIC.
	//	utilidadesTCS.clicElement("xpath",pagoServiciosPage.ICON_CLOSE_BTN);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.HACER_PAGOS_BTN);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Ingresé al módulo 'Hacer Pagos'");
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.TODOS_HACER_PAGOS_BTN);
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.INPUT_COMPANY_SERVICE_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_COMPANY_SERVICE_FIELD, servicio );
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(100, 370);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.INPUT_REF_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_REF_FIELD, referencia );
		utilidadesTCS.clickByCoordinates(180, 400);
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.REF_CONTINUE_BTN);
		
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", PagoServiciosPage.FAIL_REF_IMPUT, "REFERENCIA PARA PAGO NO EXISTE");
		
		if(isElementVisible) {
			Utilidades.esperaMiliseg(800);
			Utilidades.tomaEvidencia("No se pudo realizar pago ya que el número de referencia no existe.");
	     // SE PRESENTA LA CONDICIÓN Y NO CUMPLE, SE IMPRIME MENSAJE Y TERMINA LA EJECUCIÓN.
	        assert false : "No se pudo realizar pago ya que el número de referencia no existe.";
	        
		} else {
	        System.out.println("Número de referencia valida, continua la ejecución.");
		}
	}
	
	@Step
	public void inputBadRef(String servicio, String referencia) {
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.HACER_PAGOS_BTN);
		Utilidades.esperaMiliseg(1000);
	    utilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 120);
		Utilidades.tomaEvidencia("Ingresé al módulo 'Hacer Pagos'");
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.TODOS_HACER_PAGOS_BTN);
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.INPUT_COMPANY_SERVICE_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_COMPANY_SERVICE_FIELD, servicio );
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(100, 370);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.INPUT_REF_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_REF_FIELD, referencia );
		utilidadesTCS.clickByCoordinates(180, 400);
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.REF_CONTINUE_BTN);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("No se pudo realizar pago ya que el número de referencia no existe.");
	}
	
	@Step
	public void takeInitialBalance() {
		utilidadesTCS.validateElementVisibility("xpath", PagoServiciosPage.INITIAL_BALANCE_TXT);
		boolean estado = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.INITIAL_BALANCE_TXT);
		utilidadesTCS.validateStatusElement(estado);
		String valor = utilidadesTCS.obtenerTexto("xpath", PagoServiciosPage.INITIAL_BALANCE_TXT);
		String newValor = UtilidadesTCS.removeDecimalBalances(valor);
		Utilidades.tomaEvidencia("Valido saldo inicial: " + newValor);
        System.out.println("Verifiqué saldo inicial: "+ newValor);
	}	
	
	@Step
	public void enterValuePaid(String valor, String contrasena) {
		
		int valueInAccount = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
		int valueToSend = Integer.parseInt(valor.trim());
		
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_VALUE_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_VALUE_FIELD, valor );
		BigDecimal valorBigDecimal = new BigDecimal(valor); 
		BaseUtil.montoTransado = valorBigDecimal;
		utilidadesTCS.clickByCoordinates(200, 300);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé el valor a pagar");
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.VALUE_CONTINUE_BTN);
		Utilidades.esperaMiliseg(500);
		
		if(valueInAccount < valueToSend) {
			Utilidades.esperaMiliseg(950);
			Utilidades.tomaEvidencia("Se intenta hacer una transacción sin contar con el saldo completo.");
	        assert false : "Se intenta hacer una transacción sin contar con el saldo completo.";
		} 
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_PASS_FIELD, contrasena );
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.PASS_CONTINUE_BTN);
		
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
			Utilidades.esperaMiliseg(5000);
			String numAutorizacion = utilidadesTCS.obtenerTexto("xpath", PagoServiciosPage.NUM_AUTORIZACION);
			BaseUtil.Autorizador = numAutorizacion;
			Utilidades.tomaEvidencia("Validé transacción exitosa");
			utilidadesTCS.clicElement("xpath",PagoServiciosPage.END_BTN);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",PagoServiciosPage.BACK_BTN);
		}
	}
	
	@Step
	public void enterValuePaidInvalidRef(String valor, String contrasena) {
		
		int valueInAccount = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
		int valueToSend = Integer.parseInt(valor.trim());
		
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_VALUE_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_VALUE_FIELD, valor );
		BigDecimal valorBigDecimal = new BigDecimal(valor); 
		BaseUtil.montoTransado = valorBigDecimal;
		utilidadesTCS.clickByCoordinates(200, 300);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé el valor a pagar");
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.VALUE_CONTINUE_BTN);
		Utilidades.esperaMiliseg(500);
		
		if(valueInAccount < valueToSend) {
			Utilidades.esperaMiliseg(950);
			Utilidades.tomaEvidencia("Se intenta hacer una transacción sin contar con el saldo completo.");
	        assert false : "Se intenta hacer una transacción sin contar con el saldo completo.";
		} 
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_PASS_FIELD, contrasena );
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.PASS_CONTINUE_BTN);
		
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
			Utilidades.esperaMiliseg(5000);
			Utilidades.tomaEvidencia("Validé mensaje referencia inválida");
		}
	}
	
	@Step
	public void enterValuePaidBadPass(String valor, String contrasena) {
		
		int valueInAccount = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
		int valueToSend = Integer.parseInt(valor.trim());
		
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_VALUE_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_VALUE_FIELD, valor);
		BigDecimal valorBigDecimal = new BigDecimal(valor); 
		BaseUtil.montoTransado = valorBigDecimal;
		utilidadesTCS.clickByCoordinates(200, 300);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé el valor a pagar");
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.VALUE_CONTINUE_BTN);
		Utilidades.esperaMiliseg(500);
		
		if(valueInAccount < valueToSend) {
			Utilidades.esperaMiliseg(950);
			Utilidades.tomaEvidencia("Se intenta hacer una transacción sin contar con el saldo completo.");
	        assert false : "Se intenta hacer una transacción sin contar con el saldo completo.";
		} 
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_PASS_FIELD, contrasena);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.PASS_CONTINUE_BTN);
		
		for(int i=0; i<=4; i++) {
			utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
			utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_PASS_FIELD, contrasena);
			utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",PagoServiciosPage.PASS_CONTINUE_BTN);
		}
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("No fue posible el ingreso por exceder número intentos ingresando clave errónea.");
	}

	@Step
	public void takeFinalBalance() {
		utilidadesTCS.validateElementVisibility("xpath", PagoServiciosPage.FINAL_BALANCE_TXT);
		boolean estado = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.FINAL_BALANCE_TXT);
		utilidadesTCS.validateStatusElement(estado);
		String valor = utilidadesTCS.obtenerTexto("xpath", PagoServiciosPage.FINAL_BALANCE_TXT);
		String newValor = UtilidadesTCS.removeDecimalBalances(valor);
		Utilidades.tomaEvidencia("Valido saldo final: " + newValor);
		utilidadesTCS.validateTextNotEqualTo(BaseUtil.initialBalance, newValor);
        System.out.println("Verifiqué saldo final: "+ newValor);
	}	
	
	@Step
	public void ingresarAHacerPagos() {
		UtilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.HACER_PAGOS_BTN);
	}
	
	@Step
	public void validarSecciones() {
		UtilidadesTCS.esperarElementVisibility("xpath", PagoServiciosPage.TXT_TIPO_PAGO);
		Utilidades.tomaEvidencia("Validé secciones dentro de Hacer pagos");
		boolean estadoScan = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.SCAN_CODIGO);
		utilidadesTCS.validateStatusElement(estadoScan);
		boolean estadoCategorias = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.CATEGORIAS);
		utilidadesTCS.validateStatusElement(estadoCategorias);
		boolean estadoFavoritos = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.FAVORITOS);
		utilidadesTCS.validateStatusElement(estadoFavoritos);
		boolean estadoRecientes = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.RECIENTES);
		utilidadesTCS.validateStatusElement(estadoRecientes);
	}
	
	@Step
	public void validarPermisoScan() {
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.SCAN_CODIGO);
		Utilidades.tomaEvidencia("Validé mensaje necesitamos acceder a la cámara.");
		Utilidades.esperaMiliseg(100);
		Utilidades.tomaEvidencia("Permisos de acceso de Cívica en el dispositivo móvil.");
	//	POP UP DE PERMISOS QUE SE CIERRA SOLO DURANTE LA AUTOMATIZACIÓN EN iOS, POR ESO SE COMENTA EL PASO DEL CLIC.
	//	utilidadesTCS.clicElement("xpath",PagoServiciosPage.CONFIGURAR_ACCESO_CAM);
	}

}
