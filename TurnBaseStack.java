package com.mycompany.turnbasestack;

import java.util.Stack;
import java.util.Scanner;
import java.util.Random;

public class TurnBaseStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> lastHp = new Stack<>();
        int GameTimer = 1;

        Random random = new Random();

        int playerHp = 100;
        int botHp = 100;
        int playerMxDMg = 13;
        int playerMnDmg = 6;
        int botMxDmg = 10;
        int botMnDmg = 5;
        int backtrackSteps = 2;

        lastHp.push(botHp);

        while (true) {
             
            if (botHp <=0){
                System.out.println("The Enemy has been slain");
            }
            if (playerHp <=0){
                System.out.println("The player has been slain");
                break;
            }

            System.out.println("Player HP: " + playerHp + " Monster HP: " + botHp);

            System.out.println(" ");

            System.out.println(">>Hapaka!");
            System.out.println(">>Use Stun");
            System.out.println(">>Skip Turn");
            System.out.println(" ");

            System.out.print("What would you like to do: ");
            String in = sc.nextLine();//take text input

            if (in.equalsIgnoreCase("Hapaka")) {
                
                lastHp.push(botHp);

                int Damage = playerMxDMg - random.nextInt(playerMnDmg);
                System.out.println("you dealt " + Damage + " damage to the enemy");
                botHp = botHp - Damage;
                if (botHp < 0) botHp = 0;
                System.out.println(" ");

                
                hitCount++;
        
                if (hitCount == 4) {
                    if (lastHp.size() > backtrackSteps) {
                        int rewoundHp = botHp;
                        for (int i = 0; i < backtrackSteps; i++) {
                            if (!lastHp.isEmpty()) {
                                rewoundHp = lastHp.pop();
                            }
                        }
                        int restored = rewoundHp - botHp;
                        botHp = rewoundHp;
                        System.out.println("-----------------------------Alert!---------------------------");
                        System.out.println("Enemy's passive 'Backtrack' has been activated!\n");
                        System.out.println("Enemy rewinds time and restores " + restored + " HP! (Restored to " + botHp + ")");
                    }
                    hitCount = 0;
                }
                
                if (botHp <= 0) {
                    System.out.println("Monster has been slain after padol stike on him.\n");
                    System.out.println("The enemy has " + botHp + " HP remaining");
                    break;
                }
            } else if (in.equalsIgnoreCase("Stun")) {
                System.out.println("The player stunned the monster for turns \n");
                continue;
            } else if (in.equalsIgnoreCase("Skip")) {
                System.out.println("You did nothing and skipped the turn\n");
                
            }

            // Monster's turn
            System.out.println("It is the Monster's turn now... \n ");
            int botDmg = botMxDmg - random.nextInt(botMnDmg);
            System.out.println("The smashes his padol, dealing " + botDmg + " damage to the player");
            playerHp = playerHp - botDmg;
            lastHp.push(playerHp);
            if (playerHp < 0) {
                playerHp = 0;
                if (playerHp <= 0) {
                    System.out.println("Player has been slain after barbeque stab in him. \n");
                    System.out.println("The player has " + playerHp + " HP remaining");
                  
                  
                }

            }
        }
    }

    static boolean isOddorEven(int i) {
        boolean oddOrEven;

        if (i % 2 == 0) {
            return oddOrEven = true;
        } else {
            return oddOrEven = false;
        }

    }
}
