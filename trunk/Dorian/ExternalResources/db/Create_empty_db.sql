CREATE DATABASE  IF NOT EXISTS `models`;
USE `models`;

DROP TABLE IF EXISTS account;
CREATE TABLE account (
  id int(11) NOT NULL,
  user_id int(11) NOT NULL,
  disabled tinyint(1) DEFAULT '0',
  locked tinyint(1) DEFAULT '0',
  expired tinyint(1) DEFAULT '0',
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_at timestamp NULL DEFAULT NULL,
  avatar tinyint(1) DEFAULT '0',
  deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (id),
  KEY user_id (user_id)
);

DROP TABLE IF EXISTS `account_activation`;
CREATE TABLE account_activation (
  id int(11) NOT NULL,
  user_id int(11) NOT NULL,
  `code` varchar(64) NOT NULL,
  activated tinyint(1) DEFAULT '0',
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  activated_at date DEFAULT NULL,
  PRIMARY KEY (id),
  KEY user_id (user_id)
);

DROP TABLE IF EXISTS account_infos;
CREATE TABLE account_infos (
  id int(10) unsigned NOT NULL,
  reputation int(11) NOT NULL DEFAULT '0',
  account_id int(11) NOT NULL,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_at timestamp NULL DEFAULT NULL,
  deleted tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (id),
  KEY account_id (account_id)
);

DROP TABLE IF EXISTS account_settings;
CREATE TABLE account_settings (
  id int(11) NOT NULL,
  account_id int(11) NOT NULL,
  notifier_post tinyint(1) DEFAULT '1',
  notifier_comment tinyint(1) DEFAULT '1',
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_at timestamp NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (id),
  KEY account_id (account_id)
);

DROP TABLE IF EXISTS account_tag;
CREATE TABLE account_tag (
  id int(11) NOT NULL,
  account_id int(11) NOT NULL,
  tag_id int(11) NOT NULL,
  PRIMARY KEY (id),
  KEY tag_id (tag_id),
  KEY account_id (account_id)
);

DROP TABLE IF EXISTS activity;
CREATE TABLE activity (
  id int(11) NOT NULL,
  account_id int(11) NOT NULL,
  thread_id int(11) NOT NULL,
  command varchar(45) NOT NULL,
  param varchar(256) DEFAULT NULL,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  deleted tinyint(4) DEFAULT '0',
  PRIMARY KEY (id),
  KEY account_id (account_id),
  KEY thread_id (thread_id)
);

DROP TABLE IF EXISTS address;
CREATE TABLE address (
  id int(11) NOT NULL,
  account_id int(11) NOT NULL,
  street_number varchar(256) DEFAULT NULL,
  street_name varchar(256) DEFAULT NULL,
  city varchar(256) DEFAULT NULL,
  zip_code varchar(16) DEFAULT NULL,
  country varchar(256) DEFAULT NULL,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_at timestamp NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (id),
  KEY account_id (account_id)
);

DROP TABLE IF EXISTS attachment;
CREATE TABLE attachment (
  id int(11) NOT NULL,
  account_id int(11) NOT NULL,
  post_id int(11) DEFAULT NULL,
  tutorial_id int(11) DEFAULT NULL,
  file_name varchar(1024) NOT NULL,
  content_type varchar(1024) NOT NULL,
  file_uuid varchar(256) NOT NULL,
  description varchar(1024) DEFAULT NULL,
  visible tinyint(1) DEFAULT '0',
  downloadable tinyint(1) DEFAULT '0',
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_at timestamp NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (id),
  UNIQUE KEY file_uuid_UNIQUE (file_uuid),
  KEY post_id (post_id),
  KEY account_id (account_id),
  KEY tutorial_id (tutorial_id)
);

DROP TABLE IF EXISTS document;
CREATE TABLE document (
  id int(11) NOT NULL,
  account_id int(11) NOT NULL,
  file_name varchar(1024) NOT NULL,
  content_type varchar(1024) NOT NULL,
  file_uuid varchar(256) NOT NULL,
  description varchar(1024) DEFAULT NULL,
  visible tinyint(1) DEFAULT '0',
  downloadable tinyint(1) DEFAULT '0',
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_at timestamp NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (id),
  UNIQUE KEY file_uuid_UNIQUE (file_uuid),
  KEY account_id (account_id)
);

DROP TABLE IF EXISTS mail;
CREATE TABLE mail (
  id int(11) NOT NULL,
  destination varchar(256) NOT NULL,
  sender varchar(256) NOT NULL,
  template_type varchar(100) NOT NULL,
  object varchar(256) DEFAULT NULL,
  body longtext,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS post;
CREATE TABLE post (
  id int(11) NOT NULL,
  `owner` int(11) NOT NULL,
  content longtext NOT NULL,
  thread_id int(11) NOT NULL,
  is_question tinyint(1) DEFAULT '0',
  actived tinyint(1) DEFAULT '1',
  created_at timestamp NULL DEFAULT NULL,
  modified_at timestamp NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (id),
  KEY `owner` (`owner`),
  KEY thread_id (thread_id)
);

DROP TABLE IF EXISTS profile;
CREATE TABLE `profile` (
  id int(11) NOT NULL,
  account_id int(11) NOT NULL,
  web_site varchar(256) DEFAULT NULL,
  company varchar(256) DEFAULT NULL,
  phone_number varchar(256) DEFAULT NULL,
  birth_day date DEFAULT NULL,
  job varchar(256) DEFAULT NULL,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_at timestamp NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (id),
  KEY account_id (account_id)
);

DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  description varchar(100) DEFAULT NULL,
  created_at timestamp NULL DEFAULT NULL,
  modified_at timestamp NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (id),
  UNIQUE KEY title_UNIQUE (`name`)
);

DROP TABLE IF EXISTS tag;
CREATE TABLE tag (
  id int(11) NOT NULL,
  created_by int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  description varchar(1024) DEFAULT NULL,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_at timestamp NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (id),
  KEY created_by (created_by)
);

DROP TABLE IF EXISTS tag_parent;
CREATE TABLE tag_parent (
  id int(11) NOT NULL,
  parent_id int(11) NOT NULL,
  tag_id int(11) NOT NULL,
  PRIMARY KEY (id),
  KEY tag_id (tag_id),
  KEY parent_id (parent_id)
);

DROP TABLE IF EXISTS thread;
CREATE TABLE thread (
  id int(11) NOT NULL,
  created_by int(11) NOT NULL,
  title varchar(1024) NOT NULL,
  actived tinyint(1) DEFAULT '1',
  closed tinyint(1) DEFAULT '0',
  created_at timestamp NULL DEFAULT NULL,
  modified_at timestamp NULL DEFAULT NULL,
  post_valid_id int(11) DEFAULT NULL,
  deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (id),
  KEY created_by (created_by)
);

DROP TABLE IF EXISTS thread_tag;
CREATE TABLE thread_tag (
  id int(11) NOT NULL,
  thread_id int(11) NOT NULL,
  tag_id int(11) NOT NULL,
  PRIMARY KEY (id),
  KEY thread_id (thread_id),
  KEY tag_id (tag_id)
);

DROP TABLE IF EXISTS tutorial;
CREATE TABLE tutorial (
  id int(11) NOT NULL,
  title varchar(1024) DEFAULT NULL,
  question longtext,
  description varchar(1204) DEFAULT NULL,
  content longtext,
  account_id int(11) NOT NULL,
  second_account_id int(11) DEFAULT NULL COMMENT 'If created from thread, set it with valided post account id',
  thread_id int(11) DEFAULT NULL COMMENT 'If created from thread, set thread_id',
  actived tinyint(1) DEFAULT '0',
  created_at timestamp NULL DEFAULT NULL,
  modified_at timestamp NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (id),
  KEY account_id (account_id)
);

DROP TABLE IF EXISTS tutorial_tag;
CREATE TABLE tutorial_tag (
  id int(11) NOT NULL,
  tutorial_id int(11) NOT NULL,
  tag_id int(11) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user;
CREATE TABLE `user` (
  id int(11) NOT NULL,
  username varchar(45) DEFAULT NULL,
  primary_email varchar(45) NOT NULL,
  created_at timestamp NULL DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (id),
  UNIQUE KEY primary_email_UNIQUE (primary_email)
);

DROP TABLE IF EXISTS user_account;
CREATE TABLE user_account (
  id int(11) NOT NULL,
  account_id int(11) DEFAULT NULL,
  role_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY role_id (role_id),
  KEY account_id (account_id)
);