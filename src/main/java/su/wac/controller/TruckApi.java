package su.wac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import su.wac.model.jpa.Truck;
import su.wac.service.TruckBean;

@RestController
@RequestMapping("truck")
public class TruckApi {

    private TruckBean truckBean;

    @Autowired
    public void setTruckBean (TruckBean truckBean){
        this.truckBean = truckBean;
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Truck getTruck(@PathVariable("id") int id) {
        return truckBean.getTruck(id);
    }

    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTruck(@RequestBody Truck truck){
        truckBean.createNewTruck(truck);
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editTruck(@RequestBody Truck truck){
        truckBean.updateTruck(truck);
    }

    @DeleteMapping(value = "{id}")
    public void deleteTruck(@PathVariable("id")  int id) {
        truckBean.deleteTruck(id);
    }
}
