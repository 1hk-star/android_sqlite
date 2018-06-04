package org.androidtown.test_listview;

/**
 * Created by 1hk_s on 2018-06-04.
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//singer_item.xml의 최상이 레이아웃이 리니어 레이아웃이므로 이를 상속받으면 인플레이션하여 붙일수 있다?
public class SingerItemView extends LinearLayout {
    TextView textView;
    TextView textView2;
    TextView textView3;
    ImageView imageView;

    public SingerItemView(Context context) {
        super(context);
        init(context);
    }

    public SingerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        //서비스에 올라와있는 레이아웃의 객체를 가져온다.
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //this는 최상위 레이아웃인 리니어 레이아웃을 의미
        inflater.inflate(R.layout.singer_item, this, true);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void setName(String name) {
        textView.setText(name);
    }

    public void setMobile(String mobile) {
        textView2.setText(mobile);
    }

    public void setAge(int age) {
        textView3.setText(String.valueOf(age));
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}
