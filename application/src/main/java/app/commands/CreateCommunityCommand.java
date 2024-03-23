package app.commands;

import app.model.CommunityVisibility;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CreateCommunityCommand {
    String name;
    String description;
    CommunityVisibility visibility;
    String adminUserId;
}
