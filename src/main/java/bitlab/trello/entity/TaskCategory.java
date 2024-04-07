package bitlab.trello.entity;

import bitlab.trello.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TASK_CATEGORIES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TaskCategory extends BaseEntity {
    @Column(name = "NAME")
    private String name;
}
