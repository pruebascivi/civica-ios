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
        FileInputStream file = new FileInputStream(excelPath);
        Workbook workbook = new XSSFWorkbook(file);

        List<Path> featureFiles = Files.walk(Paths.get(featuresDir))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".feature"))
                .collect(Collectors.toList());

        for (Path featureFile : featureFiles) {
            List<String> lines = Files.readAllLines(featureFile);
            String sheetName = getSheetNameFromFeatureFile(featureFile);

            if (sheetName != null) {
                Sheet sheet = workbook.getSheet(sheetName);
                if (sheet != null) {
                    Map<String, String[]> dataMap = leerDatosDesdeHoja(sheet);

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
        
        if (fileName.contains("Login")) {
            return "Login";
        } else if (fileName.contains("CambioDispositivo")) {
            return "CambioDispositivo";
        } else if (fileName.contains("CambioClave")) {
            return "CambioClave";
        } else if (fileName.contains("CambioClaveOlvido")) {
            return "CambioClaveOlvido";
        } else if (fileName.contains("Registro")) {
            return "Registro";
        } else {
            return "Default";
        }
    }

    private static Map<String, String[]> leerDatosDesdeHoja(Sheet sheet) {
        Map<String, String[]> dataMap = new HashMap<>();
        Iterator<Row> rowIterator = sheet.iterator();

        // Salta la primera fila (encabezados)
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            int numCells = row.getPhysicalNumberOfCells();
            String[] data = new String[numCells - 1]; // La última columna es el CP

            for (int i = 0; i < data.length; i++) {
                data[i] = row.getCell(i).toString();
            }

            String tag = row.getCell(numCells - 1).toString();
            dataMap.put(tag, data);
        }
        return dataMap;
    }

    private static String reemplazarDatos(String line, Map<String, String[]> dataMap) {
        for (String tag : dataMap.keySet()) {
            if (line.contains(tag)) {
                String[] values = dataMap.get(tag);
                String[] placeholders = line.split("<|>"); // Extraer placeholders

                for (int i = 1; i < placeholders.length; i += 2) {
                    int index = (i - 1) / 2;
                    line = line.replace("<" + placeholders[i] + ">", values[index]);
                }
            }
        }
        return line;
    }
}
