import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import us.zoom.sdk.*;

@Service
public class ZoomService {

  @Value("${zoom.apiKey}")
  private String apiKey;

  @Value("${zoom.apiSecret}")
  private String apiSecret;

  public void createMeeting(String topic, String startTime, int duration) throws ZoomException {

    ZoomSDK sdk = ZoomSDK.getInstance();
    ZoomSDKInitParams params = new ZoomSDKInitParams();
    params.appKey = apiKey;
    params.appSecret = apiSecret;
    sdk.initialize(params);

    MeetingService meetingService = sdk.getMeetingService();
    StartMeetingOptions opts = new StartMeetingOptions();
    opts.no_video = true;
    opts.no_audio = true;
    StartMeetingParamsWithoutLogin paramsWithoutLogin = new StartMeetingParamsWithoutLogin();
    paramsWithoutLogin.displayName = "Test User";
    paramsWithoutLogin.userId = "testUser";
    paramsWithoutLogin.userType = MeetingUserType.API_USER;

    String meetingNo = meetingService.startMeetingWithParamsWithoutLogin(this, paramsWithoutLogin, opts);

    MeetingOptions meetingOptions = new MeetingOptions();
    meetingOptions.no_driving_mode = true;
    meetingOptions.no_invite = true;
    meetingOptions.no_share = true;
    meetingOptions.no_titlebar = true;
    meetingOptions.no_bottom_toolbar = true;
    meetingOptions.no_dial_in_via_phone = true;
    meetingOptions.no_dial_out_to_phone = true;
    meetingOptions.no_disconnect_audio = true;
    meetingOptions.no_share = true;

    MeetingService meetingService = sdk.getMeetingService();
    meetingService.startMeetingWithNumber(this, meetingNo, meetingOptions);
  }
}
