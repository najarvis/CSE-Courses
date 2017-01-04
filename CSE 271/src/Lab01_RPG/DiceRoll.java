package Lab01_RPG;

import java.util.Random;

public class DiceRoll {

    public static Random random = new Random();

    // Roll [num_dice] dice that have [num_sides] sides and adds
    // up the result and returns it
    public static int rollDice(int num_dice, int num_sides) {
        int sum = 0;
        for (int i = 0; i < num_dice; i++) {
            sum += random.nextInt(num_sides) + 1;
        }
        return sum;
    }

    // Same as the function above, but this can take classic
    // DnD dice values like '3d6' (which would be 3 6 sided dice).
    public static int rollDice(String dice_string) {
        String[] dice_info = dice_string.split("d");
        int num_dice  = Integer.parseInt(dice_info[0]);
        int num_sides = Integer.parseInt(dice_info[1]);
        int sum = 0;

        for (int i = 0; i < num_dice; i++) {
            sum += random.nextInt(num_sides) + 1;
        }
        return sum;
    }

}
