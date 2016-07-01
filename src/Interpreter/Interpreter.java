package Interpreter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String[] paramStr=param.split("\\+|-|\\*|/");
        ArrayList<Character> al=new ArrayList<Character>();
        Pattern pattern=Pattern.compile("[a-zA-Z0-9]");
        Matcher matcher=pattern.matcher(param);

        int iter=0;
        while (matcher.find()){
            al.add(matcher.group().charAt(0));
        }
        params=new  char[al.size()];
        for (int i = 0; i < al.size(); i++) {
            params[i]=al.get(i);
        }
        pointer=0;



        memory=new char[200];

    }
    public static void main(String[] args) throws IOException{
        System.out.println(new Interpreter( "++++++++[>+++++++++[>+>+>+>+>+>+<<<<<<-]<-]++++++[>++++++[>>+>-<<<-]<-]>>>--->---->++++++>++>+++++++++++++<<<<<.>.>.>.>.>.","3 4").interpret());
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
        int bracketCount=0;
        for (int i = 0; i < codes.length; i++) {
            if(codes[i]=='['){
                bracketCount++;
            }
            if(codes[i]==']'){
                bracketCount--;
            }
            if(bracketCount<0){
                return "ERROR:Invalid code,bracket not match";
            }

        }
        if(bracketCount!=0){
            return "ERROR:Invalid code,bracket not match";

        }
        StringBuilder stringBuilder=new StringBuilder();
        String result=null;
        Scanner scanner=new Scanner(System.in);
        int i=0;
        bracketCount=0;
        while (i <codes.length) {
            switch (codes[i]){
                case '+':memory[pointer]++;
                    break;
                case '-':memory[pointer]--;
                    break;
                case '>':pointer++;
                    if(pointer==memory.length){
                        expandMemory();
                    }
                    break;
                case '<': pointer--;
                    if(pointer==0){
                        return "ERROR:Index out of Bound";
                    }
                    break;
                case ',':try {
                    memory[pointer]=params[paramPointer++];
                } catch (IndexOutOfBoundsException e){
                        return  "ERROR:invalid param sequence";
                }break;
                case '.':stringBuilder.append(memory[pointer]);break;
                case '[':
                    if(memory[pointer]==0) {
                        bracketCount++;
                        while (bracketCount!=0) {
                            i++;
                            if(codes[i]=='['){
                                bracketCount++;
                            }
                            if(codes[i]==']'){
                                bracketCount--;
                            }
                        }
                        bracketCount=0;
                    }

                    break;
                case ']':if(i>=0&&i<codes.length) {
                    if (memory[pointer] != 0){
                        bracketCount++;
                        while (bracketCount!=0) {
                            i--;
                            if(codes[i]==']'){
                                bracketCount++;
                            }
                            if(codes[i]=='['){
                                bracketCount--;
                            }
                        }
                        bracketCount=0;
                    }
                }break;
            }
            i++;

        }
        result=stringBuilder.toString();
        System.out.println(result);
        return result;
    }

}
