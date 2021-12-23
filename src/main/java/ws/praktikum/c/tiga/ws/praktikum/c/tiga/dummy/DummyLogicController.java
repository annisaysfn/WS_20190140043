/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.praktikum.c.tiga.ws.praktikum.c.tiga.dummy;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author user
 */
@Controller
public class DummyLogicController {
    
    @RequestMapping(value="/dummyjson", produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Dummy> getJSONData(){
        DummyJpaController controller = new DummyJpaController();
        List<Dummy> buffer = new ArrayList<>();
        try {
            buffer = controller.findDummyEntities();
        } catch (Exception e){}
        return buffer;
    }
    
    @RequestMapping(value="/dummyxml", produces={MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Dummy> getXMLData(){
        DummyJpaController controller = new DummyJpaController();
        List<Dummy> buffer = new ArrayList<>();
        try {
            buffer = controller.findDummyEntities();
        } catch (Exception e){}
        return buffer;
    }
    
}
