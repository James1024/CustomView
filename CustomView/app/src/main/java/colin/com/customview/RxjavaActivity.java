
package colin.com.customview;

import android.app.Activity;
import android.os.Bundle;

import colin.com.customview.base.BaseActivity;

public class RxjavaActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_rxjava;
    }

    @Override
    public void setUp() {
        System.out.println("test");
        System.out.println("test2.0.2");
        System.out.println("3.0.0");
        System.out.println("4.0.0");


    }
}
