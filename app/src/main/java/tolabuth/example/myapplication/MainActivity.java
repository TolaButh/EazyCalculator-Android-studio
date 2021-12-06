package tolabuth.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText edtFirstNumber;
    private EditText edtSecondNumber;
    private Button btnCalculator;
    private TextView txtResult;
    private RadioGroup rdogOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        matchView();
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = edtFirstNumber.getText().toString();
                String second = edtSecondNumber.getText().toString();


                int rgb = rdogOperator.getCheckedRadioButtonId();
                String op ="+";
                if(first.isEmpty() || second.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please input number before Calculating", Toast.LENGTH_SHORT).show();
                }else {
                    double dbfirst = Double.parseDouble(first);
                    double dbsecond = Double.parseDouble(second);
                    double result = dbfirst + dbsecond;

                    switch (rgb){
                        case R.id.rdo_plus: result = dbfirst + dbsecond; op="+";break;
                        case R.id.rdo_substract: result = dbfirst - dbsecond;op="-";break;
                        case R.id.rdo_multiple: result = dbfirst * dbsecond; op="*";break;
                        case R.id.rdo_divide: result = dbfirst / dbsecond;op="/";break;

                    }

                    if((int)result == result){
                        DecimalFormat df = new DecimalFormat("#.##");
                        String in = df.format(result);
                        txtResult.setText(first+" "+ op+ " "+second+ " = "+String.valueOf(in));
                    }else {
                        txtResult.setText(first+" "+ op+ " "+second+ " = " + String.format("%.2f",result));
                    }

                    edtFirstNumber.requestFocus();
                    edtFirstNumber.setText("");
                    edtSecondNumber.setText("");

                }


            }
        });


    }

    private void matchView() {
        edtFirstNumber = findViewById(R.id.edt_first_number);
        edtSecondNumber = findViewById(R.id.edt_second_number);
        btnCalculator = findViewById(R.id.btn_calculator);
        txtResult = findViewById(R.id.txt_result);
        rdogOperator = findViewById(R.id.rdog_operator);

    }
}