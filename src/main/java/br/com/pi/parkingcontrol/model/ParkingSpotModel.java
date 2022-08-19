package br.com.pi.parkingcontrol.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_SPOTING_PARK")
public class ParkingSpotModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;

    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar; //placa do carro

    @Column(nullable = false, length = 70)
    private String bradCar;

    @Column(nullable = false, length = 70)
    private String modelCar;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false, length = 130)
    private String responsibleName;

    @Column(nullable = false, length = 30)
    private String apatarment;

    @Column(nullable = false, length = 30)
    private String block;

    public ParkingSpotModel(){}

    public ParkingSpotModel(String parkingSpotNumber, String licensePlateCar, String bradCar,
                            String modelCar, LocalDateTime registrationDate, String responsibleName,
                            String apatarment, String block) {
        this.parkingSpotNumber = parkingSpotNumber;
        this.licensePlateCar = licensePlateCar;
        this.bradCar = bradCar;
        this.modelCar = modelCar;
        this.registrationDate = registrationDate;
        this.responsibleName = responsibleName;
        this.apatarment = apatarment;
        this.block = block;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getBradCar() {
        return bradCar;
    }

    public void setBradCar(String bradCar) {
        this.bradCar = bradCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApatarment() {
        return apatarment;
    }

    public void setApatarment(String apatarment) {
        this.apatarment = apatarment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
