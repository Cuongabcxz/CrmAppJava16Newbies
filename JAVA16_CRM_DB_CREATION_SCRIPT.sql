CREATE DATABASE IF NOT EXISTS crm;

USE crm;

CREATE TABLE IF NOT EXISTS role (
	id 				int auto_increment,
    name 			varchar(100) not null,
    description 	varchar(255),
    primary key(id)
);

CREATE TABLE IF NOT EXISTS user (
	id 				int auto_increment,
    email			varchar(100) not null unique,
    password		varchar(255) not null,
    name 			varchar(100) not null,
    address	 		varchar(255),
    phone			varchar(50),
    role_id			int,
    primary key(id)
);

CREATE TABLE IF NOT EXISTS project (
	id 				int auto_increment,
    name 			varchar(100) not null,
    description 	varchar(255),
    start_date		date,
    end_date		date,
    owner			int,
    primary key(id)
);

CREATE TABLE IF NOT EXISTS project_user (
	project_id		int,
    user_id			int,
    join_date		date,
    role_description varchar(255),
    primary key(project_id, user_id)
);

CREATE TABLE IF NOT EXISTS status (
	id 				int auto_increment,
    name 			varchar(100) not null,
    description 	varchar(255),
    primary key(id)
);

CREATE TABLE IF NOT EXISTS task (
	id 				int auto_increment,
    name 			varchar(100) not null,
    description 	varchar(255),
	start_date		date,
    end_date		date,
    project_id		int,
    user_id			int,
    status_id		int,
    primary key(id)
);

ALTER TABLE user
	ADD CONSTRAINT FK_USER_ROLE
		FOREIGN KEY (role_id) REFERENCES role(id); 
        
ALTER TABLE project
	ADD CONSTRAINT FK_PROJECT_USER_OWNER
		FOREIGN KEY (owner) REFERENCES user(id); 
	
ALTER TABLE project_user
	ADD CONSTRAINT FK_PROJECT_USER_PROJECT_USER_LIST
		FOREIGN KEY (project_id) REFERENCES project(id),
	ADD CONSTRAINT FK_PROJECT_USER_USER_JOIN_LIST
		FOREIGN KEY (user_id) REFERENCES user(id);

ALTER TABLE task
	ADD CONSTRAINT FK_TASK_USER
		FOREIGN KEY (user_id) REFERENCES user(id),
	ADD CONSTRAINT FK_TASK_PROJECT
		FOREIGN KEY (project_id) REFERENCES project(id),
	ADD CONSTRAINT FK_TASK_STATUS
		FOREIGN KEY (status_id) REFERENCES status(id);
        
        
INSERT INTO role (name)
VALUES ('Admin');
INSERT INTO role (name)
VALUES ('Manager');
INSERT INTO role (name)
VALUES ('Employee');


INSERT INTO user(email,password,name,address,phone,role_id)
VALUES ('admin@gmail.com','admin','admin','admin',0336040892,1);
INSERT INTO user (email, password, name, address, phone, role_id) 
VALUES ('dboig0@artisteer.com', '7rPeom', 'Darryl Boig', '5 Debs Center', '265-824-8290', 2);
INSERT INTO user (email, password, name, address, phone, role_id) 
VALUES ('ltixall1@1und1.de', '9qlM17W', 'Leia Tixall', '3415 Beilfuss Circle', '667-680-0083', 3);
INSERT INTO user (email, password, name, address, phone, role_id) 
VALUES ('dcolebourne2@godaddy.com', 'NukaKxDiJH', 'Duncan Colebourne', '19395 Porter Plaza', '217-136-3693', 2);
INSERT INTO user (email, password, name, address, phone, role_id) 
VALUES ('kdel3@ifeng.com', 'gtJCrUC8m', 'Korie Del Castello', '3 Loeprich Hill', '155-288-7804', 2);
INSERT INTO user (email, password, name, address, phone, role_id) 
VALUES ('mabsolom4@ebay.com', '1XASM9sPZG', 'Meghann Absolom', '060 Linden Street', '900-300-2624', 3);
INSERT INTO user (email, password, name, address, phone, role_id) 
VALUES ('smenaul5@msn.com', 'urrJyJEub7', 'Stanley Menaul', '07 Texas Street', '783-751-3145', 2);
INSERT INTO user (email, password, name, address, phone, role_id) 
VALUES ('dpyatt6@cnbc.com', '1khfkWxaK07', 'Dido Pyatt', '20 Grover Crossing', '725-241-8184', 3);
INSERT INTO user (email, password, name, address, phone, role_id) 
VALUES ('cmesser7@reverbnation.com', 'fROVUqGwGKm', 'Corrie Messer', '586 Dennis Street', '476-482-6968', 3);
INSERT INTO user (email, password, name, address, phone, role_id) 
VALUES ('lrelf8@cmu.edu', 'Y6OUnZZ', 'Lory Relf', '5175 Everett Parkway', '486-518-3695', 3);
INSERT INTO user (email, password, name, address, phone, role_id) 
VALUES ('ayearne9@sciencedirect.com', '79XjOfyK', 'Amara Yearne', '07 Coolidge Drive', '958-915-9001', 3);


INSERT INTO project (name, description, start_date, end_date, owner) 
VALUES ('Capreolus capreolus', 'Drainage of Right Lower Lung Lobe, Percutaneous Approach', '2022-03-03', '2021-06-20', 1);
INSERT INTO project (name, description, start_date, end_date, owner) 
VALUES ('Cyrtodactylus louisiadensis', 'Replacement of Right Tibia with Synth Sub, Open Approach', '2021-08-01', '2022-02-27', 1);
INSERT INTO project (name, description, start_date, end_date, owner) 
VALUES ('Propithecus verreauxi', 'Release Right Finger Phalangeal Joint, Perc Endo Approach', '2021-05-02', '2021-11-29', 1);
INSERT INTO project (name, description, start_date, end_date, owner) 
VALUES ('Ammospermophilus nelsoni', 'Drainage of R Ankle Bursa/Lig, Open Approach, Diagn', '2021-09-21', '2021-06-12', 1);
INSERT INTO project (name, description, start_date, end_date, owner) 
VALUES ('Anser anser', 'Drainage of Left Fallopian Tube, Perc Endo Approach, Diagn', '2021-09-27', '2021-08-03', 1);
INSERT INTO project (name, description, start_date, end_date, owner) 
VALUES ('Ninox superciliaris', 'Removal of Infusion Device from GU Tract, Perc Approach', '2021-11-18', '2021-05-17', 1);
INSERT INTO project (name, description, start_date, end_date, owner) 
VALUES ('Spermophilus lateralis', 'Removal of Ext Fix from L Tarsal Jt, Open Approach', '2022-01-08', '2021-07-10', 1);
INSERT INTO project (name, description, start_date, end_date, owner) 
VALUES ('Phaethon aethereus', 'Supplement L Temporomandib Jt with Nonaut Sub, Perc Approach', '2021-04-30', '2022-02-19', 1);
INSERT INTO project (name, description, start_date, end_date, owner) 
VALUES ('Chlamydosaurus kingii', 'Drainage of Vulva, External Approach, Diagnostic', '2022-03-14', '2021-12-08', 1);
INSERT INTO project (name, description, start_date, end_date, owner) 
VALUES ('Ourebia ourebi', 'Division of Post Neck Subcu/Fascia, Open Approach', '2021-06-26', '2021-10-21', 1);


INSERT INTO status(name) 
VALUES ('Finish');
INSERT INTO status(name) 
VALUES ('Unfinish');


INSERT INTO task (name, description, start_date, end_date, project_id, status_id) 
VALUES ('Ronstring', 'Drainage of R Up Leg Subcu/Fascia, Perc Approach, Diagn', '2021-04-19', '2021-05-11', 9, 1);
INSERT INTO task (name, description, start_date, end_date, project_id, status_id) 
VALUES ('Voltsillam', 'Vocation Activ/Commun Assessment', '2022-02-11', '2021-07-16', 8, 2);
INSERT INTO task (name, description, start_date, end_date, project_id, status_id) 
VALUES ('Bitwolf', 'Drainage of Left Eustachian Tube, Endo, Diagn', '2021-05-02', '2021-07-27', 3, 1);
INSERT INTO task (name, description, start_date, end_date, project_id, status_id) 
VALUES ('It', 'Transfer Vagus Nerve to Hypoglossal Nerve, Open Approach', '2021-07-08', '2021-09-16', 10, 2);
INSERT INTO task (name, description, start_date, end_date, project_id, status_id) 
VALUES ('It', 'Excision of Right Hand Tendon, Open Approach, Diagnostic', '2021-04-29', '2021-09-14', 7, 2);
INSERT INTO task (name, description, start_date, end_date, project_id, status_id) 
VALUES ('Flowdesk', 'Excision of Left Tibia, Percutaneous Approach', '2022-01-28', '2021-09-22', 8, 1);
INSERT INTO task (name, description, start_date, end_date, project_id, status_id)
VALUES ('Tres-Zap', 'Reposition Pudendal Nerve, Percutaneous Approach', '2022-02-14', '2021-12-16', 9, 1);
INSERT INTO task (name, description, start_date, end_date, project_id, status_id) 
VALUES ('Keylex', 'Dilate Splenic Art, Bifurc, w 4 Drug-elut, Perc', '2021-07-26', '2021-11-03', 3, 1);
INSERT INTO task (name, description, start_date, end_date, project_id, status_id) 
VALUES ('Sub-Ex', 'Drainage of Right Epididymis, Open Approach', '2022-01-30', '2021-10-07', 1, 2);
INSERT INTO task (name, description, start_date, end_date, project_id, status_id) 
VALUES ('Job', 'Revise of Radioact Elem in Vagina & Cul-de-sac, Via Opening', '2021-08-18', '2021-12-16', 10, 2);
