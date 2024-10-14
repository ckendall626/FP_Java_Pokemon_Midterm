class Attack {
  String attackName;
  int damage;
  int DefAdd;
  int DefRemove;
  int Heal;
  int AttackAdd;
  int DmgRecieve;
  int ChargeTurn;
  int Burnout;
  // all the different things attacks can do

  public void AttackSetUp (String thestartAttackName, int startDamage, int startDefAdd, int startDefRemove, int startHeal, int startAttackAdd, int startDmgRecieve, int startChargeTurn, int startBurnout) {
    attackName = thestartAttackName;
    damage = startDamage;
    DefAdd = startDefAdd;
    DefRemove = startDefRemove;
    Heal = startHeal;
    AttackAdd = startAttackAdd;
    DmgRecieve = startDmgRecieve;
    ChargeTurn = startChargeTurn;
    Burnout = startBurnout;
    // method to help set up the attacks
  }
  public Attack (String startAttackName) {
    if (startAttackName.equals("Tail Whip")) {
      AttackSetUp(startAttackName, 20, 0, 0, 0, 0, 0, 0, 0);
    }
    else if (startAttackName.equals("Charge")) {
      AttackSetUp(startAttackName, 0, 20, 0, 0, 0, 0, 0, 0);
  }
    else if (startAttackName.equals("Volt Tackle")) {
      AttackSetUp(startAttackName, 40, 0, 0, 0, 0, 15, 0, 0);
    }
    else if (startAttackName.equals("Quick Attack")) {
      AttackSetUp(startAttackName, 15, 0, 0, 0, 0, 0, 0, 0);
    }
    else if (startAttackName.equals("Swords Dance")) {
      AttackSetUp(startAttackName, 0, 0, 0, 0, 10, 0, 0, 0);
    }
    else if (startAttackName.equals("Close Combat")) {
      AttackSetUp(startAttackName, 45, 0, 30, 0, 0, 0, 0, 0);
    }
    else if (startAttackName.equals("Pyro Ball")) {
      AttackSetUp(startAttackName, 30, 0, 0, 0, 0, 0, 0, 0);
    }
    else if (startAttackName.equals("Counter")) {
      AttackSetUp(startAttackName, 0, 0, 0, 0, 0, 0, 0, 0);
    }
    else if (startAttackName.equals("Burn Blast")) {
      AttackSetUp(startAttackName, 55, 0, 0, 0, 0, 0, 0, 1);
    }
    else if (startAttackName.equals("Razor Leaf")) {
      AttackSetUp(startAttackName, 30, 0, 0, 0, 0, 0, 0, 0);
    }
    else if (startAttackName.equals("Solar Beam")) {
      AttackSetUp(startAttackName, 45, 0, 0, 0, 0, 0, 1, 0);
    }
    else if (startAttackName.equals("Water Gun")) {
      AttackSetUp(startAttackName, 15, 0, 0, 0, 0, 0, 0, 0);
    }
    else if (startAttackName.equals("Iron Defense")) {
      AttackSetUp(startAttackName, 0, 20, 0, 0, 0, 0, 0, 0);
    }
    else if (startAttackName.equals("Surf")) {
      AttackSetUp(startAttackName, 30, 0, 0, 0, 0, 0, 0, 0);
    }
    else if (startAttackName.equals("Pluck")) {
      AttackSetUp(startAttackName, 20, 0, 0, 0, 0, 0, 0, 0);
    }
    else if (startAttackName.equals("Aqua Ring")) {
      AttackSetUp(startAttackName, 0, 0, 0, 20, 0, 0, 0, 0);
    }
    else if (startAttackName.equals("Brave Bird")) {
      AttackSetUp(startAttackName, 40, 0, 0, 0, 0, 20, 0, 0);
    }
    // sets up all acttacks using overloading stuff and calling on another constructor. could not figure out the this() method though, but this works as intended
}
}