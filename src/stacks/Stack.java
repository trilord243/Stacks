
package stacks;


public class Stack {
    private Node top;
    private int heigth;
    
    public Stack(){
        this.top=null;
        this.heigth=0;
    
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public int getHeight() {
        return heigth;
    }

    public void setHeight(int height) {
        this.heigth = height;
    }
    
    public void push(int value){
        Node newNode=new Node(value);
        if(heigth==0){
            setTop(newNode);
        
        
        }else{
            newNode.setNext(getTop());
            setTop(newNode);
           
        }heigth++;
    
    
    }
    public void print(){
        Node aux=getTop();
        
        while(aux!=null){
            System.out.println(aux.getValue());
            aux=aux.getNext();
        
        }
    
    
    }
    public Node pop(){
        if(heigth==0){
            return null;
        
        }else if(heigth==1 ){
            setTop(null);
            heigth--;
            return null;
        }else{
            Node aux=getTop();
            
            setTop(getTop().getNext());
            aux.setNext(null);
            
           
            heigth--;
            return aux;
        
        }
    
    }
    
}
