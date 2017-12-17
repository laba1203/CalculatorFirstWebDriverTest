package elements;

import java.util.ArrayList;

/**
 * Created by MLaba on 23-Aug-17.
 */
public class History {

    static ArrayList <TableRow> tableRows = new ArrayList();
    TableRow tableRow = new TableRow();

    public History(){
        tableRows.add(tableRow);
    }


    public TableRow getLastRow(){
        return tableRows.get(0);
    }

    public TableRow getFirstRow(){
        int lastIndex = tableRows.size() - 1;
        return tableRows.get(lastIndex);
    }

    public TableRow getRowByNumber(int rowNumber){
        if(rowNumber > tableRows.size()){
            new IllegalArgumentException("<rowNumber> bigger that table size");
        }

        return tableRows.get(rowNumber);
    }




}
