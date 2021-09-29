package database;

import office.Unit;

import java.sql.*;

public class UnitDatabase extends AccessToDatabase {
    public UnitDatabase() throws ClassNotFoundException, SQLException {
    }

    public int addNewUnit(Unit unit) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("INSERT INTO `office`.`unit` (`name`, `phoneNumber`) VALUES ('%s', '%s');",
                    unit.getName(), unit.getPhoneNumber());
            int index = statement.executeUpdate(sqlQuery);
            return index;
        }
        return 0;
    }

    public boolean isUnitExists(int id) throws SQLException {
        if (connection != null) {
            String sql = "SELECT * FROM unit WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        }
        return false;
    }

    public int updateUnit(int id, String newNAme) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("UPDATE unit SET name='%s' WHERE id=%o", newNAme, id);
            int index = statement.executeUpdate(sqlQuery);
            return index;
        }
        return 0;
    }

    public void showUnits() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM unit");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id") + ": " + resultSet.getString("name")
                        + " " + resultSet.getString("phoneNumber"));
                System.out.println();
            }
        }
    }

}

