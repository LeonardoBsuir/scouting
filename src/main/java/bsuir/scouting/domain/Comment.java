package bsuir.scouting.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Comment implements Serializable {
    private long commentId;
    private String text;
    private Long playerId;
    private Long userId;
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

    @Basic
    @Column(name = "player_id", nullable = true, insertable = true, updatable = true)
    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    @Basic
    @Column(name = "user_id", nullable = true, insertable = true, updatable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (commentId != comment.commentId) return false;
        if (text != null ? !text.equals(comment.text) : comment.text != null) return false;
        if (playerId != null ? !playerId.equals(comment.playerId) : comment.playerId != null) return false;
        if (userId != null ? !userId.equals(comment.userId) : comment.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (commentId ^ (commentId >>> 32));
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (playerId != null ? playerId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "player_id")
    public Player getPlayerByPlayerId() {
        return playerByPlayerId;
    }

    public void setPlayerByPlayerId(Player playerByPlayerId) {
        this.playerByPlayerId = playerByPlayerId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
