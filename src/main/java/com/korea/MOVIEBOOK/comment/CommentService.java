package com.korea.MOVIEBOOK.comment;

import com.korea.MOVIEBOOK.member.Member;
import com.korea.MOVIEBOOK.member.MemberRepository;
import com.korea.MOVIEBOOK.review.Review;
import com.korea.MOVIEBOOK.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    public void saveComment(String comment, Long memberId, Long reviewId){
        Member member = this.memberRepository.findById(memberId).get();
        Review review = this.reviewRepository.findById(reviewId).get();

        Comment comment1 = new Comment();
        comment1.setContent(comment);
        comment1.setMember(member);
        comment1.setReview(review);
        this.commentRepository.save(comment1);
    }

}
