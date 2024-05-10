package com.example.mobile_06_professorsalario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mobile_06_professorsalario.model.Professor;
import com.example.mobile_06_professorsalario.model.ProfessorHorista;
import com.example.mobile_06_professorsalario.model.ProfessorTitular;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private TextView tvRes;
    private TextView etnHoras;
    private TextView etnAnos;
    private RadioButton rbHorista;
    private RadioButton rbTitular;
    private Button btCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etnHoras = findViewById(R.id.etnHoras);
        etnHoras.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        etnAnos = findViewById(R.id.etnAnos);
        etnAnos.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        rbHorista = findViewById(R.id.rbHorista);
        rbTitular = findViewById(R.id.rbTitular);
        btCalc = findViewById(R.id.btCalc);
        btCalc.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btCalc.setOnClickListener(op -> calc());

    }

    private void calc() {

        String res = "O salário do professor é R$";
        if(rbHorista.isChecked()){
            ProfessorHorista prof = new ProfessorHorista();
            prof.setHorasAula(Integer.parseInt(etnHoras.getText().toString()));
            double sal = prof.calcSalario();
            BigDecimal salario = BigDecimal.valueOf(sal).setScale(2, RoundingMode.HALF_UP);
            res += salario;
            etnHoras.setText("");
        }
        if (rbTitular.isChecked()){
            ProfessorTitular prof = new ProfessorTitular();
            prof.setAnosInstituicao(Integer.parseInt(etnAnos.getText().toString()));
            double sal = prof.calcSalario();
            BigDecimal salario = BigDecimal.valueOf(sal).setScale(2, RoundingMode.HALF_UP);
            res += salario;
            etnAnos.setText("");
        }

        tvRes.setText(res);


    }
}