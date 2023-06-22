package Controller;

//import com.example.model.Dojo;
import Service.DojoService;
import Service.NinjaService;
/*
 import com.example.model.Ninja;
 import com.example.service.DojoService;
 import com.example.service.NinjaService;
*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ninja")
public class NinjaController {
    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public NinjaController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("/new")
    public String newNinjaForm(Model model) {
        model.addAttribute("ninja", new Ninja());
        model.addAttribute("dojos", dojoService.getAllDojos());
        return "new_ninja";
    }

    @PostMapping("/create")
    public String createNinja(Ninja ninja) {
        ninjaService.createNinja(ninja);
        return "redirect:/dojo/" + ninja.getDojo().getId();
    }
}
