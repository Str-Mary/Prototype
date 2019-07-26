package ru.deuteron.prototype;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DateInputActivity extends AppCompatActivity implements OnClickListener {

    Button btnInMain;
    EditText etInDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_input);

        etInDate = (EditText) findViewById(R.id.etInDate);

        btnInMain = (Button) findViewById(R.id.btnInMain);
        btnInMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent();
        intent.putExtra("date", etInDate.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
