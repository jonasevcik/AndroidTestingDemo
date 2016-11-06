package cz.droidboy.test.login;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

/**
 * @author Jonáš Ševčík
 */

public interface LoginContract {

    interface View {
        void showUsernameError(@StringRes int msg);
        void showPasswordError(@StringRes int msg);
        void showLoginError(@StringRes int msg);
        void startMainActivity();
    }

    interface UserActionsListener {
        void onLoginClicked(@NonNull String username, @NonNull String password);
    }
}
