package br.com.pi.parkingcontrol.services;

import br.com.pi.parkingcontrol.model.ParkingSpotModel;
import br.com.pi.parkingcontrol.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParkinSpotService {


//    @Autowired
//    ParkingSpotRepository parkingSpotRepository;
//    Ou

    final ParkingSpotRepository parkingSpotRepository;

    public ParkinSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }


    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel){
        return parkingSpotRepository.save(parkingSpotModel);
    }

    @Transactional
    public boolean existsByLicensePlateCar(String licensePlateCar){
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    @Transactional
    public boolean existsByParkingSpotNumber(String parkingSpotNumber){
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    @Transactional
    public boolean existsByApatarmentAndBlock(String apartament, String block){
        return  parkingSpotRepository.existsByApatarmentAndBlock(apartament, block);
    }








}