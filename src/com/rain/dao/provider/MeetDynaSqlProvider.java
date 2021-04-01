package com.rain.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import static com.rain.util.common.Constants.MEETTINGTABLE;

import com.rain.domain.Meetting;

public class MeetDynaSqlProvider {
	
	// 动态插入
		public String insertMeet(Meetting meetting){
			
			return new SQL(){
				{
					INSERT_INTO(MEETTINGTABLE);
					if(meetting.getUser_id() != null && !meetting.getUser_id().equals("")){
						VALUES("user_id", "#{user_id}");
					}
					if(meetting.getMeetting_name() != null && !meetting.getMeetting_name().equals("")){
						VALUES("meetting_name", "#{meetting_name}");
					}
					
					if(meetting.getStart_time() != null && !meetting.getStart_time().equals("")){
						VALUES("start_time", "#{start_time}");
					}
					
					if(meetting.getEnd_time() != null && !meetting.getEnd_time().equals("")){
						VALUES("end_time", "#{end_time}");
					}
					
					if(meetting.getMeetting_address() != null && !meetting.getMeetting_address().equals("")){
						VALUES("meetting_address", "#{meetting_address}");
					}
					
					if(meetting.getCreatedate() != null && !meetting.getCreatedate().equals("")){
						VALUES("createdate", "#{createdate}");
					}
					
					if(meetting.getUsername() != null && !meetting.getUsername().equals("")){
						VALUES("username", "#{username}");
					}
				}
			}.toString();
		}	
		// 动态更新
		public String updateMeet(Meetting meetting){
			
			return new SQL(){
				{
					UPDATE(MEETTINGTABLE);
					
					if(meetting.getUser_id() != null ){
						SET("user_id=#{user_id}");
					}
					if(meetting.getMeetting_name() != null ){
						SET("meetting_name=#{meetting_name}");
					}
					
					if(meetting.getStart_time() != null ){
						SET("start_time=#{start_time}");
					}
					
					if(meetting.getEnd_time() != null){
						SET("end_time=#{end_time}");
					}
					
					if(meetting.getMeetting_address() != null){
						SET("meetting_address=#{meetting_address}");
					}
					
					if(meetting.getCreatedate() != null ){
						SET("createdate=#{createdate}");
					}
					
					if(meetting.getUsername() != null){
						SET("username=#{username}");
					}
					
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}
