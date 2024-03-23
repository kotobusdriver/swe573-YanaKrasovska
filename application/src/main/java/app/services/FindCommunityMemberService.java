package app.services;

import app.entities.CommunityMember;
import app.persistence.CommunityMemberRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindCommunityMemberService {
    private final CommunityMemberRepository communityMemberRepository;

    public CommunityMember getMember(String userId, String communityId) {
        return communityMemberRepository.findByUserIdAndCommunityId(userId, communityId);
    }
}
