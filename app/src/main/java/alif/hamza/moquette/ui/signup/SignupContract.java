package alif.hamza.moquette.ui.signup;

import com.example.computec.eltadreb.ui.base.MvpView;

import alif.hamza.moquette.model.Profile;

public interface SignupContract {

    interface View extends MvpView {

        void onSuccess();
    }

    interface Presenter {

        void validateSignupInfo(Profile profile);
    }
}
