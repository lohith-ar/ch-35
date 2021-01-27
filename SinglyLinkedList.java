class Node {
    Word word;
    Node next;
}

public class SinglyLinkedList{
    Node head;
    public Node createNode(Word word){
        Node node = new Node();

        node.word = word;
        node.next = null;

        return node;
    }

    public String getWord(){
        Node temp = head;
		while (temp.next != null) {
			String w1 = temp.word.getWord();
            temp = temp.next;
            return w1;
		}
        String w1 = temp.word.getWord();
        return w1;
        
    }
    public Node words(Word w)
    {
        Node temp = head;
        while(temp!=null)
        {
            if(temp.word.getWord().equals(w.getWord()))
            {
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }

   
    public void addWord(Word word){

        Node node = createNode(word);

		if (head == null) {
			head = node;
		}if(words(word)!=null)
        {
            words(word).word.setWordsRepeated();
        }
		else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
    }


    public void showWords()
    {
        Node temp = head;
		while (temp.next != null) {
            System.out.println(temp.word.getWord()+" "+temp.word.getWordsRepeated());
            // System.out.println(temp.word.getWordsRepeated());
			temp = temp.next;
		}
		System.out.println(temp.word.getWord());
    }


    public void sortNode(){
        Node curr = head;
        Word temp;
        Node nextNode = null;
        if (curr == null) {
            System.out.println("Empty list");
        } else {
            while (curr != null) {
                nextNode = curr.next;
                while (nextNode != null) {
                    if (curr.word.getWord().compareTo(nextNode.word.getWord()) > 0) {
                        temp = curr.word;
                        curr.word = nextNode.word;
                        nextNode.word = temp;
                    }
                    nextNode = nextNode.next;
                }
                curr = curr.next;
            }
        }
    }


    public void reverse(Node current) {  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        else {  
            if(current.next == null) {  
                System.out.println(current.word.getWord() + " "+current.word.getWordsRepeated());  
                return;  
            }  
            reverse(current.next);  
            System.out.println(current.word.getWord() + " "+current.word.getWordsRepeated());  
        }  
    }  


    public void showFrequWords() 
    {
        System.out.println("\n-----------------Frequent words-----------------");
        Node tempNode = head ; 
        if(head==null || head.next==null){
            System.out.println("\nNo elements found");
        }
        while(tempNode.next!=null)
        {
            Node flag = tempNode , next = tempNode.next;
            while(flag!=null)
            {
                if(flag.word.getWordsRepeated()>next.word.getWordsRepeated())
                {
                    next=flag;
                }
                else if(flag.word.getWordsRepeated()==next.word.getWordsRepeated() &&
                next.word.getWord().compareToIgnoreCase(flag.word.getWord())>0){
                    next = flag;                  

                }

                
                flag=flag.next;
            }
            Word w = tempNode.word;
            tempNode.word=next.word;
            next.word=w;
            tempNode=tempNode.next;
        }

    }
}




