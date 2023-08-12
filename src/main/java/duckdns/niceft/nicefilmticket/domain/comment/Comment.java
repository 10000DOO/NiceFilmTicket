package duckdns.niceft.nicefilmticket.domain.comment;

import duckdns.niceft.nicefilmticket.domain.DateTime;
import duckdns.niceft.nicefilmticket.domain.member.Buyer;
import duckdns.niceft.nicefilmticket.domain.member.Publisher;
import duckdns.niceft.nicefilmticket.domain.post.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_writer_id")
    private Buyer buyerWriter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_writer_id")
    private Publisher publisherWriter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @OneToMany(mappedBy = "parent")
    private List<Comment> child = new ArrayList<>();

    @Size(max = 300)
    private String commentContent;

    @Embedded
    private DateTime dateTime;

    @Builder
    public Comment(Post post, Buyer buyerWriter, Publisher publisherWriter, String commentContent, DateTime dateTime) {
        this.post = post;
        this.buyerWriter = buyerWriter;
        this.publisherWriter = publisherWriter;
        this.commentContent = commentContent;
        this.dateTime = dateTime;
    }



    public void connectChildParent(Comment parent) {
        this.parent = parent;
        parent.child.add(this);
    }

    public void setCommentIdUsedOnlyTest(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Comment that = (Comment) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
