package app.scenarios;

import app.CommunityPlatform;
import app.commands.CreateCommunityCommand;
import app.entities.Community;
import app.services.CreateCommunityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateCommunityTest {
    private CommunityPlatform sut = new CommunityPlatform();
    @Test
    public void sanity(){
        Assertions.assertNotNull(sut);
    }
    @Test
    public void shouldReturnCreateCommunityService(){
        CreateCommunityService service = sut.getCreateCommunityService();
        Assertions.assertNotNull(service);
    }
    @Test
    public void shouldCreateCommunityService(){
        CreateCommunityService service = sut.getCreateCommunityService();
        CreateCommunityCommand createCommunityCommand = new CreateCommunityCommand();
        Community community = service.execute(createCommunityCommand);
        Assertions.assertNotNull(community);
    }
}
