package com.example.pruebalab;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText editTitulo, editDescripcion, editCorreo, editPrecio, editDireccion;
    Spinner cambiarCategoria;
    Switch envio;
    SeekBar cambiarDescuento;
    CheckBox retiro, terminos;
    Pattern patronCadena, patronCorreo;
    Button botonPublicar;
    TextView descuentoActual, seleccionarCategoria;
    LinearLayout descuentoComponente, direccionComponente;
    private static final int codigoCategoria = 42241;
    Categoria categoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //=findViewById(R.id.);
        editTitulo=findViewById(R.id.editTitulo);
        editDescripcion=findViewById(R.id.editDescripcion);
        editCorreo=findViewById(R.id.editCorreo);
        editPrecio=findViewById(R.id.editPrecio);
        editDireccion=findViewById(R.id.editDireccion);
        seleccionarCategoria=findViewById(R.id.seleccionarCategoria);
        envio=findViewById(R.id.envio);
        cambiarDescuento=findViewById(R.id.cambiarDescuento);
        retiro=findViewById(R.id.retiro);
        terminos=findViewById(R.id.terminos);
        botonPublicar=findViewById(R.id.botonPublicar);
        descuentoActual=findViewById(R.id.descuentoActual);
        descuentoComponente=findViewById(R.id.descuentoComponente);
        direccionComponente=findViewById(R.id.direccionComponente);

        //https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
        patronCadena = Pattern.compile("([a-zA-Z]|\\d|,|\\.|\\n)*");
        patronCorreo = Pattern.compile("([a-zA-Z]|\\d|,|\\.|\\n)*@([a-zA-Z]|\\d|,|\\.|\\n)*.([a-zA-Z]|\\d|,|\\.|\\n)*");



        envio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ok) {
                descuentoComponente.setVisibility(ok? View.VISIBLE:View.GONE);
                descuentoActual.setVisibility(ok? View.VISIBLE:View.GONE);
            }
        });

        //https://stackoverflow.com/questions/8956218/android-seekbar-setonseekbarchangelistener
        cambiarDescuento.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int actual, boolean b) {
                descuentoActual.setText("Descuento seleccionado: " + actual + '%');
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // ????
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // ????
            }
        });

        retiro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ok) {
               direccionComponente.setVisibility(ok? View.VISIBLE:View.GONE);
            }
        });

        terminos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ok) {
                botonPublicar.setEnabled(ok);
            }
        });

        botonPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> mensajes = validar();
                if(mensajes.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Los datos cargados fueron validos, procediendo a publicar", Toast.LENGTH_SHORT).show();
                }
                else{
                    String errores = "Se cometieron los siguientes errores\n";
                    for(String m : mensajes) errores+= ("- " + m + "\n");
                    Toast.makeText(getApplicationContext(), errores, Toast.LENGTH_LONG).show();
                }
            }
        });

        seleccionarCategoria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), ActivityCategoria.class);
                    startActivityForResult(intent, codigoCategoria);
                }
            }
        );

    }

    private ArrayList<String> validar(){
        ArrayList<String> errorMsgs = new ArrayList<String>();
        if(editTitulo.getText().toString().isEmpty()){
            errorMsgs.add("El campo Titulo es obligatorio");
        }
        else{
            if(!cadenaValida(editTitulo.getText().toString())){
                errorMsgs.add("El campo Titulo solo puede contener letras, numeros, puntos o comas.");
            }
        }
        if(!cadenaValida(editDescripcion.getText().toString())){
            errorMsgs.add("El campo Descripcion solo puede contener letras, numeros, puntos o comas.");
        }
        if(!correoValido(editCorreo.getText().toString())){
            errorMsgs.add("El campo Correo posee un formato invalido");
        }

        if(seleccionarCategoria.getText().equals("Seleccionar Categoria")){
            errorMsgs.add("No se selecciono una categoria");
        }

        if(editPrecio.getText().toString().isEmpty()) {
            errorMsgs.add("El campo Precio es obligatorio");
        }
        else{
            Boolean check = true;
            String auxPrecio = editPrecio.getText().toString();
            for(int i=0; i<auxPrecio.length(); i++) if(auxPrecio.charAt(i) < '0' || auxPrecio.charAt(i)>'9') check=false;
            if(check) {
                if (Double.parseDouble(editPrecio.getText().toString()) <= 0.0) {
                    errorMsgs.add("El campo Precio debe ser mayor que $0.0");
                }
            }
            else  errorMsgs.add("El campo Precio es obligatorio");
        }
        if(envio.isChecked() && cambiarDescuento.getProgress()<=0){
            errorMsgs.add("Por favor seleccione un porcentaje mayor a 0 o quite la opcion de ofrecer descuento de envio.");
        }
        if(retiro.isChecked()){
            if(editDireccion.getText().toString().isEmpty()){
                errorMsgs.add("La direccion es obligatoria");
            }
            else if(!cadenaValida(editDireccion.getText().toString())){
                errorMsgs.add("El campo Direccion solo puede contener letras, numeros, puntos o comas.");
            }
        }

        return errorMsgs;
    }
    private Boolean cadenaValida(String cadena){
        return patronCadena.matcher(cadena).matches();
    }
    private Boolean correoValido(String correo){
        Boolean ret = patronCorreo.matcher(correo).matches();
        int cont = 0;
        for(int i = correo.length()-1; i>=0; i--){
            if(correo.charAt(i) == '@') break;
            cont++;
        }
        return ret&(cont>=3);
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == codigoCategoria) {

                seleccionarCategoria.setText(data.getExtras().getString("nombre"));
                seleccionarCategoria.setBackgroundColor(Color.parseColor(data.getExtras().getString("color")));
            }
        }
    }
}