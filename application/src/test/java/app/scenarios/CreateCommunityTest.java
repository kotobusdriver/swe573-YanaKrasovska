package app.scenarios;

import app.CommunityPlatform;
import app.commands.CreateCommunityCommand;
import app.entities.Community;
import app.entities.CommunityMember;
import app.model.CommunityStatus;
import app.model.CommunityVisibility;
import app.persistence.CommunityMemberRepository;
import app.services.CreateCommunityService;
import app.services.FindCommunityMemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class CreateCommunityTest {
    private static final CommunityMemberRepository communityMemberRepository = Mockito.mock(CommunityMemberRepository.class);
    private final CommunityPlatform platform = new CommunityPlatform(communityMemberRepository);
    private final CreateCommunityService sut = platform.getCreateCommunityService();
    private final FindCommunityMemberService findCommunityMemberService = platform.getFindCommunityMemberService();

    @BeforeAll
    public static void setup() {
        Mockito.when(communityMemberRepository.findByUserIdAndCommunityId(any(), any())).thenReturn(new CommunityMember());
    }

    @Test
    public void shouldCreateCommunity(){
        CreateCommunityCommand createCommunityCommand = CreateCommunityCommand.builder().build();
        Community community = sut.execute(createCommunityCommand);
        Assertions.assertNotNull(community);
    }

    @Test
    public void shouldCreateCommunityWithCorrectInformation(){
        CreateCommunityCommand createCommunityCommand = CreateCommunityCommand.builder()
                .name("bird-watchers")
                .description("We watch birds")
                .visibility(CommunityVisibility.PUBLIC)
                .build();
        Community community = sut.execute(createCommunityCommand);
        Assertions.assertNotNull(community.getId());
        Assertions.assertEquals("bird-watchers", community.getName());
        Assertions.assertEquals("We watch birds", community.getDescription());
        Assertions.assertEquals(CommunityVisibility.PUBLIC, community.getVisibility());
        Assertions.assertEquals(CommunityStatus.ACTIVE, community.getStatus());
    }
    @Test
    public void shouldCheckIfUserIsMember(){
        CreateCommunityCommand createCommunityCommand = CreateCommunityCommand.builder()
                .name("bird-watchers")
                .description("We watch birds")
                .visibility(CommunityVisibility.PUBLIC)
                .adminUserId("adminUserId")
                .build();
        Community community = sut.execute(createCommunityCommand);
        CommunityMember communityMember = findCommunityMemberService.getMember("adminUserId", community.getId());
        Assertions.assertNotNull(communityMember);
        Assertions.assertEquals("adminUserId", communityMember.getUserId());
        Assertions.assertEquals(community.getId(), communityMember.getCommunityId());
    }
}
