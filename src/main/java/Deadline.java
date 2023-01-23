import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDateTime dateTime;

    public Deadline(String description, String deadline) throws DukeException {
        super(description);
        LocalDate date = null;
        LocalDateTime dateTime = null;
        DateTimeFormatter[] formatters = {
                DateTimeFormatter.ofPattern("ddMMyyyy HHmm"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm"),
                DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm"),
                DateTimeFormatter.ofPattern("yyyy/MM/dd HHmm"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"),
                DateTimeFormatter.ofPattern("ddMMyyyy"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                DateTimeFormatter.ofPattern("yyyy/MM/dd"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
        };

        for (DateTimeFormatter formatter : formatters) {
            try {
                dateTime = LocalDateTime.parse(deadline, formatter);
                break;
            } catch (DateTimeParseException e) {
                try {
                    date = LocalDate.parse(deadline, formatter);
                    break;
                } catch (DateTimeParseException e2) {
                    // Invalid format, try the next one
                }
            }
        }
        // If date or dateTime is still null, input is in invalid format
        if (date == null && dateTime == null) {
            throw new DukeException.InvalidDateException("Reenter date in this format: (ddMMyyyy) or (ddMMyyyy HHmm).");
        }

        if (date != null) {
            this.dateTime = date.atStartOfDay().plusDays(1).minusNanos(1);
        } else {
            this.dateTime = dateTime;
        }
    }

    public LocalDateTime getDeadline() {
        return dateTime;
    }

    public boolean isOverdue() {
        return LocalDateTime.now().isAfter(dateTime);
    }

    public boolean isUpcoming() {
        return LocalDateTime.now().isBefore(dateTime);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        String deadline = this.dateTime.format(formatter);
        return "[D]" + super.toString() + " (by: " + deadline + ")";
    }
}
