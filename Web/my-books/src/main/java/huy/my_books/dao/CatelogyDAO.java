package huy.my_books.dao;


import java.util.List;

import huy.my_books.mode.CatelogyBooks;

public interface CatelogyDAO {
	
	public void insert(CatelogyBooks catelogyBooks);
	public CatelogyBooks findCatelogyName(int cateID);
	public boolean deleteCatelogy(int cateID);
	public List<CatelogyBooks> selectLitsCatelogy();
	public boolean updateNameCatelogy();
	
}
