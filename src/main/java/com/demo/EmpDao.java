package com.demo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
public class EmpDao {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "PRashIK@9an|)U");
		
		return con;
	}
	
	
	//Save
	public static int save(Employee e) {
		int status =0;
		
		try {
			Connection con = EmpDao.getConnection();
			String q="insert into emp1(firstname, lastname, email, password, address, address2, city, state) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1,e.getFirstname());
			ps.setString(2, e.getLastname());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPassword());
			ps.setString(5, e.getAddress());
			ps.setString(6, e.getAddress2());
			ps.setString(7, e.getCity());
			ps.setString(8, e.getState());
			status = ps.executeUpdate();
		}
		catch(SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		return status;
		
	}
	
		
	public  static List<Employee> getAllEmployee(){
		
		ArrayList<Employee> list = new ArrayList<>();
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from emp1");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee e = new Employee();
				
				e.setId(rs.getInt(1));
				e.setFirstname(rs.getString(2));
				e.setLastname(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setPassword(rs.getString(5));
				e.setAddress(rs.getString(6));
				e.setAddress2(rs.getString(7));
				e.setCity(rs.getString(8));
				e.setState(rs.getString(9));
				list.add(e);
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static Employee getEmployeebyID(int id) {
		
		int status = 0;
		Employee e = new Employee();
		try {
			Connection con = EmpDao.getConnection();
			String q = "select * from emp1 where id=?";
			PreparedStatement ps = con.prepareStatement(q);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				e.setId(rs.getInt(1));
				e.setFirstname(rs.getString(2));
				e.setLastname(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setPassword(rs.getString(5));
				e.setAddress(rs.getString(6));
				e.setAddress2(rs.getString(7));
				e.setCity(rs.getString(8));
				e.setState(rs.getString(9));
				
			}
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}
	
	public static int update(Employee e) {
		int status=0;
		
		
		try {
			
			Connection con = EmpDao.getConnection();
			String q = "update emp1 set firstname=?, lastname=?, email=?, password=?, address=?, address2=?, city=?, state=? where id=?";
			PreparedStatement ps =con.prepareStatement(q);
			ps.setString(1, e.getFirstname());
			ps.setString(2, e.getLastname());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPassword());
			ps.setString(5, e.getAddress());
			ps.setString(6, e.getAddress2());
			ps.setString(7, e.getCity());
			ps.setString(8, e.getState());
			ps.setInt(9, e.getId());

			status = ps.executeUpdate();
			




			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	return status;
		
	}
	
	
	public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from emp1 where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
}
