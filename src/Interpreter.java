import java.io.IOException;
import java.util.Scanner;

/**
 * Created by sarleon on 16-5-5.
 */
public class Interpreter {
    private char[] codes;
    private int pointer;


    private char[] memory;
    public Interpreter(String code){
        this.codes=code.toCharArray();
        pointer=0;
        memory=new char[100];

    }

    public static void main(String[] args) throws IOException{
        new Interpreter("++++++++++[>+++++++>++++++++++>+++>+<<<<-]\n" +
                ">++.>+.+++++++..+++.>++.<<+++++++++++++++.\n" +
                ">.+++.------.--------.>+.>.").interpret();
    }
    private void expandMemory(){
        int capacity=this.memory.length*2;
        char[] newmemory=new char[capacity];
        for (int i = 0; i < this.memory.length; i++) {
            newmemory[i]=this.memory[i];
        }
        this.memory=newmemory;

    }


    private void interpret() throws IOException {
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
                case ',':memory[pointer]=(char)System.in.read();break;
                case '.':System.out.print(memory[pointer]);break;
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
    }

}
