package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by MLaba on 29-Aug-17.
 */
public class TestDataConverter {
    private FileInputStream inputStream;
    String testDataFolderPath = "src/test/resources/testData/";     //"C:\\SeleniumTests\\SVN folder\\src\\test\\resources\\testData\\dataProvider.txt";
    StringBuilder out = new StringBuilder();
    ArrayList<String> stringList = new ArrayList();
    ArrayList<ArrayList> rowList = new ArrayList();


    public TestDataConverter(String fileName) throws IOException {
        //** @fileName - name of file with test data.
        // file with test data should be located by the @testDataFolderPath*/

        inputStream = new FileInputStream(testDataFolderPath + fileName);
        int data = inputStream.read();
        char content = 0;


        while (data != -1) {
            content = (char) data;
            if (content != '\n') {
                if (content != ',') {
                    if(content != '\r') {
                        out.append(content);
                    }
                    else {System.out.println("Symbol is not added");}
                } else {
                    stringList.add(String.valueOf(out));
                    out = new StringBuilder();
                }
            } else {
                stringList.add(String.valueOf(out));
                rowList.add(stringList);
                out = new StringBuilder();
                stringList = new ArrayList();
            }
            data = inputStream.read();
        }

        System.out.print(rowList.size());

    }


    public String[][] getDataFromFile(){
        //**Converts test data from listArray into array**//
        //**First row(Header) in the file is skipped **//

        String[][] arr = new String[rowList.size()][rowList.get(0).size()];

        for(int i = 0; i < rowList.size(); i++){

//            verifyRowLength(i, rowList.get(i).size());

            for(int j = 0; j < rowList.get(i).size(); j++){
                arr[i][j] = rowList.get(i).get(j).toString();
            }

        }

        return arr;
    }



    private IllegalArgumentException verifyRowLength(int rowNumber, int rowSize){

        /**Compare rowSize */
        if(rowSize == rowList.get(0).size()){
            return null;
        }
        else{
            return new IllegalArgumentException("Incorrect count of columns in the row #" + rowNumber);
        }

    }


}






