package online.gladikov.home.climate_service.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1465278981394723227L;
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
  
    @CreationTimestamp
	@Column(updatable=false,nullable = false)
	private LocalDateTime created;
}
