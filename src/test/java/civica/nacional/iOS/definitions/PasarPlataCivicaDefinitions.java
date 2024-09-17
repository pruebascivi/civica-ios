package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.PasarPlataCivicaSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PasarPlataCivicaDefinitions {
	
	@Steps
	PasarPlataCivicaSteps pasarPlataSteps;
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	
	@When("^ingreso al módulo 'Pasar Plata'$")
	public void ingresoAlModuloPasarPlata() {
		pasarPlataSteps.enterToModulePasarPlata();
	}
	
	@Then("^ingreso 'Número celular' \"([^\"]*)\"$")
	public void ingresoNumeroCelular(String numCelular) {
		pasarPlataSteps.enterCellPhoneNum(numCelular);
	}
	
	@Then("^ingreso cuánta plata quiero pasar \"([^\"]*)\"$")
	public void ingresoCuantaPlataQuieroPasar(String valor) {
		pasarPlataSteps.enterAmountMoney(valor);
	}
	
	@Then("^ingreso cuánta plata quiero pasar valor erroneo \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoCuantaPlataQuieroPasarvalorErroneo(String valorErroneo, String valor, String numCelularDestino) {
		pasarPlataSteps.enterAmountMoneyError(valorErroneo, valor, numCelularDestino);
	}
	
	@When("^valido datos ingresados y doy a 'Pasar Plata' \"([^\"]*)\"$")
	public void validoDatosIngresadosYDoyAPasarPlata(String contrasena) {
		pasarPlataSteps.validateDataAndContinue(contrasena);
	}
	
	@When("^Valido saldos iniciales civica$")
	public void validoSaldosInicialesCivica() {
		pasarPlataSteps.validarSaldosInicialesCivica();
	}
	
	@When("^Valido el saldo inicial civica sin redeban$")
	public void validoElSaldoInicialCivicaSinRedeban() {
		pasarPlataSteps.validarSaldosInicialesCivicaSinRedeban();
	}
	
	@When("^Validar saldo final civica$")
	public void validarSaldoFinalCivica() {
		pasarPlataSteps.capturarSaldosFinalesCivica();
	}
	
	@When("^Validar movimientos en el aplicativo$")
	public void validarMovimientosEnElAplicativo() {
		pasarPlataSteps.capturarMovimientosCivica();
	}
	
	@Then("^Validar afectacion de saldos civica$")
	public void validarAfectacionDeSaldosCivica() {
		pasarPlataSteps.validarAfectacionSaldos();
	}
}