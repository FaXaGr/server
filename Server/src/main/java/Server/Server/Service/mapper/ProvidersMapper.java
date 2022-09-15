package Server.Server.Service.mapper;

import Server.Server.Service.Dto.ProvidersDto;
import Server.Server.Service.entity.Providers;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface ProvidersMapper {
    ProvidersDto toDto(Providers providers);

    Providers toEntity(ProvidersDto providersDto);
}
