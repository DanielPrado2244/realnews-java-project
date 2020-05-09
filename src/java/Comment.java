public class Comment
{
    public String username;
    public String comment;
    public int newsId;
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(final String comment) {
        this.comment = comment;
    }
    
    public int getNewsId() {
        return this.newsId;
    }
    
    public void setNewsId(final int newsId) {
        this.newsId = newsId;
    }
}

