package com.example.action_email;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText mEditextpara;
    private EditText mEditextasunto;
    private EditText mEditextmensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditextpara = findViewById(R.id.edit_text_para);
        mEditextasunto = findViewById(R.id.edit_text_Asunto);
        mEditextmensaje = findViewById(R.id.edit_text_mensaje);

        Button buttonsend = findViewById(R.id.button_send);
        buttonsend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                    sendEmail();
            }
        });
    }

    protected void sendEmail() {
        String recipientList = mEditextpara.getText().toString();
        String[]recipients = recipientList.split(",");
        String asunto = mEditextasunto.getText().toString();
        String mensaje = mEditextmensaje.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_TEXT,asunto);
        intent.putExtra(Intent.EXTRA_TEXT,mensaje);

        intent.setType("mensaje/rfc822");
        startActivity(Intent.createChooser(intent,"Elige una opcion para enviar el mensaje"));
                
    }
}


