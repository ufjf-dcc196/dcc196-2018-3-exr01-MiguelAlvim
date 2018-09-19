package miguelalvim.multactivity_exercicio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bttAluno;
    Button bttServidor;
    Button bttExterno;

    TextView txtAluno;
    TextView txtServidor;
    TextView txtExterno;

    int totAluno=0, totServidor=0, totExterno=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting Objects
        bttAluno = (Button) findViewById(R.id.bttAluno);
        bttServidor = (Button) findViewById(R.id.bttServidor);
        bttExterno = (Button) findViewById(R.id.bttExterno);

        txtAluno = (TextView) findViewById(R.id.txtAluno);
            txtAluno.setText("Alunos: 0");
        txtServidor = (TextView) findViewById(R.id.txtServidor);
            txtServidor.setText("Servidores: 0");
        txtExterno = (TextView) findViewById(R.id.txtExterno);
            txtExterno.setText("Externos: 0");

        //Action Listenners
        // recCode 0 = aluno; 1 = Servidor; 2 = Externo
        bttAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,InputActivity.class);
                intent.putExtra("txtOne", "Nome");
                intent.putExtra("txtTwo", "Matrícula");
                startActivityForResult(intent,0);
            }
        });
        bttServidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,InputActivity.class);
                intent.putExtra("txtOne", "Nome");
                intent.putExtra("txtTwo", "SIAPE");
                startActivityForResult(intent,1);
            }
        });
        bttExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,InputActivity.class);
                intent.putExtra("txtOne", "Nome");
                intent.putExtra("txtTwo", "Email");
                startActivityForResult(intent,2);
            }
        });

    }

    //Event Listenner
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case 0 :{
                if (resultCode == Activity.RESULT_OK && data != null){
                    if(data.getBooleanExtra("Add", false)) {
                        ++totAluno;
                        txtAluno.setText("Alunos: " + totAluno);
                    }
                }
            }break;
            case 1 :{
                if (resultCode == Activity.RESULT_OK && data != null){
                    if(data.getBooleanExtra("Add", false)) {
                        ++totServidor;
                        txtServidor.setText("Servidores: " + totServidor);
                    }
                }
            }break;
            case 2 :{
                if (resultCode == Activity.RESULT_OK && data != null){
                    if(data.getBooleanExtra("Add", false)) {
                        ++totExterno;
                        txtExterno.setText("Servidores: " + totExterno);
                    }
                }
            }break;
        }
    }
}
