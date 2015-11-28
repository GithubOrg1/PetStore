import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
	private String connectionString;
	private String user;
	private String password;
	Connection mycon = null;
	
	//连接数据库
	public void getConnection(String connectionString,String user,String password)
	{
		this.connectionString = connectionString;
		this.user = user;
		this.password = password;
		
		try {
        	Class.forName("com.mysql.jdbc.Driver");
            mycon = DriverManager.getConnection(connectionString,user,password);
            } catch (Exception e) {
    				e.printStackTrace();
    		}
	}
	/*
	//向数据库中cart表插入数据
	public void insertIntoCart(String sql,int[] data) throws SQLException
	{
		try{
			PreparedStatement st = mycon.prepareStatement(sql);
		    st.setInt(1, data[0]);
		    st.setInt(2, data[1]);
		    st.executeUpdate();
		}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	//向数据库中order表插入数据
		public void insertIntoOrder(String sql,Object[] data) throws SQLException
		{
			try{
				PreparedStatement st = mycon.prepareStatement(sql);
				for(int i=0;i<data.length;i++){
			        st.setInt(1, (int) data[0]);
			        st.setString(2, (String) data[1]);
			        st.setFloat(3, (float) data[2]);
			        st.setInt(4, (int) data[3]);
				}
			     st.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		*/
		//向数据库中插入数据
		public void insert(String sql,Object[] data) throws SQLException
		{
			try{
				PreparedStatement st = mycon.prepareStatement(sql);
				for(int i=0;i<data.length;i++){
			        st.setObject(i+1, data[i]);
				}
			     st.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	//根据id搜索数据
	public Object search(int id,int column,String table) throws SQLException
	{
		Statement st=null;
	    ResultSet rs=null;
	    Object result = null;
	    try{
		    st=mycon.createStatement();
		    String sql="select * from "+table;
	        rs=st.executeQuery(sql);
	
		    while(rs.next())
	        {
		    	if(rs.getString("id")==Integer.toString(id)){
		    		result = rs.getObject(column);
		    	}
	        }
	    }catch (Exception e) {
			e.printStackTrace();
		}
	    return result;
	}
	/*
	//根据id搜索int类型的信息
		public int searchForNumber(int id,int column,String table) throws SQLException
		{
			Statement st=null;
		    ResultSet rs=null;
		    int result = 0;
		    try{
			    st=mycon.createStatement();
			    String sql="select * from "+table;
		        rs=st.executeQuery(sql);
		
			    while(rs.next())
		        {
			    	if(rs.getString("id")==Integer.toString(id)){
			    		result = rs.getInt(column);
			    	}
		        }
		    }catch (Exception e) {
				e.printStackTrace();
			}
		    return result;
		}
		
		//根据id搜索int类型的信息
		public float searchForPrice(int id,int column,String table) throws SQLException
		{
			Statement st=null;
		    ResultSet rs=null;
		    float result = 0;
		    try{
			    st=mycon.createStatement();
			    String sql="select * from "+table;
		        rs=st.executeQuery(sql);
		
			    while(rs.next())
		        {
			    	if(rs.getString("id")==Integer.toString(id)){
			    		result = rs.getFloat(column);
			    	}
		        }
		    }catch (Exception e) {
				e.printStackTrace();
			}
		    return result;
		}
		*/
		//根据id删除数据库数据		
		public void delete(String tableName,String id)  
		{  
			String sql = "delete from"+tableName+" where id="+id;  
			Statement st = null; 
			try{  
				st=mycon.createStatement();
				st.executeUpdate(sql);
			}catch (SQLException e){  
				e.printStackTrace();  
			}   
		}  


		//更新数据库数据
		public void update(int column,int currentNumber,String sql){
			PreparedStatement st = null;
		    try{
			    st=mycon.prepareStatement(sql);
			    st.setInt(column, currentNumber);
		        }catch (SQLException e){  
					e.printStackTrace();  
				}   
		}
		
}
