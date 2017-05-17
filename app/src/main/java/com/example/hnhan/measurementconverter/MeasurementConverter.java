package com.example.hnhan.measurementconverter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Adapter;
import android.widget.TextView;


public class MeasurementConverter extends AppCompatActivity {

    //set references
    private EditText conversionEditText;
    private TextView conversionTV;
    private TextView convertFromTV;
    private TextView convertToTV;
    private Spinner spinner;
    private TextView conversionAnswer;

    private String convertOrigin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_converter);

        //get references to widgets
        conversionEditText = (EditText) findViewById(R.id.conversionEditText);
        conversionTV = (TextView) findViewById(R.id.conversionTV);
        convertFromTV = (TextView) findViewById(R.id.convertFromTV);
        convertToTV = (TextView) findViewById(R.id.convertToTV);
        spinner = (Spinner) findViewById(R.id.spinner);

        //set listeners
        conversionEditText.setOnEditorActionListener(this);
        spinner.setOnItemSelectedListener(this);

        //create array adapter for specified array and layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.conversions, android.R.layout.simple_spinner_item);

        //set the layout for the drop-down list
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //set the adapter for the spinner
        spinner.setAdapter(adapter);

        int position = spinner.getSelectedItemPosition();


    }

    //on pause

    //on resume
    public void calculateAndDisplay(int position) {
        convertOrigin = conversionEditText.getText().toString();
        float originAmount;

        if(convertOrigin.equals("")) {
            originAmount = 0;
        }
        else {
            originAmount = Float.parseFloat(convertOrigin);
        }

        switch(position) {
            case 0:
                originAmount * 1.6093;
                break;
            case 1:
                originAmount * 0.6214;
                break;
            case 2:
                originAmount * 2.54;
                break;
            case 3:
                originAmount * 0.3937;
                break;
            default:
                originAmount * 1.6093;
                break;
        }
    }



        /*Spinner spinner = (Spinner) findViewById(R.id.spinner);
        //create an arrayadapter using the string array and a def spinner layout
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.conversions, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //apply the adapter the spinner
        spinner.setAdapter(adapter);
//        public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
//            public void OnItemSelected(AdapterView<?>parent, View view, int pos, long id){
//                //An item was selected , you can retrieve the selected item using
//                //parent.getItemAtPosition(pos)
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//                //another interface callback
//            }

        }

//
//    }*/


}
