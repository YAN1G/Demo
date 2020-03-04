package pojo;

public class Match {
	public int matchString(String parent,String child) {
		int i=0;
		char a[]=parent.toCharArray();
		char b[]=child.toCharArray();
		for(i=0;i<b.length;i++) {
			if(a[i]!=b[i]) {
				return 0;
			}
		}
		
	return 1;
		
	}
}
