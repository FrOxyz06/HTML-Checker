# HTML Checker

A Java coursework project that repairs a queue of HTML tags using a stack. It preserves matching tags and self-closing elements, discards unmatched closing tags, and closes remaining opening tags at the end.

## Run

Use a JDK (Java 21 is used in CI). From this folder:

```sh
javac --release 21 -d build *.java
java -cp build HTMLMain
```

The built-in example repairs `<b><i><br /></b></i>` to `<b><i><br /></i></b>`.

To read a local file instead:

```sh
java -cp build HTMLMain path/to/example.html
```

## Check

```sh
java -cp build ProjectTest
```

The check covers five documented repair examples and verifies that repairing the result a second time does not change it. GitHub Actions runs it on pushes and pull requests.

## Files

- `HTMLManager.java`: queue and stack repair logic.
- `HTMLParser.java`, `HTMLTag.java`, `HTMLTagType.java`: original course support classes.
- `HTMLMain.java`: command-line demo and local file entry point.
- `ProjectTest.java`: regression checks.
- `HTMLChecker.zip`: original archived project, retained for reference. Use the source files above for current development.

## Limits

This is a tag-balancing exercise, not a browser-grade HTML validator or an HTML sanitizer. The parser assumes parseable input and the manager requires a non-empty tag queue. Course support files retain their original attribution. Dependabot checks workflow updates weekly.
