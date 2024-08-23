package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.PantallaMasServiciosSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class PantallaMasServiciosDefinitions {

	@Steps
	PantallaMasServiciosSteps pantallaMasServiciosSteps;
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	
	@Given("^Validar el boton mas servicios en el home publico$")
	public void ValidarElBotonMasServiciosEnElHomePublico() {
		pantallaMasServiciosSteps.ValidarElBotonMasServiciosEnElHomePublico();
	}
	
	@Then("^Validar el boton mas servicios en el home privado$")
	public void ValidarElBotonMasServiciosEnElHomePrivado() {
		pantallaMasServiciosSteps.ValidarElBotonMasServiciosEnElHomePrivado();
	}
	
}



