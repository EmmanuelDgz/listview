

package com.emmanuel.lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView simpleList;
    String countryList[] = {
            "México",
            "Argentina",
            "Chile",
            "Perú",
            "Colombia",
            "Cuba",
            "Brazil"
    };

    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleList = findViewById(R.id.simpleListView);
        //final Button btnEdit = findViewById(R.id.btnEdit);
        //final Button btnDelete = findViewById(R.id.btnDelete);

        final ArrayList<String>  xd = new ArrayList<>(Arrays.asList(countryList));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.activity_listview, R.id.textView, xd);

        simpleList.setAdapter(arrayAdapter);

        xd.add("Ecuador");
        arrayAdapter.notifyDataSetChanged();

        final EditText editText = findViewById(R.id.editText);
        final Button button = findViewById(R.id.button);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //pos = position;
                //Toast toast = Toast.makeText(getApplicationContext(), "hola", Toast.LENGTH_SHORT);
                //toast.show();
                Log.d("hola", "dddd");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ciudad = editText.getText().toString();
                xd.add(ciudad);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        /*btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT);
                toast.show();
            }
        });*/

        //Button btnDelete = findViewById(R.id.btnDelete);
    }
}
