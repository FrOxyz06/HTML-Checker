import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
public HTMLManager(Queue<HTMLTag> html){
   Queue<HTMLTag> tags = new LinkedList<>();
   if(html.size() == 0){
      throw new IllegalArgumentException();
   }
   
   while(!html.isEmpty()){
     tags.add(html.remove());
   }
}

public Queue<HTMLTag> getTags() {
    return tags;
}

public String toString() {
   String code = " ";
   Queue<HTMLTag> temp = new LinkedList<>();
   // I put every value in temp
   while(!tags.isEmpty()){
     temp.add(tags.remove());
   }
   // making a string of all the tags and adding back in tags
    while(!temp.isEmpty()){
        code += temp.element() + " ";
        tags.add(temp.remove());
    }
    return code.trim();
}



}
