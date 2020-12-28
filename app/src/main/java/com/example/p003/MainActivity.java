package com.example.p003;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    DecimalFormat df = new DecimalFormat("0.0");
private Button button ;
    EditText editText ;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById((R.id.button));
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                 editText =(EditText)findViewById(R.id.editText);
                 message = editText.getText().toString();
                if(message.isEmpty()){
                    setAlert();
                }
                else
                Convert();
            }
        });
    }
public void Convert(){

    Float f=Float.parseFloat(message);

    RadioGroup radioGroup = findViewById(R.id.radioGroup2) ;
    TextView textView = findViewById(R.id.textView);
    // id radiobutton checked
    int radioId=radioGroup.getCheckedRadioButtonId();
    RadioButton radioButton = findViewById(radioId);
    String checked= (String) radioButton.toString();
    //id radiobutton fahrenheit
    radioButton=findViewById(R.id.f);
    String rf= (String) radioButton.toString();
    //id radiobutton celcius
    radioButton=findViewById(R.id.c);
    String rc= (String) radioButton.toString();

    if (checked.equals(rf)){
        f=convertCelsiusToF(f);
        message=df.format(f)+"°F" ;
    }
    else if (checked.equals(rc)){
        f=convertFareheitToC(f);
        message=df.format(f)+"°C" ;
    }
    textView.setText(message);
}
    //convert celsius to farenheit
    public  static  float convertCelsiusToF(Float C){
        return ((C*9)/5)+32;
    }
    //convert  farenheit to celsius
    public  static  float convertFareheitToC(Float F){
        return ((F-32)*5/9);
    }

    public void setAlert(){
        AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Champ vide")
                .setMessage("veuillez saisir une valeur de température").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}