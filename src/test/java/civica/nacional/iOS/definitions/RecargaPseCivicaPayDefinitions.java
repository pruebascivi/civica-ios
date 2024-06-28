package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.RecargaPseCivicaPaySteps;
import civica.nacional.iOS.steps.WebRedebanSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RecargaPseCivicaPayDefinitions {
	
	@Steps
	RecargaPseCivicaPaySteps recargaPseSteps;
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	@Steps
	WebRedebanSteps stepsWebRedeban;
	

	@Then("^ingreso al modulo 'Recargar CivicaPay' \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoAlModuloRecargarCiviPay(String numCelular, String monto, String banco) throws Exception {
		recargaPseSteps.enterModuleRecargarCivicaPay(numCelular, monto, banco);
	}
	
	@Then("^Ingreso clave en PSE \"([^\"]*)\"$")
	public void ingresoClaveEnPSE(String clave) throws Exception {
		recargaPseSteps.enterPassAgency(clave);
	}
	
	@When("^Validar movimiento recarga CiviPay en el aplicativo$")
	public void validarMovimientosEnElAplicativo() throws Exception {
		recargaPseSteps.capturarMovimientoRecargaCiviPay();
	}
	
	@Then("^Validar en redeban Recarga CiviPay \"([^\"]*)\"$")
    public void validarEnRedeban(String cuenta) throws Exception {
        System.out.println("base: " + BaseUtil.tipoTransaccion);
        BaseUtil.montoTrasadoRedeban = stepsWebRedeban.consultaDiariaRecargaCiviPay(cuenta, BaseUtil.tipoTransaccion);
        System.out.println("El monto transado es: " + BaseUtil.montoTrasadoRedeban);
    }
	
	@When("^Valido saldos iniciales CivicaPay$")
	public void validoSaldosInicialesCivicaPay() throws Exception {
		recargaPseSteps.validarSaldosInicialesCivicaPay();
	}
	
	@Then("^Validar afectacion de saldos CivicaPay$")
	public void validarAfectacionDeSaldosCivica() throws Exception  {
		recargaPseSteps.validarAfectacionSaldosCivPay();
	}
	
	@Then("^Doy clic en el boton Recargar CiviPay desde home publico$")
	public void doyClicEnElBotonRecargarCivPayDesdeHomePublico() throws Exception  {
		recargaPseSteps.clicearBtnCiviPay();
	}
	
	@Then("^Valido Pop up Ingresa a la app$")
	public void validoPopUpIngresoALaApp() throws Exception  {
		recargaPseSteps.validarPopUp();
	}
	
	@When("^Pop up direge a la interfaz de ingreso de credenciales$")
	public void ingresoCredenciales() throws Exception {
		recargaPseSteps.validarRedireccionDelPopup();
	}
	
	@Given("^Valido estoy en el home publico$")
	public void validoEstoyEnElHomePublico() throws Exception  {
		recargaPseSteps.checkPublicHome();
	}
}