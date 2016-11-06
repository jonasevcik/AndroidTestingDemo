package cz.droidboy.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cz.droidboy.test.login.LoginService;

import static android.widget.Toast.LENGTH_SHORT;


public class LoginActivity extends AppCompatActivity {
  private EditText mUsernameView;
  private EditText mPasswordView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    mUsernameView = (EditText) findViewById(R.id.username);
    mPasswordView = (EditText) findViewById(R.id.password);
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  public void onLoginClicked(View view) {
    final String username = mUsernameView.getText().toString();
    final String password = mPasswordView.getText().toString();
    if (username.isEmpty()) {
      mUsernameView.setError(getString(R.string.username_error));
      return;
    }
    if (password.isEmpty()) {
      mPasswordView.setError(getString(R.string.password_error));
      return;
    }
    boolean loggedIn = new LoginService().login(username, password);
    if (loggedIn) {
      startActivity(new Intent(LoginActivity.this, MainActivity.class));
    } else {
      Toast.makeText(this, getString(R.string.login_failed), LENGTH_SHORT).show();
    }
  }
}
