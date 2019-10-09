public class main {
    public static void main(String[] args){
        Game game = new Game("movies.txt");

        System.out.println("Welcome to Guess The Movie Game!");
        System.out.println("Let's Start");
        System.out.println("The movie title has " + game.getMovieTitle().length()+ "characters ");

        while (!game.gameEnded()){
            System.out.println("You are guessing: " + game.getHiddenMovieTitle());
            System.out.println("You have guessed (" + game.getWrongLetters().length()/2 + ")wrong letters: " + game.getWrongLetters());
            game.guessLetter();
        }

        if (game.WonGame()){
            System.out.println("You Won!");
            System.out.println("You have guessed " + game.getMovieTitle() + "correctly");
        }

        else {
            System.out.println("You have guessed (" + game.getWrongLetters().length()/2 +") wrong letters: " + game.getWrongLetters());
            System.out.println("You Lost!");
            System.out.println("The movie title was " + game.getMovieTitle());
            System.out.println("Better Luck Next Time!");
        }
    }
}
