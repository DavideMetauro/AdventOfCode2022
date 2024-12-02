package Advent;
public class Stopwatch {

   private long startTime = -1;
   private long stopTime = -1;
   private boolean running = false;

   public Stopwatch start() {
      startTime = System.nanoTime();
      running = true;
      return this;
   }

   public Stopwatch stop() {
      stopTime = System.nanoTime();
      running = false;
      return this;
   }

   /**
    * returns elapsed time in milliseconds
    * if the watch has never been started then
    * return zero
    */
   public double getElapsedTime() {
      if (startTime == -1) {
         return 0;
      }
      if (running) {
         return (System.nanoTime() - startTime) / 1000000.0;
      } else {
         return (stopTime - startTime) / 1000000.0;
      }
   }

   public void printParsedTime(){
      double time=getElapsedTime();
      String notation[] = {"s", "ms", "µs", "ns"};
      int i=1;
      if (time>1000){
         i--;
         time=time/1000;
      }else {
         while (time<1) {
            time=time*1000;
            i++;
         }
      }
      System.out.println(time+" "+notation[i]);
   }

   public Stopwatch reset() {
      startTime = -1;
      stopTime = -1;
      running = false;
      return this;
   }
}