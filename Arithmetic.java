package cover;

/*Represents arithmetic progression limited in advance by the number.
Limit can be equal to infinity – in this case the limit is represented by
Integer.MAX_VALUE. */
public class Arithmetic extends Component{
  int point;
  int difference;
  int limit;

  /*The limit is not equal to infinity.*/
  public Arithmetic(int point, int difference, int limit){
    this.point = point;
    this.difference = difference;
    this.limit = limit;
  }

  /*The limit is equal to infinity.*/
  public Arithmetic(int point, int difference){
    this.point = point;
    this.difference = difference;
    this.limit = Integer.MAX_VALUE;
  }

  public boolean canImproveOccupied(boolean[] occupied){
    for(int i = point; i <= limit && i > 0 && i < occupied.length; i += difference){
      if(occupied[i] == false) return true;
    }
    return false;
  }

  public void completeOccupied(boolean[] occupied){
    for(int i = point; i <= limit && i >= 0 && i < occupied.length; i += difference){
      occupied[i] = true;
    }
  }
}
