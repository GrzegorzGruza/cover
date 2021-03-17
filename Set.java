package cover;

/*Represents set of Components*/
public class Set{
  Component[] components = new Component[1];
  int length = 0;
  private int realLength = 1;

  public void add(Component e){
    if(length == realLength){
      realLength *= 2;
      Component[] newArray = new Component[realLength];
      for(int i = 0; i < length; i++){
        newArray[i] = components[i];
      }
      components = newArray;
    }
    components[length] = e;
    length++;
  }

  /*For each integer 'e' belonging to some Component in Set,
  sets occupied[e] to true.*/
  public void completeOccupied(boolean[] occupied){
    for(int i = 0; i < this.length; i++){
      components[i].completeOccupied(occupied);
    }
  }

  /*Checks if there is thery is an integer 'e' belonging to some Component
  in Set, such that occupied[e] = false.*/
  public boolean canImproveOccupied(boolean[] occupied){
    for(int i = 0; i < this.length; i++){
      if(components[i].canImproveOccupied(occupied)) return true;
    }
    return false;
  }

  /*Counts how many Integer 'e' belonging to some Component
  in Set, satisfy occupied[e] = false.*/
  public int howMuchCanItImprove(boolean[] occupied){
    boolean[] newOccupied = new boolean[occupied.length];
    completeOccupied(newOccupied);

    int toReturn = 0;
    for(int i = 0; i < occupied.length; i++){
      if(!occupied[i] && newOccupied[i]) toReturn++;
    }
    return toReturn;
  }
}
