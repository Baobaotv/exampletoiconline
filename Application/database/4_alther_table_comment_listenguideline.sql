
alter table  comment add column roleid bigint;

alter table comment add constraint fk_comment_user foreign key (userid) references user(id);

alter table comment add constraint fk_comment_listenguideline foreign key (listenguidelineid) references listenguideline(id);