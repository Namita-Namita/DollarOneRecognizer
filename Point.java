/*
 * @author Namita Namita
 */
// Point class with values x, y, t values to store the co-ordinates and time t.
public class Point
{
	public double x, y;
	public long t;
	// default constructor point to set all values to 0
	public Point(){
		this.x = 0; this.y = 0;
		this.t=0;
	}
	//constructor to initialize x, y coordinated and time t
	public Point(double x, double y, long t)
	{	this.x = x; this.y = y; this.t=t;	}
	
	// distance method to compute distance between two points
	public double distance( Point other)
  {
    return Math.sqrt(Math.pow(other.x-x,2)+Math.pow(other.y-y ,2));
  }
  // getters methods for x, y and t
  public double getX(){
	return this.x;
  }
  public double getY(){
	return this.y;
  }
  public long getTime(){
		return this.t;
  }
}