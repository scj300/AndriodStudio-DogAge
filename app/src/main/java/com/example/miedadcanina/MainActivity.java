package com.example.miedadcanina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String initText = "Si fueras perro, tu edad sería de: ";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView answerText = findViewById(R.id.answer_text);
        final EditText ageEdit = findViewById(R.id.age_edit);
        ImageView dogImage = findViewById(R.id.image_src);
        Button myButton = findViewById(R.id.my_button);

        answerText.setText(initText);
        dogImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dog));

        Log.d(TAG, "La App fue creada");

        myButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String ageString = ageEdit.getText().toString();
                String resultText;

                try {
                    int ageInt = Integer.parseInt(ageString);

                    answerText.setText(String.format(getString(R.string.response), (ageInt * 6)));
                } catch (NumberFormatException e){
                    Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.error_mgs) , Toast.LENGTH_LONG);
                    toast.show();
                   // resultText = "Por favor, introduce un número entero";
                }

                //answerText.setText(resultText);
            }

        });
    }

} // End MainActivity()
