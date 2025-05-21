import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
public HTMLManager(Queue<HTMLTag> html){
   tags = new LinkedList<>();
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
        code = code.trim();
        tags.add(temp.remove());
    }
    return code;
}

public void fixHTML() {
    Stack<HTMLTag> stack = new Stack<>();
    Queue<HTMLTag> temp = new LinkedList<>();
    Queue<HTMLTag> fix = new LinkedList<>();
    //putting the tags in temp
    while (!tags.isEmpty()) {
        temp.add(tags.remove());
    }
   // checking every element in temp
    while (!temp.isEmpty()) {
        HTMLTag tag = temp.remove();
         
        if (tag.isSelfClosing()) {
            fix.add(tag);
        } else if (tag.isOpening()) {
            stack.push(tag);
            fix.add(tag);
        } else if (tag.isClosing()) {// if the tag is a closing tag we check if the last opening tag matches it and we add it to the fix queue
            if (!stack.isEmpty() && tag.matches(stack.peek())) {
                fix.add(tag);
                stack.pop();

            }
         }
    }

    while (!stack.isEmpty()) {// we check if the stack still contains any opening tags if it does we add it's match in the fix queue
        fix.add(stack.pop().getMatching());
    }
    tags = fix;
}

   
}

/*
 ===============================
 Processing tests/test1.html...
 ===============================
 HTML: <b><i><br /></b></i>
 Checking HTML for errors...
 HTML after fix: <b><i><br /></i></b>
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test2.html...
 ===============================
 HTML: <a><a><a></a>
 Checking HTML for errors...
 HTML after fix: <a><a><a></a></a></a>
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test3.html...
 ===============================
 HTML: <br /></p></p>
 Checking HTML for errors...
 HTML after fix: <br />
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test4.html...
 ===============================
 HTML: <div><div><ul><li></li><li></li><li></ul></div>
 Checking HTML for errors...
 HTML after fix: <div><div><ul><li></li><li></li><li></li></ul></div></div>
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test5.html...
 ===============================
 HTML: <div><h1></h1><div><img /><p><br /><br /><br /></div></div></table>
 Checking HTML for errors...
 HTML after fix: <div><h1></h1><div><img /><p><br /><br /><br /></p></div></div>
 ----> Result matches Expected Output!
 
 ===============================
         All tests passed!
 ===============================

*/

