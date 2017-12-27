package alif.hamza.moquette.model


class Profile {

    var username: String? = null
    var password: String? = null
    var name: String? = null
    var email: String? = null
    var address: String? = null
    var phone: String? = null

    constructor(name: String, email: String, address: String, phone: String) {
        this.name = name
        this.email = email
        this.address = address
        this.phone = phone
    }

    constructor(username: String, password: String, name: String, email: String, address: String, phone: String) {
        this.username = username
        this.password = password
        this.name = name
        this.email = email
        this.address = address
        this.phone = phone
    }

    override fun toString(): String {
        return "Profile{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}'
    }
}
