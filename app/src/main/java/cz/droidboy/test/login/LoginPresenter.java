package cz.droidboy.test.login;

import android.support.annotation.NonNull;

import cz.droidboy.test.R;

import static cz.droidboy.test.login.LoginContract.View;

/**
 * @author Jonáš Ševčík
 */

public class LoginPresenter implements LoginContract.UserActionsListener {
    private View view;
    private LoginService service;

    public LoginPresenter(View view, LoginService service) {
        this.view = view;
        this.service = service;
    }

    public void onLoginClicked(@NonNull String username, @NonNull String password) {
        if (username.isEmpty()) {
            view.showUsernameError(R.string.username_error);
            return;
        }
        if (password.isEmpty()) {
            view.showPasswordError(R.string.password_error);
            return;
        }
        boolean loginSucceeded = service.login(username, password);
        if (loginSucceeded) {
            view.startMainActivity();
            return;
        }
        view.showLoginError(R.string.login_failed);
    }
}
