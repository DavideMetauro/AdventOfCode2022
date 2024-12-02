package day9;

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveLeft() {
        x = x - 1;
    }

    public void moveRight() {
        x = x + 1;
    }

    public void moveUp() {
        y = y + 1;
    }

    public void moveDown() {
        y = y - 1;
    }

    public void getCloser(Point p) {

        if ((this.getY() - p.getY()) > 1) {
            this.moveDown();
            this.x=p.getX();
        } 
         if ((this.getY() - p.getY()) < -1) {
            this.moveUp();
            this.x=p.getX();
        }
        if ((this.getX() - p.getX()) > 1) {
            this.moveLeft();
            this.y=p.getY();
        } 
         if ((this.getX() - p.getX()) < -1) {
            this.moveRight();
            this.y=p.getY();
        }

    }

    @Override
    public boolean equals(Object p) {
        return this.x == ((Point) p).getX() && this.y == ((Point) p).getY();

    }

    @Override
    public String toString() {
        return "[ " + x + " , " + y + " ]";
    }

    @Override
    public int compareTo(Point o) {
        if(this.x==o.getX() && this.y==o.getY()) return 0;
        else if(this.x==o.getX()){
            return this.y-o.getY();
        }else return this.x-o.getX();
    }

}
