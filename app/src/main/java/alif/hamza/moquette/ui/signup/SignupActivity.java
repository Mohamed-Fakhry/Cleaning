package alif.hamza.moquette.ui.signup;

import android.os.Bundle;
import android.widget.EditText;

import com.example.computec.eltadreb.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import alif.hamza.moquette.R;
import alif.hamza.moquette.model.Profile;

public class SignupActivity extends BaseActivity implements SignupContract.View {

    @BindView(R.id.usernameET)
    EditText usernameET;
    @BindView(R.id.passwordET)
    EditText passwordET;
    @BindView(R.id.nameET)
    EditText nameET;
    @BindView(R.id.emailET)
    EditText emailET;
    @BindView(R.id.phoneET)
    EditText phoneET;
    @BindView(R.id.cityET)
    EditText cityET;

    private SignupContract.Presenter signupPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        signupPresenter = new SignupPresenter(this);
    }



    @OnClick(R.id.signUpB)
    public void SignUp() {

        String username = usernameET.getText().toString();
        String name = nameET.getText().toString();
        String password = passwordET.getText().toString();
        String email = emailET.getText().toString();
        String phone = phoneET.getText().toString();
        String city = cityET.getText().toString();

        if (username == null || username.isEmpty()) {
            onError("Please enter username");
            return;
        }
        if (name == null || name.isEmpty()) {
            onError("Please Enter name");
            return;
        }
        if (password == null || password.isEmpty()) {
            onError("Please enter password");
            return;
        }

        Profile profile =  new Profile(username, password, name, email, city, phone);

        signupPresenter.validateSignupInfo(profile);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    protected void setUp() {

    }
}
