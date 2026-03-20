-- 1. Create the Clinical Database--

CREATE DATABASE IF NOT EXISTS clinic_db;
USE clinic_db;
SHOW TABLES;

SELECT * FROM screening_results

ORDER BY id DESC;



CREATE TABLE IF NOT EXISTS safety_results (
    id INT AUTO_INCREMENT PRIMARY KEY,         
    patient_id VARCHAR(50) NOT NULL,           
    safety_status VARCHAR(50) NOT NULL,       
    check_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);





