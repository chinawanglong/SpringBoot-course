create table `t_role`(
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `rolename` varchar(20) DEFAULT NULL COMMENT '角色名称',
    primary key(`id`)
) ENGINE=InnonDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `t_user`(
    `id` int(11) not null auto_increment,
    `username` varchar(20) not null comment'用户名',
    `password` varchar(20) not null comment'密码',
    `role_id` int(11) default null comment '外键关联role表',
    primary key(`id`),
    key `role_id`(`role_id`),
    CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) engine=innodb auto_increment=1 default charset=utf8;

create table `t_permission`(
    `id` int(11) not null auto_increment,
    `permissionname` varchar(50) not null comment'权限名',
    `role_id` int(11) default null comment'外键关联role',
    primary key(`id`),
    key `role_id`(`role_id`),
    CONSTRAINT `t_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) engine=innodb auto_increment=1 default charset=utf8;

