package Interpreter;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by sarleon on 16-5-5.
 */
public class Interpreter {
    private char[] codes;
    private int pointer;
    private char[] params;
    private int paramPointer=0;
    private char[] memory;
    public Interpreter(String code,String param){
        this.codes=code.toCharArray();
        String[] paramStr=param.split(" ");
        params=new char[paramStr.length];
        try {

            for (int i = 0; i < paramStr.length; i++) {
                params[i]=paramStr[i].charAt(0);
            }
            pointer=0;

        } catch (IndexOutOfBoundsException e){

        }
        memory=new char[100];

    }
    public static void main(String[] args) throws IOException{
        System.out.println(new Interpreter(",>++++++[<-------->-],,[<+>-],<.>.","3 4").interpret());
    }
    private void expandMemory(){

        int capacity=this.memory.length*2;
        char[] newmemory=new char[capacity];
        for (int i = 0; i < this.memory.length; i++) {
            newmemory[i]=this.memory[i];
        }
        this.memory=newmemory;

    }


    public String  interpret() throws IOException {
        StringBuilder stringBuilder=new StringBuilder();

        String result=null;
        Scanner scanner=new Scanner(System.in);

        for (int i = 0; i <codes.length ; i++) {
            switch (codes[i]){
                case '+':memory[pointer]++;
                    break;
                case '-':memory[pointer]--;
                    break;
                case '>':if(pointer==memory.length)
                    expandMemory();
                    pointer++;
                    break;
                case '<':pointer--;break;
                case ',':try {
                    memory[pointer]=params[paramPointer++];
                } catch (IndexOutOfBoundsException e){

                }break;
                case '.':stringBuilder.append(memory[pointer]);break;
                case '[':if(i>=0&&i<codes.length){
                    if(memory[pointer]==0){
                        while (codes[i]!=']'){
                            i++;
                        }
                    }
                } else {

                }
                    break;
                case ']':if(i>=0&&i<codes.length) {
                    if (memory[pointer] != 0){
                        while (codes[i]!='['){
                            i--;
                        }
                    }
                }
            }

        }
        result=stringBuilder.toString();
        System.out.println(result);
        return result;
    }

}
