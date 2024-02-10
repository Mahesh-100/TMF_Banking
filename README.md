#Bank application: Using Servlets and jsp
<-------------------------->
Data base name: bank_customers
user_info table:
CREATE TABLE User_info (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_fullname VARCHAR(255) NOT NULL,
    phone_no VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL,
    user_address VARCHAR(255) NOT NULL
);

<----------------------------------------->
bank_account table:
CREATE TABLE Bank_Account (
    accountID INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) ,
    bank_account_no VARCHAR(20) unique,
    bank_name VARCHAR(255),
    IFSC_code VARCHAR(11),
    account_type VARCHAR(50),
    current_balance DECIMAL(10, 2),
    FOREIGN KEY (username) REFERENCES user_info(username)
);
<--------------------------------------------->
CREATE TABLE transactions (
    transactionID INT PRIMARY KEY AUTO_INCREMENT,
    sourceAcctID INT,
    targetAcctID INT,
    amount DECIMAL(10, 2),
    transactionType VARCHAR(10),
    transactionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
 
