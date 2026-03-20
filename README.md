
            
 # 🛡️ SafeScan V2: Student Project IST5001


🏥 Project Overview

The Clinic Management System is a specialized Java Swing application designed for medical environments. It features a high-contrast "Clinical Dark Mode" UI and a robust safety screening logic to determine patient eligibility for MRI procedures.
🚀 Key Features
Safety Results: Patient history is checked automatically to show a clear RED, YELLOW, or GREEN safety result.

    UI Design: The interface was built using professional medical colors (forest green and khaki) and integrated hospital branding.

    Database Storage: All screening results are saved to a MySQL database using JDBC, ensuring a permanent record is kept for every check.

    Project Tracking: The development process was managed and documented using Git and GitHub to track every version of the code.

🛠️ Tech Stack

    Language: Java (JDK 17+)
    GUI Framework: Java Swing / AWT
    Database: MySQL 8.0
    Driver: JDBC (com.mysql.cj.jdbc.Driver)

🗄️ Database Setup

To recreate the backend, execute the provided src/db_setup.sql script in your MySQL environment:

    Open MySQL Workbench.
    Load and run db_setup.sql.
    Ensure your local DatabaseManager.java credentials match your MySQL server.

👥 Contributors

    Costantinus - Lead Developer (UI, Logic, & Integration)
    Panagiotis - Database Architect
    Paraskevas - QA Tester
===

## 🏥 Project Overview
The Clinic Management System is a specialized Java Swing application designed for medical environments. It features a high-contrast "Clinical Dark Mode" UI and a robust safety screening logic to determine patient eligibility for MRI procedures.

# 🚀 Key Features
* **Automated Safety Logic:** Processes patient medical history to generate immediate "RED," "YELLOW," or "GREEN" safety clearances.
* **Branded GUI:** Customized interface with clinical forest-green/khaki branding and hospital asset integration.
* **SQL Persistence:** Full JDBC integration with MySQL to maintain a permanent, timestamped audit trail of all safety checks.
* **Version Control:** Managed via Git with a clean, documented commit history.

## 🛠️ Tech Stack
* **Language:** Java (JDK 17+)
* **GUI Framework:** Java Swing / AWT
* **Database:** MySQL 8.0
* **Driver:** JDBC (com.mysql.cj.jdbc.Driver)

## 🗄️ Database Setup
To recreate the backend, execute the provided `src/db_setup.sql` script in your MySQL environment:
1. Open MySQL Workbench.
2. Load and run `db_setup.sql`.
3. Ensure your local `DatabaseManager.java` credentials match your MySQL server.

## 👥 Contributors
* **Costantinus** - Lead Developer (UI, Logic, & Integration)
* **Panagiotis** - Database Architect
* **Paraskevas** - QA Tester
