package curriculum;

public class Data {

    private int ID;
    private String title;
    private int isPublished;
    private String contenttype;
    private String content;

    public Data(int ID, String title, String contenttype, int isPublished, String content) {
        this.ID = ID;
        this.title = title;
        this.contenttype = contenttype;
        this.isPublished = isPublished;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public int getIsPublished() {
        return isPublished;
    }

    public String getContenttype() {
        return contenttype;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "id=" + ID +
                ", title='" + title + '\'' +
                ", isPublished='" + isPublished + '\'' +
                ", contenttype='" + contenttype + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
