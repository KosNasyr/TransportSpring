package su.wac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import su.wac.model.jpa.PassengerCar;
import su.wac.service.PassengerCarBean;

@RestController
@RequestMapping("passengercar")
public class PassengerCarApi {

    private PassengerCarBean passengerCarBean;

    @Autowired
    public void setPassengerCarBean (PassengerCarBean passengerCarBean){
        this.passengerCarBean = passengerCarBean;
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PassengerCar getPassengerCar(@PathVariable("id") int id){
        return passengerCarBean.getPassengerCar(id);
    }

    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPassengerCar(PassengerCar pc){
        passengerCarBean.createNewPC(pc);
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void editPassengerCar(PassengerCar pc){
        passengerCarBean.updatePassengerCar(pc);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePassengerCar(@PathVariable("id") int id) {
        passengerCarBean.deletePassengerCar(id);
    }
}
