import java.io.*;
import java.nio.file.*;
import java.util.*;

/*
Programmer: Andrew Langan
Date: 5/13
Project: TriviaGame
File Name: Trivia
Description: Main Game class
*/
public class Trivia {
    static Printer printer = new Printer(); // class written by me to print in different colors using ANSI escape codes
    static final int delay = 250; // delay between prints to build suspense
    static Timer timer = new Timer();

    public static void main(String[] args) throws Exception {
        String[] questions = { "to open", "to dance", "to sing", "to give", "to teach (no tilde needed)", "to win",
                "to do", "to play (sports)", "to read", "to watch", "to swim", "to hear (no accent needded)",
                "to paint", "to want", "to return to", "to play (music)", "to use", "to see" }; // questions list
        String[] answers = { "YWJyaXI=", "YmFpbGFy", "Y2FudGFy", "ZGFy", "ZW5zZW5hcg==", "Z2FuYXI=", "aGFjZXI=",
                "anVnYXI=", "bGVlcg==", "bWlyYXI=", "bmFkYXI=", "b2ly", "cGludGFy", "cXVlcmVy", "cmVncmVzYXI=",
                "dG9jYXI=", "dXNhcg==", "dmVy" }; // In base 64 so you can't read them :)
        Scanner s = new Scanner(System.in);
        int correct = 0; // correct questions
        int[] prevQs = new int[10]; // don't repeat questions
        printer.clear();
        printer.prBanner(Printer.color.green);
        printer.println("", Printer.color.white);
        for (int i = 0; i < 10; i++) {
            printer.prCyan("Question " + (i + 1) + ": ");
            int q;
            boolean exists = false;
            do {
                q = (int) (Math.random() * answers.length);
                for (int j = 0; j < prevQs.length; j++) {
                    if (prevQs[j] == q) {
                        exists = true;
                        break;
                    } else
                        exists = false;
                }
            } while (exists);
            prevQs[i] = q;
            if (i > 0)
                printer.prCyan("Next Question,\n");
            printer.prPurple("What is " + questions[q] + " in spanish?\n");
            String input = s.nextLine().toLowerCase();
            if (input.equals(new String(Base64.getDecoder().decode(answers[q])))) {
                correct += 1;
                correct();
            } else {
                incorrect(new String(Base64.getDecoder().decode(answers[q])));
            }
        }
        showStats(correct); // show stats for this session
        timer.cancel(); // cleanup
        timer.purge();
        s.close();
    }

    // this method is called when a question is answered correctly to output a
    // String with delays in between prints
    public static void correct() {
        TimerTask tt = new TimerTask() {
            public void run() {
                printer.prYellow("You were");

            }
        };
        TimerTask tt2 = new TimerTask() {
            public void run() {
                for (int i = 0; i < 3; i++) {
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        // should never happen
                    }
                    printer.prYellow(".");

                }
            }
        };
        TimerTask tt3 = new TimerTask() {
            public void run() {
                printer.prGreen("\rYou were CORRECT!\n");

            }
        };
        timer.schedule(tt, 0); // print You were in yellow
        timer.schedule(tt2, 0); // print ... with delay in between
        timer.schedule(tt3, (int) (3.5 * delay)); // print You were CORRECT! in green
        try {
            Thread.sleep((int) (3.6 * delay)); // wait for printing to finish + a small delay
        } catch (InterruptedException e) {
            // should never happen
        }

    }

    // this method is called when a question is answered incorrectly to output a
    // String with delays in between prints
    public static void incorrect(String correct) {
        TimerTask tt = new TimerTask() {
            public void run() {
                printer.prYellow("You were");

            }
        };
        TimerTask tt2 = new TimerTask() {
            public void run() {
                for (int i = 0; i < 3; i++) {
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        // should never happen
                    }
                    printer.prYellow(".");

                }
            }
        };
        TimerTask tt3 = new TimerTask() {
            public void run() {
                printer.prRed("\rYou were INCORRECT!\n");
                printer.prRed("The correct answer was " + correct + ".\n");

            }
        };
        timer.schedule(tt, 0); // print You were in yellow
        timer.schedule(tt2, 0); // print ... with delay in between
        timer.schedule(tt3, (int) (3.5 * delay)); // print You were INCORRECT! in red
        try {
            Thread.sleep((int) (3.6 * delay)); // wait for printing to finish + a small delay
        } catch (InterruptedException e) {
            // should never happen
        }
    }

    // int correct is for determining message
    // throws Exception if file not found.
    // displays the users sats for this session
    public static void showStats(int correct) throws Exception {
        BufferedReader statsR = new BufferedReader(new FileReader("stats.txt")); // previous scores file
        printer.clear();
        printer.println("Your stats for this session: ", Printer.color.cyan);
        printer.prCyan("Correct: ");
        if (correct <= 5) {
            printer.prRed("" + correct);
            printer.prCyan("/10 (");
            printer.prRed(correct * 10 + "%");
            printer.prCyan(")\n");
        } else if (correct <= 8) {
            printer.prYellow("" + correct);
            printer.prCyan("/10 (");
            printer.prYellow(correct * 10 + "%");
            printer.prCyan(")\n");
        } else {
            printer.prGreen("" + correct);
            printer.prCyan("/10 (");
            printer.prGreen(correct * 10 + "%");
            printer.prCyan(")\n");
        }
        double[] scores = new double[(int) Files.lines(Paths.get(".\\stats.txt")).count() + 1]; // scores in file + our
                                                                                                // score
        double total = 0; // total of all scores for average
        for (int i = 0; i < Files.lines(Paths.get(".\\stats.txt")).count(); i++) {
            scores[i] = Double.parseDouble(statsR.readLine());
            total += scores[i];
        }
        scores[(int) Files.lines(Paths.get("stats.txt")).count()] = correct; // our score
        double averageF = total / (scores.length - 1); // average from file
        double average = correct * 10; // our average
        if (average > averageF)
            printer.prCyan("You did better than average!\nYour average was " + average
                    + "%. The average score of other players is " + Math.round(averageF * 100) / 10 + "%.\n");
        else
            printer.prCyan("You did worse than average\nYour average was " + average
                    + "%. The average score of other players is " + Math.round(averageF * 100) / 10 + "%.\n");
        statsR.close();
        BufferedWriter statsW = new BufferedWriter(new FileWriter("stats.txt")); // write our average to file
        String scoreString = ""; // format for readability in file
        for (int i = 0; i < scores.length; i++) {
            scoreString += scores[i];
            if (i < scores.length - 1)
                scoreString += "\n";
        }
        statsW.append(scoreString);
        statsW.close();

    }

}
