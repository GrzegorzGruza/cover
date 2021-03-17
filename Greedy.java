package cover;

import java.util.Arrays;

/*Represents greedy algorithm.*/
public class Greedy extends Algorithm{

  public int[] findCover(Family family, int interval){
    boolean[] occupied = new boolean[interval + 1];
    Vector result = new Vector();
    int numberOfOccupied = 0;
    int maxImprovement = 0;
    int theBestI = 0;
    int improvement = 0;

    while(numberOfOccupied != interval){
      maxImprovement = 0;
      for(int i = 0; i < family.length; i++){
        improvement = family.sets[i].howMuchCanItImprove(occupied);
        if(improvement > maxImprovement){
          maxImprovement = improvement;
          theBestI = i;
        }
      }
      if(maxImprovement == 0){
        return failure;
      }
      family.sets[theBestI].completeOccupied(occupied);

      result.add(theBestI + 1);
      numberOfOccupied += maxImprovement;
    }
    int[] toReturn = result.makeArray();
    Arrays.sort(toReturn);

    return toReturn;
  }
}
