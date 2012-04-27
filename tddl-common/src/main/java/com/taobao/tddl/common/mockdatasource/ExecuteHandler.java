/*(C) 2007-2012 Alibaba Group Holding Limited.	

import java.sql.ResultSet;

public interface ExecuteHandler {
	public ResultSet execute(String method, String sql);
	public boolean executeSql(String method, String sql);
}