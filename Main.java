import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        StudentData t = new StudentData("RawIncomeData.csv");
        //CountryData t1 = new CountryData(t,"Japan","2014");
        //System.out.println(t.getRow("Japan", "2014")); 
        //System.out.println(t1.giniIndex());
        System.out.println("What Country would you like to know about?");
        System.out.println("Or press x to quit");
        String n = input.nextLine();
        int l = 1;
        String[][] a = t.getFormattedData();
        if(n.equals("x"))
        {
            l = 2;
        }
        while(l == 1){
            for(int i = 1; i < a.length;i++)
            {
                String s = n;
                if(n.equals(a[i][0]))
                {
                    System.out.println("What year would you like to know about? Or Press x to quit");
                    n = input.nextLine();
                    if(n.equals("x"))
                    {
                        System.out.println("Year not found, Thank you for playing");
                    }
                    else{
                        for(int j = 1; j < a.length; j++)
                        {
                            if(s.equals(a[j][0]) && n.equals(a[j][1]))
                            {
                                CountryData pl = new CountryData(t, s, n);
                                int x = Integer.parseInt(a[j][12]);
                                System.out.println("The country " + s + " in the year " + n + ", has a mean income of " + x + ",with a population of " + pl.getPop() + ", with a gini Index " + pl.giniIndex());
                                System.out.println("Please select another country?Or press x to quit");
                                n = input.nextLine();
                                if(n.equals("x"))
                                {
                                    System.out.println("GAME OVER, THANK YOU FOR PLAYING");
                                }
                                else{
                                    l = 1;
                                }
                            }
                        } 

                    } 
              
                } 
            }
        }
        if(l == 2)
        {
            System.out.println("GAME OVER. THANK YOU FOR PLAYING");
        }
  }
}
