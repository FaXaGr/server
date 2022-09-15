package Server.Server.Service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.sound.midi.Sequence;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "history_id_seq", sequenceName = "history_id_seq", allocationSize = 50)
    private Long id;
    private String prName;
    private String telNumber;
    private Double summa;
    private boolean successfully;
}
