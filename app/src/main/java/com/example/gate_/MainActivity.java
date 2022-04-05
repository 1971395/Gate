package com.example.gate_;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.gate_.board.Person;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button joinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.activity_main_usernameEditText);
        passwordEditText = findViewById(R.id.activity_main_passwordEditText);
        loginButton = findViewById(R.id.activity_main_loginButton);
        joinButton = findViewById(R.id.activity_main_joinButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameEditText.getText().length() > 0 && passwordEditText.getText().length() > 0) {
                    String toastMessage = "Username: " + usernameEditText.getText().toString() + ", Password: " + passwordEditText.getText().toString();
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                } else {
                    String toastMessage = "Username or Password are not populated";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layout = new LinearLayout(MainActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                EditText edName = new EditText(MainActivity.this);
                edName.setHint("이름 입력");
                EditText edId = new EditText(MainActivity.this);
                edId.setHint("ID 입력");
                EditText edPassword = new EditText(MainActivity.this);
                edPassword.setHint("비밀번호 입력");
                EditText edPhone = new EditText(MainActivity.this);
                edPhone.setHint("전화번호 입력");

                layout.addView(edName);
                layout.addView(edId);
                layout.addView(edPassword);
                layout.addView(edPhone);

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog  .setTitle("회원가입")
                        .setView(layout)
                        .setPositiveButton("생성", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String name = edName.getText().toString();
                                String id = edId.getText().toString();
                                String password = edPassword.getText().toString();
                                String phone = edPhone.getText().toString();

                                Person person = new Person(name, id, password, phone);

                            }
                        })
                        .setNeutralButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create().show();
            }
        });
    }
}