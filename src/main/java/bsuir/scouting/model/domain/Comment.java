package bsuir.scouting.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Comment implements Serializable {
    private long commentId;
    private String text;
    private Player playerByPlayerId;
    private User userByUserId;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "comment_id", nullable = false, insertable = true, updatable = true)
    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "text", nullable = true, insertable = true, updatable = true, length = 255)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (commentId != comment.commentId) return false;
        if (text != null ? !text.equals(comment.text) : comment.text != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (commentId ^ (commentId >>> 32));
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "player_id", referencedColumnName = "player_id")
    public Player getPlayerByPlayerId() {
        return playerByPlayerId;
    }

    public void setPlayerByPlayerId(Player playerByPlayerId) {
        this.playerByPlayerId = playerByPlayerId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
