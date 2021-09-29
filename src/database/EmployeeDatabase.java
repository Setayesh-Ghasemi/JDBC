package database;

import office.Employee;

import java.sql.*;

public class EmployeeDatabase extends AccessToDatabase {
    public EmployeeDatabase() throws ClassNotFoundException, SQLException {
    }

    public int addNewEmployee(Employee employee) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("INSERT INTO `organization`.`employee` (`firstName`, `lastName`, `personnelId`," +
                            " `birthday`, `WorkUnitId`) VALUES ('%s', '%s', '%s', '%s', '%o');",
                    employee.getFirstName(), employee.getLastName(), employee.getPersonnelId(), employee.getBirthday(), employee.getUnitId());
            int index = statement.executeUpdate(sqlQuery);
            return index;
        }
        return 0;
    }

    public boolean isEmployeeExists(int id) throws SQLException {
        if (connection != null) {
            String sql = "SELECT * FROM employee WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        }
        return false;
    }

    public int updateEmployee(int id, String newFirstName, String newLastName) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("UPDATE employee SET firsName='%s', lasName='%s' WHERE id=%o",
                    newFirstName, newLastName, id);
            int index = statement.executeUpdate(sqlQuery);
            return index;
        }
        return 0;
    }

    public void employeesInWorkUnit(int unitId) throws SQLException {
        int countToShow = 0;
        if (connection != null) {
            String sql = "SELECT * FROM employee WHERE WorkunitId = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, unitId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id") + ": " + resultSet.getString("firstName") +
                        " " + resultSet.getString("lastName"));
                System.out.println();
                countToShow++;
            }
        }
        if (countToShow == 0)
            System.out.println("error");
    }
}

