package hello;

public class Greeting {

    private Integer id;
    private String content;

    public Greeting(){}

    public Greeting(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public static boolean isValid(Greeting greeting)
    {
        return false;
    }
    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}