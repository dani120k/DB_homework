package TaskApp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    Date creation_time;

    @Column(name = "description")
    private String description;

    @Column(name = "creator_user_id")
    private Long creator_user_id;

    @Column(name = "executor_user_id")
    private Long executor_user_id;

    @Column(name = "curr_hours")
    private Long curr_hours;

    @Column(name = "full_hours")
    private Long full_hours;

    @Column(name = "status")
    private Long status;

}
