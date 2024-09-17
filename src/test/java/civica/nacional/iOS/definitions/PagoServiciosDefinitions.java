package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.PagoServiciosSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PagoServiciosDefinitions {
	
	@Steps
	PagoServiciosSteps pagoServiciosSteps;
	
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	
	@Given("^ingreso al modulo 'Hacer pagos' \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoAlModuloHacerPagos(String servicio, String referencia) {
		pagoServiciosSteps.enterIntoHacerPagos(servicio, referencia);
	}
	
	@Given("^ingreso referencia no existente \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoReferenciaNoExistente(String servicio, String referencia) {
		pagoServiciosSteps.inputBadRef(servicio, referencia);
	}
	
	@When("^ingreso valor a pagar \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoValorAPagar(String valor, String contrasena) {
		pagoServiciosSteps.enterValuePaid(valor, contrasena);
	}
	 
	@When("^ingreso flujo valor a pagar con ref invalida \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoFlujoValorAPagarConRefInvalida(String valor, String contrasena) {
		pagoServiciosSteps.enterValuePaidInvalidRef(valor, contrasena);
	}
	
	@When("^ingreso clave erronea \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoClaveErronea(String valor, String contrasena) {
		pagoServiciosSteps.enterValuePaidBadPass(valor, contrasena);
	}
	
	@When("^Ingreso al modulo Hacer pagos$")
	public void ingresoAlModuloHacerPagos() {
		pagoServiciosSteps.ingresarAHacerPagos();
	}
	
	@When("^Valido secciones del modulo Hacer pagos$")
	public void validoSeccionesDelModuloHacerPagos() {
		pagoServiciosSteps.validarSecciones();
	}
	
	@When("^Valido solicitud permisos para escanear códigos$")
	public void validoSolicitudPermisosParaEscanearCodigos() {
		pagoServiciosSteps.validarPermisoScan();
	}
}