package cover;

/*Represents an algorithm finding a solution to the set cover problem.*/
abstract class Algorithm{

  /*Result of findCover failure. Returned by the function findCover
  if is not possible to cover the set. */
  int[] failure = new int[1];

  /*Returns Array of indexes - Sets coverng [1, interfal]
  or failure if it is not possible.*/
  abstract int[] findCover(Family family, int interval);
}
