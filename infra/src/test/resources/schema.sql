CREATE TABLE IF NOT EXISTS transaction (
  id INT AUTO_INCREMENT PRIMARY KEY,
  kind VARCHAR(10) NOT NULL COMMENT 'BUY, SELL',
  state VARCHAR(10) NOT NULL COMMENT 'WAITING(대기중), COMPLETE(완료), CANCEL(취소)',
  quantity INT NOT NULL COMMENT '주문 수량',
  price DECIMAL(12, 4) NOT NULL,
  user_id INT NOT NULL,
  stock_id VARCHAR(45) NOT NULL COMMENT '주식 id',
  order_no VARCHAR(100) NOT NULL COMMENT '주문번호(증권사 발급)',
  modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS stock (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name_kr_abbreviation VARCHAR(50) NOT NULL COMMENT '한글 종목명 (약어)',
  name_kr VARCHAR(100) NOT NULL COMMENT '한글 종목명',
  name_en VARCHAR(100) NOT NULL COMMENT '영문 종목명',
  code VARCHAR(30) NOT NULL COMMENT '단축코드',
  standard_code VARCHAR(30) NOT NULL COMMENT '표준코드',
  market VARCHAR(15) NULL COMMENT '시장 구분(kospi, kosdaq)',
  country VARCHAR(30) NOT NULL COMMENT '국가',
  modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '등록일'
);