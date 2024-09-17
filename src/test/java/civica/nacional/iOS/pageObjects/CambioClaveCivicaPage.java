package civica.nacional.iOS.pageObjects;

public class CambioClaveCivicaPage {

	public static final String MENU_HAMBURGUESA = "//*[@name='ic menu 2']";
	public static final String USER_BTN_HM = "//*[@name='Usuario']";
	public static final String CHANGE_PASS_BTN = "//XCUIElementTypeTable/XCUIElementTypeCell[3]";
	public static final String ENTER_PSS_TO_CONTINUE = "//*[@name='Ingresa tu clave']";
	public static final String CONTINUE_BTN_CHANGE_PSS = "//XCUIElementTypeButton[@name='Continuar']";
	public static final String CREATE_PASS_BTN = "//XCUIElementTypeButton[@name=\"Crear clave\"]";
	public static final String PASS_CHANGE_FIELD = "//XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]";
	public static final String PASS_CHANGE_CONFIRM_FIELD = "//XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]";
	public static final String BACKGROUND_VIEW = "//*[@name='Asigna una clave de 4 números.']";
	public static final String PASS_CHANGE_CONFIRM_BTN = "//XCUIElementTypeButton[@name='Cambiar Clave']";
	public static final String FINAL_CREATE_PASS_BTN = "//*[@name='Crear clave']";
	public static final String TXT_SUCCESSFUL_PASS_CHANGE = "//XCUIElementTypeStaticText[@name=\"Cambio de clave exitoso\"]";
	public static final String END_PASS_CHANGE_BTN = "//XCUIElementTypeButton[@name=\"Finalizar\"]";
	public static final String PASS_NO_VALID = "//*[@name='Intenta otra clave']";
	public static final String ACCPT_POPUP_PASS_NO_VALID = "//XCUIElementTypeButton[@name='Aceptar']";
	public static final String RETURN_CHANGE_PASS = "//XCUIElementTypeButton[@name='Cambia tu clave']";
	public static final String ICON_EYE_PASS = "(//XCUIElementTypeImage[@name='iconEyeClose'])[1]";
	public static final String ICON_EYE_CONFIRM_PASS = "//XCUIElementTypeImage[@name='iconEyeClose']";
}
