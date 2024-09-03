package civica.nacional.iOS.utilidades;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class DataToFeature {

    public static void overrideFeatureFiles(String featuresDir, String excelPath) throws InvalidFormatException, IOException {
        // Carga el archivo Excel
        FileInputStream file = new FileInputStream(excelPath);
        Workbook workbook = new XSSFWorkbook(file);

        // Busca todos los archivos .feature en el directorio especificado
        List<Path> featureFiles = Files.walk(Paths.get(featuresDir))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".feature"))
                .collect(Collectors.toList());

        // Procesa cada archivo .feature
        for (Path featureFile : featureFiles) {
            List<String> lines = Files.readAllLines(featureFile);
            String sheetName = getSheetNameFromFeatureFile(featureFile); // Método que determina la hoja según el archivo .feature

            if (sheetName != null) {
                Sheet sheet = workbook.getSheet(sheetName);
                if (sheet != null) {
                    // Mapa para almacenar los datos de cada caso de prueba
                    Map<String, String[]> dataMap = leerDatosDesdeHoja(sheet);

                    // Actualiza las líneas del archivo .feature con los datos del Excel
                    List<String> updatedLines = lines.stream()
                            .map(line -> reemplazarDatos(line, dataMap))
                            .collect(Collectors.toList());

                    Files.write(featureFile, updatedLines);
                }
            }
        }

        workbook.close();
        file.close();
    }

    private static String getSheetNameFromFeatureFile(Path featureFile) {
        String fileName = featureFile.getFileName().toString();
        
        // Lógica para determinar el nombre de la hoja basado en el nombre del archivo .feature
        if (fileName.contains("Login")) {
            return "Login";
        } else if (fileName.contains("OtroModulo")) {
            return "OtroModulo";
        } else if (fileName.contains("Registro")) {
            return "Registro";
        } else {
            // Si no se encuentra un nombre específico, puedes retornar un valor predeterminado o lanzar una excepción
            return "Default"; // O lanzar una excepción, si prefieres manejar el error
        }
    }

    private static Map<String, String[]> leerDatosDesdeHoja(Sheet sheet) {
        Map<String, String[]> dataMap = new HashMap<>();
        Iterator<Row> rowIterator = sheet.iterator();

        // Salta la primera fila (encabezados)
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String[] data = new String[row.getPhysicalNumberOfCells() - 1];
            for (int i = 0; i < data.length; i++) {
                data[i] = row.getCell(i).toString();
            }
            String tag = row.getCell(row.getPhysicalNumberOfCells() - 1).toString();
            dataMap.put(tag, data);
        }
        return dataMap;
    }

    private static String reemplazarDatos(String line, Map<String, String[]> dataMap) {
        for (String tag : dataMap.keySet()) {
            if (line.contains(tag)) {
                String[] values = dataMap.get(tag);
                String[] placeholders = {"<0>", "<1>", "<2>", "<3>", "<4>"};

                for (int i = 0; i < placeholders.length; i++) {
                    line = line.replace(placeholders[i], values[i]);
                }
            }
        }
        return line;
    }
}
