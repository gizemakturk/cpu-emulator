import java.io.*;
import java.util.Scanner;

/**
 * gizem aktürk
 * 20190808053
 * 21.05.2022
 */
public class Midterm_20190808053 {
    static int ac=0;
    static int flag=0;
    static int [] memory=new int[256];
    public static void main(String[] args)  throws FileNotFoundException{
        Scanner text = new Scanner(new File(args[0]));
        int linenumber=0;
        while(text.hasNextLine()) {
            String line=text.nextLine();
            linenumber ++;
        }
        String [][] instructions=new String[linenumber][];
        linenumber=0;
        text=new Scanner(new File(args[0]));
        while(text.hasNextLine()) {
            String line=text.nextLine();
            String splitlines[]=line.split(" ");
            String[] codes = new String[2];
            if(splitlines.length>1){
                codes[0]=splitlines[0];
                codes[1]=splitlines[1];
                instructions[linenumber] = codes;
            }else{
                codes[0]=splitlines[0];
                instructions[linenumber] = codes;
            }
            linenumber++;
        }
        if (instructions[0][0].equals("START")){
            for (int programcounter = 1; programcounter < instructions.length; programcounter++) {
                switch (instructions[programcounter][0]) {
                    case "LOAD":
                        ac=Integer.parseInt(instructions[programcounter][1]);
                        break;
                    case "LOADM":
                        ac=memory[Integer.parseInt(instructions[programcounter][1])];
                        break;
                    case "STORE":
                       memory[Integer.parseInt(instructions[programcounter][1])]=ac;
                        break;
                    case "CMPM":
                        if(ac>memory[Integer.parseInt(instructions[programcounter][1])]){
                            flag=1;
                        }else if(ac<memory[Integer.parseInt(instructions[programcounter][1])]){
                            flag=-1;
                        }else
                            flag=0;
                        break;
                    case "CJMP":
                        if(flag>0){
                        programcounter=Integer.parseInt(instructions[programcounter][1]) - 1;
                        }
                        break;
                    case "JMP":
                        programcounter=Integer.parseInt(instructions[programcounter][1]) - 1;
                        break;
                    case "ADD":
                        ac=Integer.parseInt(instructions[programcounter][1])+ac;
                        break;
                    case "ADDM":
                       ac=memory[Integer.parseInt(instructions[programcounter][1])]+ac;
                        break;
                    case "SUBM":
                        ac=ac-memory[Integer.parseInt(instructions[programcounter][1])];
                        break;
                    case "SUB":
                        ac=ac-Integer.parseInt(instructions[programcounter][1]);
                        break;
                    case "MUL":
                        ac=ac*Integer.parseInt(instructions[programcounter][1]);
                        break;
                    case "MULM":
                        ac=ac*memory[Integer.parseInt(instructions[programcounter][1])];
                        break;
                    case "DISP":
                        System.out.println(ac);
                        break;
                    case "HALT":
                        System.exit(0);
                        break;
                }
            }
        }
    }
}

