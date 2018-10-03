package su.wac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import su.wac.model.jpa.Management;
import su.wac.service.ManagementBean;

@RestController
@RequestMapping("management")
public class ManagementApi {

    private ManagementBean managementBean;

    @Autowired
    public void setManagementBean(ManagementBean managementBean) {
        this.managementBean = managementBean;
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Management getManagement(@PathVariable("id") int id) {
        return managementBean.getManagement(id);
    }

    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addManager(@RequestBody Management man) {
        managementBean.createNewManagement(man);
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editManagement(@RequestBody Management man) {
        managementBean.updateManagement(man);
    }

    @DeleteMapping(value = "{id}")
    public void deleteManagement(@PathVariable("id") int id) {
        managementBean.deleteManagement(id);
    }
}