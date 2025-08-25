package agilefeedback.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WsEvent {
    private String type;     // CREATED, UPDATED, DELETED, etc.
    private Object payload;  // un DTO, un id, ou un message simple
}