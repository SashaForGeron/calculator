package com.example.homework6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etNum1;
    EditText etNum2;
    Button btnSum;
    Button btnRaz;
    Button btnUmn;
    Button btnDel;
    TextView tvResult;
    LinearLayout LnLayout;
    ImageView imView;
    String oper = "";
    final int MENU_RESET = 1;
    final int MENU_QUIT = 2;
    final int LIGHT_THEME = 3;
    final int DARK_THEME = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1 = findViewById(R.id.edText1);
        etNum2 = findViewById(R.id.edText2);
        btnSum = findViewById(R.id.btnSum);
        btnDel = findViewById(R.id.btnDel);
        btnRaz = findViewById(R.id.btnRaz);
        btnUmn = findViewById(R.id.btnUmn);
        tvResult = findViewById(R.id.textRes);
        LnLayout = findViewById(R.id.mLinearLayout);
        imView = findViewById(R.id.poloca);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0, MENU_RESET, 0,"reser");
        menu.add(0,MENU_QUIT, 0, "quit");
        menu.add(0,LIGHT_THEME,0,"light theme");
        menu.add(0,DARK_THEME,0,"dark theme");
        return super.onCreateOptionsMenu(menu);
    }
    public void onClick(View v){
        float num1 = 0;
        float num2 = 0;
        float result = 0;
        if(TextUtils.isEmpty(etNum1.getText().toString()) || TextUtils.isEmpty(etNum2.getText().toString())){
            return;
        }
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());
        switch (v.getId()){
            case R.id.btnSum:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnRaz:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnUmn:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnDel:
                oper = "/";
                try{
                    if(num1 == 0 || num2 == 0){
                        result = num1 / num2;
                        Toast.makeText(this, "На ноль делить нельзя", Toast.LENGTH_LONG).show();
                    }
                }
                catch (ArithmeticException e){
                }
                result = num1 / num2;
                break;

        }
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case MENU_RESET:
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("Решение:");
                Toast.makeText(this, "Поле очищено", Toast.LENGTH_LONG).show();
                break;
            case MENU_QUIT:
                finish();
                break;
            case LIGHT_THEME:
                LnLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
                btnSum.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.lightBtn)));
                btnUmn.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.lightBtn)));
                btnRaz.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.lightBtn)));
                btnDel.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.lightBtn)));
                imView.setBackgroundColor(ContextCompat.getColor(this, R.color.lightPos));
                imView.setColorFilter(ContextCompat.getColor(this, R.color.lightPos));
                break;
            case DARK_THEME:
                LnLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.dark));
                btnSum.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.darkBtn)));
                btnUmn.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.darkBtn)));
                btnRaz.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.darkBtn)));
                btnDel.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.darkBtn)));
                imView.setBackgroundColor(ContextCompat.getColor(this, R.color.darkPos));
                imView.setColorFilter(ContextCompat.getColor(this, R.color.darkPos));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}