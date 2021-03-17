package cover;

/*Represents the family of Sets*/
public class Family{
  public Set[] sets = new Set[1];
  public int length = 0;
  private int realLength = 1;

  public void add(Set e){
    if(length == realLength){
      realLength *= 2;
      Set[] newArray = new Set[realLength];
      for(int i = 0; i < length; i++){
        newArray[i] = sets[i];
      }
      sets = newArray;
    }
    sets[length] = e;
    length++;
  }
}
