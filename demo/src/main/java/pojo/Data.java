package pojo;

public class Data {

	private int id=0;

	private String hash;
	private double lon;
	private double lat;

	public Data(  int id, String hash) {

		this.id=id;

		this.hash = hash;
	}
	public Data( int id,  String hash,double lon,double lat) {
	
		this.id=id;

		this.hash = hash;
		this.lon=lon;
		this.lat=lat;

	}
	public Data() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

}
