package swe.spec.scenarios;

import org.junit.jupiter.api.Test;
import swe.rest.models.CommunityMemberResource;
import swe.rest.models.CommunityResource;
import swe.rest.models.PostResource;
import swe.rest.models.UserResource;
import swe.spec.Scenario;
import swe.spec.utils.Posting;

public class DeletePostTest extends Scenario {
  @Test
  public void delete_post() throws Exception {
    UserResource user = createUserUsecase.invokeUsecase("Amy", "amy@company.com", "password");

    CommunityResource community =
        createCommunityUsecase.invokeUsecase(
            "BirdWatchers", "We watch birds!!", user.getId(), Posting.buildMySpecialTemplate());

    CommunityMemberResource member =
        getCommunityMembersUsecase.getUserMembershipForCommunity(user.getId(), community.getId());

    PostResource post =
        sendPostUsecase.invokeUsecase(
            community.getId(), member.getId(), Posting.createMySpecialPostFields(community));

    deletePostUsecase.invokeUsecase(post.getId(), member.getId());
  }
}
