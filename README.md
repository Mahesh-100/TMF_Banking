#Bank application: Required Tables


CREATE TABLE User_info (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_fullname VARCHAR(255) NOT NULL,
    phone_no VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL,
    user_address VARCHAR(255) NOT NULL
);

CREATE TABLE bank_info (
    accountID INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(255) not null,
    bank_account_no VARCHAR(20) not null unique,
    bank_name VARCHAR(255) not null,
    IFSC_code VARCHAR(11) not null,
    account_type VARCHAR (50) not null ,
    current_balance DECIMAL(10, 2) not null 
    );
    
CREATE TABLE transaction_info (
    transactionID INT PRIMARY KEY AUTO_INCREMENT,
    sourceAcctID INT,
    targetAcctID INT,
    amount DECIMAL(10, 2),
    transactionType VARCHAR(50),
    transactionDate Date
);
 
