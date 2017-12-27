package alif.hamza.moquette.service.model.login;

public interface LoginModel {

    interface OnLoginListener {

        void succeed(String token);

        void failed();
    }

    void login(String name, String password, OnLoginListener listener);
}
