package Server.Server.Service.repository;

import Server.Server.Service.entity.Providers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidersRepository extends JpaRepository<Providers,Integer> {
    Providers findByAddress(String address);
}
