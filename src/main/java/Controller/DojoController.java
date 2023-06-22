package Controller;

//import com.example.model.Dojo;
//import com.example.service.DojoService;
import Service.Dojo;
import Service.DojoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dojo")
public class DojoController {
    private final DojoService dojoService;

    public DojoController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    @GetMapping("/new")
    public String newDojoForm(Model model) {
        model.addAttribute("dojo", newDojo());
        return "new_dojo";
    }

    private Object newDojo() {
        return null;
    }

    @PostMapping("/create")
    public String createDojo() {
        return createDojo(null);
    }

    @PostMapping("/create")
    public String createDojo(Dojo dojo) {
        dojoService.createDojo(dojo);
        return "redirect:/dojo/" + dojo.getId();
    }
}
