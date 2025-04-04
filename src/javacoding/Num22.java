package javacoding;

class Rectangle{
    int x, y, width, height;

    Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public int square(){
        return width * height;
    }
    public void show(){
        System.out.println("Rectangle at (" + x + "," + y + ") with area " + square());
    }
    boolean contains(Rectangle r){
        /*r의 왼쪽 하단 꼭지점이 현재 사각형의 왼쪽 하단 보다 오른쪽 또는 같은 위치에 있고
        */
        return r.x >= this.x && r.y >= this.y &&
                r.x + r.width <= this.x + this.width &&
                r.y + r.height <= this.y + this.height;
    }
}

public class Num22 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 2, 8, 7);
        Rectangle s = new Rectangle(5, 5, 6, 6);
        Rectangle t = new Rectangle(1, 1, 10, 10);

        r.show();
        System.out.println("Area : " + s.square());

        if(t.contains(r)){
            System.out.println("t includes r");
        }
        if(t.contains(s)){
            System.out.println("t includes s");
        }
    }
}
