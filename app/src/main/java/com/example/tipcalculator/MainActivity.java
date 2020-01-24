package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText billTotalInput, tipAmountInput;
    private RadioButton onePerson, twoPerson, threePerson, fourPerson;
    private Button calculateTotal;
    private TextView tipAmountOutput, billTotalOutput, totalPerPersonOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFields();
    }

    private void initFields() {
        billTotalInput = findViewById(R.id.bill_amount_input);
        tipAmountInput = findViewById(R.id.tip_amount_input);
        onePerson = findViewById(R.id.one_person_button);
        twoPerson = findViewById(R.id.two_person_button);
        threePerson = findViewById(R.id.three_person_button);
        fourPerson = findViewById(R.id.four_person_button);
        calculateTotal = findViewById(R.id.claculateTotalButton);
        tipAmountOutput = findViewById(R.id.tip_amount_output);
        billTotalOutput = findViewById(R.id.total_amount_output);
        totalPerPersonOutput = findViewById(R.id.eachperson_output);
    }

    public void calculateTotal(View view) {
        //TODO
    }

    /**
     * What my app should do:
     * 1. User enters total cost of bill
     * 2. User enters amount of tip
     * 3. App calculates dollar amount of tip and total
     * 4. App allows bill to be split among party members and calculates how much each member owes
     */

}
