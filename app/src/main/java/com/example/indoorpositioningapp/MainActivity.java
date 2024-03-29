package com.example.indoorpositioningapp;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    int val;
    private RadioGroup radiogroup;
    private ImageView imageviewphoto;
    private Integer []photos= {R.drawable.mapg,R.drawable.mapf,R.drawable.maps,R.drawable.mapt};
    private String[] mac={"48:4a:e9:f2:5b:40","f0:5c:19:17:a8:42","48:4a:e9:f6:2d:00","48:4a:e9:f3:4e:a0","b4:75:08:19:c3:41","48:4a:e9:f0:a7:00","48:4a:e9:f6:43:40","48:4a:e9:f6:43:40"};
    private String[] location={"library","sunya", "hercules","bohr", "skywalk", "ccf", "arc", "boson"};
    String[] names = new String[]{"library", "sunya","hercules", "bohr","skywalk", "ccf", "arc", "boson"};
    String str;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner mySpinner =findViewById(R.id.spinner1);
        final Spinner mySpinner2 =findViewById(R.id.spinner2);
        Button nav_button = findViewById(R.id.nav_button);
        this.imageviewphoto=findViewById(R.id.imageView);
        this.radiogroup= findViewById(R.id.radiogp);

       val = RunScan();
       Toast.makeText(this,"CURRENT LOCATION :"+location[val], Toast.LENGTH_SHORT).show();

        this.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

                                                       @Override
                                                       public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                           RadioButton radioButton=(RadioButton) group.findViewById(checkedId);
                                                           int index= group.indexOfChild(radioButton);
                                                           imageviewphoto.setImageResource(photos[index]);



                                                           Button refreshbtn=findViewById(R.id.refreshbtn);
        refreshbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "You have clicked Refresh button", Toast.LENGTH_SHORT).show();
            }
        });
                                                       }


                                                   });
        Button refreshbtn=findViewById(R.id.refreshbtn);
        refreshbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "You have clicked Refresh button", Toast.LENGTH_SHORT).show();
                val=RunScan();
                mySpinner.setSelection(val);
            }
        });

        final List<String> namesList = new ArrayList<>(Arrays.asList(names));

        // Initializing an ArrayAdapter
        final ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,namesList);
        mySpinner.setAdapter(spinnerArrayAdapter);
        mySpinner.setSelection(val);
       // ArrayAdapter<String>myAdapter =new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        //myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //selectSpinnerItemByValue(mySpinner,location[val]);
      //  mySpinner.setAdapter(val);



        ArrayAdapter<String>myAdapter2 =new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names2));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);



        nav_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = mySpinner.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "CURRENT LOCATION : " + s1, Toast.LENGTH_SHORT).show();
                String s2 = mySpinner2.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "TARGET LOCATION : " + s2, Toast.LENGTH_SHORT).show();
                str=s1+'_'+s2;


                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(getBaseContext(),Display.class);
               intent.putExtra("EXTRA_SESSION_ID", str);
               startActivity(intent);



            }
        });




    }


    private int RunScan() {

        WifiManager wManager;
        List<ScanResult> wifiList;
        String[] BSSID=new String[]{"killall"};
        // initiate the listadapter
        ArrayList<String> list = new ArrayList<String>();
        ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this,android.R.layout.simple_list_item_1, list);
        wManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiList = wManager.getScanResults();
        new IntentFilter(wManager.SCAN_RESULTS_AVAILABLE_ACTION);
        wManager.startScan();

        int j,flag=0;
        double mindis=0;
        String bss=null;
        int pos=0;



        for (int i = 0; i < wifiList.size(); i++) {
            ScanResult scanresult = wManager.getScanResults().get(i);
            double exp = (27.55 - (20 * Math.log10(scanresult.frequency)) + Math.abs(scanresult.level)) / 20.0;
            Math.pow(10.0, exp);
            //txv[0].setMovementMethod(new ScrollingMovementMethod());
            double dis = (Math.pow(10.0, exp) * 100.0) / 100.0;
            DecimalFormat df = new DecimalFormat("###.##");
            String id = scanresult.SSID.toString();
            String id2 = scanresult.BSSID.toString();
            list.add("SSID: "+id + "\n" +"Mac: "+ id2 + "\n" + "Estimated Distance: " + df.format(dis) + "m.\n"+"Capabilities: "+scanresult.capabilities+"\nStrength: "+scanresult.level+"db"+"\nFrequency : "+scanresult.frequency+".mhz"+"\n");
            String out = "SSID: "+id + "\n" +"Mac: "+ id2 + "\n" + "Estimated Distance: " + df.format(dis) + "m.\n"+"Capabilities: "+scanresult.capabilities+"\nStrength: "+scanresult.level+"db"+"\nFrequency : "+scanresult.frequency+".mhz"+"\n";
            Toast.makeText(this, out, Toast.LENGTH_SHORT).show();
            if(flag==0)
            {
                for(j=0;j<mac.length;j++)
                    if(mac[j].equals(id2)) {
                        bss = id2;
                        mindis=dis;
                        flag=1;
                        pos=j;

                    }
            }

           if(flag==1)
                for(j=0;j<mac.length;j++)
                    if(id2.equals(mac[j])&&(dis<mindis)) {
                        bss = id2;
                        mindis=dis;
                        pos=j;

                    }

        }

        Toast.makeText(this, String.valueOf(pos),Toast.LENGTH_LONG).show();
        return pos;
    }



}




