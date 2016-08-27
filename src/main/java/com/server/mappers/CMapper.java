package com.server.mappers;

import java.util.ArrayList;
import java.util.HashMap;

public interface CMapper {
	
	public ArrayList<String> getSelectedCourse(HashMap<String, String> map);

	public int chooseCourse(HashMap<String, String> map);
	
	public int delete(HashMap<String, String> map);
	
}
