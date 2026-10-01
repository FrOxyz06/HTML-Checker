import java.io.File;

public class HTMLMain {
    public static void main(String[] args) {
        HTMLParser parser = args.length == 0
            ? new HTMLParser("<b><i><br /></b></i>")
            : new HTMLParser(new File(args[0]));
        HTMLManager manager = new HTMLManager(parser.parse());
        System.out.println("Before: " + manager);
        manager.fixHTML();
        System.out.println("After:  " + manager);
    }
}
