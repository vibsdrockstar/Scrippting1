import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class SimpleExcelWriter {
	 public static void main(String[] args) throws IOException {
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("USER INPUT");
	         
	        Object[][] userData = {
	                {"Scenario Time", "FCU" },
	                {"Average Rest Time", "3.87"},
	                {"Thinking Time ,  " 4.9" },
	                {"Average Failure Rate", "7%"},
	                {"Virtual User","78000"},
	                {"Expected Session Rate ","3.4%"}
	        };
	 
	        int rowCount = 0;
	         
	        for (Object[] aUser : UserData) {
	            Row row = sheet.createRow(++rowCount);
	             
	            int columnCount = 0;
	             
	            for (Object field : aUser) {
	                Cell cell = row.createCell(++columnCount);
	                if (field instanceof String) {
	                    cell.setCellValue((String) field);
	                } else if (field instanceof Integer) {
	                    cell.setCellValue((Integer) field);
	                }
	            }
	             
	        }
	         
	         
	        try (FileOutputStream outputStream = new FileOutputStream("UserInput.xlsx")) {
	            workbook.write(outputStream);
	        }
	    }
	 
	}
}
