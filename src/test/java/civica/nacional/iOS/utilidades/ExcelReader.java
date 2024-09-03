package civica.nacional.iOS.utilidades;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReader {

    public Map<String, String[]> leerDatos(String excelFilePath) throws IOException {
        Map<String, String[]> dataMap = new HashMap<>();
        
        try (FileInputStream inputStream = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(inputStream)) {
            
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Leer la primera fila (encabezados)
            Row headerRow = rowIterator.next();
            List<String> headers = new ArrayList<>();
            for (Cell cell : headerRow) {
                headers.add(cell.getStringCellValue());
            }

            // Leer las filas restantes
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String[] rowData = new String[headers.size() - 1]; // Excluye el último valor que es el tag
                for (int i = 0; i < rowData.length; i++) {
                    rowData[i] = row.getCell(i).toString();
                }
                String tag = row.getCell(row.getLastCellNum() - 1).toString();
                dataMap.put(tag, rowData);
            }
        }
        
        return dataMap;
    }
}
