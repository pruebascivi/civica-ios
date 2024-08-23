package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.CambioClaveOlvidoSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.Given;
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
	
	@Given("ingreso correo erróneo y valido mensaje error \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoCorreoErroneoYValidoMensajeError(String correoErroneo, String newPass, String tipoID, String usuario, String correo) throws Exception {
		cambioClaveOlvidoSteps.confirmBadEmail(correoErroneo, newPass, tipoID, usuario, correo);
	}
	
	@Given("^confirmo correo electrónico y creo clave \"([^\"]*)\" \"([^\"]*)\"$")
	public void confirmoCorreoElectronicoYCreoClave(String correo, String newPass) throws Exception {
		cambioClaveOlvidoSteps.confirmEmail(correo, newPass);
	}
}