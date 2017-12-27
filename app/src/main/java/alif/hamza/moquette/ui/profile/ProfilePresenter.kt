package alif.hamza.moquette.ui.profile

import com.example.computec.eltadreb.ui.base.BasePresenter
import alif.hamza.moquette.model.Profile
import alif.hamza.moquette.service.model.profile.ProfileModel
import alif.hamza.moquette.service.model.profile.ProfileModelImpl


class ProfilePresenter<V: ProfileContract.View>: BasePresenter<V>(), ProfileContract.Presenter<V>,
        ProfileModel.OnGetProfile, ProfileModel.OnPatchProfile {

    var profileModel: ProfileModel = ProfileModelImpl()

    override fun getProfile() {
        profileModel.getProfile(this)
    }

    override fun editProfile(profile: Profile) {
        profileModel.patchProfile(profile, this)
    }

    override fun onSucess(profile: Profile) {
        mvpView!!.showProfile(profile)
    }

    override fun onFailGet() {}

    override fun onSucess() {}

    override fun onFailPatch() {}
}