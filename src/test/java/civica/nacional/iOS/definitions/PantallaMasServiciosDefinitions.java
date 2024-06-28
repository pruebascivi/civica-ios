package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.PantallaMasServiciosSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

	
//Paso para validar boton mas servicios en home publico
	
	@Given("^Validar el boton mas servicios en el home publico$")
	public void ValidarElBotonMasServiciosEnElHomePublico() {
		pantallaMasServiciosSteps.ValidarElBotonMasServiciosEnElHomePublico();
	}
	
	@Then("^Validar el boton mas servicios en el home privado$")
	public void ValidarElBotonMasServiciosEnElHomePrivado() {
		pantallaMasServiciosSteps.ValidarElBotonMasServiciosEnElHomePrivado();
		
	}
	

}



