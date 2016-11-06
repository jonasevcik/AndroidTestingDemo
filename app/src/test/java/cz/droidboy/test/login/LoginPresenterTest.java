package cz.droidboy.test.login;

import cz.droidboy.test.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

/**
 * @author Jonáš Ševčík
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    private LoginContract.View loginView;
    @Mock
    private LoginService loginService;
    private LoginPresenter loginPresenter;

    @Before
    public void setUp() throws Exception {
        loginPresenter = new LoginPresenter(loginView, loginService);
    }

    @Test
    public void testOnLoginClickedCorrectData() throws Exception {
        when(loginService.login("John", "Doe")).thenReturn(true);
        loginPresenter.onLoginClicked("John", "Doe");

        verify(loginView).startMainActivity();
    }

    @Test
    public void testOnLoginClickedNoLogin() throws Exception {
        loginPresenter.onLoginClicked("", "Doe");

        verify(loginView).showUsernameError(R.string.username_error);
    }

    @Test
    public void testOnLoginClickedNoPassword() throws Exception {
        loginPresenter.onLoginClicked("John", "");

        verify(loginView).showPasswordError(R.string.password_error);
    }

    @Test
    public void testOnLoginClickedWrongData() throws Exception {
        when(loginService.login("Jane", "Doe")).thenReturn(false);
        loginPresenter.onLoginClicked("Jane", "Doe");

        verify(loginView).showLoginError(R.string.login_failed);
    }

}