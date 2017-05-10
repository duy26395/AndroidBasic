package com.example.duy.mtinh_;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements OnClickListener {
        float s1,s2;
        String dau;
        TextView etgiatri;
        String xuat="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etgiatri = (TextView)findViewById(R.id.kq);
        int[] idbutton = new int[]{R.id.so0, R.id.so1, R.id.so2, R.id.so3, R.id.so4, R.id.so5, R.id.so6, R.id.so7, R.id.so8, R.id.so9,
                R.id.cong, R.id.tru, R.id.nhan, R.id.chia, R.id.bang,R.id.xoa};
        for (int id : idbutton) {
            View v = (View)findViewById(id);
            v.setOnClickListener(this);
        }
    }
        public void TT () {
        s1 = Float.parseFloat(etgiatri.getText().toString());
        xuat = "";
        etgiatri.setText("");
    }
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onClick (View v){
        switch (v.getId()) {
            case R.id.cong:
                dau = "+";
                TT();
                break;
            case R.id.tru:
                dau = "-";
                TT();
                break;
            case R.id.nhan:
                dau = "*";
                TT();
                break;
            case R.id.chia:
                dau = "/";
                TT();
                break;
            case R.id.xoa:
                s1 = 0;
                s2 = 0;
                dau = null;
                etgiatri.setText(xuat);
                break;
            case R.id.bang:
                float kq = 0;
                s2 = Float.parseFloat(etgiatri.getText().toString());

                if (dau== "+") kq = s1 + s2;
                if (dau == "-") {
                    kq = s1 - s2;
                }
                if (dau == "*") {
                    kq = s1 * s2;
                }
                if (dau == "/") {
                    kq = s1 / s2;
                }
              //  etgiatri.setText(String.valueOf(kq));
                etgiatri.setText(String.valueOf(kq));
                s1 = 0.0f;
                s2 = 0.0f;
                xuat = "0";
                break;
            default:
                if(xuat.equals("0")) {
                    xuat="";
                }
                    xuat += ((Button) v).getText().toString();
                    etgiatri.setText(xuat);

        }

    }
}
