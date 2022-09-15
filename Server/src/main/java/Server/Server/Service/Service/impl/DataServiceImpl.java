package Server.Server.Service.Service.impl;

import Server.Server.Service.Dto.ClientData;
import Server.Server.Service.Dto.ProvidersDto;
import Server.Server.Service.Dto.ResponseDto;
import Server.Server.Service.Service.DataService;
import Server.Server.Service.entity.History;
import Server.Server.Service.mapper.ProvidersMapper;
import Server.Server.Service.repository.HistoryRepository;
import Server.Server.Service.repository.ProvidersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final ProvidersMapper providersMapper;
    private final ProvidersRepository providersRepository;

    private final HistoryRepository historyRepository;
    @Override
    public ResponseDto pay(ClientData clientData) {

//     ProvidersDto providersDto = providersMapper.toDto(providersRepository.findByAddress(clientData.getProviderName()));
//

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ClientData> clientDataHttpEntity = new HttpEntity<>(clientData);
        ResponseEntity<ResponseDto> response = restTemplate.exchange("http://192.168.6.220:8000/beeline/pay", HttpMethod.PUT,clientDataHttpEntity,ResponseDto.class);


      History history = History.builder().summa(clientData.getPrice()).prName(clientData.getProviderName()).successfully(response.getBody().getSuccess()).telNumber(clientData.getPhoneNumber()).build();

        System.out.println(response.getBody().toString());

      historyRepository.save(history);


        return response.getBody();
    }

    @Override
    public ResponseDto add(ProvidersDto providersDto) {
        providersRepository.save(providersMapper.toEntity(providersDto));
        return ResponseDto.builder().code(0).build();
    }
}
