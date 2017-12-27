package alif.hamza.moquette.service.model.profile

import alif.hamza.moquette.model.Profile

interface ProfileModel {

    interface OnGetProfile {
        fun onSucess(profile: Profile)
        fun onFailGet()
    }

    interface OnPatchProfile {
        fun onSucess()
        fun onFailPatch()
    }

    fun getProfile(listener: OnGetProfile)
    fun patchProfile(profile: Profile ,listener: OnPatchProfile)
}