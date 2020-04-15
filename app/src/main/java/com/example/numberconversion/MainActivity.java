package com.example.numberconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editdecimal,editbinary,editoctal,edithexa;
    private Button editbutton;
    private String value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editbinary =(EditText)findViewById(R.id.binary);
        editdecimal=(EditText)findViewById(R.id.Decimal);
        editoctal =(EditText)findViewById(R.id.Octal);
        edithexa=(EditText)findViewById(R.id.HexaDecimal);
        editbutton =(Button)findViewById(R.id.button);
        editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearall();
            }
        });

        editdecimal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                value = editdecimal.getText().toString().trim();

                if(value.length() > 0)
                {
                    convertmethod();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void clearall() {
        editdecimal.setText("");
        editoctal.setText("");
        editbinary.setText("");
        edithexa.setText("");
    }

    private void convertmethod() {
        try
        {
            long num = Long.parseLong(value);

            editbinary.setText(String.valueOf(Long.toBinaryString(num)));
            editoctal.setText(String.valueOf(Long.toOctalString(num)));
            edithexa.setText(String.valueOf(Long.toHexString(num)));


        }catch(NumberFormatException e)
        {
            e.printStackTrace();

        } catch(Exception e)
        {

            e.printStackTrace();
        }
    }
}
