package cover;

/*Represents single integer.*/
public class Element extends Component{
  int point;

  public Element(int point){
    this.point = point;
  }

  public boolean canImproveOccupied(boolean[] occupied){
    if(this.point >= occupied.length) return false;
    return (occupied[this.point] == false);
  }

  public void completeOccupied(boolean[] occupied){
    if(this.point >= occupied.length) return;
    occupied[this.point] = true;
  }

}
