Bank application
Data base name: bank_customers
user_info table:
CREATE TABLE UserTable (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_fullname VARCHAR(255) NOT NULL,
    phone_no VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL,
    user_address VARCHAR(255) NOT NULL
);
alter table UserTable rename to User_info;

bank_account table:
CREATE TABLE Bank_Account (
    accountID INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) ,
    bank_account_no VARCHAR(20) ,
    bank_name VARCHAR(255),
    IFSC_code VARCHAR(11),
    account_type VARCHAR(50),
    current_balance DECIMAL(10, 2),
    FOREIGN KEY (username) REFERENCES user_info(username)
);

transactions table:
CREATE TABLE transactions (
    txnId INT PRIMARY KEY AUTO_INCREMENT,
    txnDateTime TIMESTAMP,
    txnAmount DOUBLE,
    txnType VARCHAR(50),
    txnStatus VARCHAR(50),
    sourceAcctId INT,
    targetAcctId INT,
    FOREIGN KEY (sourceAcctId) REFERENCES bank_account(accountID),
    FOREIGN KEY (targetAcctId) REFERENCES bank_account(accountID)
);
