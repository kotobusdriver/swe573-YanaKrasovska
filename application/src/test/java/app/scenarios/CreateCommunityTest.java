package app.scenarios;

import app.CommunityPlatform;
import app.commands.CreateCommunityCommand;
import app.entities.Community;
import app.services.CreateCommunityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateCommunityTest {
    private final CommunityPlatform platform = new CommunityPlatform();
    private final CreateCommunityService sut = platform.getCreateCommunityService();

    @Test
    public void shouldReturnCreateCommunityService(){
        Assertions.assertNotNull(sut);
    }
    @Test
    public void shouldCreateCommunityService(){
        CreateCommunityCommand createCommunityCommand = new CreateCommunityCommand();
        Community community = sut.execute(createCommunityCommand);
        Assertions.assertNotNull(community);
    }
}
