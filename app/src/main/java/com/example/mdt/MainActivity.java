package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView editTextTextPersonName15;
    private TextView editTextTextPersonName2;
    private TextView editTextTextPersonName3;
    private TextView editTextTextPersonName7;
    private TextView editTextTextPersonName8;
    private TextView editTextTextPersonName10;
    private TextView editTextTextPersonName11;
    private TextView editTextTextPersonName12;
    private TextView editTextTextPersonName13;
    private TextView editTextTextPersonName32;
    private TextView editTextTextPersonName34;
    private TextView editTextTextPersonName35;
   // private TextView editTextTextPersonName37;
 //   private TextView editTextTextPersonName50;
    private TextView editTextTextPersonName45;
    private TextView editTextTextPersonName46;
    private TextView editTextTextPersonName47;
  //  private TextView editTextTextPersonName48;
    private TextView editTextTextPersonName49;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextPersonName15 = findViewById(R.id.editTextTextPersonName15);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName7 = findViewById(R.id.editTextTextPersonName7);
        editTextTextPersonName8 = findViewById(R.id.editTextTextPersonName8);
        editTextTextPersonName10 = findViewById(R.id.editTextTextPersonName10);
        editTextTextPersonName11 = findViewById(R.id.editTextTextPersonName11);
        editTextTextPersonName12 = findViewById(R.id.editTextTextPersonName12);
        editTextTextPersonName13 = findViewById(R.id.editTextTextPersonName13);
        editTextTextPersonName32 = findViewById(R.id.editTextTextPersonName32);
        editTextTextPersonName34 = findViewById(R.id.editTextTextPersonName34);
        editTextTextPersonName35 = findViewById(R.id.editTextTextPersonName35);
       // editTextTextPersonName37 = findViewById(R.id.editTextTextPersonName37);
      //  editTextTextPersonName50 = findViewById(R.id.editTextTextPersonName50);
        editTextTextPersonName45 = findViewById(R.id.editTextTextPersonName45);
        editTextTextPersonName46 = findViewById(R.id.editTextTextPersonName46);
        editTextTextPersonName47 = findViewById(R.id.editTextTextPersonName47);
      //  editTextTextPersonName48 = findViewById(R.id.editTextTextPersonName48);
        editTextTextPersonName49 = findViewById(R.id.editTextTextPersonName49);

        editTextTextPersonName15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Simcard();
            }
        });


        editTextTextPersonName2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sdcard();
            }
        });

        editTextTextPersonName3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();
            }
        });

        editTextTextPersonName7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                software();
            }
        });

        editTextTextPersonName8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                network();
            }
        });

        editTextTextPersonName10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                battery();
            }
        });
        editTextTextPersonName11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Touch();
            }
        });
        editTextTextPersonName12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button();
            }
        });
        editTextTextPersonName13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mic();
            }
        });
        editTextTextPersonName32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location();
            }
        });
        editTextTextPersonName34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wifi();
            }
        });
        editTextTextPersonName35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bluetooth();
            }
        });
        /*editTextTextPersonName37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fingerprint();
            }
        });
        editTextTextPersonName50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                face();
            }
        });*/
        editTextTextPersonName45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headphones();
            }
        });

        editTextTextPersonName46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camera();
            }
        });
        editTextTextPersonName47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charging();
            }
        });
        /*editTextTextPersonName48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Speaker();
            }
        });*/

        editTextTextPersonName49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibration();
            }
        });

    }
    public void Simcard() {
        Intent intent = new Intent(MainActivity.this, Simcard.class);
        startActivity(intent);
    }

    public void Sdcard() {
        Intent intent = new Intent(MainActivity.this, SDcard.class);
        startActivity(intent);
    }
    public void restart() {
        Intent intent = new Intent(MainActivity.this, restart.class);
        startActivity(intent);
    }

    public void software() {
        Intent intent = new Intent(MainActivity.this, software.class);
        startActivity(intent);
    }

    public void network() {
        Intent intent = new Intent(MainActivity.this, Network.class);
        startActivity(intent);
    }

    public void battery() {
        Intent intent = new Intent(MainActivity.this, battery.class);
        startActivity(intent);
    }

    public void Touch() {
        Intent intent = new Intent(MainActivity.this, Touch.class);
        startActivity(intent);
    }

    public void Button() {
        Intent intent = new Intent(MainActivity.this, Button.class);
        startActivity(intent);
    }

    public void Mic() {
        Intent intent = new Intent(MainActivity.this, Mic.class);
        startActivity(intent);
    }

    public void location() {
        Intent intent = new Intent(MainActivity.this, location.class);
        startActivity(intent);
    }

    public void wifi() {
        Intent intent = new Intent(MainActivity.this, wifi.class);
        startActivity(intent);
    }

    public void Bluetooth() {
        Intent intent = new Intent(MainActivity.this, Bluetooth.class);
        startActivity(intent);
    }

   /* public void fingerprint() {
        Intent intent = new Intent(MainActivity.this, fingerprint.class);
        startActivity(intent);
    }

    public void face() {
        Intent intent = new Intent(MainActivity.this, face.class);
        startActivity(intent);
    }*/

    public void headphones() {
        Intent intent = new Intent(MainActivity.this, headphones.class);
        startActivity(intent);
    }

    public void camera() {
        Intent intent = new Intent(MainActivity.this, camera.class);
        startActivity(intent);
    }

    public void charging() {
        Intent intent = new Intent(MainActivity.this, charging.class);
        startActivity(intent);
    }

    /*public void Speaker() {
        Intent intent = new Intent(MainActivity.this, Speaker.class);
        startActivity(intent);
    }*/

    public void Vibration() {
        Intent intent = new Intent(MainActivity.this, Vibration.class);
        startActivity(intent);
    }
}






