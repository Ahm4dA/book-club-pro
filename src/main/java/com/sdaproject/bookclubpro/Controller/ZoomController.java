import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZoomController {

    @Autowired
    private ZoomService zoomService;

    @PostMapping("/zoom/meeting")
    public void createMeeting(@RequestBody MeetingRequest request) throws ZoomException {
        zoomService.createMeeting(request.getTopic(), request.getStartTime(), request.getDuration());
    }
}
