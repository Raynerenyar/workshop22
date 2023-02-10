package sg.edu.nus.iss.workshop22.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rsvp {

    public int id;
    public String fullName;
    public String email;
    public Integer phone;
    public Date confirmationDate;
    public String comments;

    // public Rsvp(String fullName, String email, Integer phone, Date
    // confirmationDate, String comments) {
    // this.fullName = fullName;
    // this.email = email;
    // this.phone = phone;
    // this.confirmationDate = confirmationDate;
    // this.comments = comments;
    // }

}
