package su.wac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import su.wac.service.GetAllHierarchyBean;
import su.wac.model.business.Htree;

@RestController
@RequestMapping("hierarchy")
public class ShowHierarchy {

    private GetAllHierarchyBean getAllHierarchyBean;

    @Autowired
    public void setGetAllHierarchyBean (  GetAllHierarchyBean getAllHierarchyBean){
        this.getAllHierarchyBean = getAllHierarchyBean;
    }

    @GetMapping(value="tree",
            produces= MediaType.APPLICATION_JSON_VALUE)
    public Htree getHierarchy() {
        return getAllHierarchyBean.getTree();
    }
}
