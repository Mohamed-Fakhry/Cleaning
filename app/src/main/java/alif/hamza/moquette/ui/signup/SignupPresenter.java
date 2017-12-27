package alif.hamza.moquette.ui.signup;

import com.example.computec.eltadreb.ui.base.BasePresenter;
import com.example.computec.eltadreb.ui.base.MvpView;

import alif.hamza.moquette.model.Profile;
import alif.hamza.moquette.service.model.signup.SignupModel;
import alif.hamza.moquette.service.model.signup.SignupModelImpl;

public class SignupPresenter extends BasePresenter<MvpView>
        implements SignupContract.Presenter, SignupModel.OnSignupListener {

    private SignupContract.View signupView;
    private SignupModel signupModel;

    public SignupPresenter(SignupContract.View mvpView) {
        this.signupView = mvpView;
        this.signupModel = new SignupModelImpl();
    }

    @Override
    public void validateSignupInfo(Profile profile) {
        signupView.showLoading();
        signupModel.signUp(profile, this);
    }

    @Override
    public void succeed() {
        signupView.hideLoading();
        signupView.onSuccess();

    }

    @Override
    public void failed() {
        signupView.hideLoading();
    }
}
