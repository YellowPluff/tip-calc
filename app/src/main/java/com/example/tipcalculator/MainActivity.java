package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText billTotalInput, tipAmountInput;
    private RadioButton onePerson, twoPerson, threePerson, fourPerson;
    private TextView preTipAmount, tipAmountOutput, billTotalOutput, totalPerPersonOutput;

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
        preTipAmount = findViewById(R.id.pretip_amount_output);
        tipAmountOutput = findViewById(R.id.tip_amount_output);
        billTotalOutput = findViewById(R.id.total_amount_output);
        totalPerPersonOutput = findViewById(R.id.eachperson_output);
    }

    public void calculateTotal(View v) {
        try {
            double billTotalPreTip = Double.parseDouble(billTotalInput.getText().toString());
            double tipPercentage = Double.parseDouble(tipAmountInput.getText().toString());
            double tipAmount = billTotalPreTip * (tipPercentage / 100);
            double totalBillCost = billTotalPreTip + tipAmount;
            int personCount = getCostPerPerson();
            double costPerPerson = totalBillCost / personCount;
            preTipAmount.setText("$" + String.format("%.2f", billTotalPreTip));
            tipAmountOutput.setText("$" + String.format("%.2f", tipAmount));
            billTotalOutput.setText("$" + String.format("%.2f", totalBillCost));
            totalPerPersonOutput.setText("Each person(" + personCount + ") would owe $" + String.format("%.2f", costPerPerson));
        } catch (Exception e)
        {

        }
    }

    private int getCostPerPerson() {
        if(onePerson.isChecked()) {
            return 1;
        } else if (twoPerson.isChecked()) {
            return 2;
        } else if (threePerson.isChecked()) {
            return 3;
        } else {
            return 4;
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
