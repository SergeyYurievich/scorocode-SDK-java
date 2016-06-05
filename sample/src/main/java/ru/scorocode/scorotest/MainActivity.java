package ru.scorocode.scorotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.api.response.entity.RegistrationResponseEntity;
import ru.scorocode.android.main.SC;
import ru.scorocode.android.model.User;

public class MainActivity extends AppCompatActivity {

    private SCCallback<RegistrationResponseEntity> callback = new SCCallback<RegistrationResponseEntity>() {
        @Override
        public void onSuccess(RegistrationResponseEntity result) {
            showToast("Success, registered username " + result.getUsername());
        }

        @Override
        public void onError(String message) {
            showToast("Error: " + message);
        }
    };

    private EditText username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SC.init("81b82b7cbaf832868d04bd9ed4af715c", "4593340dfeba5e3d724a71b992ef9bfb", null, null, null);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });


    }

    public void signup() {
        String us = username.getText().toString();
        String em = email.getText().toString();
        String pas = password.getText().toString();

        if (TextUtils.isEmpty(us) || TextUtils.isEmpty(em) || TextUtils.isEmpty(pas)) {
            showToast("Please fill in all fields");
            return;
        }

        User user = new User("user1");
        user.register(callback, us, em, pas);
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
