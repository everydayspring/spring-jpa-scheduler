CREATE TABLE todo (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    user_name VARCHAR(50) NOT NULL COMMENT '작성 유저명',
    title VARCHAR(255) NOT NULL COMMENT '할일 제목',
    content TEXT NOT NULL COMMENT '할일 내용',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '작성일',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
);

CREATE TABLE comment (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    content TEXT NOT NULL COMMENT '댓글 내용',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '작성일',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일',
    user_name VARCHAR(50) NOT NULL COMMENT '작성 유저명',
    todo_id INT NOT NULL COMMENT 'TODO_ID',
    FOREIGN KEY (todo_id) REFERENCES Todo(id) ON DELETE CASCADE
);


