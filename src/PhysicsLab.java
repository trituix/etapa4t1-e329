public class PhysicsLab {
   public static void main(String[] args) {
      if (args.length != 3)  {
        System.out.println("usage: java PhysicsLab <delta_time[s]> <end_time[s]> <sampling_time[s]>");
        System.exit(-1);
      }
      double deltaTime = Double.parseDouble(args[0]);    // [s]
      double endTime = Double.parseDouble(args[1]);      // [s]
      double samplingTime = Double.parseDouble(args[2]); // [s]
      MyWorld world = new MyWorld(System.out);
      
      double mass = 1.0;      // 1 [kg] 
      double radius = 0.1;    // 10 [cm] 
      double position = 0;  // 0 [m] 
      double speed = 0;     // 0 [m/s]
      FixedHook fh0 = new FixedHook(position);
      Ball b0 = new Ball(mass, radius, 1.5, 1);
      Ball b1 = new Ball(mass, radius, 2, 0);
      Spring spring = new Spring(1.0, 1.0);
      spring.attachEnd(fh0);
      spring.attachEnd(b0);
      //spring.attachEnd(b1);
      
      world.addElement(spring);
      world.addElement(fh0);
      world.addElement(b0);
      world.addElement(b1);
      world.simulate(deltaTime, endTime, samplingTime); // delta time[s], total simulation time [s].
   }
}