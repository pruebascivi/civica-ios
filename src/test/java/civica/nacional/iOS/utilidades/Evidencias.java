package civica.nacional.iOS.utilidades;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
import civica.nacional.iOS.definitions.Hooks;
import org.openqa.selenium.WebElement;

public class Evidencias {

	static String nombreEscenarioGlobal = "";
	static String rutaArchivoGeneral = "";
	static XWPFDocument docx = new XWPFDocument();
	static XWPFRun run = docx.createParagraph().createRun();
	public static String USER_DIR = "user.dir";
	static FileOutputStream out;
	public static int numeroScreen = 1;
	public static Date fechaPrueba;
	public static String nombreImagen;
	public static String []nombreimagen = new String[100];
	public static int contador = 0;

	
	public static String[] getImagen() {
		return nombreimagen;
	}

	public static void capturaDispositivo(String descripcion) throws IOException {
		File srcFile = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.FILE);
		File targetFile = new File(
				System.getProperty("RutaEvidencias") + File.separator + numeroScreen + "_" + descripcion + ".png");
		nombreImagen = numeroScreen + "_" + descripcion;
		nombreimagen [contador]= nombreImagen; 
		BufferedImage image = ImageIO.read(srcFile);
		Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("png");
		ImageWriter writer = (ImageWriter) writers.next();
		ImageOutputStream ios = ImageIO.createImageOutputStream(targetFile);
		writer.setOutput(ios);
//		ImageWriteParam param = writer.getDefaultWriteParam();
//		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//		param.setCompressionQuality(0.5f);
		writer.write(null, new IIOImage(image, null, null), null);
		ios.close();
		writer.dispose();
		// FileUtils.copyFile(srcFile, targetFile);
		numeroScreen++;
		contador++;
	}
	
    public static void capturaDispositivoResaltado(String descripcion, WebElement elemento) throws IOException {
        BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Tomar la captura de pantalla original
        File srcFile = ((TakesScreenshot) BaseUtil.driver).getScreenshotAs(OutputType.FILE);
        BufferedImage image = ImageIO.read(srcFile);

        // Obtener las coordenadas del objeto
        Point location = elemento.getLocation();
        Dimension size = elemento.getSize();

        // Calcular las coordenadas del rectángulo resaltado
        int x = location.getX();
        int y = location.getY();
        int width = size.getWidth();
        int height = size.getHeight();

        // Resaltar el objeto en la imagen
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.GREEN);
        graphics.setStroke(new BasicStroke(5));
        graphics.drawRect(x, y, width, height);
        graphics.dispose();

        // Guardar la captura de pantalla resaltada
        String nombreImagen = numeroScreen + "_" + descripcion + ".png";
        File targetFile = new File(System.getProperty("RutaEvidencias") + File.separator + nombreImagen);
        ImageIO.write(image, "png", targetFile);

        // Incrementar los contadores
        numeroScreen++;
        contador++;
    }

    
	public static String capturaDispositivoTesseract(String descripcion) throws IOException {
		
		String textoImagen = "";
	    // Capturar la imagen del dispositivo
	    File srcFile = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.FILE);
	   
	    // Crear un archivo de destino con la ruta adecuada y el nombre de archivo
	    File targetFile = new File(
	    		System.getProperty("RutaEvidencias") + File.separator + "_" + descripcion + ".png");
	    // Leer la imagen capturada en un objeto BufferedImage
	    BufferedImage imagenCompleta = ImageIO.read(srcFile);

	    // Escribir la imagen recortada en el archivo de destino
	    ImageIO.write(imagenCompleta, "png", targetFile);

	    // Incrementar el contador de pantalla y el contador
	    numeroScreen++;
	    contador++;
	    
	    textoImagen = TesseractOCR.getTextImage(descripcion);
	    System.out.println("El texto de la imnagen es: " + textoImagen);
	    
	    return textoImagen.trim();
	}
	
	public static void capturaDispositivoPCLatinia(String descripcion) throws IOException {

		File srcFile = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.FILE);
		File targetFile = new File(
				System.getProperty("RutaEvidencias") + File.separator + numeroScreen + "_" + descripcion + ".png");
		FileUtils.copyFile(srcFile, targetFile);
		numeroScreen++;
	}

	public static void capturaDispositivo(WebDriver driver, String descripcion) throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File(
				System.getProperty("RutaEvidencias") + File.separator + numeroScreen + "_" + descripcion + ".png");
		nombreImagen = numeroScreen + "_" + descripcion;
		nombreimagen [contador]= nombreImagen; 
		numeroScreen++;
//			BufferedImage image = ImageIO.read(srcFile);
//			Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
//			ImageWriter writer = (ImageWriter) writers.next();
//			ImageOutputStream ios = ImageIO.createImageOutputStream(targetFile);
//			writer.setOutput(ios);
//			ImageWriteParam param = writer.getDefaultWriteParam();
//			param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//			param.setCompressionQuality(0.5f);
//			writer.write(null, new IIOImage(image, null, null), param);
//			ios.close();
//			writer.dispose();

		FileUtils.copyFile(srcFile, targetFile);
		contador++;

	}
	
    public static void capturaPantallaWeb(String descripcionImagen) {
        String screenshot_name = descripcionImagen + ".png";
        try {
            // Convierte el controlador a TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) BaseUtil.chromeDriver;

            // Toma la captura de pantalla como un archivo
            File capturaDePantalla = screenshot.getScreenshotAs(OutputType.FILE);

            // Guarda la captura de pantalla en el sistema de archivos
            File file = new File(
                    System.getProperty("RutaEvidencias") + File.separator + numeroScreen + "_" + screenshot_name);
            org.apache.commons.io.FileUtils.copyFile(capturaDePantalla, file);

            InputStream pic = new FileInputStream(
                    System.getProperty("RutaEvidencias") + File.separator + numeroScreen + "_" + screenshot_name);
            nombreImagen = numeroScreen + "_";
            nombreimagen[contador] = nombreImagen;
            numeroScreen++;
            contador++;
            run.addBreak();
            pic.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

	public static void generarReporte(String ruta, String nombreEscenario, String estadoCaso, String tiempo)
			throws InvalidFormatException, FileNotFoundException, IOException {
		fechaPrueba = new Date();
		Map<String, File> keyImagenes = new HashMap<String, File>();

		try {
			/*
			 * DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy"); Calendar cal =
			 * Calendar.getInstance(); String date=dateFormat.format(cal.getTime());
			 */
			XWPFDocument document = new XWPFDocument();

			XWPFParagraph paragraphSix = document.createParagraph();
			paragraphSix.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun paragraphFourRunOne = paragraphSix.createRun();
			paragraphFourRunOne.setBold(true);
			// paragraphFourRunOne.setUnderline(UnderlinePatterns.SINGLE);
			paragraphFourRunOne.setFontSize(15);
			paragraphFourRunOne.setFontFamily("Verdana");
			paragraphFourRunOne.setColor("000070");
			paragraphFourRunOne.addBreak();
			paragraphFourRunOne.setText("REPORTE DE EJECUCIÓN");/////////// step name or image name
			paragraphFourRunOne.addBreak();

			XWPFParagraph paragraphOne = document.createParagraph();
			paragraphOne.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun paragraph1RunOne = paragraphOne.createRun();
			paragraph1RunOne.setBold(true);
			paragraph1RunOne.setFontSize(14);
			paragraph1RunOne.setFontFamily("Verdana");
			paragraph1RunOne.setColor("000070");
			paragraph1RunOne.setText("-----------------------------------------------------------------");////////////////////
			// paragraph1RunOne.addBreak();

			XWPFParagraph paragraphTwo = document.createParagraph();
			paragraphTwo.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun paragraphOneRunOne = paragraphTwo.createRun();
			paragraphOneRunOne.setBold(true);
			paragraphOneRunOne.setFontSize(15);
			paragraphOneRunOne.setFontFamily("Verdana");
			paragraphOneRunOne.setColor("000070");
			paragraphOneRunOne.setText(nombreEscenario);/////////

			XWPFParagraph paragraphThree = document.createParagraph();
			paragraphThree.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun paragraphThreeRunOne = paragraphThree.createRun();
			paragraphThreeRunOne.setBold(false);
			paragraphThreeRunOne.setFontSize(12);
			paragraphThreeRunOne.setFontFamily("Verdana");
			paragraphThreeRunOne.setColor("000070");
			paragraphThreeRunOne.setText("" + new java.util.Date());////////////////////
			// paragraphThreeRunOne.addBreak();

			XWPFParagraph paragraphFour = document.createParagraph();
			paragraphFour.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun paragraphsixRunOne = paragraphFour.createRun();
			paragraphsixRunOne.setBold(true);
			paragraphsixRunOne.setFontSize(14);
			paragraphsixRunOne.setFontFamily("Verdana");
			paragraphsixRunOne.setColor("000070");
			paragraphsixRunOne.setText("Estado de Ejecución:");

			if (estadoCaso.equals("PASSED")) {
				paragraphsixRunOne.setColor("0BA20B");
				paragraphsixRunOne.setText(" " + estadoCaso);
				
			} else {
				paragraphsixRunOne.setColor("EF1111");
				paragraphsixRunOne.setText(" " + estadoCaso);
			}
			
			paragraphFour = document.createParagraph();
			paragraphFour.setAlignment(ParagraphAlignment.LEFT);
			paragraphsixRunOne = paragraphFour.createRun();
			paragraphsixRunOne.setBold(true);
			paragraphsixRunOne.setFontSize(10);
			paragraphsixRunOne.setFontFamily("Verdana");
			paragraphsixRunOne.setColor("000070");
			paragraphsixRunOne.setText("Causa de la falla: ");
			
			if (estadoCaso.equals("FAILED")) {
				paragraphsixRunOne.setColor("000070");
				paragraphsixRunOne.setText(BaseUtil.causaFalla);
			}
			
			paragraphFour = document.createParagraph();
			paragraphFour.setAlignment(ParagraphAlignment.LEFT);
			paragraphsixRunOne = paragraphFour.createRun();
			paragraphsixRunOne.setBold(true);
			paragraphsixRunOne.setFontSize(14);
			paragraphsixRunOne.setFontFamily("Verdana");
			paragraphsixRunOne.setColor("000070");
			paragraphsixRunOne.setText("Tiempo de Ejecución: " + tiempo);
			
			Capabilities dc = Hooks.getDriver().getCapabilities();
			paragraphFour = document.createParagraph();
			paragraphFour.setAlignment(ParagraphAlignment.LEFT);
			paragraphsixRunOne = paragraphFour.createRun();
			paragraphsixRunOne.setBold(true);
			paragraphsixRunOne.setFontSize(14);
			paragraphsixRunOne.setFontFamily("Verdana");
			paragraphsixRunOne.setColor("000070");
			paragraphsixRunOne.setText("Dispositivo: " + dc.getCapability("deviceName"));

			paragraphFour = document.createParagraph();
			paragraphFour.setAlignment(ParagraphAlignment.LEFT);
			paragraphsixRunOne = paragraphFour.createRun();
			paragraphsixRunOne.setBold(true);
			paragraphsixRunOne.setFontSize(14);
			paragraphsixRunOne.setFontFamily("Verdana");
			paragraphsixRunOne.setColor("000070");
			paragraphsixRunOne.setText("Plataforma: " + dc.getCapability("platformName"));

			paragraphFour = document.createParagraph();
			paragraphFour.setAlignment(ParagraphAlignment.LEFT);
			paragraphsixRunOne = paragraphFour.createRun();
			paragraphsixRunOne.setBold(true);
			paragraphsixRunOne.setFontSize(14);
			paragraphsixRunOne.setFontFamily("Verdana");
			paragraphsixRunOne.setColor("000070");
			paragraphsixRunOne.setText("Versión plataforma: " + dc.getCapability("platformVersion"));

			paragraphFour = document.createParagraph();
			paragraphFour.setAlignment(ParagraphAlignment.LEFT);
			paragraphsixRunOne = paragraphFour.createRun();
			paragraphsixRunOne.setBold(true);
			paragraphsixRunOne.setFontSize(14);
			paragraphsixRunOne.setFontFamily("Verdana");
			paragraphsixRunOne.setColor("000070");
			paragraphsixRunOne.setText("UDID: " + dc.getCapability("udid"));

			paragraphFour = document.createParagraph();
			paragraphFour.setAlignment(ParagraphAlignment.LEFT);
			paragraphsixRunOne = paragraphFour.createRun();
			paragraphsixRunOne.setBold(true);
			paragraphsixRunOne.setFontSize(14);
			paragraphsixRunOne.setFontFamily("Verdana");
			paragraphsixRunOne.setColor("000070");
			paragraphsixRunOne.setText("BundleId: " + dc.getCapability("bundleId"));

			paragraphFour = document.createParagraph();
			paragraphFour.setAlignment(ParagraphAlignment.LEFT);
			paragraphsixRunOne = paragraphFour.createRun();
			paragraphsixRunOne.setBold(true);
			paragraphsixRunOne.setFontSize(14);
			paragraphsixRunOne.setFontFamily("Verdana");
			paragraphsixRunOne.setColor("000070");
			paragraphsixRunOne.setText("Versión App: " + BaseUtil.versionApp);
			
			paragraphFour = document.createParagraph();
			paragraphFour.setAlignment(ParagraphAlignment.LEFT);
			paragraphsixRunOne = paragraphFour.createRun();
			paragraphsixRunOne.setBold(true);
			paragraphsixRunOne.setFontSize(14);
			paragraphsixRunOne.setFontFamily("Verdana");
			paragraphsixRunOne.setColor("000070");
			paragraphsixRunOne.setText("Usuario: " + BaseUtil.usuario);
			
			if(!BaseUtil.numeroCelular.contentEquals("No Aplica")) {
				paragraphFour = document.createParagraph();
				paragraphFour.setAlignment(ParagraphAlignment.LEFT);
				paragraphsixRunOne = paragraphFour.createRun();
				paragraphsixRunOne.setBold(true);
				paragraphsixRunOne.setFontSize(14);
				paragraphsixRunOne.setFontFamily("Verdana");
				paragraphsixRunOne.setColor("000070");
				paragraphsixRunOne.setText("Celular de Usuario: " + BaseUtil.numeroCelular);
			}

//		paragraphsixRunOne.addBreak();

			XWPFParagraph paragraphFive = document.createParagraph();
			paragraphFive.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun paragraph7RunOne = paragraphFive.createRun();
			paragraph7RunOne.setBold(true);
			paragraph7RunOne.setFontSize(14);
			paragraph7RunOne.setFontFamily("Verdana");
			paragraph7RunOne.setColor("000070");
			paragraph7RunOne.setText("-----------------------------------------------------------------");////////////////////
			paragraph7RunOne.addBreak();

			InputStream pic = null;
//            try {
//                pic = new FileInputStream("d:\\1.JPG");
//            } catch (FileNotFoundException e1) {
//                e1.printStackTrace();
//            }

			File file = new File(ruta);
			File[] files = file.listFiles();

			for (File f : files) {
				if (f.getName().contains(".png")) {
					String posicion = f.getName().split("_")[0];
					System.out.println(posicion);
					keyImagenes.put(posicion, f);
				}
			}
			
//			for (int x = 1; x <= keyImagenes.size(); x++) {
			for (int x = 1; x <= keyImagenes.size(); x++) {
				File f = keyImagenes.get(x + "");
				try {
				if (f.getName().contains(".png")) {
					System.out.println(f.getName());
					try {
						pic = new FileInputStream(ruta + File.separator + f.getName());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
						terminarEvidencia(document, ruta, nombreEscenario, estadoCaso);
					}

					try {

						XWPFParagraph paragraphSeven = document.createParagraph();
						paragraphSeven.setAlignment(ParagraphAlignment.LEFT);
						XWPFRun paragraphThreeRunOne5 = paragraphSeven.createRun();
						// paragraphThreeRunOne.setBold(true);
						paragraphThreeRunOne5.setFontSize(12);
						paragraphThreeRunOne5.setFontFamily("Verdana");
						paragraphThreeRunOne5.setColor("000070");
						paragraphThreeRunOne5.setText("Paso: " + f.getName().replaceAll(".png", ""));////////////////////
						// paragraphThreeRunOne5.addBreak();

						XWPFParagraph paragraphEight = document.createParagraph();
						paragraphEight.setAlignment(ParagraphAlignment.CENTER);
						XWPFRun paragraphFiveRunOne = paragraphEight.createRun();
						int numeroImagen = Integer.parseInt(f.getName().split("_")[0]);
						if (f.getName().contains("web")||f.getName().contains("Web")) {
							paragraphFiveRunOne.addPicture(pic, XWPFDocument.PICTURE_TYPE_JPEG,
									ruta + File.separator + f.getName(), Units.toEMU(500), Units.toEMU(300));
						} else {
							paragraphFiveRunOne.addPicture(pic, XWPFDocument.PICTURE_TYPE_JPEG,
									ruta + File.separator + f.getName(), Units.toEMU(200), Units.toEMU(360));
						}
						if (!(f.getName().split("_")[0]).equals("1") && (numeroImagen % 2 == 0)) {
							// paragraphEight.setPageBreak(true);
							paragraphSeven.setPageBreak(true);
						}

					} catch (InvalidFormatException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}}catch (Exception ex) {
					ex.printStackTrace();
				}
				pic.close();
			}
			terminarEvidencia(document, ruta, nombreEscenario, estadoCaso);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void terminarEvidencia(XWPFDocument document, String ruta, String nombreEscenario,
			String estadoCaso) {
		XWPFParagraph paragraph8 = document.createParagraph();
		paragraph8.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun paragraph8RunOne = paragraph8.createRun();
		paragraph8RunOne.setBold(true);
		paragraph8RunOne.setFontSize(14);
		paragraph8RunOne.setFontFamily("Verdana");
		paragraph8RunOne.setColor("000070");
		paragraph8.setPageBreak(true);
		paragraph8RunOne.setText("---------------------------Caso finalizado---------------------");////////////////////

		// create header start
		CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
		XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(document, sectPr);

		XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);

		XWPFParagraph paragraph = header.createParagraph();
		paragraph.setAlignment(ParagraphAlignment.LEFT);

		CTTabStop tabStop = paragraph.getCTP().getPPr().addNewTabs().addNewTab();
		tabStop.setVal(STTabJc.RIGHT);
		int twipsPerInch = 1440;
		tabStop.setPos(BigInteger.valueOf(6 * twipsPerInch));

		XWPFRun run = paragraph.createRun();
		run.setText("Informe de evidencia de prueba de Banco Davivienda S.A");
		run.addTab();

		run = paragraph.createRun();

		String imgFile = "src/test/resources/imagenes/logo_Davivienda.png";// System.getProperty(USER_DIR)+
																			// File.separator+"lib\\logo_Davivienda.png";
		try {
			run.addPicture(new FileInputStream(imgFile), XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(50),
					Units.toEMU(50));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// create footer start
		XWPFFooter footer = headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT);

		paragraph = footer.createParagraph();
		paragraph.setAlignment(ParagraphAlignment.CENTER);

		run = paragraph.createRun();
		run.setText("Banco Davivienda S.A | Confidencial");

		FileOutputStream outStream = null;
		try {
			ruta = ruta + File.separator + "Evidencias_" + nombreEscenario.split("_")[0] + "_" + estadoCaso + "_"
					+ Utilidades.formatDateInforme("yyyy-MM-dd_HH-mm-ss", fechaPrueba) + ".docx";
			outStream = new FileOutputStream(ruta);

		} catch (FileNotFoundException e) {
			System.out.println("First Catch");
			e.printStackTrace();
		}
		try {
			document.write(outStream);
			outStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Second Catch");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Third Catch");
			e.printStackTrace();
		}
	}

	public static String homologarEstadoCaso(String estado) {
		String estadoHomologado = "";
		if (estado.toUpperCase().equals("PASSED")) {
			estadoHomologado = "Passed";
		} else {
			estadoHomologado = "Failed";
		}
		return estadoHomologado;
	}

	public String getRuta(String ruta) {
		return ruta;
	}

	public static void eleminarImagenes(String ruta) {

		File file = new File(ruta);
		File[] files = file.listFiles();
		for (File f : files) {
			// || f.getName().contains(".docx")
			if (f.getName().contains(".png") || f.getName().contains(".png") || f.getName().contains(".gif")) {
				f.delete();
			}
		}
	}
}