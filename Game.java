import java.util.ArrayList;
import java.util.*;
class Game {
  Scanner consoleInput = new Scanner(System.in);
  public Pokemon currentCPUpkmn;
  public Pokemon currentPlayerpkmn;
  Attack chosenCPUattack;
  Attack chosenPlayerattack;
  public boolean gameEnd;
  int scannerChecker;
  int scannerChecker2;
  // scannerChecker help me in instances where I have to keep looping player input if they type an invalid answer
  ArrayList <Pokemon> CPUpkmn = new ArrayList<Pokemon>(3);
ArrayList <Pokemon> playerpkmn = new ArrayList<Pokemon>(3);
   ArrayList <String> pokemonNameChecker = new ArrayList<String>(3);
  // I put the arraylists up here so they can be accessed by multiple methods in the game class
  
public void gamePrep() {
  //I split up the different game stages to help me code and check things easier
      scannerChecker = 0;
  CPUpkmn.add (new Pokemon("Leafeon", 75, "Grass", 30));
  CPUpkmn.add (new Pokemon("Blastoise", 100, "Water", 20));
  CPUpkmn.add (new Pokemon("Cramorant", 80, "Flying", 20));
  playerpkmn.add (new Pokemon("Pikachu", 70, "Electric", 20));
  playerpkmn.add (new Pokemon("Cinderace", 85, "Fire", 30));
  playerpkmn.add (new Pokemon("Lucario", 95, "Fighting", 50));
  // the various pokemon being added to the respective arraylists
    System.out.println("Welcome to the world of Pokémon!");
    System.out.println("You have entered a 1 v 1 against another trainer to prove who is better");
    currentCPUpkmn = CPUpkmn.get((int) (Math.random()* CPUpkmn.size()));
    System.out.println ("Opponent sent out " + CPUpkmn.get(0).pkmnName + " to fight");
    System.out.println("Choose which Pokémon to fight: ");
    for (int aespa = 0; aespa < playerpkmn.size(); aespa ++){
      System.out.println(playerpkmn.get(aespa).pkmnName);
    }
  // prints out the player's pokemon options
    for (int gidle = 0; gidle < playerpkmn.size(); gidle ++){
      pokemonNameChecker.add(playerpkmn.get(gidle).pkmnName.toLowerCase());
      // this name checker arraylist helps me check if the player's input is a valid pokemon name in the list
    }
    while (scannerChecker != 1){
      String pokemonWord = consoleInput.nextLine();
      if (!pokemonNameChecker.contains(pokemonWord.toLowerCase())){
        System.out.println("Not a valid Pokémon. Please type a valid Pokémon name");
        continue;
      }
      else {
        if (pokemonWord.equalsIgnoreCase(pokemonNameChecker.get(0))){
          currentPlayerpkmn = playerpkmn.get(0);
          System.out.println ("You have selected " + currentPlayerpkmn.pkmnName + " here is its move set: ");
          scannerChecker = 1;
          // ends the while loop
        }
        else if (pokemonWord.equalsIgnoreCase(pokemonNameChecker.get(1))){
          currentPlayerpkmn = playerpkmn.get(1);
          System.out.println ("You have selected " + currentPlayerpkmn.pkmnName + " here is its move set: ");
          scannerChecker = 1;
        }
        else if (pokemonWord.equalsIgnoreCase(pokemonNameChecker.get(2))){
          currentPlayerpkmn = playerpkmn.get(2);
          System.out.println ("You have selected " + currentPlayerpkmn.pkmnName + " here is its move set: ");
          scannerChecker = 1;
        }
      }
    }

  }
  public void SystemAttack (Pokemon pkmnplayerstart2, Attack chosenplayerAttackstart, Pokemon pkmnCPUstart2) {
    // the exchnage of attack methods. The variables on top are a bit misleading and the honestly should be more generic since this is the method used for both player attacks and CPU attacks. like pkmnplayerstart2 is not always the player's pokemon. But it works fine and I already wrote so much using these variables
    if (pkmnplayerstart2.burnoutcounter == 2){
      System.out.println(pkmnplayerstart2.pkmnName + " is tired and cannot attack right now");
      pkmnplayerstart2.burnoutcounter = 1;
      // for burnout method that skips a player's turn
    }
      else if (chosenplayerAttackstart.ChargeTurn == 1){
          chosenplayerAttackstart.ChargeTurn = 2;
        System.out.println(pkmnplayerstart2.pkmnName + " has charged " + chosenplayerAttackstart.attackName + " and is ready to attack next turn");
        // for charge turn method that also skips the CPU's turn
      }
    else {
    if (chosenplayerAttackstart.damage != 0){
      int defReducedAttack = chosenplayerAttackstart.damage - (pkmnCPUstart2.Def / 2);
      if ((pkmnCPUstart2.Def / 2) > chosenplayerAttackstart.damage){
        defReducedAttack = 0;
        // lines 83-85 help me in instances where the defense is greater than the attack damage. I want to avoid messes with negative numbers and I think these lines help get rid of those issues
      }
      pkmnCPUstart2.HP = pkmnCPUstart2.HP - defReducedAttack;
      System.out.println(pkmnCPUstart2.pkmnName + " took " + defReducedAttack + " damage!");
      
    }
    if (chosenplayerAttackstart.DefAdd != 0){
      pkmnplayerstart2.Def = pkmnplayerstart2.Def + chosenplayerAttackstart.DefAdd;
      System.out.println(pkmnplayerstart2.pkmnName + "'s defense rose by " + chosenplayerAttackstart.DefAdd);
    }
      if (chosenplayerAttackstart.DefRemove != 0){
      pkmnplayerstart2.Def = pkmnplayerstart2.Def - chosenplayerAttackstart.DefRemove;
        System.out.println(pkmnplayerstart2.pkmnName + "'s defense fell by " + chosenplayerAttackstart.DefRemove);
    }
    if (chosenplayerAttackstart.Heal != 0){
      pkmnplayerstart2.HP = pkmnplayerstart2.HP + chosenplayerAttackstart.Heal;
      System.out.println(pkmnplayerstart2.pkmnName + "healed " + chosenplayerAttackstart.Heal + " points!");
    }
    if (chosenplayerAttackstart.AttackAdd != 0){
        chosenplayerAttackstart.damage = chosenplayerAttackstart.damage + chosenplayerAttackstart.AttackAdd;
      System.out.println(pkmnplayerstart2.pkmnName + "'s attack rose by'" + chosenplayerAttackstart.AttackAdd);
    }
    if (chosenplayerAttackstart.DmgRecieve != 0){
          pkmnplayerstart2.HP = pkmnplayerstart2.HP - chosenplayerAttackstart.DmgRecieve;
      System.out.println(pkmnplayerstart2.pkmnName + " hurt itself by " + chosenplayerAttackstart.DmgRecieve);
    } 
    // various if statements above that activate if the move adds any attack, heals, adds defense, removes defense, etc.
    if (chosenplayerAttackstart.ChargeTurn == 2){
        chosenplayerAttackstart.ChargeTurn = 1;
      }
    if (chosenplayerAttackstart.Burnout == 1){
      pkmnplayerstart2.burnoutcounter = 2;
    // for charge turn and burnout features
  }
  }
  }









  
  public void CombatSystem (Pokemon pkmnplayerStart, Pokemon pkmnCPUstart){
    for (int ive = 0; ive < pkmnplayerStart.moveSet.size(); ive ++){
      System.out.println(pkmnplayerStart.moveSet.get(ive).attackName);
    }
    ArrayList <String> pokemonAttackChecker = new ArrayList<String>(3);
    for (int fromis9 = 0; fromis9 < pkmnplayerStart.moveSet.size(); fromis9 ++){
pokemonAttackChecker.add(pkmnplayerStart.moveSet.get(fromis9).attackName.toLowerCase());
    }
    // same thing as name checker but for attack names
    System.out.println("Would you like to see the move descriptions? (type yes to see and type anything else for no");
    String moveDescription = consoleInput.nextLine();
    if (moveDescription.equalsIgnoreCase("yes")){
      System.out.println("Note: Defense points reduce incoming attacks by half of your pokemon's defense value. So if Pikachu's defense is 20, all attacks are reduced by 10.");
      if (pokemonAttackChecker.contains("tail whip")){
        System.out.println("Tail Whip: Deals 15 damage to the opponent");
    }
      if (pokemonAttackChecker.contains("charge")){
          System.out.println("Charge: Adds 20 Defense to Pikachu ");
      }
      if (pokemonAttackChecker.contains("volt tackle")){
          System.out.println("Volt Tackle: Deals 40 damage but Pikachu loses 15 HP");
      }
      if (pokemonAttackChecker.contains("pyro ball")){
          System.out.println("Pyro Ball: Deals 30 damage");
      }
      if (pokemonAttackChecker.contains("iron defense")){
          System.out.println("Iron Defense: Adds 20 defense");
      }
      if (pokemonAttackChecker.contains("burn blast")){
          System.out.println("Burn Blast: Deals 55 damage but takes 1 turn to recover");
      }
      if (pokemonAttackChecker.contains("quick attack")){
          System.out.println("Quick Attack: Deals 15 damage");
      }
      if (pokemonAttackChecker.contains("swords dance")){
          System.out.println("Swords Dance: Permanently buffs all attacks by 10");
      }
      if (pokemonAttackChecker.contains("close combat")){
          System.out.println("Close Combat: Deals 45 damage but reduces Lucario's defense by 30");
      }
      if (pokemonAttackChecker.contains("razor leaf")){
          System.out.println("Razor Leaf: Deals 30 damage");
      }
      if (pokemonAttackChecker.contains("solar beam")){
          System.out.println("Solar Beam: Deals 60 damage but takes 1 turn to charge");
      }
      if (pokemonAttackChecker.contains("water gun")){
          System.out.println("Water Gun: Deals 15 damage");
      }
     
      if (pokemonAttackChecker.contains("surf")){
          System.out.println("Surf: Blastoise deals 30 damage but adds his current defense to his attack.");
      }
      if (pokemonAttackChecker.contains("pluck")){
          System.out.println("Pluck: Deals 20 damage");
      }
      if (pokemonAttackChecker.contains("aqua ring")){
          System.out.println("Aqua Ring: Heals 20 HP");
      }
      if (pokemonAttackChecker.contains("brave bird")){
          System.out.println("Brave Bird: Deals 40 damage but Cramorant recieves 20 damage to himself");
      }
    }
    // move descriptions to familiarize players
    while (pkmnplayerStart.HP > 0 && pkmnCPUstart.HP > 0){
      scannerChecker2 = 0;
      System.out.println(pkmnplayerStart.pkmnName + " has " + pkmnplayerStart.HP +  " Health Points");
      System.out.println(pkmnCPUstart.pkmnName + " has " + pkmnCPUstart.HP + " Health Points");
      System.out.println ("Please Select a move: ");
      while (scannerChecker2 != 1){
      String AttackWord = consoleInput.nextLine();
      if (!pokemonAttackChecker.contains(AttackWord.toLowerCase()) ){
        
        System.out.println("Not a valid Move. Please type a valid Move name");
        continue;
      }
      else {
        if (AttackWord.equalsIgnoreCase(pkmnplayerStart.moveSet.get(0).attackName)){
          chosenPlayerattack = pkmnplayerStart.moveSet.get(0);
          System.out.println ("You have selected " + chosenPlayerattack.attackName);
          scannerChecker2 = 1;
        }
       else if (AttackWord.equalsIgnoreCase(pkmnplayerStart.moveSet.get(1).attackName)){
          chosenPlayerattack = pkmnplayerStart.moveSet.get(1);
          System.out.println ("You have selected " + chosenPlayerattack.attackName);
          scannerChecker2 = 1;
        }
        else if (AttackWord.equalsIgnoreCase(pkmnplayerStart.moveSet.get(2).attackName)){
          chosenPlayerattack = pkmnplayerStart.moveSet.get(2);
          System.out.println ("You have selected " + chosenPlayerattack.attackName);
          scannerChecker2 = 1;
        }
      }
      
  }
      chosenCPUattack = pkmnCPUstart.moveSet.get((int) (Math.random()* pkmnCPUstart.moveSet.size()));
      // CPU chooses a random move. Whats werid is that the CPU tends to just pick the same move multiple times which is super werid and I'm not sure how to get around that bc it can get super annoying at times. Like a Cramorant that only heals 
      SystemAttack (pkmnplayerStart, chosenPlayerattack, pkmnCPUstart);
      System.out.println("Opponent used " + chosenCPUattack.attackName);
      SystemAttack (pkmnCPUstart, chosenCPUattack, pkmnplayerStart);
      // these 3 lines are the attack exchanges that repeat until a pokemon dies
}
}
  
  public void nextBattle(){
    scannerChecker = 0;
    if (currentCPUpkmn.HP <= 0){
      System.out.println(currentCPUpkmn.pkmnName + " has fainted");
      CPUpkmn.remove(currentCPUpkmn);
      if (CPUpkmn.isEmpty()){
        System.out.println("You have won the game!!");
        gameEnd = true;
      }
      // ending 1 = victory
      currentCPUpkmn = CPUpkmn.get((int) (Math.random()* CPUpkmn.size()));
      System.out.println ("Opponent sent out " + currentCPUpkmn.pkmnName + " to fight");
      if (currentPlayerpkmn.HP >= 0){
        // this above part is important so instances don't happen where both pokemon die and this method runs and then later it asks u again to select another pokemon
      System.out.println("Do you want to swap Pokémon? (type yes for yes or anything else for no)");
      String swap = consoleInput.nextLine();
      if (swap.equalsIgnoreCase("yes")){
        System.out.println("Choose which Pokémon to fight: ");
          for (int blackpink = 0; blackpink < playerpkmn.size(); blackpink ++){
            System.out.println(playerpkmn.get(blackpink).pkmnName);
          }
        while (scannerChecker != 1){
          String pokemonWord = consoleInput.nextLine();
          if (!pokemonNameChecker.contains(pokemonWord.toLowerCase())){
            System.out.println("Not a valid Pokémon. Please type a valid Pokémon name");
            continue;
          }
          else {
            if (pokemonWord.equalsIgnoreCase(pokemonNameChecker.get(0))){
              currentPlayerpkmn = playerpkmn.get(0);
              System.out.println ("You have selected " + currentPlayerpkmn.pkmnName + " here is its move set: ");
              scannerChecker = 1;
            }
            else if (pokemonWord.equalsIgnoreCase(pokemonNameChecker.get(1))){
              currentPlayerpkmn = playerpkmn.get(1);
              System.out.println ("You have selected " + currentPlayerpkmn.pkmnName + " here is its move set: ");
              scannerChecker = 1;
            }
            else if (pokemonWord.equalsIgnoreCase(pokemonNameChecker.get(2))){
              currentPlayerpkmn = playerpkmn.get(2);
              System.out.println ("You have selected " + currentPlayerpkmn.pkmnName + " here is its move set: ");
              scannerChecker = 1;
            }
          }
        }
      }
      else {
        System.out.println(currentPlayerpkmn.pkmnName + " stays in");
      }
      }
    }
    else if (currentPlayerpkmn.HP <= 0){
      System.out.println(currentPlayerpkmn.pkmnName + " has fainted");
      pokemonNameChecker.remove(currentPlayerpkmn.pkmnName);
      playerpkmn.remove(currentPlayerpkmn);
      // removes name from list so you can't cheese it and get a dead pokemon back
      if (playerpkmn.isEmpty()){
        System.out.println("You have lost :(");
        gameEnd = true;
      }
      System.out.println("Choose which Pokémon to continue the fight: ");
      for (int newjeans = 0; newjeans < playerpkmn.size(); newjeans ++){
        System.out.println(playerpkmn.get(newjeans).pkmnName);
      }
      while (scannerChecker != 1){
        String pokemonWord = consoleInput.nextLine();
        if (!pokemonNameChecker.contains(pokemonWord.toLowerCase())){
          System.out.println("Not a valid Pokémon. Please type a valid Pokémon name");
          continue;
        }
        else {
          if (pokemonWord.equalsIgnoreCase(pokemonNameChecker.get(0))){
            currentPlayerpkmn = playerpkmn.get(0);
            System.out.println ("You have selected " + currentPlayerpkmn.pkmnName + " here is its move set: ");
            scannerChecker = 1;
          }
          else if (pokemonWord.equalsIgnoreCase(pokemonNameChecker.get(1))){
            currentPlayerpkmn = playerpkmn.get(1);
            System.out.println ("You have selected " + currentPlayerpkmn.pkmnName + " here is its move set: ");
            scannerChecker = 1;
          }
          else if (pokemonWord.equalsIgnoreCase(pokemonNameChecker.get(2))){
            currentPlayerpkmn = playerpkmn.get(2);
            System.out.println ("You have selected " + currentPlayerpkmn.pkmnName + " here is its move set: ");
            scannerChecker = 1;
          }
        }
      }
  }
}
}
