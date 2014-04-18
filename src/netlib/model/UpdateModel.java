package netlib.model;

public class UpdateModel extends BaseModel {

	private static final long serialVersionUID = -2091551348343415124L;
	private boolean haveUpdate;
	private String describe;
	private String url;

	private int type;

	public boolean isHaveUpdate() {
		return haveUpdate;
	}

	public void setHaveUpdate(boolean haveUpdate) {
		this.haveUpdate = haveUpdate;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}