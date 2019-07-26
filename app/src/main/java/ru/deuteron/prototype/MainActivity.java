package ru.deuteron.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button btnInData;
    Intent intent;
    String infMsg;

    final int REQUEST_CODE_DATE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInData = (Button) findViewById(R.id.btnInData);
        btnInData.setOnClickListener(this);
    }

    public void onClick(View v){
                switch (v.getId()){
            case R.id.btnInData:
                inputDate();
                break;
            default:
                break;

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.d("myLogs", "requestCode = " + requestCode + ", resultCode = " + resultCode);
        if (resultCode == RESULT_OK){
            switch (requestCode) {
                case REQUEST_CODE_DATE:
                    int date = data.getIntExtra("date", 123456);
                    Toast.makeText(this, "Date: " + date, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
        else{
            Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show();
        }
    }

    void inputDate(){
        intent = new Intent(this, DateInputActivity.class);
        //startActivityForResult(intent, REQUEST_CODE_DATE);
        startActivity(intent);
    }
}
