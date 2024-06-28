package civica.nacional.iOS.pageObjects;

public class RecargaPseCivicaPayPage {
	
	public static final String CIVICAPAY_MODULE = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]";
	public static final String INPUT_CEL_FIELD = "//XCUIElementTypeTextField[@value='Número celular registrado en Cívica Pay']";
	public static final String INPUT_CONFIRM_CEL_FIELD = "//XCUIElementTypeTextField[@value='Confirmar número']";
	public static final String INPUT_VALUE_FIELD = "//XCUIElementTypeTextField[@value='Valor mínimo de recarga $ 1.000']";
	public static final String MONTO_INVALID = "//XCUIElementTypeStaticText[contains(@name, 'Monto no válido')]";
	public static final String SELECT_BANK_FIELD = "//XCUIElementTypeOther[@value='Selecciona el banco']";
	public static final String ELEMENT_VISIBLE = "//XCUIElementTypeStaticText[@name='Completa los datos para recargar Cívica Pay']";
	public static final String COLLECTION_VIEW = "//XCUIElementTypeCollectionView";
	public static final String BANCO_UNION_COL = "//XCUIElementTypeButton[@name='BANCO UNION COLOMBIANO']";
	public static final String EXTRAER_TEXT_BANK = "//XCUIElementTypeOther[contains(@value, 'A') or contains(@value, 'I') or contains(@value, 'P')]";
	public static final String BTN_CONTINUAR_LOGIN = "//*[@name='Continuar']";
	public static final String ACCEPT_TO_CONTINUE = "//XCUIElementTypeButton[@name='Aceptar']";
	public static final String CONTINUE_BTN = "//XCUIElementTypeButton[@name='Continuar']";
	public static final String MENU_HAMBURGUESA = "//*[@name='ic menu 2']";
	public static final String ACCOUNT_AGENCY = "//XCUIElementTypeTextField[@name='Format: 4 digits']";
	public static final String ACCOUNT_NUMBER = "//XCUIElementTypeTextField[@name='Format: 4-6 digits']";
	public static final String PASSWORD = "//XCUIElementTypeSecureTextField[@name='Format: 6 digits']";
	public static final String PAY_BTN = "//XCUIElementTypeButton[@name='Pay']";
	public static final String SUCCESSFUL_TRANSACTION_TXT = "//XCUIElementTypeOther[@name='Transacción exitosa']";
	public static final String END_BTN = "//XCUIElementTypeButton[@name='Finalizar']";
	public static final String BACK_BTN = "//XCUIElementTypeButton[@name='Back']";
	public static final String DONE_BTN = "//XCUIElementTypeButton[@name='Back']";
	public static final String NEW_AUTORIZADOR = "//XCUIElementTypeStaticText[@name='Tu código']/following-sibling::XCUIElementTypeStaticText";
	public static final String ICON_CLOSE = "//XCUIElementTypeButton[@name='iconClose']";
	public static final String ELEMENT_LOGOUT_VISIBLE = "//XCUIElementTypeOther[@name='Cerrar sesión']";
	public static final String TXT_ERROR_POPUP = "//XCUIElementTypeStaticText[contains(@name, 'No') or contains(@name, 'Error') or contains(@name, 'bloqueado')]";
}
