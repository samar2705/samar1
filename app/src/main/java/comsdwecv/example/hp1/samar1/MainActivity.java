package comsdwecv.example.hp1.samar1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener ,AdapterView.OnItemLongClickListener{
    ListView lvsechedule;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrhours=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrhours.add("arabic");
        arrhours.add("hebrew");
        arrhours.add("english");


        adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,arrhours);

        lvsechedule=(ListView)findViewById(R.id.lvschedule);
        lvsechedule.setAdapter(adapter);
        lvsechedule.setBackgroundColor(Color.DKGRAY);
        lvsechedule.setOnItemClickListener(this);
        lvsechedule.setOnItemLongClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(this,arrhours.get(position),Toast.LENGTH_SHORT).show();
        }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
    {
        arrhours.remove(position);
        adapter.notifyDataSetChanged();
        return false;
    }
}
