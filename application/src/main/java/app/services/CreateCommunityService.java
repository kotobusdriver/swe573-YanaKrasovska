package app.services;

import app.commands.CreateCommunityCommand;
import app.entities.Community;

public class CreateCommunityService {
    public Community execute(CreateCommunityCommand createCommunityCommand) {
        return new Community();
    }
}
