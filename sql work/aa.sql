-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        9.0.0 - MySQL Community Server - GPL
-- 서버 OS:                        Linux
-- HeidiSQL 버전:                  12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 테이블 Lsy.student 구조 내보내기
CREATE TABLE IF NOT EXISTS `student` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `regdate` datetime DEFAULT (now()),
  `mydate` datetime DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 Lsy.student:~8 rows (대략적) 내보내기
DELETE FROM `student`;
INSERT INTO `student` (`idx`, `name`, `age`, `email`, `password`, `regdate`, `mydate`) VALUES
	(5, '이승용', 25, NULL, NULL, NULL, NULL),
	(6, '홍길동', 20, NULL, NULL, NULL, NULL),
	(7, NULL, NULL, 'aa@gmail.com', 'qwer1234', NULL, NULL),
	(8, NULL, NULL, 'aa@gmail.com', 'qwer1234', NULL, NULL),
	(9, NULL, NULL, 'aa@gmail.com', 'qwer1234asdfsadf', NULL, NULL),
	(10, NULL, NULL, 'asdfasf', 'asdfsafasfdf', NULL, NULL),
	(11, NULL, NULL, 'asdfasf@gmail.com', 'asdfsafasfdf', NULL, NULL),
	(12, NULL, NULL, 'asdfdasf@fdf', 'asfasf23423', NULL, NULL),
	(13, '이길동', 24, 'aaa@naver.com', 'qwer', '2024-08-30 02:39:51', NULL),
	(14, '이길동', 24, 'aaa@naver.com', 'qwer', '2024-08-30 02:40:19', NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
