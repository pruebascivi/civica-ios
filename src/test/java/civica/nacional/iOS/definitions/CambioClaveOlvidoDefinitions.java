package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.CambioClaveOlvidoSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CambioClaveOlvidoDefinitions {
	
	@Steps
	CambioClaveOlvidoSteps cambioClaveOlvidoSteps;	
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	
	@Given("^ingreso al módulo 'Olvidaste tu clave' \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoAlModuloOlvidasteTuClave(String tipoID, String usuario) {
	    BaseUtil.usuario = usuario;
		cambioClaveOlvidoSteps.forgotPassOption(tipoID, usuario);
	}
	
	@When("^ingreso datos \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoDatos(String tipoID, String usuario) throws Exception {
	    BaseUtil.usuario = usuario;
	    cambioClaveOlvidoSteps.ingresarDatos(tipoID, usuario);
	}
	
	@Given("ingreso correo erróneo y valido mensaje error \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoCorreoErroneoYValidoMensajeError(String correoInvalido, String correoErroneo ) throws Exception {
		cambioClaveOlvidoSteps.confirmBadEmail(correoInvalido, correoErroneo);
	}
	
	@Given("^confirmo correo electrónico y creo clave \"([^\"]*)\" \"([^\"]*)\"$")
	public void confirmoCorreoElectronicoYCreoClave(String correo, String newPass) throws Exception {
		cambioClaveOlvidoSteps.confirmEmail(correo, newPass);
	}
	
	@Given("^confirmo correo y creo clave erronea \"([^\"]*)\" \"([^\"]*)\"$")
	public void confirmoCorreoYCreoClaveErronea(String correo, String badPass) throws Exception {
		cambioClaveOlvidoSteps.setMailAndBadPass(correo, badPass);
	}
	
	@Given("^confirmo popup al ingresar mal el correo \"([^\"]*)\"$")
	public void confirmoPopupAlIngresarMalElCorreo(String correo) throws Exception {
		cambioClaveOlvidoSteps.inputBadEmail(correo);
	}
}