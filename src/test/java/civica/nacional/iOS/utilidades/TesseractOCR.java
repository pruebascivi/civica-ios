package civica.nacional.iOS.utilidades;

import java.io.File;

import net.sourceforge.tess4j.*;

public class TesseractOCR {
	
	public static String getTextImage(String nombreImagen) {
	
		 File imageFile = new File(System.getProperty("RutaEvidencias") + File.separator + "_" + nombreImagen + ".png");
	     Tesseract instance = new Tesseract();
	     String result = "";
	     //Data de entrenamiento de la red neuronal
	     
	     instance.setDatapath(".\\tessdata\\spa.traineddata");
	     
	     //instance.setDatapath("./tessdata");
	
	     instance.setLanguage("spa"); // for Spanish
	     try {
	         result = instance.doOCR(imageFile);
	      } catch (TesseractException e) {
	         System.err.println(e.getMessage());
	      }
	     
	     return result;
	     
	    }
}
