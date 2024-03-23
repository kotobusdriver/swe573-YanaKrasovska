package app.persistence;

import app.entities.CommunityMember;

public interface CommunityMemberRepository {
    CommunityMember findByUserIdAndCommunityId(String userId, String communityId);
}
