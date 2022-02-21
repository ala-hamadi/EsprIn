package Utils;

import Modules.Users.*;
import Utils.Enums.AdminDepartments;
import Utils.Enums.Domaine;
import Utils.Enums.Roles;
import Utils.Enums.TypeClub;
import Utils.Structure.Classe;

public class CurrentUser {
    private static CurrentUser instance;
    private long cinUser;
    private String email;
    private String passwd;
    private String imgUrl;
    private Roles role;
    private String firstName;
    private String lastName;
    private TypeClub typeClub;
    private AdminDepartments department;
    private Domaine domaine;
    private Classe classe;
    private String entrepriseName;
    private String adresse;



    // region Admin
    public CurrentUser(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName, AdminDepartments department) {
        this.cinUser = cinUser;
        this.email = email;
        this.passwd = passwd;
        this.imgUrl = imgUrl;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public static CurrentUser getInstance(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName, AdminDepartments department) {
        if (instance == null)
            instance = new CurrentUser(cinUser, email, passwd, imgUrl, role, firstName, lastName, department);
        return instance;
    }

    //endregion

    // region Student
    public CurrentUser(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName, Domaine domaine, Classe classe) {
        this.cinUser = cinUser;
        this.email = email;
        this.passwd = passwd;
        this.imgUrl = imgUrl;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.domaine = domaine;
        this.classe = classe;
    }

    public static CurrentUser getInstance(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName, Domaine domaine, Classe classe) {
        if (instance == null)
            instance = new CurrentUser(cinUser, email, passwd, imgUrl, role, firstName, lastName, domaine, classe);
        return instance;
    }

    //endregion

    // region Professor
    public CurrentUser(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName, Domaine domaine) {
        this.cinUser = cinUser;
        this.email = email;
        this.passwd = passwd;
        this.imgUrl = imgUrl;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.domaine = domaine;
    }

    public static CurrentUser getInstance(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName, Domaine domaine) {
        if (instance == null)
            instance = new CurrentUser(cinUser, email, passwd, imgUrl, role, firstName, lastName, domaine);
        return instance;
    }

    //endregion

    //region Club
    public CurrentUser(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName, TypeClub typeClub) {
        this.cinUser = cinUser;
        this.email = email;
        this.passwd = passwd;
        this.imgUrl = imgUrl;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.typeClub = typeClub;
    }

    public static CurrentUser getInstance(long cinUser, String email, String passwd, String imgUrl, Roles role, String firstName, String lastName, TypeClub typeClub) {
        if (instance == null)
            instance = new CurrentUser(cinUser, email, passwd, imgUrl, role, firstName, lastName, typeClub);
        return instance;
    }
//endregion

    //region Extern
    public CurrentUser(long cinUser, String email, String passwd, String imgUrl, Roles role, String entrepriseName, String adresse) {
        this.cinUser = cinUser;
        this.email = email;
        this.passwd = passwd;
        this.imgUrl = imgUrl;
        this.role = role;
        this.entrepriseName = entrepriseName;
        this.adresse = adresse;
    }

    public static CurrentUser getInstance(long cinUser, String email, String passwd, String imgUrl, Roles role, String entrepriseName, String adresse) {
        if (instance == null)
            instance = new CurrentUser(cinUser, email, passwd, imgUrl, role, entrepriseName, adresse);
        return instance;
    }
//endregion

    //region Getters And Setters

    public long getCinUser() {
        return cinUser;
    }

    public void setCinUser(long cinUser) {
        this.cinUser = cinUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TypeClub getTypeClub() {
        return typeClub;
    }

    public void setTypeClub(TypeClub typeClub) {
        this.typeClub = typeClub;
    }

    public AdminDepartments getDepartment() {
        return department;
    }

    public void setDepartment(AdminDepartments department) {
        this.department = department;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String getEntrepriseName() {
        return entrepriseName;
    }

    public void setEntrepriseName(String entrepriseName) {
        this.entrepriseName = entrepriseName;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    //endregion

    public static void clearInstance() {
        instance = null;
    }
    public static CurrentUser getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "cinUser=" + cinUser +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", role=" + role +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", typeClub=" + typeClub +
                ", department=" + department +
                ", domaine=" + domaine +
                ", classe=" + classe +
                ", entrepriseName='" + entrepriseName + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
