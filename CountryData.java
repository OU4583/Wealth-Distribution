public class CountryData {
    private String name;
    private int year;
    private int pop;
    private int[] incomeDeciles;
    
    public CountryData(StudentData income, String country, String year1)
    {
        incomeDeciles = new int[10];
        int x = income.getRow(country,year1);
        String [][] a = income.getFormattedData();
        int y = Integer.parseInt(a[x][a[0].length - 1]);
        String[] b = a[x];
        int[] c = new int[10];
        int d = 0;
        for(int i = 2; i < 12; i++)
        {
            c[d] = Integer.parseInt(b[i]);
            d++;
        }
        incomeDeciles[0] = c[0];
        incomeDeciles[1] = c[1];
        incomeDeciles[2] = c[2];
        incomeDeciles[3] = c[3];
        incomeDeciles[4] = c[4];
        incomeDeciles[5] = c[5];
        incomeDeciles[6] = c[6];
        incomeDeciles[7] = c[7];
        incomeDeciles[8] = c[8];
        incomeDeciles[9] = c[9];
        pop = y;
        country = name;
        year = Integer.parseInt(year1);
    }


    public String getName()
    {
        return name;
    }
    public int getYear()
    {
        return year;
    }
    public int getPop()
    {
        return pop;
    }
    public int[] getIncomeDeciles()
    {
        return incomeDeciles;
    }
    public void setName(String name1)
    {
        name = name1;
    }
    public void setYear(int year1)
    {
        year = year1;
    }
    public void setPop(int pop1)
    {
        pop = pop1;
    }
    public void setIncomeDeciles(int[] incomeDeciles1)
    {
        incomeDeciles = incomeDeciles1;
    }
    public int totalIncome()
    {
        int x = 0;
        for(int i = 0; i < incomeDeciles.length;i++)
        {
            x += incomeDeciles[i];


        }
        return x;
    }
    public double giniIndex(){
        int x = 0;
        for(int i = 0; i < incomeDeciles.length; i++)
        {
            int start = 0;
            for(int j = 0; j <= i; j++)
            {
                start += incomeDeciles[j];
            }
            if(i == 0 || i == 9)
            {
                x += start;
            }
            else{
                x += start * 2;
            }
        }
        double sum = 0.0;
        int s = totalIncome();
        sum = 1-0.1/s * x;
        return sum;
    }

}
