package tool;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;
import pojo.SexEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName SexEnumTypeHandler
 * @Description 类的描述
 * @Author 萌白
 * @Date 2019/7/16 15:20
 * @Version 1.0
 */
//@MappedTypes(SexEnum.class)
//@MappedJdbcTypes(JdbcType.VARCHAR)
public class SexEnumTypeHandler implements TypeHandler<SexEnum> {
    Logger logger = Logger.getLogger(SexEnumTypeHandler.class);

    @Override
    public void setParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        logger.info("i >>>" + i + "parameter >>> " + parameter);
        ps.setInt(i, parameter.getId());
    }

    @Override
    public SexEnum getResult(ResultSet rs, String columnName) throws SQLException {
        logger.info("rs >>> " + rs + " columnName >>> " + columnName);
        int id = rs.getInt(columnName);
        return SexEnum.getSexById(id);
    }

    @Override
    public SexEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        int anInt = rs.getInt(columnIndex);
        return SexEnum.getSexById(anInt);
    }

    @Override
    public SexEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int anInt = cs.getInt(columnIndex);
        return SexEnum.getSexById(anInt);
    }
}
