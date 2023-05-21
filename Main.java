import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.*;



public class Main {
    public static void main(String[] args)
    {

        // System Objects:
        Scanner in = new Scanner(System.in);
        Random rand = new Random();


        //Game Variables:
        int RoomNum = 1;

        List<String> questions = new LinkedList<String>(Arrays.asList(
        "What common English verb becomes its own past tence by rearranging its letters?", 
        "It occurs once in a minute, twice in a moment, but never in an hour.", 
        "The day before two days after the day before tomorrow is Saturday. What day is it today?"));

        List<String> answers = new LinkedList<String>(Arrays.asList(
        "Eat", 
        "The Letter M", 
        "Friday"));
        

        boolean Running = true;

        System.out.println("Hello Player, Welcome to the Challenge Quiz, can you answer all three correctly?\n");


        while(Running){
            //Main Game Code. Loops untill all three questions are answered correctly.
            System.out.println("-------------------------------------------------------------------------\n");
            int count = questions.size();
            int roompuzzle = rand.nextInt(count);

            String question = questions.get(roompuzzle);
            String answer = answers.get(roompuzzle);

            questions.remove(roompuzzle);
            answers.remove(roompuzzle);

            //Questions and Answer section.
            System.out.println("Here is question number" + RoomNum + ":" + question);

            boolean Correct = false;

            while(Correct == false){

                //This is how you obtain input in Java. Will loop until contidion is fulfilled.
                String input = in.nextLine();

                if(!input.equals(answer)){
                    System.out.println("Sorry, that was incorrect. Please try again.\n");
                    System.out.println("Note: The answer is case sensitive.\n");

                }
                else{
                    Correct = true;
                }
            }
            System.out.println("That is Correct! The answer is:" + answer);

            count -= 1;
            RoomNum += 1;

            if (RoomNum > 3){
                Running = false;
            }

        }

        // Victory code run outside of loop.
        System.out.println("Congradulations! You got them all right!");
        System.out.println("Whould you like to play again? (y/n):");

        boolean Responce = false;

        while (!Responce){
            String input = in.nextLine();

            if (input.equals("y")){
                Responce = true;
                System.out.println("Okay! Let's take it from the top!");
                continue;
            }
            else if(input.equals("n")){
                Responce = true;
                System.out.println("Goodbye!");
                break;
            }
            else{
                System.out.println("That was not a valid answer, please try agian:");
                System.out.println("Responce must be a single lowercase letter.");
            }
        }
    }
}
