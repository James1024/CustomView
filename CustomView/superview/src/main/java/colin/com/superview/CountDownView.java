package colin.com.superview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

public class CountDownView extends android.support.v7.widget.AppCompatTextView {
    /**
     * 参数 millisInFuture         倒计时总时间（如30s,60S，120s等）
     * */
    public int millisInFuture;
    /**
     * 参数 countDownInterval    渐变时间（每次倒计1s）
     * */
    public int countDownInterval;
    /**
     * 倒计时结束后，按钮对应显示的文字
     * */
    public  String endStrRid;

    public CountDownView(Context context) {
        super(context);

    }

    public CountDownView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //第二个参数就是我们在styles.xml文件中的<declare-styleable>标签
        //即属性集合的标签，在R文件中名称为R.styleable+name
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CountDownView);
        //第一个参数为属性集合里面的属性，R文件名称：R.styleable+属性集合名称+下划线+属性名称
        //第二个参数为，如果没有设置这个属性，则设置的默认的值
        millisInFuture = a.getInteger(R.styleable.CountDownView_millisInFuture, 1);
        countDownInterval = a.getInteger(R.styleable.CountDownView_countDownInterval, 1);
        endStrRid = a.getString(R.styleable.CountDownView_endStrRid);
        //最后记得将TypedArray对象回收
        a.recycle();
    }

    public void start(){
        setVisibility(View.VISIBLE);
        MyCountTimer myCountTimer = new MyCountTimer();
        myCountTimer.start();
    }




    class MyCountTimer extends CountDownTimer {


        /**
         * 参数 millisInFuture         倒计时总时间（如30s,60S，120s等）
         * 参数 countDownInterval    渐变时间（每次倒计1s）
         * 参数 btn               点击的按钮(因为Button是TextView子类，为了通用我的参数设置为TextView）
         * 参数 endStrRid   倒计时结束后，按钮对应显示的文字
         */
        public MyCountTimer() {
            super(millisInFuture, countDownInterval);

        }


        /**
         * 计时完毕时触发
         */
        @Override
        public void onFinish() {
            setText(endStrRid);
            setVisibility(View.GONE);
        }

        /**
         * 计时过程显示
         */
        @Override
        public void onTick(long millisUntilFinished) {
            setEnabled(false);
            //每隔一秒修改一次UI
            setText(millisUntilFinished / 1000+"");

            // 设置透明度渐变动画
            final AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
            //设置动画持续时间
            alphaAnimation.setDuration(1000);
            startAnimation(alphaAnimation);

            // 设置缩放渐变动画
            final ScaleAnimation scaleAnimation =new ScaleAnimation(0.5f, 2f, 0.5f,2f,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            scaleAnimation.setDuration(1000);
            startAnimation(scaleAnimation);
        }
    }
}
