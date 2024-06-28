package civica.nacional.iOS.pageObjects;

public class PasarPlataCivicaPage {

	public static final String PASAR_PLATA_BTN = "//*[@name='PasarPlata']";
	public static final String ENTER_CELLPHONE_NUM_FIELD = "//XCUIElementTypeTextField[@name='Número celular, ​El numero de celular debe iniciar con el número 3 y debe ser de 10 digitos.']";
	public static final String VALIDATE_VISIBLE_TXT = "//XCUIElementTypeStaticText[@name='¿A quién le vas a pasar plata?']";
	public static final String FIELD_VIEW = "//XCUIElementTypeStaticText[@name='¿Cuánta plata quieres pasar?']";
	public static final String ENTER_VALUE_FIELD = "//*/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther[2]";
	public static final String CONTINUE_BTN = "//XCUIElementTypeButton[@name='Continuar']";
	public static final String VALIDATE_PASS_FIELD = "//XCUIElementTypeSecureTextField[@name='Ingresa tu clave']";
	public static final String FINAL_BTN_PASAR_PLATA = "(//XCUIElementTypeButton[@name='Pasar plata'])[2]";
	public static final String VALIDATE_TXT_PASASTE_PLATA = "//XCUIElementTypeStaticText[@name='Pasaste plata']";
	public static final String END_BTN = "//XCUIElementTypeButton[@name='Finalizar']";
	public static final String SALDOS_HOME = "//XCUIElementTypeStaticText[contains(@name,'$')]";
	public static final String MOVIMIENTOS_BTN = "//XCUIElementTypeButton[@name='Movimientos']";
	public static final String FIRST_FIELD_MOV_TYPE = "//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[1]";
	public static final String FIRST_FIELD_MOV_VALUE = "//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[4]";
	public static final String FIRST_FIELD_MOV_DATE = "//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[3]";
	public static final String VISIBLE_MOVIMIENTOS = "//XCUIElementTypeStaticText[@name='Tus movimientos']";
	public static final String BACK_BTN = "//XCUIElementTypeButton[@name='Back']";
	public static final String NUM_AUTORIZACION = "//XCUIElementTypeTextField[contains(@name,'Número de autorización')]";
	public static final String FIELD_VALUE = "//XCUIElementTypeTextField[@name='Valor a pasar']";
	public static final String TAP_TU_SALDO = "//XCUIElementTypeStaticText[@name='Tu saldo']";
	public static final String TAP_CUANTA_PLATA = "//XCUIElementTypeStaticText[@name='¿Cuánta plata quieres pasar?']";
	public static final String BTN_CANCEL = "//XCUIElementTypeButton[@name='Cancelar']";
}
