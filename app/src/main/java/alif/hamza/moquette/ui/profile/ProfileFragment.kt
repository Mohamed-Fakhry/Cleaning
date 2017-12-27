package alif.hamza.moquette.ui.profile


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.computec.eltadreb.ui.base.BaseFragment
import alif.hamza.moquette.R
import alif.hamza.moquette.model.Profile
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment(), ProfileContract.View {

    lateinit var profilePresenter: ProfileContract.Presenter<ProfileFragment>
    lateinit var profile: Profile

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_profile, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun setUp(view: View?) {
        profilePresenter = ProfilePresenter()
        profilePresenter.onAttach(this)
        profilePresenter.getProfile()
        activity.title = "الصفحة الشخصية"
        submitB.setOnClickListener {
            profile.name = nameET.text.toString()
            profile.email = emailET.text.toString()
            profile.address = cityET.text.toString()
            profile.phone = phoneET.text.toString()
            profilePresenter.editProfile(profile)
        }
    }

    companion object {

        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override fun showProfile(profile: Profile) {
        this.profile = profile
        nameET.setText(profile.name)
        emailET.setText(profile.email)
        cityET.setText(profile.address)
        phoneET.setText(profile.phone)
    }
}