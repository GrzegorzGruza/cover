package cover;

/*Represents an Array of integers, that can increase in size of elements*/
public class Vector{
  public int[] array = new int[1];
  int length = 0;
  private int realLength = 1;

  public void add(int e){
    if(length == realLength){
      realLength *= 2;
      int[] newArray = new int[realLength];
      for(int i = 0; i < length; i++){
        newArray[i] = array[i];
      }
      array = newArray;
    }
    array[length] = e;
    length++;
  }

  /*Returns an array with integers belonging to the Vector.*/
  public int[] makeArray(){
    int[] toReturn = new int[length];
    for(int i = 0; i < length; i++){
      toReturn[i] = array[i];
    }
    return toReturn;
  }
}
