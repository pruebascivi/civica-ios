package civica.nacional.iOS.pageObjects;

public class RecargarCelularCivicaPage {

	public static final String INITIAL_BALANCE_TXT = "//XCUIElementTypeStaticText[contains(@name,'$')]";
	public static final String RECARGAR_CEL_BTN = "//XCUIElementTypeButton[@name=\"RecargarCelular\"]";
	public static final String VALIDATE_VISIBLE_TXT = "//XCUIElementTypeStaticText[@name=\"Selecciona el operador de tu celular.\"]";
	public static final String OPERATOR_SELECTION_TIGO_BTN = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther";
	public static final String OPERATOR_SELECTION_MOVISTAR_BTN = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]";
	public static final String OPERATOR_SELECTION_CLARO_BTN = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[3]";
	public static final String OPERATOR_SELECTION_VIRGIN_BTN = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[4]";
	public static final String OPERATOR_SELECTION_AVANTEL_BTN = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[5]";
	public static final String OPERATOR_SELECTION_ETB_BTN = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[6]";
	public static final String OPERATOR_SELECTION_CELLVOZ_BTN = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[7]";
	public static final String OPERATOR_SELECTION_FLASH_BTN = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[8]";
	public static final String OPERATOR_SELECTION_WOM_BTN = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[9]";
	public static final String ENTER_CELLPHONE_NUM_FIELD = "//*[@name='Número celular']";
	public static final String FIELD_VIEW = "//*[@name='¿Cuánto quieres recargar?']";
	public static final String ENTER_VALUE_FIELD = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther[2]";
	public static final String CONTINUE_BTN = "//*[@name='Continuar']";
	public static final String ENTER_PASS_FIELD = "//*[@name='Ingresa tu clave']";
	public static final String BAD_PASS_IMPUT = "//XCUIElementTypeStaticText[contains(@name, 'REFERENCIA PARA PAGO NO EXISTE')]";
	public static final String RECHARGE_BTN = "//XCUIElementTypeButton[@name=\"Recargar\"]";
	public static final String VALIDATE_TXT_RECARGA_REALIZADA = "//XCUIElementTypeStaticText[@name='Recarga realizada']";
	public static final String END_BTN = "//XCUIElementTypeButton[@name=\"Finalizar\"]";
	public static final String FINAL_BALANCE_TXT = "//XCUIElementTypeStaticText[contains(@name,'$')]";

}
