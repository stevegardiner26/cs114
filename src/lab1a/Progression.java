package lab1a;
/**
* A class for numeric progression */

public class Progression {

/** First value of the progression */
protected long first;

/** Current value of the progrssion */

protected long cur;


/** Default constructor */

Progression() {
   cur = first = 0;
 }
 
 /* Resets the progression to the first value and return first value */
 
 protected long firstValue() {
  cur = first;
  return cur;
  }
  
  /* Advances the progression to the next value and return next value of the progssion */
  
  protected long nextValue() {
  return ++ cur;
  }
  
  /** Prints the fist n values of the progression */
  
  public void printProgression(long n) {
  System.out.print(firstValue());
   for (int i=2; i<=n; i++)
    System.out.print(" "+nextValue());
    System.out.println();
  }
}