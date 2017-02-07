/**1. 配件(保养项目)信息表**/
DROP TABLE IF EXISTS t_parts;
CREATE TABLE t_parts (
  i_id                      INTEGER AUTO_INCREMENT NOT NULL
  COMMENT '配件id,主键',
  v_name                    VARCHAR(30) NOT NULL
  COMMENT '配件名称',
  i_first_protect_distance  INTEGER NOT NULL
  COMMENT '首保里程',
  i_space_distance          INTEGER NOT NULL
  COMMENT '里程间隔',
  i_car_id                  INTEGER NOT NULL
  COMMENT '对应车型id',

  PRIMARY KEY (i_id),
  CONSTRAINT fk_tp_car_id FOREIGN KEY (i_car_id) REFERENCES t_car(i_id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;

/**2. 配件(保养项目)规格表**/
DROP TABLE IF EXISTS t_parts_standard;
CREATE TABLE t_parts_standard (
  i_id             INTEGER AUTO_INCREMENT NOT NULL
  COMMENT '配件规格id,主键',
  v_description    VARCHAR(30) NOT NULL
  COMMENT '规格描述',
  i_price          DECIMAL(10, 2) NOT NULL
  COMMENT '规格价格',
  i_parts_id       INTEGER NOT NULL
  COMMENT '对应的配件id',

  PRIMARY KEY (i_id),
  CONSTRAINT fk_tps_parts_id FOREIGN KEY (i_parts_id) REFERENCES t_parts(i_id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;

/**3. 车型信息表**/
DROP TABLE IF EXISTS t_car;
CREATE TABLE t_car (
  i_id              INTEGER AUTO_INCREMENT NOT NULL
  COMMENT '车型id,主键',
  v_brand           VARCHAR(30) NOT NULL
  COMMENT '品牌',
  v_car_name        VARCHAR(30) NOT NULL
  COMMENT '车名',
  v_car_pattern     VARCHAR(30) NOT NULL
  COMMENT '车款',
  i_car_year        INTEGER NOT NULL
  COMMENT '年款',
  v_detail_pattern  VARCHAR(30) NOT NULL
  COMMENT '细分款',

  PRIMARY KEY (i_id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;