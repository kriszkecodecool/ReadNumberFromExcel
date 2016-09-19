import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Ivancsik Krisztian on 2016.09.19..
 */
public class ReadFile {
    public static void main(String[] args) {
        File file = new File("C:/codecool/numbers.xlsx");
        System.out.println(readFile(file));

    }

    public static String readFile(File file){
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFExcelExtractor extractor = new XSSFExcelExtractor(workbook);

            extractor.setFormulasNotResults(true);
            extractor.setIncludeSheetNames(false);
            String text = extractor.getText();
            String str = text.replaceAll("\\D+", "");
            return str;
        } catch (Exception E) {
            E.printStackTrace();
            return "Hiba keletkezett";
        }
    }

}

