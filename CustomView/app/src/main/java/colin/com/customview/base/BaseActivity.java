package colin.com.customview.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.ButterKnife;
import colin.com.customview.R;


public abstract class BaseActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setUp();


    }

    public abstract int getLayoutId() ;

    public abstract void setUp();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
                                