package huy.my_books.mode;

public class BookRateMode {

	private int idBookRate;
	private int starRate;
	private int idBook;
	private int numRate;

	public BookRateMode() {
		super();
	}

	public BookRateMode(int idBookRate, int starRate, int idBook, int numRate) {
		super();
		this.idBookRate = idBookRate;
		this.starRate = starRate;
		this.idBook = idBook;
		this.numRate = numRate;
	}

	public int getIdBookRate() {
		return idBookRate;
	}

	public void setIdBookRate(int idBookRate) {
		this.idBookRate = idBookRate;
	}

	public int getStarRate() {
		return starRate;
	}

	public void setStarRate(int starRate) {
		this.starRate = starRate;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public int getNumRate() {
		return numRate;
	}

	public void setNumRate(int numRate) {
		this.numRate = numRate;
	}

}
