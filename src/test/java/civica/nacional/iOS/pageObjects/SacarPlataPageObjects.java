package civica.nacional.iOS.pageObjects;


public class SacarPlataPageObjects {

	public static final String SACAR_PLATA_MODULE = "//XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]";
	public static final String AMOUNT_MONEY_FIELD = "//XCUIElementTypeTextField[@name=\"Ingresa otro valor\"]";
	public static final String CONTINUE_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String INPUT_PASS_FIELD = "//XCUIElementTypeSecureTextField[@name=\"Ingresa tu clave\"]";
	public static final String SACAR_PLATA_BTN = "//XCUIElementTypeButton[@name=\"Sacar Plata\"]";
	public static final String TXT_CODE = "//XCUIElementTypeApplication[@name=\"Cívica\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]";
	public static final String END_BTN = "//XCUIElementTypeButton[@name=\"Finalizar\"]";
	public static final String TXT_BALANCE = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]";
	public static final String TXT_VALIDATE = "//XCUIElementTypeStaticText[@name='Tu código']";
	public static final String NEW_AUTORIZADOR = "//XCUIElementTypeStaticText[@name='Tu código']/following-sibling::XCUIElementTypeStaticText";
	public static final String BTN_CANCEL = "//XCUIElementTypeButton[@name='Cancelar']";
	public static final String NEW_FIEL_INPUT_VALUE = "//XCUIElementTypeTextField[contains(@name,'$')]";
	public static final String RETURN_BTN = "//XCUIElementTypeButton[@name='Sacar plata']";
	public static final String BACK_BTN_DESDE_SACARPLATA = "//XCUIElementTypeButton[@name='Back']";
}
