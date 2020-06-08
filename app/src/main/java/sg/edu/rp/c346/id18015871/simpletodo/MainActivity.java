package sg.edu.rp.c346.id18015871.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView action;
    EditText task;

    Button btnAdd;
    Button btnDel;
    Button btnClear;

    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        action = findViewById(R.id.textViewAction);
        task = findViewById(R.id.editTextTask);

        btnAdd =findViewById(R.id.buttonAdd);
        btnDel = findViewById(R.id.buttonInDelete);
        btnClear = findViewById(R.id.buttonClear);

        lst =findViewById(R.id.listTask);

        action.setText("Add a task");


        final ArrayList taskArrayList = new ArrayList<>();
        taskArrayList.add("Red");
        taskArrayList.add("Orange");

        ArrayAdapter aatask = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskArrayList);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lst.setAdapter(aatask);
                String atask = task.getText().toString();
                taskArrayList.add(colour);
                taskArrayList.notifyDataSetChanged();


            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.setText("Remove a task");
                task.setHint("Type in the index of the task to be removed");
                lst.setAdapter(aatask);
                int pos = Integer.parseInt(task.getText().toString());
                taskArrayList.remove(pos);
                taskArrayList.notifyDataSetChanged();

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskArrayList.removeAll();

            }
        });

    }
}
