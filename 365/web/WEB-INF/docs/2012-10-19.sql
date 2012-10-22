--1.系统数据字典表：tbl_SystemDataInfo

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

--2.系统数据字典数据项值：tbl_dataItemsInfo
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
--3.用户信基本息表：tbl_userinfo
CREATE TABLE tbl_userinfo
(
  userid bigint NOT NULL,
  password character varying(255),
  createdate date,
  creator character varying(255),
  effetdate date,
  errornum integer NOT NULL,
  faildate date,
  flag integer NOT NULL,
  locktime date,
  locking integer NOT NULL,
  username character varying(255),
  prelogintime date,
  remarks character varying(255),
  sorts integer NOT NULL,
  updateuser character varying(255),
  updatetime date,
  usertype integer,
  CONSTRAINT tbl_userinfo_pkey PRIMARY KEY (userid )
);
--4.用户角色表：tbl_userrolesinfo
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

--5.组信息表：tbl_groupInfo
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

--6.组角色对应关系表：tbl_groupRolesInfo

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

--7.组内用户表：tbl_groupUser
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

--8.角色信息表：tbl_roleInfo
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

--9.角色具有的权限信息表：tbl_rightsForRolesInfo
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

--10.系统功能菜单模块信息表：tbl_menusInfo
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
--11.角色对应的权限对象信息：tbl_roleDataObjInfo


--11.权限对象表：tbl_dataObjInfo
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


--12.菜单对应的权限对象信息表：tbl_menuObjInfo
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

--14.企业表：tbl_enterprise
CREATE TABLE tbl_enterprise
(
  id bigint NOT NULL,
  name character varying(100),
  website character varying(32),
  address character varying(255),
  phone character varying(255),
  en_type character varying(20),
  personnel_numeric numeric,
  en_synopsis character varying(20),
  email character varying(20),
  found_time date,
  registered_region character varying(100),
  legal_person character varying(20),
  turnover_year character varying(20),
  business_model character varying(20),
  customer_base character varying(20),
  exports_year character varying(20),
  sell_year character varying(20),
  certification_system character varying(20),
  oem character varying(20),
  authenticate numeric,
  creator character varying(20),
  update_user character varying(20),
  update_time date,
  create_time date,
  logo_id bigint,
  user_id bigint,
  main_product character varying(100),
  main_sort character varying(100),
  faxes character varying(255),
  telphone character varying(255),
  homepage character varying(255),
  qq character varying(20),
  linkman character varying(50),
  description character varying(255),
  CONSTRAINT pk_tbl_enterprise PRIMARY KEY (id )
);
--15.企业图片表：tbl_enterprise_image
CREATE TABLE tbl_enterprise_image
(
  id bigint NOT NULL,
  enterprise_id bigint,
  img_name character varying(32),
  img_path character varying(32),
  creator character varying(20),
  update_user character varying(20),
  update_time date,
  create_time date,
  CONSTRAINT pk_tbl_enterprise_image PRIMARY KEY (id )
);

--16.企业联系人表：tbl_enterprise_contact
CREATE TABLE tbl_enterprise_contact
(
  id bigint NOT NULL,
  enterprise_id bigint,
  contact_name character varying(20),
  contact_phone character varying(20),
  creator character varying(20),
  update_user character varying(20),
  update_time date,
  create_time date,
  CONSTRAINT pk_tbl_enterprise_contact PRIMARY KEY (id )
);

--17.企业动态表：tbl_enterprise_news
CREATE TABLE tbl_enterprise_news
(
  id bigint NOT NULL,
  enterprise_id bigint,
  content_title character varying(20),
  news_content character varying(500),
  creator character varying(20),
  update_user character varying(20),
  update_time date,
  create_time date,
  CONSTRAINT pk_tbl_enterprise_news PRIMARY KEY (id )
);

--18.资质证书：tbl_Qualification_Certificate
CREATE TABLE tbl_qualification_certificate
(
  id bigint NOT NULL,
  enterprise_id bigint,
  certificate_type character varying(20),
  certificate_path character varying(20),
  is_certificate numeric,
  creator character varying(20),
  update_user character varying(20),
  update_time date,
  create_time date,
  CONSTRAINT pk_tbl_qualification_certificate PRIMARY KEY (id )
);

--19.商品主数据信息表：spgl_productInfo
CREATE TABLE spgl_productinfo
(
  id bigint NOT NULL,
  product_code character varying(20),
  long_desc character varying(20),
  pro_type character(1),
  brand_id bigint,
  name character varying(40),
  english_name character varying(40),
  units character varying(20),
  output_rate numeric(3,0),
  product_width numeric(10,2),
  product_height numeric(10,2),
  product_type character varying(20),
  is_stored character varying(20),
  stack_height numeric(5,0),
  gross_weight numeric(14,4),
  manufacturer character varying(100),
  remark character varying(600),
  sorts numeric(4,0),
  creator character varying(20),
  update_user character varying(20),
  update_time date,
  create_time date,
  CONSTRAINT pk_spgl_productinfo PRIMARY KEY (id )
);

--20.商品图片信息表：spgl_productPicInfo
CREATE TABLE spgl_productpicinfo
(
  id bigint NOT NULL,
  product_id bigint,
  pic_name character varying(32),
  pic_path character varying(32),
  sorts numeric(4,0),
  creator character varying(20),
  update_user character varying(20),
  update_time date,
  create_time date,
  CONSTRAINT pk_spgl_productpicinfo PRIMARY KEY (id )
);

--21.商品所属品类信息：spgl_productCategory
CREATE TABLE spgl_productcategory
(
  id bigint NOT NULL,
  cate_id numeric(19,2),
  catetype_id numeric(19,2),
  create_time timestamp without time zone,
  creator character varying(20),
  product_id numeric(19,2),
  sorts smallint,
  update_time timestamp without time zone,
  update_user character varying(30),
  CONSTRAINT spgl_productcategory_pkey PRIMARY KEY (id )
);

--22.商品扩展属性值表：spgl_productAttrValue
CREATE TABLE spgl_productattrvalue
(
  id bigint NOT NULL,
  product_id character varying(32) NOT NULL,
  category_attrid character varying(32) NOT NULL,
  attrvalues character varying(200) NOT NULL,
  sorts numeric(4,0) NOT NULL,
  creator character varying(20),
  update_user character varying(30),
  create_time timestamp without time zone,
  update_time timestamp without time zone,
  CONSTRAINT "SPGL_PRODUCTATTRVALUE_PKEY" PRIMARY KEY (id )
);

--23.商品规格信息表：spgl_productSpecInfo
CREATE TABLE "spgl_productSpecInfo"
(
  id bigint NOT NULL,
  product_id character varying(32) NOT NULL,
  spec character varying(40) NOT NULL,
  sorts numeric(4,0) NOT NULL,
  creator character varying(20),
  update_user character varying(30),
  create_time timestamp without time zone,
  update_time timestamp without time zone,
  CONSTRAINT "SPGL_PRODUCTSPECINFO_PKEY" PRIMARY KEY (id )
);

--24.品牌信息表：pp_brandInfo
CREATE TABLE "pp_brandInfo"
(
  id bigint NOT NULL,
  pcode character varying(6) NOT NULL,
  name character varying(40) NOT NULL,
  brandcode character varying(6) NOT NULL,
  ename character varying(40),
  logopic character varying(200) NOT NULL,
  remark character varying(600),
  sorts numeric(4,0) NOT NULL,
  creator character varying(20),
  update_user character varying(30),
  create_time timestamp without time zone,
  update_time timestamp without time zone,
  CONSTRAINT "PP_BRANDINFO_PKEY" PRIMARY KEY (id )
);

--25.品类类型信息表：sppl_CategoryTypeInfo
CREATE TABLE "sppl_CategoryTypeInfo"
(
  id bigint NOT NULL,
  name character varying(40) NOT NULL,
  code character varying(6) NOT NULL,
  is_used boolean NOT NULL,
  is_std boolean NOT NULL,
  description character varying(400),
  remark character varying(600),
  creator character varying(20),
  update_user character varying(30),
  create_time timestamp without time zone,
  update_time timestamp without time zone,
  CONSTRAINT "SPPL_CATEGORYTYPEINFO_PKEY" PRIMARY KEY (id )
);

--26.品类信息表：sppl_CategoryInfo
CREATE TABLE "sppl_CategoryInfo"
(
  id bigint NOT NULL,
  category_type_id character varying(32) NOT NULL,
  pcode character varying(12) NOT NULL,
  name character varying(40) NOT NULL,
  code character varying(12) NOT NULL,
  description character varying(400),
  attrtype numeric(1,0) NOT NULL,
  remark character varying(600),
  sorts numeric(4,0) NOT NULL,
  creator character varying(20),
  update_user character varying(30),
  create_time timestamp without time zone,
  update_time timestamp without time zone,
  CONSTRAINT "SPPL_CATEGORYINFO_PKEY" PRIMARY KEY (id )
);

--27.品类扩展属性表：sppl_CategoryAttrInfo
CREATE TABLE sppl_categoryattrinfo
(
  id bigint NOT NULL,
  category_id character varying(32) NOT NULL,
  attrname character varying(40) NOT NULL,
  attrtype character varying(2) NOT NULL,
  required boolean NOT NULL,
  display boolean NOT NULL,
  disporder numeric(4,0) NOT NULL,
  sorts numeric(4,0) NOT NULL,
  creator character varying(20),
  update_user character varying(30),
  create_time timestamp without time zone,
  update_time timestamp without time zone,
  CONSTRAINT "SPPL_CATEGORYATTRINFO_PKEY" PRIMARY KEY (id )
);

--28.品类扩展属性域值表：sppl_CateAttrRVInfo
CREATE TABLE sppl_cateattrrvinfo
(
  id bigint NOT NULL,
  cateattr_id bigint NOT NULL,
  range_code character varying(8) NOT NULL,
  range_desc character varying(60) NOT NULL,
  sorts numeric(4,0) NOT NULL,
  status numeric(1,0) NOT NULL,
  creator character varying(20),
  update_user character varying(30),
  create_time timestamp without time zone,
  update_time timestamp without time zone,
  CONSTRAINT "sppl_cateattrrvinfo_PKEY" PRIMARY KEY (id )
);

--29.供应商品表: sad_supplyProduct
CREATE TABLE sad_supply_product
(
  id bigint NOT NULL,
  category_id_path character varying(60),
  category_name_path character varying(100),
  create_time timestamp without time zone,
  creator character varying(20),
  description character varying(255),
  description_segmentation character varying(255),
  enterprise_id numeric(19,2),
  information_valid_date timestamp without time zone,
  inventory_amount bigint,
  min_order_amount bigint,
  passed boolean,
  pcp_services integer,
  pricing_type character varying(32),
  product_id numeric(19,2),
  product_name character varying(50),
  product_name_segmentation character varying(255),
  sorts integer,
  status integer,
  update_time timestamp without time zone,
  update_user character varying(30),
  CONSTRAINT sad_supply_product_pkey PRIMARY KEY (id )
);
--30:供应产品价格表:sad_ supplyProductPrict
CREATE TABLE sad_supply_productprice
(
  id bigint NOT NULL,
  create_time timestamp without time zone,
  creator character varying(50),
  ent_num integer,
  num_type_price numeric(19,2),
  spe_stock_quantity numeric(19,2),
  specifications integer,
  specifications_price numeric(19,2),
  start_num integer,
  supply_product_id bigint,
  update_time timestamp without time zone,
  update_user character varying(50),
  CONSTRAINT sad_supply_productprice_pkey PRIMARY KEY (id )
);

--31:求购信息表:sad_buyProduct
CREATE TABLE sad_buy_product
(
  buy_product_id bigint NOT NULL,
  buy_title character varying(50), -- 求购标题
  buy_product character varying(50), -- 求购产品名称
  category_id bigint NOT NULL, -- 所属品类
  buy_num integer, -- 求购数量
  buy_typee integer, -- 求购类型
  buy_scale integer, -- 求购数量规模
  information_date date, -- 信息有效期-默认一个月
  more_information text, -- 求购详细信息
  is_system_suppliers bigint, -- 是否同意系统发布给供应商
  enterprise_id bigint, -- 企业ID
  creator character varying(50),
  update_user character varying(50),
  update_time date,
  create_time date,
  CONSTRAINT sad_buy_product_pkey PRIMARY KEY (buy_product_id )
);

--32:求购信息图片表:sad_buyProductPic
CREATE TABLE sad_buy_product_picture
(
  buy_product_pic_id bigint NOT NULL,
  pic_name character varying(50), -- 图片名称
  pic_path character varying(100), -- 图片路径
  buy_product_id bigint NOT NULL, -- 求购信息ID
  creator character varying(50),
  update_user character varying(50),
  update_time timestamp without time zone,
  create_time timestamp with time zone,
  CONSTRAINT sad_buy_product_picture_pkey PRIMARY KEY (buy_product_pic_id )
);

--33:求购报价表:sad_bugProductPrict
CREATE TABLE sad_buy_product_price
(
  buy_product_price_id bigint NOT NULL,
  buy_product_id bigint NOT NULL, -- 供应信息ID
  price numeric(10,2), -- 报价
  product_name character varying(50), -- 产品名称
  product_advantages character varying(100), -- 产品优势说明
  product_price numeric(10,2), -- 产品价格
  description character varying(100), -- 详细说明
  enterprise_id bigint, -- 企业ID
  creator character varying(50), -- 创建人
  update_user character varying(50), -- 修改人
  update_time timestamp with time zone, -- 修改时间
  create_time timestamp with time zone, -- 创建时间
  CONSTRAINT sad_buy_product_price_pkey PRIMARY KEY (buy_product_price_id )
);



--38.进货单: shipping_list
CREATE TABLE shipping_list
(
  shipping_list_id bigint NOT NULL,
  supply_product_id bigint NOT NULL, -- 供应id
  user_id bigint, -- 用户ID
  add_time timestamp with time zone, -- 加入购物车时间
  creator character varying(50), -- 创建人
  update_time timestamp with time zone, -- 修改时间
  create_time timestamp with time zone, -- 创建时间
  CONSTRAINT shipping_list_pkey PRIMARY KEY (shipping_list_id )
);

--39.物流公司表：logistics_companies


--42.招商信息:merchants_Info
CREATE TABLE merchants_info
(
  merchants_info_id bigint NOT NULL,
  merchants_title character varying(100), -- 招商标题
  merchants_type integer, -- 招商类别
  merchants_area character varying(100), -- 招商区别
  end_time timestamp without time zone, -- 截止日期
  description character varying(100), -- 详细说明
  product_package character varying(100), -- 产品包装
  product_spe character varying(100), -- 产品规格
  creator character varying(50), -- 创建人
  update_user character varying(50), -- 修改人
  update_time timestamp without time zone, -- 修改时间
  create_time timestamp without time zone, -- 创建时间
  CONSTRAINT merchants_info_pkey PRIMARY KEY (merchants_info_id )
);
--43.招商图片:merchants_pic
CREATE TABLE merchants_picture
(
  merhante_picture_id bigint NOT NULL,
  merchants_info_id bigint NOT NULL, -- 招商信息ID
  merchants_path character varying(100), -- 图片路径
  creator character varying(50), -- 创建人
  update_user character varying(50), -- 修改人
  update_time timestamp without time zone, -- 修改时间
  create_time timestamp without time zone, -- 创建时间
  CONSTRAINT merchants_picture_pkey PRIMARY KEY (merhante_picture_id )
);

--44.加工信息: machining_Info
CREATE TABLE machining_info
(
  machining_info_id bigint NOT NULL,
  machining_title character varying(100), -- 加工标题
  machining_type integer, -- 加工类别
  machining_equipment character varying(50), -- 加工设备
  processing_capability character varying(100), -- 加工能力
  description character varying(200), -- 详细说明
  creator character varying(50), -- 创建人
  update_user character varying(50), -- 修改人
  update_time timestamp without time zone, -- 修改时间
  create_time timestamp without time zone, -- 创建时间
  CONSTRAINT machining_info_pkey PRIMARY KEY (machining_info_id )
);

--45.加工图片: machining _Pic
CREATE TABLE machining_picture
(
  machining_pic_id bigint NOT NULL,
  merchants_info_id bigint NOT NULL, -- 加工信息ID
  machining_path character varying(100), -- 图片路径
  creator character varying(50), -- 创建人
  update_user character varying(50),
  update_time timestamp without time zone, -- 修改时间
  create_time timestamp without time zone, -- 修改时间
  CONSTRAINT machining_picture_pkey PRIMARY KEY (machining_pic_id )
);

--46.询盘信息：inquiry_info    (11)
CREATE TABLE inquiry_info
(
  inquiry_id bigint NOT NULL,
  content_id bigint NOT NULL, -- 被询盘加工\招商\求购ID
  inquiry_type integer, -- 询盘类型
  inquiry_title character varying(50), -- 询盘标题
  inquiry_content character varying(200), -- 询盘内容
  questioner_id bigint NOT NULL, -- 询盘者ID
  answer_id bigint, -- 询盘回复
  reply character varying(200), -- 回复内容
  creator character varying(50), -- 提问者
  update_user character varying(50), -- 修改人
  update_time time without time zone, -- 修改时间
  create_time timestamp without time zone, -- 创建时间
  CONSTRAINT inquiry_info_pkey PRIMARY KEY (inquiry_id )
);

--56.行业资讯：industry_news
CREATE TABLE industry_news
(
  industry_news_id bigint NOT NULL, -- 行业资讯
  news_type integer, -- 资讯类型
  news_title character varying(100), -- 资讯标题
  news_content character varying(200), -- 资讯内容
  creator character varying(50), -- 创建人
  update_user character varying(50), -- 修改人
  update_time timestamp without time zone, -- 修改时间
  create_time timestamp without time zone, -- 创建时间
  CONSTRAINT industry_news_pkey PRIMARY KEY (industry_news_id )
);

--57.行业资讯图片：industry_newsPic
CREATE TABLE industry_news_picture
(
  industry_news_picture_id bigint NOT NULL, -- 行业资讯图片
  picture_name character varying(20), -- 图片名称
  picture_pah character varying(100), -- 图片路径
  description character varying(200), -- 描述
  creator character varying(50),
  update_user character varying(50),
  update_time timestamp without time zone,
  create_time timestamp without time zone,
  CONSTRAINT industry_news_picture_pkey PRIMARY KEY (industry_news_picture_id )
);

--58.展会信息: exhibition_info
CREATE TABLE exhibition_info
(
  exhibition_id bigint NOT NULL, -- 展会信息
  exhibition_time timestamp without time zone, -- 展会时间
  exhibition_area character varying[], -- 展会地点
  exhibiton_title character varying(100), -- 展会标题
  exhibition_content character varying(200), -- 展会内容
  creator character varying(50),
  update_user character varying(50),
  update_time timestamp without time zone,
  create_time timestamp without time zone,
  CONSTRAINT exhibition_info_pkey PRIMARY KEY (exhibition_id )
);

--57.展会信息图片：exhibition_pic

CREATE TABLE exhibition_picture
(
  exhibition_picture_id bigint NOT NULL,
  picture_name character varying(50), -- 图片名称
  picture_path character varying(100), -- 图片路径
  description character varying(200),
  creator character varying(50),
  update_user character varying(50),
  update_time timestamp without time zone,
  create_time timestamp without time zone,
  CONSTRAINT exhibition_picture_pkey PRIMARY KEY (exhibition_picture_id )
);
