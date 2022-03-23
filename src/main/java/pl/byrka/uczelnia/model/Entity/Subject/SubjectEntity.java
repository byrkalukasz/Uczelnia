package pl.byrka.uczelnia.model.Entity.Subject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Data
@Entity
@Table(name = "subject")
public class SubjectEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "name",nullable = false)
    public String name;
    @Column(name = "ECTS")
    public int ects;
    @Column(name = "type",nullable = true)
    public String type;

    @OneToOne
    @JoinColumn(name = "lecturer_id")
    public LecturerEntity lecturer;

}
