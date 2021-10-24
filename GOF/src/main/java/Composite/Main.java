package Composite;

/**
 * @Author Gorit
 * @Date 2021/10/7
 * 使用 main 创建如下目录树
 * - root
 *      - bin
 *          - vi
 *          - latex
 *      - tmp
 *      - usr
 *          - yuki
 *              - diary.html
 *              - Composite.java
 *           - hanko
 *              - memo.tax
 *            -  tomura
 *              - game.doc
 *              - junk.mail
 **/
public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Making root entries...");
            Directory rootDir = new Directory("root");
            Directory bindDir = new Directory("bin");
            Directory tmpDir = new Directory("tmp");
            Directory usrDir = new Directory("usr");
            rootDir.add(bindDir);
            rootDir.add(tmpDir);
            rootDir.add(usrDir);

            bindDir.add(new File("vi", 10000));
            bindDir.add(new File("latex", 20000));
            rootDir.printList();

            System.out.println("");
            System.out.println("Making user entries...");
            Directory yuki = new Directory("yuki");
            Directory hanko = new Directory("hanko");
            Directory tomura = new Directory("tomura");
            usrDir.add(yuki);
            usrDir.add(hanko);
            usrDir.add(tomura);
            yuki.add(new File("diary.html", 1001));
            yuki.add(new File("Composite.java", 200));
            hanko.add(new File("memo.tak", 300));
            tomura.add(new File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));
            rootDir.printList();
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
