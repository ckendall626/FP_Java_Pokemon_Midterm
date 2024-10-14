class Main {
  public static void main(String[] args) {
    Game g = new Game();
    g.gamePrep();
   while (g.gameEnd != true){
     g.CombatSystem (g.currentPlayerpkmn, g.currentCPUpkmn);
     g.nextBattle();
     // also this loop runs the game specifically the attack methods and the method used to change pokemon and it ends once one player has no more pokemon left
     // returns exception in "main" once game ends but everything else works
   }
  
      
    
    
  }
}