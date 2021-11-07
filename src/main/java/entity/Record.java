package entity;


import lombok.*;

import java.sql.Date;
import java.sql.Time;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Record {
    private int Id;
    private final Date date;
    private final Time startTime;
    private final Time endTime;
    private final Person client;
    private final Person worker;
    private final Service service;
}
