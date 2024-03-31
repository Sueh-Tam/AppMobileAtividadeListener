package com.example.atividadelistener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{

    private TextInputEditText editText;
    private TextView textview;
    private CheckBox checkBoxNegrito;
    private  CheckBox checkBoxItalico;
    private  CheckBox checkBoxMaisculo;
    private RadioGroup radioGroupButtons;
    private  SeekBar seekBar;
    private TextView SpValueView;
    private int seekValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textview = findViewById(R.id.showText);
        checkBoxItalico = findViewById(R.id.checkBoxItalico);
        checkBoxMaisculo = findViewById(R.id.checkBoxMaiusculo);
        checkBoxNegrito = findViewById(R.id.checkBoxNegrito);
        radioGroupButtons = findViewById(R.id.radioGroup);
        seekBar = findViewById(R.id.seekBar);
        SpValueView = findViewById(R.id.SpValue);
        Button buttonAplicarEfeitos = findViewById(R.id.buttonAplicarEfeitos);

        buttonAplicarEfeitos.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String textoInserido = editText.getText().toString();


                SetTextStyle(textoInserido);
                SetTextColor(radioGroupButtons);
                ChangeTextSize();

            }

            public void SetTextColor(RadioGroup radioGroupButtons){

                int selectId = radioGroupButtons.getCheckedRadioButtonId();
                RadioButton Botao = findViewById(selectId);;

                if(Botao.getTag().toString().equals("RED")){
                    textview.setTextColor(Color.RED);
                }else if(Botao.getTag().toString().equals("GREEN")) {
                    textview.setTextColor(Color.GREEN);
                }else if(Botao.getTag().toString().equals("BLUE")){
                    textview.setTextColor(Color.BLUE);
                }else{
                    textview.setTextColor(Color.BLACK);
                }

            }
            public void SetTextStyle(String textoInserido){
                int style = Typeface.NORMAL;

                if(checkBoxNegrito.isChecked()){
                    style |= Typeface.BOLD;
                }
                if(checkBoxItalico.isChecked()){
                    style |= Typeface.ITALIC;
                }
                textview.setTypeface(null,style);
                if(checkBoxMaisculo.isChecked()){
                    textview.setText(textoInserido.toUpperCase());

                }else{
                    textview.setText(textoInserido.toLowerCase());
                }
            }
            public void ChangeTextSize(){
                //float TextSize = Float.parseFloat(textview.getText().toString()+"f");
                //textview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50f);
                textview.setTextSize(seekValue);
            }

        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekValue = progress;
                SpValueView.setText("Sp: " + String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }


}