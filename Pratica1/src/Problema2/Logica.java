package Problema2;

public class Logica {
    
    private int x;
    private int y;

    public Logica(int x, int y) {
    
        this.x = x;
        this.y = y;

    }

    public void logicaA() {

        if (x < 10)
            if (y > 10)
            System.out.println("*****");
        else
            System.out.println("#####");
            System.out.println("$");

    }

    public void logicaB() {
        
        if (x < 10)
        {
            if (y > 10)
            System.out.println("*****");
        }
        else
        {
            System.out.println("#####");
            System.out.println("$");
        }

    }

}