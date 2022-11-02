public class Sierpinski {
    //This is a project that can draw the sierpinski triangle reclusively! 
    public static void main (String[] args){
        int n = Integer.parseInt(args[0]);
        int length = 1;

        StdDraw.line(0.0 , 0.0, 1.0, 0.0);
        StdDraw.line(1.0, 0.0, 0.5, height(length));
        StdDraw.line(0.5, height(length), 0.0, 0.0);

        double x_value = 0.5;
        double y_value = 0;
        
        sierpinski(n, x_value, y_value, length);
    }
    public static double height(double length){
        double height = length * Math.sqrt(3.0) / 2; 

        return height;
    }
    public static void filledTriangle(double x, double y, double length){
        double x_value2 = x - length/4;
        double y_value2 = y + height(length)/2;

        double x_value3 = x + length/4;
        double y_value3 = y + height(length)/2;

        double [] allxvalues = {x, x_value2, x_value3};
        double [] allyvalues = {y, y_value2, y_value3};

        StdDraw.filledPolygon(allxvalues, allyvalues);
    }
    public static void sierpinski(int n, double x, double y, double length) {
        if(n == 0){
            return;
        }
        else{
            filledTriangle(x, y, length);
            sierpinski(n - 1, x - (length/4) , y, length/2);
            sierpinski(n - 1 , x + (length/4), y, length/2);
            sierpinski(n - 1, x , y + height(length)/2, length/2);
        }
    }
}