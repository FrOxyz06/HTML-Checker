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





}
