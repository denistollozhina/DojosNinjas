package Service;

//import com.example.model.Dojo;

import java.util.List;

public interface DojoService {
    List<Dojo> getAllDojos();

    Dojo createDojo(Dojo dojo);
}
