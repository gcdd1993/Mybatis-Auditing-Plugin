CREATE DATABASE sample_db;
CREATE TABLE sample_user
(
    id            serial      NOT NULL
        CONSTRAINT sample_user_pk PRIMARY KEY,
    username      text        NOT NULL,
    password      text        NOT NULL,
    age           integer     NOT NULL,
    created_by    text        NOT NULL,
    create_date   timestamptz NOT NULL,
    modified_by   text        NOT NULL,
    modified_date timestamptz NOT NULL
);

CREATE INDEX sample_user_ix_modified_date ON sample_user (modified_date);

COMMENT ON TABLE sample_user IS '示例用户';
COMMENT ON COLUMN sample_user.username IS '用户名';
COMMENT ON COLUMN sample_user.password IS '密码';
COMMENT ON COLUMN sample_user.created_by IS '创建人';
COMMENT ON COLUMN sample_user.create_date IS '创建时间';
COMMENT ON COLUMN sample_user.modified_by IS '修改人';
COMMENT ON COLUMN sample_user.modified_date IS '修改时间';