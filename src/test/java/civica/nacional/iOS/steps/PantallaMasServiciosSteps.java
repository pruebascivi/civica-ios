package civica.nacional.iOS.steps;

import static org.junit.Assert.fail;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.PantallaMasServiciosPage;
import civica.nacional.iOS.pageObjects.PasarPlataCivicaPage;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Step;

public class PantallaMasServiciosSteps {
	
	UtilidadesTCS utilidadesTCS;
	LoginCivicaPage loginRobustoPage;
	LoginCivicaSteps loginpublico;
	PantallaMasServiciosSteps pantallamasserviciossteps;
	Utilidades utilidades;
	CambioClaveCivicaSteps cambioClaveCivicaSteps;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();


	//Validar boton de mas servicios en el home
	
	@Step
	public void ValidarElBotonMasServiciosEnElHomePublico() {
	
		try {
			UtilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
			Utilidades.tomaEvidencia("Validar que se presente el botón más servicios en la pantalla del Home público.");
			utilidadesTCS.clicElement("xpath",PantallaMasServiciosPage.BTN_MAS_SERVICIOS);
			Utilidades.esperaMiliseg(600);
			Utilidades.tomaEvidencia("Validar al dar clic en la opción más servicios. ");
			System.out.println("Ingresando al botón más servicios");
			utilidadesTCS.clicElement("xpath",PantallaMasServiciosPage.BTN_REGRESAR_LOGIN_DESDE_OPCION_MAS_SERVICIOS_HOME);
			utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
			Utilidades.tomaEvidencia("Se realiza el ingreso desde el menú hamburguesa.");
			} catch (Exception e) {
			fail("No se pudo interactuar con el elemento o tiempo de espera superado" + e);
			}  
	}
	
	@Step
	public void ValidarElBotonMasServiciosEnElHomePrivado() {
		try {
		UtilidadesTCS.esperarElementVisibility("xpath",PantallaMasServiciosPage.BTN_MAS_SERVICIOS);
		utilidadesTCS.clicElement("xpath",PantallaMasServiciosPage.BTN_INICIO);
		Utilidades.esperaMiliseg(400);
		UtilidadesTCS.esperarElementVisibility("xpath",PasarPlataCivicaPage.SALDOS_HOME);
		Utilidades.tomaEvidencia("Validar que se presente la opción más servicios en el home privado.");
		System.out.println("Ingresara al botón más servicios desde el home privado");
		utilidadesTCS.clicElement("xpath",PantallaMasServiciosPage.BTN_MAS_SERVICIOS);
		UtilidadesTCS.esperarElementVisibility("xpath",PantallaMasServiciosPage.BTN_MAS_SERVICIOS);
		Utilidades.tomaEvidencia("Validar que solo se visualicen los servicios activos, en este caso están las categorías: Turismo - Único Activo, y movilidad -Activo.");
		UtilidadesTCS.esperarElementVisibility("xpath",PantallaMasServiciosPage.SLIDER_UNO);
		Utilidades.tomaEvidencia("Validar las publicaciones de la parte inferior se ubique en la primera posición del carrusel.");
		Utilidades.esperaMiliseg(10000);
		UtilidadesTCS.esperarElementVisibility("xpath",PantallaMasServiciosPage.SLIDER_DOS);
		Utilidades.tomaEvidencia("Validar las publicaciones de la parte inferior se ubique en la segunda posición del carrusel.");
		Utilidades.esperaMiliseg(15000);
		Utilidades.tomaEvidencia("Validar nuevamente la publicación inicial.");
		utilidadesTCS.clicElement("xpath",PantallaMasServiciosPage.BTN_REGRESAR_DESDE_OPCION_MAS_SERVICIOS);
		UtilidadesTCS.esperarElementVisibility("xpath",PasarPlataCivicaPage.SALDOS_HOME);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		UtilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
		UtilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.BTN_INGRESO_REGISTRO_HOME);
		} catch (Exception e) {
		fail("No se pudo interactuar con el elemento o tiempo de espera superado" + e);
		} 

	}
	
	
}
