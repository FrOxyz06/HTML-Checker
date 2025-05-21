import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
public HTMLManager(Queue<HTMLTag> html){
   Queue<HTMLTag> code = new LinkedList<>();
   if(html.size() == 0){
      throw new IllegalArgumentException();
   }
   
   while(!html.isEmpty()){
      code.add(html.remove());
   }
}



}
