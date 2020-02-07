package colin.com.customview;

import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import colin.com.customview.base.BaseActivity;

/**
 * @author wanglirong
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.listView)
    ListView listView;


    private List<String> list = new ArrayList<>(10);
    private List<String> list1 = new ArrayList<>(10);
    private List<String> list2= new ArrayList<>(10);
    private List<String> list3 = new ArrayList<>(10);



    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setUp() {


        list.add("RxJava2");

        listView.setAdapter(new MyAdapter(new ItemListener() {
            @Override
            public void OnClick(int position) {
                switch (list.get(position)) {
                    case "RxJava2":
                        startActivity(new Intent(MainActivity.this, RxjavaActivity.class));
                        break;
                    default:
                        break;
                }


            }
        }));

    }

    private class MyAdapter implements ListAdapter {
        ItemListener itemListener;

        public MyAdapter(ItemListener itemListener) {
            this.itemListener = itemListener;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEnabled(int position) {
            return false;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                convertView = layoutInflater.inflate(R.layout.list_item, null);
                viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) convertView.findViewById(R.id.textview);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            String name = list.get(position);
            viewHolder.textView.setText(name);
            viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.OnClick(position);
                }
            });
            return convertView;
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        @Override
        public int getViewTypeCount() {
            return list.size();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        class ViewHolder {
            public TextView textView;
        }
    }


    interface ItemListener {
        void OnClick(int position);
    }

}
