package tool;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName MyTypeHandler
 * @Description 类的描述
 * @Author 萌白
 * @Date 2019/7/16 11:39
 * @Version 1.0
 */
public class MyTypeHandler implements TypeHandler<String> {

    Logger logger = Logger.getLogger(MyTypeHandler.class);

    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        logger.info("设置String参数>>>" + parameter  + " ps >>> " + ps + " int >>> " + i + " jdbcType >>> " + jdbcType);
        ps.setString(i, parameter);
    }

    public String getResult(ResultSet rs, String columnName) throws SQLException {
        String result = rs.getString(columnName);
        logger.info("读取String参数1 >>> " + result + " rs >>> " + rs + " columnName >>> " + columnName);
        return result;
    }

    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        String result = rs.getString(columnIndex);
        logger.info("读取String参数2[" + result + "]");
        return result;
    }

    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String result = cs.getString(columnIndex);
        logger.info("读取String参数3[" + result + "]");
        return result;
    }
}
