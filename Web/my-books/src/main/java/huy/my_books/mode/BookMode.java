package huy.my_books.mode;

public class BookMode {

	private int idBook;
	private String nameBook;
	private String year;
	private int idCatelogy;
	private int idActor;
	// full or not full
	private String statusBooks;
	private String infoBook;
	private String imageBook;

	public BookMode() {
		super();
	}

	public BookMode(int idBook, String nameBook, String year, int idCatelogy, int idActor, String statusBooks,
			String infoBook, String imageBook) {
		super();
		this.idBook = idBook;
		this.nameBook = nameBook;
		this.year = year;
		this.idCatelogy = idCatelogy;
		this.idActor = idActor;
		this.statusBooks = statusBooks;
		this.infoBook = infoBook;
		this.imageBook = imageBook;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getIdCatelogy() {
		return idCatelogy;
	}

	public void setIdCatelogy(int idCatelogy) {
		this.idCatelogy = idCatelogy;
	}

	public int getIdActor() {
		return idActor;
	}

	public void setIdActor(int idActor) {
		this.idActor = idActor;
	}

	public String getStatusBooks() {
		return statusBooks;
	}

	public void setStatusBooks(String statusBooks) {
		this.statusBooks = statusBooks;
	}

	public String getInfoBook() {
		return infoBook;
	}

	public void setInfoBook(String infoBook) {
		this.infoBook = infoBook;
	}

	public String getImageBook() {
		return imageBook;
	}

	public void setImageBook(String imageBook) {
		this.imageBook = imageBook;
	}

}
