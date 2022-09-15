package Server.Server.Service.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto <T> {
    private String message;
    private Integer code;
    private Boolean success;
    private T object;
}
