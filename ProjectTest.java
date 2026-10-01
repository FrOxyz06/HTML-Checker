public class ProjectTest {
    public static void main(String[] args) {
        String[][] cases = {
            {"<b><i><br /></b></i>", "<b><i><br /></i></b>"},
            {"<a><a><a></a>", "<a><a><a></a></a></a>"},
            {"<br /></p></p>", "<br />"},
            {"<div><div><ul><li></li><li></li><li></ul></div>",
             "<div><div><ul><li></li><li></li><li></li></ul></div></div>"},
            {"<div><h1></h1><div><img /><p><br /><br /><br /></div></div></table>",
             "<div><h1></h1><div><img /><p><br /><br /><br /></p></div></div>"}
        };
        for (String[] test : cases) {
            HTMLManager manager = new HTMLManager(new HTMLParser(test[0]).parse());
            manager.fixHTML();
            if (!test[1].equals(manager.toString()))
                throw new AssertionError("Unexpected repair: " + manager);
            manager.fixHTML();
            if (!test[1].equals(manager.toString()))
                throw new AssertionError("Repair should be idempotent");
        }
        System.out.println("Five repair examples and repeat repairs passed.");
    }
}
