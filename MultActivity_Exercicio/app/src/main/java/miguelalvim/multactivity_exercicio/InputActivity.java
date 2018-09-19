package miguelalvim.multactivity_exercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity {
    Button bttOk;
    EditText editOne;
    EditText editTwo;

    TextView txtOne;
    TextView txtTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        bttOk = (Button) findViewById(R.id.bttOk);
        editOne = (EditText) findViewById(R.id.editOne);
        editTwo = (EditText) findViewById(R.id.editTwo);
        txtOne = (TextView) findViewById(R.id.txtOne);
        txtTwo = (TextView) findViewById(R.id.txtTwo);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            txtOne.setText(extras.getString("txtOne"));
            txtTwo.setText(extras.getString("txtTwo"));
        }

        //Action Listenners
        bttOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("Add", (!editTwo.getText().toString().trim().equals("") &&
                        !editOne.getText().toString().trim().equals("")));
                setResult(RESULT_OK,result);
                finish();
            }
        });
    }
}
