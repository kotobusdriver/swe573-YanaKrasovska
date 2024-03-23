package app.services;

import app.commands.CreateCommunityCommand;
import app.entities.Community;
import app.model.CommunityStatus;

public class CreateCommunityService {
    public Community execute(CreateCommunityCommand createCommunityCommand) {
        return Community.builder()
                .name(createCommunityCommand.getName())
                .description(createCommunityCommand.getDescription())
                .visibility(createCommunityCommand.getVisibility())
                .status(CommunityStatus.ACTIVE)
                .id("SomeId")
                .build();
    }
}
