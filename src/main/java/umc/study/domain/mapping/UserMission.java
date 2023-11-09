package umc.study.domain.mapping;
import lombok.*;
import umc.study.domain.Mission;
import umc.study.domain.User;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MStatus;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "m_id")
    private Mission mission;
    @Column(columnDefinition = "VARCHAR(10)")
    private MStatus status;
}
