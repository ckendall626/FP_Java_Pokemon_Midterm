import java.util.ArrayList;
class Pokemon {
  String pkmnName;
  int HP;
  int Def;
  String pkmnType;
  int burnoutcounter;
  ArrayList <Attack> moveSet = new ArrayList <Attack> (3);

  public Pokemon (String startpkmnName, int startHP, String startpkmnType, int startDef) {
    // constructor for the pokemon
    HP = startHP;
    Def = startDef;
    pkmnType = startpkmnType;
    if (startpkmnName.equals("Pikachu")){
      pkmnName = startpkmnName;
      moveSet.add(new Attack("Tail Whip"));
      moveSet.add(new Attack("Charge"));
      moveSet.add(new Attack("Volt Tackle"));
    }
    else if (startpkmnName.equals("Lucario")){
      pkmnName = startpkmnName;
      moveSet.add(new Attack("Quick Attack"));
      moveSet.add(new Attack("Swords Dance"));
      moveSet.add(new Attack("Close Combat"));
    }
    else if (startpkmnName.equals("Cinderace")){
      pkmnName = startpkmnName;
      moveSet.add(new Attack("Pyro Ball"));
      moveSet.add(new Attack("Iron Defense"));
      moveSet.add(new Attack("Burn Blast"));
    }
    else if (startpkmnName.equals("Leafeon")){
      pkmnName = startpkmnName;
      moveSet.add(new Attack("Razor Leaf"));
      moveSet.add(new Attack("Swords Dance"));
      moveSet.add(new Attack("Solar Beam"));
    }
    else if (startpkmnName.equals("Blastoise")){
      pkmnName = startpkmnName;
      moveSet.add(new Attack("Water Gun"));
      moveSet.add(new Attack("Iron Defense"));
      moveSet.add(new Attack("Surf"));
    }
    else if (startpkmnName.equals("Cramorant")){
      pkmnName = startpkmnName;
      moveSet.add(new Attack("Pluck"));
      moveSet.add(new Attack("Aqua Ring"));
      moveSet.add(new Attack("Brave Bird"));
    }
  }

}