package cover;

import java.util.Scanner;
import java.util.Arrays;

/*First Object-oriented programming project: set cover problem.*/
public class Main{

  public static void main (String [] args) {
    Scanner scan = new Scanner(System.in);
    Family family = new Family();
    Naive naive = new Naive();
    Greedy greedy = new Greedy();
    Exact exact = new Exact();
    int a, b, c;
    int[] result;

    while(scan.hasNext()){
      a = scan.nextInt();

      if(a < 0){//question
        b = scan.nextInt();
        if(b == 1) result = exact.findCover(family, -a);
        else if(b == 2) result = greedy.findCover(family, -a);
        else result = naive.findCover(family, -a);

        System.out.print(result[0]);
        for(int i = 1; i < result.length; i++) System.out.print(" " + result[i]);
        System.out.print("\n");
      }
      else{//new set
        Set set = new Set();
        while(true){
          if(a == -1) a = scan.nextInt();
          if(a == 0){
            family.add(set);
            break;
          }
          b = scan.nextInt();
          if(b >= 0){//Element
            set.add(new Element(a));
            a = b;
            continue;
          }
          else{
            c = scan.nextInt();
            if(c >= 0){//infinity arithmetic progression
              set.add(new Arithmetic(a, -b));
              a = c;
              continue;
            }
            else{//finity arithmetic progression
              set.add(new Arithmetic(a, -b, -c));
              a = -1;
            }
          }
        }
      }
    }
  }
}
