package civica.nacional.iOS.definitions;

import java.math.BigDecimal;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import civica.nacional.iOS.modelo.ConsultaCupoTarjeta;
import civica.nacional.iOS.modelo.ConsultaCupoTarjetaDestino;
import civica.nacional.iOS.steps.WebRedebanSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;

public class WebRedebanDefinitions {
	
	Hooks Hooks;
	BaseUtil base;
	BigDecimal valorHome = null;
	BigDecimal valorTransferencia = null;
	Utilidades utilidad;
	Utilidades Utilidades;
	static String numCelular = "";
	
	@Steps
	WebRedebanSteps stepsWebRedeban;
	
	@Given("^consultar saldo tarjeta en redeban \"([^\"]*)\"$")
    public void consultarSaldoTarjetaEnRedeban(String usuario) throws Exception {
        stepsWebRedeban.ingresoNumeroClienteRedeban(usuario);
        String numTarjeta = stepsWebRedeban.returnNumeroTarjeta();
        ConsultaCupoTarjeta cupoTarjeta = stepsWebRedeban.consultaCuposTarjeta(numTarjeta);
        float realDisponible = Float.parseFloat(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
        float bolsillos = Float.parseFloat(cupoTarjeta.getSaldoBolsillos().replace(".", "").replace(",", "."));
        BaseUtil.saldos.add(realDisponible);
        BaseUtil.saldos.add(bolsillos);
        System.out.println("Real Disponible tarjeta " + numTarjeta + ": " + cupoTarjeta.getRealDisponible());
        System.out.println("Bolsillos tarjeta " + numTarjeta + ": " + cupoTarjeta.getSaldoBolsillos());
        String saldoTarjeta = cupoTarjeta.getRealDisponible();
        Serenity.setSessionVariable("saldoTarjeta").to(saldoTarjeta);
    }
	
	@Then("^Logout redeban$")
    public void logoutRedeban() throws Exception {
        stepsWebRedeban.logOut("//img[contains(@src, 'logout.gif')]");
    }
	
	@Then("^validar afectacion saldos tarjetas de daviplata a bolsillos$")
	public void validarIgualdadSaldosTarjetasDaviplataBolsillos() throws Exception {
		double montoInt = BaseUtil.montoTransado.doubleValue();
		int cantidadSaldos = BaseUtil.saldos.size();
		try {
			
			assertThat(cantidadSaldos, is(equalTo(4)));
			double sumaPrimeraTarjeta = BaseUtil.saldos.get(1);
			double sumaSegundaTarjeta = BaseUtil.saldos.get(3);
			
			assertThat(sumaSegundaTarjeta, is(equalTo(sumaPrimeraTarjeta + montoInt)));
			System.out.println("La transacción afectó la cuenta del cliente en redeban");
				
		}catch(Exception e) {
			fail("No se pudo validar la afectacion de saldos en redeban debido a: " + e.getMessage());
		}
	}
	
	@Then("^validar afectacion saldos tarjetas de bolsillos a daviplata$")
	public void validarIgualdadSaldosTarjetasBolsillosDaviplataEliminacion() throws Exception {
		
		double montoInt = BaseUtil.montoTransado.doubleValue();
		int cantidadSaldos = BaseUtil.saldos.size();
		try {
			
			assertThat(cantidadSaldos, is(equalTo(4)));
			double sumaPrimeraTarjeta = BaseUtil.saldos.get(0);
			double sumaSegundaTarjeta = BaseUtil.saldos.get(2); 
			
			assertThat(sumaSegundaTarjeta, is(equalTo(sumaPrimeraTarjeta + montoInt)));
			System.out.println("La transacción afectó correctamente la cuenta del cliente en redeban");
				
		}catch(Exception e) {
			fail("No se pudo validar la afectacion de saldos en redeban debido a: " + e.getMessage());
		}
    }
	
	@Given("^consultar saldos tarjetas en redeban origen y destino \"([^\"]*)\"\"([^\"]*)\"$")
	public void consultarSaldoTarjetaEnRedeban(String usuario, String usuario2) throws Exception {
		stepsWebRedeban.ingresoNumeroClienteRedeban(usuario);
		String numTarjeta = stepsWebRedeban.returnNumeroTarjeta();
		ConsultaCupoTarjeta cupoTarjeta = stepsWebRedeban.consultaCuposTarjeta(numTarjeta);
		float realDisponible = Float.parseFloat(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
		float bolsillos = Float.parseFloat(cupoTarjeta.getSaldoBolsillos().replace(".", "").replace(",", "."));
		BaseUtil.saldos.add(realDisponible);
		BaseUtil.saldos.add(bolsillos);
		System.out.println("Real Disponible tarjeta " + numTarjeta + ": " + cupoTarjeta.getRealDisponible());
		System.out.println("Bolsillos tarjeta " + numTarjeta + ": " + cupoTarjeta.getSaldoBolsillos());
		String saldoTarjeta = cupoTarjeta.getRealDisponible();
		Serenity.setSessionVariable("saldoTarjeta").to(saldoTarjeta);

		stepsWebRedeban.consultaSaldosUsuario2(usuario2);
		
		String numTarjeta2 = stepsWebRedeban.returnNumeroTarjeta();
		ConsultaCupoTarjeta cupoTarjeta2 = stepsWebRedeban.consultaCuposTarjeta(numTarjeta);
		float realDisponible2 = Float.parseFloat(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
		float bolsillos2 = Float.parseFloat(cupoTarjeta.getSaldoBolsillos().replace(".", "").replace(",", "."));
		BaseUtil.saldos.add(realDisponible2);
		BaseUtil.saldos.add(bolsillos2);
		System.out.println("Real Disponible tarjeta " + numTarjeta2 + ": " + cupoTarjeta2.getRealDisponible());
		System.out.println("Bolsillos tarjeta " + numTarjeta2 + ": " + cupoTarjeta2.getSaldoBolsillos());
		String saldoTarjeta2 = cupoTarjeta2.getRealDisponible(); 
		Serenity.setSessionVariable("saldoTarjeta2").to(saldoTarjeta2);
		System.out.println("Ya realicé las consultas respectivas");
	}
	
	@Then("^valido igualdad saldos cuenta origen y destino$")
    public void validarIgualdadSaldosUsuarios() throws Exception {
        int cantidadSaldos = BaseUtil.saldos.size();
        if (cantidadSaldos == 8) {
            double sumaPrimeraTarjetaCliente1 = BaseUtil.saldos.get(0) + BaseUtil.saldos.get(1);
            double sumaPrimeraTarjetaCliente2 = BaseUtil.saldos.get(2) + BaseUtil.saldos.get(3);
            double sumaSegundaTarjetaCliente1 = BaseUtil.saldos.get(4) + BaseUtil.saldos.get(5);
            double sumaSegundaTarjetaCliente2 = BaseUtil.saldos.get(6) + BaseUtil.saldos.get(7);
            assertThat(sumaPrimeraTarjetaCliente1, is(equalTo(sumaSegundaTarjetaCliente1)));
            assertThat(sumaPrimeraTarjetaCliente2, is(equalTo(sumaSegundaTarjetaCliente2)));
            System.out.println("Validé los saldos en redeban correctamente");
        }else {
            System.out.println("No pude validar saldos");
        }
	}
	
	@Then("^valido igualdad saldos cuenta origen$")
	public void validoIgualdadSaldosCuentaOrigen() {
		
		int cantidadSaldos = BaseUtil.saldos.size();
		if (cantidadSaldos == 4) {
			double sumaPrimeraTarjeta = BaseUtil.saldos.get(0) + BaseUtil.saldos.get(1);
			double sumaSegundaTarjeta = BaseUtil.saldos.get(2) + BaseUtil.saldos.get(3);
			
			if(sumaPrimeraTarjeta == sumaSegundaTarjeta) {
				System.out.println("La transaccion no afectó redeban");
			}else if((sumaSegundaTarjeta) == (sumaPrimeraTarjeta - 10000)) {
				System.out.println("La transaccion  afectó redeban correctamente");
			}else {
				System.out.println("Hubo un error");
			}
		}else {
			System.out.println("No pude validar saldos");
		}
	}
	
	@Given("^Validar en redeban subtipo \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void validarEnRedebanSubtipo(String cuenta, String subtipo, String celular) throws Exception {
	    BaseUtil.numeroCelular = celular;
		BaseUtil.montoTrasadoRedeban = stepsWebRedeban.consultasubtipo(cuenta, subtipo, celular);
	}
	
	@Given("^Validar en redeban subtipo destino \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void validarEnRedebanSubtipoDestino(String cuenta, String subtipo, String celular) throws Exception {
		BaseUtil.montoTrasadoRedeban = stepsWebRedeban.consultasubtipoDestino(cuenta, subtipo, celular);
	}
	
	@Given("^Validar en redeban el subtipo del usuario \"([^\"]*)\" \"([^\"]*)\"$")
	public void validarEnRedebanElSubtipoElUsuario(String cuenta, String subtipo) throws Exception {
		BaseUtil.montoTrasadoRedeban = stepsWebRedeban.consultarSubtipos(cuenta, subtipo);
	}

	@Given("^obtener numero celular actual en redeban bolsillos con sesion redeban abierta \"([^\"]*)\"$")
	public void obtenerNumeroCelularActualEnRedebanBolsillosConSesionRedebanAbierta(String usuario) throws Exception {
	    numCelular = stepsWebRedeban.consultaNumeroCelularConSesionAbierta(usuario);
		assertNotNull(numCelular);
	}
	
	@Given("^consultar saldos tarjetas en redeban origen y destino con sesion redeban abierta \"([^\"]*)\"\"([^\"]*)\"$")
	public void consultarSaldosTarjetasEnRedebanOrigenYDestinoConSesionRedebanAbierta(String usuario, String usuario2) throws Exception {
		stepsWebRedeban.ingresoNumeroClienteRedebanSesionAbierta(usuario);
		String numTarjeta = stepsWebRedeban.returnNumeroTarjeta();
		ConsultaCupoTarjeta cupoTarjeta = stepsWebRedeban.consultaCuposTarjeta(numTarjeta);
		float realDisponible = Float.parseFloat(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
		float bolsillos = Float.parseFloat(cupoTarjeta.getSaldoBolsillos().replace(".", "").replace(",", "."));
		BaseUtil.saldos.add(realDisponible);
		BaseUtil.saldos.add(bolsillos);
		System.out.println("Real Disponible tarjeta " + numTarjeta + ": " + cupoTarjeta.getRealDisponible());
		System.out.println("Bolsillos tarjeta " + numTarjeta + ": " + cupoTarjeta.getSaldoBolsillos());
		String saldoTarjeta = cupoTarjeta.getRealDisponible();
		Serenity.setSessionVariable("saldoTarjeta").to(saldoTarjeta);

		stepsWebRedeban.consultaSaldosUsuario2(usuario2);
		
		String numTarjeta2 = stepsWebRedeban.returnNumeroTarjeta();
		ConsultaCupoTarjeta cupoTarjeta2 = stepsWebRedeban.consultaCuposTarjeta(numTarjeta);
		float realDisponible2 = Float.parseFloat(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
		float bolsillos2 = Float.parseFloat(cupoTarjeta.getSaldoBolsillos().replace(".", "").replace(",", "."));
		BaseUtil.saldos.add(realDisponible2);
		BaseUtil.saldos.add(bolsillos2);
		System.out.println("Real Disponible tarjeta " + numTarjeta2 + ": " + cupoTarjeta2.getRealDisponible());
		System.out.println("Bolsillos tarjeta " + numTarjeta2 + ": " + cupoTarjeta2.getSaldoBolsillos());
		String saldoTarjeta2 = cupoTarjeta2.getRealDisponible(); 
		Serenity.setSessionVariable("saldoTarjeta2").to(saldoTarjeta2);
		System.out.println("Ya realicé las consultas respectivas");
	}
	
	@Given("^Obtener numero celular actual en redeban \"([^\"]*)\"$")
	public void obtenerNumeroCelularActualEnRedebanAumentoDeTopes(String usuario) throws Exception {
		numCelular = stepsWebRedeban.consultaNumeroCelular(usuario);
		BaseUtil.numeroCelular = numCelular;
		assertNotNull(numCelular);
	}
	
	@Given("^Obtener numero celular destino en redeban \"([^\"]*)\"$")
	public void obtenerNumeroCelularDestinoEnRedebanAumentoDeTopes(String usuario) throws Exception {
		stepsWebRedeban.consultaNumeroCelularDestino(usuario);
	}
	
	@Given("^Consultar saldos en redeban$")
	public void consultarSaldoTarjetaEnRedebanPasarPlata() throws Exception {
		String numTarjeta = stepsWebRedeban.returnNumeroTarjeta();
		ConsultaCupoTarjeta cupoTarjeta = stepsWebRedeban.consultaCuposTarjeta(numTarjeta);
		float realDisponible = Float.parseFloat(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
		BaseUtil.saldos.add(realDisponible);
		System.out.println("Real Disponible tarjeta " + numTarjeta + ": " + cupoTarjeta.getRealDisponible());
	}
	
	@Given("^Consultar saldos usuario destino en redeban$")
	public void consultarSaldoUsuarioDestinoEnRedeban() throws Exception {
		String numTarjetaDestino = stepsWebRedeban.returnNumeroTarjetaDestino();
		ConsultaCupoTarjetaDestino cupoTarjetaDestino = stepsWebRedeban.consultaCuposTarjetaDestino(numTarjetaDestino);
		float realDisponibleDestino = Float.parseFloat(cupoTarjetaDestino.getRealDisponibleDestino().replace(".", "").replace(",", "."));
		BaseUtil.saldoDestino.add(realDisponibleDestino);
		System.out.println("Real Disponible tarjeta destino " + numTarjetaDestino + ": " + cupoTarjetaDestino.getRealDisponibleDestino());
	}
	
	@Then("^Validar en redeban la transansaccion \"([^\"]*)\"$")
    public void validarEnRedeban(String cuenta) throws Exception {
        System.out.println("base: " + BaseUtil.Autorizador);
        BaseUtil.idTransaccion = BaseUtil.Autorizador;
        BaseUtil.montoTrasadoRedeban = stepsWebRedeban.consultaDiaria3(cuenta, BaseUtil.Autorizador);
        System.out.println("El monto transado es: " + BaseUtil.montoTrasadoRedeban);
    }
	
	@Then("^Entre a detalles de usuario$")
    public void entreADetalleDeUsuario() throws Exception {
		stepsWebRedeban.userDetails();
	}

}
