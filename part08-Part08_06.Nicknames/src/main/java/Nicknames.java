
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations required here!
        HashMap<String, String> names = new HashMap<>();
        names.put("mathew", "matt");
        names.put("michaels", "mike");
        names.put("arthur", "artie");
        
        System.out.println(names.get("mathew"));
    }

}
