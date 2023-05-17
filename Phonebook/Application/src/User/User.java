package User;

public abstract class User {
    private boolean adminPrivilege;

    public User(boolean adminPrivilege){
        this.adminPrivilege = adminPrivilege;
    }

    public boolean getAdminPrivilege(){
        return adminPrivilege;
    }
}
