/*  Comments starting with "-- HSQLDB: " are commands that are interpreted when
this script is used for the ApolloDbUtils unit tests (which use HSQLDB).

All commands listed after "-- HSQLDB: END;" will NOT be run when this script is
used in the unit tests. These commands are MySQL-specific and will not work with HSQLDB.
 */

DROP VIEW IF EXISTS run_data_description_view;
DROP VIEW IF EXISTS translator_output_content_view;
DROP VIEW IF EXISTS software_input;

DROP TABLE IF EXISTS run_status;
DROP TABLE IF EXISTS run_status_description;
DROP TABLE IF EXISTS simulation_group_definition;
DROP TABLE IF EXISTS run_data;

DROP TABLE IF EXISTS role_description;

DROP TABLE IF EXISTS run_data_content;
DROP TABLE IF EXISTS run_data_description;
DROP TABLE IF EXISTS run_data_description_axis_value;
DROP TABLE IF EXISTS run_data_description_axis;
DROP TABLE IF EXISTS simulated_population;
DROP TABLE IF EXISTS population_axis;
DROP TABLE IF EXISTS simulated_population_axis_value;
DROP TABLE IF EXISTS time_series;
DROP TABLE IF EXISTS run;


DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

DROP TABLE IF EXISTS software_identification;
DROP TABLE IF EXISTS simulation_groups;

CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  requester_id VARCHAR(255) NOT NULL,
  hash_of_user_password_and_salt VARCHAR(255) NOT NULL,
  salt VARCHAR(255) NOT NULL,
  user_email VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
);

-- HSQLDB: ALTER TABLE users ALTER COLUMN id RESTART WITH 1;

CREATE TABLE software_identification (
  id INT NOT NULL AUTO_INCREMENT,
  developer VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  version VARCHAR(255) NOT NULL,
  service_type VARCHAR(255) NOT NULL,
  wsdl_url TEXT NOT NULL,
  admin_id INT NOT NULL REFERENCES users(id),
  PRIMARY KEY (id)
);

-- HSQLDB: ALTER TABLE software_identification ALTER COLUMN id RESTART WITH 1;

CREATE TABLE roles (
  id INT NOT NULL AUTO_INCREMENT,
  description VARCHAR(255),
  PRIMARY KEY(id)
);

-- HSQLDB: ALTER TABLE roles ALTER COLUMN id RESTART WITH 1;

INSERT INTO roles VALUES (1, 'Can run SEIR without privileged request');
INSERT INTO roles VALUES (2, 'Can run SEIR with privileged request');
INSERT INTO roles VALUES (3, 'Cannot SEIR');

INSERT INTO roles VALUES (4, 'Can run FRED without privileged request');
INSERT INTO roles VALUES (5, 'Can run FRED with privileged request');
INSERT INTO roles VALUES (6, 'Cannot run FRED');

INSERT INTO roles VALUES (7, 'Can run FluTE without privileged request');
INSERT INTO roles VALUES (8, 'Can run FluTE with privileged request');
INSERT INTO roles VALUES (9, 'Cannot run FluTE');

INSERT INTO roles VALUES (10, 'Can run TSV without privileged request');
INSERT INTO roles VALUES (11, 'Can run TSV with privileged request');
INSERT INTO roles VALUES (12, 'Cannot run TSV');

INSERT INTO roles VALUES (13, 'Can run GAIA without privileged request');
INSERT INTO roles VALUES (14, 'Can run GAIA with privileged request');
INSERT INTO roles VALUES (15, 'Cannot run GAIA');

INSERT INTO roles VALUES (16, 'Can run Anthrax without privileged request');
INSERT INTO roles VALUES (17, 'Can run Anthrax with privileged request');
INSERT INTO roles VALUES (18, 'Cannot run Anthrax');

CREATE TABLE role_description (
  role_id INT REFERENCES roles(id),
  software_id INT REFERENCES software_identification(id),
  can_run_software BIT,
  allow_privileged_request BIT,
  CONSTRAINT role_description UNIQUE(role_id, software_id)
);


CREATE TABLE user_roles (
  user_id INT NOT NULL REFERENCES users(id),
  role_id INT NOT NULL REFERENCES roles(id),
  CONSTRAINT user_role_unique UNIQUE (user_id, role_id)
);

CREATE TABLE run_data_content
 (
  id INT NOT NULL AUTO_INCREMENT,
  binary_content LONGBLOB,
  text_content LONGTEXT,
  md5_hash_of_content CHAR(32) NOT NULL,
  md5_collision_id INT NOT NULL DEFAULT 1,
  PRIMARY KEY(id),
  CONSTRAINT run_data_content_unique UNIQUE (md5_hash_of_content, md5_collision_id)
);

-- HSQLDB: ALTER TABLE run_data_content ALTER COLUMN id RESTART WITH 1;

CREATE TABLE simulation_groups (
  id INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY(id)
);

-- HSQLDB: ALTER TABLE simulation_groups ALTER COLUMN id RESTART WITH 1;

CREATE TABLE run (
  id INT NOT NULL AUTO_INCREMENT,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
  md5_hash_of_run_message CHAR(32) NOT NULL,
  md5_collision_id INT NOT NULL DEFAULT 1,
  software_id INT NOT NULL,
  requester_id INT NOT NULL,
  simulation_group_id INT,
  last_service_to_be_called int,
  PRIMARY KEY (id),
  CONSTRAINT run_unique UNIQUE (md5_hash_of_run_message, md5_collision_id),
  CONSTRAINT fk_software_id FOREIGN KEY (software_id) REFERENCES software_identification(id),
  CONSTRAINT fk_requester_id FOREIGN KEY (requester_id) REFERENCES users (id),
  CONSTRAINT fk_simulation_group_id FOREIGN KEY (simulation_group_id) REFERENCES simulation_groups (id),
  CONSTRAINT fk_last_service_to_be_called FOREIGN KEY (last_service_to_be_called) REFERENCES software_identification (id)
);

-- HSQLDB: ALTER TABLE run ALTER COLUMN id RESTART WITH 1;

CREATE TABLE run_status_description (
  id INT NOT NULL AUTO_INCREMENT,
  status VARCHAR(32) NOT NULL,
  PRIMARY KEY (id)
);

-- HSQLDB: ALTER TABLE run_status_description ALTER COLUMN id RESTART WITH 1;

INSERT INTO run_status_description (status) VALUES ('exiting');
INSERT INTO run_status_description (status) VALUES ('held');
INSERT INTO run_status_description (status) VALUES ('queued');
INSERT INTO run_status_description (status) VALUES ('called_translator');
INSERT INTO run_status_description (status) VALUES ('called_visualizer');
INSERT INTO run_status_description (status) VALUES ('called_simulator');
INSERT INTO run_status_description (status) VALUES ('translating');
INSERT INTO run_status_description (status) VALUES ('translation_completed');
INSERT INTO run_status_description (status) VALUES ('initializing');
INSERT INTO run_status_description (status) VALUES ('log_files_written');
INSERT INTO run_status_description (status) VALUES ('staging');
INSERT INTO run_status_description (status) VALUES ('running');
INSERT INTO run_status_description (status) VALUES ('moving');
INSERT INTO run_status_description (status) VALUES ('waiting');
INSERT INTO run_status_description (status) VALUES ('completed');
INSERT INTO run_status_description (status) VALUES ('failed');
INSERT INTO run_status_description (status) VALUES ('unauthorized');
INSERT INTO run_status_description (status) VALUES ('unknown_runid');
INSERT INTO run_status_description (status) VALUES ('run_terminated');
INSERT INTO run_status_description (status) VALUES ('authentication_failure');

CREATE TABLE run_status (
  id INT NOT NULL AUTO_INCREMENT,
  run_id INT NOT NULL,
  status_id INT NOT NULL,
  message VARCHAR(255),
  PRIMARY KEY (id),
  CONSTRAINT fk_run_id FOREIGN KEY (run_id) REFERENCES run (id),
  CONSTRAINT fk_status_id FOREIGN KEY (status_id) REFERENCES run_status_description(id)
);

-- HSQLDB: ALTER TABLE run_status ALTER COLUMN id RESTART WITH 1;

CREATE TABLE simulation_group_definition (
  simulation_group_id INT NOT NULL REFERENCES simulation_groups(id),
  run_id INT NOT NULL,
  CONSTRAINT fk_sim_group_def_run_id FOREIGN KEY (run_id) REFERENCES run (id)
);

CREATE TABLE run_data_description (
  id INT NOT NULL AUTO_INCREMENT,
  label VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
);

-- HSQLDB: ALTER TABLE run_data_description ALTER COLUMN id RESTART WITH 1;

CREATE TABLE run_data_description_axis (
  id INT NOT NULL AUTO_INCREMENT,
  label VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- HSQLDB: ALTER TABLE run_data_description_axis ALTER COLUMN id RESTART WITH 1;

CREATE TABLE run_data (
  id INT NOT NULL AUTO_INCREMENT,
  run_id INT NOT NULL,
  description_id INT NOT NULL REFERENCES run_data_description(id),
  content_id INT NOT NULL REFERENCES run_data_content(id),
  PRIMARY KEY (id),
  CONSTRAINT fk_run_data_run_id FOREIGN KEY (run_id) REFERENCES run (id),
  CONSTRAINT run_data_unique UNIQUE (run_id, description_id, content_id)
);

-- HSQLDB: ALTER TABLE run_data ALTER COLUMN id RESTART WITH 1;

INSERT INTO run_data_description_axis (label) values ('format');
INSERT INTO run_data_description_axis (label) values ('label');
INSERT INTO run_data_description_axis (label) values ('type');
INSERT INTO run_data_description_axis (label) values ('source_software_id');
INSERT INTO run_data_description_axis (label) values ('destination_software_id');


CREATE TABLE run_data_description_axis_value (
  run_data_description_id INT NOT NULL REFERENCES run_data_description (id),
  run_data_description_axis_id INT NOT NULL REFERENCES run_data_description_axis (id),
  value VARCHAR(255) NOT NULL
);

INSERT INTO run_data_description (label) values ('FRED text configuration file, config.txt'); /* 1 */
INSERT INTO run_data_description (label) values ('FRED text configuration file, fred_initial_population_0.txt'); /* 2 */
INSERT INTO run_data_description (label) values ('FRED text configuration file, fred-vaccination-schedule_0.txt'); /* 3 */
INSERT INTO run_data_description (label) values ('FluTE text configuration file, config.txt'); /* 4 */
INSERT INTO run_data_description (label) values ('TimeSeriesVisualizer output url, incidence.png'); /* 5 */
INSERT INTO run_data_description (label) values ('TimeSeriesVisualizer output url, prevalence.png'); /* 6 */
INSERT INTO run_data_description (label) values ('TimeSeriesVisualizer text input file, time_series_visualizer_input.xml'); /* 7 */
INSERT INTO run_data_description (label) values ('Reed-Frost text configuration file, config.txt'); /* 8 */
INSERT INTO run_data_description (label) values ('GES binary configuration file, config.bin'); /* 9 */
INSERT INTO run_data_description (label) values ('GAIA input file, gaia.zip'); /* 10 */
INSERT INTO run_data_description (label) values ('Verbose HTML file for FRED, verbose.html'); /* 11*/
INSERT INTO run_data_description (label) values ('SEIR Simulator log file for newly-exposed, newly_exposed.txt '); /* 12*/
INSERT INTO run_data_description (label) values ('SEIR Simulator log file for susceptible, susceptible.txt '); /* 13*/
INSERT INTO run_data_description (label) values ('SEIR Simulator log file for exposed, exposed.txt '); /* 14*/
INSERT INTO run_data_description (label) values ('SEIR Simulator log file for infectious, infectious.txt '); /* 15*/
INSERT INTO run_data_description (label) values ('SEIR Simulator log file for recovered, recovered.txt '); /* 16*/
INSERT INTO run_data_description (label) values ('SEIR Simulator log file for antivirals given, av_given.txt '); /* 17*/
INSERT INTO run_data_description (label) values ('SEIR Simulator log file for vaccines given, vacc_gave_to.txt '); /* 18*/
INSERT INTO run_data_description (label) values ('Verbose HTML for SEIR, verbose.html '); /* 19*/
INSERT INTO run_data_description (label) values ('SEIR text configuration file, config.txt '); /* 20*/
INSERT INTO run_data_description (label) values ('FluTE verbose configuration file, verbose.html'); /* 21 */
INSERT INTO run_data_description (label) values ('SEIR verbose configuration file, verbose.html'); /* 22 */
INSERT INTO run_data_description (label) values ('TSV FluTE Simulator log file for newly-exposed, newly_exposed.txt '); /* 23 */
INSERT INTO run_data_description (label) values ('TSV FluTE Simulator log file for susceptible, susceptible.txt '); /* 24 */
INSERT INTO run_data_description (label) values ('TSV FluTE Simulator log file for exposed, exposed.txt '); /* 25 */
INSERT INTO run_data_description (label) values ('TSV FluTE Simulator log file for infectious, infectious.txt '); /* 26 */
INSERT INTO run_data_description (label) values ('TSV FluTE Simulator log file for recovered, recovered.txt '); /* 27*/
INSERT INTO run_data_description (label) values ('TSV FluTE Simulator log file for antivirals given, av_given.txt '); /* 28*/
INSERT INTO run_data_description (label) values ('TSV FluTE Simulator log file for vaccines given, vacc_gave_to.txt '); /* 29*/
INSERT INTO run_data_description (label) values ('TSV FRED Simulator log file for newly-exposed, newly_exposed.txt '); /* 30*/
INSERT INTO run_data_description (label) values ('TSV FRED Simulator log file for susceptible, susceptible.txt '); /* 31*/
INSERT INTO run_data_description (label) values ('TSV FRED Simulator log file for exposed, exposed.txt '); /* 32 */
INSERT INTO run_data_description (label) values ('TSV FRED Simulator log file for infectious, infectious.txt '); /* 33 */
INSERT INTO run_data_description (label) values ('TSV FRED Simulator log file for recovered, recovered.txt '); /* 34 */
INSERT INTO run_data_description (label) values ('TSV FRED Simulator log file for antivirals given, av_given.txt '); /* 35 */
INSERT INTO run_data_description (label) values ('TSV FRED Simulator log file for vaccines given, vacc_gave_to.txt '); /* 36*/
INSERT INTO run_data_description (label) values ('GAIA FluTE Simulator log file for newly-exposed, newly_exposed.txt '); /* 37 */
INSERT INTO run_data_description (label) values ('GAIA FRED Simulator log file for newly-exposed, newly_exposed.txt '); /* 38*/
INSERT INTO run_data_description (label) values ('GAIA movie, movie.ogg '); /* 39*/
INSERT INTO run_data_description (label) values ('RunSimulationMessage JSON, run_simulation_message.json '); /* 40*/
INSERT INTO run_data_description (label) values ('RunVisualizationMessage JSON for Time Series Visualizer, run_visualization_message.json '); /* 41*/
INSERT INTO run_data_description (label) values ('RunVisualizationMessage JSON for GAIA Visualizer, run_visualization_message.json '); /* 42*/
INSERT INTO run_data_description (label) values ('Anthrax text configuration file, config.txt '); /* 43*/
INSERT INTO run_data_description (label) values ('Anthrax verbose configuration file, verbose.html'); /* 44 */
INSERT INTO run_data_description (label) values ('Anthrax Simulator log file for susceptible, susceptible.txt '); /* 45*/
INSERT INTO run_data_description (label) values ('Anthrax Simulator log file for exposed, exposed.txt '); /* 46*/
INSERT INTO run_data_description (label) values ('Anthrax Simulator log file for recovered, recovered.txt ');



INSERT INTO run_data_description_axis_value (run_data_description_id, run_data_description_axis_id, value) values
	(1, 1, 'TEXT'), 
	(1, 2, 'config.txt'),
	(1, 3, 'CONFIGURATION_FILE'),
	(1, 4, '1'),
	(1, 5, '3'),

	(2, 1, 'TEXT'),
	(2, 2, 'fred_initial_population_0.txt'),
	(2, 3, 'CONFIGURATION_FILE'),
	(2, 4, '1'),
	(2, 5, '3'),
	
	(3, 1, 'TEXT'),
	(3, 2, 'fred-vaccination-schedule_0.txt'),
	(3, 3, 'CONFIGURATION_FILE'),
	(3, 4, '1'),
	(3, 5, '3'),
	
	(4, 1, 'TEXT'), 
	(4, 2, 'config.txt'),
	(4, 3, 'CONFIGURATION_FILE'),
	(4, 4, '1'),
	(4, 5, '6'),
	
	(5, 1, 'URL'), 
	(5, 2, 'incidence.png'),
	(5, 3, 'IMAGE'),
	(5, 4, '4'),
	(5, 5, '0'),
	
	(6, 1, 'URL'), 
	(6, 2, 'prevalence.png'),
	(6, 3, 'IMAGE'),
	(6, 4, '4'),
	(6, 5, '0'),
	
	(7, 1, 'xml'), 
	(7, 2, 'config.xml'),
	(7, 3, 'CONFIGURATION_FILE'),
	(7, 4, 'Simulator'),
	(7, 5, '0'),
	
	(8, 1, 'TEXT'), 
	(8, 2, 'config.txt'),
	(8, 3, 'CONFIGURATION_FILE'),
	(8, 4, '1'),
	(8, 5, 'Reed-Frost'),
	
	(9, 1, 'binary'), 
	(9, 2, 'config.bin'),
	(9, 3, 'CONFIGURATION_FILE'),
	(9, 4, '1'),
	(9, 5, 'GES'),
	
	(10, 1, 'zip'), 
	(10, 2, 'gaia.zip'),
	(10, 3, 'CONFIGURATION_FILE'),
	(10, 4, '3'),
	(10, 5, '5'),
	
	(11, 1, 'TEXT'), 
	(11, 2, 'verbose.html'),
	(11, 3, 'CONFIGURATION_FILE'),
	(11, 4, '1'),
	(11, 5, '3'),
	
	
	(12, 1, 'TEXT'), 
	(12, 2, 'newly_exposed.txt'),
	(12, 3, 'SIMULATOR_LOG_FILE'),
	(12, 4, '2'),
	(12, 5, '4'),
	
	(13, 1, 'TEXT'), 
	(13, 2, 'susceptible.txt'),
	(13, 3, 'SIMULATOR_LOG_FILE'),
	(13, 4, '2'),
	(13, 5, '4'),
	
	(14, 1, 'TEXT'), 
	(14, 2, 'exposed.txt'),
	(14, 3, 'SIMULATOR_LOG_FILE'),
	(14, 4, '2'),
	(14, 5, '4'),
	
	(15, 1, 'TEXT'), 
	(15, 2, 'infectious.txt'),
	(15, 3, 'SIMULATOR_LOG_FILE'),
	(15, 4, '2'),
	(15, 5, '4'),
	
	(16, 1, 'TEXT'), 
	(16, 2, 'recovered.txt'),
	(16, 3, 'SIMULATOR_LOG_FILE'),
	(16, 4, '2'),
	(16, 5, '4'),
	
	(17, 1, 'TEXT'), 
	(17, 2, 'av_administered.txt'),
	(17, 3, 'SIMULATOR_LOG_FILE'),
	(17, 4, '2'),
	(17, 5, '4'),
	
	(18, 1, 'TEXT'), 
	(18, 2, 'vacc_administered.txt'),
	(18, 3, 'SIMULATOR_LOG_FILE'),
	(18, 4, '2'),
	(18, 5, '4'),
	
	(19, 1, 'TEXT'), 
	(19, 2, 'verbose.html'),
	(19, 3, 'CONFIGURATION_FILE'),
	(19, 4, '1'),
	(19, 5, '2'),
	
	(20, 1, 'TEXT'), 
	(20, 2, 'config.txt'),
	(20, 3, 'CONFIGURATION_FILE'),
	(20, 4, '1'),
	(20, 5, '2'),
	
	(21, 1, 'TEXT'), 
	(21, 2, 'verbose.html'),
	(21, 3, 'CONFIGURATION_FILE'),
	(21, 4, '1'),
	(21, 5, '6'),
	
	(22, 1, 'TEXT'), 
	(22, 2, 'verbose.html'),
	(22, 3, 'CONFIGURATION_FILE'),
	(22, 4, '2'),
	(22, 5, '6'),
	
	(23, 1, 'TEXT'), 
	(23, 2, 'newly_exposed.txt'),
	(23, 3, 'SIMULATOR_LOG_FILE'),
	(23, 4, '6'),
	(23, 5, '4'),
	
	(24, 1, 'TEXT'), 
	(24, 2, 'susceptible.txt'),
	(24, 3, 'SIMULATOR_LOG_FILE'),
	(24, 4, '6'),
	(24, 5, '4'),
	
	(25, 1, 'TEXT'), 
	(25, 2, 'exposed.txt'),
	(25, 3, 'SIMULATOR_LOG_FILE'),
	(25, 4, '6'),
	(25, 5, '4'),
	
	(26, 1, 'TEXT'), 
	(26, 2, 'infectious.txt'),
	(26, 3, 'SIMULATOR_LOG_FILE'),
	(26, 4, '6'),
	(26, 5, '4'),
	
	(27, 1, 'TEXT'), 
	(27, 2, 'recovered.txt'),
	(27, 3, 'SIMULATOR_LOG_FILE'),
	(27, 4, '6'),
	(27, 5, '4'),
	
	(28, 1, 'TEXT'), 
	(28, 2, 'av_administered.txt'),
	(28, 3, 'SIMULATOR_LOG_FILE'),
	(28, 4, '6'),
	(28, 5, '4'),
	
	(29, 1, 'TEXT'), 
	(29, 2, 'vacc_administered.txt'),
	(29, 3, 'SIMULATOR_LOG_FILE'),
	(29, 4, '6'),
	(29, 5, '4'),
	
	(30, 1, 'TEXT'), 
	(30, 2, 'newly_exposed.txt'),
	(30, 3, 'SIMULATOR_LOG_FILE'),
	(30, 4, '3'),
	(30, 5, '4'),
	
	(31, 1, 'TEXT'), 
	(31, 2, 'susceptible.txt'),
	(31, 3, 'SIMULATOR_LOG_FILE'),
	(31, 4, '3'),
	(31, 5, '4'),
	
	(32, 1, 'TEXT'), 
	(32, 2, 'exposed.txt'),
	(32, 3, 'SIMULATOR_LOG_FILE'),
	(32, 4, '3'),
	(32, 5, '4'),
	
	(33, 1, 'TEXT'), 
	(33, 2, 'infectious.txt'),
	(33, 3, 'SIMULATOR_LOG_FILE'),
	(33, 4, '3'),
	(33, 5, '4'),
	
	(34, 1, 'TEXT'), 
	(34, 2, 'recovered.txt'),
	(34, 3, 'SIMULATOR_LOG_FILE'),
	(34, 4, '3'),
	(34, 5, '4'),
	
	(35, 1, 'TEXT'), 
	(35, 2, 'av_administered.txt'),
	(35, 3, 'SIMULATOR_LOG_FILE'),
	(35, 4, '3'),
	(35, 5, '4'),
	
	(36, 1, 'TEXT'), 
	(36, 2, 'vacc_administered.txt'),
	(36, 3, 'SIMULATOR_LOG_FILE'),
	(36, 4, '3'),
	(36, 5, '4'),
	
	(37, 1, 'TEXT'), 
	(37, 2, 'newly_exposed.txt'),
	(37, 3, 'SIMULATOR_LOG_FILE'),
	(37, 4, '6'),
	(37, 5, '5'),
	
	(38, 1, 'TEXT'), 
	(38, 2, 'newly_exposed.txt'),
	(38, 3, 'SIMULATOR_LOG_FILE'),
	(38, 4, '3'),
	(38, 5, '5'),
	
	(39, 1, 'URL'), 
	(39, 2, 'movie.ogg'),
	(39, 3, 'MOVIE'),
	(39, 4, '5'),
	(39, 5, '0'),
	
	(40, 1, 'TEXT'), 
	(40, 2, 'run_simulation_message.json'),
	(40, 3, 'RUN_SIMULATION_MESSAGE'),
	(40, 4, '0'),
	(40, 5, '1'),
	
	(41, 1, 'TEXT'), 
	(41, 2, 'run_visualization_message.json'),
	(41, 3, 'RUN_VISUALIZATION_MESSAGE'),
	(41, 4, '0'),
	(41, 5, '4'),
	
	(42, 1, 'TEXT'), 
	(42, 2, 'run_visualization_message.json'),
	(42, 3, 'RUN_VISUALIZATION_MESSAGE'),
	(42, 4, '0'),
	(42, 5, '5'),
	
	(43, 1, 'TEXT'), 
	(43, 2, 'config.txt'),
	(43, 3, 'CONFIGURATION_FILE'),
	(43, 4, '1'),
	(43, 5, '7'),
	
	(44, 1, 'TEXT'), 
	(44, 2, 'verbose.html'),
	(44, 3, 'CONFIGURATION_FILE'),
	(44, 4, '1'),
	(44, 5, '7'),

	(45, 1, 'TEXT'), 
	(45, 2, 'susceptible.txt'),
	(45, 3, 'SIMULATOR_LOG_FILE'),
	(45, 4, '7'),
	(45, 5, '4'),
	
	(46, 1, 'TEXT'), 
	(46, 2, 'exposed.txt'),
	(46, 3, 'SIMULATOR_LOG_FILE'),
	(46, 4, '7'),
	(46, 5, '4'),
	
	(47, 1, 'TEXT'), 
	(47, 2, 'recovered.txt'),
	(47, 3, 'SIMULATOR_LOG_FILE'),
	(47, 4, '7'),
	(47, 5, '4');

CREATE VIEW run_data_description_view AS
SELECT
	des.id as run_data_description_id,
	axis_value1.value AS format,
	axis_value2.value AS label,
	axis_value3.value AS type,
	axis_value4.value AS source_software,
	axis_value5.value AS destination_software 
FROM
	run_data_description des,
	run_data_description_axis axis1,
	run_data_description_axis axis2,
	run_data_description_axis axis3,
	run_data_description_axis axis4,
	run_data_description_axis axis5,
	run_data_description_axis_value axis_value1,
	run_data_description_axis_value axis_value2,
	run_data_description_axis_value axis_value3,
	run_data_description_axis_value axis_value4,
	run_data_description_axis_value axis_value5
WHERE
	des.id = axis_value1.run_data_description_id AND
	des.id = axis_value2.run_data_description_id AND
	des.id = axis_value3.run_data_description_id AND
	des.id = axis_value4.run_data_description_id AND
	des.id = axis_value5.run_data_description_id AND
	axis_value1.run_data_description_axis_id = axis1.id AND
	axis_value2.run_data_description_axis_id = axis2.id AND
	axis_value3.run_data_description_axis_id = axis3.id AND
	axis_value4.run_data_description_axis_id = axis4.id AND
	axis_value5.run_data_description_axis_id = axis5.id AND
	axis1.id = 1 AND
	axis2.id = 2 AND
	axis3.id = 3 AND
	axis4.id = 4 AND
	axis5.id = 5;
	

CREATE VIEW translator_output_content_view AS
SELECT
    rd.run_id,
	rddv.label,
    rddv.source_software,
    rddv.destination_software,
	rdc.text_content 
FROM
	run_data_content rdc,
	run_data rd,
	run_data_description_view rddv 
WHERE
	rd.content_id = rdc.id AND
	rddv.run_data_description_id = rd.description_id AND
	rddv.source_software = 1;

CREATE TABLE simulated_population (
  id INT NOT NULL AUTO_INCREMENT,
  label VARCHAR(255),
  PRIMARY KEY (id)
);

-- HSQLDB: ALTER TABLE simulated_population ALTER COLUMN id RESTART WITH 1;

CREATE TABLE population_axis (
  id INT NOT NULL AUTO_INCREMENT,
  label VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- HSQLDB: ALTER TABLE population_axis ALTER COLUMN id RESTART WITH 1;

CREATE TABLE simulated_population_axis_value (
  population_id INT NOT NULL REFERENCES simulated_population (id),
  axis_id INT NOT NULL REFERENCES population_axis (id),
  value VARCHAR(255) NOT NULL
);

CREATE TABLE time_series (
  run_id INT NOT NULL REFERENCES run (id),
  population_id INT NOT NULL REFERENCES simulated_population (id),
  time_step INT NOT NULL,
  pop_count FLOAT  NOT NULL
);

INSERT INTO population_axis (label) values ('disease_state');
INSERT INTO population_axis (label) values ('location');

create view software_input as
SELECT
    rd.run_id,
    rddav3.value AS destination_software,
	rddav1.value AS label,
    rdc.text_content
FROM
	run_data_content rdc,
	run_data rd,
	run_data_description_axis_value rddav1,
    run_data_description_axis_value rddav2,
    run_data_description_axis_value rddav3
WHERE
	rddav1.run_data_description_axis_id = 2 AND
    rddav2.run_data_description_axis_id = 3 AND
    rddav3.run_data_description_axis_id = 5 AND
    rd.description_id = rddav3.run_data_description_id AND
    rd.description_id = rddav2.run_data_description_id AND
	rd.description_id = rddav1.run_data_description_id AND
	rdc.id = rd.content_id;
	
-- HSQLDB: CREATE TRIGGER run_creation_timestamp BEFORE INSERT ON run REFERENCING NEW AS newrow FOR EACH ROW SET newrow.created = NOW();
	
-- HSQLDB: END;
	
CREATE TRIGGER run_creation_timestamp BEFORE INSERT ON run 
FOR EACH ROW
SET NEW.created = NOW();


	