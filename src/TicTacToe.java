import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> computerPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);


        while (true){
            Scanner vvod = new Scanner(System.in);
            System.out.print("Введите поле от 1-9: ");
            int playerPlayce = vvod.nextInt();
            while (playerPositions.contains(playerPlayce) || computerPositions.contains(playerPositions)){
            System.out.println("Такая позиция уже занята, выберите другую");
           playerPlayce = vvod.nextInt();}

            placeChange(gameBoard, playerPlayce, "player");

            String result =  checkWinner();
            if (result.length() > 0){
                System.out.println(result);
                break;
            }

            Random random = new Random();
            int placComp = random.nextInt(9)+1;
            while (playerPositions.contains(placComp) || computerPositions.contains(placComp)){
                placComp = random.nextInt(9)+1;}

            placeChange(gameBoard, placComp, "computer");

            printGameBoard(gameBoard);

          result =  checkWinner();
          if (result.length() > 0){
              System.out.println(result);
              break;
          }
            System.out.println(result);
        }
        }


    public static void printGameBoard(char[][] gameBoard){
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.println(gameBoard[i]);
        }
    }
    public static void placeChange (char[][] gameBoard, int place, String user){

        char symbol = ' ';
        if (user.equals("player")){
            symbol = 'X';
            playerPositions.add(place);
        }else if (user.equals("computer")){
            symbol = 'O';
            computerPositions.add(place);
        }


        switch (place){
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
    }


    }
    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,5);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,5,9);
        List diagonal1 = Arrays.asList(1,5,9);
        List diagonal2 = Arrays.asList(3,5,7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(diagonal1);
        winning.add(diagonal2);

        for (List e : winning){
            if (playerPositions.containsAll(e)){
                return  "Поздравляем, вы выиграли!";
            }else if (computerPositions.containsAll(e)){
                return  "Компьютер выигра, попробуйте снова!";
            }else if (playerPositions.size() + computerPositions.size() == 9){
                return "Ничья!";
            }
        }


        return "";
    }
}

