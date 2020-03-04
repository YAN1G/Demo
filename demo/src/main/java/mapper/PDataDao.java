package mapper;
public class PDataDao {
	  public String insert(int id, double lat,double lon,String hash) {
				String sql = "insert into geo(id,lon,lat,hash) values('" + id + "','" + lon + "','" + lat + "','" + hash + "') ";	
			return sql;
	  }
	  public String getLi(double minX,double minY,double maxX,double maxY) {
		  String sql="select id,lon,lat from geo where (lat>='" + minX + "' and lat<='" + maxX + "') and (lon>='" + minY + "' and lon<='" + maxY + "')";
			return sql;
		}
	  public String getAll() {
		  String sql="select * from geo";
			return sql;
		}
	  
}
