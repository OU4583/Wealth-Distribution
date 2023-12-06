import java.util.*;
import java.io.*;


public class StudentData {
  
  private ArrayList<String> unformattedData;
  private String[][] formattedData;
  private File fileName;
  private int column;
  
  public StudentData(String file) {
    try {
      fileName = new File(file); //opens the file to read
      Scanner scan = new Scanner(fileName); //instantiates a Scanner object that will read the file
      
      /* Initialize the ArrayList and read through the file, populating the  */
      /* populate unformattedData array with data from the table */
      unformattedData = new ArrayList<String>();
      while(scan.hasNextLine())
      {
        String line = scan.nextLine();
        unformattedData.add(line);
      }
      /* use String method replaceAll(String replace, String replacement) to get rid double quotes */
      ArrayList<String> data = new ArrayList<String>();
      for(int i = 0; i < unformattedData.size(); i ++)
      {
        String word = unformattedData.get(i);
        String n = word.replaceAll("\"","");
        data.add(n);
        System.out.println(n);
      }
      unformattedData = data;
      /* parse through the first row of unformattedData to determine the number of columns */
      int columns = 1;
      int index = unformattedData.get(0).indexOf(" ");
      String w = unformattedData.get(0);
      while(index != -1)
      {
        columns++;
        w = w.substring(index + 1);
        index = w.indexOf(",");
      }
      column = columns + 1;
      /* initialize the formattedData array using rows and columns */
      formattedData = new String[unformattedData.size()][column];
      
      /* populate formattedData array with data from unformattedData */
      for(int i =0; i < formattedData.length; i++)
      {
        String wo =unformattedData.get(i);
        int p = wo.indexOf(",");
        for(int j = 0; j < formattedData[0].length; j++){
            if (p != -1){
                formattedData[i][j] = wo.substring(0,p);
                wo = wo.substring(p+ 1);
                p = wo.indexOf(",");
            }
            else {
                formattedData[i][j] = wo;
            }
        }
      }


      scan.close();


    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }




  }
  
  public String[][] getFormattedData() {
    return formattedData;
  }
  
  
  /* Returns the row containing the country and year. Returns -1 if not found. */
  public int getRow(String countryName, String year) {
    for(int i = 0; i < formattedData.length;i++)
    {
        String word = formattedData[i][0];
        String p = formattedData[i][1];
        if(countryName.equals(word) && year.equals(p))
        {
            return i;
        }
    }
    return -1;
  }
}
