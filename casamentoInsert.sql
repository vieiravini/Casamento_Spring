-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.6-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for casamentodatabse
CREATE DATABASE IF NOT EXISTS `casamentodatabse` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `casamentodatabse`;

-- Dumping structure for table casamentodatabse.convidado
CREATE TABLE IF NOT EXISTS `convidado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `familia` varchar(255) DEFAULT NULL,
  `mesa` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `festa_id` bigint(20) DEFAULT NULL,
  `presente_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr1qoy5vj7qvsboyusl935rquw` (`festa_id`),
  KEY `FKbkgh5k5ki2wbalmfs3th9e3a5` (`presente_id`),
  CONSTRAINT `FKbkgh5k5ki2wbalmfs3th9e3a5` FOREIGN KEY (`presente_id`) REFERENCES `presente` (`id`),
  CONSTRAINT `FKr1qoy5vj7qvsboyusl935rquw` FOREIGN KEY (`festa_id`) REFERENCES `festa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table casamentodatabse.convidado: ~5 rows (approximately)
/*!40000 ALTER TABLE `convidado` DISABLE KEYS */;
INSERT INTO `convidado` (`id`, `familia`, `mesa`, `nome`, `festa_id`, `presente_id`) VALUES
	(1, 'Silva', 3, 'João Silva', 1, 7),
	(2, 'Silva', 3, 'Anderson Silva', 1, 7),
	(3, 'Silva', 3, 'Maria Pereira da Silva', 1, 7),
	(4, 'Silva', 3, 'Thainá Silva', 1, 7),
	(5, NULL, 4, 'Roberto Pererira', 1, 8);
/*!40000 ALTER TABLE `convidado` ENABLE KEYS */;

-- Dumping structure for table casamentodatabse.festa
CREATE TABLE IF NOT EXISTS `festa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_casamento` date NOT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `horario` time NOT NULL,
  `local_casamento` varchar(255) DEFAULT NULL,
  `local_festa` varchar(255) DEFAULT NULL,
  `noiva` varchar(255) DEFAULT NULL,
  `noivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table casamentodatabse.festa: ~2 rows (approximately)
/*!40000 ALTER TABLE `festa` DISABLE KEYS */;
INSERT INTO `festa` (`id`, `data_casamento`, `endereco`, `horario`, `local_casamento`, `local_festa`, `noiva`, `noivo`) VALUES
	(1, '2020-05-06', 'Rua NomeDeRuaTeste', '22:30:00', 'igreja', 'Chácara', 'Renata', 'Pedro'),
	(2, '2020-05-21', 'Rua Desconhecida', '22:30:00', 'Igreja', 'Praia', 'Maria Eduarda', 'João Pedro');
/*!40000 ALTER TABLE `festa` ENABLE KEYS */;

-- Dumping structure for table casamentodatabse.padrinho
CREATE TABLE IF NOT EXISTS `padrinho` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `madrinha` bit(1) NOT NULL,
  `mesa` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `padrinho` bit(1) NOT NULL,
  `tipo_padrinho` varchar(255) DEFAULT NULL,
  `festa_id` bigint(20) DEFAULT NULL,
  `presente_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnse8r8tk1x1e2oh3kj89wsyes` (`festa_id`),
  KEY `FK7uo2vfj4km6dawgjufnkvncos` (`presente_id`),
  CONSTRAINT `FK7uo2vfj4km6dawgjufnkvncos` FOREIGN KEY (`presente_id`) REFERENCES `presente` (`id`),
  CONSTRAINT `FKnse8r8tk1x1e2oh3kj89wsyes` FOREIGN KEY (`festa_id`) REFERENCES `festa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table casamentodatabse.padrinho: ~8 rows (approximately)
/*!40000 ALTER TABLE `padrinho` DISABLE KEYS */;
INSERT INTO `padrinho` (`id`, `madrinha`, `mesa`, `nome`, `padrinho`, `tipo_padrinho`, `festa_id`, `presente_id`) VALUES
	(1, b'1', '1', 'Viviane', b'0', 'noiva', 1, 5),
	(2, b'0', '1', 'Marcelo', b'1', 'noiva', 1, 5),
	(3, b'1', '1', 'Beatriz', b'0', 'noiva', 1, 4),
	(4, b'0', '1\r\n', 'Renato', b'1', 'noiva', 1, 4),
	(5, b'1', '2', 'Mariana', b'0', 'noivo', 1, 3),
	(6, b'0', '2', 'Andre', b'1', 'noivo', 1, 3),
	(7, b'1', '2', 'Carla', b'0', 'noivo', 1, 1),
	(8, b'0', '2', 'Pedro', b'1', 'noivo', 1, 1);
/*!40000 ALTER TABLE `padrinho` ENABLE KEYS */;

-- Dumping structure for table casamentodatabse.presente
CREATE TABLE IF NOT EXISTS `presente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `local_compra` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table casamentodatabse.presente: ~8 rows (approximately)
/*!40000 ALTER TABLE `presente` DISABLE KEYS */;
INSERT INTO `presente` (`id`, `descricao`, `local_compra`) VALUES
	(1, 'Tv 40 Polegadas', 'Casas bahia'),
	(2, 'Cafeteira', 'lojas 100'),
	(3, 'Geladeira', 'Casas bahia'),
	(4, 'Nootbook', 'Submarino'),
	(5, 'cama casal', 'lojas 100'),
	(6, 'Relogio de Parede', 'casa dos presentes'),
	(7, 'liquidificador', 'Americanas'),
	(8, 'Batedeira', 'americanas');
/*!40000 ALTER TABLE `presente` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
