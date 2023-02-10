package sg.edu.nus.iss.workshop22.repo;

public class Queries {
    public static String GET_ALL_RSVP = "SELECT * FROM rsvp";
    public static String GET_RSVP_BY_NAME = "SELECT * FROM rsvp WHERE full_name = ?";
    public static String UPDATE_RSVP = """
            INSERT INTO rsvp(
            full_name,
            email, phone,
            confirmation_date,
            comments)
            VALUES(?, ?,?,?,?)
            """;
    public static String OVERWRITE_RSVP = """
                    UPDATE rsvp SET
                    full_name = ?,
                    email = ?,
                    phone = ?,
                    confirmation_date = ?,
                    comments = ?
                    WHERE id = ?
            """;

    public static String UPDATE_EMAIL_RSVP = """
            UPDATE rsvp SET
            email = ?
            WHERE email = ?
                    """;

    public static String COUNT_RSVP = """
            SELECT COUNT(*) as count FROM rsvp;
                        """;
}
