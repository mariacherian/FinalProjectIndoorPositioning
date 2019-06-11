package com.example.indoorpositioningapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageView;




public class Display extends AppCompatActivity {


    private String []stri=
            {"boson_sunya","boson_arc","boson_bohr","boson_ccf","boson_hercules","boson_library","boson_skywalk",
            "library_sunya","library_arc","library_bohr","library_boson","library_ccf","library_hercules","library_skywalk",
            "ccf_arc","ccf_skywalk","ccf_bohr","ccf_boson","ccf_hercules","ccf_library","ccf_sunya",
            "arc_skywalk","arc_ccf","arc_bohr","arc_boson","arc_hercules","arc_library","arc_sunya",
            "sunya_library","sunya_skywalk","sunya_ccf","sunya_bohr","sunya_boson","sunya_hercules","sunya_arc",
            "hercules_bohr","hercules_skywalk","hercules_boson","hercules_arc","hercules_sunya","hercules_ccf","hercules_library",
            "skywalk_ccf","skywalk_arc","skywalk_boson","skywalk_bohr","skywalk_library","skywalk_hercules","skywalk_sunya",
            "bohr_ccf","bohr_arc","bohr_boson","bohr_skywalk","bohr_library","bohr_hercules","bohr_sunya"
            };

    private Integer[][] ph={{R.drawable.boson_sunya0,R.drawable.boson_sunya1,R.drawable.boson_sunya2,R.drawable.boson_sunya3},
                            {R.drawable.boson_arc0,R.drawable.boson_arc1},
                            {R.drawable.boson_bohr0,R.drawable.boson_bohr1,R.drawable.boson_bohr2},
                            {R.drawable.boson_ccf0,R.drawable.boson_ccf1},
                            {R.drawable.boson_hercules0,R.drawable.boson_hercules1,R.drawable.boson_hercules2},
                            {R.drawable.boson_library0,R.drawable.boson_library1,R.drawable.boson_library2,R.drawable.boson_library3},
                            {R.drawable.boson_skywalk0,R.drawable.boson_skywalk1},

                            {R.drawable.library_sunya},
                            {R.drawable.library_arc0,R.drawable.library_arc1,R.drawable.library_arc2},
                            {R.drawable.library_bohr0,R.drawable.library_bohr1},
                            {R.drawable.library_boson0,R.drawable.library_boson1,R.drawable.library_boson2,R.drawable.library_boson3},
                            {R.drawable.library_ccf0,R.drawable.library_ccf1,R.drawable.library_ccf2},
                            {R.drawable.library_hercules0,R.drawable.library_hercules1},
                            {R.drawable.library_skywalk0,R.drawable.library_skywalk1,R.drawable.library_skywalk2},

                            {R.drawable.ccf_arc},
                            {R.drawable.ccf_skywalk},
                            {R.drawable.ccf_bohr0,R.drawable.ccf_bohr1},
                            {R.drawable.ccf_boson0,R.drawable.library_boson1,R.drawable.library_boson2,R.drawable.library_boson3},
                            {R.drawable.ccf_hercules0,R.drawable.ccf_hercules1},
                            {R.drawable.ccf_library0,R.drawable.ccf_library1,R.drawable.ccf_library2},
                            {R.drawable.ccf_sunya0,R.drawable.ccf_sunya1,R.drawable.ccf_sunya2},

                            {R.drawable.arc_skywalk},
                            {R.drawable.arc_ccf},
                            {R.drawable.arc_bohr0,R.drawable.arc_bohr1},
                            {R.drawable.arc_boson0,R.drawable.arc_boson1},
                            {R.drawable.arc_hercules0,R.drawable.arc_hercules1},
                            {R.drawable.arc_library0,R.drawable.arc_library1,R.drawable.arc_library2},
                            {R.drawable.arc_sunya0,R.drawable.arc_sunya1,R.drawable.arc_sunya2},


                            {R.drawable.sunya_library},
                            {R.drawable.sunya_skywalk0,R.drawable.sunya_skywalk1,R.drawable.sunya_skywalk2},
                            {R.drawable.sunya_ccf0,R.drawable.sunya_ccf1,R.drawable.sunya_ccf2},
                            {R.drawable.sunya_bohr0,R.drawable.sunya_bohr1},
                            {R.drawable.sunya_boson0,R.drawable.sunya_boson1,R.drawable.sunya_boson2,R.drawable.sunya_boson3},
                            {R.drawable.sunya_hercules0,R.drawable.sunya_hercules1},
                            {R.drawable.sunya_arc0,R.drawable.sunya_arc1},


                            {R.drawable.hercules_bohr},
                            {R.drawable.hercules_skywalk0,R.drawable.hercules_skywalk1},
                            {R.drawable.hercules_boson0,R.drawable.hercules_boson1,R.drawable.hercules_boson2},
                            {R.drawable.hercules_arc0,R.drawable.hercules_arc1},
                            {R.drawable.hercules_sunya0,R.drawable.hercules_sunya1},
                            {R.drawable.hercules_ccf0,R.drawable.hercules_ccf1},
                            {R.drawable.hercules_library0,R.drawable.hercules_library1},


                            {R.drawable.skywalk_ccf},
                            {R.drawable.skywalk_arc},
                            {R.drawable.skywalk_boson0,R.drawable.skywalk_boson1},
                            {R.drawable.skywalk_bohr0,R.drawable.skywalk_bohr1},
                            {R.drawable.skywalk_library0,R.drawable.skywalk_library1,R.drawable.skywalk_library2},
                            {R.drawable.skywalk_hercules0,R.drawable.skywalk_hercules1},
                            {R.drawable.skywalk_sunya0,R.drawable.skywalk_sunya1,R.drawable.skywalk_sunya2},


                            {R.drawable.bohr_ccf0,R.drawable.bohr_ccf1},
                            {R.drawable.bohr_arc0,R.drawable.bohr_arc1},
                            {R.drawable.bohr_boson0,R.drawable.bohr_boson1,R.drawable.bohr_boson2},
                            {R.drawable.bohr_skywalk0,R.drawable.bohr_skywalk1},
                            {R.drawable.bohr_library0,R.drawable.bohr_library1},
                            {R.drawable.bohr_hercules},
                            {R.drawable.bohr_sunya0,R.drawable.bohr_sunya1}

    };
    final  private Integer[] subarray= new Integer[10];
    int val1=0,k;
    int current =0;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2);

        Button next=findViewById(R.id.next);
        Button prev=findViewById(R.id.prev);
      Intent intent = getIntent();
      String str = intent.getStringExtra("EXTRA_SESSION_ID");


        int i,j;
        for (i = 0; i < stri.length; i++)
            if (stri[i].equals(str)) {
                if(ph[i].length==1)
                {
                    ImageView iv = findViewById(R.id.imageView);
                    iv.setImageResource(ph[i][0]);
                    break;
                }

                else
                {
                    Toast.makeText(getBaseContext(), "Length"+ph[i].length, Toast.LENGTH_SHORT).show();
                    count=ph[i].length;
                    k=0;
                    for(j=0;j<count;j++)
                    {
                        subarray[k++]= ph[i][j];
                       // Toast.makeText(getBaseContext(), "Image1 : "+subarray, Toast.LENGTH_SHORT).show();
                    }

                    ImageView iv = findViewById(R.id.imageView);
                    iv.setImageResource(ph[i][0]);
                    next.setVisibility(View.VISIBLE);
                    prev.setVisibility(View.VISIBLE);

                    break;
                }

            }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current < count - 1)
                    current = current+1;
                ImageView iv = findViewById(R.id.imageView);
                iv.setImageResource(subarray[current]);
                Toast.makeText(Display.this, "current is "+current, Toast.LENGTH_SHORT).show();
            }
        });


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current > 0)
                    current = current - 1;
                ImageView iv = findViewById(R.id.imageView);
                iv.setImageResource(subarray[current]);
            }
        });



    }







}
