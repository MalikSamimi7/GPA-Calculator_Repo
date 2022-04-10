package com.samimi.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    LinearLayout layoutlist;
    Button gpa;
    Button add;
    TextView gpatext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutlist = findViewById(R.id.layout_list);
        gpa = findViewById(R.id.btn1);
        add = findViewById(R.id.btn2);
        gpatext=findViewById(R.id.gpatext);

   /*     btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv.setText("clicked GPA");
            }
        });
    }*/

        gpa.setOnClickListener(this);
        add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btn1) {

            getgpa();
        }
        if(v.getId()==R.id.btn2) {

            addview();
        }

    }

    private void getgpa() {

        String finalmarks = "";
        int mymarks=0;
        String subjects = "";
        EditText childsubject=null;
        String credits = "";
        int totalcred=1;

        ViewGroup list=findViewById(R.id.layout_list);
        for(int i=0;i<layoutlist.getChildCount();i++)
        {
          View childview=layoutlist.getChildAt(i);


          childsubject=childview.findViewById(R.id.subject);
          EditText marks=childview.findViewById(R.id.marks);
          EditText credit=childview.findViewById(R.id.credits);

          finalmarks+=marks.getText().toString();
          credits+=credit.getText().toString();
          subjects += childsubject.getText().toString();




          //


          subjects+="\n";
          credits+="\n";
          finalmarks+="\n";


        }



        int i=0;
        int arrcredit[] = new int[10];
        for(String numstring : credits.split("[^0-9]+"))
        {
            if(!numstring.isEmpty())
            {
               totalcred+=Integer.parseInt(numstring);
               arrcredit[i]=Integer.parseInt(numstring);
               i++;
            }


        }





        int j=0;
        int arrmarks[] = new int[10];
        for(String numstring : finalmarks.split("[^0-9]+"))
        {
            if(!numstring.isEmpty())
            {
               // mymarks+=Integer.parseInt(numstring);
                arrmarks[j]=Integer.parseInt(numstring);

                j++;

            }


        }
         String test="";
        for (int k = 0; k < arrmarks.length; k++) {

            if(arrcredit[k]==0)
            {
                break;
            }
            mymarks+=arrcredit[k]*arrmarks[k];
        }
        totalcred--;

        if(mymarks!=0) {
            mymarks/=totalcred;
            double gpa=0;


            if(mymarks>=85)
            {
                gpa=4;
            }
           else if(mymarks>=80 && mymarks<85)
            {
                gpa=3.7;
            }
            else if(mymarks>=75 && mymarks<80)
            {
                gpa=3.3;
            }
            else if(mymarks>=70 && mymarks<75)
            {
                gpa=3;
            }
            else if(mymarks>=65 && mymarks<70)
            {
                gpa=2.7;
            }
            else if(mymarks>=60 && mymarks<65)
            {
                gpa=2.3;
            }
            else if(mymarks>=55 && mymarks<60)
            {
                gpa=2;
            }
            else if(mymarks>=50 && mymarks<55)
            {
                gpa=1.7;
            }
            else if(mymarks>=45 && mymarks<50)
            {
                gpa=1.7;
            }
            else if(mymarks>=40 && mymarks<45)
            {
                gpa=1;
            }
            else
            {
                gpa=0;
            }



            gpatext.setText("Mark's Percentage " + String.valueOf(mymarks) +"\n"+"GPA "+ gpa);
        }
    }

    private void addview()
    {

        View listview =getLayoutInflater().inflate(R.layout.linear_list,null,false);

        layoutlist.addView(listview);
    }

}