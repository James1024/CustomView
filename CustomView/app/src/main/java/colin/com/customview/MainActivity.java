package colin.com.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import colin.com.superutil.ExecutorManager;
import colin.com.superview.CountDownView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        CountDownView countDownView=findViewById(R.id.countDownView);
        countDownView.start();


    }
}
