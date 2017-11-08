package codingDojo.JAVA_OOP.Singly_Linked_List;

public class SinglyLinkedList {

    public Node head;

    public SinglyLinkedList(){
        this.head = null;
    }

    public void add(int value){
        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printValues(){
        Node nextValue = this.head;

        if(nextValue == null){
            System.out.println("Nothing to Print");
        }else{
            while(nextValue != null){
                System.out.println(nextValue.value);
                nextValue = nextValue.next;
            }
        }
    }

    public void remove(){
        Node current = this.head;

        if(current == null){
            System.out.println("Nothing to remove");

        }else if(current.next == null){
            this.head =null;


        }else{
            while(current.next.next != null){
                current = current.next;
            }

            current.next     = null;

        }
    }

    public Node find(int val){
        if(this.head == null){
            return null;

        }

        Node current = this.head;

        while (current != null){
            if (current.value == val){
                return current;
            }

            current = current.next;
        }

        return null;
    }


    public void removeAt(int index){
        Node previous = head;
        int count = 0;

        if(head == null){
            System.out.println("Nothing to remove, the list is empty");
        } else if(index == 0){
            head = head.next;
        }else{
            while(count < (index -1)){
                if(previous.next == null){
                    return;
                }

                previous = previous.next;
                count++;
            }

            Node current = previous.next;//6
            previous.next = current.next;//8
            current.next = null;
        }
    }
}
