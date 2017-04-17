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

	public void insert(String catelogyBooks) {

		try {
			String sqlCheckExistCatelogy = "SELECT idCATELOGY FROM CATELOGY WHERE nameCATELOGY = ?";
			String idCatelogy = (String) getJdbcTemplate().queryForObject(sqlCheckExistCatelogy,
					new Object[] { catelogyBooks }, String.class);
			System.out.println("ID CATELOGY: " + idCatelogy);
		} catch (Exception e) {
			String sql = "INSERT INTO CATELOGY " + "(nameCATELOGY) VALUES (?)";
			getJdbcTemplate().update(sql, new Object[] { catelogyBooks });

		}

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
		try {
			String sqlDelete = "DELETE FROM CATELOGY WHERE idCATELOGY = ?";
			getJdbcTemplate().update(sqlDelete, new Object[] { cateID });
			return true;
		} catch (Exception e) {
			return false;
		}
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

	public boolean updateNameCatelogy(int idUpdate, String nameCatelory) {
		try {
			String sqlDelete = "UPDATE CATELOGY SET nameCATELOGY = ? WHERE idCATELOGY = ?";
			getJdbcTemplate().update(sqlDelete, new Object[] { nameCatelory, idUpdate });
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
