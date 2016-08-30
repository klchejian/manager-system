package com.server.mappers;

import java.util.ArrayList;
import java.util.HashMap;

public interface GradeMapper {
	
	public ArrayList<HashMap<String, String>> getMyCourseGrade(HashMap<String, String> map);
	
}
