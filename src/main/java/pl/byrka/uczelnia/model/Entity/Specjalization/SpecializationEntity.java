package pl.byrka.uczelnia.model.Entity.Specjalization;

import lombok.*;
import pl.byrka.uczelnia.model.Entity.Group.GroupEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Specialization")
public class SpecializationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "name", nullable = false)
    public String name;
    @Column(name = "active", nullable = false)
    public boolean active;

    @ManyToMany(mappedBy = "specialization")
    private List<GroupEntity> group;
}
