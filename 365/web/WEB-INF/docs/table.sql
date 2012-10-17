--用户基本信息
CREATE TABLE tbl_userinfo
(
  userid bigint NOT NULL,
  password character varying(255),--密码
  PRIMARY KEY (userid)
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
	create_time timestamp without time zone,
	CONSTRAINT FK_M_MALL_tbl_user FOREIGN KEY(tbl_user_id) REFERENCES tbl_userinfo(userid),
    primary key (id),
	
	description character varying(255)
);
CREATE TABLE tbl_enterprise
(
  id bigint NOT NULL,
  name varchar(100),
  website varchar(32),
  address varchar(255),
  phone varchar(255),
  en_type varchar(20),
  personnel_numeric numeric,
  en_synopsis varchar(20),
  email varchar(20),
  found_time date,
  registered_region  varchar(100),
  legal_person varchar(20),--法人代表
  turnover_year varchar(20),--年营业额
  business_model varchar(20),--经营模式
  customer_base varchar(20),
  exports_year varchar(20),
  sell_year varchar(20),--年销量
  certification_system varchar(20),
  oem varchar(20),
  authenticate numeric,
  creator varchar(20),
  update_user varchar(20),
  update_time date,
  create_time date,
  logo_id bigint,--企业Logo
  user_id bigint,
  main_product varchar(100),
  main_sort varchar(100),
  faxes varchar(255),
  telphone varchar(255),
  homepage varchar(255),
  QQ varchar(20),
  linkman varchar(50),
  CONSTRAINT PK_TBL_ENTERPRISE PRIMARY KEY (id)
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
    CONSTRAINT FK_M_MALL_tbl_user FOREIGN KEY(tbl_user_id) REFERENCES tbl_userinfo(userid),
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
  sex character(10),
  tel character(100),
  department character(100),
  position character(100),
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


--产品属性
CREATE TABLE tbl_product_property
(
id bigint NOT NULL,
category_id bigint,
name character varying(100),
description character varying(255),
create_time date,
PRIMARY KEY (id )
);

--产品规格
CREATE TABLE tbl_spec
(
id bigint NOT NULL,
category_id bigint,
name character varying(100),
description character varying(255),
create_time date,
PRIMARY KEY (id )
);
--分类表
CREATE TABLE tbl_category
(
  id bigint NOT NULL,
  name character varying(30),
  pid bigint NOT NULL,
  PRIMARY KEY (id )
);

--角色表

CREATE TABLE tbl_role_info
(
  id bigint NOT NULL,
  name character varying(255) NOT NULL,
  description character(100),
  sorts integer,
  creator character(50),
  update_user character(50),
  update_time date,
  create_time date,
  CONSTRAINT tbl_role_pkey PRIMARY KEY (id )
);
--系统数据字典

CREATE TABLE tbl_system_datainfo
(
  systemdata_id bigint NOT NULL,
  cname character(50),
  sorts integer,
  creator character(50),
  update_user character(50),
  update_time date,
  create_time date,
  CONSTRAINT tbl_system_datainfo_pkey PRIMARY KEY (systemdata_id )
);

--系统数据字典数据项
CREATE TABLE tbl_dataitems_info
(
  dataitems_id bigint NOT NULL,
  systemdata_id bigint,
  cname character(50),
  data_value character(100),
  sorts integer,
  creator character(50),
  update_user character(50),
  update_time date,
  create_time date,
  CONSTRAINT tbl_dataitems_info_pkey PRIMARY KEY (dataitems_id )
);

--用户角色
CREATE TABLE tbl_userrolesinfo
(
  userroleid bigint NOT NULL,
  createtime date,
  creator character varying(50),
  roleid numeric(19,2),
  sorts integer,
  status integer,
  updatetime date,
  updateuser character varying(50),
  userid numeric(19,2),
  CONSTRAINT tbl_userrolesinfo_pkey PRIMARY KEY (userroleid )
);

--组信息
CREATE TABLE tbl_groupinfo
(
  groupid bigint NOT NULL,
  createtime date,
  creator character varying(50),
  description character varying(100),
  groupcname character varying(100),
  pid numeric(19,2),
  sorts integer,
  treeid numeric(19,2),
  updatetime date,
  updateuser character varying(100),
  CONSTRAINT tbl_groupinfo_pkey PRIMARY KEY (groupid )
);

--组角色信息
CREATE TABLE tbl_group_role_info
(
  group_roles_id bigint NOT NULL,
  create_time date,
  creator character varying(100),
  group_id numeric(19,2),
  role_id numeric(19,2),
  sorts integer,
  update_time date,
  update_user character varying(100),
  CONSTRAINT tbl_group_role_info_pkey PRIMARY KEY (group_roles_id )
);

--组内用户
CREATE TABLE tbl_group_user
(
  group_user_id bigint NOT NULL,
  create_time date,
  creator character varying(100),
  group_id bigint NOT NULL,
  sorts integer,
  update_time date,
  update_user character varying(50),
  user_id bigint NOT NULL,
  CONSTRAINT tbl_group_user_pkey PRIMARY KEY (group_user_id )
);

--角色具有的权限
CREATE TABLE tbl_rightsfor_rolesinfo
(
  authority_id bigint NOT NULL,
  role_id bigint NOT NULL,
  id bigint NOT NULL,
  right_type integer,
  sorts integer,
  creator character(50),
  update_user character(50),
  update_time date,
  create_time date
);

--系统功能菜单模块

CREATE TABLE tbl_menus_info
(
  menuid bigint NOT NULL,
  pid bigint NOT NULL,
  texts character(50),
  menu_name character(100),
  icon_cls character(50),
  menucontrol character(100),
  menuview character(100),
  description character(100),
  menu_type integer,
  expanded integer,
  tree_id bigint,
  menustore character(50),
  sorts integer,
  creator character(50),
  update_user character(50),
  update_time date,
  create_time date,
  CONSTRAINT tbl_menus_info_pkey PRIMARY KEY (menuid )
);

--权限对象表：tbl_dataObjInfo
CREATE TABLE tbl_data_objinfo
(
  id bigint NOT NULL,
  name character varying(255) NOT NULL,
  remark character(50),
  attr_value character(100),
  sorts integer,
  creator character(50),
  update_user character(50),
  update_time date,
  create_time date,
  CONSTRAINT tbl_authority_pkey PRIMARY KEY (id )
);

--菜单对应的权限对象信息表：tbl_menuObjInfo
CREATE TABLE tbl_menu_objinfo
(
  menuobj_id bigint NOT NULL,
  menu_id bigint,
  dataobj_id bigint,
  sorts integer,
  creator character(50),
  update_user character(50),
  update_time date,
  create_time date,
  CONSTRAINT tbl_menu_objinfo_pkey PRIMARY KEY (menuobj_id )
);


--订单表
create table order_orderinfo(
	id				    bigint,--主键
	order_no			varchar(32),--订单号
	order_state			varchar(8),--订单状态
	state_time			timestamp without time zone,--状态变更时间
	reason_code			varchar(32),--原因代码
	remark				varchar(32),--状态说明
	distribution_model	varchar(32),--配送方式
	pay_model			varchar(32),--支付方式
	pay_state			varchar(20),--支付状态
	receivable_amount	numeric(10,2),--应收金额
	pre_payment			varchar(32),--
	finish_time			timestamp without time zone,--完成时间
	vender_code			varchar(32),--承运商
	freight				numeric(10,2),--运费
	weight				numeric(10,4),--重量
	invoice				varchar(32),--是否已打印发票
	enterprise_id_buy		varchar(32),--购买企业id
	order_time			timestamp without time zone,--下单时间
	order_remaek		varchar(32),--会员订单备注
	sale_amount			numeric(10,2),--销售总价
	terminate_type		varchar(32),--终止类别
	enterprise_id_sell		varchar(32),--销售企业id
	receives_time		timestamp without time zone,--签收时间
	express_id			varchar(32),--快递公司id
	need_invoice		varchar(32),--是否需要发票
	received_amount		numeric(10,2),--支付金额
	CONSTRAINT "ORDER_ORDERINFO_PKEY" PRIMARY KEY (id )
);
--订单商品表供应
create table order_orderProduct(
	id 				bigint ,--(主键
	order_no		varchar(32),--订单号
	product_name	varchar(32),--商品
	product_price	varchar(32),--商品单价
	product_account	varchar(32),--数量
	product_total	varchar(32),--总金额
	order_state		varchar(32),--订单商品状态
	CONSTRAINT "OORDER_ORDERPRODUCT_PKEY" PRIMARY KEY (id )
);
--订单支付表
create table order_payment(
	id 				bigint,			--主键
	orderno	  		varchar(32),--订单号
	pay_state		numeric(1),--支付状态
	product_price 	varchar(32)	,--支付银行
	product_account 	varchar(32),--	支付账号
	transaction_code varchar(32),--	交易号
	order_state		varchar(32) ,--收款仓库代码
	remark			varchar(32) ,--支付说明
	pay_time 		timestamp without time zone,--支付时间
	CONSTRAINT "ORDER_PAYMENT_PKEY" PRIMARY KEY (id )
);
--订单发票表
create table order_invoice(
	id				bigint,--主键
	invoice_type 	varchar(20),--发票类型
	head			varchar(20),--发票抬头
	head_type		varchar(20),--抬头类型
	corp_name		varchar(20),--单位名称
	taxpayer_no		varchar(20),--纳税人识别号
	invoice_time 	timestamp without time zone,--开票时间
	CONSTRAINT "ORDER_INVOICE_PKEY" PRIMARY KEY (id )
);
--订单收货人
create table "order_contact"(
	id 				bigint,					--主键
	consignee 		varchar(32),--	收货人
	consignee_model	varchar(32),--收货方式
	phone			varchar(32),--固定电话
	mobile			varchar(32),--移动电话
	zip_code		varchar(10),--邮编
	address			varchar(32),--地址
	sign_user		varchar(32),--签收人
	CONSTRAINT "ORDER_CONTACT_PKEY" PRIMARY KEY (id )
);

  --企业图片
  create table tbl_enterprise_image(
	id bigint,
	enterprise_id bigint,
	img_name varchar(32),
	img_path varchar(32),
	creator varchar(20),
    update_user varchar(20),
    update_time date,
    create_time date,
	CONSTRAINT PK_TBL_ENTERPRISE_IMAGE PRIMARY KEY (id)
  );
  --企业联系人
  create table tbl_enterprise_contact(
	id bigint,
	enterprise_id bigint,
	contact_name varchar(20),
	contact_phone varchar(20),
	creator varchar(20),
    update_user varchar(20),
    update_time date,
    create_time date,
	CONSTRAINT PK_TBL_ENTERPRISE_CONTACT PRIMARY KEY (id)
  );
  
  --企业动态表
  create table tbl_enterprise_news(
	id bigint,
	enterprise_id bigint,
	content_title varchar(20),--动态标题
	news_content varchar(500),--动态内容
	creator varchar(20),
    update_user varchar(20),
    update_time date,
    create_time date,
	CONSTRAINT PK_TBL_ENTERPRISE_NEWS PRIMARY KEY (id)
  );
  
  --资质证书
  create table tbl_qualification_certificate(
    id bigint,
	enterprise_id bigint,
	certificate_type varchar(20),
	certificate_path varchar(20),
	is_certificate numeric,
	creator varchar(20),
    update_user varchar(20),
    update_time date,
    create_time date,
	CONSTRAINT PK_TBL_QUALIFICATION_CERTIFICATE PRIMARY KEY (id)
  );
  --商品主数据信息表
  create table spgl_productInfo(
	id bigint,
	product_code varchar(20),	--标准编码	
	long_desc varchar(20),--长描述
	pro_type char(1),--商品类别
	brand_id bigint,--品牌ID
	name varchar(40),
	english_name varchar(40),
	units varchar(20),
	output_rate numeric(3),
	product_width numeric(10,2),
	product_height numeric(10,2),
	product_type varchar(20),--产品型号
	is_stored varchar(20),--存储方式
	stack_height numeric(5),--安全垒叠高度
	gross_weight numeric(14,4),--毛重
	manufacturer varchar(100),--制造商
	remark varchar(600),--详细描述
	sorts numeric(4),--排序
	creator varchar(20),
    update_user varchar(20),
    update_time date,
    create_time date,
	CONSTRAINT PK_SPGL_PRODUCTINFO PRIMARY KEY (id)
  );
  
  --商品图片信息表
  create table spgl_productPicInfo(
	id bigint,
	product_id bigint,
	pic_name varchar(32),
	pic_path varchar(32),
	sorts numeric(4),
    creator varchar(20),
    update_user varchar(20),
    update_time date,
    create_time date,
	CONSTRAINT PK_spgl_productPicInfo PRIMARY KEY (id)
  );
  --商品所属品类信息
  CREATE TABLE "spgl_productCategory"
(
  id bigint NOT NULL,
  product_id bigint,
  cate_id bigint,
  catetype_id bigint,
  sorts numeric(4,0),
  creator character varying(20),
  update_user character varying(30),
  create_time timestamp without time zone,
  update_time timestamp without time zone,
  CONSTRAINT "spgl_productCategory_pkey" PRIMARY KEY (id )
);
--商品扩展属性值表
create table "spgl_productattrvalue"(
	id               bigint,
	product_id		 varchar(32)	not null,--商品主数据id
	category_attrid	 varchar(32)	not null,--扩展属性id
	attrvalues		 varchar(200)	not null,--属性值
	sorts		     numeric(4)	not null,--排序
	creator          character varying(20),
	update_user      character varying(30),
	create_time      timestamp without time zone,
	update_time      timestamp without time zone,
	CONSTRAINT "SPGL_PRODUCTATTRVALUE_PKEY" PRIMARY KEY (id )
);

--商品规格信息表：
create table "spgl_productSpecInfo"(
	id		      bigint	Not Null,--主键
	product_id     varchar(32)	Not Null,--商品主数据ID
	spec	      varchar(40)	Not Null,--规格
	sorts	      numeric(4)	Not null,--排序
	creator       character varying(20),
	update_user   character varying(30),
	create_time   timestamp without time zone,
	update_time   timestamp without time zone,
	CONSTRAINT "SPGL_PRODUCTSPECINFO_PKEY" PRIMARY KEY (id )
);
--品牌信息表
create table "pp_brandInfo"(
	id		    bigint       	Not Null,--主键
	Pcode		varchar(6)	    Not Null,--父品牌编码
	name		varchar(40)	Not Null,--品牌名称
	brandcode	varchar(6)	    Not Null,--品牌编码
	ename		varchar(40)	Null,    --品牌英文名称
	logopic	    varchar(200)	Not Null,--	Logo图片
	remark		varchar(600)	Null,    --备注
	sorts		numeric(4)	    Not null,--排序
	creator       character varying(20),
	update_user   character varying(30),
	create_time   timestamp without time zone,
	update_time   timestamp without time zone,
	CONSTRAINT "PP_BRANDINFO_PKEY" PRIMARY KEY (id )
);
--品类类型信息表
create table "sppl_CategoryTypeInfo"(
	id	        bigint	Not Null,--主键
	name		varchar(40)	Not Null,--品类类型名称
	code		varchar(6)	Not Null,--品类类型编码
	is_used		boolean	Not Null,--是否启用
	is_std		boolean	Not null,--是否标准品类
	description	varchar(400)	Null,--描述
	remark		varchar(600)	Null,--备注
	creator       character varying(20),
	update_user   character varying(30),
	create_time   timestamp without time zone,
	update_time   timestamp without time zone,
	CONSTRAINT "SPPL_CATEGORYTYPEINFO_PKEY" PRIMARY KEY (id )
);
--品类信息表
create table "sppl_CategoryInfo"(
	id	            bigint	Not Null,--主键
	category_type_id	varchar(32)	Not Null,--所属品类类型ID
	pcode			varchar(12)	Not Null,--父品类编码
	name			varchar(40)	Not Null,--品类名称
	code			varchar(12)	Not Null,--品类编码
	description		varchar(400)	Null,--描述
	attrtype		numeric(1)	Not null,--扩展属性定义方式
	remark			varchar(600)	Null,--备注
	sorts			numeric(4)	Not null,--排序
	creator      	character varying(20),
	update_user     character varying(30),
	create_time     timestamp without time zone,
	update_time     timestamp without time zone,
	CONSTRAINT "SPPL_CATEGORYINFO_PKEY" PRIMARY KEY (id )
);
--品类扩展属性表
create table sppl_categoryattrinfo(
	id			bigint	not null,--（主键）
	category_id	varchar(32)	not null,--所属品类
	attrname	varchar(40)	not null,--属性名称
	attrtype	varchar(2)	not null,--属性类型
	required	boolean	not null,--是否必填
	display		boolean	not null,--是否显示
	disporder	numeric(4)	not null,--显示顺序
	sorts		numeric(4)	not null,--排序
	creator     character varying(20),
	update_user character varying(30),
	create_time timestamp without time zone,
	update_time timestamp without time zone,
	CONSTRAINT "SPPL_CATEGORYATTRINFO_PKEY" PRIMARY KEY (id )
);
--品类扩展属性域值表
create table sppl_cateattrrvinfo(
	id			bigint	not null,--（主键）
	cateattr_id	bigint	not null,--品类扩展属性id
	range_code	varchar(8)		not null,--域值编码
	range_desc	varchar(60)	not null,--域值描述
	sorts		numeric(4)	not null,--排序
	status		numeric(1)	not null,--记录删除标志
	creator     character varying(20),
	update_user character varying(30),
	create_time timestamp without time zone,
	update_time timestamp without time zone,
        CONSTRAINT "sppl_cateattrrvinfo_PKEY" PRIMARY KEY (id )
);

create table sad_supply_product(
	id bigint,--主键
    enterprise_id bigint,--	企业ID
    product_id bigint,--产品ID	
	product_name varchar(50),--产品
	product_name_segmentation text,--产品名分词
	category_id_path varchar(60),--分类ID路径以","分割
	category_name_path varchar(100),--分类名以空格分词
    passed boolean ,--是否通过供应审核
	description text,--产品描述
    description_segmentation text,--产品分词描述
	min_order_amount numeric(11),-- 最小起订量
	inventory_amount numeric(11),--产品库存数量	
	information_valid_date timestamp without time zone,--信息发布有效期
	pcp_services integer,--是否提供加工\定制服务		
	pricing_type varchar(32),--产品计价方式	
	status		integer,--状态
    sorts		integer,--排序
	creator     character varying(20),
	update_user character varying(30),
	create_time timestamp without time zone,
	update_time timestamp without time zone,
	CONSTRAINT "SAD_SUPPLY_PRODUCT_PKEY" PRIMARY KEY (id )
);
