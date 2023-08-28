		
		DROP TABLE IF EXISTS sensor;
		DROP TABLE IF EXISTS sensor_record;
		CREATE TABLE IF NOT EXISTS sensor 
			(id bigserial not null, 
			created timestamp(6) not null, 
			name varchar(255) not null, 
			address varchar(255), 
			description varchar(255), 
			compartment smallint check (compartment between 0 and 100),
			house smallint check (house between 0 and 100), 
			primary key (id));
		CREATE TABLE IF NOT EXISTS sensor_record 
			(id bigserial not null, 
			created timestamp(6) not null, 
			humidity float(53) not null, 
			pressure float(53) not null, 
			temperature float(53) not null, 
			sensor_id bigint, primary key (id));
		ALTER TABLE if EXISTS sensor 
			ADD CONSTRAINT sensorUniqueName unique (name);
		ALTER TABLE if EXISTS sensor_record 
			ADD CONSTRAINT sensorRecordFK foreign key (sensor_id) references sensor;