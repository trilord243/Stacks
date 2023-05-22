/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stacks;

/**
 *
 * @author Escal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Stack newStack=new Stack();
     
        newStack.push(48);
        newStack.push(587);
        newStack.push(45);
        newStack.push(4);
        newStack.pop();
        newStack.pop();
        newStack.print();

    }
    
}
