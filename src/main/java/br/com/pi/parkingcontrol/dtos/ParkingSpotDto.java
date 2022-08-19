package br.com.pi.parkingcontrol.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDto {

    @NotBlank
    private String parkingSpotNumber;

    @NotBlank
    @Size(max = 7)
    private String licensePlateCar; //placa do carro

    @NotBlank
    private String bradCar;

    @NotBlank
    private String modelCar;

    @NotBlank
    private String responsibleName;

    @NotBlank
    private String apatarment;

    @NotBlank
    private String block;

    public ParkingSpotDto(){}

    public ParkingSpotDto(String parkingSpotNumber, String licensePlateCar, String bradCar, String modelCar, String responsibleName,
                          String apatarment, String block) {
        this.parkingSpotNumber = parkingSpotNumber;
        this.licensePlateCar = licensePlateCar;
        this.bradCar = bradCar;
        this.modelCar = modelCar;
        this.responsibleName = responsibleName;
        this.apatarment = apatarment;
        this.block = block;
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
