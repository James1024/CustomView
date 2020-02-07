
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
    }
}
