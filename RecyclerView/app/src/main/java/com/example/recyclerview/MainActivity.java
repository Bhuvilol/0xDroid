package com.example.recyclerview;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<ContactModel> arrContacts = new ArrayList<>();
RecyclerContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FloatingActionButton btnOpenDialog = findViewById(R.id.btnOpenDialog);
        btnOpenDialog.setOnClickListener(v -> {
            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.add_update_lay);
            EditText edtName = dialog.findViewById(R.id.edtName);
            EditText edtNumber = dialog.findViewById(R.id.edtNumber);
            Button btnAction = dialog.findViewById(R.id.btnAction);

            btnAction.setOnClickListener(View -> {
                String name="",number="";
                if (!edtName.getText().toString().isEmpty()) {
                    name = edtName.getText().toString();
                } else {
                    Toast.makeText(MainActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                }
                if (!edtNumber.getText().toString().isEmpty()) {
                    number = edtNumber.getText().toString();
                } else {
                    Toast.makeText(MainActivity.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
                }
                arrContacts.add(new ContactModel(name,number));
                adapter.notifyItemInserted(arrContacts.size()-1);
                recyclerView.scrollToPosition(arrContacts.size()-1);
                dialog.dismiss();
            });

            dialog.show();
        });

        recyclerView = findViewById(R.id.recyclerContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContacts.add(new ContactModel(R.drawable.boy,"A","9861347192"));
        arrContacts.add(new ContactModel(R.drawable.girl,"B","9845678901"));
        arrContacts.add(new ContactModel(R.drawable.hacker,"C","9743124592"));
        arrContacts.add(new ContactModel(R.drawable.man,"D","7771347192"));
        arrContacts.add(new ContactModel(R.drawable.man2,"E","6561347192"));
        arrContacts.add(new ContactModel(R.drawable.man3,"F","9000347192"));
        arrContacts.add(new ContactModel(R.drawable.woman,"G","9033337192"));
        arrContacts.add(new ContactModel(R.drawable.woman1,"H","6464647192"));
        arrContacts.add(new ContactModel(R.drawable.boy,"I","9869999992"));
        arrContacts.add(new ContactModel(R.drawable.girl,"J","9833333192"));
        arrContacts.add(new ContactModel(R.drawable.hacker,"K","7777347192"));
        arrContacts.add(new ContactModel(R.drawable.man,"L","933356192"));
        arrContacts.add(new ContactModel(R.drawable.man2,"M","7788947192"));
        arrContacts.add(new ContactModel(R.drawable.man3,"N","7799147192"));
        arrContacts.add(new ContactModel(R.drawable.woman,"O","9881917192"));
        arrContacts.add(new ContactModel(R.drawable.woman1,"P","9861398981"));
        arrContacts.add(new ContactModel(R.drawable.boy,"Q","9861300001"));
        arrContacts.add(new ContactModel(R.drawable.girl,"R","6767961192"));

        adapter = new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);



    }
}