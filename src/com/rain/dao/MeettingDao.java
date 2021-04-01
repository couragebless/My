package com.rain.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.rain.dao.provider.MeetDynaSqlProvider;
import com.rain.domain.Meetting;
import static com.rain.util.common.Constants.MEETTINGTABLE;
public interface MeettingDao {

	//查询
		@Select("select * from "+MEETTINGTABLE+" ")
		List<Meetting> selectAllMeetting();
		@Select("select * from "+MEETTINGTABLE+" where meetting_name like CONCAT('%',#{content},'%')")
		List<Meetting> selectLikeAllMeetting(String content);
		
		
		@SelectProvider(type=MeetDynaSqlProvider.class,method="insertMeet")
		void insert_meet(Meetting meetting);
		
		@Select("select * from "+MEETTINGTABLE+" where id = #{id}")
		Meetting get_Info(Integer id);

		@SelectProvider(type=MeetDynaSqlProvider.class,method="updateMeet")
		void update_Info(Meetting meetting);
		// 根据id删除会议
		@Delete(" delete from "+MEETTINGTABLE+" where id = #{id} ")
		void delete_Info(Integer id);

}
