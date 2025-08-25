package agilefeedback.service;


import agilefeedback.Dto.WsEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/** Gateway simple pour publier des événements vers STOMP. */
@Service
@RequiredArgsConstructor
public class EventBus {

    private final SimpMessagingTemplate messagingTemplate;

    /** Publie un événement générique vers un topic STOMP. */
    public void publish(String topic, String type, Object payload) {
        messagingTemplate.convertAndSend(topic, new WsEvent(type, payload));
    }

    // Helpers dédiés si tu veux:
    public void projects(String type, Object payload) {
        publish("/topic/projects", type, payload);
    }
    public void backlogs(String type, Object payload) {
        publish("/topic/backlogs", type, payload);
    }
    public void sprints(String type, Object payload) {
        publish("/topic/sprints", type, payload);
    }
}