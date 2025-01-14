CREATE DATABASE VETERINARIA3

USE VETERINARIA3

CREATE TABLE TB_EMPRESA(
	COD_EMPRESA CHAR(5) PRIMARY KEY NOT NULL,
	NOM_EMPRESA VARCHAR(45) NOT NULL,
	DIREC_EMPRESA VARCHAR(60) NOT NULL,
	NUMCEL_EMPRESA CHAR(9) NOT NULL,
	PAGWEB_EMPRESA VARCHAR(50) NOT NULL
)
INSERT INTO TB_EMPRESA VALUES('EE01','veterinaria COLITAS FELICES','ICA-CAMINO A CASUARINAS:CONFRATERNIDAD B-2','941112191','www.colitasFelices.com')
SELECT*FROM TB_EMPRESA

CREATE TABLE TB_PLANILLA(
	COD_EMPRESA CHAR(5) REFERENCES TB_EMPRESA NOT NULL,
	COD_PLANILLA CHAR(5) PRIMARY KEY NOT NULL,
)


INSERT INTO TB_PLANILLA VALUES('EE01','PL01')
SELECT*FROM TB_PLANILLA


--esencial 
CREATE TABLE TB_EMPLEADO(
	DNI_EMPLEADO CHAR(8) PRIMARY KEY NOT NULL,
	NOM_EMPLEADO VARCHAR(40) NOT NULL,
	APEPA_EMPLEADO VARCHAR(40) NOT NULL,
	APEMA_EMPLEADO VARCHAR(40) NOT NULL,
	NUMCEL_EMPLEADO CHAR(9) NOT NULL,
	EMAIL_EMPLEADO VARCHAR(60) NOT NULL,
	DIREC_EMPLEADO VARCHAR(45) NOT NULL,
	SUELDO_EMPLEADO MONEY NOT NULL
)

INSERT INTO TB_EMPLEADO VALUES('12343234','Mar','Nu�ez','Cabrero','977795678','mar22@gmail.com','Av Grau 148, Ica','1200')
INSERT INTO TB_EMPLEADO VALUES('42113234','Jose','Tello','Acosta','983423454','joseacostell0@gmail.com','Av Ayabaca, Ica','1500')
INSERT INTO TB_EMPLEADO VALUES('82343235','Matias','Aguilar','Gonzales','922235678','aguilargonzales@gmail.com','Av Tarapaca, Lima','1600')	
INSERT INTO TB_EMPLEADO VALUES('85748543','Diana','Navarro','Satien','913335678','navarrosatiendian4@gmail.com','Av J.J Elias, Ica','1350')
INSERT INTO TB_EMPLEADO VALUES('23464543','Marcos','Alcaraz','Curiel','912345778','alcarazcurielmar@gmail.com','Av Amancaes, Lima','1430')
INSERT INTO TB_EMPLEADO VALUES('44756345','Mauricio','Alva','Cabrero','911115678','mauricioalvacabrero@gmail.com','Av Cutervo, Ica','1500')
INSERT INTO TB_EMPLEADO VALUES('74595867','Sol','Parra','Alvarado','912235678','Av Parque B, Lima','solsalvara2@gmail.com','1650')
INSERT INTO TB_EMPLEADO VALUES('70958695','Esteban','Nu�ez','Negrete','910232678','estebannegret3@gmail.com','Av de los Proceres, Lima','1400')
INSERT INTO TB_EMPLEADO VALUES('86758695','Heber','Fauser','Martin','900115678','hebermartinfauser2@gmail.com','Av Los nogales, Lima','1800')
INSERT INTO TB_EMPLEADO VALUES('10343345','Jhon','Llanos','Sandoval','915410678','llanosjhonsandoval@gmail.com','Av Cutervo, Ica','1200')
INSERT INTO TB_EMPLEADO VALUES('56473845','Juan','Cardiel','Calderon','945615673','jccalderon@gmail.com','Av Nikolas de Pierola, Lima','1500')
INSERT INTO TB_EMPLEADO VALUES('96857684','Bruno','Bernal','Ortiz','986110073','brunberortiz@gmail.com','Av San Martin, Ica','1300')
INSERT INTO TB_EMPLEADO VALUES('12343456','Ana','Frenk','Furuya','951215600','anafrenfuruya@gmail.com','Av la victoria, ica','1450')
INSERT INTO TB_EMPLEADO VALUES('49583745','Jose','Pe�a','Ramos','961199673','joseramosp@gmail.com','Av Nikolas de Pierola, Lima','1600')
SELECT*FROM TB_EMPLEADO



CREATE TABLE TB_DETALLE_PLANILLA(
	COD_PLANILLA CHAR(5) REFERENCES TB_PLANILLA NOT NULL,
	DNI_EMPLEADO CHAR(8) REFERENCES TB_EMPLEADO NOT NULL,
	FECHA_INGRESO VARCHAR(30) NOT NULL,
	HORAS_TRABAJO INT NOT NULL, 
	SUELDO MONEY NOT NULL,
	APORTES MONEY NOT NULL
)

INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','12343234','12/11/2020',8,150,100)
INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','42113234','13/12/2020',10,150,160)
INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','82343235','10/08/2020',9,177.8,165)
INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','85748543','12/11/2021',8,168.75,120)
INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','23464543','05/11/2021',8,178.75,130)
INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','74595867','12/11/2021',10,183.33,120)
INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','70958695','02/08/2021',8,175,110)
INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','86758695','23/08/2021',10,180,150)
INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','10343345','08/09/2021',8,150,110)
INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','56473845','02/10/2021',8,187.5,120)
INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','96857684','02/11/2021',9,144.44,120)
INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','12343456','11/11/2021',8,181.25,100)
INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','49583745','17/08/2021',8,200,100)
INSERT INTO TB_DETALLE_PLANILLA VALUES('PL01','44756345','12/11/2021',8,150,100)

SELECT*FROM TB_DETALLE_PLANILLA



--ESTA TABLA SE INGRESA POR EL PROGRAMA ELABORADO EN JAVA
CREATE TABLE TB_CLIENTE(
	DNI_CLIENTE CHAR(8) PRIMARY KEY NOT NULL,
	NOM_CLIENTE VARCHAR(45) NOT NULL,
	APEPA_CLIENTE VARCHAR(40) NOT NULL,
	APEMA_CLIENTE VARCHAR(40) NOT NULL,
	NUMCEL_CLIENTE CHAR(9) NOT NULL,
	EMAIL_CLIENTE VARCHAR(60) NOT NULL,
	DIREC_CLIENTE VARCHAR(45) NOT NULL,
)
SELECT*FROM TB_CLIENTE WHERE DNI_CLIENTE='12345674'

INSERT INTO TB_CLIENTE VALUES('84756374','DANIEL','GUTIERREZ','CCALLASACA','985766475','DA@GMAIL.COM','ICA')
SELECT*FROM TB_CLIENTE

--ESTA TABLA SE INGRESA POR EL PROGRAMA ELABORADO EN JAVA
CREATE TABLE TB_MASCOTA(
	COD_MASCOTA INT IDENTITY(1,1) PRIMARY KEY,
	NOM_MASCOTA VARCHAR(30) NOT NULL,
	DNI_CLIENTE CHAR(8) REFERENCES TB_CLIENTE NOT NULL,
	COLOR VARCHAR(20) NOT NULL,
	RAZA VARCHAR(25) NOT NULL,
	ESTADO VARCHAR(40) NOT NULL
)
DBCC CHECKIDENT (TB_MASCOTA, RESEED, 0)
INSERT INTO TB_MASCOTA VALUES('BOLTA','84756374','NEGRO CON CANELA','Pastor alem�n','Presenta complicaciones para correr')
INSERT INTO TB_MASCOTA VALUES('COR','84756374','NEGRO CON CANELA','Pastor alem�n','CORTE')
SELECT*FROM TB_MASCOTA



--IMPORTANTES: SOLO TENDREMOS 3 TIPOS DE AREAS EN LA VETERINARIA
CREATE TABLE TB_AREA(
	COD_AREA CHAR(5) PRIMARY KEY NOT NULL,
	NOM_AREA VARCHAR(30) NOT NULL,
	NUM_EMPLEADOS INT NOT NULL
)

INSERT INTO TB_AREA VALUES('AR01','AREA MEDICA',11)
INSERT INTO TB_AREA VALUES('AR02','AREA DE ATENCION AL CLIENTE',3)
INSERT INTO TB_AREA VALUES('AR03','AREA	ESTANDAR',7)
SELECT*FROM TB_AREA


--LA VETERINARIA TIENE LOS SIGUIENTES SERVICIOS A OFRECER
CREATE TABLE TB_SERVICIO(
	COD_SERVICIO CHAR(5) PRIMARY KEY NOT NULL,
	NOM_SERVICIO VARCHAR(40) NOT NULL
)

INSERT INTO TB_SERVICIO VALUES('S01','consultas y tratamientos') --servicio medico
INSERT INTO TB_SERVICIO VALUES('S02','cirugias') --servicio medico
INSERT INTO TB_SERVICIO VALUES('S03','ba�os medicos')--servicio estandar
INSERT INTO TB_SERVICIO VALUES('S04','vacuna')--servicio medico
INSERT INTO TB_SERVICIO VALUES('S05','emergencia')--servicio medico
INSERT INTO TB_SERVICIO VALUES('S06','peluqueria canina')--servicio estandar
INSERT INTO TB_SERVICIO VALUES('S07','laboratorio')--servicio medico
INSERT INTO TB_SERVICIO VALUES('S08','ecogra. rayos x')--servicio medico
INSERT INTO TB_SERVICIO VALUES('S09','hospedaje')--servicio estandar
INSERT INTO TB_SERVICIO VALUES('S10','ventas de accesorios')--servicio estandar
INSERT INTO TB_SERVICIO VALUES('S11','atencion cliente')--servicio estandar
SELECT*FROM TB_SERVICIO

--AQUI SE ESPECIFICA EL A LOS EMPLEADOS CON SUS CORRESPONDIENTES SERVICIOS EN BASE AL AREA QUE PERTENECEN 
CREATE TABLE TB_DETALLE_AREA(
	COD_AREA CHAR(5) REFERENCES TB_AREA NOT NULL,
	DNI_EMPLEADO CHAR(8) REFERENCES TB_EMPLEADO NOT NULL,
	COD_SERVICIO CHAR(5) REFERENCES TB_SERVICIO NOT NULL
)
											--LOS EMPLEADOS NO TIENEN QUE REPETIRSE EN UN MISMO AREA

/*
INSERT INTO TB_SERVICIO VALUES('S01','consultas y tratamientos') --servicio medico
INSERT INTO TB_SERVICIO VALUES('S02','cirugias') --servicio medico
INSERT INTO TB_SERVICIO VALUES('S04','vacuna')--servicio medico
INSERT INTO TB_SERVICIO VALUES('S05','emergencia')--servicio medico
INSERT INTO TB_SERVICIO VALUES('S07','laboratorio')--servicio medico
INSERT INTO TB_SERVICIO VALUES('S08','ecogra. rayos x')--servicio medico
INSERT INTO TB_SERVICIO VALUES('S03','ba�os medicos')--servicio medico
*/
--PARA AREA DE MEDICA SOLO SERVICIOS MEDICOS
INSERT INTO TB_DETALLE_AREA VALUES('AR01','12343234','S01')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','42113234','S05')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','85748543','S04')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','74595867','S07')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','96857684','S08')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','49583745','S03')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','23464543','S01')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','56473845','S03')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','10343345','S02')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','86758695','S08')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','44756345','S08')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','49583745','S07')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','96857684','S03')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','86758695','S03')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','44756345','S01')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','85748543','S02')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','74595867','S02')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','96857684','S02')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','49583745','S02')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','23464543','S05')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','56473845','S05')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','44756345','S04')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','49583745','S04')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','96857684','S04')
INSERT INTO TB_DETALLE_AREA VALUES('AR01','86758695','S04')


SELECT*FROM TB_DETALLE_AREA WHERE COD_AREA ='AR01' AND DNI_EMPLEADO = '44756345'

SELECT*FROM TB_DETALLE_AREA WHERE DNI_EMPLEADO='44756345' AND COD_SERVICIO='S02'


--INSERT INTO TB_SERVICIO VALUES('S11','atencion cliente')--servicio estandar
--PARA AREA DE ATENCION AL CLIENTE
INSERT INTO TB_DETALLE_AREA VALUES('AR02','49583745','S11')
INSERT INTO TB_DETALLE_AREA VALUES('AR02','44756345','S11')
INSERT INTO TB_DETALLE_AREA VALUES('AR02','82343235','S11')
SELECT*FROM TB_DETALLE_AREA WHERE COD_AREA ='AR02'


/*
INSERT INTO TB_SERVICIO VALUES('S10','ventas de accesorios')--servicio estandar
INSERT INTO TB_SERVICIO VALUES('S06','peluqueria canina')--servicio estandar
INSERT INTO TB_SERVICIO VALUES('S09','hospedaje')--servicio estandar
*/
--PARA EL AREA ESTANDAR DONDE SE DA SERVICIOS DE PELUQUERIA, ROPAS, COMIDA, ETC.

INSERT INTO TB_DETALLE_AREA VALUES('AR03','42113234','S10')
INSERT INTO TB_DETALLE_AREA VALUES('AR03','70958695','S06')
INSERT INTO TB_DETALLE_AREA VALUES('AR03','85748543','S06')
INSERT INTO TB_DETALLE_AREA VALUES('AR03','96857684','S10')
INSERT INTO TB_DETALLE_AREA VALUES('AR03','74595867','S06')
INSERT INTO TB_DETALLE_AREA VALUES('AR03','44756345','S06')
INSERT INTO TB_DETALLE_AREA VALUES('AR03','82343235','S06')
INSERT INTO TB_DETALLE_AREA VALUES('AR03','96857684','S09')
INSERT INTO TB_DETALLE_AREA VALUES('AR03','12343234','S09')
INSERT INTO TB_DETALLE_AREA VALUES('AR03','85748543','S09')
INSERT INTO TB_DETALLE_AREA VALUES('AR03','74595867','S09')
INSERT INTO TB_DETALLE_AREA VALUES('AR03','42113234','S09')
SELECT*FROM TB_DETALLE_AREA WHERE COD_AREA ='AR03'


--TENDREMOS DOS ALMACENES 1RO QUE SOLO GUARDE COSAS PARA USO MEDICO Y 2DO EL OTRO PARA ROPAS, CHAMPOOS, COMIDAS, ETC.
CREATE TABLE TB_ALMACEN(
	COD_ALMACEN CHAR(5) PRIMARY KEY NOT NULL,
	COD_AREA CHAR(5) REFERENCES TB_AREA NOT NULL,
)

INSERT INTO TB_ALMACEN VALUES('AL01','AR01')--PERTENECE AL AREA 1: DE MEDICINA, POR ENDE, LLEVA PRODUCTOS DELICADOS.
INSERT INTO TB_ALMACEN VALUES('AL02','AR03')--PERTENECE AL AREA 3: ESTANDAR, LLEVA ROPAS, CHAMPOOS, ETC.
SELECT * FROM TB_ALMACEN


CREATE TABLE TB_DETALLE_ALMACEN(
	COD_ALMACEN CHAR(5) REFERENCES TB_ALMACEN NOT NULL,
	NOM_ALMACEN VARCHAR(40) NOT NULL,
	ANCHO_ALMACEN DECIMAL NOT NULL,
	LARGO_ALMACEN DECIMAL NOT NULL,
	ALTO_ALMACEN DECIMAL NOT NULL,
	ANTIGUEDAD_ALMACEN VARCHAR(15) NOT NULL,
	ESTADO_ALMACEN VARCHAR(40) NOT NULL
)

INSERT INTO TB_DETALLE_ALMACEN VALUES('AL01','ALMEDI',10,10,7,'3 A�OS','BUEN ESTA EN INFRAESTRUCTURA')
INSERT INTO TB_DETALLE_ALMACEN VALUES('AL02','ALESTA',8.5,9.5,6,'1 A�OS','PERFECTO ESTADO')
SELECT*FROM TB_DETALLE_ALMACEN



CREATE TABLE TB_PROVEEDOR (
	COD_PROVE CHAR(5) NOT  NULL PRIMARY KEY,
	NOM_PROVE VARCHAR(40) NOT NULL,
	NUMCEL_PROVE CHAR(9) NOT NULL,
	EMAIL_PROVE VARCHAR(40) NOT NULL,
	SITIO_WEBPRO VARCHAR(60) NOT NULL
)
INSERT INTO TB_PROVEEDOR VALUES('PVE01','SANTOS','963258741','ssantoss@gamil.com','www.provee.santos.com.pe')--ROPA PARA PERRO
INSERT INTO TB_PROVEEDOR VALUES('PVE02','RESOURCE MEDICAMENTOS','987234681','resoucemedicamentos@gamil.com','www.resource.medi.net')--MEDICAMENTOS PARA PERRO
INSERT INTO TB_PROVEEDOR VALUES('PVE03','DISTRIBUCION GARCILLEJA','922251740','distrigarcilleja@gamil.com','www.distribucion.garcilleja.net')--COMIDA DE PERROS
INSERT INTO TB_PROVEEDOR VALUES('PVE04','NUPI3','931258440','nupi3@gamil.com','www.nupi3.com.pe')--COMIDA DE PERROS
INSERT INTO TB_PROVEEDOR VALUES('PVE05','CHEF PET','913218741','chefpet@gamil.com','www.chef.pet.com.pe')--COMIDA DE PERROS
INSERT INTO TB_PROVEEDOR VALUES('PVE06','GAHERPROGA','900266741','gaherprogra@gamil.com','www.gaherproga.com.pe')--PRODUCTOS PARA ELIMINACION DE GARRAPATAS,PULGAS,ETC
INSERT INTO TB_PROVEEDOR VALUES('PVE07','MASCOTAS MO�INO','913258000','masmo�ino@gamil.com','www.mo�ino.net')--ROPA(ACCESORIOS PARA PERRO)
INSERT INTO TB_PROVEEDOR VALUES('PVE08','SANIDAD ANIMAL','911218740','saniddanimal@gamil.com','www.sanidad.animal.com.pe')--MEDICAMENTOS
INSERT INTO TB_PROVEEDOR VALUES('PVE09','BATIS MEDICAL','903250731','batismedical@gamil.com','www.batis.medical.br')--MEDICAMENTOS PARA PERRO
INSERT INTO TB_PROVEEDOR VALUES('PVE10','B.I.D.A NATURE	','963338731','bidanature@gamil.com','www.bidanature.us.net')--MEDICAMENTOS PARA PERRO
INSERT INTO TB_PROVEEDOR VALUES('PVE11','MASUKOTTA DISTRIBUCIONES','973208731','masukotta@gamil.com','www.masukotta.net')--COMIDA PARA PERROS
SELECT*FROM TB_PROVEEDOR



CREATE TABLE TB_PRODUCTO(
	COD_PRODUCTO CHAR(5) PRIMARY KEY NOT NULL,
	COD_PROVE CHAR(5) REFERENCES TB_PROVEEDOR NOT NULL,
	COD_ALMACEN CHAR(5) REFERENCES TB_ALMACEN NOT NULL,
	NOM_PRODUCTO VARCHAR(35) NOT NULL,
	CANTIDAD_PRODUCTO INT NOT NULL,
	PRECIOUNI_PRODUCTO MONEY NOT NULL
)
INSERT INTO TB_PRODUCTO VALUES('PD01','PVE04','AL02','POLLICEREAL',65,5) --MAS DATA
INSERT INTO TB_PRODUCTO VALUES('PD02','PVE09','AL01','BRAVECTO',55,175)
INSERT INTO TB_PRODUCTO VALUES('PD03','PVE09','AL01','SIMPARICA',20,225)
INSERT INTO TB_PRODUCTO VALUES('PD04','PVE02','AL01','NEXGARD',35,155)
INSERT INTO TB_PRODUCTO VALUES('PD05','PVE10','AL01','TUSIVET',120,75)
INSERT INTO TB_PRODUCTO VALUES('PD06','PVE11','AL02','PREVICOX',57,25)
INSERT INTO TB_PRODUCTO VALUES('PD07','PVE07','AL02','CAMISETA PARA PERRO DE HAWAI',80,30)
INSERT INTO TB_PRODUCTO VALUES('PD08','PVE09','AL01','HEPATOIPET',14,10)
INSERT INTO TB_PRODUCTO VALUES('PD09','PVE10','AL01','PRACTI-CAN',19,25)
INSERT INTO TB_PRODUCTO VALUES('PD10','PVE03','AL02','PETCARE',44,13)
INSERT INTO TB_PRODUCTO VALUES('PD11','PVE10','AL01','PRACTI-CAN',19,25)
INSERT INTO TB_PRODUCTO VALUES('PD12','PVE07','AL02','COLCHONETA',44,13)
INSERT INTO TB_PRODUCTO VALUES('PD13','PVE06','AL02','RASS',30,50)
INSERT INTO TB_PRODUCTO VALUES('PD14','PVE07','AL02','POLERA ANIMAL',20,25)
INSERT INTO TB_PRODUCTO VALUES('PD15','PVE08','AL01','FRIPET',50,30)
INSERT INTO TB_PRODUCTO VALUES('PD16','PVE07','AL02','CASACA GUAU GUAU',10,38)
INSERT INTO TB_PRODUCTO VALUES('PD17','PVE03','AL02','CANCOM',44,120)
INSERT INTO TB_PRODUCTO VALUES('PD18','PVE07','AL02','BANDANA',26,15)
INSERT INTO TB_PRODUCTO VALUES('PD19','PVE06','AL01','ANTIPARASITARIO FRIPETS',45,20)
INSERT INTO TB_PRODUCTO VALUES('PD20','PVE06','AL02','ANTIPULGA SIMPARICA',38,5)
SELECT*FROM TB_PRODUCTO WHERE COD_ALMACEN = 'AL02'




CREATE TABLE TB_DETALLE_PRODUCTO(
	COD_PRODUCTO CHAR(5) REFERENCES TB_PRODUCTO NOT NULL,
	FECHA_ELABORACION VARCHAR(30) NOT NULL,
	FECHA_VENCIMINETO VARCHAR(30) NOT NULL,
	LUGAR_ELABORACION VARCHAR(40) NOT NULL
)
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD01','12/12/2020','11/12/2024','HECHO EN PERU') --DETALLE DE LA DATA
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD02','12/03/2021','22/03/2023','HECHO EN BRASIL')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD03','20/04/2022','02/13/2023','HECHO EN BRASIL')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD04','20/04/2021','12/25/2026','HECHO EN EE.UU')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD05','18/06/2021','03/08/2023','HECHO EN COLOMBIA')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD06','08/04/2021','11/05/2024','HECHO EN EE.UU')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD07','10/12/2021','--/--/----','HECHO EN COLOMBIA')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD08','01/10/2021','12/23/2023','HECHO EN BRASIL')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD09','20/01/2022','25/13/2025','HECHO EN JAPAN')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD10','14/03/2021','02/03/2024','HECHO EN PER�')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD11','01/10/2022','12/23/2023','HECHO EN BRASIL')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD12','20/01/2022','--/--/----','HECHO EN PER�')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD13','16/03/2022','02/03/2024','HECHO EN PER�')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD14','14/10/2022','--/--/----','HECHO EN BRASIL')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD15','20/01/2022','25/13/2025','HECHO EN JAPAN')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD16','09/02/2022','--/--/----','HECHO EN NUEVA ZELANDA')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD17','19/02/2022','18/01/2025','HECHO EN MEXICO')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD18','22/04/2022','--/--/----','HECHO EN EE.UU')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD19','29/02/2022','28/04/2023','HECHO EN MEXICO')
INSERT INTO TB_DETALLE_PRODUCTO VALUES('PD20','02/12/2022','12/25/2026','HECHO EN JAPAN')
SELECT*FROM TB_DETALLE_PRODUCTO


--ESTO TAMBIEN SE INGRESA EN EL PROGRAMA JAVA

CREATE TABLE TB_SOLICITUD(
	COD_SOLICITUD INT IDENTITY(1,1) PRIMARY KEY,
	DNI_EMPLEADO CHAR(8) REFERENCES TB_EMPLEADO NOT NULL,
	DNI_CLIENTE CHAR(8) REFERENCES TB_CLIENTE NOT NULL,
	COD_MASCOTA INT REFERENCES TB_MASCOTA NOT NULL,
	FECHA_SOLICITUD VARCHAR(30) NOT NULL,
	COD_SERVICIO CHAR(5) REFERENCES TB_SERVICIO NOT NULL
)
DBCC CHECKIDENT (TB_mascota, RESEED, 4)

SELECT E.DNI_EMPLEADO,E.NOM_EMPLEADO,E.NUMCEL_EMPLEADO,E.EMAIL_EMPLEADO,SE.COD_SERVICIO,SE.NOM_SERVICIO 
                    FROM TB_EMPLEADO E INNER JOIN TB_DETALLE_AREA DA ON E.DNI_EMPLEADO = DA.DNI_EMPLEADO
                   INNER JOIN TB_SERVICIO SE ON SE.COD_SERVICIO = DA.COD_SERVICIO
                   WHERE E.DNI_EMPLEADO='44756345'
				    


INSERT INTO TB_SOLICITUD VALUES('44756345','84756374','1','20:03','S11')

SELECT COD_MASCOTA FROM TB_MASCOTA WHERE DNI_CLIENTE='84756374' AND NOM_MASCOTA='BOLTA'

SELECT*FROM TB_MASCOTA WHERE DNI_CLIENTE='22222222' AND NOM_MASCOTA='d'

	


INSERT INTO TB_SOLICITUD VALUES('44756345','84756374','2','20:05','S11')

SELECT * FROM TB_CLIENTE 
SELECT*FROM TB_MASCOTA 
SELECT*FROM TB_SOLICITUD

delete from TB_CLIENTE where DNI_CLIENTE='34543456'


SELECT S.COD_SOLICITUD,S.FECHA_SOLICITUD,C.NOM_CLIENTE, C.DNI_CLIENTE,
       C.NUMCEL_CLIENTE,C.DIREC_CLIENTE,S.COD_SERVICIO, SE.NOM_SERVICIO,
       E.NOM_EMPLEADO,E.DNI_EMPLEADO,E.NUMCEL_EMPLEADO,M.COD_MASCOTA,M.NOM_MASCOTA 
	   FROM TB_CLIENTE C INNER JOIN TB_SOLICITUD S ON S.DNI_CLIENTE = C.DNI_CLIENTE
                    	 INNER JOIN TB_EMPLEADO E ON E.DNI_EMPLEADO =S.DNI_EMPLEADO
                         INNER JOIN TB_SERVICIO SE ON SE.COD_SERVICIO = S.COD_SERVICIO
						 INNER JOIN TB_MASCOTA M ON M.COD_MASCOTA = S.COD_MASCOTA


UPDATE TB_CLIENTE SET NOM_CLIENTE='ACTUALIZADO',APEMA_CLIENTE='AZCUALIZADO',APEPA_CLIENTE='Nu�ez',EMAIL_CLIENTE='AZTUALIZADO22@gmail.com',NUMCEL_CLIENTE='977795678',DIREC_CLIENTE='ICA' 
		WHERE DNI_CLIENTE='23456789'
UPDATE TB_MASCOTA SET NOM_MASCOTA='MASCOTA ACTUALIZADA',RAZA='A',COLOR='A',ESTADO='AA'
		WHERE COD_MASCOTA = '2'
UPDATE TB_SOLICITUD SET DNI_EMPLEADO='56473845',COD_SERVICIO='S03',FECHA_SOLICITUD='22:50' WHERE COD_SOLICITUD='2'

	/*
	CREATE TABLE TB_SOLICITUD(
	COD_SOLICITUD INT IDENTITY(1,1) PRIMARY KEY,
	DNI_EMPLEADO CHAR(8) REFERENCES TB_EMPLEADO NOT NULL,
	DNI_CLIENTE CHAR(8) REFERENCES TB_CLIENTE NOT NULL,
	COD_MASCOTA INT REFERENCES TB_MASCOTA NOT NULL,
	FECHA_SOLICITUD VARCHAR(30) NOT NULL,
	COD_SERVICIO CHAR(5) REFERENCES TB_SERVICIO NOT NULL
)
		*/



DELETE FROM TB_MASCOTA WHERE COD_MASCOTA =''



CREATE TABLE TB_DETALLE_SOLICITUD(
	COD_SOLICITUD INT REFERENCES TB_SOLICITUD NOT NULL,
	FECHA_REVISADA VARCHAR(30) NOT NULL,
	DESCRIPCION VARCHAR(35) NOT NULL,
	FECHA_ATENDIDA VARCHAR(30) NOT NULL
)



--NO TOCAREMOS
CREATE TABLE TB_CONTRATO(
	COD_CONTRATO INT IDENTITY(1,1) PRIMARY KEY,
	COD_SOLICITUD INT REFERENCES TB_SOLICITUD NOT NULL,
	FECHA_CONTRATO VARCHAR(30) NOT NULL
)

CREATE TABLE TB_DETALLE_CONTRATO(
	COD_CONTRATO INT REFERENCES TB_CONTRATO NOT NULL,
	COD_PRODUCTO CHAR(5) REFERENCES TB_PRODUCTO NOT NULL,
	COD_SERVICIO CHAR(5) REFERENCES TB_SERVICIO NOT NULL,
	CANTIDAD_COMPRA_PRODUC INT NULL,
	PAGO_BRUTO MONEY NOT NULL,
	IGV MONEY NOT NULL,
	PAGO_NETO MONEY NOT NULL
)
-------


SELECT*FROM TB_ALMACEN

SELECT*FROM TB_PRODUCTO

--PROCEDIMIENTO ALMACENADO PARA RESTAR            --TODO PARAMETRO SE INICIA CON EL SIMBOLO @
CREATE PROCEDURE SP_RestarExistencia
@CodProdR as CHAR(5), 										
@CantidadR as INT
AS
UPDATE TB_PRODUCTO SET CANTIDAD_PRODUCTO=CANTIDAD_PRODUCTO-@CantidadR WHERE COD_PRODUCTO=@CodProdR

EXEC SP_RestarExistencia 'PD20',1


--PROCEDIMIENTO ALMACENADO PARA SUMAR

CREATE PROCEDURE SP_SumarExistencia
@CodProdS as CHAR(5), 										
@CantidadS as INT
AS
UPDATE TB_PRODUCTO SET CANTIDAD_PRODUCTO=CANTIDAD_PRODUCTO+@CantidadS WHERE COD_PRODUCTO=@CodProdS


EXEC SP_SumarExistencia 'PD20',1

SELECT*FROM TB_DETALLE_PRODUCTO
SELECT*FROM TB_ALMACEN
SELECT*FROM TB_AREA

--CONSULTA INICIAL
SELECT P.COD_PRODUCTO,P.COD_PROVE,P.COD_ALMACEN,P.NOM_PRODUCTO,P.CANTIDAD_PRODUCTO,P.PRECIOUNI_PRODUCTO
	FROM TB_PRODUCTO P INNER JOIN TB_DETALLE_PRODUCTO DP ON P.COD_PRODUCTO = DP.COD_PRODUCTO 


--CONSULTA EN BASE A PRODUCTO DE USO ESTANDAR
SELECT P.COD_PRODUCTO,P.COD_PROVE,P.COD_ALMACEN,P.NOM_PRODUCTO,P.CANTIDAD_PRODUCTO,P.PRECIOUNI_PRODUCTO
	FROM TB_PRODUCTO P INNER JOIN TB_DETALLE_PRODUCTO DP ON P.COD_PRODUCTO = DP.COD_PRODUCTO WHERE COD_ALMACEN='AL02'


--CONSULTA EN BASE A PRODUCTOS DE USO MEDICINAL
SELECT P.COD_PRODUCTO,P.COD_PROVE,P.COD_ALMACEN,P.NOM_PRODUCTO,P.CANTIDAD_PRODUCTO,P.PRECIOUNI_PRODUCTO
	FROM TB_PRODUCTO P INNER JOIN TB_DETALLE_PRODUCTO DP ON P.COD_PRODUCTO = DP.COD_PRODUCTO WHERE COD_ALMACEN='AL01'






--PARA TENER UNA INFORMACION DEL PRODUCTO CON MUCHO MAS DETALLE
SELECT*FROM TB_PRODUCTO P INNER JOIN TB_DETALLE_PRODUCTO DP ON P.COD_PRODUCTO=DP.COD_PRODUCTO
							INNER JOIN TB_PROVEEDOR PRO  ON PRO.COD_PROVE=P.COD_PROVE
							INNER JOIN TB_ALMACEN A ON A.COD_ALMACEN = P.COD_ALMACEN
							INNER JOIN TB_AREA AR ON AR.COD_AREA = A.COD_AREA
							WHERE P.COD_PRODUCTO = 'PD04'


SELECT  P.COD_PRODUCTO,P.NOM_PRODUCTO, P.PRECIOUNI_PRODUCTO, DP.FECHA_ELABORACION,
		DP.FECHA_VENCIMINETO, DP.LUGAR_ELABORACION,A.COD_ALMACEN,PRO.COD_PROVE,PRO.NOM_PROVE,PRO.EMAIL_PROVE,PRO.NUMCEL_PROVE,
		AR.NOM_AREA, AR.COD_AREA FROM TB_PRODUCTO P INNER JOIN TB_DETALLE_PRODUCTO DP ON P.COD_PRODUCTO=DP.COD_PRODUCTO
							INNER JOIN TB_PROVEEDOR PRO  ON PRO.COD_PROVE=P.COD_PROVE
							INNER JOIN TB_ALMACEN A ON A.COD_ALMACEN = P.COD_ALMACEN
							INNER JOIN TB_AREA AR ON AR.COD_AREA = A.COD_AREA
							WHERE P.COD_PRODUCTO = 'PD13'


--CREACION DE INDICES PARA ORDENAR PRODUCTOS EN BASE A SU CANTIDAD
	
		--ASCENDENTE
CREATE NONCLUSTERED INDEX IDX_ASCEN ON TB_PRODUCTO(CANTIDAD_PRODUCTO ASC)
SELECT * FROM TB_PRODUCTO WITH (INDEX(IDX_ASCEN))--QUERY

SELECT P.COD_PRODUCTO,P.COD_PROVE,P.COD_ALMACEN,P.NOM_PRODUCTO,P.CANTIDAD_PRODUCTO,P.PRECIOUNI_PRODUCTO
	FROM TB_PRODUCTO P WITH (INDEX(IDX_ASCEN)) INNER JOIN TB_DETALLE_PRODUCTO DP ON P.COD_PRODUCTO = DP.COD_PRODUCTO 
							
		--DESCENDENTE
CREATE NONCLUSTERED INDEX IDX_DESCEN ON TB_PRODUCTO(CANTIDAD_PRODUCTO DESC)
SELECT * FROM TB_PRODUCTO WITH (INDEX(IDX_DESCEN))--QUERY
