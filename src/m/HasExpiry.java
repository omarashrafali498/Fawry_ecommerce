
package m;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HasExpiry implements Expirable {
    private LocalDate expiryDate;

    public HasExpiry(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.expiryDate = LocalDate.parse(date, formatter);
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}