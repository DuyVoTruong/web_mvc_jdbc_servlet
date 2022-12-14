package trinhtruong2k1.io.seller.Dao;

import java.util.List;

import trinhtruong2k1.io.seller.mapper.RowMapper;

public interface GenericDao<T> {
	 @SuppressWarnings("hiding")
	 <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	 void update (String sql, Object... parameters);
	 Long insert (String sql, Object... parameters);
	 int count(String sql, Object... parameters);
}
