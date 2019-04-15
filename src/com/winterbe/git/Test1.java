package com.winterbe.git;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sd-wangtaicheng@sdcncsi.com.cn
 * @date 2018/3/29
 */
public class Test1 {
    static Connection conn = null;

    public static void main(String[] args) {
        init();
        fun("0", 1, 1, 1);
    }

    public static void init() {
        String url = "jdbc:mysql://10.0.210.98:3309/wtc_html?useUnicode=true&characterEncoding=utf8" +
                "&characterSetResults" +
                "=utf8&tinyInt1isBit=false";
        String driverClass = "com.mysql.jdbc.Driver";
        String username = "mysql";
        String password = "hr123!@#";
        Statement ps = null;
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void fun(String id, int l, int m, int r) {

        List<Map<String, String>> list = query(id);

        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, String> map = list.get(i);
                String pid = map.get("id");
                fun(pid, l, m, r);
                System.out.println(String.format("id=%s,l=%s,m=%s,r=%s", id, l, m, r));
            }
        } else {
            System.out.println(String.format("id=%s,l=%s,m=%s,r=%s", id, l, m, r));
            // update(id,l,m,r);
        }
    }

    public static List<Map<String, String>> query(String id) {
        try {
            String sql = "select id,pid from demo1 where pid=" + id;
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            List<Map<String, String>> list = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    Map<String, String> m = new HashMap<>();
                    m.put("id", rs.getString("id"));
                    m.put("pid", rs.getString("pid"));
                    list.add(m);
                }
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void update(String id, int l, int m, int r) {
        try {
            String sql = String.format("update demo1 set l=%s,m=%s,r=%s where pid=%s", l, m, r, id);
            Statement ps = conn.createStatement();
            ps.executeUpdate(sql);
        } catch (Exception e) {

        }

    }
}
