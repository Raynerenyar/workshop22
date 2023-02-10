package sg.edu.nus.iss.workshop22.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.workshop22.model.Rsvp;
import sg.edu.nus.iss.workshop22.repo.RsvpRepo;

@Service
public class RsvpService {

    @Autowired
    RsvpRepo rsvpRepo;

    public List<Rsvp> getAllRsvp() {
        return rsvpRepo.getAllRsvp();
    }

    public List<Rsvp> getRsvpByName(String name) {
        return rsvpRepo.getRsvpByName(name);
    }

    public Integer updateRsvp(Rsvp rsvp) {
        List<Rsvp> rsvps = rsvpRepo.getRsvpByName(rsvp.fullName);
        if (rsvps.isEmpty()) {
            return rsvpRepo.updateRsvp(rsvp);

        }
        return rsvpRepo.overwriteRsvp(rsvp, rsvps.get(0).getId()) + 1;
    }

    public Boolean updateEmailRsvp(String email1, String email2) {
        int num = rsvpRepo.updateEmailRsvp(email1, email2);
        if (num == 1) {
            return true;

        }
        return false;
    }

    public Integer countRsvp() {
        return rsvpRepo.getRsvpCount();
    }
}
