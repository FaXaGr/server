package Server.Server.Service.Service;

import Server.Server.Service.Dto.ClientData;
import Server.Server.Service.Dto.ProvidersDto;
import Server.Server.Service.Dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface DataService {
    ResponseDto pay(ClientData clientData);

    ResponseDto add(ProvidersDto providersDto);
}
