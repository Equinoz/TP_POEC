package bll;

import java.util.List;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bo.Sceance;
import dao.SceanceDAOJDBCImpl;

public class SceanceManager {
	public static List<Sceance> allSceance() {

		return SceanceDAOJDBCImpl.selectAll();

	}

	public static List<Sceance> allSF() {
		return SceanceDAOJDBCImpl.selectAllWithSF();

	}

	public static String allSFJSON() throws JsonProcessingException {
		String result ="{\"Search\":[";
		List<Sceance> lst = allSF();
		for (int i = 0; i < lst.size(); i++) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setTimeZone(TimeZone.getDefault());
			mapper.setSerializationInclusion(Include.NON_NULL);			
			result += mapper.writeValueAsString(lst.get(i));
			if (i < lst.size() - 1) {
				result += ",";
			}else {
				result+="]}";
			}
		}
		return result;
	}
}
