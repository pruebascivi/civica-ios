package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.TransporteCivicaSteps;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TransporteCivicaDefinitions {
	
	@Steps
	TransporteCivicaSteps transporteCivSteps;
	
	@When("Ingreso a la seccion 'Beneficios de viaje'")
	public void ingresoALaSeccionBeneficiosDeViaje() throws Exception {
		transporteCivSteps.enterBeneficiosViajevModule();
	}
	
	@When("Valido mensaje parametrico")
	public void validoMensajeParametrico() throws Exception {
		transporteCivSteps.validateMsn();
	}
	
	@When("Valido si el usuario tiene trayectos guardados como favoritos")
	public void validoSiElUsuarioTieneTrayectosGuardadosComoFavoritos() throws Exception {
		transporteCivSteps.validateFavoriteRoutes();
	}
	
	@When("Valido la seccion 'Viaje en curso'")
	public void validoLaSeccionViajeEnCurso() throws Exception {
		transporteCivSteps.validateTripProgressSection();
	}
	
	@When("Valido el boton ver todos los trayectos guardados")
	public void validoElBotonVerTodosLosTrayectosGuardados() throws Exception {
		transporteCivSteps.validateBtnAllJourneys();
	}
	
	@When("Valido los trayectos predefinidos")
	public void validoLosTreayectoPredefinidos() throws Exception {
		transporteCivSteps.validateListJourneys();
	}
	
	@When("Valido opciones en seccion 'Lugares cercanos'")
	public void validoOpcionesEnSeccionLugaresCercanos() throws Exception {
		transporteCivSteps.validateNearPlaces();
	}

	@When("Valido campos en la seccion 'A donde vas'")
	public void validoCamposEnLaSeccionADondevAS() throws Exception {
		transporteCivSteps.validateWhereAreUGoing();
	}
	
	@When("Valido trayectos guardados en ver todos dentro de la seccion 'A donde vas'")
	public void validoTrayectosGuardadosEnVerTodosDentroDeLaSeccionADondeVas() throws Exception {
		transporteCivSteps.validateListJourneysSavesWAreUGo();
	}
	
	@When("Valido comportamientos en el mapa y verifico 'Boton Seleccionar Ubicacion'")
	public void validoComportomientosEnElMapaYVerificoBotonSeleccionarUbicacion() throws Exception {
		transporteCivSteps.validatePresenceSelectLocation();
	}
	
	@When("Verifico redireccion al ingresar a algun trayecto guardado")
	public void verificoRedireccionAlIngresarAAlgunTrayectoGuardado() throws Exception {
		transporteCivSteps.enterIntoJourneysSaves();
	}
	
	@When("Corroboro opciones al ingresar a la seccion 'A donde vas'")
	public void corroboroOpcionesAlIngresarALaSeccionADondeVas() throws Exception {
		transporteCivSteps.validateOptionsIntoWhereAreUGoing();
	}
	
	@When("Ingreso direccion actual y destino \"([^\"]*)\" \"([^\"]*)\"")
	public void ingresoDireccionActualYDestino(String direccionActual, String destino) throws Exception {
		transporteCivSteps.inputAdress(direccionActual, destino);
	}
	
	@When("Ingreso fecha de salida \"([^\"]*)\"")
	public void ingresoFechaDeSalida(String date) throws Exception {
		transporteCivSteps.inputDate(date);
	}
	
	@When("Ingreso hora de salida \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"")
	public void ingresoHoraDeSalida(String hora, String minuto, String jornada) throws Exception {
		transporteCivSteps.inputDepertureTime(hora, minuto, jornada);
	}
	
	@When("Valido presencia de trayectos sugeridos")
	public void validoPresenciaDeTrayectosSigeridos() throws Exception {
		transporteCivSteps.validateSuggestedRoutes();
	}
	
	@When("Valido mensaje popup al intentar ingresar a 'Botón QR'")
	public void validoMensajePopupAlIntentarIngresarABotonQR() throws Exception {
		transporteCivSteps.validateBtnQRPublicHome();
	}
}
