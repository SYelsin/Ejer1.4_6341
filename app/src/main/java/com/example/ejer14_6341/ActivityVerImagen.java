package com.example.ejer14_6341;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ejer14_6341.configuraciones.Datos;

import java.io.ByteArrayInputStream;

public class ActivityVerImagen extends AppCompatActivity{
    TextView nombre2, desc2;
    ImageView foto2;
    Button btAtras2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_imagen);
        btAtras2 = (Button) findViewById(R.id.btnAtras2);
        btAtras2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListaActivity.class);
                startActivity(intent);
            }
        });

        init();
        Bundle data = getIntent().getExtras();
        Datos datos = null;
        if(data != null){
            datos = (Datos) data.getSerializable("datos");

            nombre2.setText(datos.getNombre());
            desc2.setText(datos.getDescripcion());
            showPhoto(datos.getImagen());
            Bitmap bmImagen = BitmapFactory.decodeFile(datos.getPath());
            foto2.setImageBitmap(bmImagen);


        }

    }

    private void init(){
        nombre2 = findViewById(R.id.txtNombre2);
        desc2 = findViewById(R.id.txtDescripcion2);
        foto2 = findViewById(R.id.imgFoto2);

    }

    private void showPhoto(byte[] img){
        Bitmap bitmap = null;
        ByteArrayInputStream bais = new ByteArrayInputStream(img);
        bitmap = BitmapFactory.decodeStream(bais);
        foto2.setImageBitmap(bitmap);
    }


}