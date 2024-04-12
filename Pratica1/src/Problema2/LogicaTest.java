package Problema2;

public class LogicaTest {
    public static void main(String[] args) { 
        
        System.out.println("Teste 1: ");
        Logica teste1 = new Logica(9, 11);
        teste1.logicaA();
        //teste1.logicaB();

        System.out.println();

        System.out.println("Teste 2: ");
        Logica teste2 = new Logica(11, 9);
        //teste2.logicaA();
        teste2.logicaB();
    
    }
}