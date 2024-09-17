package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.CambioClaveCivicaSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class CambioClaveCivicaDefinitions {
	
	@Steps
	CambioClaveCivicaSteps cambioClaveSteps;
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	
	
	@Given("^selecciono la opción 'Cambia tu clave' \"([^\"]*)\"$")
	public void seleccionoLaOpcionCambiaTuClave(String contrasena) throws Exception {
		cambioClaveSteps.selectKeyChangeOption(contrasena);
	}
	
	@Given("^creo mi nueva clave Cívica \"([^\"]*)\"$")
	public void creoMiNuevaClaveCivica(String newPass) throws Exception {
		cambioClaveSteps.createNewPass(newPass);
	}
	
	@Given("^creo mi nueva clave Cívica \"([^\"]*)\" \"([^\"]*)\"$")
	public void creoMiNuevaClaveCivica(String newPass, String newPassBad) throws Exception {
		cambioClaveSteps.createNewPassBadPass(newPass, newPassBad);
	}

	@Given("^ingreso contrasena no permitida \"([^\"]*)\"$")
	public void ingresoContrasenaNoPermitida(String newPass) throws Exception {
		cambioClaveSteps.inputBadPass(newPass);
	}
	
	@Given("^valido Pop up de rechazo")
	public void validoPopUpDeRechazo() throws Exception {
		cambioClaveSteps.validatePopUpRechazo();
	}
	
	@Given("^valido rechazo contrasena similar")
	public void validoRechazoContrasenaSimilar() throws Exception {
		cambioClaveSteps.validateRechazoSamePass();
	}
}