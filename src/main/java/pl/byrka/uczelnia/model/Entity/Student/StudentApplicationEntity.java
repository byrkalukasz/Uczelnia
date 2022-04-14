package pl.byrka.uczelnia.model.Entity.Student;

import lombok.*;
import pl.byrka.uczelnia.model.Entity.Major.MajorEntity;
import pl.byrka.uczelnia.model.Entity.Specjalization.SpecializationEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;

//Dodano @Transactional ponieważ:
//org.hibernate.LazyInitializationException: could not initialize proxy [pl.byrka.uczelnia.model.Entity.Student.StudentApplicationEntity#3] - no Session
@Getter
@Setter
@Entity
@Builder
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_application")
public class StudentApplicationEntity implements Serializable {
    /*
    Możliwe wartości pola state - aktualnie nie używane przez brak kolejki do wymiany danych
    0 - Utworzona
    1 - Wysłana do weryfikacji
    2 - odebrana odpowiedz
    3 - Przeprocesowana
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "pesel", nullable = false)
    private String pesel;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "count", nullable = false)
    private String count;
    @Column(name = "state", nullable = true)
    private long state;
    @Column(name = "Message", nullable = true)
    private String message;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "major_id", referencedColumnName = "id")
    private MajorEntity major;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialization_id", referencedColumnName = "id")
    private SpecializationEntity specialization;
}
