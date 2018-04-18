package com.kte.sts4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kte.sts4.vo.V2_Item;

public interface V2_ItemDAO {
	@Select("SELECT NO, NAME, PRICE, QTY, TO_CHAR(DATE1, 'YYYY-MM-DD') DATE1 FROM V2_ITEM ORDER BY no DESC")
	public List<V2_Item> selectItemList();
	
	@Delete(
			"<script>"
				+ " DELETE FROM V2_ITEM WHERE NO IN ("
					+ " <foreach collection='list' item='str' separator=','"
						+ " #{str}"
					+ " </foreach>"
				+ " )"
		+ " </script>"
			)
	public int deleteBatch(List<String> list);
	
	@Select("SELECT NVL(MAX(no), 1000000) no FROM V2_Item")
	public int lastNo();
	
	@Select({
		"<script>",
		"INSERT ALL ",
		"<foreach collection='list' item='a'  separator=' '>",
		" INTO V2_ITEM VALUES(#{a.no}, #{a.name}, #{a.price}, #{a.qty}, SYSDATE) ",
		"</foreach> ",
		"SELECT * FROM DUAL",
		"</script>"})
		public void insertBatch(@Param("list") List<V2_Item> list);
	
	@Update(
			" <script>"
				+ " UPDATE V2_ITEM SET"
					+ " NAME = (CASE"
						+ " <foreach collection='list' item='vo'  separator=' '>"
							+ " WHEN NO=#{vo.no} THEN #{vo.name}"
						+ " </foreach>"
					+ " END),"
					+ " PRICE = (CASE"
						+ " <foreach collection='list' item='vo'  separator=' '>"
							+ " WHEN NO=#{vo.no} THEN #{vo.price}"
						+ " </foreach>"
					+ " END),"
					+ " QTY = (CASE"
						+ " <foreach collection='list' item='vo'  separator=' '>"
							+ " WHEN NO=#{vo.no} THEN #{vo.qty}"
						+ " </foreach>"
					+ " END)"
				+ " WHERE NO IN ("
					+" <foreach collection='list' item='vo' separator=','>"
						+ " #{vo.no}"
					+ " </foreach>"
				+ " )"
			+ " </script>")
	public int updateBatch(@Param("list") List<V2_Item> list);
}
