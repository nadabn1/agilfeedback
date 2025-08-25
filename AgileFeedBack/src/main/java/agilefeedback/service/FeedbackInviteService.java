package agilefeedback.service;

import agilefeedback.Dto.*;
import agilefeedback.model.FeedbackInvite;

public interface FeedbackInviteService {
    ValidateResponse validateToken(String token);
    FeedbackDto consumeAndCreateFeedback(FeedbackSubmitDto dto);
    FeedbackInvite createAndSendInvite(InviteRequest request);
}
