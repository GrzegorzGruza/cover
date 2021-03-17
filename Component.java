package cover;

/*Represents sets of integer values.*/
public abstract class Component{

  /*Checks if there is thery is an integer 'e' belonging to the Component,
  such that occupied[e] = false.*/
  abstract boolean canImproveOccupied(boolean[] occupied);

  /*For each integer 'e' in Component, sets occupied[e] to true.*/
  abstract void completeOccupied(boolean[] occupied);
}
