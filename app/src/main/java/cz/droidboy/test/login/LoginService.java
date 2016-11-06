package cz.droidboy.test.login;

public class LoginService {
  public boolean login(String username, String password) {
    return "john".equals(username) && "doe".equals(password);
  }
}
