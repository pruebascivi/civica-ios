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
	public void seleccionoLaOpcionCambiaTuClave(String contrasena) {
		cambioClaveSteps.selectKeyChangeOption(contrasena);
	}
	
	@Given("^creo mi nueva clave Cívica \"([^\"]*)\"$")
	public void creoMiNuevaClaveCivica(String newPass) {
		cambioClaveSteps.createNewPass(newPass);
	}
	
	@Given("^creo mi nueva clave Cívica \"([^\"]*)\" \"([^\"]*)\"$")
	public void creoMiNuevaClaveCivica(String newPass, String newPassBad) {
		cambioClaveSteps.createNewPassBadPass(newPass, newPassBad);
	}

}