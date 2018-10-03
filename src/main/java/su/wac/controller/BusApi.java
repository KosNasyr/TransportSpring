package su.wac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import su.wac.model.jpa.Bus;
import su.wac.service.BusBean;

@RestController
@RequestMapping("bus")
public class BusApi {

    private BusBean busBean;

    @Autowired
    public void setBusBean (BusBean busBean){
        this.busBean = busBean;
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Bus getBus(@PathVariable("id") int id){
        return busBean.getBus(id);
    }

    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBus(Bus bus){
        busBean.createNewBus(bus);
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void editBus(Bus bus){
        busBean.updateBus(bus);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteBus(@PathVariable("id") int id) {
        busBean.deleteBus(id);
    }

}