import java.util.ArrayList;
import java.util.Scanner;

public class Simpletron extends Operations {
    
    private Integer instructionCounter = 0;
    private Integer instructionRegister = 0; 
    private Integer operationCode = 0;
    private Integer operand = 0;
    private Integer accumulator = 0;
    protected Boolean end = false;

    private final ArrayList<Integer> memory = new ArrayList<>();
    
    public Simpletron() {
        for (int i = 0; i < 100; i++) {
            memory.add(0);
        }
    }
    
    
    public void newInstruction(Integer input) {
        
        memory.set(instructionCounter, input);
        
        instructionRegister = input;
        operationCode = instructionRegister / 100;
        operand = instructionRegister % 100;
        
        operation();
        
    }
    
    public void Error() {
        System.out.println("*** Simpletron execution abnormally terminated ***");
        end = true;
    }
    
    public void checkAccumulator(Integer accumulator) {
        if (accumulator < -9999 || accumulator > 9999)
            Error();
        
    }
    
    public void operation() {
        
        switch (operationCode) {
            
            case READ:
                
                Scanner sc = new Scanner(System.in);
                Integer value;
                
                do {
                    System.out.println("Enter an integer: ");
                    value = sc.nextInt();
                    
                    if (-9999 <= value || value <= 9999)
                        memory.set(operand, value);
                    else
                        System.out.println("*** Value out of range ***");
                    
                } while (-9999 > value || value > 9999);
                break;
            
            case WRITE:
                
                Integer val = memory.get(operand);
                System.out.println(val);
                break;
            
            case LOAD:
                
                accumulator = memory.get(operand);
                break;
                
            case HALT:
                System.out.println("*** Simpletron execution terminated ***");
                end = true;
                break;
            
            case STORE:
                memory.set(operand, accumulator);
                break;
                
            case ADD:
                accumulator += memory.get(operand);
                break;
            
            case SUBTRACT:
                accumulator -= memory.get(operand);
                break;
                
            case MULTIPLY:
                accumulator *= memory.get(operand);
                break;
                
            case DIVIDE:
                if (memory.get(operand) != 0)
                    accumulator /= memory.get(operand);
                else {
                    System.out.println("*** Division by Zero. ***");
                    Error();
                }
                break;
                
            case BRANCH:
                instructionCounter = operand;
                break;
            
            case (BRANCHNEG):
                if (accumulator < 0)
                    instructionCounter = operand;
                break;
                
            case (BRANCHZERO):
                if (accumulator < 0)
                        instructionCounter = operand;
                    break;
                    
            }
            
            if (operationCode != BRANCH && operationCode != BRANCHNEG && operationCode != BRANCHZERO)
                instructionCounter++;
            
            
            if (end) {
                dump();
                System.exit(0);
            
                
                
        }
        
        
    }
    
    public Integer getInstructionCounter() {
        return instructionCounter;
    }
    
    public void dump() {
        
        System.out.println("REGISTERS: ");
        System.out.printf("accumulator: %+04d%n", accumulator);
        System.out.printf("instructionCounter: %+02d%n", instructionCounter);
        System.out.printf("instructionRegister: %+04d%n", instructionRegister);
        System.out.printf("operationCode: %+04d%n", operationCode);
        System.out.printf("operand: %+02d%n", operand);
        
        System.out.println("MEMORY: ");
        for (int i = 0; i < 100; i += 10) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%3d ", memory.get(i+j));
            }
            System.out.println();
        }

        
    }


 }