public class Rectangle implements RectangleInterface, Comparable<Rectangle>{ 
    private double length;
    private double width;
    
    public Rectangle(double l, double w){
        this.length = l;
        this.width = w;
    }
    
    public void setLength(double l){
        this.length = l;
    }
    
    public void setWidth(double w){
        this.width = w;
    }
    
    public double getLength(){
        return length;
    }
	public double getWidth(){
        return width;
    }
    
    public double getPerimeter()  {
        return getWidth()*2+getLength()*2;
    }
    
    public int compareTo(Rectangle x){
        return (int)(this.getPerimeter() - x.getPerimeter());
    }
    public String toString (){
        return "Length: " + getLength() + " Width: " + getWidth();
    }
}
