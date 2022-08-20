package br.com.pi.parkingcontrol.repository;

import br.com.pi.parkingcontrol.model.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

    //VERIFICANDO SE EXISTE NO BANCO
    boolean existsByLicensePlateCar(String licensePlateCar);
    boolean existsByParkingSpotNumber(String parkingSpotNumber);
    boolean existsByApatarmentAndBlock(String apartament, String block);



    //BUSCANDO PELA VAGA
    Optional<ParkingSpotModel> findByParkingSpotNumber(String parkingSpotNumber);

}
