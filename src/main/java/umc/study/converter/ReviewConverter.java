package umc.study.converter;

import lombok.RequiredArgsConstructor;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class ReviewConverter {
    public static ReviewResponseDTO.PostResultDTO toPostResultDTO(Review review){
        return ReviewResponseDTO.PostResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.PostDTO request, Member member, Store store){
        return Review.builder()
                .title(request.getTitle())
                .member(member)
                .store(store)
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }
}
