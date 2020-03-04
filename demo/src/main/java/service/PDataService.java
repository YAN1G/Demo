package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import mapper.PDataDao;
import pojo.C3P0Utils;
import pojo.Data;
import pojo.Geohash;
import pojo.Match;

public class PDataService {
	 private PDataDao dataDao=new PDataDao();
	 public String insert(int id,double lon,double lat) {
		 Geohash geohash=new Geohash();
			String hash=geohash.encode(lon, lat);
			Connection con = C3P0Utils.getConnection();
			// ����������
			try {
				// ������������
				if (!con.isClosed())
					System.out.println("Succeeded connecting to the Database!");

			
				// 2.����statement���������ִ��SQL��䣡��
				String sql=dataDao.insert(id, lon, lat, hash);
				PreparedStatement statement = con.prepareStatement(sql);
				statement.executeUpdate();
			} catch (Exception e) {
				System.out.println("connection fail!");
				e.printStackTrace();
			} finally {
				try {
					if (con != null)
						con.close();
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}

		return "success";
	 }

	 public List<Data> getList1(double minX,double minY,double maxX,double maxY){
			Statement stmt = null;
			ResultSet rs = null;
			Connection con = null;
			List<Data> list1 = new ArrayList<>();
			try {
				con = C3P0Utils.getConnection();
				if (!con.isClosed())
					System.out.println("Succeeded connecting to the Database!");
			
				stmt = con.createStatement();
			    String sql=dataDao.getLi(minX, minY, maxX, maxY);
				rs = stmt.executeQuery(sql); //查询hash1和hash2之间范围的点
				while (rs.next()) { // 逐行扫描
					int id = rs.getInt("id");
					String hash = rs.getString("hash");
				    double lat=rs.getDouble("lat");
				    double lon=rs.getDouble("lon");
					Data a = new Data(id, hash, lon, lat);
					list1.add(a);
				}
			} catch (Exception e) {
				System.out.println("connection fail!");
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (con != null)
						con.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			System.out.print(list1);
			return list1;
}

	 
	 public List<Data> getList2(String hash){
			Statement stmt = null;
			ResultSet rs = null;
			Connection con = null;
			Match match=new Match();
			List<Data> list1 = new ArrayList<>();
			try {
				con = C3P0Utils.getConnection();
				if (!con.isClosed())
					System.out.println("Succeeded connecting to the Database!");
			
				stmt = con.createStatement();
			    String sql=dataDao.getAll();
				rs = stmt.executeQuery(sql); //查询hash1和hash2之间范围的点
				while (rs.next()) { // 逐行扫描
					int id = rs.getInt("id");
					String hash1 = rs.getString("hash");
				    double lat=rs.getDouble("lat");
				    double lon=rs.getDouble("lon");
					Data a = new Data(id, hash, lon, lat);
					if(match.matchString(hash1, hash)==1) {
					list1.add(a);}
				}
			} catch (Exception e) {
				System.out.println("connection fail!");
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (con != null)
						con.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			System.out.print(list1);
			return list1;
}
}
	 
