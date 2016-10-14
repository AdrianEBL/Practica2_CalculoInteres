package edu.tecii.android.practica2_calculointeres;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.inputCapital)
    EditText inputCapital;
    @Bind(R.id.inputPercentage)
    EditText inputPercentage;
    @Bind(R.id.inputPeriod)
    EditText inputPeriod;
    @Bind(R.id.btnCalculate)
    Button btnCalculate;
    @Bind(R.id.etTotal)
    TextView etTotal;
    @Bind(R.id.etInterest)
    TextView etInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCalculate)
    public void InterestCalculated(){
        String capital = inputCapital.getText().toString();
        String percentage = inputPercentage.getText().toString();
        String period = inputPeriod.getText().toString();

        if (!capital.isEmpty() && !percentage.isEmpty() && !period.isEmpty()){
            double c = Double.parseDouble(capital);
            double pte = Double.parseDouble(percentage);
            double prd = Double.parseDouble(period);

            double amount = c * Math.pow((1+pte/100), prd);
            double intertot = amount-c;

            String total = "";
            String inte = "";
            total = "El monto total a pagar es: " + String.format("%2.2f",amount) + "";
            inte = "El interes a pagar es: " + String.format("%2.2f",intertot) + "";
            etTotal.setText(total);
            etInterest.setText(inte);
        } /*else {
            String incor = "Ingrese todos los datos necesarios";
            etTotal.setText(incor);
            etInterest.setText(incor);
        }*/
    }

}
