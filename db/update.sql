/**1. 用户角色信息表**/
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
  i_id          INTEGER AUTO_INCREMENT NOT NULL
  COMMENT '用户id,主键',
  v_username    VARCHAR(20) NOT NULL
  COMMENT '用户名',
  v_password    VARCHAR(50) NOT NULL
  COMMENT '用户名',
  v_name        VARCHAR(20) NOT NULL
  COMMENT '姓名',
  i_user_type   TINYINT NOT NULL
  COMMENT '用户角色类型:1->客服
                      2->任务调度
                      3->技术工程师
                      4->库管
                      5->运营监督',
  b_is_free     BOOLEAN DEFAULT FALSE
  COMMENT '是否空闲',

  PRIMARY KEY (i_id),
  CONSTRAINT x_user_type CHECK (i_user_type IN (1, 2, 3, 4, 5))
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;

/**2. 客户信息表**/
DROP TABLE IF EXISTS t_customer;
CREATE TABLE t_customer (
  i_id              INTEGER AUTO_INCREMENT NOT NULL
  COMMENT '客户id,主键',
  v_number          VARCHAR(20) NOT NULL
  COMMENT '客户编号',
  v_id_card         VARCHAR(30) NOT NULL
  COMMENT '客户身份证号',
  d_time            TIMESTAMP
  COMMENT '客户送机时间',
  i_customer_type   TINYINT
  COMMENT '客户类型：1->家庭用户
                    2->单位用户
                    3->代理商
                    4->签约用户',
  v_company         VARCHAR(20)
  COMMENT '单位名称',
  v_phone           VARCHAR(20)
  COMMENT '移动电话',
  v_address         VARCHAR(50)
  COMMENT '客服地址',
  v_zip_code        VARCHAR(20)
  COMMENT '邮编',
  v_contact_user    VARCHAR(20)
  COMMENT '联系人',
  v_email           VARCHAR(20)
  COMMENT '邮箱',
  v_add_time        TIMESTAMP
  COMMENT '添加客户的时间',

  PRIMARY KEY (i_id),
  CONSTRAINT x_customer_type CHECK (i_customer_type IN (1, 2, 3, 4, 5))
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;

/**3. 设备报修表**/
DROP TABLE IF EXISTS t_device_repair;
CREATE TABLE t_device_repair (
  i_id                       INTEGER AUTO_INCREMENT NOT NULL
  COMMENT 'id,主键',
  v_number                   VARCHAR(20) NOT NULL
  COMMENT '维修编号',
  i_customer_id              INTEGER NOT NULL
  COMMENT '报修客户id',
  i_device_type              TINYINT NOT NULL
  COMMENT '设备类型：1->台式机
                    2->笔记本
                    3->投影仪
                    4->打印机
                    5->其他',
  v_brand                     VARCHAR(30)
  COMMENT '机器品牌',
  v_version                   VARCHAR(30)
  COMMENT '机器型号',
  v_serial_number             VARCHAR(30)
  COMMENT '系列号',
  v_shorted_component         VARCHAR(30)
  COMMENT '缺少的零件',
  v_device_fault              VARCHAR(30) NOT NULL
  COMMENT '设备故障现象',
  i_fault_type                TINYINT NOT NULL
  COMMENT '故障类型：1->固定性故障
                    2->间隙性故障',
  v_appearance_check          VARCHAR(30)
  COMMENT '外观检查',
  v_startup_pwd               VARCHAR(30)
  COMMENT '开机口令',
  v_important_material        VARCHAR(50)
  COMMENT '重要资料路径',
  v_hdd                       VARCHAR(30)
  COMMENT 'HDD',
  v_internal_storage          VARCHAR(30)
  COMMENT '内存',
  v_pc_card                   VARCHAR(30)
  COMMENT '外置PC卡',
  v_ac_adapter                VARCHAR(30)
  COMMENT 'AC适配器',
  v_bettary                   VARCHAR(30)
  COMMENT '电池',
  v_external_CD_driver        VARCHAR(30)
  COMMENT '外接光驱',
  v_external_floppy_driver    VARCHAR(30)
  COMMENT '外接软驱',
  v_others                    VARCHAR(200)
  COMMENT '其他',
  d_repair_time               TIMESTAMP DEFAULT now()
  COMMENT '报修时间',
  v_estimate_price            INTEGER
  COMMENT '预估维修价格',
  i_repair_status             TINYINT DEFAULT 0
  COMMENT '报修状态：0->未打印
                    1->打印
                    2->提交',

  PRIMARY KEY (i_id),
  CONSTRAINT x_fault_type CHECK (i_fault_type IN (0, 1, 2)),
  FOREIGN KEY (i_customer_id) REFERENCES t_customer (i_id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;

/**4. 维修记录表**/
DROP TABLE IF EXISTS t_maintain_record;
CREATE TABLE t_maintain_record (
  i_id                    INTEGER AUTO_INCREMENT NOT NULL
  COMMENT '客户id,主键',
  v_number                VARCHAR(20) NOT NULL
  COMMENT '维修编号',
  i_maintain_user         INTEGER
  COMMENT '维修人员id',
  v_check_record          VARCHAR(30)
  COMMENT '检查记录',
  v_repair_record         VARCHAR(30)
  COMMENT '维修记录',
  d_repair_time           TIMESTAMP
  COMMENT '检测维修时间',
  v_used_component        VARCHAR(200)
  COMMENT '使用的零件',
  i_repair_status         TINYINT
  COMMENT '维修转态：0->未分配
                    1->分配未检查
                    2->检测完成维修完成
                    3->维修完成',

  PRIMARY KEY (i_id),
  CONSTRAINT x_repair_status CHECK (i_repair_status IN (0, 1, 2, 3)),
  FOREIGN KEY (i_maintain_user) REFERENCES t_user (i_id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;

/**5. 备件表**/
DROP TABLE IF EXISTS t_spare_part;
CREATE TABLE t_spare_part (
  i_id                    INTEGER AUTO_INCREMENT NOT NULL
  COMMENT '备件id,主键',
  v_name                  VARCHAR(30) NOT NULL
  COMMENT '备件名称',
  v_version               VARCHAR(30) NOT NULL
  COMMENT '备件型号',
  v_check_record          VARCHAR(30)
  COMMENT '检查记录',
  i_price                 INTEGER
  COMMENT '备件价格',
  i_quantity              INTEGER
  COMMENT '备件数量',
  d_laid_up_time          TIMESTAMP
  COMMENT '入库时间',
  i_warn_quantity         INTEGER
  COMMENT '备件警戒数量,仓库中备件至少数目',
  i_inventory_status      TINYINT
  COMMENT '库存状态：1->正常：库存量>警戒数量
                    2->临界：库存量=警戒数量
                    3->警示：0<库存量<警戒数量
                    4->缺货：库存量=0',

  PRIMARY KEY (i_id),
  CONSTRAINT x_inventory_status CHECK (i_inventory_status IN (1, 2, 3, 4))
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;

/**6. 备件流水明细表**/
DROP TABLE IF EXISTS t_spare_part_record;
CREATE TABLE t_spare_part_record (
  i_id                    INTEGER AUTO_INCREMENT NOT NULL
  COMMENT '备件id,主键',
  i_spare_part_id         INTEGER
  COMMENT '备件id',
  i_maintain_id           INTEGER
  COMMENT '维修id',
  i_quantity              INTEGER
  COMMENT '使用数量',
  d_use_time              TIMESTAMP
  COMMENT '备件使用时间',

  PRIMARY KEY (i_id),
  FOREIGN KEY (i_spare_part_id) REFERENCES t_spare_part (i_id),
  FOREIGN KEY (i_maintain_id) REFERENCES t_maintain_record(i_id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;