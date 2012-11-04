import com.matchup.User

class BootStrap {

    def init = { servletContext ->
        User user = new User();
        user.username = "knight";
        user.password = "password";
        user.accountExpired = false;
        user.accountLocked = false;
        user.enabled = true;
        user.save(flush : true);
    }
    def destroy = {
    }
}
