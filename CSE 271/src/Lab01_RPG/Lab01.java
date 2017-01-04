package Lab01_RPG;

public class Lab01 {

    static int num_iterations = 1;

    public static void main(String[] args) {
        if (args.length == 1) { 
            num_iterations = Integer.parseInt(args[0]); 
        } else {
            Character.print = true;
        }

        int goblin_wins, player_wins;
        goblin_wins = player_wins = 0;

        for (int i = 0; i < num_iterations; i++) {
            Character player = new Fighter("Nick");
            Character goblin = new Character("Goblin", 8, 5, 4, 2, 3, 2);
        
            while (player.hitPoints > 0 && goblin.hitPoints > 0){
                player.fightCharacter(goblin);
                if (goblin.hitPoints <= 0) { 
                    player_wins++;
                    player.battlesWon += 1;
                    break; 
                }
                goblin.fightCharacter(player);
                if (player.hitPoints <= 0) {
                    goblin_wins++;
                    goblin.battlesWon += 1;
                }
            }

            if (Character.print) {
                System.out.println("Player hp: " + player.hitPoints);
                System.out.println("Goblin hp: " + goblin.hitPoints);
            }
        }
        
        if (!Character.print) {
            System.out.println("Player wins: " + player_wins);
            System.out.println("Goblin wins: " + goblin_wins);
        }
    }

}
