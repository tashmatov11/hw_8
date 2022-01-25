package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        while (true) {
            try {
                comandy();
                String a = console.nextLine();
                if (a.equals("-")) {
                    System.exit(0);
                }
                switch (a) {
                    case "1": {
                        userService.createUsersTable();
                        break;
                    }
                    case "2": {
                        userService.dropUsersTable();
                        break;
                    }
                    case "3": {
                        userService.saveUser("Bektur", "Tashmatov", (byte) 19);
                        userService.saveUser("Aza", "Muratov", (byte) 33);
                        userService.saveUser("Joma", "Abdurasulov", (byte) 18);
                        userService.saveUser("Aza", "Abdykadyrov", (byte) 26);
                        userService.saveUser("Kuttubek", "Gaparov", (byte) 17);
                        userService.saveUser("Aza", "Murzaev", (byte) 16);
                        break;
                    }
                    case "4": {
                        System.out.println(userService.getAllUsers());
                        break;
                    }
                    case "5": {
                        System.out.println(userService.getAllUser());
                        break;
                    }
                    case "6": {
                        userService.UpdateUsers();
                        break;
                    }
                    case "7": {
                        userService.removeUserByName();
                        break;
                    }
                    case "8": {
                        userService.cleanUsersTable();
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Нельзя вводить буквы!!!" + ANSI_RESET);
                console.nextLine();
            }
        }
    }

    public static void comandy() {
        System.out.println(ANSI_GREEN +
                "Нажмите 1 чтобы создать таблицу\n" +
                "Нажмите 2 чтобы удалить таблицу\n" +
                "Нажмите 3 чтобы добавить данные\n" +
                "Нажмите 4 чтобы вывести всех рабочих\n" +
                "Нажмите 5 чтобы вывести на экран рабочих с именем 'Aza' которым больше 20ти\n" +
                "Нажмите 6 чтобы переименовать возраст на 18 рабочих с именем 'Aza'\n" +
                "Нажмите 7 чтобы удалить рабочих с именем 'Aza'\n" +
                "Нажмите 8 чтобы очистить таблицу\n" +
                "Нажмите - чтобы завершить" + ANSI_RESET);
    }
}