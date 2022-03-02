package Services;


import Modules.*;
import Utils.BdConnection;
import Utils.CurrentUser;
import Utils.Enums.*;
import Utils.Structure.Classe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServices implements IServices<User> {
    private Connection connection;
    private static UserServices instance;

    private UserServices() throws SQLException{
        BdConnection connect = BdConnection.getInstance();
        this.connection = connect.cnx;
    }

    public static UserServices getInstance() throws SQLException{
        if (instance == null)
            instance = new UserServices();
        return instance;
    }

    @Override
    public void add(User user) {
        try {
            String query = "";
            Statement statement = connection.createStatement();
            switch (user.getRole()) {
                case Admin:
                    final Admin admin = (Admin) user;
                    query = "INSERT INTO `user` (`cinUser`, `email`, `passwd`, `createdAt`, `imgURL`, `firstName`, `lastName`, `departement`, `role`) VALUES ('" + user.getCinUser() + "', '" + user.getEmail() + "', '" + user.getPasswd() + "', current_timestamp(), '" + admin.getImgUrl() + "', '" + admin.getFirstName() + "', '" + admin.getLastName() + "', '" + admin.getDepartment() + "', '" + admin.getRole() + "');";
                    System.out.println(statement.executeUpdate(query) + " Row inserted");
                    break;
                case Etudiant:
                    final Student student = (Student) user;
                    query = "INSERT INTO `user` (`cinUser`, `email`, `passwd`, `createdAt`, `imgURL`, `firstName`, `lastName`, `domaine`, `departement`, `typeClub`, `class`, `localisation`, `entrepriseName`, `role`) VALUES ('" + student.getCinUser() + "', '" + student.getEmail() + "', '" + student.getPasswd() + "', current_timestamp(), '" + student.getImgUrl() + "', '" + student.getFirstName() + "', '" + student.getLastName() + "', '" + student.getDomaine() + "', NULL, NULL, '" + student.getClasse().toString() + "', NULL, NULL, '" + student.getRole() + "');";
                    System.out.println(statement.executeUpdate(query) + " Row inserted");
                    break;
                case Professeur:
                    final Professor professor = (Professor) user;
                    query = "INSERT INTO `user` (`cinUser`, `email`, `passwd`, `createdAt`, `imgURL`, `firstName`, `lastName`, `domaine`, `departement`, `typeClub`, `class`, `localisation`, `entrepriseName`, `role`) VALUES ('" + professor.getCinUser() + "', '" + professor.getEmail() + "', '" + professor.getPasswd() + "', current_timestamp(), '" + professor.getImgUrl() + "', '" + professor.getFirstName() + "', '" + professor.getLastName() + "', '" + professor.getDomaine() + "', NULL, NULL, NULL, NULL, NULL, '" + professor.getRole() + "');";
                    System.out.println(statement.executeUpdate(query) + " Row inserted");
                    break;
                case Externe:
                    final Extern extern = (Extern) user;
                    query = "INSERT INTO `user` (`cinUser`, `email`, `passwd`, `createdAt`, `imgURL`, `firstName`, `lastName`, `domaine`, `departement`, `typeClub`, `class`, `localisation`, `entrepriseName`, `role`) VALUES ('" + extern.getCinUser() + "', '" + extern.getEmail() + "', '" + extern.getPasswd() + "', current_timestamp(), '" + extern.getImgUrl() + "', NULL, NULL, NULL, NULL, NULL, NULL, '" + extern.getAdresse() + "', '" + extern.getEntrepriseName() + "', '" + extern.getRole() + "');";
                    System.out.println(statement.executeUpdate(query) + " Row inserted");
                    break;
                case Club:
                    final Club club = (Club) user;
                    query = "INSERT INTO `user` (`cinUser`, `email`, `passwd`, `createdAt`, `imgURL`, `firstName`, `lastName`, `domaine`, `departement`, `typeClub`, `class`, `localisation`, `entrepriseName`, `role`) VALUES ('" + club.getCinUser() + "', '" + club.getEmail() + "', '" + club.getPasswd() + "', current_timestamp(), '" + club.getImgUrl() + "', '" + club.getFirstName() + "', '" + club.getLastName() + "', NULL, NULL, '" + club.getTypeClub() + "', NULL, NULL, NULL, '" + club.getRole() + "');";
                    break;
                default:
                    System.out.println("Error,Role not defined");
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public boolean delete(User user) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE `user` SET `state` = '" + State.Deleted + "' WHERE `user`.`cinUser` = " + user.getCinUser() + ";";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        try {
            Statement statement = connection.createStatement();
            String query = "";
            switch (user.getRole()) {
                case Admin:
                    final Admin admin = (Admin) user;
                    query = "UPDATE `user` SET `firstName` = '" + admin.getFirstName() + "', `lastName` = '" + admin.getLastName() + "', `email` = '" + admin.getEmail() + "', `passwd` = '" + admin.getPasswd() + "', `imgURL` = '" + admin.getImgUrl() + "', `departement` = '" + admin.getDepartment() + "' WHERE `user`.`cinUser` = " + admin.getCinUser() + ";";
                    System.out.println(statement.executeUpdate(query) + " Row updated");
                    break;
                case Etudiant:
                    final Student student = (Student) user;
                    query = "UPDATE `user` SET `firstName` = '" + student.getFirstName() + "', `lastName` = '" + student.getLastName() + "', `email` = '" + student.getEmail() + "', `passwd` = '" + student.getPasswd() + "', `imgURL` = '" + student.getImgUrl() + "', `domaine` = '" + student.getDomaine() + "' `class`='" + student.getClasse().toString() + "' WHERE `user`.`cinUser` = " + student.getCinUser() + ";";
                    System.out.println(statement.executeUpdate(query) + " Row updated");
                    break;
                case Club:
                    final Club club = (Club) user;
                    query = "UPDATE `user` SET `firstName` = '" + club.getFirstName() + "', `lastName` = '" + club.getLastName() + "', `email` = '" + club.getEmail() + "', `passwd` = '" + club.getPasswd() + "', `imgURL` = '" + club.getImgUrl() + "', `typeClub` = '" + club.getTypeClub() + "' WHERE `user`.`cinUser` = " + club.getCinUser() + ";";
                    System.out.println(statement.executeUpdate(query) + " Row updated");
                    break;
                case Professeur:
                    final Professor professor = (Professor) user;
                    query = "UPDATE `user` SET `firstName` = '" + professor.getFirstName() + "', `lastName` = '" + professor.getLastName() + "', `email` = '" + professor.getEmail() + "', `passwd` = '" + professor.getPasswd() + "', `imgURL` = '" + professor.getImgUrl() + "', `domaine` = '" + professor.getDomaine() + "' WHERE `user`.`cinUser` = " + professor.getCinUser() + ";";
                    System.out.println(statement.executeUpdate(query) + " Row updated");
                    break;
                case Externe:
                    final Extern extern = (Extern) user;
                    query = "UPDATE `user` SET `entrepriseName` = '" + extern.getEntrepriseName() + "', `email` = '" + extern.getEmail() + "', `passwd` = '" + extern.getPasswd() + "', `imgURL` = '" + extern.getImgUrl() + "', `localisation` = '" + extern.getAdresse() + "' WHERE `user`.`cinUser` = " + extern.getCinUser() + ";";
                    System.out.println(statement.executeUpdate(query) + " Row updated");
                    break;
                default:
                    System.out.println("Error,Role not defined");
            }
            return true;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public List<User> getList() {
        List<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM `user` WHERE `state`<>'Deleted'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                switch (Roles.valueOf(resultSet.getString("role"))) {
                    case Admin:
                        Admin admin = new Admin(resultSet.getInt("cinUser"), resultSet.getString("email"), resultSet.getString("passwd"), resultSet.getString("imgURL"), Roles.Admin, resultSet.getString("firstName"), resultSet.getString("lastName"), AdminDepartments.valueOf(resultSet.getString("departement")));
                        admin.setState(State.valueOf(resultSet.getString("state")));
                        admin.setCreatedAt(resultSet.getDate("createdAt"));
                        users.add(admin);
                        break;
                    case Club:
                        Club club = new Club(resultSet.getInt("cinUser"), resultSet.getString("email"), resultSet.getString("passwd"), resultSet.getString("imgURL"), Roles.Club, resultSet.getString("firstName"), resultSet.getString("lastName"), TypeClub.valueOf(resultSet.getString("typeClub")));
                        users.add(club);
                        club.setState(State.valueOf(resultSet.getString("state")));
                        club.setCreatedAt(resultSet.getDate("createdAt"));
                        break;
                    case Etudiant:
                        String[] classString = resultSet.getString("class").split(" ");
                        Classe classe = new Classe(Integer.parseInt(classString[0]), classString[1], Integer.parseInt(classString[2]));
                        Student student = new Student(resultSet.getInt("cinUser"), resultSet.getString("email"), resultSet.getString("passwd"), resultSet.getString("imgURL"), Roles.Etudiant, resultSet.getString("firstName"), resultSet.getString("lastName"), classe, Domaine.valueOf(resultSet.getString("domaine")));
                        student.setState(State.valueOf(resultSet.getString("state")));
                        student.setCreatedAt(resultSet.getDate("createdAt"));
                        users.add(student);
                        break;
                    case Professeur:
                        Professor professor = new Professor(resultSet.getInt("cinUser"), resultSet.getString("email"), resultSet.getString("passwd"), resultSet.getString("imgURL"), Roles.Professeur, resultSet.getString("firstName"), resultSet.getString("lastName"), Domaine.valueOf(resultSet.getString("domaine")));
                        professor.setState(State.valueOf(resultSet.getString("state")));
                        professor.setCreatedAt(resultSet.getDate("createdAt"));
                        users.add(professor);
                        break;
                    case Externe:
                        Extern extern = new Extern(resultSet.getInt("cinUser"), resultSet.getString("email"), resultSet.getString("passwd"), resultSet.getString("imgURL"), Roles.Externe, resultSet.getString("entrepriseName"), resultSet.getString("localisation"));
                        extern.setState(State.valueOf(resultSet.getString("state")));
                        extern.setCreatedAt(resultSet.getDate("createdAt"));
                        users.add(extern);
                        break;
                    default:
                        System.out.println("Error,Role not defined");
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;
    }

    public void login(String email, String passwd) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM `user` WHERE `email`='" + email + "' AND `passwd`='" + passwd + "' ;";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            switch (Roles.valueOf(resultSet.getString("role"))) {
                case Admin:
                    CurrentUser admin = CurrentUser.getInstance(resultSet.getInt("cinUser"), resultSet.getString("email"), resultSet.getString("passwd"), resultSet.getString("imgURL"), Roles.Admin, resultSet.getString("firstName"), resultSet.getString("lastName"), AdminDepartments.valueOf(resultSet.getString("departement")));
                    changeState(admin, State.Connected);
                    break;
                case Club:
                    CurrentUser club = CurrentUser.getInstance(resultSet.getInt("cinUser"), resultSet.getString("email"), resultSet.getString("passwd"), resultSet.getString("imgURL"), Roles.Club, resultSet.getString("firstName"), resultSet.getString("lastName"), TypeClub.valueOf(resultSet.getString("typeClub")));
                    changeState(club, State.Connected);
                    break;
                case Etudiant:
                    String[] classString = resultSet.getString("class").split(" ");
                    Classe classe = new Classe(Integer.parseInt(classString[0]), classString[1], Integer.parseInt(classString[2]));
                    CurrentUser student = CurrentUser.getInstance(resultSet.getInt("cinUser"), resultSet.getString("email"), resultSet.getString("passwd"), resultSet.getString("imgURL"), Roles.Etudiant, resultSet.getString("firstName"), resultSet.getString("lastName"), Domaine.valueOf(resultSet.getString("domaine")), classe);
                    changeState(student, State.Connected);
                    break;
                case Professeur:
                    CurrentUser professor = CurrentUser.getInstance(resultSet.getInt("cinUser"), resultSet.getString("email"), resultSet.getString("passwd"), resultSet.getString("imgURL"), Roles.Professeur, resultSet.getString("firstName"), resultSet.getString("lastName"), Domaine.valueOf(resultSet.getString("domaine")));
                    changeState(professor, State.Connected);
                    break;
                case Externe:
                    CurrentUser extern = CurrentUser.getInstance(resultSet.getInt("cinUser"), resultSet.getString("email"), resultSet.getString("passwd"), resultSet.getString("imgURL"), Roles.Externe, resultSet.getString("entrepriseName"), resultSet.getString("localisation"));
                    changeState(extern, State.Connected);
                    break;
                default:
                    System.out.println("Error,Role not defined");
            }


        } catch (SQLException exception) {
            System.out.println("User Not Found");
        }
    }


    public void changeState(User user, State state) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE `user` SET `state` = '" + state + "' WHERE `user`.`cinUser` = " + user.getCinUser() + ";";
            statement.executeUpdate(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public void changeState(CurrentUser user, State state) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE `user` SET `state` = '" + state + "' WHERE `user`.`cinUser` = " + user.getCinUser() + ";";
            statement.executeUpdate(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void disconnect() {
        CurrentUser currentUser = CurrentUser.getInstance();
        changeState(currentUser, State.Disconnected);
        currentUser.clearInstance();
        System.out.println(currentUser);
    }

    public List<User> filtreByRole(Roles role) {
        return this.getList().stream().filter(u -> u.getRole() == role).collect(Collectors.toList());
    }

    public List<Espritien> searchByFirstName(String name) {
        return this.getList().stream().map(u -> (Espritien) u)
                .filter(u -> u.getFirstName().contains(name)).collect(Collectors.toList());
    }

    public List<User> sortById() {
        return this.getList().stream().sorted((o1, o2) -> String.valueOf(o1.getCinUser())
                .compareTo(String.valueOf(o1.getCinUser()))).collect(Collectors.toList());
    }

    //region Student
    public List<Student> filtreByClassLevel(int classNum) {
        List<Student> studentList = this.getList().stream().filter(u -> u.getRole() == Roles.Etudiant).map(u -> (Student) u).collect(Collectors.toList());
        return studentList.stream().filter(u -> u.getClasse().getNiveau() == classNum).collect(Collectors.toList());
    }

    public List<Student> filtreByClassSpeciality(String spec) {
        List<Student> studentList = this.getList().stream().filter(u -> u.getRole() == Roles.Etudiant).map(u -> (Student) u).collect(Collectors.toList());
        return studentList.stream().filter(u -> u.getClasse().getSpecialite().toLowerCase().contains(spec.toLowerCase())).collect(Collectors.toList());
    }

    public List<Student> filtreByStudentDomaine(Domaine domaine) {
        List<Student> studentList = this.getList().stream().filter(u -> u.getRole() == Roles.Etudiant).map(u -> (Student) u).collect(Collectors.toList());
        return studentList.stream().filter(u -> u.getDomaine() == domaine).collect(Collectors.toList());
    }

    //endregion

    //region Admin
    public List<User> filtreByDepartment(AdminDepartments department) {
        List<Admin> adminList = this.getList().stream().filter(u -> u.getRole() == Roles.Admin).map(u -> (Admin) u).collect(Collectors.toList());
        return adminList.stream().filter(u -> u.getDepartment() == department).collect(Collectors.toList());
    }
    //endregion


}
