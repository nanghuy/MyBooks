package huy.my_books.mode;

public class CatelogyBooks {
	private int idBooks;
	private String nameCatelogy;

	public CatelogyBooks() {
	}

	public CatelogyBooks(int idBooks, String nameCatelogy) {
		super();
		this.idBooks = idBooks;
		this.nameCatelogy = nameCatelogy;
	}

	public int getIdBooks() {
		return idBooks;
	}

	public void setIdBooks(int idBooks) {
		this.idBooks = idBooks;
	}

	public String getNameCatelogy() {
		return nameCatelogy;
	}

	public void setNameCatelogy(String nameCatelogy) {
		this.nameCatelogy = nameCatelogy;
	}

}
