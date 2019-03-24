DROP TABLE IF EXISTS `post_zip_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_zip_data` (
  `id` bigint(20) NOT NULL,
  `old_zip` varchar(5) DEFAULT NULL,
  `zip` varchar(7) DEFAULT NULL,
  `pref` varchar(16) NOT NULL,
  `city` varchar(256) NOT NULL,
  `town` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) NOT NULL,
  `passwd` varchar(255) NOT NULL,
  `created` timestamp NULL DEFAULT NULL,
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `users_id_index` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_detail`;

CREATE TABLE `user_detail` (
  `USERS_ID` bigint(20) NOT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `EML_NAME` varchar(32) DEFAULT NULL,
  `EML_DOMAIN` varchar(255) DEFAULT NULL,
  `POST_CODE` varchar(7) DEFAULT NULL,
  `PRE_CODE` int(11) DEFAULT NULL,
  `ADDRESS1` varchar(255) DEFAULT NULL,
  `ADDRESS2` varchar(255) DEFAULT NULL,
  `ADDRESS3` varchar(255) DEFAULT NULL,
  `created` timestamp NULL DEFAULT NULL,
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`USERS_ID`),
  UNIQUE KEY `EML_NAME` (`EML_NAME`,`EML_DOMAIN`),
  CONSTRAINT `user_detail_ibfk_1` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;