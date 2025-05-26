package jdbcTest;

import java.sql.*;

public class SQLServerJTDSTestConnection {
    public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
        return SQLServerJTDSConnUtils.getSQLServerConnection();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Get connection... ");

        // Lấy ra đối tượng Connection kết nối vào database.
        Connection conn = SQLServerJTDSTestConnection.getMyConnection();

        System.out.println("Opened connection: " + conn);

        Statement statement = conn.createStatement();

        String sql = "SELECT * FROM [DbAutoTesting].[dbo].[BRANCH];";

        String insertSql = "INSERT INTO [dbo].[BRANCH] ([ADDRESS],[CITY],[NAME],[STATE],[ZIP_CODE]) VALUES ('25 Le Loi', 'Da nang','Honda', 'DN', '55000')";

        String paramSql = "Select emp.Emp_Id, emp.First_Name, emp.Title, emp.Dept_Id from " +
                "[DbAutoTesting].[dbo].[EMPLOYEE] emp where emp.Title like ? and emp.Dept_Id = ?";

        // int rowCount = statement.executeUpdate(insertSql);
        // System.out.println("Row Count affected = " + rowCount);

        // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        // ResultSet rs = statement.executeQuery(sql);

        PreparedStatement pstm = conn.prepareStatement(paramSql);
        pstm.setString(1,"%ent");
        pstm.setInt(2,3);

        ResultSet rs = pstm.executeQuery();

        // Duyệt trên kết quả trả về
        while (rs.next()) {
            // Di chuyển con trỏ xuống bản ghi kế tiếp.

            /*String empFirstName = rs.getString(1);
            String empLastName = rs.getString("NAME");
            System.out.println("--------------------");
            System.out.println("Emp Firstname:" + empFirstName);
            System.out.println("Emp Lastname:" + empLastName);*/


            /*System.out.println(rs.getInt("BRANCH_ID"));
            System.out.println(rs.getString("ADDRESS"));
            System.out.println(rs.getString("CITY"));
            System.out.println(rs.getString("NAME"));
            System.out.println(rs.getString("STATE"));
            System.out.println(rs.getString("ZIP_CODE"));*/

            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getInt(4));

        }
        // Đóng kết nối
        conn.close();
        System.out.println("---------- Closed connection ----------");
    }
}
