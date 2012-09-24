--用户表
CREATE TABLE tbl_user
(
  id bigint NOT NULL,
  create_time timestamp without time zone,
  email character varying(255),
  last_login_time timestamp without time zone,
  login_name character varying(255),
  password character varying(255),--密码
  user_type integer,--用户类型
  status integer,
  PRIMARY KEY (id )
);
--企业信息
CREATE TABLE en_enterprise (
    id bigint NOT NULL,
    business_pattern character varying(100),
    main_product character varying(100),
    main_sort character varying(100),
    name character varying(100),
    address character varying(255),
    faxes character varying(255),
    phone character varying(255),
    telphone character varying(255),
    url character varying(255),
	image_id bigint,
    tbl_user_id bigint,
	CONSTRAINT FK_M_MALL_tbl_user FOREIGN KEY(tbl_user_id) REFERENCES tbl_user(id),
    primary key (id)
);
--tbl_supply
CREATE TABLE tbl_supply
(
  id bigint NOT NULL,
  description character varying(255),
  title character varying(100),
  en_enterprise_id bigint,
  CONSTRAINT FK_M_MALL_tbl_user FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
  CONSTRAINT tbl_supply_pkey PRIMARY KEY (id )
);
--求购
CREATE TABLE tbl_buy
(
  id bigint NOT NULL,
  content character varying(255),
  create_time date,
  title character varying(255),
  count integer,
  endtime date,
  flg integer NOT NULL,
  name character varying(255),
  en_enterprise_id bigint,
  CONSTRAINT FK_M_MALL_tbl_user FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
  PRIMARY KEY (id )
);

--图库
CREATE TABLE tbl_image (
    id bigint NOT NULL,
    image_type character varying(20),
    small bytea,
    middle bytea,
    big bytea,
    title character varying(200),
    name character varying(200)
, primary key (id) );

--市场
CREATE TABLE m_mall (
    id bigint NOT NULL,
    describes character varying(255),
    email character varying(100),
    logo bigint,
    name character varying(100),
    phone character varying(100),
    tbl_user_id bigint,
    CONSTRAINT FK_M_MALL_tbl_user FOREIGN KEY(tbl_user_id) REFERENCES tbl_user(id),
    primary key (id)
 );



--招商信息
CREATE TABLE admin_canvass_trader (
    id bigint NOT NULL,
    en_enterprise_id bigint,
    description character varying(255),
    factory_name character varying(100),
    trader_name character varying(100),
    address character varying(255),
    endtime date,
    kind character varying(255),
    name character varying(255),
    pack character varying(255),
    standard character varying(255),
    title character varying(255),
    CONSTRAINT FK_ADMIN_CANVASS_TRADER_EN_ENTERPRISE FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
    primary key (id)
);

	
--分类
CREATE TABLE admin_catalogue (
    id bigint NOT NULL,
    class_name character varying(100),
    description character varying(255),
    level numeric(19,2),
    parent_id bigint, 
    primary key (id),
    CONSTRAINT FK_ADMIN_CATALOGUE FOREIGN KEY(parent_id) REFERENCES admin_catalogue(id)
);
--帮助
CREATE TABLE admin_help (
    id bigint NOT NULL,
    class_name character varying(100),
    content character varying(100),
    create_time date,
    description character varying(255),
    name character varying(100), 
	primary key (id) 
);


--行业资讯
CREATE TABLE admin_industry_news (
    id bigint NOT NULL,
    class_name character varying(100),
    class_title character varying(100),
    content character varying(255),
    description character varying(255)
, primary key (id) );



--杂志订阅
CREATE TABLE admin_magazine (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(100)
, primary key (id) );
--商贸城基本信息
CREATE TABLE admin_message (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(100),
     primary key (id)
 );

--产品
CREATE TABLE admin_producet (
	id bigint NOT NULL,
	en_enterprise_id bigint,
	admin_catalogue_id bigint,
	create_time date,
	description character varying(255),
	end_time date,
	name character varying(100),
	CONSTRAINT FK_ADMIN_PRODUCET_EN_ENTERPRISE FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
	CONSTRAINT FK_ADMIN_PRODUCET_ADMIN_CATALOGUE FOREIGN KEY(admin_catalogue_id) REFERENCES admin_catalogue(id),
	primary key (id)
);
--订单
CREATE TABLE admin_order (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(100)
, primary key (id) );
--订单项
CREATE TABLE admin_order_item (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(100),
    order_id bigint ,
	admin_producet_id bigint,
	CONSTRAINT FK_ADMIN_ORDER_ITEM_ADMIN_ORDER FOREIGN KEY(order_id) REFERENCES admin_order(id),
	CONSTRAINT FK_ADMIN_ORDER_ITEM_ADMIN_PRODUCET FOREIGN KEY(admin_producet_id) REFERENCES admin_producet(id),
	primary key (id)
);
--注册
CREATE TABLE admin_register (
    id bigint NOT NULL,
    area character varying(100),
    create_time date,
    description character varying(255),
    email character varying(100),
    ip character varying(100),
    name character varying(100),
    online_time date,
    phone character varying(100)
, primary key (id) );

--品牌展示，市场推广
CREATE TABLE admin_spread (
    id bigint NOT NULL,
    brand_name character varying(100),
    description character varying(255)
, primary key (id) );

--网站模板
CREATE TABLE admin_style (
    id bigint NOT NULL,
    description character varying(255),
    enterprise_style character varying(100),
    mall_style character varying(100),
	primary key (id)
);
--企业模板关联表
CREATE TABLE en_enterprise_admin_style(
	admin_style_id bigint,
	en_enterprise_id bigint,
	CONSTRAINT FK_EN_ENTERPRISE FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
	CONSTRAINT FK_ADMIN_STYLE FOREIGN KEY(admin_style_id) REFERENCES admin_style(id)
);

--供应
CREATE TABLE admin_supply (
    id bigint NOT NULL,
	en_enterprise_id bigint,
    description character varying(255),
    name character varying(100),
	CONSTRAINT FK_ADMIN_SUPPLY_EN_ENTERPRISE FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
	primary key (id)
);

--企业认证
CREATE TABLE en_authentication (
    id bigint NOT NULL,
    en_enterprise_id bigint,
    aptitude_certifications character varying(100),
    description character varying(255),
    integrity_certifications character varying(100),
    name character varying(100),
    CONSTRAINT FK_EN_AUTHENTICATION_EN_ENTERPRISE FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
    primary key (id) 
);

--商友
CREATE TABLE en_businessmen (
    id bigint NOT NULL,
    en_enterprise_id bigint,
    friend_id bigint,
    group_name varchar(50),
    CONSTRAINT FK_EN_BUSINESSMEN_EN_ENTERPRISE FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
    CONSTRAINT FK_EN_BUSINESSMEN_FRIEND_ID FOREIGN KEY(friend_id) REFERENCES en_enterprise(id),
    primary key (id)
);

--展馆
CREATE TABLE tbl_pavilion (
    id bigint NOT NULL,
    description character varying(200),
    way character varying(200),
    url character varying(100),
    linkman character varying(100),
    telphone character varying(100),
    fax character varying(100),
    address character varying(200),
    big bytea,
	primary key (id)
);

--展会
CREATE TABLE en_exhibition (
    id bigint NOT NULL,
    content character varying(255),
    address character varying(255),
    authorize character varying(255),
    create_time date,
    description character varying(255),
    hotline character varying(255),
    line character varying(255),
    msn character varying(255),
    organizer character varying(255),
    phone character varying(255),
    qq integer NOT NULL,
    sponsor character varying(255),
    start_time date,
    title character varying(255),
    url character varying(255),
    name character varying(100),
    primary key (id)
 );

--收藏夹
CREATE TABLE en_favorite (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(100),
    en_enterprise_id bigint,
    CONSTRAINT FK_EN_FAVORITE_EN_ENTERPRISE FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
    primary key (id) );

--询盘
CREATE TABLE en_inquiry (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(100),
    en_enterprise_id bigint,
    CONSTRAINT FK_EN_INQUIRY_EN_ENTERPRISE FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
    primary key (id) );

--金融动态
CREATE TABLE en_money (
    id bigint NOT NULL,
    money bigint,
    name character varying(255),
	en_enterprise_id bigint,
	CONSTRAINT FK_EN_MONEY_EN_ENTERPRISE FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
	primary key (id) );
--企业新闻
CREATE TABLE en_news (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(100),
    addtime date,
    en_enterprise_id bigint,
    CONSTRAINT FK_EN_BUSINESSMEN_FRIEND_ID FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
    primary key (id)
);

--增值服务
CREATE TABLE en_premium (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(100),
    en_enterprise_id bigint,
    CONSTRAINT FK_EN_PREMIUM_EN_ENTERPRISE FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
    primary key (id) );

--人才招聘
CREATE TABLE en_recruitment (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(100),
    phone character varying(100),
    count integer NOT NULL,
    create_time timestamp without time zone,
    experience integer NOT NULL,
    it_require character varying(255),
    pay integer NOT NULL,
    require character varying(255),
    address character varying(255),
    education character varying(255),
    end_time timestamp without time zone,
    quale character varying(255),
    sex character varying(255),
    foreign_lang character varying(255),
    relatedinfo character varying(200),
	en_enterprise_id bigint,
	CONSTRAINT FK_EN_RECRUITMENT_EN_ENTERPRISE FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
	m_mall_id bigint,
	CONSTRAINT FK_EN_RECRUITMENT_M_MALL FOREIGN KEY(m_mall_id) REFERENCES m_mall(id),
	primary key (id) );
 
--店面
CREATE TABLE en_storefront (
    id bigint NOT NULL,
    ad character varying(255),
    description character varying(255),
    logo bigint,
    name character varying(100),
    phone character varying(255),
    style character varying(255)
, primary key (id) );

--采购
CREATE TABLE purchase (
    id bigint NOT NULL,
    create_time date,
    describe character varying(255),
    name character varying(255), 
    en_enterprise_id bigint,
    CONSTRAINT FK_PURCHASE_EN_ENTERPRISE FOREIGN KEY(en_enterprise_id) REFERENCES en_enterprise(id),
    primary key (id)
);

--友情链接
CREATE TABLE tbl_friendly_link (
    id bigint NOT NULL,
    content character varying(100),
    create_time date,
    description character varying(255),
    name character varying(100),
    primary key (id) );
--公司表
CREATE TABLE company
(
  id bigint NOT NULL,
  company_name character varying(225),
  company_introduction character varying(225),
  company_phone character varying(225),
  company_fax character varying(225),
  company_address character varying(225),
  CONSTRAINT company_pkey PRIMARY KEY (id )
);

--职位表

CREATE TABLE "position"
(
  id bigint NOT NULL,
  position_name character varying(225),
  need_count integer,
  gender_requirement character varying(10),
  academic_requirement character varying(225),
  work_experience character varying(225),
  work_nature character varying(225),
  salary_range character varying(100),
  language_requirement character varying(225),
  work_address character varying(225),
  create_time date,
  end_time date,
  other_requirement character varying(225),
  position_description character varying(225),
  position_requirement character varying(225),
  company_id bigint,
  CONSTRAINT position_pkey PRIMARY KEY (id ),
CONSTRAINT position_company_id_fkey FOREIGN KEY (company_id)
      REFERENCES company (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

--应聘人员信息表

CREATE TABLE persion
(
  id bigint NOT NULL,
  persion_name character varying(225),
  persion_gender character varying(10),
  persion_age integer,
  native_place character varying(225),
  persion_education character varying(225),
  persion_title character varying(225),
  political_affiliation character varying(225),
  marital_status character varying(225),
  job_intention character varying(225),
  expect_address character varying(225),
  expect_salary character varying(225),
  contact_telephone character varying(225),
  persion_phone character varying(225),
  persion_email character varying(225),
  persion_qq character varying(225),
  persion_address character varying(225),
  graduation_school character varying(225),
  persion_professional character varying(225),
  persion_honor character varying(225),
  education_introduction character varying(225),
  worked_name character varying(225),
  worked_date character varying(225),
  worked_introduction character varying(225),
  job_date date,
  PRIMARY KEY (id )
)
;


--应聘联系人表

CREATE TABLE contact
(
  id bigint NOT NULL,
  contact_name character varying(225),
  contact_phone character varying(225),
  contact_email character varying(225),
  company_id bigint,
  PRIMARY KEY (id ),
  CONSTRAINT contact_company_id_fkey FOREIGN KEY (company_id)
      REFERENCES company (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
--报价表
CREATE TABLE tbl_quote
(
  id bigint NOT NULL,
  address character varying(255),
  description character varying(255),
  en_name character varying(255),
  good character varying(255),
  name character varying(255),
  phone character varying(255),
  phone_name character varying(255),
  PRIMARY KEY (id )
);
--加工1
CREATE TABLE tbl_process
(
  id bigint NOT NULL,
  ability character varying(100),
  description character varying(100),
  device character varying(500),
  kind character varying(100),
  title character varying(100),
  CONSTRAINT tbl_process_pkey PRIMARY KEY (id )
);
--加工2
CREATE TABLE tbl_machining
(
  id bigint NOT NULL,
  title character varying(100),
  kind character varying(100),
  device character varying(500),
  ability character varying(100),
  description character varying(100),
  PRIMARY KEY (id )
);




