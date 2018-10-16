package hello;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
   // @Autowired private GreetingService greetingService;
   // private static final String template = "Hello, %s!";
   // private final AtomicLong counter = new AtomicLong();
    private Map<Integer, Greeting> greetings = new HashMap<Integer, Greeting>();

    @RequestMapping(value = "/greetings/{id}")
    public Greeting greeting(@PathVariable("id") int id) {
    if (greetings.containsKey(id))
    {
        return greetings.get(id);
    }
    else return new Greeting(0, "nie pozdrawiam :c");
    }

    @RequestMapping(value = "/greetings", method = RequestMethod.POST)
    public ResponseEntity< String > postGreeting(@RequestBody Greeting greeting ) {
        if (greeting.getId() == null || greeting.getContent() == null)
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else if(greetings.containsKey(greeting.getId()))
        {
            greetings.replace(greeting.getId(), greeting);
        }
        else
        {
            greetings.put(greeting.getId(), greeting);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}



/**
 GET /greeting/{id}
 POST /greeting
 {"content" : "hejka"}
 */