package duke.parser;

import duke.exception.DukeException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;

class ParserTime {
    static LocalDateTime parseStringToDate(String line) throws DukeException {
        String[] timePatterns = { "dd/MM/yy", "yyyy-MM-dd'T'HH:mm[:ss.n]", "dd/MM/yyyy HHmm", "dd/MM/yy HHmm", "['next ']['this ']E", "['this ']['next ']EEEE", "HHmm", };
        TimePatternType[] timeTypes = {TimePatternType.DATE, TimePatternType.DATE_TIME,  TimePatternType.DATE_TIME, TimePatternType.DATE_TIME, TimePatternType.DAY_OF_WEEK, TimePatternType.DAY_OF_WEEK,TimePatternType.TIME};
        for (int i = 0; i < timePatterns.length;) {
            try {
                TemporalAccessor accessor = DateTimeFormatter.ofPattern(timePatterns[i]).parse(line);
                switch (timeTypes[i]) {
                    case DATE:
                        LocalTime localTime = LocalTime.now();
                        return localTime.atDate(LocalDate.from(accessor));
                    case DATE_TIME:
                        return LocalDateTime.from(accessor);
                    case DAY_OF_WEEK:
                        LocalDateTime localDateTime = LocalDateTime.now();
                        return localDateTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.from(accessor)));
                    case TIME:
                        LocalDate localDate = LocalDate.now();
                        return localDate.atTime(LocalTime.from(accessor));
                    default:
                }
            } catch (DateTimeParseException e) {
                i++;
            }
        }
        throw new DukeException("Invalid format. Refer to help for command format.");
    }
}
