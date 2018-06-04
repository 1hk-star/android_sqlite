package org.androidtown.test_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ListView listView;
    SingerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        adapter = new SingerAdapter();

        adapter.addItem(new SingerItem("소녀시대", "010-1000-1000", 20, R.drawable.singer));
        adapter.addItem(new SingerItem("걸스데이", "010-2000-2000", 22, R.drawable.singer2));
        adapter.addItem(new SingerItem("여자친구", "010-3000-3000", 21, R.drawable.singer3));
        adapter.addItem(new SingerItem("티아라", "010-4000-4000", 24, R.drawable.singer4));
        adapter.addItem(new SingerItem("AOA", "010-5000-5000", 25, R.drawable.singer5));

        listView.setAdapter(adapter);


        editText = (EditText) findViewById(R.id.editText);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                String mobile = "010-1000-1000";
                int age = 20;

                adapter.addItem(new SingerItem(name, mobile, age, R.drawable.singer3));
                adapter.notifyDataSetChanged();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    //어댑터 클래스 작성
    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        //아이템이 몇개인지 반환
        @Override
        public int getCount() {

            return items.size();
        }

        public void addItem(SingerItem item) {

            items.add(item);
        }

        //몇번째 아이템인지 반환
        @Override
        public Object getItem(int position) {

            return items.get(position);
        }

        //아이템의 아이디 반환
        @Override
        public long getItemId(int position) {
            return position;
        }

        //getView()는 어댑터가 가지고 있는 data를 어떻게 보여줄 것인가를 정의한다.
        //listview가 각각의 list item을 그릴때 어댑터에게 어떻게 그려야 할 지 물을때 호출된다.
        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            SingerItemView view = new SingerItemView(getApplicationContext());
            //반환되는 리스트 수가 많을 경우 부담이된다.
            //컨버트뷰를 재사용한다.
            //convertView는 이전에 사용했던 데이터이다.
            //SingerItemView view = null;
            //if (convertView == null){
            //  view = new SingerItemView(getApplicationContext());
            //} else {
            //      view = (SingerItemView) convertView;
            //}

            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setAge(item.getAge());
            view.setImage(item.getResId());

            return view;
        }
    }

}