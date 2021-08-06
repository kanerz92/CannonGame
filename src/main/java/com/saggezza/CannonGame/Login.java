package com.saggezza.CannonGame;

import java.util.ArrayList;

public class Login implements  ILogin{
    ConsoleInputGetter consoleInputGetter;
    RetrieveUsers retrieveUsers;

    public Login(ConsoleInputGetter consoleInputGetter, RetrieveUsers retrieveUsers) {
        this.consoleInputGetter = consoleInputGetter;
        this.retrieveUsers = retrieveUsers;
    }

    @Override
    public LogInResponse login() {
        LogInResponse logInResponse = new LogInResponse();
        logInResponse.setLoginSuccessful(false);
        String username = consoleInputGetter.ask("Please enter your Username");
        String password = consoleInputGetter.ask("Please enter your Password");
        User userLoggingIn= new User(username,password);
        logInResponse.setUser(userLoggingIn);
        ArrayList<User> users = retrieveUsers.readUsersFromDB();
        for (User user: users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                 logInResponse.setLoginSuccessful(true);
                 return logInResponse;
            }
        }
        return logInResponse;
    }
}
