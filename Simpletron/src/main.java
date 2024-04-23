import java.util.Scanner;

public class main {
    
    public static void main(String[] args) {
        
        //Prints solicitados
        System.out.println("*** Welcome to Simpletron! ***");
        System.out.println("*** Please enter your program one instruction ***");
        System.out.println("*** (or data word) at a time. I will display ***");
        System.out.println("*** the location number and a question mark (?). ***");
        System.out.println("*** You then type the word for that location. ***");
        System.out.println("*** Type -99999 to stop entering your program. ***");
        
        //Cria memória no Simpletron;
        
        Simpletron simpletron = new Simpletron();
        
        //Instancia sc do Scanner;
        Scanner sc = new Scanner(System.in);
        
        Integer input = 0;
        
        while (input != -99999) {
            
            System.out.printf("%02d ? ", simpletron.getInstructionCounter());
            input = sc.nextInt();
            simpletron.newInstruction(input);
        
        }
            
            
        System.out.println("*** Program loading completed ***");
        System.out.println("*** Program execution begins ***");
        
        }
        
    }