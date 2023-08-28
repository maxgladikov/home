//package online.gladikov.home.climate_service.model.mapper;
//
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.mapstruct.factory.Mappers;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import lombok.RequiredArgsConstructor;
//import online.gladikov.home.climate_service.model.SensorRecord;
//import online.gladikov.home.climate_service.model.dto.Dummy;
//import online.gladikov.home.climate_service.model.dto.DummyMapper;
//import online.gladikov.home.climate_service.model.dto.SensorRecordDto;
//class SensorRecordMapperTest {
//	
////	private final SensorRecordMapper mapper;
////	private final SensorRecordMapper mapper=Mappers.getMapper(SensorRecordMapper.class);
//	private  DummyMapper mapper=DummyMapper.INSTANCE;
////	@Disabled
////	@Test
////	void givenSensor_whenMap_thenCorrect() {
//		// given
////		SensorRecord record=new SensorRecord("livingroom", 1.0, 2.0, 3.0);
////		record.setId(1L);
//		// when
////		SensorRecordDto dto=mapper.sensorRecordToSensoRecordrDto(record);
//		// then
////		assertThat(dto.id()).isEqualTo(1L);
////		assertThat(dto.sensor()).isEqualTo("livingroom");
////		assertThat(dto.temperature()).isEqualTo(1);
////		assertThat(dto.pressure()).isEqualTo(2);
////		assertThat(dto.humidity()).isEqualTo(3);
////		assertThat(true).isEqualTo(true);
////	}
//	
//	@Test
//	void test() {
//		Dummy dummy=Dummy.builder().field("OPA").build();
//		var dto=mapper.dummyToDto(dummy);
//		assertThat(dto.field()).isEqualTo("OPA");
//	}
//	
//}
