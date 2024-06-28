package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.LoginCivicaSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginCivicaDefinitions {
	
	@Steps
	LoginCivicaSteps loginRobustoSteps;
	
	@Given("ingreso al aplicativo")
	public void ingresoAlAplicativo() {
	    loginRobustoSteps.logInToTheApplication();
	}
	
	@When("^ingreso de nuevo$")
	public void ingresoDeNuevo() {
		loginRobustoSteps.loginAgain();
	}

	@Given("^verifico la version del aplicativo$")
	public void verificoLaVersionDelAplicativo() {
	    loginRobustoSteps.checkVersion();
	}

	@When("^ingreso las credenciales \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoLasCredenciales(String tipoID, String usuario, String contrasenia) throws Exception {
	    loginRobustoSteps.enterCredentials(tipoID, usuario, contrasenia);
	    BaseUtil.usuario = usuario;
	}
	
	@When("^ingreso nuevamente clave de manera errónea \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoNuevamenteClaveDeManeraErronea(String tipoID, String usuario, String contrasenia) throws Exception {
	    loginRobustoSteps.incorrectPasswordEntry(tipoID, usuario, contrasenia);
	}
	
	@When("^selecciono la opcion ingresar$")
	public void seleccionoLaOpcionIngresar() {
		loginRobustoSteps.clickOnEnterOption();
	}

	@Then("^verifico que me encuentro en el inicio de la app$")
	public void verificoQueMeEncuentroEnElInicioDeLaApp() {
		loginRobustoSteps.verifyToBeInsideTheApp();
	}
	
	@When("^Valido que el usuario al ingresar por (\\d+) vez la clave incorrecta del ingreso en APP Cívica se debe inhabilitar el campo “Clave” y se debe mostrar al usuario el mensaje “Algo salió mal$")
	public void validaoQueElUsuarioAlIngresarPorVezLaClaveIncorrectaDelIngresoEnAPPCívicaSeDebeInhabilitarElCampoClaveYSeDebeMostrarAlUsuarioElMensajeAlgoSalióMal(int arg1) {
		loginRobustoSteps.validatePopupErrorMaxLoginAttempt();
	}
	
	@Then("^Validar el mensaje de rechazo cuando se ingresa mal la clave de ingreso \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void validarElMensajeDeRechazoCuandoSeIngresaMalLaClaveDeIngreso(String tipoID, String usuario, String badPass, String contrasenia) throws Exception {
		loginRobustoSteps.checkWrongPassword(tipoID, usuario, badPass, contrasenia);
	    BaseUtil.usuario = usuario;
	}
	
	@When("^Cerrar sesion desde el home$")
	public void cerrarSesionDesdeElHome() {
		loginRobustoSteps.signOut();
	}
	
	/*PASO PARA VALIDAR INGRESO A LA APP DESPUES DE CAMBIAR CONTRASEÑA*/
	@When("^ingreso las credenciales con contraseña nueva \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoLasCredencialesConContrasenaNueva(String tipoID, String usuario, String newPass) throws Exception {
	    loginRobustoSteps.enterCredentialsNewPass(tipoID, usuario, newPass);
	    BaseUtil.usuario = usuario;
	}
}