package com.triton_pc.printdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String shopname = "Miracle Store";
    String shopaddressl1 = "4 / 72 Moovendernagar";
    String shopaddressl2 = "Cauvery road, Chennai";
    String contactno = "Mobile no: +91 9095100105";
    String customername= "Bala Ganesh";

    int printer_colume_size = 33;

    String printstring = "";


    String top_outpot = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        top_outpot="";
        top_outpot+= fitcenter(shopname, printer_colume_size, 0);
        top_outpot+= fitcenter(shopaddressl1, printer_colume_size, 0);
        top_outpot+= fitcenter(shopaddressl2, printer_colume_size, 0);
        top_outpot+= fitcenter(contactno, printer_colume_size, 0);
        top_outpot+= fitcenter("Cash Bill", printer_colume_size, 0);
        top_outpot+= fitcenter("---------", printer_colume_size, 0);
        top_outpot+= fitLeft("C. Name: "+customername, printer_colume_size);
        top_outpot+= fitcenter("--------------------------------", printer_colume_size, 0);
        top_outpot+= fitLeftHalf("S#", 2) +fitLeftHalf("Item", printer_colume_size-18)+fitLeftHalf("Qty", 4)+fitLeftHalf("RATE", 6)+fitLeftHalf(" AMT", 6)+"\n" ;
        top_outpot+= fitcenter("--------------------------------", printer_colume_size, 0);
        int totalqty = 0;
        int total  = 0;
        for(int i = 0 ; i < 10; i ++){
            Random r = new Random();
            int qty = r.nextInt(10 - 1);
            totalqty+=qty;
            int cost = r.nextInt(100 - 10);
            int amt = cost * qty;
            total +=amt;
            top_outpot+= fitLeftHalf(""+i, 2) +fitLeftHalf("Product "+i, printer_colume_size-18)+fitLeftHalf(""+qty, 3)+" "+fitLeftHalf(""+cost+".0", 6)+" "+fitLeftHalf(""+amt+".0", 6)+"\n" ;
        }
        top_outpot+= fitcenter("--------------------------------", printer_colume_size, 0);
        top_outpot+= fitLeft("Total Qty: "+totalqty, printer_colume_size);
        top_outpot+= fitLeft("Total (Rs): "+total, printer_colume_size);
        top_outpot+= fitcenter("--------------------------------", printer_colume_size, 0);
        top_outpot+= fitcenter("THANK YOU. VISIT AGAIN.", printer_colume_size, 0);
        top_outpot+= fitcenter("FOR MORE DETAILS CONTACT US", printer_colume_size, 0);
        top_outpot+= fitcenter("MOBILE: 9095100105", printer_colume_size, 0);
        TextView value = (TextView)findViewById(R.id.value);
        value.setText(top_outpot);

        Log.v("output", "\n"+top_outpot);

    }

    public String fitcenter(String data, int length, int startpos){
        String masterdataset="";

        char[] row = new char[length];
        char[] dataarray = new char[data.length()];
        dataarray = data.toCharArray();
        String[] row_values_actual;
        String[] row_values_converted;
        int count_rows =1;

        /*
        * Find No of Rows
        * */
        if(data.length() > length)
        {
            float fva = data.length() / length;
            int iva = data.length() / length;

            if(fva>iva){
                count_rows = iva +1;
            }
            else
                count_rows = iva;
        }// Finding No Of Rows code Ends Here

        row_values_actual =new String[count_rows];
        row_values_converted =new String[count_rows];

        for(int i = 0 ;i < count_rows; i++ ){
            row_values_actual[i] = "";
            row_values_converted[i] = "";
        }
        int t_row =-1;
        for (int i = 0 ; i < data.length(); i++){
            if( i % length == 0)
            {
                t_row++;
            }

            row_values_actual[t_row] +=dataarray[i];
        }

        for (int i = 0; i < row_values_actual.length;i++){
            char[] temp = row_values_actual[i].toCharArray();

            int leftspace;
            leftspace = (length - temp.length) /2;

            for (int j = 0; j < length; j++){
                if (j <leftspace)
                {
                    row_values_converted[i] +=" ";
                }
                else if (j >=(leftspace+temp.length))
                {
                    row_values_converted[i] +=" ";
                }
                else
                {

                    row_values_converted[i] +=row_values_actual[i];
                    j += row_values_actual[i].length();

                }
            }

               for (int l = 0; l < startpos; l++)
                   masterdataset += " ";

              masterdataset += row_values_converted[i]+"\n";


        }


        return masterdataset;
    }

    public String fitLeft(String data, int length){
        String masterdataset="";

        char[] row = new char[length];
        char[] dataarray = new char[data.length()];
        dataarray = data.toCharArray();
        String[] row_values_actual;
        String[] row_values_converted;
        int count_rows =1;

        /*
        * Find No of Rows
        * */
        if(data.length() > length)
        {
            float fva = data.length() / length;
            int iva = data.length() / length;

            if(fva>iva){
                count_rows = iva +1;
            }
            else
                count_rows = iva;
        }// Finding No Of Rows code Ends Here

        row_values_actual =new String[count_rows];
        row_values_converted =new String[count_rows];

        for(int i = 0 ;i < count_rows; i++ ){
            row_values_actual[i] = "";
            row_values_converted[i] = "";
        }
        int t_row =-1;
        for (int i = 0 ; i < data.length(); i++){
            if( i % length == 0)
            {
                t_row++;
            }

            row_values_actual[t_row] +=dataarray[i];
        }

        for (int i = 0; i < row_values_actual.length;i++){
            char[] temp = row_values_actual[i].toCharArray();

            int leftspace;
            leftspace = 0;

            for (int j = 0; j < length; j++){
                if (j <leftspace)
                {
                    //row_values_converted[i] +=" ";
                }
                else if (j >=(leftspace+temp.length))
                {
                    row_values_converted[i] +=" ";
                }
                else
                {

                    row_values_converted[i] +=row_values_actual[i];
                    j += row_values_actual[i].length();

                }
            }



              masterdataset += row_values_converted[i];
              for (int l = masterdataset.length(); l < length; l++)
                masterdataset += " ";

                masterdataset += "\n";

        }


        return masterdataset;
    }
    public String fitLeftHalf(String data, int length){
        String masterdataset="";

        char[] row = new char[length];
        char[] dataarray = new char[data.length()];
        dataarray = data.toCharArray();
        String[] row_values_actual;
        String[] row_values_converted;
        int count_rows =1;

        /*
        * Find No of Rows
        * */
        if(data.length() > length)
        {
            float fva = data.length() / length;
            int iva = data.length() / length;

            if(fva>iva){
                count_rows = iva +1;
            }
            else
                count_rows = iva;
        }// Finding No Of Rows code Ends Here

        row_values_actual =new String[count_rows];
        row_values_converted =new String[count_rows];

        for(int i = 0 ;i < count_rows; i++ ){
            row_values_actual[i] = "";
            row_values_converted[i] = "";
        }
        int t_row =-1;
        for (int i = 0 ; i < data.length(); i++){
            if( i % length == 0)
            {
                t_row++;
            }

            row_values_actual[t_row] +=dataarray[i];
        }

        for (int i = 0; i < row_values_actual.length;i++){
            char[] temp = row_values_actual[i].toCharArray();

            int leftspace;
            leftspace = 0;

            for (int j = 0; j < length; j++){
                if (j <leftspace)
                {
                    //row_values_converted[i] +=" ";
                }
                else if (j >=(leftspace+temp.length))
                {
                    row_values_converted[i] +=" ";
                }
                else
                {

                    row_values_converted[i] +=row_values_actual[i];
                    j += row_values_actual[i].length();

                }
            }



              masterdataset += row_values_converted[i];
              for (int l = masterdataset.length(); l < length; l++)
                masterdataset += " ";

                masterdataset += "";

        }


        return masterdataset;
    }
}
