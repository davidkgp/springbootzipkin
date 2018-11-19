package com.test.tracing.discipline.repo;

import com.test.dto.Discipline;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DisciplineRepo {

    private Map<String, Discipline> disciplineMap;

    public DisciplineRepo(){
        disciplineMap = new HashMap<String,Discipline>(){{
            put("15",new Discipline("V", Arrays.asList("Science","Arts")));
            put("16",new Discipline("VI", Arrays.asList("Geography","Arts")));
            put("17",new Discipline("X", Arrays.asList("Science","Humanities")));
        }};

    }

    public Discipline getDiscipline(String id) {
        return disciplineMap.get(id);
    }
}
