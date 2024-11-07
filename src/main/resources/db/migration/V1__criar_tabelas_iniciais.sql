-- Cria tabela Contato
CREATE TABLE TB_DICIOFUT_CONTATO (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    telefone_fixo VARCHAR(20) NOT NULL,
    telefone_celular VARCHAR(20) NOT NULL
);

-- Cria tabela Endereco
CREATE TABLE TB_DICIOFUT_ENDERECO (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cep VARCHAR(10) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(50) NOT NULL
);

-- Cria tabela Documentos
CREATE TABLE TB_DICIOFUT_DOCUMENTOS (
    id_documento BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_documento VARCHAR(255) NOT NULL,
    tipo_documento VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    data_emissao DATE NOT NULL,
    data_validade DATE,
    url_documento VARCHAR(255) NOT NULL,
    id_empresa BIGINT NOT NULL
);

-- Cria tabela Login
CREATE TABLE TB_DICIOFUT_LOGIN (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    ativo BOOLEAN NOT NULL,
    ultima_tentativa_login TIMESTAMP,
    ultimo_login TIMESTAMP
);

-- Cria tabela Cadastro
CREATE TABLE TB_DICIOFUT_CADASTRO (
    id_usuario BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_nascimento VARCHAR(10) NOT NULL,
    cargo VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    contato_id BIGINT,
    endereco_id BIGINT,
    documentos_id BIGINT,
    login_id BIGINT,
    FOREIGN KEY (contato_id) REFERENCES TB_DICIOFUT_CONTATO(id),
    FOREIGN KEY (endereco_id) REFERENCES TB_DICIOFUT_ENDERECO(id),
    FOREIGN KEY (documentos_id) REFERENCES TB_DICIOFUT_DOCUMENTOS(id_documento),
    FOREIGN KEY (login_id) REFERENCES TB_DICIOFUT_LOGIN(id)
);
