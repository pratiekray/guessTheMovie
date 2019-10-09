import java.util.Scanner;

public class Game {
    private String movieToGuess;
    private int pointsLost;
    private String wrongLetters;
    private String rightLetters;
    private boolean gameWon;


    public Game(String pathname){
        MovieList movieList = new MovieList(pathname);
        movieToGuess = movieList.getRandomMovie().trim();
        pointsLost = 0;
        wrongLetters = "";
        rightLetters = "";
        gameWon = false;
    }

    public String getMovieTitle(){
        return movieToGuess;
    }

    public String getHiddenMovieTitle(){
        if (rightLetters.equals("")){
            return movieToGuess.replaceAll("[a-zA-z]","_");
        }
        else {
            return movieToGuess.replaceAll("[a-zA-Z&&[^"+rightLetters+"]]","_");
        }
    }

    public String getWrongLetters(){
        return wrongLetters;
    }

    public boolean WonGame(){
        return gameWon;
    }

    public boolean gameEnded(){
        if (pointsLost >= 10){
            return true;
        }

        if (!getHiddenMovieTitle().contains("_")){
            gameWon = true;
            return true;
        }

        return false;
    }

    private String inputLetter(){
        System.out.println("Guess a letter: ");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toLowerCase();

        if (!letter.matches("[a-z]")){
            System.out.println("That is not a letter");
            return inputLetter();
        }
        else if (wrongLetters.contains(letter)|| rightLetters.contains(letter)){
            System.out.println("You already guessed that letter");
            return inputLetter();
        }
        else {
            return letter;
        }
    }

    public void guessLetter(){

        String guessedLetter = inputLetter();

        if (movieToGuess.toLowerCase().contains(guessedLetter)){
            rightLetters += guessedLetter + guessedLetter.toUpperCase();
        }
        else {
            pointsLost++;
            wrongLetters += "" + guessedLetter;
        }
    }
}
