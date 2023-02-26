// Point class with values x and y values to store the co-ordinates.
public class Point
{
	public double x, y;
	public long t;
	// default constructor
	public Point(){
		this.x = 0; this.y = 0;
		this.t=0;
	}
	//constructor to initialize x and y
	public Point(double x, double y, long t)
	{	this.x = x; this.y = y; this.t=t;	}
	
	public double distance( Point other)
  {
    return Math.sqrt(Math.pow(other.x-x,2)+Math.pow(other.y-y ,2));
  }
  public double getX(){
	return this.x;
  }
  public double getY(){
	return this.y;
  }
  public double getTime(){
		return this.t;
  }
}