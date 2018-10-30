package bd.bd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edNombre, edDocumento, edUniversidad, edEdad;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNombre = (EditText) findViewById(R.id.edNombre);
        edDocumento = (EditText) findViewById(R.id.edDocumento);
        edUniversidad = (EditText) findViewById(R.id.edUniversidad);
        edEdad = (EditText) findViewById(R.id.edEdad);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);

        final bdHelper bd = new bdHelper(getApplicationContext());

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd.nuevoUsuario(edDocumento.getText().toString(), edNombre.getText().toString(), edEdad.getText().toString(), edUniversidad.getText().toString());
                Toast.makeText(getApplicationContext(), "Se guardo correctamente", Toast.LENGTH_SHORT).show();
                edNombre.setText("");
                edDocumento.setText("");
                edUniversidad.setText("");
                edEdad.setText("");

            }
        });
    }
}







