package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.RecargarCelularCivicaSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RecargarCelularCivicaDefinitions {
	
	@Steps
	RecargarCelularCivicaSteps recargarCelSteps;
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	
	@When("^ingreso al módulo 'Recargar Celular'$")
	public void ingresoAlModuloRecargarCelular() {
		recargarCelSteps.enterToModuleRecargarCelular();
	}
	
	@When("^selecciono operador del celular e ingreso datos de la recarga \"([^\"]*)\" \"([^\"]*)\"$")
	public void seleccionoOperadorDelCelularEIngresoDatosDeLaRecarga(String numCelular, String valor) {
		recargarCelSteps.selectOperatorAndEnterData(numCelular, valor);
	}
	
	@When("^selecciono operador del celular e ingreso datos de la recarga con valor erroneo \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void seleccionoOperadorDelCelularEIngresoDatosDeLaRecargaConValorErroneo(String numCelular, String valor, String badValue) {
		recargarCelSteps.selectOperatorAndEnterDataWithBadValue(numCelular, valor, badValue);
	}
	
	@When("^valido datos ingresados y finalizo el proceso \"([^\"]*)\"$")
	public void validoDatosIngresadosYFinalizoElProceso(String contrasena) {
		recargarCelSteps.validateDataAndEnd(contrasena);
	}
	
	
}