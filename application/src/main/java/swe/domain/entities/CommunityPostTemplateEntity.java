package swe.domain.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommunityPostTemplateEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  private String id;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<FieldDefinition> fieldDefinitions;

  @OneToOne private CommunityEntity community;
}
