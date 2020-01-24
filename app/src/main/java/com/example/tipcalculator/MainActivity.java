package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private EditText billTotalInput, tipAmountInput;
    private RadioButton onePerson, twoPerson, threePerson, fourPerson;
    private TextView tipAmountOutput, billTotalOutput, totalPerPersonOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFields();
    }

    private void initFields() {
        layout = findViewById(R.id.linear_layout);
        billTotalInput = findViewById(R.id.bill_amount_input);
        tipAmountInput = findViewById(R.id.tip_amount_input);
        onePerson = findViewById(R.id.one_person_button);
        twoPerson = findViewById(R.id.two_person_button);
        threePerson = findViewById(R.id.three_person_button);
        fourPerson = findViewById(R.id.four_person_button);
        tipAmountOutput = findViewById(R.id.tip_amount_output);
        billTotalOutput = findViewById(R.id.total_amount_output);
        totalPerPersonOutput = findViewById(R.id.eachperson_output);
    }

    public void calculateTotal(View view) {
        try {
            double billTotalPreTip = Double.parseDouble(billTotalInput.getText().toString());
            int tipPercentage = Integer.parseInt(tipAmountInput.getText().toString());
            double tipAmount = billTotalPreTip * (tipPercentage / 100);
            double totalBillCost = billTotalPreTip + tipAmount;
            double costPerPerson = getCostPerPerson(totalBillCost);
            tipAmountOutput.setText("$" + tipAmount);
            billTotalOutput.setText("$" + totalBillCost);
            totalPerPersonOutput.setText("Each person would owe $" + costPerPerson);
        } catch (Exception e)
        {
            Toast.makeText(layout.getContext(), "Error: Fill in all fields", Toast.LENGTH_LONG).show();
        }
    }

    private double getCostPerPerson(double totalBillCost) {
        if(onePerson.isChecked()) {
            return totalBillCost / 1;
        } else if (twoPerson.isChecked()) {
            return totalBillCost / 2;
        } else if (threePerson.isChecked()) {
            return totalBillCost / 3;
        } else {
            return totalBillCost / 4;
        }
    }

    /**
     * What my app should do:
     * 1. User enters total cost of bill
     * 2. User enters amount of tip
     * 3. App calculates dollar amount of tip and total
     * 4. App allows bill to be split among party members and calculates how much each member owes
     */

}
