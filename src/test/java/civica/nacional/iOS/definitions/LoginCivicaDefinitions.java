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
	public void ingresoAlAplicativo() throws Exception {
	    loginRobustoSteps.logInToTheApplication();
	}
	
	@When("^ingreso de nuevo$")
	public void ingresoDeNuevo() throws Exception {
		loginRobustoSteps.loginAgain();
	}

	@Given("^verifico la version del aplicativo$")
	public void verificoLaVersionDelAplicativo() throws Exception {
	    loginRobustoSteps.checkVersion();
	}

	@When("^ingreso las credenciales \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoLasCredenciales(String tipoID, String usuario, String contrasenia) throws Exception {
	    BaseUtil.usuario = usuario;
		loginRobustoSteps.enterCredentials(tipoID, usuario, contrasenia);
	}
	
	@When("^ingreso credenciales desde el home \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoCredencialesDesdeElHome(String tipoID, String usuario, String contrasenia) throws Exception {
		loginRobustoSteps.enterCredentialsHome(tipoID, usuario, contrasenia);
	}
	
	@When("^ingreso nuevamente clave de manera errónea \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoNuevamenteClaveDeManeraErronea(String tipoID, String usuario, String contrasenia) throws Exception {
	    loginRobustoSteps.incorrectPasswordEntry(tipoID, usuario, contrasenia);
	}
	
	@When("^selecciono la opcion ingresar$")
	public void seleccionoLaOpcionIngresar() throws Exception {
		loginRobustoSteps.clickOnEnterOption();
	}
	
	@When("^selecciono ingresar opcion erronea$")
	public void seleccionoIngresarOpcionErronea() throws Exception {
		loginRobustoSteps.clickOnEnterOptionBad();
	}

	@Then("^verifico que me encuentro en el inicio de la app$")
	public void verificoQueMeEncuentroEnElInicioDeLaApp() throws Exception {
		loginRobustoSteps.verifyToBeInsideTheApp();
	}
	
	@Then("^Logout app$")
	public void logoutApp() throws Exception	{
		loginRobustoSteps.logoutApp();
	}
	
	@When("^Valido que el usuario al ingresar por (\\d+) vez la clave incorrecta del ingreso en APP Cívica se debe inhabilitar el campo “Clave” y se debe mostrar al usuario el mensaje “Algo salió mal$")
	public void validaoQueElUsuarioAlIngresarPorVezLaClaveIncorrectaDelIngresoEnAPPCívicaSeDebeInhabilitarElCampoClaveYSeDebeMostrarAlUsuarioElMensajeAlgoSalióMal(int arg1) throws Exception {
		loginRobustoSteps.validatePopupErrorMaxLoginAttempt();
	}
	
	@Then("^Validar el mensaje de rechazo cuando se ingresa mal la clave de ingreso \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void validarElMensajeDeRechazoCuandoSeIngresaMalLaClaveDeIngreso(String tipoID, String usuario, String badPass, String contrasenia) throws Exception {
	    BaseUtil.usuario = usuario;
		loginRobustoSteps.checkWrongPassword(tipoID, usuario, badPass, contrasenia);
	}
	
	@Then("^Validar el mensaje de rechazo cuando se ingresa mal la clave de ingreso \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void validarElMensajeDeRechazoCuandoSeIngresaMalLaClaveDeIngreso(String tipoID, String usuario, String badPass) throws Exception {
	    BaseUtil.usuario = usuario;
		loginRobustoSteps.checkWrongPasswordUnique(tipoID, usuario, badPass);
	}
	
	@Then("^Validar el mensaje de rechazo cuando se ingresa mal la clave de ingreso por num de intentos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void validarElMensajeDeRechazoCuandoSeIngresaMalLaClaveDeIngresoPorNumDeIntentos(String tipoID, String usuario, String badPass) throws Exception {
	    BaseUtil.usuario = usuario;
		loginRobustoSteps.checkWrongPasswordNumTries(tipoID, usuario, badPass);
	}
	
	@When("^Cerrar sesion desde el home$")
	public void cerrarSesionDesdeElHome() throws Exception {
		loginRobustoSteps.signOut();
	}
	
	/*PASO PARA VALIDAR INGRESO A LA APP DESPUES DE CAMBIAR CONTRASEÑA*/
	@When("^ingreso las credenciales con contraseña nueva \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoLasCredencialesConContrasenaNueva(String tipoID, String usuario, String newPass) throws Exception {
	    BaseUtil.usuario = usuario;
		loginRobustoSteps.enterCredentialsNewPass(tipoID, usuario, newPass);
	}
}