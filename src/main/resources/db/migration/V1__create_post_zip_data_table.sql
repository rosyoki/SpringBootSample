CREATE TABLE `post_zip_data`(
  `id` bigint(20) NOT NULL,
  `old_zip` varchar(5) DEFAULT NULL,
  `zip` varchar(7) DEFAULT NULL,
  `pref` varchar(16) NOT NULL,
  `city` varchar(256) NOT NULL,
  `town` text NOT NULL
);