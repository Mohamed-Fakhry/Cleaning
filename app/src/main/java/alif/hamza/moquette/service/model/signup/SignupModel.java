package alif.hamza.moquette.service.model.signup;

import alif.hamza.moquette.model.Profile;

public interface SignupModel {

    interface OnSignupListener {

        void succeed();

        void failed();
    }

    void signUp(Profile profile, OnSignupListener listener);
}
