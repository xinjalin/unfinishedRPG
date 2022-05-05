import java.io.IOException;
import java.util.Scanner;

public class PointlessRPG {
    public static void main(String[] args) throws IOException {
        String charName = ""; //Stating all the variables used in the program.
        int charAtk = 0;	//Characters Variable
        int charWeapon = 0;
        int charStam = 0;
        int charLvl = 0;
        int charExp = 0;
        int charEarnT = 0;
        int charTreasure = 0;
        int charMaxS = 0;		//Total Stats
        int charMaxT = 0;
        int charMaxEx = 0;
        int charMaxEn = 0;
        int charMaxOutDam = 0;
        int charMaxInDam = 0;

        int dunLvl = 0;		//Combat Variables
        int encounter = 0;
        int encountMob = 0;
        int atkStrM = 0;
        int atkStrC = 0;
        int mobHeal = 0;

        int mobAtk = 0;		//Mob Variables
        int mobStam = 0;

        weapon wep = new weapon(); //Weapon Import

        Scanner reader = new Scanner(System.in);    //Acquires Adventurers Name.
        System.out.println("Enter Adventurers Name:");
        charName = reader.nextLine();

        charAtk = (int) (6 + (Math.random()*6)+1);	//Rolls for adventurers base stats.
        charStam = (int) ((200 + (Math.random()*6)+1)+(Math.random()*6)+1);
        charMaxS = charStam;	//Max Stamina
	        
	       /* String file = charName+".txt"; 		//Saves to log file
		    PrintStream printStream = new PrintStream(new FileOutputStream(file));
		    System.setOut(printStream); */

        System.out.println("The Adventurer " + "[" + charName + "]" + " is going into a dungeon.");  //States the Adventurers Current Stats
        System.out.println("[" + charName + "]" + "'s current attack is " + charAtk);
        System.out.println("[" + charName + "]" + "'s current stamina is " + charStam);
        System.out.println("Good Luck Brave Adventure");
        System.out.println("--------------------------------------------");

        while (charStam > 0){
            dunLvl++;       //Increase dungeon level
            System.out.println(charName + " enters a level " + dunLvl + " dungeon." );

            encounter = (int) ((Math.random()*100)+1);  //Encounter
            if (encounter <= 20){
                encountMob = (int) ((Math.random()*100)+1);
                if (encountMob < 25){
                    System.out.println(charName + " encountered a Gaint Rat.");
                    mobStam = 6;
                    while(mobStam > 0 && charStam > 0){ //Fight
                        if(charWeapon == (int) wep.dagger||charWeapon == 0){
                            charWeapon = (int) wep.dagger;
                        }else{
                        }
                        mobAtk = (int) (4 + (Math.random()*4)+1);

                        atkStrM = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        atkStrC = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        if (atkStrM > atkStrC){
                            charStam = charStam - mobAtk;
                            System.out.println("The Gaint Rat rolls " + atkStrM + " and deals " + mobAtk + " damage to " + charName + ".");
                            charMaxInDam = charMaxInDam + mobAtk;
                        }else if (atkStrC > atkStrM){
                            mobStam = mobStam - (charAtk + charWeapon);
                            System.out.println(charName + " rolls " + atkStrC + " and deals " + (charAtk + charWeapon) + " damage to the Gaint Rat.");
                            charMaxOutDam = charMaxOutDam + (charAtk + charWeapon);
                        }else if (atkStrC == atkStrM){
                        }
                        if (mobStam <= 0){      //Conclusion
                            System.out.println(charName + " killed the Gaint Rat.");
                            charExp = charExp + 5;
                            charMaxEx = charMaxEx + 5;	//Total Exp
                            System.out.println(charName + " gains 5 exp." + " " + charName + "'s total exp is " + charExp + ".");  //Gain Exp
                            charMaxEn++;
                            break;
                        } else if (charStam <= 0){
                            System.out.println("[" + charName + "] Died!");
                            System.out.println("");
                        }
                    }
                } else if (encountMob < 50){
                    System.out.println(charName + " encountered a Goblin.");
                    mobStam = 10;
                    while(mobStam > 0 && charStam > 0){
                        if(charWeapon == wep.dagger||charWeapon == 0){
                            charWeapon = (int) wep.dagger;
                        }else{
                        }
                        mobAtk = (int) (8 + (Math.random()*6)+1);

                        atkStrM = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        atkStrC = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        if (atkStrM > atkStrC){
                            charStam = charStam - mobAtk;
                            System.out.println("The Goblin rolls " + atkStrM + " and deals " + mobAtk + " damage to " + charName + ".");
                            charMaxInDam = charMaxInDam + mobAtk;
                            mobHeal = (int) ((Math.random()*100)+1); //Mob chance of using potion
                            if (mobHeal <= 5){
                                mobStam = 10;
                            }
                        }else if (atkStrC > atkStrM){
                            mobStam = mobStam - (charAtk + charWeapon);
                            System.out.println(charName + " rolls " + atkStrC + " and deals " + (charAtk + charWeapon) + " damage to the Goblin.");
                            charMaxOutDam = charMaxOutDam + (charAtk + charWeapon);
                        }else if (atkStrC == atkStrM){
                        }
                        if (mobStam <= 0){
                            System.out.println(charName + " killed the Goblin.");
                            charExp = charExp + 10;
                            charMaxEx = charMaxEx + 10;
                            System.out.println(charName + " gains 10 exp." + " " + charName + "'s total exp is " + charExp + ".");
                            charEarnT = (int) ((Math.random()*4)+1);	//Gain Treasure
                            charTreasure = (int) charTreasure + charEarnT;
                            charMaxT = (int) charMaxT + charEarnT;
                            System.out.println(charName + " gains " + charEarnT + " treasure. " + charName + "'s total treasure is " + charTreasure + "." );
                            charMaxEn++;
                            if(charWeapon == wep.dagger){
                                charWeapon = wep.shortSword;
                                System.out.println("The Goblin Droped a Short Sword with the power of 1d6.");
                                System.out.println("you equip your newly obtained spoiles of a triumph vicrtory.");
                            }else{
                            }
                            break;
                        } else if (charStam <= 0){
                            System.out.println("[" + charName + "] Died!");
                            System.out.println("");
                        }
                    }
                } else if (encountMob < 65){
                    System.out.println(charName + " encountered a Hobgoblin.");
                    mobStam = 15;
                    while(mobStam > 0 && charStam > 0){
                        if(charWeapon == (int) wep.dagger||charWeapon == 0){
                            charWeapon = (int) wep.dagger;
                        }else{
                        }
                        mobAtk = (int) (10 + (Math.random()*8)+1);

                        atkStrM = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        atkStrC = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        if (atkStrM > atkStrC){
                            charStam = charStam - mobAtk;
                            System.out.println("The Hobgoblin rolls " + atkStrM + " and deals " + mobAtk + " damage to " + charName + ".");
                            charMaxInDam = charMaxInDam + mobAtk;
                            mobHeal = (int) ((Math.random()*100)+1);
                            if (mobHeal <= 10){
                                mobStam = 15;
                            }
                        }else if (atkStrC > atkStrM){
                            mobStam = mobStam - (charAtk + charWeapon);
                            System.out.println(charName + " rolls " + atkStrC + " and deals " + (charAtk + charWeapon) + " damage to the Hobgoblin.");
                            charMaxOutDam = charMaxOutDam + (charAtk + charWeapon);
                        }else if (atkStrC == atkStrM){
                        }
                        if (mobStam <= 0){
                            System.out.println(charName + " killed the Hobgoblin.");
                            charExp = charExp + 15;
                            charMaxEx = charMaxEx + 15;
                            System.out.println(charName + " gains 15 exp." + " " + charName + "'s total exp is " + charExp + ".");
                            charEarnT = (int) ((Math.random()*6)+1);
                            charTreasure = (int) charTreasure + charEarnT;
                            charMaxT = (int) charMaxT + charEarnT;
                            System.out.println(charName + " gains " + charEarnT + " treasure. " + charName + "'s total treasure is " + charTreasure + "." );
                            charMaxEn++;
                            if(charWeapon == (int) wep.dagger||charWeapon == (int) wep.shortSword){
                                charWeapon = (int) wep.battleAxe;
                                System.out.println("The Hobgoblin Droped a Battle Axe with the power of 1d8.");
                                System.out.println("you equip your newly obtained spoiles of a triumph vicrtory.");
                            }else{
                            }
                            break;
                        } else if (charStam <= 0){
                            System.out.println("[" + charName + "] Died!");
                            System.out.println("");
                        }
                    }
                } else if (encountMob < 80){
                    System.out.println(charName + " encounter an Orc.");
                    mobStam = 20;
                    while(mobStam > 0 && charStam > 0){
                        if(charWeapon == wep.dagger||charWeapon == 0){
                            charWeapon = (int) wep.dagger;
                        }else{
                        }
                        mobAtk = (int) (12 + (Math.random()*8)+1);

                        atkStrM = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        atkStrC = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        if (atkStrM > atkStrC){
                            charStam = charStam - mobAtk;
                            System.out.println("The Orc rolls " + atkStrM + " and deals " + mobAtk + " damage to " + charName + ".");
                            charMaxInDam = charMaxInDam + mobAtk;
                            mobHeal = (int) ((Math.random()*100)+1);
                            if (mobHeal <= 15){
                                mobStam = 20;
                            }
                        }else if (atkStrC > atkStrM){
                            mobStam = mobStam - (charAtk + charWeapon);
                            System.out.println(charName + " rolls " + atkStrC + " and deals " + (charAtk + charWeapon) + " damage to the Orc.");
                            charMaxOutDam = charMaxOutDam + (charAtk + charWeapon);
                        }else if (atkStrC == atkStrM){

                        }
                        if (mobStam <= 0){
                            System.out.println(charName + " killed the Orc.");
                            charExp = charExp + 20;
                            charMaxEx = charMaxEx + 20;
                            System.out.println(charName + " gains 20 exp." + " " + charName + "'s total exp is " + charExp + ".");
                            charEarnT = (int) ((Math.random()*6)+1);
                            charTreasure = (int) charTreasure + charEarnT;
                            charMaxT = (int) charMaxT + charEarnT;
                            System.out.println(charName + " gains " + charEarnT + " treasure. " + charName + "'s total treasure is " + charTreasure + "." );
                            charMaxEn++;
                            if(charWeapon == (int) wep.dagger||charWeapon == (int) wep.shortSword||charWeapon == (int) wep.battleAxe){
                                charWeapon = (int) wep.longSword;
                                System.out.println("The Orc Droped a Long Sword with the power of 1d8.");
                                System.out.println("you equip your newly obtained spoiles of a triumph vicrtory.");
                            }else{
                            }
                            break;
                        } else if (charStam <= 0){
                            System.out.println("[" + charName + "] Died!");
                            System.out.println("");
                        }
                    }
                } else if (encountMob < 90){
                    System.out.println(charName + " encounter a Minotaur.");
                    mobStam = 28;
                    while(mobStam > 0 && charStam > 0){
                        if(charWeapon == wep.dagger||charWeapon == 0){
                            charWeapon = (int) wep.dagger;
                        }else{
                        }
                        mobAtk = (int) (12 + (Math.random()*10)+1);

                        atkStrM = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        atkStrC = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        if (atkStrM > atkStrC){
                            charStam = charStam - mobAtk;
                            System.out.println("The Minotaur rolls " + atkStrM + " and deals " + mobAtk + " damage to " + charName + ".");
                            charMaxInDam = charMaxInDam + mobAtk;
                            mobHeal = (int) ((Math.random()*100)+1);
                            if (mobHeal <= 20){
                                mobStam = 28;
                            }
                        }else if (atkStrC > atkStrM){
                            mobStam = mobStam - (charAtk + charWeapon);
                            System.out.println(charName + " rolls " + atkStrC + " and deals " + (charAtk + charWeapon) + " damage to the Minotaur.");
                            charMaxOutDam = charMaxOutDam + (charAtk + charWeapon);
                        }else if (atkStrC == atkStrM){
                        }
                        if (mobStam <= 0){
                            System.out.println(charName + " killed the Minotaur.");
                            charExp = charExp + 30;
                            charMaxEx = charMaxEx + 30;
                            System.out.println(charName + " gains 30 exp." + " " + charName + "'s total exp is " + charExp + ".");
                            charEarnT = (int) ((Math.random()*8)+1);
                            charTreasure = (int) charTreasure + charEarnT;
                            charMaxT = (int) charMaxT + charEarnT;
                            System.out.println(charName + " gains " + charEarnT + " treasure. " + charName + "'s total treasure is " + charTreasure + "." );
                            charMaxEn++;
                            if(charWeapon == (int) wep.dagger||charWeapon == (int) wep.shortSword||charWeapon == (int) wep.battleAxe||charWeapon == (int) wep.longSword){
                                charWeapon = (int) wep.greatAxe;
                                System.out.println("The Orc Droped a Great Axe with the power of 1d10.");
                                System.out.println("you equip your newly obtained spoiles of a triumph vicrtory.");
                            }else{
                            }
                            break;
                        } else if (charStam <= 0){
                            System.out.println("[" + charName + "] Died!");
                            System.out.println("");
                        }
                    }
                } else if (encountMob < 96){
                    System.out.println(charName + " encounter a Death Knight.");
                    mobStam = 40;
                    while(mobStam > 0 && charStam > 0){
                        if(charWeapon == wep.dagger||charWeapon == 0){
                            charWeapon = (int) wep.dagger;
                        }else{
                        }
                        mobAtk = (int) (12 + (Math.random()*10)+1);

                        atkStrM = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        atkStrC = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        if (atkStrM > atkStrC){
                            charStam = charStam - mobAtk;
                            System.out.println("The Death Knight rolls " + atkStrM + " and deals " + mobAtk + " damage to " + charName + ".");
                            charMaxInDam = charMaxInDam + mobAtk;
                            mobHeal = (int) ((Math.random()*100)+1); //Mob chance of using potion
                            if (mobHeal <= 40){
                                mobStam = 40;
                            }
                        }else if (atkStrC > atkStrM){
                            mobStam = mobStam - (charAtk + charWeapon);
                            System.out.println(charName + " rolls " + atkStrC + " and deals " + (charAtk + charWeapon) + " damage to the Death Knight.");
                            charMaxOutDam = charMaxOutDam + (charAtk + charWeapon);
                        }else if (atkStrC == atkStrM){
                        }
                        if (mobStam <= 0){
                            System.out.println(charName + " killed the Death Knight.");
                            charExp = charExp + 75;
                            charMaxEx = charMaxEx + 75;
                            System.out.println(charName + " gains 75 exp." + " " + charName + "'s total exp is " + charExp + ".");
                            charEarnT = (int) ((Math.random()*10)+1);
                            charTreasure = (int) charTreasure + charEarnT;
                            charMaxT = (int) charMaxT + charEarnT;
                            System.out.println(charName + " gains " + charEarnT + " treasure. " + charName + "'s total treasure is " + charTreasure + "." );
                            charMaxEn++;
                            if(charWeapon == (int) wep.dagger||charWeapon == (int) wep.shortSword||charWeapon == (int) wep.battleAxe||charWeapon == (int) wep.longSword||charWeapon == (int) wep.greatAxe){
                                charWeapon = (int) wep.bastardSword;
                                System.out.println("The Orc Droped a Bastard Sword with the power of 1d10.");
                                System.out.println("you equip your newly obtained spoiles of a triumph vicrtory.");
                            }else{
                            }
                            break;
                        } else if (charStam <= 0){
                            System.out.println("[" + charName + "] Died!");
                            System.out.println("");
                        }
                    }
                } else if (encountMob < 99){
                    System.out.println(charName + " encounter an Umberhulk.");
                    mobStam = 45;
                    while(mobStam > 0 && charStam > 0){
                        if(charWeapon == wep.dagger||charWeapon == 0){
                            charWeapon = (int) wep.dagger;
                        }else{
                        }
                        mobAtk = (int) (20 + (Math.random()*12)+1);

                        atkStrM = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        atkStrC = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);

                        if (atkStrM > atkStrC){
                            charStam = charStam - mobAtk;
                            System.out.println("The Umberhulk rolls " + atkStrM + " and deals " + mobAtk + " damage to " + charName + ".");
                            charMaxInDam = charMaxInDam + mobAtk;
                            mobHeal = (int) ((Math.random()*100)+1);
                            if (mobHeal <= 10){
                                mobStam = 45;
                            }
                        }else if (atkStrC > atkStrM){
                            mobStam = mobStam - (charAtk + charWeapon);
                            System.out.println(charName + " rolls " + atkStrC + " and deals " + (charAtk + charWeapon) + " damage to the Umberhulk.");
                            charMaxOutDam = charMaxOutDam + (charAtk + charWeapon);
                        }else if (atkStrC == atkStrM){
                        }
                        if (mobStam <= 0){
                            System.out.println(charName + " killed the Umberhulk.");
                            charExp = charExp + 80;
                            charMaxEx = charMaxEx + 80;
                            System.out.println(charName + " gains 80 exp." + " " + charName + "'s total exp is " + charExp + ".");
                            charMaxEn++;
                            break;
                        } else if (charStam <= 0){
                            System.out.println("[" + charName + "] Died!");
                            System.out.println("");
                        }
                    }
                } else if (encountMob == 100){
                    System.out.println(charName + " encounter a Dragon.");
                    mobStam = 60;
                    while(mobStam > 0 && charStam > 0){
                        if(charWeapon == wep.dagger||charWeapon == 0){
                            charWeapon = (int) wep.dagger;
                        }else{
                        }
                        mobAtk = (int) (25 + (Math.random()*12)+5);

                        atkStrM = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);
                        atkStrC = (int) (((Math.random()*6)+1)+(Math.random()*6)+1);

                        if (atkStrM > atkStrC){
                            charStam = charStam - mobAtk;
                            System.out.println("The Dragon rolls " + atkStrM + " and deals " + mobAtk + " damage to " + charName + ".");
                            charMaxInDam = charMaxInDam + mobAtk;
                            mobHeal = (int) ((Math.random()*100)+1);
                            if (mobHeal <= 75){
                                mobStam = 60;
                            }
                        }else if (atkStrC > atkStrM){
                            mobStam = mobStam - (charAtk + charWeapon);
                            System.out.println(charName + " rolls " + atkStrC + " and deals " + (charAtk + charWeapon) + " damage to the Dragon.");
                            charMaxOutDam = charMaxOutDam + (charAtk + charWeapon);
                        }else if (atkStrC == atkStrM){
                        }
                        if (mobStam <= 0){
                            System.out.println(charName + " killed the Dragon.");
                            charExp = charExp + 100;
                            charMaxEx = charMaxEx + 100;
                            System.out.println(charName + " gains 100 exp." + " " + charName + "'s total exp is " + charExp + ".");
                            charEarnT = (int) ((Math.random()*100)+1);
                            charTreasure = (int) charTreasure + charEarnT;
                            charMaxT = (int) charMaxT + charEarnT;
                            System.out.println(charName + " gains " + charEarnT + " treasure. " + charName + "'s total treasure is " + charTreasure + "." );
                            charMaxEn++;
                            break;
                        } else if (charStam <= 0){
                            System.out.println("[" + charName + "] Died!");
                            System.out.println("");
                        }
                    }
                }//If End
                if (charExp >= 100){		//Leveling System
                    charExp = charExp - 100;
                    charLvl++;
                    charAtk++;
                    charStam++;
                    charMaxS++;
                    System.out.println(charName + " leveled up! " + charName + " is now level " + charLvl + ".");
                }
                if (charTreasure >= 500){	//Going Back to town to refil stamina
                    charStam = charMaxS;
                    System.out.println(charName + " have gained more than 500GP");
                    System.out.println(charName + " travels back to town and put the money in the bank");
                    System.out.println(charName + " gains max stamina!");
                    charTreasure = charTreasure - 500;
                }
            }if (charLvl == 50){  // ends if gets to Lvl 50
                break;
            }
        } //While End

        if (charLvl == 50){ //Finish Game at level 50
            System.out.println("");
            System.out.println(charName + " has achieved level 50! [YOU WIN]");
            System.out.println("");
        }
        //	Print Out stats
        System.out.println("-Statistics-");
        System.out.println(charName + " has reached dungeon level " + dunLvl + ".");
        System.out.println(charName + " is level was " + charLvl + ".");
        System.out.println(charName + " earned a total of " + charMaxEx + "XP.");
        System.out.println(charName + " killed " + charMaxEn + " monsters.");
        System.out.println(charName + "'s total damage dealt was " + charMaxOutDam + ".");
        System.out.println(charName + " received a total damage of " + charMaxInDam + ".");
        System.out.println(charName + "'s max attack was " + charAtk + ".");
        System.out.println(charName + "'s max stamina was " + charMaxS + ".");
        System.out.println(charName + " earned " + charMaxT + "GP worth of treasure.");
    }
} //Program End