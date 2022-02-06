package assignment6;
/* References
[1] https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
[2] SEPB lecture -https://videocampus.sachsen.de/video/07Listsstackqueue-1m4v/9a0845a847b9851ae674f8c1ae077b7f

 */
public class VoteList {

    //attributes
    Node head;

    //constructor
    public VoteList()
    {
        head =null; //empty list
    }
    //getter method
    public Node getHead()
    {
        return head;

    }

// public methods
public  boolean add( Vote data)    {
        // reference [2] SEPB lecture
        //create new node
        Node newNode = new Node(data);
        // add node to list
        newNode.next = head;//adding at front
        head =newNode;
if(head ==newNode)
{
return true;
    }
else
{
    return false;
}
}
    public int importVotes( Vote[] data)
    {

        int count =0;
        for(int i=0;i< data.length;i++)
        {
add(data[i]);
count++;
    }


        return count;
    }
    public boolean isValid( )
    {
       // https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/ [1]
        int valid =0;
        boolean isvalid;
//Find total number of nodes reference [1]
        Node temp = head;
        int count = 0;
        while (temp != null) // reference [1]
        {
            count++;
            temp = temp.next;
        }
// reference [2] SEPB lecture
        for (Node node = head; node != null; node = node.next) {
            if(node.data == Vote.INVALID)
            {
               valid++;

            }
        }
                if((double)valid / count >0.4)
                {
                    isvalid =false;



       }
else
                {
isvalid =true;
    }
        return isvalid;
    }
    public Vote countVotes( )
    {

        int countInvalid =0;
        int countYes=0;
        int countNo=0;
        Vote result = null;
        // reference [2] SEPB lecture
        for (Node node = head; node != null; node = node.next) {
            if(node.data == Vote.INVALID)
            {
                countInvalid++;

            }
            if (node.data == Vote.YES){
                countYes++;
            }
            if (node.data == Vote.NO){
                countNo++;
            }
        }

        if(countYes>countNo){
            result =Vote.YES;
        }

        if(countYes<countNo){
            result =Vote.NO;
        }
        if(countYes==countNo || isValid()==false)
        {
            result =Vote.INVALID;
    }
        return result;
    }




}