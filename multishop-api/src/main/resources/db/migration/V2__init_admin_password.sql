use multimall;

INSERT INTO multimall_sysadmin_role (id, name, `desc`, enabled, add_time, update_time, deleted)
VALUES (1, '超级管理员', '所有模块的权限', 1, '2019-01-01 00:00:00', '2019-01-01 00:00:00', 0);

INSERT INTO multimall_sysadmin_permission(id, role_id, permission, add_time, update_time, deleted)
VALUES (1, 1, '*', '2019-01-01 00:00:00', '2019-01-01 00:00:00', 0);

INSERT INTO `multimall_sysadmin`(id, username, password, last_login_ip, last_login_time, avatar, add_time, update_time,
                                 deleted, role_ids)
VALUES (1, 'admin123', '$2a$10$.rEfyBb/GURD9P2p0fRg/OAJGloGNDkJS4lY0cQHeqDgsbdTylBpu', NULL, NULL,
        'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '2018-02-01 00:00:00',
        '2018-02-01 00:00:00', 0, '[1]');
