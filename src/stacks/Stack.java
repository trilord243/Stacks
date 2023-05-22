
package stacks;


public class Stack {
    private Node top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        } else {
            int value = top.getValue();
            top = top.getNext();
            size--;
            return value;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        } else {
            return top.getValue();
        }
    }

    public int getSize() {
        return size;
    }
    public void print() {
    if (isEmpty()) {
        System.out.println("Stack is empty");
    } else {
        Node current = top;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
}

    
    /*
    Dados dos enteros positivos, cuyos dígitos están almacenados en una pila, elabore un algoritmo,
utilizando las primitivas del tipo PILA, que realice la suma de estos números dejando el
resultado en otra pila. Ejemplo: 145 + 535= 680
    */
    public Stack sumStacks(Stack stack1, Stack stack2) {
    Stack result = new Stack();
    int carry = 0;
    
    while (!stack1.isEmpty() || !stack2.isEmpty()) {
        int sum = carry;
        
        if (!stack1.isEmpty()) {
            sum += stack1.pop();
        }
        
        if (!stack2.isEmpty()) {
            sum += stack2.pop();
        }
        
        carry = sum / 10;
        result.push(sum % 10);
    }
    
    if (carry != 0) {
        result.push(carry);
    }
    
    return result;
}
    ///Estos 2 metodos inverte la pila 
    public void reverse() {
    if (!isEmpty()) {
        int temp = pop();
        reverse();
        insertAtBottom(temp);
    }
}

private void insertAtBottom(int value) {
    if (isEmpty()) {
        push(value);
    } else {
        int temp = pop();
        insertAtBottom(value);
        push(temp);
    }
}
//Verifica si una pila es palindrome
public boolean isPalindrome(Stack stack) {
    Stack aux = new Stack();
    Stack reverse = new Stack();

    while (!stack.isEmpty()) {
        int temp = stack.pop();
        aux.push(temp);
        reverse.push(temp);
    }

    while (!aux.isEmpty()) {
        if (aux.pop() != reverse.pop()) {
            return false;
        }
    }

    return true;
}

//Suma desde el fondo hasta el tope

public class SumCounter {
    private int count;
    private int sum;

    public SumCounter() {
        this.count = 0;
        this.sum = 0;
    }

    public void decrementCount() {
        count--;
    }

    public boolean shouldAdd() {
        return count > 0;
    }

    public void add(int value) {
        sum += value;
    }

    public int getSum() {
        return sum;
    }
}

public int sumFirstN(Stack stack, SumCounter counter) {
    if (stack.isEmpty()) {
        return 0;
    }

    int value = stack.pop();

    // We're at the bottom of the stack
    if (stack.isEmpty()) {
        counter.count = value;
        return value;
    } else {
        int result = sumFirstN(stack, counter);
        if (counter.shouldAdd()) {
            counter.add(value);
            counter.decrementCount();
        }
        return result + counter.getSum();
    }
}
//promedio
public float average() {
    if (isEmpty()) {
        return 0;
    }

    float sum = 0;
    int count = 0;
    
    Node current = top;
    while (current != null) {
        sum += current.getValue();
        count++;
        current = current.getNext();
    }

    return sum / count;
}

//Stack merger Combina 2 pilas 
public class StackMerger {
    public static Stack merge(Stack stack1, Stack stack2) {
        Stack mergedStack = new Stack();
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() > stack2.peek()) {
                mergedStack.push(stack1.pop());
            } else {
                mergedStack.push(stack2.pop());
            }
        }
        while (!stack1.isEmpty()) {
            mergedStack.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            mergedStack.push(stack2.pop());
        }
        return mergedStack;
    }
}




}