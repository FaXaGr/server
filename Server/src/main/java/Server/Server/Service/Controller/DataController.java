package Server.Server.Service.Controller;

import Server.Server.Service.Dto.ClientData;
import Server.Server.Service.Dto.ProvidersDto;
import Server.Server.Service.Dto.ResponseDto;
import Server.Server.Service.Service.impl.DataServiceImpl;
import Server.Server.Service.entity.History;
import Server.Server.Service.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
public class DataController {
    private final HistoryRepository historyRepository;
    private final DataServiceImpl dataService;
    @Transactional
    @PostMapping("/pay/beeline")
    public ResponseDto DataController(@RequestBody ClientData clientData){
        System.out.println(clientData.getProviderName());
       return dataService.pay(clientData);
    }
    @PostMapping("/add")
    public ResponseDto add(@RequestBody ProvidersDto providersDto){
        return dataService.add(providersDto);
    }

    @PostMapping("/history")
    public void addHistory(@RequestBody History history){
        historyRepository.save(history);
    }
}
