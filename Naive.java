package cover;

/*Represents naive algorithm.*/
public class Naive extends Algorithm{

  public int[] findCover(Family family, int interval){
    boolean[] occupied = new boolean[interval + 1];
    Vector result = new Vector();

    for(int i = 0; i < family.length; i++){
      if(family.sets[i].canImproveOccupied(occupied)){
        family.sets[i].completeOccupied(occupied);
        result.add(i + 1);
      }
    }
    for(int i = 1; i < occupied.length; i++){
      if(!occupied[i]) return failure;
    }
    return result.makeArray();
  }
}
