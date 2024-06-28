package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.RecargaTarjetaCivicaSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RecargaTarjetaCivicaDefinitions {
	
	@Steps
	RecargaTarjetaCivicaSteps recargaTarjetaSteps;
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	

	@Then("^Ingreso al modulo 'Tu Tarjeta Civica'$")
	public void ingresoAlModuloTuTarjetaCivica() {
		recargaTarjetaSteps.enterModuleTuTarjetaCivica();
	}
	
	@When("^Valido saldos iniciales$")
	public void validoSaldosInicialesCivica() {
		recargaTarjetaSteps.validarSaldosInicialesCivica();
	}
	
	@Then("^Ingreso datos de la recarga \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoDatoDeLaRecarga(String tipoDocumento, String documento) {
		recargaTarjetaSteps.validateRechargeTarget(tipoDocumento, documento);
	}
	
	@Then("Verifico si el usuario tiene tarjetas agregadas a favoritos en 'Recarga Tarjeta Civica' \"([^\"]*)\" \"([^\"]*)\"")
	public void verificoSiElUsuarioTieneTarjetasAgregadasAFavoritosEnRecargaTarjetaCivica(String tipoDocumento, String documento) {
		recargaTarjetaSteps.verificateFavsIntoModule(tipoDocumento, documento);
	}
	
	@Then("^Ingreso monto a transar y contrasenia \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoMontoATransarYContrasenia(String monto, String contrasena) {
		recargaTarjetaSteps.inputAmoutAndPass(monto, contrasena);
	}
	
	@When("Obtengo código de autenticacion de la transaccion")
	public void obtengoCodigoDeAutorizacionDeLaTransaccion() throws Exception {
		recargaTarjetaSteps.validateAuthenticationCode();
	}
	
	@When("Valido mensaje popup al intentar ingresar a 'Tu tarjeta Civica'")
	public void validoMensajePopupAlIntentarIngresarATuTarjetaCivica() throws Exception {
		recargaTarjetaSteps.validateBtnCivicaCardPublicHome();
	}
	
	@Then("^Valido boton de favoritos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void validoBotonDeFavoritos(String monto, String contrasena, String favoriteTxt) {
		recargaTarjetaSteps.validateIconFav(monto, contrasena, favoriteTxt);
	}
	 

}