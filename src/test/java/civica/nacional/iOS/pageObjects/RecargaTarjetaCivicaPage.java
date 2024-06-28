package civica.nacional.iOS.pageObjects;

public class RecargaTarjetaCivicaPage {
	
	public static final String MODULE_TU_TARJETA_CIVICA = "(//XCUIElementTypeButton[@name='MyFare'])[1]";
	public static final String BTN_SALDO_VISIBLE = "//XCUIElementTypeButton[@name='Saldos']";
	public static final String RECHARGE_CIVICA_BTN = "//XCUIElementTypeStaticText[@name='Recargar Tarjeta Cívica']/preceding-sibling::XCUIElementTypeButton";
	public static final String DATOS_VISIBLE = "//XCUIElementTypeStaticText[@name='Datos de la tarjeta']";
	public static final String DESPLEGABLE_TIPO_DOC = "//XCUIElementTypeTextField[@name='Tipo de documento']";
	public static final String CC_BTN = "//XCUIElementTypeStaticText[@name='Cédula de ciudadania']";
	public static final String AL_PORTADOR_BTN = "//XCUIElementTypeStaticText[@name='Al portador (número de tarjeta cívica)']";
	public static final String CE_BTN = "//XCUIElementTypeStaticText[@name='Cédula de extranjera']";
	public static final String NUM_UNICO_BTN = "//XCUIElementTypeStaticText[@name='Número único de identificación personal']";
	public static final String PASAPORTE_BTN = "//XCUIElementTypeStaticText[@name='Pasaporte']";
	public static final String PERMISO_ESPECIAL_BTN = "//XCUIElementTypeStaticText[@name='Permiso especial de permanencia']";
	public static final String PERMISO_PROTECCION_BTN = "//XCUIElementTypeStaticText[@name='Permiso por protección temporal']";
	public static final String TI_BTN = "//XCUIElementTypeStaticText[@name='Tarjeta de identidad']";
	public static final String DOCUMENT_NUMBER_FIELD = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]";
	public static final String BTN_CONTINUAR = "//XCUIElementTypeButton[@name='Continuar']";
	public static final String FIELD_FAV = "//XCUIElementTypeStaticText[@name='Favoritos']";
	public static final String VERIFICATED_DATA_VISIBLE = "//XCUIElementTypeStaticText[@name='Verifica los datos de la recarga.']";
	public static final String MONTO_FIELD = "//XCUIElementTypeTextField[@name='Ingresa otro valor']";
	public static final String METHOD_PAYMENT = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeButton";
	public static final String CONTINUE_BTN = "//XCUIElementTypeButton[@name='Continuar']";
	public static final String PASS_VISIBLE = "//XCUIElementTypeStaticText[@name='Ingresa tu clave para confirmar.']";
	public static final String PASS_FIELD = "//XCUIElementTypeSecureTextField[@name='Ingresa tu clave']";
	public static final String RECHARGED_CARD = "(//XCUIElementTypeButton[@name='Recargar Tarjeta Cívica'])[2]";
	public static final String SUCCESSFUL_RECHARGED = "//XCUIElementTypeStaticText[@name='Recarga realizada']";
	public static final String END_BTN = "//XCUIElementTypeButton[@name='Finalizar']";
	public static final String SKIP_BTN = "//XCUIElementTypeButton[@name='Omitir']";
	public static final String BACK_BTN = "//XCUIElementTypeButton[@name='Back']";
	public static final String CONDICION_PARA_IF_VISIBLE = "//XCUIElementTypeStaticText[@name='Solicita tu tarjeta Civica']";
	public static final String CONDICION_HORA_SERVICIO = "//XCUIElementTypeStaticText[contains(@name, 'No podemos recargar tu Tarjeta Cívica')]";
	public static final String CONDICION_SALDO = "//XCUIElementTypeCell/XCUIElementTypeOther";
	public static final String NUM_AUTORIZACION = "//XCUIElementTypeTextField[contains(@name,'Número de autorización')]";
	public static final String BAD_PASS_IMPUT = "//XCUIElementTypeStaticText[contains(@name, 'La clave no es correcta')]";
	public static final String DATOS_TARJETA = "//XCUIElementTypeStaticText[@name='Datos de la tarjeta']";
	public static final String CUANTO_QUIERES_RECARGAR = "//XCUIElementTypeStaticText[@name='¿Cuánto quieres recargar?']";
	public static final String METODO_PAGO = "//XCUIElementTypeStaticText[@name='Método de pago']";
	public static final String SALDO_CLIENTE = "//XCUIElementTypeStaticText[contains(@name, 'Saldo:$')]";
	public static final String VALORES = "//XCUIElementTypeCollectionView";
	public static final String TXT_ICON_FAV = "//XCUIElementTypeStaticText[@name='Guarda tu favorito']";
	public static final String FIELD_NAME_ICON_FAV = "//XCUIElementTypeTextField[@name='Nombre, Máximo 15 caracteres.']";
	public static final String BTN_SAVE_FAV = "//XCUIElementTypeButton[@name='Guardar']";
	public static final String FAVS_INTO_RECHARGE_CARD = "//XCUIElementTypeStaticText[@name='Tus favoritos']";
	public static final String EDIT_INTO_RECHARGE_CARD = "(//XCUIElementTypeButton[@name='ic editar'])[1]";
	public static final String FAV_NUMBER_ONE = "(//XCUIElementTypeOther)[39]";
	public static final String BTN_BACK_TO_RECARGAR_TARJETA_CIV = "(//XCUIElementTypeButton)[2]";
	
	
}
