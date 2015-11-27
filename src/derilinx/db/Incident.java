package derilinx.db;

public class Incident {
	private int id;
	private String district;
	private String date;
	private String postcode;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDistrict() {
		return district;
	}
}
