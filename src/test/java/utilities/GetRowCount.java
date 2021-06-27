package utilities;

/**
 * Created by Ashish on 11-07-2017.
 */
public class GetRowCount extends GetColCount{

    public int getRowCount(String sheetName)
    {
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum()+1;
        return rowCount;
    }
}
