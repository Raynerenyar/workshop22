package sg.edu.nus.iss.workshop22.repo;

import java.util.List;

import sg.edu.nus.iss.workshop22.model.Rsvp;

public interface RsvpRepo {

    List<Rsvp> getAllRsvp();

    List<Rsvp> getRsvpByName(String name);

    Integer updateRsvp(Rsvp rsvp);

    Integer overwriteRsvp(Rsvp rsvp, int id);

    Integer updateEmailRsvp(String email1, String email2);

    Integer getRsvpCount();

}
