/* advisor table */
INSERT INTO advisor (`advisorID`, `create_date`, `email`, `password`, `username`, `canal`)
VALUES (1,'2019-09-16','eric.mander@gmail.com','password','Eric','EC');


INSERT INTO advisor (`advisorID`, `create_date`, `email`, `password`, `username`, `canal`)
VALUES (2,'2019-09-16','Arnaud.elot@gmail.com','password','Arnaud','FACE');

/* address table */
INSERT INTO address (`addressid`, `active`, `country`, `state`, `street`, `zip`, `number`, `city`, `type`) 
VALUES ('1',true,'FRANCE','Ile-de-France','street','75', '17', 'Paris', 'PRINCIPAL');

INSERT INTO address (`addressid`, `active`, `country`, `state`, `street`, `zip`, `number`, `city`, `type`) 
VALUES ('2',true,'FRANCE','Ile-de-France','test2','75', '2', 'Lyon', 'PRINCIPAL');


/* user table */
INSERT INTO subscriber
VALUES ('1','2019-09-16','olivia.caramella@gmail.com','caramella','PASSWORD', 'olivia','1','1');

INSERT INTO subscriber
VALUES ('2','2019-09-10','advisor@gmail.com','advisor','PASSWORD','advisor','1', '2');


/* contract table */
INSERT INTO contract(`id_contract`, `create_date`, `name`, `id_subscriber`) 
VALUES ('1','2019-09-16','contrat tv','2');

INSERT INTO contract(`id_contract`, `create_date`, `name`, `id_subscriber`) 
VALUES ('2','2019-09-16','contrat canal+','2');

INSERT INTO contract(`id_contract`, `create_date`, `name`, `id_subscriber`) 
VALUES ('3','2019-09-16','contrat Football Club','2');