package app;

import app.entities.CommunityMember;
import app.persistence.CommunityMemberRepository;
import app.services.CreateCommunityService;
import app.services.FindCommunityMemberService;

public class CommunityPlatform {
    private final CreateCommunityService createCommunityService;
    private final CommunityMemberRepository communityMemberRepository;
    private final FindCommunityMemberService findCommunityMemberService;

    public CommunityPlatform(CommunityMemberRepository communityMemberRepository) {
        this.communityMemberRepository = communityMemberRepository;
        this.createCommunityService = new CreateCommunityService();
        this.findCommunityMemberService = new FindCommunityMemberService(communityMemberRepository);
    }

    public CreateCommunityService getCreateCommunityService() {
        return createCommunityService;
    }

    public FindCommunityMemberService getFindCommunityMemberService() {
        return findCommunityMemberService;
    }
}
