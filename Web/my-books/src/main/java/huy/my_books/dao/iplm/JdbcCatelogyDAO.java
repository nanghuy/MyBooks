package huy.my_books.dao.iplm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import huy.my_books.dao.CatelogyDAO;
import huy.my_books.mode.CatelogyBooks;

public class JdbcCatelogyDAO extends JdbcDaoSupport implements CatelogyDAO {

	private DataSource dataSource;

	// public void setDataSource(DataSource dataSource) {
	// this.dataSource = dataSource;
	// }

	public void insert(CatelogyBooks catelogyBooks) {
		String sql = "INSERT INTO CATELOGY " + "(idCATELOGY, nameCATELOGY) VALUES (?, ?)";

		getJdbcTemplate().update(sql, new Object[] { catelogyBooks.getIdBooks(), catelogyBooks.getNameCatelogy() });

	}

	public CatelogyBooks findCatelogyName(int cateID) {

		String sql = "SELECT * FROM CATELOGY WHERE idCatelogy = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateID);
			CatelogyBooks catelogyBooks = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				catelogyBooks = new CatelogyBooks(rs.getInt("idCatelogy"), rs.getString("nameCatelogy"));
			}
			rs.close();
			ps.close();
			return catelogyBooks;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}
	}

	public boolean deleteCatelogy(int cateID) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("rawtypes")
	public List<CatelogyBooks> selectLitsCatelogy() {

		List<CatelogyBooks> listCate = new ArrayList<CatelogyBooks>();

		String sql = "SELECT * FROM CATELOGY";

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map row : rows) {
			CatelogyBooks customer = new CatelogyBooks();
			customer.setIdBooks((Integer) (row.get("idCATELOGY")));
			customer.setNameCatelogy((String) (row.get("nameCATELOGY")));
			listCate.add(customer);
		}

		return listCate;
	}

	public boolean updateNameCatelogy() {
		// TODO Auto-generated method stub
		return false;
	}

}
