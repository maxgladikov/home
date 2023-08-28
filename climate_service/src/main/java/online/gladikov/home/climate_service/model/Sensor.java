package online.gladikov.home.climate_service.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sensor extends BaseEntity {

	private static final long serialVersionUID = -4287475643755349509L;
	
	public Sensor(@NotBlank(message = "Name is mandatory") @NotNull String name) {
		super();
		this.name = name;
	}
	@NotBlank(message = "Name is mandatory")
	@NotNull
	@Column(unique = true)
	private String name;
	private String address;
	private String description;
	@OneToMany(mappedBy = "sensor")
	private Set<SensorRecord> records;
}
