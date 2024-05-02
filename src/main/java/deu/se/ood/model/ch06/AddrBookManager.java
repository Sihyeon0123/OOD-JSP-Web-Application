package deu.se.ood.model.ch06;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AddrBookManager {
    private String mysqlServerIp;
    private String mysqlServerPort;
    private String username;
    private String password;
    private String jdbcDriver;

    public AddrBookManager() {
        log.debug("AddressBookManager(): mysqlServerIp: " + mysqlServerIp + ", mysqlServerPort: " + mysqlServerPort + "jdbcDriver: " + jdbcDriver);
    }

    public AddrBookManager(String mysqlServerIp, String mysqlServerPort, String jdbcDriver, String username, String password) {
        this.mysqlServerIp = mysqlServerIp;
        this.mysqlServerPort = mysqlServerPort;
        this.jdbcDriver = jdbcDriver;
        this.username = username;
        this.password = password;
        log.debug("AddressBookManager(): mysqlServerIp: " + mysqlServerIp + ", mysqlServerPort: " + mysqlServerPort + "jdbcDriver: " + jdbcDriver);
    }

    public List<AddrBookRow> getAllRows(){
        List<AddrBookRow> dataList = new ArrayList<>();
        final String JDBC_URL = String.format("jdbc:mysql://%s:%s/webmail?serverTimezone=Asia/Seoul", mysqlServerIp, mysqlServerPort);
        log.debug("AddressBookManager(): JDBC URL: " + JDBC_URL + "mysqlServerIp: " + mysqlServerIp + " jdbcDriver: " + jdbcDriver);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(JDBC_URL, username, password);
            stmt = conn.createStatement();

            String sql = "SELECT email, name, phone FROM addrbook";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String email = rs.getString("email");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                dataList.add(new AddrBookRow(email, name, phone));
                // builder 패턴 적용시
//                dataList.add(AddrBookRow.builder()
//                                        .email(email)
//                                        .name(name)
//                                        .phone(phone)
//                                        .build());
            }

            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        return dataList;
    }

    public void addRow(String email, String name, String phone) {
        final String JDBC_URL = String.format("jdbc:mysql://%s:%s/webmail?serverTimezone=Asia/Seoul", mysqlServerIp, mysqlServerPort);

        log.debug("JDBC_URL(): " + JDBC_URL);

        // try 를 사용하여 명시적으로 close 하지 않아도 객체가 반환된다.
        try( Connection conn = DriverManager.getConnection(JDBC_URL, username, password) ){
            String sql = "INSERT INTO addrbook VALUES(?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, email);
                pstmt.setString(2, name);
                pstmt.setString(3, phone);

                int result = pstmt.executeUpdate();
                log.debug("변경된 행: " + result);
            }
        } catch (Exception e){
            log.error("오류가 발생하였습니다. (발생 오류: {})", e.getMessage());
        }


//        Connection conn = null;
//        ResultSet rs = null;
//
//        try{
//            Class.forName(jdbcDriver);
//            conn = DriverManager.getConnection(JDBC_URL, this.username, this.password);
//            String sql = "INSERT INTO addrbook VALUES(?, ?, ?)";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, email);
//            pstmt.setString(2, name);
//            pstmt.setString(3, phone);
//            pstmt.executeUpdate();
//
//            if (pstmt != null) pstmt.close();
//            if (conn != null) conn.close();
//        } catch (Exception e) {
//            log.error("오류가 발생하였습니다. (발생 오류: {})", e.getMessage());
//        }
    }

    public void deleteRow(String email) {
        final String JDBC_URL = String.format("jdbc:mysql://%s:%s/webmail?serverTimezone=Asia/Seoul", mysqlServerIp, mysqlServerPort);

        log.debug("JDBC_URL(): " + JDBC_URL);
        Connection conn = null;
        ResultSet rs = null;

        try{
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(JDBC_URL, this.username, this.password);
            String sql = "DELETE FROM addrbook WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.executeUpdate();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e){
            log.error("오류가 발생하였습니다. (발생 오류: {})", e.getMessage());
        }
    }
}
