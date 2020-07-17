drop table if exists `t_menu`;

create table `t_menu`(
    `id` int(11) unsigned auto_increment,
    `pid` int(11) unsigned default null,
    `menuName` varchar(20) not null,
    `menuType` smallint(1) default'0' comment'菜单类型，0前台主要菜单，1前台顶部菜单',
    primary key (`id`)
)engine=innodb default charset=utf8;

insert into t_menu values ('1','0', '会员管理','0'),
('2','1','会员列表', '0'),
('3','1','添加会员', '0'),
('4','1','编辑会员','0'),
('5','2','导出惠誉啊','0');