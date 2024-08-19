-- Doctor
"CREATE TABLE IF NOT EXISTS doctors (" + "id VARCHAR(255) PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "phone_number VARCHAR(20) NOT NULL, " +
                    "address VARCHAR(255), " +
                    "role VARCHAR(50) NOT NULL" +
                    ");";

--Patient
-- "CREATE TABLE IF NOT EXISTS patients (" +
                    "id VARCHAR(255) PRIMARY KEY, " +
                    "name VARCHAR(255), " +
                    "phone_number VARCHAR(255), " +
                    "address VARCHAR(255), " +
                    "insurance_info VARCHAR(255)" +
                    ");";