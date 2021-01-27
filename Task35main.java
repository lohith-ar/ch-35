import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Task35main {
    static int noofrecords=0;
    public static void main(String[] args) {
        try {
            Task35main.readFromFile("daffodils.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        

    }

    public static void readFromFile(String fileName) throws Exception {
    File file = new File(fileName);
    SinglyLinkedList sl = new SinglyLinkedList();

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line = "";
        String[] words = null;
        while ((line = br.readLine()) != null) {
            
            line = line.toLowerCase().replaceAll("[,':;.?]", " ");
            words = line.split(" ");            

            for(String word: words){
                sl.addWord(new Word(word));
                noofrecords++;
                
            } 

        }


    }
    long start = System.currentTimeMillis(); 
    sl.showWords();
    long end = System.currentTimeMillis(); 
    System.out.println("\ntime taken for adding elements: "+(end-start));

    System.out.println("\n-------------Sorted order-------------");
    start = System.currentTimeMillis(); 
    sl.sortNode();
    end = System.currentTimeMillis(); 
    System.out.println("\ntime taken for sorting elements: "+(end-start));
    sl.showWords();
    System.out.println("\n-------------descending order-------------");
    start = System.currentTimeMillis(); 
    sl.reverse(sl.head);
     end = System.currentTimeMillis(); 
    System.out.println("\ntime taken for sorting elements descending: "+(end-start));
    start = System.currentTimeMillis(); 
    sl.showFrequWords(); 
     end = System.currentTimeMillis(); 
    System.out.println("\ntime taken for sorting elements based on word count frequency: "+(end-start));
    sl.showWords();
}

 
}


















