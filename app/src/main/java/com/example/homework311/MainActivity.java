package com.example.homework311;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView t1, t2, t3, t4;
    private EditText addLogin, addPassword;
    private Button button;
    private String login = "Ichiro_kun_kg";
    private String password = "1238";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        t1 = findViewById(R.id.mainText);
        t2 = findViewById(R.id.Login);
        t3 = findViewById(R.id.Password);
        t4 = findViewById(R.id.forgetPass);
        addLogin = findViewById(R.id.addLogin);
        addPassword = findViewById(R.id.addPassword);
        button = findViewById(R.id.log);
    }

    public void Click(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        if (addLogin.getText().toString().equals(login)) {
            if (!(addPassword.getText().toString().equals(""))) {
                int length = addPassword.getText().length();
                if (length > 16) {
                    builder.setMessage("Длинна пароля не может составлять больше 16 символов").setNegativeButton(
                            "Окей", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    addPassword.setText(null);
                                }
                            });
                } else {
                    if (addPassword.getText().toString().equals(password)) {
                        Intent intent = new Intent(MainActivity.this, Main.class);
                        startActivity(intent);
                    } else {
                        builder.setMessage("Неверный пароль, введите заново!").setNegativeButton("Окей", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                addPassword.setText(null);
                            }
                        });
                        builder.create();
                        builder.show();
                    }
                }
            } else {
                Toast.makeText(MainActivity.this, "Введите пароль!", Toast.LENGTH_SHORT).show();
            }
        } else {
            builder.setMessage("Такой учётной записи не существует!         Создать новую учётную запись?")
                    .setPositiveButton("Да, хочу.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(MainActivity.this, Register.class);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Спасибо, не надо.", null);
            builder.create();
            builder.show();
        }
    }

    public void Click1(View view) {
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }
}
