package br.com.pi.parkingcontrol.controller;

import br.com.pi.parkingcontrol.dtos.ParkingSpotDto;
import br.com.pi.parkingcontrol.model.ParkingSpotModel;
import br.com.pi.parkingcontrol.services.ParkinSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("parking-spot")
public class ParkinSpotController {


    final ParkinSpotService parkinSpotService;
    public ParkinSpotController(ParkinSpotService parkinSpotService) {
        this.parkinSpotService = parkinSpotService;
    }


    @PostMapping //REGISTRANDO NOVAS VAGAS
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){

        if(parkinSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())){ //METODOS QUE VERIFICAM SE EXISTE ALGO NO BANCO COM ESSES DADOS
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CONFLITO: Essa licença ja está em uso"
                    + parkingSpotDto.getLicensePlateCar());
        }
        if(parkinSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CONFLITO: Essa vaga já está em uso"
                    + parkingSpotDto.getParkingSpotNumber());
        }
        if(parkinSpotService.existsByApatarmentAndBlock(parkingSpotDto.getApatarment(), parkingSpotDto.getBlock())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CONFLITO: Esse apartamento já possui uma vaga");
        }

        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel); //Faz a conversão DTO para ParkSpotModel
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkinSpotService.save(parkingSpotModel));
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpot(){
        return ResponseEntity.status(HttpStatus.OK).body(parkinSpotService.findAll()) ;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getParkingSpotBySpotNumber(@PathVariable String id){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkinSpotService.findByParkingSpotNumber(id);
        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("VAGA NAO EXISTE");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional);
    }










}
