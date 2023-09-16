import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.type.StandardBasicTypes;

import java.sql.Types;

public class hibernate_class_3 {

    public static class SQLiteDialect extends Dialect {
        public SQLiteDialect() {
            super();
            registerColumnType(Types.BIT, "integer");
            registerColumnType(Types.TINYINT, "tinyint");
            registerColumnType(Types.SMALLINT, "smallint");
            registerColumnType(Types.INTEGER, "integer");
            registerColumnType(Types.BIGINT, "bigint");
            registerColumnType(Types.FLOAT, "float");
            registerColumnType(Types.REAL, "real");
            registerColumnType(Types.DOUBLE, "double");
            registerColumnType(Types.NUMERIC, "numeric");
            registerColumnType(Types.DECIMAL, "decimal");
            registerColumnType(Types.CHAR, "char");
            registerColumnType(Types.VARCHAR, "varchar");
            registerColumnType(Types.LONGVARCHAR, "longvarchar");
            registerColumnType(Types.DATE, "date");
            registerColumnType(Types.TIME, "time");
            registerColumnType(Types.TIMESTAMP, "timestamp");
            registerColumnType(Types.BINARY, "blob");
            registerColumnType(Types.VARBINARY, "blob");
            registerColumnType(Types.LONGVARBINARY, "blob");
            registerColumnType(Types.BLOB, "blob");
            registerColumnType(Types.CLOB, "clob");
            registerColumnType(Types.BOOLEAN, "integer");

            registerFunction("concat", new VarArgsSQLFunction(StandardBasicTypes.STRING, StandardBasicTypes.STRING,
                    ""));
            registerFunction("mod", new SQLFunctionTemplate(StandardBasicTypes.INTEGER,
                    "?1 % ?2"));
            registerFunction("substr", new StandardSQLFunction("substr",
                    StandardBasicTypes.STRING));
            registerFunction("substring", new StandardSQLFunction("substr",
                    StandardBasicTypes.STRING));
        }
    }
}