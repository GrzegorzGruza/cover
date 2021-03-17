package cover;

/*Represents Algorithm giving the exact result.*/
public class Exact extends Algorithm{

  /*Checks if sets in family for which the choosen value is true
  cover [1, interval]*/
  private boolean isCover(Family family, boolean[] choosen, int interval){
    boolean[] occupied = new boolean[interval + 1];
    for(int i = 0; i < family.length; i++){
      if(choosen[i] == false) continue;
      family.sets[i].completeOccupied(occupied);
    }
    for(int i = 1; i <= interval; i++){
      if(occupied[i] == false) return false;
    }
    return true;
  }

  /*Returns indexes of choosen, for wich the choosen value is true*/
  private int[] makeAnswer(boolean[] choosen){
    Vector result = new Vector();
    for(int i = 0; i < choosen.length; i++){
      if(choosen[i]) result.add(i + 1);
    }
    return result.makeArray();
  }

  /*Sets choosen array for first next arreangement (in lexicographic order)
  with the same number of 'true' falues.
  Returns true if it is possible and false otherwise.*/
  private boolean nextArrangement(boolean[] choosen){
    int lastChoosen = choosen.length - 1;
    while(!choosen[lastChoosen]) lastChoosen--;

    if(lastChoosen != choosen.length - 1){
      choosen[lastChoosen] = false;
      choosen[lastChoosen + 1] = true;
      return true;
    }

    int lastNotChoosen = lastChoosen;
    while(choosen[lastNotChoosen]){
      if(lastNotChoosen == 0) return false;
      lastNotChoosen--;
    }
    if(lastNotChoosen == 0) return false;

    int newStart = lastNotChoosen;
    while(!choosen[newStart - 1]){
      if(newStart == 1) return false;
      newStart--;
    }
    int numberOfSets = lastChoosen - lastNotChoosen;
    for(int i = 0; i < numberOfSets; i++) choosen[choosen.length - 1 - i] = false;
    choosen[newStart - 1] = false;
    for(int i = 0; i < numberOfSets + 1; i++) choosen[newStart + i] = true;

    return true;
  }

  public int[] findCover(Family family, int interval){
    boolean[] choosen = new boolean[family.length];
    for(int numberOfChoosen = 1; numberOfChoosen <= interval; numberOfChoosen++){
      for(int i = 0; i < numberOfChoosen; i++) choosen[i] = true;
      for(int i = numberOfChoosen; i < family.length; i++) choosen[i] = false;

      if(isCover(family, choosen, interval)) return makeAnswer(choosen);
      while(nextArrangement(choosen)){
        if(isCover(family, choosen, interval)) return makeAnswer(choosen);
      }
    }
    return failure;
  }
}
