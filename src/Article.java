public class Article {
    private int lastId = 0;
    private String title = "";
    private String content = "";

    Article(int lastId, String title, String content){
        this.lastId = lastId;
        this.title = title;
        this.content = content;
    }

    public int getLastId(){
        return this.lastId;
    }

    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return this.content;
    }
}
