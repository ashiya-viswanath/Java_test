package assignment6;

public class Node {
//attributes
    Vote data;
    Node next;
//constructor
    public Node(Vote data)
    {
       this.data=data;
        this.next =null;
    }
    //getter methods
    public Vote getData()
    {
        return data;
    }

    public Node getNext()
    {
        return next;
    }
}
