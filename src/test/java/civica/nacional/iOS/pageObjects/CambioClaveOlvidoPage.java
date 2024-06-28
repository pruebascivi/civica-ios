package civica.nacional.iOS.pageObjects;

public class CambioClaveOlvidoPage {

	public static final String FORGOT_PASS_BTN = "//XCUIElementTypeOther[@name=\"¿Olvidaste tu clave?\"]";
	public static final String TYPE_ID_BTN = "//XCUIElementTypeButton[@name=\"iconDownArrow\"]";
	public static final String SELECT_TIPO_ID = "//XCUIElementTypePickerWheel[@value=\"Cédula de ciudadanía\"]";
	public static final String DOCUMENT_NUM_FIELD = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField";
	public static final String CONTINUE_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String INPUT_MAIL_FIELD = "//XCUIElementTypeTextField[@value=\"Correo electrónico\"]";
	public static final String POPUP_ERR_MAIL = "//XCUIElementTypeStaticText[contains(@name,'Revisa la información']";
	public static final String POPUP_SAME_PASS = "//XCUIElementTypeStaticText[@name='Intenta otra clave']";
	public static final String CONTINUE_EMAIL_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String SMS_CODE_VERIFY_FIELD = "//*[@name='Ingresa el número de 6 dígitos']";
	public static final String CONTINUE_CODE_VERIFY_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String AD_CREATE_PASS = "(//XCUIElementTypeButton[@name=\"Crear clave\"])[2]";
	public static final String CREATE_NEW_PASS_BTN = "(//XCUIElementTypeButton[@name=\"Crear clave\"])[2]";
	public static final String CREATE_NEW_PASS = "//XCUIElementTypeSecureTextField[@name=\"Crea tu clave\"]";
	public static final String CREATE_PASS_FIELD = "//XCUIElementTypeSecureTextField[@name=\"Crea tu clave\"]";
	public static final String CONFIRM_PASS_FIELD = "//XCUIElementTypeSecureTextField[@name=\"Confirma tu clave\"]";
	public static final String CREATE_PASS_BTN = "//XCUIElementTypeButton[@name='Crear clave']";
	public static final String END_BTN = "//*[@name='Finalizar']";
	public static final String REVISA_INFORMACION = "//XCUIElementTypeStaticText[@name='Revisa la información']";
	public static final String ACERCATE_PAC = "//XCUIElementTypeStaticText[contains(@name,'Revisa la información')] | //XCUIElementTypeStaticText[contains(@name,'Acércate a un PAC')]";
	public static final String ACCEPT_POP_UP = "//XCUIElementTypeButton[@name=\"Aceptar\"]";
	public static final String VERIFICATION_CODE_INPUT = "//XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]";

}
