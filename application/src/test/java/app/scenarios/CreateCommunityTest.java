package app.scenarios;

import app.CommunityPlatform;
import app.commands.CreateCommunityCommand;
import app.entities.Community;
import app.model.CommunityStatus;
import app.model.CommunityVisibility;
import app.services.CreateCommunityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateCommunityTest {
    private final CommunityPlatform platform = new CommunityPlatform();
    private final CreateCommunityService sut = platform.getCreateCommunityService();

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
        Assertions.assertEquals("bird-watchers", community.getName());
        Assertions.assertEquals("We watch birds", community.getDescription());
        Assertions.assertEquals(CommunityVisibility.PUBLIC, community.getVisibility());
        Assertions.assertEquals(CommunityStatus.ACTIVE, community.getStatus());
    }

}
