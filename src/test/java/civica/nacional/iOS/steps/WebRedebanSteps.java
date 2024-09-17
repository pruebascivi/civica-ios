package civica.nacional.iOS.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Date;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import civica.nacional.iOS.modelo.ConsultaClientes;
import civica.nacional.iOS.modelo.ConsultaCupoTarjeta;
import civica.nacional.iOS.modelo.ConsultaCupoTarjetaDestino;
import civica.nacional.iOS.pageObjects.WebRedebanPageObjects;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.serenitybdd.core.Serenity;

public class WebRedebanSteps {

	static String numeroTarjeta = "";
	static String correoActual = "";
	Utilidades utilidad;
	//Utilidades Utilidades;
	UtilidadesTCS utilidadesTCS;
	static String numeroTarjetaDestino = "";
	public static WebRedebanPageObjects webRedebanPageObjects;

	public String consultaDiaria(String numeroID, String autorizador) {
		String valor = null;
		try {
			WebRedebanPageObjects.abrirWebRedeban();
//			webRedebanPageObjects.clicBtnContinuar();
			WebRedebanPageObjects.sendKeysInputUsuario();
			WebRedebanPageObjects.sendKeysInputPass();
			WebRedebanPageObjects.clicBtnEnvia();
			WebRedebanPageObjects.clicBtnDebitoPrepago();
			WebRedebanPageObjects.clicBtnConsultaClientes();
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso cliente de Cívica");
			WebRedebanPageObjects.clicBtnEnviar();
			String tarjeta = WebRedebanPageObjects.returnNumeroTarjetaNor();
			Utilidades.tomaEvidenciaPantallaWeb("web-Guardo el numero de tarjeta");
			System.out.println(tarjeta);
			WebRedebanPageObjects.clicBtnAutorizador();
			WebRedebanPageObjects.clicBtnConsultas();
			WebRedebanPageObjects.clicBtnMovimientoDiario();
			WebRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso número tarjeta");
			Date date = new Date();
			try {
				String dateCurrent = Utilidades.formatDateInforme("yyyyMMdd", date);
				System.out.println(dateCurrent);
				WebRedebanPageObjects.sendKeysInputFecha(dateCurrent);
				Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso fecha de hoy " + dateCurrent);
				Utilidades.esperaMiliseg(2000);
				WebRedebanPageObjects.clicBtnAceptar();
				Utilidades.esperaMiliseg(3000);
				System.out.println("entró al try del date");
			} catch (Exception e) {
				WebRedebanPageObjects.clicBtnSalir();
				consultaDiaria(numeroID, autorizador);
				System.out.println("Entró al catch");
			}

			String registros = WebRedebanPageObjects.returnValorregistrps();
			System.out.println("El numero de registros es: " + registros);

			valor = WebRedebanPageObjects.returnValorTrans();
			Utilidades.tomaEvidenciaPantallaWeb("web-Busco por codigo de autorizacion " + autorizador);
			Serenity.setSessionVariable("autorizador").to(autorizador);
			// valor = valor.replace(".", "").replace(",", "");
			// valor = valor.substring(0,valor.length()-2);
			System.out.println("Valor " + valor);
//			String valorApp = Utilidades.insertarCaracter((valorTransferencia + "").split(".")[0], 3, ".");
//			Assert.assertEquals(valor, valorApp);
			Utilidades.tomaEvidenciaPantallaWeb("web-El valor encontrado es por " + valor);
//			webRedebanPageObjects.clicBtnSalir();
//			Utilidades.esperaMiliseg(500);
//			webRedebanPageObjects.cerrarWebRedeban();
		} catch (Exception e) {
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		return valor;
	}

	public String consultaDiariaAutorizadores(String numeroID) {
		String valor = null;
		try {
			WebRedebanPageObjects.abrirWebRedeban();
//			webRedebanPageObjects.clicBtnContinuar();
			WebRedebanPageObjects.sendKeysInputUsuario();
			WebRedebanPageObjects.sendKeysInputPass();
			WebRedebanPageObjects.clicBtnEnvia();
			WebRedebanPageObjects.clicBtnDebitoPrepago();
			WebRedebanPageObjects.clicBtnConsultaClientes();
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso cliente de Cívica");
			WebRedebanPageObjects.clicBtnEnviar();
			String tarjeta = WebRedebanPageObjects.returnNumeroTarjetaNor();
			Utilidades.tomaEvidenciaPantallaWeb("web-Guardo el numero de tarjeta");
			System.out.println(tarjeta);
			WebRedebanPageObjects.clicBtnAutorizador();
			WebRedebanPageObjects.clicBtnConsultas();
			WebRedebanPageObjects.clicBtnMovimientoDiario();
			WebRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso número tarjeta");
			Date date = new Date();
			try {
				String dateCurrent = Utilidades.formatDateInforme("yyyyMMdd", date);
				System.out.println(dateCurrent);
				WebRedebanPageObjects.sendKeysInputFecha(dateCurrent);
				Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso fecha de hoy " + dateCurrent);
				Utilidades.esperaMiliseg(2000);
				WebRedebanPageObjects.clicBtnAceptar();
				Utilidades.esperaMiliseg(3000);
				System.out.println("entró al try del date");
			} catch (Exception e) {
				WebRedebanPageObjects.clicBtnSalir();
				consultaDiariaAutorizadores(numeroID);
				System.out.println("Entró al catch");
			}

			String registros = WebRedebanPageObjects.obtenerValorRegistros();
			System.out.println("El numero de registros es: " + registros);
			if (registros == "0") {
				System.out.println("no encontre registros");
			}
			// List<String> autorizadores = MarketPlacePageObjects.listaAutorizadores;
			// System.out.println("autorizadores a buscar : " + autorizadores);
			// 3 a 12
			// boolean encontreAutorizadores =
			// webRedebanPageObjects.buscarAutorizadores(registros, autorizadores);
			// assertTrue(encontreAutorizadores);
			// *[@id="generalForm"]/table[2]/tbody/tr[3]/td[10]
		} catch (Exception e) {
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		return valor;
	}

	public String consultaDiaria2(String numeroID, String valorTransaccion) {
		String valor = null;
		try {
			WebRedebanPageObjects.abrirWebRedeban();
			// webRedebanPageObjects.clicBtnContinuar();
			WebRedebanPageObjects.sendKeysInputUsuario();
			WebRedebanPageObjects.sendKeysInputPass();
			WebRedebanPageObjects.clicBtnEnvia();
			WebRedebanPageObjects.clicBtnDebitoPrepago();
			WebRedebanPageObjects.clicBtnConsultaClientes();
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso cliente de Cívica");
			WebRedebanPageObjects.clicBtnEnviar();
			String tarjeta = WebRedebanPageObjects.returnNumeroTarjetaNor();
			System.out.println(tarjeta);
			WebRedebanPageObjects.clicRadioBtn();
			WebRedebanPageObjects.clicBtnVistaGeneral();
			String subtibo = WebRedebanPageObjects.returnLblSubTipo();
			System.out.println("El Sub Tipo del clientes es :" + subtibo);
			Utilidades.tomaEvidenciaPantallaWeb("web-Guardo información cliente");
			WebRedebanPageObjects.clicBtnAutorizador();
			WebRedebanPageObjects.clicBtnConsultas();
			WebRedebanPageObjects.clicBtnMovimientoDiario();
			WebRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso número tarjeta");
			Date date = new Date();
			try {
				String dateCurrent = Utilidades.formatDateInforme("yyyyMMdd", date);
				System.out.println(dateCurrent);
				WebRedebanPageObjects.sendKeysInputFecha(dateCurrent);
				Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso fecha de hoy " + dateCurrent);
				Utilidades.esperaMiliseg(2000);
				WebRedebanPageObjects.clicBtnAceptar();
				Utilidades.esperaMiliseg(3000);
			} catch (Exception e) {
				WebRedebanPageObjects.clicBtnSalir();
				consultaDiaria(numeroID, valorTransaccion);
			}
			WebRedebanPageObjects.obtenerValorTransado(valorTransaccion);
			WebRedebanPageObjects.clickCheckButtonTransaccion(valorTransaccion);
			// webRedebanPageObjects.obtenerInformacionTransaccion();
		} catch (Exception e) {
			logOut("//img[@onClick='sendLogOut()']");
		}
		return valor;
	}

	public String consultasubtipo(String numeroID, String subtipo) {
		String valor = null;
		try {
			WebRedebanPageObjects.abrirWebRedeban();
			// webRedebanPageObjects.clicBtnContinuar();
			WebRedebanPageObjects.sendKeysInputUsuario();
			WebRedebanPageObjects.sendKeysInputPass();
			WebRedebanPageObjects.clicBtnEnvia();
			WebRedebanPageObjects.clicBtnDebitoPrepago();
			WebRedebanPageObjects.clicBtnConsultaClientes();
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso cliente de Cívica");
			WebRedebanPageObjects.clicBtnEnviar();
			// String tarjeta = webRedebanPageObjects.returnNumeroTarjetaNor();
			// System.out.println(tarjeta);
			WebRedebanPageObjects.clicRadioBtn();
			WebRedebanPageObjects.clicBtnVistaGeneral();
			String[] subtibo = WebRedebanPageObjects.returnLblSubTipo().split(" ");
			assertThat(subtibo[0], equalTo(subtipo));
			System.out.println("El Sub Tipo del clientes es : " + subtibo[0] + " y el subtipo esperado es " + subtipo);
			Utilidades.tomaEvidenciaPantallaWeb("web-Guardo información cliente");

			boolean validacion = false;
			if (subtipo.contains(subtibo[0])) {

				validacion = true;
			}
			assertEquals(true, validacion);

		} catch (Exception e) {
			System.out.println("Hola estoy en el catch");
		}
		return valor;
	}

	public void validar() {
		String monto1 = BaseUtil.montoTransado.toString();
		String monto2 = BaseUtil.montoTrasadoRedeban;
		System.out.println(monto1);
		System.out.println(monto2);
		assertEquals(monto1, monto2);
	}

	public void ingresoNumeroClienteRedeban(String cliente) {
		String numeroCelular = null;
		loginWebRedeban();
		WebRedebanPageObjects.clicBtnDebitoPrepago();
		WebRedebanPageObjects.clicBtnConsultaClientes();
		WebRedebanPageObjects.clicChkNumeroID();
		WebRedebanPageObjects.sendKeysInputNumeroID(cliente);
		Utilidades.esperaMiliseg(1000);
		WebRedebanPageObjects.clicBtnEnviar();
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidenciaPantallaWeb("Consulta número tarjeta web Redeban");
		int row = WebRedebanPageObjects.returnTdEstado();
		System.out.println("row: " + row);
		String numeroBin = WebRedebanPageObjects.returnNumeroBin(row);
		System.out.println("num: " + numeroBin);
		if (numeroBin.length() != 0) {
			numeroTarjeta = WebRedebanPageObjects.returnNumeroTarjeta(row);
			System.out.println("Numero Tarjeta: " + numeroTarjeta);
			numeroCelular = numeroTarjeta.split(numeroBin)[1];
		} else {
			logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		}
		System.out.println("numero Celular: " + numeroCelular);
	}

	public ConsultaClientes consultaClientesWebRedeban(String cliente) {
		ConsultaClientes consultaClientes = new ConsultaClientes();
		try {
			consultaClientes = buscarPorDocumento(consultaClientes, cliente);
			pulsarDatosGeneralesTarjeta();
			consultaClientes = obtenerDatosGeneralesTarjeta(consultaClientes, cliente);
			System.out.println(consultaClientes.toString());
		} catch (Exception e) {
			logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
			System.out.println("Fallé en consultaClientesWebRedeban");
			e.printStackTrace();
		}
		return consultaClientes;
	}

	public ConsultaCupoTarjeta consultaCuposTarjeta(String tarjeta) {
		ConsultaCupoTarjeta cupoTarjeta = new ConsultaCupoTarjeta();
		try {
			buscarPorTarjeta(tarjeta);
			cupoTarjeta = obtenerSaldosTarjeta(cupoTarjeta, tarjeta);
			System.out.println("Cupo Tarjeta: " + cupoTarjeta.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		return cupoTarjeta;
	}
	
	public ConsultaCupoTarjetaDestino consultaCuposTarjetaDestino(String tarjetaDestino) {
		ConsultaCupoTarjetaDestino cupoTarjetaDestino = new ConsultaCupoTarjetaDestino();
		try {
			buscarPorTarjeta(tarjetaDestino);
			cupoTarjetaDestino = obtenerSaldosTarjetaDestino(cupoTarjetaDestino, tarjetaDestino);
			System.out.println("Cupo Tarjeta destino: " + cupoTarjetaDestino.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		return cupoTarjetaDestino;
	}
	
	public String consultaNumeroCelular(String cliente) {
		String numeroCelular = null;
		try {
			loginWebRedeban();
			WebRedebanPageObjects.clicBtnDebitoPrepago();
			WebRedebanPageObjects.clicBtnConsultaClientes();
			Utilidades.esperaMiliseg(5000);
//	        utilidadesTCS.esperaCargaElementoWeb(WebRedebanPageObjects.PROGRESS_BAR_REDEBAN, 60);
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(cliente);
			Utilidades.esperaMiliseg(500);
			WebRedebanPageObjects.clicBtnEnviar();
			Utilidades.esperaMiliseg(1000);
			WebRedebanPageObjects.validateVisibilityTxt();
			Utilidades.tomaEvidenciaPantallaWeb("Consulta número tarjeta web Redeban");
			int row = WebRedebanPageObjects.returnTdEstado();
			System.out.println("row: " + row);
			String numeroBin = WebRedebanPageObjects.returnNumeroBin(row);
			System.out.println("num: " + numeroBin);
			if (numeroBin.length() != 0) {
				numeroTarjeta = WebRedebanPageObjects.returnNumeroTarjeta(row);
				System.out.println("Numero Tarjeta: " + numeroTarjeta);
				Serenity.setSessionVariable("numeroTarjeta").to(numeroTarjeta);
				numeroCelular = numeroTarjeta.split(numeroBin)[1];
			} else {
				logOut("//img[contains(@src, 'logout.gif')]");
			}
			System.out.println("numero Celular: " + numeroCelular);
			Serenity.setSessionVariable("numeroCelularRedeban").to(numeroCelular);
		} catch (AssertionError e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("Error de aserción: " + e.getMessage());

		} catch (Exception e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("ERROR: " + e.getMessage());
		}

		return numeroCelular;
	}
	

	public String consultaEstadoExcepcion(String cliente) {
		loginWebRedeban();
		WebRedebanPageObjects.clicBtnDebitoPrepago();
		WebRedebanPageObjects.clicBtnConsultaClientes();
		WebRedebanPageObjects.clicChkNumeroID();
		WebRedebanPageObjects.sendKeysInputNumeroID(cliente);
		Utilidades.esperaMiliseg(1500);
		WebRedebanPageObjects.clicBtnEnviar();
		Utilidades.esperaMiliseg(1500);
		Utilidades.tomaEvidenciaPantallaWeb("Consulta Estado Excenta usuario");
		int row = WebRedebanPageObjects.returnTdEstado();
		System.out.println("row: " + row);
		String estadoExcenta = WebRedebanPageObjects.returnEstadoExcenta4x1000(row);
		System.out.println("estado Excenta del cliente: " + estadoExcenta);
		return estadoExcenta;
	}

	public String consultaNuevoNumeroCelular(String cliente) {
		String numeroCelular = "";
		loginWebRedeban();
		WebRedebanPageObjects.clicBtnDebitoPrepago();
		WebRedebanPageObjects.clicBtnConsultaClientes();
		WebRedebanPageObjects.clicChkNumeroID();
		WebRedebanPageObjects.sendKeysInputNumeroID(cliente);
		WebRedebanPageObjects.clicBtnEnviar();
		int row = WebRedebanPageObjects.returnContEstado();
		String numeroBin = WebRedebanPageObjects.returnNumeroBin(row);
		if (numeroBin.length() != 0) {
			numeroTarjeta = WebRedebanPageObjects.returnNumeroTarjeta(row);
			numeroCelular = numeroTarjeta.split(numeroBin)[1];
		} else {
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		System.out.println("Numero Celular: " + numeroCelular);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Consulta Celular Web Redeban");
		return numeroCelular;
	}

	/**
	 * Se loguea en RBM
	 */
	public void loginWebRedeban() {
		try {
			WebRedebanPageObjects.abrirWebRedeban();
			// webRedebanPageObjects.clicBtnContinuar();
			
			WebRedebanPageObjects.sendKeysInputUsuario();
			WebRedebanPageObjects.sendKeysInputPass();
			WebRedebanPageObjects.clicBtnEnvia();
		} catch (Exception e) {
			e.printStackTrace();
			WebRedebanPageObjects.clicBtnSalir();
			WebRedebanPageObjects.cerrarWebRedeban();
		}
	}

	public String correoActual(String usuario) {
		Utilidades.esperaMiliseg(2000);
		System.out.println("entré a consultar el número de celular");
		String numCelular = consultaNumeroCelular(usuario);
		Utilidades.esperaMiliseg(6000);
		System.out.println("dando click a btn monederos");
		WebRedebanPageObjects.clicBtnMonederos();
		Utilidades.esperaMiliseg(2000);
		System.out.println("dando click a btn app daviplata");
		WebRedebanPageObjects.clicBtnAppDaviplata();
		Utilidades.esperaMiliseg(2000);
		System.out.println("dando click a btn actualizar correo electronico");
		WebRedebanPageObjects.clicBtnActualizarCorreoElectronico();
		Utilidades.esperaMiliseg(2000);
		System.out.println("ingresando numero de celular");
		WebRedebanPageObjects.ingresarNumeroCelular(numCelular);
		Utilidades.esperaMiliseg(2000);
		System.out.println("dando click a btn enviar");
		WebRedebanPageObjects.clicBtnEnviar();
		Utilidades.esperaMiliseg(2000);
		System.out.println("obteniendo correo electronico");
		correoActual = WebRedebanPageObjects.obtenerCorreoElectronico();
		System.out.println("El correo actual es: " + correoActual);
		return correoActual;
	}

	public String obtenerCorreo(String numCelular) {
		WebRedebanPageObjects.clicBtnMonederos();
		WebRedebanPageObjects.clicBtnAppDaviplata();
		WebRedebanPageObjects.clicBtnActualizarCorreoElectronico();
		WebRedebanPageObjects.ingresarNumeroCelular(numCelular);
		WebRedebanPageObjects.clicBtnEnviar();
		correoActual = WebRedebanPageObjects.obtenerCorreoElectronico();
		System.out.println("El correo actual es: " + correoActual);
		return correoActual;
	}

	public void consultaMovimientoDiarioTarjeta(String numeroTarjeta) {
		WebRedebanPageObjects.clicBtnMovimientoDiario();
		WebRedebanPageObjects.sendKeysInputTarjeta(numeroTarjeta);
		Date date = new Date();
		WebRedebanPageObjects.sendKeysInputFecha(Utilidades.formatDateInforme("yyyyMMdd", date));
		WebRedebanPageObjects.clicBtnAceptar();
	}

	public void logOut(String xpath) {
		try {
			Utilidades.esperaMiliseg(2000);
			WebRedebanPageObjects.clicBtnSalir(xpath);
			System.out.println("Salí de Redeban Page Objects");
			WebRedebanPageObjects.cerrarWebRedeban();
			System.out.println("Cerré Redeban Correctamente");
		} catch (Exception e) {
			System.out.println("No pude cerrar sesión en redeban, debido a: " + e.getMessage());
		}
	}

	public ConsultaClientes buscarPorDocumento(ConsultaClientes consultaClientes, String cliente) {
		try {
			WebRedebanPageObjects.clicBtnConsultaClientes();
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(cliente);
			String auxiliar;
			int contador = 0;
			do {
				auxiliar = "";
				WebRedebanPageObjects.clicBtnEnviar();
				auxiliar = WebRedebanPageObjects.returnLblBin();
				consultaClientes.setBin(auxiliar);
				contador++;
				System.out.println("contador consultaClientesWebRedeban vale: " + contador);
			} while (auxiliar.equals("") && contador <= 3);
			System.out.println("Finalicé con éxito buscarPorDocumento");
		} catch (Exception objException) {
			System.out.println("Fallé buscarPorDocumento");
			objException.printStackTrace();
		}
		return consultaClientes;
	}

	public void pulsarDatosGeneralesTarjeta() {
		try {
			WebRedebanPageObjects.clicRadioBtnDetallesConsultaCliente();
			WebRedebanPageObjects.clicBtnDatosGeneralesTarjeta();
			System.out.println("Finalicé con éxito pulsarDatosGeneralesTarjeta");
		} catch (Exception e) {
			System.out.println("Fallé en pulsarDatosGeneralesTarjeta");
			e.printStackTrace();
		}
	}

	public ConsultaClientes obtenerDatosGeneralesTarjeta(ConsultaClientes consultaClientes, String cliente) {
		try {
			consultaClientes.setTipoIdentificacion(WebRedebanPageObjects.returnLblTipoIdentificacion());
			consultaClientes.setNumeroTarjeta(WebRedebanPageObjects.returnLblTarjeta());
			consultaClientes.setEstado(WebRedebanPageObjects.returnLblEstadoActual());
			consultaClientes.setSubTipo(WebRedebanPageObjects.returnLblSubTipo());
			consultaClientes.setTipoTarjeta(WebRedebanPageObjects.returnLblTipoTarjeta());
			consultaClientes.setExcenta4xmil(WebRedebanPageObjects.returnLblExcenta4XMil());
			consultaClientes.setNumeroTarjeta(WebRedebanPageObjects.returnLblTarjeta());
			Utilidades.tomaEvidenciaPantallaWeb("Consulta Cliente web RBM " + cliente);
			System.out.println("Finalicé con éxito obtenerDatosGeneralesTarjeta");
		} catch (Exception objExcepcion) {
			System.out.println("Fallé en obtenerDatosGeneralesTarjeta");
			objExcepcion.printStackTrace();
		}
		return consultaClientes;
	}

	public void buscarPorTarjeta(String tarjeta) {
		WebRedebanPageObjects.clicBtnConsultaCuposTarjeta();
		String auxiliar;
		int contador = 0;
		do {
			auxiliar = "";
			WebRedebanPageObjects.clicChkTarjetaID();
			WebRedebanPageObjects.sendKeysInputTarjetaID(tarjeta);
			Utilidades.esperaMiliseg(500);
			WebRedebanPageObjects.clicBtnEnviar();
			auxiliar = WebRedebanPageObjects.clicRadioBtnConsulta3();
			contador++;
			System.out.println("contador buscarPorTarjeta vale: " + contador);
		} while (auxiliar.equals("") && contador <= 3);
		Utilidades.esperaMiliseg(4000);
		WebRedebanPageObjects.clicBtnConsultaDatos();
		System.out.println("Finalicé con éxito buscarPorTarjeta");
	}

	public ConsultaCupoTarjeta obtenerMovimientosRealizados(ConsultaCupoTarjeta cupoTarjeta, String tarjeta) {
		WebRedebanPageObjects.clicBtnMovimientoRealizado(2);
		cupoTarjeta.setTotalAcumulado(WebRedebanPageObjects.returnLblTotalAcumuladoDiario());
		cupoTarjeta.setAcumuladoMensualCredito(WebRedebanPageObjects.returnLblAcumuladoMensualCredito());
		cupoTarjeta.setAcumuladoMensualDebito(WebRedebanPageObjects.returnLblAcumuladoMensualDebito());
		BaseUtil.topeCreditos = cupoTarjeta.getAcumuladoMensualCredito().replace(".", "").replace(",", ".").replace(".00",
				"");
		BaseUtil.topeDebitos = cupoTarjeta.getAcumuladoMensualDebito().replace(".", "").replace(",", ".").replace(".00",
				"");
		cupoTarjeta.setUtilizacionesAcumuladas(WebRedebanPageObjects.returnLblUtilizacionesAcumuladas());
		Utilidades.tomaEvidenciaPantallaWeb("Consulta Cupo Por tarjeta acumulaciones web RBM " + tarjeta);
		System.out.println("Finalicé con éxito obtenerMovimientosRealizados");
		return cupoTarjeta;
	}

	public ConsultaCupoTarjeta obtenerSaldosTarjeta(ConsultaCupoTarjeta cupoTarjeta, String tarjeta) {
		int contador;
		String auxiliar;
		do {
			contador = 0;
			auxiliar = "";
			Utilidades.esperaMiliseg(3000);
			System.out.println("dando click a btn limites");
			WebRedebanPageObjects.clicBtnDetallesLimitesDisponibles(3);
			System.out.println("esperando visibilidad de saldos");
			esperarVisibilidadSaldos();
			auxiliar = WebRedebanPageObjects.returnLblIndicador4x1000();
			contador++;
			System.out.println("contador consultaCuposTarjeta vale: " + contador);
		} while (auxiliar.equals("") && contador <= 3);
		cupoTarjeta.setRealDisponible(WebRedebanPageObjects.returnLblRealDisponible());
		Utilidades.tomaEvidenciaPantallaWeb("Consulta Cupo Por tarjeta detalles web RBM " + tarjeta);
		System.out.println("Finalicé con éxito obtenerSaldosTarjeta");
		return cupoTarjeta;
	}

	public String consultasubtipo(String numeroID, String subtipo, String celular) {
		String valorSubtipo = null;
		try {
			WebRedebanPageObjects.clicBtnConsultaClientes();
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso cliente de Cívica");
			WebRedebanPageObjects.clicBtnEnviar();
			WebRedebanPageObjects.clicRadioBtnPorNumeroCelular(celular);
			WebRedebanPageObjects.clicBtnVistaGeneral();
			String[] subtibo = WebRedebanPageObjects.returnLblSubTipo().split(" ");
			valorSubtipo = subtibo[0];
			assertThat(valorSubtipo, equalTo(subtipo));
			System.out.println("El Sub Tipo del cliente es : " + valorSubtipo + " y el subtipo esperado es " + subtipo);
			Utilidades.tomaEvidenciaPantallaWeb("web-Guardo información cliente");
		} catch (AssertionError e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("Error de aserción: " + e.getMessage());

		} catch (Exception e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("ERROR: " + e.getMessage());
		}
		return valorSubtipo;
	}
	
	public String consultasubtipoDestino(String numeroID, String subtipo, String celular) {
		String valorSubtipo = null;
		try {
			WebRedebanPageObjects.clicBtnConsultaClientes();
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			Utilidades.tomaEvidenciaPantallaWeb("Web - Ingreso usuario destino");
			Utilidades.esperaMiliseg(3000);
			WebRedebanPageObjects.clicBtnEnviar();
			WebRedebanPageObjects.clicRadioBtnPorNumeroCelular(celular);
			WebRedebanPageObjects.clicBtnVistaGeneral();
			String[] subtibo = WebRedebanPageObjects.returnLblSubTipo().split(" ");
			valorSubtipo = subtibo[0];
			assertThat(valorSubtipo, equalTo(subtipo));
			System.out.println("El Subtipo del cliente destino es : " + valorSubtipo + " y el subtipo destino esperado es " + subtipo);
			Utilidades.tomaEvidenciaPantallaWeb("Web - Guardo información cliente destino.");
		} catch (AssertionError e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("Error de aserción: " + e.getMessage());

		} catch (Exception e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("ERROR: " + e.getMessage());
		}
		return valorSubtipo;
	}
	
	public String consultarSubtipos(String numeroID, String subtipo) {
		String valorSubtipo = null;
		try {
			WebRedebanPageObjects.clicBtnConsultaClientes();
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso cliente de Cívica");
			WebRedebanPageObjects.clicBtnEnviar();
			WebRedebanPageObjects.clicRadioBtnPorNumeroCelular(BaseUtil.numeroCelular);
			WebRedebanPageObjects.clicBtnVistaGeneral();
			String[] subtibo = WebRedebanPageObjects.returnLblSubTipo().split(" ");
			valorSubtipo = subtibo[0];
			BaseUtil.subTipo = valorSubtipo;
			assertThat(valorSubtipo, equalTo(subtipo));
			System.out.println("El Sub Tipo del cliente es : " + valorSubtipo + " y el subtipo esperado es " + subtipo);
			Utilidades.tomaEvidenciaPantallaWeb("web-Guardo información cliente");
		} catch (AssertionError e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("Error de aserción: " + e.getMessage());

		} catch (Exception e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("ERROR: " + e.getMessage());
		}
		return valorSubtipo;
	}

	// ---- GETTER ´N SETTERS----//
	public String returnNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void consultaSaldosUsuario2(String cliente) {
		String numeroCelular = null;
		WebRedebanPageObjects.clicBtnConsultaClientes();
		WebRedebanPageObjects.clicChkNumeroID();
		WebRedebanPageObjects.sendKeysInputNumeroID(cliente);
		Utilidades.esperaMiliseg(2000);
		WebRedebanPageObjects.clicBtnEnviar();
		Utilidades.tomaEvidencia("Consulta número tarjeta web Redeban");
		int row = WebRedebanPageObjects.returnTdEstado();
		System.out.println("row: " + row);
		String numeroBin = WebRedebanPageObjects.returnNumeroBin(row);
		System.out.println("num: " + numeroBin);
		if (numeroBin.length() != 0) {
			numeroTarjeta = WebRedebanPageObjects.returnNumeroTarjeta(row);
			System.out.println("Numero Tarjeta: " + numeroTarjeta);
			numeroCelular = numeroTarjeta.split(numeroBin)[1];
		} else {
			logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		}
		System.out.println("numero Celular: " + numeroCelular);
		Serenity.setSessionVariable("numeroCelularUsuario2").to(numeroCelular);

	}

	public ConsultaCupoTarjeta obtenerSaldoDaviplata(ConsultaCupoTarjeta cupoTarjeta, String tarjeta) {
		WebRedebanPageObjects.clicBtnDetallesLimitesDisponibles(3);
		cupoTarjeta.setRealDisponible(WebRedebanPageObjects.returnLblRealDisponible());
		Utilidades.tomaEvidenciaPantallaWeb("Consulta saldo del daviplata" + tarjeta);
		System.out.println("Finalicé con éxito obtenerSaldosTarjeta");
		return cupoTarjeta;
	}

	public ConsultaCupoTarjeta consultaSaldoRealDaviplata(String tarjeta) {
		System.out.println("consulta saldo real daviplata");
		ConsultaCupoTarjeta cupoTarjeta = new ConsultaCupoTarjeta();
		try {
			System.out.println("buscando tarjeta");
			buscarPorTarjeta(tarjeta);
			System.out.println("ya busque tarjeta");
			System.out.println("obteniendo saldo daviplata");
			Utilidades.esperaMiliseg(2000);
			cupoTarjeta = obtenerSaldoDaviplata(cupoTarjeta, tarjeta);
			System.out.println("Cupo Tarjeta: " + cupoTarjeta.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		return cupoTarjeta;
	}

	public ConsultaCupoTarjeta obtenerSaldoDaviplataGmf(ConsultaCupoTarjeta cupoTarjeta, String tarjeta) {
		WebRedebanPageObjects.clicBtnDetallesLimitesDisponibles(3);
		cupoTarjeta.setSaldoDisponible4x1000(WebRedebanPageObjects.returnLblSaldoDisponible4x1000());
		cupoTarjeta.setAcumulado4x1000(WebRedebanPageObjects.returnLblAcumulado4x1000());
		Utilidades.tomaEvidenciaPantallaWeb("Consulta saldo GMF del daviplata" + tarjeta);
		System.out.println("Finalicé con éxito obtenerSaldosGmfTarjeta");
		return cupoTarjeta;
	}

	public ConsultaCupoTarjeta consultaSaldoGmfDaviplata(String tarjeta) {
		ConsultaCupoTarjeta cupoTarjeta = new ConsultaCupoTarjeta();
		try {
			buscarPorTarjeta(tarjeta);
			Utilidades.esperaMiliseg(3000);
			cupoTarjeta = obtenerSaldoDaviplataGmf(cupoTarjeta, tarjeta);
			System.out.println("Cupo Tarjeta: " + cupoTarjeta.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		return cupoTarjeta;
	}

	public String consultaDiaria3(String numeroID, String autorizador) {
		String valor = null;
		try {
			WebRedebanPageObjects.clicBtnDebitoPrepago();
			WebRedebanPageObjects.clicBtnConsultaClientes();
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			Utilidades.esperaMiliseg(2000);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso cliente de Cívica");
			WebRedebanPageObjects.clicBtnEnviar();
			WebRedebanPageObjects.clicBtnMovimientoDiario();
			String tarjeta = Serenity.sessionVariableCalled("numeroTarjeta");
			WebRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso número tarjeta");
			Date date = new Date();
			
			String dateCurrent = Utilidades.formatDateInforme("yyyyMMdd", date);
			System.out.println(dateCurrent);
			WebRedebanPageObjects.sendKeysInputFecha(dateCurrent);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso fecha de hoy " + dateCurrent);
			Utilidades.esperaMiliseg(2000);
			WebRedebanPageObjects.clicBtnAceptar();
			Utilidades.esperaMiliseg(3000);
			System.out.println("entró al try del date");	

			String registros = WebRedebanPageObjects.validarValorRegistros();
			System.out.println("El numero de registros es: " + registros);
			WebRedebanPageObjects.irHastaUltimaPaginaRegistros(registros);
			valor = WebRedebanPageObjects.returnValorTrans();
			WebRedebanPageObjects.clicCheckboxRedeban();
			Utilidades.tomaEvidenciaPantallaWeb("web-El valor encontrado es por " + valor);
            WebRedebanPageObjects.clicBotonVerDetalle();
            
            
			System.out.println("Valor " + valor);
		}catch(TimeoutException  e) {
            logOut("//img[contains(@src, 'logout.gif')]");
            fail("Tiempo de espera excedido: " + e.getMessage());
        }catch(WebDriverException e) {
            logOut("//img[contains(@src, 'logout.gif')]");
            fail("Error en WebDriver: " + e.getMessage());
        }catch(Exception e) {
            logOut("//img[contains(@src, 'logout.gif')]");
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
		return valor;
	}
	
	public String consultaDiariaTipoTransaccion(String numeroID, String autorizador) {
		String valor = null;
		try {
			WebRedebanPageObjects.clicBtnDebitoPrepago();
			WebRedebanPageObjects.clicBtnConsultaClientes();
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			Utilidades.esperaMiliseg(2000);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso cliente de Cívica");
			WebRedebanPageObjects.clicBtnEnviar();
			WebRedebanPageObjects.clicBtnMovimientoDiario();
			String tarjeta = Serenity.sessionVariableCalled("numeroTarjeta");
			WebRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso número tarjeta");
			Date date = new Date();
			
			String dateCurrent = Utilidades.formatDateInforme("yyyyMMdd", date);
			System.out.println(dateCurrent);
			WebRedebanPageObjects.sendKeysInputFecha(dateCurrent);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso fecha de hoy " + dateCurrent);
			Utilidades.esperaMiliseg(2000);
			WebRedebanPageObjects.clicBtnAceptar();
			Utilidades.esperaMiliseg(3000);
			System.out.println("entró al try del date");	

			String registros = WebRedebanPageObjects.validarValorRegistros();
			System.out.println("El numero de registros es: " + registros);
			WebRedebanPageObjects.irHastaUltimaPaginaRegistros(registros);
			valor = WebRedebanPageObjects.nuevaValidacionTT();

			System.out.println("Valor " + valor);
		}catch(TimeoutException  e) {
            logOut("//img[contains(@src, 'logout.gif')]");
            fail("Tiempo de espera excedido: " + e.getMessage());
        }catch(WebDriverException e) {
            logOut("//img[contains(@src, 'logout.gif')]");
            fail("Error en WebDriver: " + e.getMessage());
        }catch(Exception e) {
            logOut("//img[contains(@src, 'logout.gif')]");
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
		return valor;
	}
	
	public String consultaDiariaRecargaCiviPay(String numeroID, String autorizador) {
		String valor = null;
		try {
			WebRedebanPageObjects.clicBtnDebitoPrepago();
			WebRedebanPageObjects.clicBtnConsultaClientes();
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			Utilidades.esperaMiliseg(2000);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso cliente de Cívica");
			WebRedebanPageObjects.clicBtnEnviar();
			WebRedebanPageObjects.clicBtnMovimientoDiario();
			String tarjeta = Serenity.sessionVariableCalled("numeroTarjeta");
			WebRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso número tarjeta");
			Date date = new Date();
			
			String dateCurrent = Utilidades.formatDateInforme("yyyyMMdd", date);
			System.out.println(dateCurrent);
			WebRedebanPageObjects.sendKeysInputFecha(dateCurrent);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso fecha de hoy " + dateCurrent);
			Utilidades.esperaMiliseg(2000);
			WebRedebanPageObjects.clicBtnAceptar();
			Utilidades.esperaMiliseg(3000);
			System.out.println("entró al try del date");	

			String registros = WebRedebanPageObjects.validarValorRegistros();
			System.out.println("El numero de registros es: " + registros);
			WebRedebanPageObjects.irHastaUltimaPaginaRegistros(registros);
			valor = WebRedebanPageObjects.nuevaValidacionRecargaCiviPay();

			System.out.println("Valor " + valor);
		}catch(TimeoutException  e) {
            logOut("//img[contains(@src, 'logout.gif')]");
            fail("Tiempo de espera excedido: " + e.getMessage());
        }catch(WebDriverException e) {
            logOut("//img[contains(@src, 'logout.gif')]");
            fail("Error en WebDriver: " + e.getMessage());
        }catch(Exception e) {
            logOut("//img[contains(@src, 'logout.gif')]");
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
		return valor;
	}
	
    public void userDetails() {
		try {
	        Utilidades.esperaMiliseg(1000);
	        WebRedebanPageObjects.clicBtnDetalleCuposLimites();
	        Utilidades.esperaMiliseg(500);
	        Utilidades.tomaEvidenciaPantallaWeb("web-Valido: Detalle de cupos límites");
	    	System.out.println("Valido Detalle de cupos y límites");
	        WebRedebanPageObjects.clicBtnDatosDeCierre();
	        Utilidades.esperaMiliseg(500);
	        Utilidades.tomaEvidenciaPantallaWeb("web-Valido: Datos de cierre");
	    	System.out.println("Valido Datos de cierre");
	    	WebRedebanPageObjects.clicBtnValoresDeTransaccion();
	        Utilidades.esperaMiliseg(500);
	        Utilidades.tomaEvidenciaPantallaWeb("web-Valido: Valores de transacción");
	    	System.out.println("Valido Valores de transacción");
        }catch(Exception e) {
            logOut("//img[contains(@src, 'logout.gif')]");
            fail("Se produjo un error no esperado: " + e.getMessage());
		}
    }
	
	public String consultaNumeroCelularDestino(String clienteDestino) {
		String numeroCelularDestino = null;
		// webRedebanPageObjects.clicBtnDebitoPrepago();
		WebRedebanPageObjects.clicBtnConsultaClientes();
		WebRedebanPageObjects.clicChkNumeroID();
		WebRedebanPageObjects.sendKeysInputNumeroID(clienteDestino);
		Utilidades.esperaMiliseg(1500);
		WebRedebanPageObjects.clicBtnEnviar();
		Utilidades.esperaMiliseg(1500);
		Utilidades.tomaEvidenciaPantallaWeb("Consulta número tarjeta destino Web Redeban");
		int row = WebRedebanPageObjects.returnTdEstado();
		System.out.println("row destino: " + row);
		String numeroBinDestino = WebRedebanPageObjects.returnNumeroBin(row);
		System.out.println("num destino: " + numeroBinDestino);
		if (numeroBinDestino.length() != 0) {
			numeroTarjetaDestino = WebRedebanPageObjects.returnNumeroTarjeta(row);
			Serenity.setSessionVariable("numeroTarjetaDestino").to(numeroTarjetaDestino);
			System.out.println("Numero Tarjeta Destino: " + numeroTarjetaDestino);
			numeroCelularDestino = numeroTarjetaDestino.split(numeroBinDestino)[1];
		} else {
			logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		}
		System.out.println("Número Celular Destino: " + numeroCelularDestino);
		Serenity.setSessionVariable("numeroCelularRedebanDestino").to(numeroCelularDestino);
		return numeroCelularDestino;

	}

	public String returnNumeroTarjetaDestino() {
		return numeroTarjetaDestino;
	}

	public ConsultaCupoTarjetaDestino obtenerSaldosTarjetaDestino(ConsultaCupoTarjetaDestino cupoTarjetaDestino,
			String tarjetaDestino) {
		int contador;
		String auxiliar;
		Utilidades.esperaMiliseg(5000);
		do {
			contador = 0;
			auxiliar = "";
			WebRedebanPageObjects.clicBtnDetallesLimitesDisponibles(3);
			auxiliar = WebRedebanPageObjects.returnLblIndicador4x1000();
			contador++;
			System.out.println("contador consultaCuposTarjeta vale: " + contador);
		} while (auxiliar.equals("") && contador <= 3);
		cupoTarjetaDestino.setEstadoCuentaDestino(WebRedebanPageObjects.returnLblEstadoCuenta());
		cupoTarjetaDestino.setIndicador4x1000Destino(WebRedebanPageObjects.returnLblIndicador4x1000());
		cupoTarjetaDestino.setEstadoDestino(WebRedebanPageObjects.returnLblEstado());
		cupoTarjetaDestino.setTipoDestino(WebRedebanPageObjects.returnLblTipo());
		cupoTarjetaDestino.setExenta4x1000Destino(WebRedebanPageObjects.returnLblExenta4x1000());
		cupoTarjetaDestino.setTotalSaldosDestino(WebRedebanPageObjects.returnLblTotalSaldos());
		cupoTarjetaDestino.setDisponibleSaldosDestino(WebRedebanPageObjects.returnLblDisponibleSaldos());
		cupoTarjetaDestino.setTotalDisponibleDestino(WebRedebanPageObjects.returnLblTotalDisponible());
		cupoTarjetaDestino.setRealDisponibleDestino(WebRedebanPageObjects.returnLblRealDisponible());
		cupoTarjetaDestino.setSaldoDisponible4x1000Destino(WebRedebanPageObjects.returnLblSaldoDisponible4x1000());
		cupoTarjetaDestino.setSaldoBolsillosDestino(WebRedebanPageObjects.returnLblSaldoBolsillo());
		cupoTarjetaDestino.setAcumulado4x1000Destino(WebRedebanPageObjects.returnLblAcumulado4x1000());
		Utilidades.tomaEvidenciaPantallaWeb("Consulta Cupo Por tarjeta detalles web RBM " + tarjetaDestino);
		System.out.println("Finalicé con éxito obtenerSaldosTarjeta");
		return cupoTarjetaDestino;
	}

	public ConsultaCupoTarjetaDestino obtenerMovimientosRealizadosDestino(ConsultaCupoTarjetaDestino cupoTarjetaDestino,
			String tarjetaDestino) {
		WebRedebanPageObjects.clicBtnMovimientoRealizado(2);
		cupoTarjetaDestino.setTotalAcumuladoDestino(WebRedebanPageObjects.returnLblTotalAcumuladoDiario());
		cupoTarjetaDestino.setAcumuladoMensualCreditoDestino(WebRedebanPageObjects.returnLblAcumuladoMensualCredito());
		cupoTarjetaDestino.setAcumuladoMensualDebitoDestino(WebRedebanPageObjects.returnLblAcumuladoMensualDebito());
		cupoTarjetaDestino.setUtilizacionesAcumuladasDestino(WebRedebanPageObjects.returnLblUtilizacionesAcumuladas());
		BaseUtil.topeCreditos = WebRedebanPageObjects.returnLblAcumuladoMensualCredito().replace(".", "").replace(",", ".")
				.replace(".00", "");
		BaseUtil.topeDebitos = WebRedebanPageObjects.returnLblAcumuladoMensualCredito().replace(".", "").replace(",", ".")
				.replace(".00", "");

		System.out.println("tope debitos: " + BaseUtil.topeDebitos);
		Utilidades.tomaEvidenciaPantallaWeb("Creditos mensuales de la tarjeta " + tarjetaDestino + "con tope "
				+ cupoTarjetaDestino.getAcumuladoMensualDebitoDestino());
		System.out.println("Finalicé con éxito obtenerMovimientosRealizados");
		return cupoTarjetaDestino;
	}

	public void validarTopeCredito(String topecredito) {
		WebRedebanPageObjects.validarTopesCreditos(topecredito);

	}

	public void validarTopeDebitos(String topeDebitos) {
		WebRedebanPageObjects.validarTopesDebito(topeDebitos);

	}

	public void validarTopeDebitosDestino(String topeDebitos) {
		WebRedebanPageObjects.validarTopesDebitoDestino(topeDebitos);

	}

	public String consultaNumeroCelularConSesionAbierta(String cliente) {
		String numeroCelular = null;
		// loginWebRedeban();
		WebRedebanPageObjects.clicBtnDebitoPrepago();
		WebRedebanPageObjects.clicBtnConsultaClientes();
		WebRedebanPageObjects.clicChkNumeroID();
		WebRedebanPageObjects.sendKeysInputNumeroID(cliente);
		Utilidades.esperaMiliseg(1500);
		WebRedebanPageObjects.clicBtnEnviar();
		Utilidades.esperaMiliseg(1500);
		Utilidades.tomaEvidenciaPantallaWeb("Consulta número tarjeta web Redeban");
		int row = WebRedebanPageObjects.returnTdEstado();
		System.out.println("row: " + row);
		String numeroBin = WebRedebanPageObjects.returnNumeroBin(row);
		System.out.println("num: " + numeroBin);
		if (numeroBin.length() != 0) {
			numeroTarjeta = WebRedebanPageObjects.returnNumeroTarjeta(row);
			Serenity.setSessionVariable("numeroTarjeta").to(numeroTarjeta);
			System.out.println("Numero Tarjeta: " + numeroTarjeta);
			numeroCelular = numeroTarjeta.split(numeroBin)[1];
		} else {
			logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		}
		System.out.println("numero Celular: " + numeroCelular);
		Serenity.setSessionVariable("numeroCelularRedeban").to(numeroCelular);
		return numeroCelular;

	}

	public void ingresoNumeroClienteRedebanSesionAbierta(String cliente) {
		String numeroCelular = null;
		// loginWebRedeban();
		WebRedebanPageObjects.clicBtnDebitoPrepago();
		WebRedebanPageObjects.clicBtnConsultaClientes();
		WebRedebanPageObjects.clicChkNumeroID();
		WebRedebanPageObjects.sendKeysInputNumeroID(cliente);
		Utilidades.esperaMiliseg(1500);
		WebRedebanPageObjects.clicBtnEnviar();
		Utilidades.esperaMiliseg(1500);
		Utilidades.tomaEvidenciaPantallaWeb("Consulta número tarjeta web Redeban");
		int row = WebRedebanPageObjects.returnTdEstado();
		System.out.println("row: " + row);
		String numeroBin = WebRedebanPageObjects.returnNumeroBin(row);
		System.out.println("num: " + numeroBin);
		if (numeroBin.length() != 0) {
			numeroTarjeta = WebRedebanPageObjects.returnNumeroTarjeta(row);
			System.out.println("Numero Tarjeta: " + numeroTarjeta);
			numeroCelular = numeroTarjeta.split(numeroBin)[1];
		} else {
			logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		}
		System.out.println("numero Celular: " + numeroCelular);
	}

	public String consultasubtipoTopes(String numeroID, String subtipo) {
		String valorSubtipo = null;
		try {
			WebRedebanPageObjects.clicBtnConsultaClientes();
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso cliente de Cívica");
			WebRedebanPageObjects.clicBtnEnviar();
			WebRedebanPageObjects.clicRadioBtnPorNumeroCelular(numeroTarjeta);
			WebRedebanPageObjects.clicBtnVistaGeneral();
			String[] subtibo = WebRedebanPageObjects.returnLblSubTipo().split(" ");
			valorSubtipo = subtibo[0];
			try {
				assertThat(valorSubtipo, equalTo(subtipo));
			} catch (AssertionError e) {
				logOut("//*[@id='AS_RespSpander']/table/tbody/tr/td/table/tbody/tr[2]/td/img");
				fail("No se pudo consultar el subtipo del usuario debido a " + e.getMessage());
			}

			Utilidades.tomaEvidenciaPantallaWeb(
					"El Sub Tipo del cliente es " + valorSubtipo + " y el subtipo esperado es " + subtipo);

		} catch (Exception e) {
			System.out.println("No se pudo consultar el subtipo del usuario debido a " + e.getMessage());
		}
		return valorSubtipo;
	}

	public void esperarVisibilidadSaldos() {
		WebRedebanPageObjects.esperarVisibilidadNumeroTarjeta();
	}

	public String consultaDiariaSwitch(String numeroID, String autorizador) {
		String valor = null;
		try {
			WebRedebanPageObjects.clicBtnDebitoPrepago();
			WebRedebanPageObjects.clicBtnConsultaClientes();
			WebRedebanPageObjects.clicChkNumeroID();
			WebRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso cliente de Cívica");
			WebRedebanPageObjects.clicBtnEnviar();
			WebRedebanPageObjects.clicBtnMovimientoDiario();
			String tarjeta = Serenity.sessionVariableCalled("numeroTarjeta");
			WebRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso número tarjeta");
			Date date = new Date();
			try {
				String dateCurrent = Utilidades.formatDateInforme("yyyyMMdd", date);
				System.out.println(dateCurrent);
				WebRedebanPageObjects.sendKeysInputFecha(dateCurrent);
				Utilidades.tomaEvidenciaPantallaWeb("web-Ingreso fecha de hoy " + dateCurrent);
				Utilidades.esperaMiliseg(2000);
				WebRedebanPageObjects.clicBtnAceptar();
				Utilidades.esperaMiliseg(3000);
				System.out.println("entró al try del date");
			} catch (Exception e) {
				WebRedebanPageObjects.clicBtnSalir();
				consultaDiaria(numeroID, autorizador);
				System.out.println("Entró al catch");
			}

			String registros = WebRedebanPageObjects.validarValorRegistros();
			System.out.println("El numero de registros es: " + registros);
			WebRedebanPageObjects.irHastaUltimaPaginaRegistros(registros);
			valor = WebRedebanPageObjects.returnValorTrans();
			Utilidades.tomaEvidenciaPantallaWeb("web-Busco por codigo de autorizacion " + autorizador);
			System.out.println("Valor " + valor);
			Utilidades.tomaEvidenciaPantallaWeb("web-El valor encontrado es por " + valor);
			WebRedebanPageObjects.clicCheckboxRedeban();
			WebRedebanPageObjects.clicBotonVerDetalle();
			String switchText = WebRedebanPageObjects.validarSwitch();
			Utilidades.tomaEvidenciaPantallaWeb("web-El switch encontrado es  " + switchText);

		} catch (Exception e) {
			fail("No encontró valor de transacción, debido a " + e.getMessage());
		}
		return valor;
	}

}
