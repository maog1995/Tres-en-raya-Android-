package xyz.maog.tresenraya;

import android.app.Activity;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    private int jugadores;
    private int[] CASILLAS;
    private Partida partida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iniciamos el array casillas que identifica cada casilla y la almacena en el array
        CASILLAS = new int[9];

        CASILLAS[0] = R.id.IV11;
        CASILLAS[1] = R.id.IV12;
        CASILLAS[2] = R.id.IV13;
        CASILLAS[3] = R.id.IV21;
        CASILLAS[4] = R.id.IV22;
        CASILLAS[5] = R.id.IV23;
        CASILLAS[6] = R.id.IV31;
        CASILLAS[7] = R.id.IV32;
        CASILLAS[8] = R.id.IV33;
    }

    public void aJugar(View view) {
        ImageView imagen;

        for (int cadaCasilla : CASILLAS) {
            imagen = (ImageView) findViewById((cadaCasilla));
            imagen.setImageResource(R.drawable.casilla);
        }

        jugadores = 1;

        if (view.getId() == R.id.BTN2jugador) {
            jugadores = 2;
        }

        RadioGroup configDificultad = (RadioGroup) findViewById(R.id.RGdificultad);
        int id = configDificultad.getCheckedRadioButtonId();

        int dificultad = 0;

        if (id == R.id.RBnormal) {
            dificultad = 1;
        } else if (id == R.id.RBimposible) {
            dificultad = 2;
        }

        partida = new Partida(dificultad);

        ((Button) findViewById(R.id.BTN1jugador)).setEnabled(false);

        ((RadioGroup) findViewById(R.id.RGdificultad)).setAlpha(0);

        ((Button) findViewById(R.id.BTN2jugador)).setEnabled(false);

    }
}
