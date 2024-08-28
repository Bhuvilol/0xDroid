package com.example.mycustomtoast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button btnToast;
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

        //Toast.makeText(getApplicationContext(), "My custom Toast", Toast.LENGTH_LONG).show();


        btnToast.setOnClickListener(v -> {
            Toast toast = new Toast(getApplicationContext());

            View view = getLayoutInflater().inflate(R.layout.custom_toast_layout, findViewById(R.id.viewcontainer));

            toast.setView(view);

            TextView textmsg = view.findViewById(R.id.textmsg);

            textmsg.setText("Message sent successfully");

            toast.setDuration(Toast.LENGTH_LONG);

            toast.setGravity(Gravity.CENTER, 0, 0);

            toast.show();
        });

    }
}