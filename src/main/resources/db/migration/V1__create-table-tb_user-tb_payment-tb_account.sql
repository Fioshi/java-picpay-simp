CREATE TABLE tb_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255) NOT NULL,
    type_user ENUM('COMMON', 'LOGISTICIAN'),
    CONSTRAINT cpf_unique UNIQUE (cpf),
    CONSTRAINT email_unique UNIQUE (email)
);

CREATE TABLE tb_account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    balance DECIMAL(19, 2) NOT NULL,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE CASCADE
);

CREATE TABLE tb_payment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    value DOUBLE NOT NULL,
    payer_id BIGINT,
    payee_id BIGINT,
    FOREIGN KEY (payer_id) REFERENCES tb_account(id),
    FOREIGN KEY (payee_id) REFERENCES tb_account(id)
);
