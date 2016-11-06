package cz.droidboy.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cz.droidboy.test.login.LoginContract;
import cz.droidboy.test.login.LoginPresenter;
import cz.droidboy.test.login.LoginService;

import static cz.droidboy.test.login.LoginContract.UserActionsListener;

import static android.widget.Toast.LENGTH_SHORT;


public class LoginActivity extends AppCompatActivity implements LoginContract.View {

  private UserActionsListener mUserActionsListener;

  private EditText mUsernameView;
  private EditText mPasswordView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    mUsernameView = (EditText) findViewById(R.id.username);
    mPasswordView = (EditText) findViewById(R.id.password);

    mUserActionsListener = new LoginPresenter(this, new LoginService());
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
    mUserActionsListener.onLoginClicked(mUsernameView.getText().toString(),
        mPasswordView.getText().toString());
  }

  @Override
  public void showUsernameError(@StringRes int msg) {
    mUsernameView.setError(getString(msg));
  }

  @Override
  public void showPasswordError(@StringRes int msg) {
    mPasswordView.setError(getString(msg));
  }

  @Override
  public void showLoginError(@StringRes int msg) {
    Toast.makeText(this, msg, LENGTH_SHORT).show();
  }

  @Override
  public void startMainActivity() {
    startActivity(new Intent(LoginActivity.this, MainActivity.class));
  }
}
