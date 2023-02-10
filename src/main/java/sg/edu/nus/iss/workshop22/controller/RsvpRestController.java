package sg.edu.nus.iss.workshop22.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.workshop22.model.Rsvp;
import sg.edu.nus.iss.workshop22.service.RsvpService;

@RestController
public class RsvpRestController {

    @Autowired
    RsvpService rsvpService;

    @GetMapping(path = "/api/rsvps", produces = "application/json")
    public Object getAllRsvps() {

        return rsvpService.getAllRsvp();
    }

    @GetMapping(path = "/api/rsvp", produces = "application/json")
    public Object getRsvpByName(@RequestParam String q) {

        List<Rsvp> rsvp = rsvpService.getRsvpByName(q);
        if (rsvp.isEmpty()) {
            JsonObject jo = Json.createObjectBuilder()
                    .add("error", 404)
                    .add("message", "Name " + q + " not found.")
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jo.toString());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rsvp);

    }

    @PostMapping(path = "/api/rsvp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addNewRsvp(@RequestBody Rsvp rsvp) {
        Integer num = rsvpService.updateRsvp(rsvp);
        if (num == 1) {
            String SuccessMessage = "rsvp " + rsvp.fullName + " has been successfully added.";
            return ResponseEntity.status(HttpStatus.CREATED).body(SuccessMessage);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(rsvp.fullName + " has been updated");
    }

    // Receives a json of the key/value then update only email
    @PutMapping(path = "/api/rsvp/{email}")
    public Object updateEmailRsvp(@RequestBody Rsvp rsvp, @PathVariable String email) {
        Boolean result = rsvpService.updateEmailRsvp(email, rsvp.email);
        if (result == true) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Email updated");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
    }

    @GetMapping("/api/rsvps/count")
    public Object getRsvpCount() {
        int count = rsvpService.countRsvp();
        return ResponseEntity.status(HttpStatus.CREATED).body("Total count is: " + count);
    }
}
