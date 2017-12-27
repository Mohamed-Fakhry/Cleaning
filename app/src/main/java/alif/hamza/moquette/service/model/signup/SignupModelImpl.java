package alif.hamza.moquette.service.model.signup;

import com.google.gson.JsonObject;

import alif.hamza.moquette.App;
import alif.hamza.moquette.model.Profile;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupModelImpl implements SignupModel {

    @Override
    public void signUp(Profile profile, final OnSignupListener listener) {
        JsonObject user = new JsonObject();
        user.addProperty("username", profile.getUsername());
        user.addProperty("password", profile.getPassword());
        user.addProperty("name", profile.getName());
        user.addProperty("email", profile.getEmail());
        user.addProperty("address", profile.getAddress());
        user.addProperty("phone", profile.getPhone());
        user.addProperty("sex", "male");

        App.getService.signupService(user).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    listener.succeed();
                } else {
                    listener.failed();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.failed();
            }
        });
    }
}
