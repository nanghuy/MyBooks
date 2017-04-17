package huy.my_books.mode;

public class DetailBook {

	private int idDetail;
	private int idBook;
	private int idChap;
	private String nameChap;
	private String detailChap;

	public DetailBook(int idDetail, int idBook, int idChap, String nameChap, String detailChap) {
		super();
		this.idDetail = idDetail;
		this.idBook = idBook;
		this.idChap = idChap;
		this.nameChap = nameChap;
		this.detailChap = detailChap;
	}

	public DetailBook() {
		super();
	}

	public int getIdDetail() {
		return idDetail;
	}

	public void setIdDetail(int idDetail) {
		this.idDetail = idDetail;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public int getIdChap() {
		return idChap;
	}

	public void setIdChap(int idChap) {
		this.idChap = idChap;
	}

	public String getNameChap() {
		return nameChap;
	}

	public void setNameChap(String nameChap) {
		this.nameChap = nameChap;
	}

	public String getDetailChap() {
		return detailChap;
	}

	public void setDetailChap(String detailChap) {
		this.detailChap = detailChap;
	}

}
