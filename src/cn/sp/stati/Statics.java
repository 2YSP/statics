package cn.sp.stati;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * Created by 2YSP on 2017/8/20.
 */
public class Statics {
    private static  final String URL = "jdbc:mysql://localhost:3306/urun?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
    private static  final String USERNAME = "root";
    private static  final String PASSWORD = "1234";//app@uparty.cn
    private static  final String DRIVERNAME = "com.mysql.jdbc.Driver";

    public static void main(String[] args) throws  Exception{
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.add(Calendar.DAY_OF_MONTH,-1);
//        Date sun = calendar.getTime();
//        calendar.add(Calendar.DAY_OF_MONTH,-6);
//        Date mon = calendar.getTime();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String startDate = sdf.format(mon);
//        String endDate = sdf.format(sun)+" 23:59:59";
        String startDate = "2017-10-01";
        String endDate = "2017-10-31 23:59:59";
        String result = test(startDate, endDate);
        System.out.println(result);
//        MailSender mailSender = new MailSender(result);
//        mailSender.addReceiver("1101044005@qq.com");
//        mailSender.sendToAll();

    }

    public static  String test(String startDate,String endDate)throws  Exception{
        System.out.println("===============查询开始");
        Class.forName(DRIVERNAME);
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = con.createStatement();
        String sql = "SELECT DISTINCT(uid) FROM fitness_data WHERE created_time BETWEEN '"+startDate+"' AND '"+endDate+"' and duration > 1 ORDER BY data_id ;";

        ResultSet rs = statement.executeQuery(sql);

        List<Integer> uidList = new ArrayList<>();
        while (rs.next()){
            int uid = rs.getInt("uid");
            uidList.add(uid);
        }

        rs.close();
        List<Result> list = new LinkedList<>();
        ResultSet resultSet = null;
        for(Integer id :uidList){
            Result result = new Result();
            result.setUid(id);

            String sql2 = "SELECT COUNT(DISTINCT(DATE_FORMAT(created_time,'%y%m%d')))  AS num " +
                    "  FROM fitness_data WHERE uid = "+id+"  AND " +
                    "  created_time BETWEEN '"+startDate+"' AND '"+endDate+"' and duration > 1 ";
            Statement stat = con.createStatement();
            resultSet = stat.executeQuery(sql2);

            while (resultSet.next()){
                int count = resultSet.getInt("num");

                result.setCount(count);
            }
            list.add(result);
        }

        if (resultSet != null){
            resultSet.close();
        }

        con.close();
        System.out.println("===============查询完毕");
        //用户到店频次（1次到店、2次到店、3次到店、4次及以上的）
        int oneTimes = 0;
        int twoTimes = 0;
        int threeTimes = 0;
        int moreTimes = 0;
        int count = 0;
        for(Result r :list){
            if (r.getCount() == 1){
                ++oneTimes;
            }else if (r.getCount() == 2){
                ++twoTimes;
            }else if (r.getCount() == 3){
                ++threeTimes;
            }else if (r.getCount() >= 4){
                ++moreTimes;
            }
            count =count + r.getCount();
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\n用户到店频次1次到店:"+oneTimes);
        sb.append("\n用户到店频次2次到店:"+twoTimes);
        sb.append("\n用户到店频次3次到店:"+threeTimes);
        sb.append("\n用户到店频次4次及以上的:"+moreTimes);
        return sb.toString();
    }

}
