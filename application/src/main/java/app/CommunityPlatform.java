package app;

import app.services.CreateCommunityService;

public class CommunityPlatform {
    public CreateCommunityService getCreateCommunityService() {
        return new CreateCommunityService();
    }
}
