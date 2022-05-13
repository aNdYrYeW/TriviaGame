/*
Programmer: Andrew Langan
Date: 5/12
Project: TriviaGame
File Name: Printer
Description: Helper class to print colors 
*/
public class Printer {
    public enum color {
        red, yellow, green, cyan, blue, purple, black, white
    }

    private String banner = " $$$$$$\\                  $$\\                                  $$\\         \n" +
            "$$  __$$\\                 $$ |                                 $  |        \n" +
            "$$ /  $$ |$$$$$$$\\   $$$$$$$ | $$$$$$\\   $$$$$$\\  $$\\  $$\\  $$\\\\_/$$$$$$$\\ \n" +
            "$$$$$$$$ |$$  __$$\\ $$  __$$ |$$  __$$\\ $$  __$$\\ $$ | $$ | $$ | $$  _____|\n" +
            "$$  __$$ |$$ |  $$ |$$ /  $$ |$$ |  \\__|$$$$$$$$ |$$ | $$ | $$ | \\$$$$$$\\  \n" +
            "$$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |      $$   ____|$$ | $$ | $$ |  \\____$$\\ \n" +
            "$$ |  $$ |$$ |  $$ |\\$$$$$$$ |$$ |      \\$$$$$$$\\ \\$$$$$\\$$$$  | $$$$$$$  |\n" +
            "\\__|  \\__|\\__|  \\__| \\_______|\\__|       \\_______| \\_____\\____/  \\_______/ \n" +
            "                                                                           \n" +
            "                                                                           \n" +
            "                                                                           \n" +
            " $$$$$$\\                                $$\\           $$\\                  \n" +
            "$$  __$$\\                               \\__|          $$ |                 \n" +
            "$$ /  \\__| $$$$$$\\   $$$$$$\\  $$$$$$$\\  $$\\  $$$$$$$\\ $$$$$$$\\             \n" +
            "\\$$$$$$\\  $$  __$$\\  \\____$$\\ $$  __$$\\ $$ |$$  _____|$$  __$$\\            \n" +
            " \\____$$\\ $$ /  $$ | $$$$$$$ |$$ |  $$ |$$ |\\$$$$$$\\  $$ |  $$ |           \n" +
            "$$\\   $$ |$$ |  $$ |$$  __$$ |$$ |  $$ |$$ | \\____$$\\ $$ |  $$ |           \n" +
            "\\$$$$$$  |$$$$$$$  |\\$$$$$$$ |$$ |  $$ |$$ |$$$$$$$  |$$ |  $$ |           \n" +
            " \\______/ $$  ____/  \\_______|\\__|  \\__|\\__|\\_______/ \\__|  \\__|           \n" +
            "          $$ |                                                             \n" +
            "          $$ |                                                             \n" +
            "          \\__|                                                             \n" +
            "$$$$$$$$\\        $$\\            $$\\                                        \n" +
            "\\__$$  __|       \\__|           \\__|                                       \n" +
            "   $$ | $$$$$$\\  $$\\ $$\\    $$\\ $$\\  $$$$$$\\                               \n" +
            "   $$ |$$  __$$\\ $$ |\\$$\\  $$  |$$ | \\____$$\\                              \n" +
            "   $$ |$$ |  \\__|$$ | \\$$\\$$  / $$ | $$$$$$$ |                             \n" +
            "   $$ |$$ |      $$ |  \\$$$  /  $$ |$$  __$$ |                             \n" +
            "   $$ |$$ |      $$ |   \\$  /   $$ |\\$$$$$$$ |                             \n" +
            "   \\__|\\__|      \\__|    \\_/    \\__| \\_______|                             \n" +
            "                                                                           \n" +
            "                                                                           \n" +
            "                                                                           \n" +
            " $$$$$$\\                                                                   \n" +
            "$$  __$$\\                                                                  \n" +
            "$$ /  \\__| $$$$$$\\  $$$$$$\\$$$$\\   $$$$$$\\                                 \n" +
            "$$ |$$$$\\  \\____$$\\ $$  _$$  _$$\\ $$  __$$\\                                \n" +
            "$$ |\\_$$ | $$$$$$$ |$$ / $$ / $$ |$$$$$$$$ |                               \n" +
            "$$ |  $$ |$$  __$$ |$$ | $$ | $$ |$$   ____|                               \n" +
            "\\$$$$$$  |\\$$$$$$$ |$$ | $$ | $$ |\\$$$$$$$\\                                \n" +
            " \\______/  \\_______|\\__| \\__| \\__| \\_______|                               \n" +
            "                                                                           \n" +
            "                                                                           \n" +
            "                                                                           ";

    Printer() {
        return;
    }

    public void print(String t, color c) {
        switch (c) {
            case red:
                prRed(t);
                break;
            case black:
                prBlack(t);
                break;
            case blue:
                prBlue(t);
                break;
            case cyan:
                prCyan(t);
                break;
            case green:
                prGreen(t);
                break;
            case purple:
                prPurple(t);
                break;
            case white:
                prWhite(t);
                break;
            case yellow:
                prYellow(t);
                break;
            default:
                System.out.print(t);
                break;

        }
    }

    public void println(String t, color c) {
        switch (c) {
            case red:
                prRed(t + "\n");
                break;
            case black:
                prBlack(t + "\n");
                break;
            case blue:
                prBlue(t + "\n");
                break;
            case cyan:
                prCyan(t + "\n");
                break;
            case green:
                prGreen(t + "\n");
                break;
            case purple:
                prPurple(t + "\n");
                break;
            case white:
                prWhite(t + "\n");
                break;
            case yellow:
                prYellow(t + "\n");
                break;
            default:
                System.out.println(t);
                break;

        }
    }

    public void prRed(String t) {
        System.out.print("\u001B[31m" + t + "\u001B[0m");
    }

    public void prYellow(String t) {
        System.out.print("\u001B[33m" + t + "\u001B[0m");
    }

    public void prGreen(String t) {
        System.out.print("\u001B[32m" + t + "\u001B[0m");
    }

    public void prCyan(String t) {
        System.out.print("\u001B[36m" + t + "\u001B[0m");
    }

    public void prBlue(String t) {
        System.out.print("\u001B[34m" + t + "\u001B[0m");
    }

    public void prPurple(String t) {
        System.out.print("\u001B[35m" + t + "\u001B[0m");
    }

    public void prBlack(String t) {
        System.out.print("\u001B[30m" + t + "\u001B[0m");
    }

    public void prWhite(String t) {
        System.out.print("\u001B[37m" + t + "\u001B[0m");
    }

    public void clear() {
        System.out.print("\033[2J\033[H");
    }

    public void prBanner() {

        System.out.println(banner);
    }

    public void prBanner(color c) {
        switch (c) {
            case red:
                prRed(banner);
                break;
            case black:
                prBlack(banner);
                break;
            case blue:
                prBlue(banner);
                break;
            case cyan:
                prCyan(banner);
                break;
            case green:
                prGreen(banner);
                break;
            case purple:
                prPurple(banner);
                break;
            case white:
                prWhite(banner);
                break;
            case yellow:
                prYellow(banner);
                break;
            default:
                prBanner();
                break;

        }
    }
}
