package app.entities;

import app.model.CommunityStatus;
import app.model.CommunityVisibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Community {
    String name;
    String description;
    CommunityVisibility visibility;
    CommunityStatus status;
}
