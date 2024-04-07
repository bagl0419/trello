package bitlab.trello.entity;

import bitlab.trello.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "FOLDERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Folder extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<TaskCategory> categories;
}
