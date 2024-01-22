package com.example.divisasrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView inputText;
    TextView resultadoConversion;
    Button convertidor;

    CardView cvDivisas;

    String cvValor;

    ArrayList<DivisaModel> divisaModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.historicEventModelRecycleView);
        setDivisaEventModel();

        DivisaRVAdapter adapter = new DivisaRVAdapter(this, divisaModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setDivisaEventModel(){

        String[] eventNames = getResources().getStringArray(R.array.nombres_divisas);
        String[] eventValor = getResources().getStringArray(R.array.valor_divisas);

        TypedArray ta = getResources().obtainTypedArray(R.array.ic_divisas);
        Drawable[] ic_divisa = new Drawable[ta.length()];

        for(int i = 0; i < ta.length(); i++){
            int id = ta.getResourceId(i, 0);
            if(id != 0){
                ic_divisa[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();

        for (int i = 0; i < eventNames.length; i++){
            divisaModels.add(new DivisaModel(
                eventNames[i],
                eventValor[i],
                ic_divisa[i]

            ));
        }

        inputText = findViewById(R.id.inputText);
        resultadoConversion = findViewById(R.id.conversion_resultado);
        convertidor = findViewById(R.id.convertir);
        cvDivisas = findViewById(R.id.cvDivisa);

        convertidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Double clienteVip = 1.02;
                    Switch switchVip = findViewById(R.id.clienteVip);

                    if(inputText.getText().toString().isBlank()){
                        Toast.makeText(MainActivity.this, "El Campo está vacío", Toast.LENGTH_SHORT).show();
                    }
                    if (DivisaRVAdapter.posicionMarcada==-1) {
                        Toast.makeText(MainActivity.this, "Selecciona una divisa", Toast.LENGTH_SHORT).show();

                    }else {
                        if(switchVip.isChecked()){
                            clienteVip = 1.0;
                        }
                        resultadoConversion.setText("" + Double.parseDouble
                                (divisaModels.get(DivisaRVAdapter.posicionMarcada).getEventValor()) *
                                Double.parseDouble(inputText.getText().toString()) * clienteVip);
                        resultadoConversion.setVisibility(View.VISIBLE);
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Coloca un valor númerico válido", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}