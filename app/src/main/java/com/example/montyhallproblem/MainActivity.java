package com.example.montyhallproblem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] portas = {"1","2","3"};
    String portaP = "";
    String portaE = "";
    String portaA = "";
    String portaF = "";
    String g = "";
    Random r = new Random();
    Button button;
    TextView txvw;
    int k = 1;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =findViewById(R.id.button);
        txvw = findViewById(R.id.textView);
        txvw.setMovementMethod(new ScrollingMovementMethod());
        spinner =  findViewById(R.id.spinnerNumeroJ);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numero_de_j, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = Integer.valueOf(spinner.getSelectedItem().toString());
                k =0;
                g ="";
                for (int i = 0; i < p; i++) {

                    portaP = portaRand();
                    portaE = portaRand();
                    portaA = "";
                    portaF = "";
                    do {
                        portaA = portaRand();
                    } while (portaA.equals(portaP) || portaA.equals(portaE));

                    do {
                        portaF = portas[r.nextInt(3)];
                    } while (portaF.equals(portaA) || portaF.equals(portaE));
                    if (portaF.equals(portaP)){
                        k++;
                    }
                    g = g + "\n P:" + portaP + " E:" + portaE + " A:" + portaA + " F:" + portaF;

                }
                txvw.setText(k+g);

            }
        });

    }


    String portaRand() {
        return portas[r.nextInt(3)];
    }
}
