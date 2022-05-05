package com.stebanramos.appmuestra;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final double z = 1.96; //confianza
    private final double p = 0.5;
    private final double q = 0.5;
    private double e = 0.05; //error formula residencial
    private double E = 50; //error formula no residencial
    private double V = 200; //Varianza


    EditText etUrbEstrato1;
    EditText etUrbEstrato2;
    EditText etUrbEstrato3;
    EditText etUrbEstrato4;
    EditText etUrbEstrato5;
    EditText etUrbEstrato6;

    EditText etRurEstrato1;
    EditText etRurEstrato2;
    EditText etRurEstrato3;
    EditText etRurEstrato4;
    EditText etRurEstrato5;
    EditText etRurEstrato6;

    EditText etUrbPqueño;
    EditText etUebMediano;
    EditText etUrbGrande;

    EditText etRurPqueño;
    EditText etRurMediano;
    EditText etRurGrande;

    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUrbEstrato1 = findViewById(R.id.et1Urbano);
        etUrbEstrato2 = findViewById(R.id.et2Urbano);
        etUrbEstrato3 = findViewById(R.id.et3Urbano);
        etUrbEstrato4 = findViewById(R.id.et4Urbano);
        etUrbEstrato5 = findViewById(R.id.et5Urbano);
        etUrbEstrato6 = findViewById(R.id.et6Urbano);

        etRurEstrato1 = findViewById(R.id.et1Rural);
        etRurEstrato2 = findViewById(R.id.et2Rural);
        etRurEstrato3 = findViewById(R.id.et3Rural);
        etRurEstrato4 = findViewById(R.id.et4Rural);
        etRurEstrato5 = findViewById(R.id.et5Rural);
        etRurEstrato6 = findViewById(R.id.et6Rural);

        etUrbPqueño = findViewById(R.id.etPequeñoUrbano);
        etUebMediano = findViewById(R.id.etMedianoUrbano);
        etUrbGrande = findViewById(R.id.etgrandeUrbano);

        etRurPqueño = findViewById(R.id.etPequeñoRural);
        etRurMediano = findViewById(R.id.etMedianoRural);
        etRurGrande = findViewById(R.id.etGrandeRural);

        btnCalcular = findViewById(R.id.calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int urbEstrato1 = Integer.parseInt(etUrbEstrato1.getText().toString());
                int urbEstrato2 = Integer.parseInt(etUrbEstrato2.getText().toString());
                int urbEstrato3 = Integer.parseInt(etUrbEstrato3.getText().toString());
                int urbEstrato4 = Integer.parseInt(etUrbEstrato4.getText().toString());
                int urbEstrato5 = Integer.parseInt(etUrbEstrato5.getText().toString());
                int urbEstrato6 = Integer.parseInt(etUrbEstrato6.getText().toString());

                int UsersResiUrb = urbEstrato1 + urbEstrato2 + urbEstrato3 + urbEstrato4 + urbEstrato5 + urbEstrato6;
                int resulResidencialUrb = (int) Math.ceil(getMuestraResidencial(UsersResiUrb));

                urbEstrato1 = (int) Math.ceil(getMuestraCategorias(UsersResiUrb, urbEstrato1, resulResidencialUrb));
                urbEstrato2 = (int) Math.ceil(getMuestraCategorias(UsersResiUrb, urbEstrato2, resulResidencialUrb));
                urbEstrato3 = (int) Math.ceil(getMuestraCategorias(UsersResiUrb, urbEstrato3, resulResidencialUrb));
                urbEstrato4 = (int) Math.ceil(getMuestraCategorias(UsersResiUrb, urbEstrato4, resulResidencialUrb));
                urbEstrato5 = (int) Math.ceil(getMuestraCategorias(UsersResiUrb, urbEstrato5, resulResidencialUrb));
                urbEstrato6 = (int) Math.ceil(getMuestraCategorias(UsersResiUrb, urbEstrato6, resulResidencialUrb));

                int rurEstrato1 = Integer.parseInt(etRurEstrato1.getText().toString());
                int rurEstrato2 = Integer.parseInt(etRurEstrato2.getText().toString());
                int rurEstrato3 = Integer.parseInt(etRurEstrato3.getText().toString());
                int rurEstrato4 = Integer.parseInt(etRurEstrato4.getText().toString());
                int rurEstrato5 = Integer.parseInt(etRurEstrato5.getText().toString());
                int rurEstrato6 = Integer.parseInt(etRurEstrato6.getText().toString());

                int usersResiRur = rurEstrato1 + rurEstrato2 + rurEstrato3 + rurEstrato4 + rurEstrato5 + rurEstrato6;
                int resulResidencialRur = (int) Math.ceil(getMuestraResidencial(usersResiRur));

                rurEstrato1 = (int) Math.ceil(getMuestraCategorias(usersResiRur, rurEstrato1, resulResidencialRur));
                rurEstrato2 = (int) Math.ceil(getMuestraCategorias(usersResiRur, rurEstrato2, resulResidencialRur));
                rurEstrato3 = (int) Math.ceil(getMuestraCategorias(usersResiRur, rurEstrato3, resulResidencialRur));
                rurEstrato4 = (int) Math.ceil(getMuestraCategorias(usersResiRur, rurEstrato4, resulResidencialRur));
                rurEstrato5 = (int) Math.ceil(getMuestraCategorias(usersResiRur, rurEstrato5, resulResidencialRur));
                rurEstrato6 = (int) Math.ceil(getMuestraCategorias(usersResiRur, rurEstrato6, resulResidencialRur));

                int urbPqueño = Integer.parseInt(etUrbPqueño.getText().toString());
                int urbMediano = Integer.parseInt(etUebMediano.getText().toString());
                int urrbGrande = Integer.parseInt(etUrbGrande.getText().toString());

                int usersNoResiUrb = urbPqueño + urbMediano + urrbGrande;
                int resulNoResiUrb = (int) Math.ceil(getMuestraNoResidencial(usersNoResiUrb));

                urbPqueño = (int) Math.ceil(getMuestraCategorias(usersNoResiUrb, urbPqueño, resulNoResiUrb));
                urbMediano = (int) Math.ceil(getMuestraCategorias(usersNoResiUrb, urbMediano, resulNoResiUrb));
                urrbGrande = (int) Math.ceil(getMuestraCategorias(usersNoResiUrb, urrbGrande, resulNoResiUrb));

                int rurPqueño = Integer.parseInt(etRurPqueño.getText().toString());
                int rurMediano = Integer.parseInt(etRurMediano.getText().toString());
                int rurGrande = Integer.parseInt(etRurGrande.getText().toString());

                int usersNoResiRur = rurPqueño + rurMediano + rurGrande;
                int resulNoResiRur = (int) Math.ceil(getMuestraNoResidencial(usersNoResiRur));

                rurPqueño = (int) Math.ceil(getMuestraCategorias(usersNoResiRur, rurPqueño, resulNoResiRur));
                rurMediano = (int) Math.ceil(getMuestraCategorias(usersNoResiRur, rurMediano, resulNoResiRur));
                rurGrande = (int) Math.ceil(getMuestraCategorias(usersNoResiRur, rurGrande, resulNoResiRur));

                Log.d("funciones", "Muestra Residencial");

                Log.d("funciones", "Estrato 1 - Urbano: " + urbEstrato1 + " Rural: " + rurEstrato1);
                Log.d("funciones", "Estrato 2 - Urbano: " + urbEstrato2 + " Rural: " + rurEstrato2);
                Log.d("funciones", "Estrato 3 - Urbano: " + urbEstrato3 + " Rural: " + rurEstrato3);
                Log.d("funciones", "Estrato 4 - Urbano: " + urbEstrato4 + " Rural: " + rurEstrato4);
                Log.d("funciones", "Estrato 5 - Urbano: " + urbEstrato5 + " Rural: " + rurEstrato5);
                Log.d("funciones", "Estrato 6 - Urbano: " + urbEstrato6 + " Rural: " + rurEstrato6);

                Log.d("funciones", "Total - Urbano: " + resulResidencialUrb + " Rural: " + resulResidencialRur);

                Log.d("funciones", "Muestra no Residencial");

                Log.d("funciones", "Pequeño - Urbano: " + urbPqueño + "  Rural: " + rurPqueño);
                Log.d("funciones", "Mediano - Urbano: " + urbMediano + " Rural: " + rurMediano);
                Log.d("funciones", "Grande  - Urbano: " + urrbGrande + " Rural: " + rurGrande);

                Log.d("funciones", "Total - Urbano: " + resulNoResiUrb + " Rural: " + resulNoResiRur);

                String result = "Muestra Residencial \n" +
                        "Estrato 1 - Urbano: " + urbEstrato1 + " Rural: " + rurEstrato1 + "\n" +
                        "Estrato 2 - Urbano: " + urbEstrato2 + " Rural: " + rurEstrato2 + "\n" +
                        "Estrato 3 - Urbano: " + urbEstrato3 + " Rural: " + rurEstrato3 + "\n" +
                        "Estrato 4 - Urbano: " + urbEstrato4 + " Rural: " + rurEstrato4 + "\n" +
                        "Estrato 5 - Urbano: " + urbEstrato5 + " Rural: " + rurEstrato5 + "\n" +
                        "Estrato 6 - Urbano: " + urbEstrato6 + " Rural: " + rurEstrato6 + "\n" +
                        "Total - Urbano: " + resulResidencialUrb + " Rural: " + resulResidencialRur + "\n" +
                        "Muestra no Residencial" + "\n" +
                        "Pequeño - Urbano: " + urbPqueño + "  Rural: " + rurPqueño + "\n" +
                        "Mediano - Urbano: " + urbMediano + " Rural: " + rurMediano + "\n" +
                        "Grande  - Urbano: " + urrbGrande + " Rural: " + rurGrande + "\n" +
                        "Total - Urbano: " + resulNoResiUrb + " Rural: " + resulNoResiRur;

                Log.d("funciones", result);

                // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage(result)
                        .setTitle("resultado número de muestras");

                // 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
                AlertDialog dialog = builder.create();

                dialog.show();

            }
        });

    }

    public double getMuestraResidencial(int N) {
        double n = 0; // numero de muestras

        n = (N * Math.pow(z, 2) * p * q) / (Math.pow(e, 2) * (N - 1) + (Math.pow(z, 2) * p * q));

        return n;
    }

    public double getMuestraNoResidencial(int N) {
        double n = 0; // numero de muestras

        n = Math.pow(V, 2) / ((Math.pow((E / z), 2)) + (Math.pow(V, 2) / N));

        return n;
    }


    public double getMuestraCategorias(int N, double N1, double n) {
        double n1 = 0; // numero de muestras

        double w = N1 / N;

        n1 = n * w;

        return n1;
    }


}